package com.dexfun.yiku.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.dexfun.yiku.R;
import com.dexfun.yiku.UserClass;
import com.dexfun.yiku.activity.LoginActivity;
import com.dexfun.yiku.activity.NextKnapsackActivity;
import com.dexfun.yiku.activity.getAddCardActivity;
import com.dexfun.yiku.base.BaseFragment;
import com.dexfun.yiku.entity.DefaultEntity;
import com.dexfun.yiku.entity.DeleteKnapsackDOTO;
import com.dexfun.yiku.entity.KnapsacEntry;
import com.dexfun.yiku.entity.MainDexEvent;
import com.dexfun.yiku.entity.OnDexEvent;
import com.dexfun.yiku.entity.QueryAddClothingVoucher;
import com.dexfun.yiku.fragment.knapsack.ItemKnapsackAdapter;
import com.dexfun.yiku.service.impl.HttpServiceImpl;
import com.dexfun.yiku.widget.CustomListView;
import com.kennyc.view.MultiStateView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class KnapsackFragment extends BaseFragment {

    @BindView(R.id.knapsack_lv)
    CustomListView knapsackLv;
    @BindView(R.id.knapsack_btn)
    Button knapsackBtn;
    @BindView(R.id.button_view)
    View button_view;
    @BindView(R.id.btn_delete)
    Button btn_delete;
    @BindView(R.id.vi_gr)
    View vi_gr;
    @BindView(R.id.btn_select_all)
    View btn_select_all;
    @BindView(R.id.include_right_btn)
    TextView include_right_btn;
    @BindView(R.id.load_view)
    MultiStateView loadView;
    ItemKnapsackAdapter itemKnapsackAdapter;

    @BindView(R.id.user_buy_card)
    Button userBuyCard;
    @BindView(R.id.user_card)
    CheckBox userCard;
    private int cardId = -1;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_knapsack;
    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {

        setTitle(view, "衣袋");
        include_right_btn.setText("管理");
        try {
            EventBus.getDefault().register(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        itemKnapsackAdapter = new ItemKnapsackAdapter(getContext(), new ArrayList<>());
        knapsackLv.setAdapter(itemKnapsackAdapter);
        userBuyCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), getAddCardActivity.class));
            }
        });
        userCard.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    new HttpServiceImpl().usedAddClothingVoucher(cardId, new HttpServiceImpl.OnObjectDataListener<DefaultEntity>() {
                        @Override
                        public void onData(DefaultEntity data) {
                            if (data.getStatus() == 200) {
                                itemKnapsackAdapter.setMaxNumber(4);
                            }
                        }
                    });
                } else {
                    new HttpServiceImpl().cancelUsedAddClothingVoucher(cardId, new HttpServiceImpl.OnObjectDataListener<DefaultEntity>() {
                        @Override
                        public void onData(DefaultEntity data) {
                            if (data.getStatus() == 200) {
                                itemKnapsackAdapter.setMaxNumber(3);
                            }
                        }
                    });
                }
            }
        });
    }

    @Override
    public void getData(View view, Bundle savedInstanceState) {
        loadView.setViewState(MultiStateView.VIEW_STATE_LOADING);

        loadView.setStateListener(i -> {
            if (MultiStateView.VIEW_STATE_EMPTY == i) {
                View empty = loadView.getView(MultiStateView.VIEW_STATE_EMPTY);
                if (null != empty)
                    empty.findViewById(R.id.rebtn).setOnClickListener(
                            btn -> EventBus.getDefault().post(new MainDexEvent(1)));
            }
            if (MultiStateView.VIEW_STATE_ERROR == i) {
                View empty = loadView.getView(MultiStateView.VIEW_STATE_ERROR);
                if (null != empty)
                    empty.findViewById(R.id.rebtn).setOnClickListener(
                            btn -> startActivity(new Intent(getContext(), LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)));
            }
        });

        if (!UserClass.getInstance().isLogin2(getContext())) {
            loadView.setViewState(MultiStateView.VIEW_STATE_ERROR);
            return;
        }
        new HttpServiceImpl().getShoppingCart(
                data -> {
                    if (data.getStatus() == 200) {
                        loadView.setViewState(MultiStateView.VIEW_STATE_CONTENT);
                        itemKnapsackAdapter = new ItemKnapsackAdapter(getContext(), data.getData());
                        knapsackLv.setAdapter(itemKnapsackAdapter);
                    } else if (data.getStatus() == 411) {
                        loadView.setViewState(MultiStateView.VIEW_STATE_EMPTY);
                        if (getArguments() != null && getArguments().getInt("t", 0) == 1)
                            loadView.getView(MultiStateView.VIEW_STATE_EMPTY).findViewById(R.id.rebtn).setVisibility(View.INVISIBLE);

                    }
                });

        new HttpServiceImpl().queryAddClothingVoucher(new HttpServiceImpl.OnObjectDataListener<QueryAddClothingVoucher>() {
            @Override
            public void onData(QueryAddClothingVoucher data) {
                if (data.getStatus() == 200 && data.getData() != null) {
                    if (!data.getData().isEmpty()) {
                        userBuyCard.setVisibility(View.GONE);
                        userCard.setVisibility(View.VISIBLE);
                        for (QueryAddClothingVoucher.DataEntity dataEntity : data.getData()) {
                            if (dataEntity.getStatusX().equals("已使用")) {
                                cardId = dataEntity.getAddClothingId();
                                if (itemKnapsackAdapter != null)
                                    itemKnapsackAdapter.setMaxNumber(4);
                                break;
                            } else {
                                cardId = dataEntity.getAddClothingId();
                            }
                        }
                    } else {
                        userBuyCard.setVisibility(View.VISIBLE);
                        userCard.setVisibility(View.GONE);
                    }
                }
            }
        });
    }


    @OnClick(R.id.knapsack_btn)
    public void onViewClicked() {
        ItemKnapsackAdapter adapter = (ItemKnapsackAdapter) knapsackLv.getAdapter();
        if (null == adapter) return;
        ArrayList<KnapsacEntry.DataEntity> indexClothing = adapter.getIndexClothing();
        if (null != indexClothing && indexClothing.size() == 0) {
            Toast.makeText(getContext(), "请选择商品", Toast.LENGTH_SHORT).show();
            return;
        }
        System.out.println(indexClothing);
        Intent intent = new Intent(getContext(), NextKnapsackActivity.class);
        intent.putExtra("list", indexClothing);
        startActivity(intent);
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        System.out.println("hidden = [" + hidden + "]");
        if (!hidden)
            if (!UserClass.getInstance().isLogin2(getContext())) {
                loadView.setViewState(MultiStateView.VIEW_STATE_ERROR);
                return;
            }
        new HttpServiceImpl().getShoppingCart(
                data -> {
                    if (data.getStatus() == 200) {
                        loadView.setViewState(MultiStateView.VIEW_STATE_CONTENT);
                        itemKnapsackAdapter.setObjects(data.getData());
                    } else if (data.getStatus() == 411) {
                        loadView.setViewState(MultiStateView.VIEW_STATE_EMPTY);
                    }
                });
        new HttpServiceImpl().queryAddClothingVoucher(new HttpServiceImpl.OnObjectDataListener<QueryAddClothingVoucher>() {
            @Override
            public void onData(QueryAddClothingVoucher data) {
                if (data.getStatus() == 200 && data.getData() != null) {
                    if (!data.getData().isEmpty()) {
                        userBuyCard.setVisibility(View.GONE);
                        userCard.setVisibility(View.VISIBLE);
                        for (QueryAddClothingVoucher.DataEntity dataEntity : data.getData()) {
                            if (dataEntity.getStatusX().equals("已使用")) {
                                cardId = dataEntity.getAddClothingId();
                                break;
                            } else {
                                cardId = dataEntity.getAddClothingId();
                            }
                        }
                    } else {
                        userBuyCard.setVisibility(View.VISIBLE);
                        userCard.setVisibility(View.GONE);
                    }
                }
            }
        });
        super.onHiddenChanged(hidden);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        System.out.println("isVisibleToUser = [" + isVisibleToUser + "]");
        if (isVisibleToUser) {
            if (!UserClass.getInstance().isLogin2(getContext())) {
                loadView.setViewState(MultiStateView.VIEW_STATE_ERROR);
                return;
            }
            new HttpServiceImpl().getShoppingCart(
                    data -> {
                        if (data.getStatus() == 200) {
                            loadView.setViewState(MultiStateView.VIEW_STATE_CONTENT);
                            itemKnapsackAdapter.setObjects(data.getData());
                        } else if (data.getStatus() == 411) {
                            loadView.setViewState(MultiStateView.VIEW_STATE_EMPTY);
                        }

                    });
            new HttpServiceImpl().queryAddClothingVoucher(new HttpServiceImpl.OnObjectDataListener<QueryAddClothingVoucher>() {
                @Override
                public void onData(QueryAddClothingVoucher data) {
                    if (data.getStatus() == 200 && data.getData() != null) {
                        if (!data.getData().isEmpty()) {
                            userBuyCard.setVisibility(View.GONE);
                            userCard.setVisibility(View.VISIBLE);
                            for (QueryAddClothingVoucher.DataEntity dataEntity : data.getData()) {
                                if (dataEntity.getStatusX().equals("已使用")) {
                                    cardId = dataEntity.getAddClothingId();
                                    break;
                                } else {
                                    cardId = dataEntity.getAddClothingId();
                                }
                            }
                        } else {
                            userBuyCard.setVisibility(View.VISIBLE);
                            userCard.setVisibility(View.GONE);
                        }
                    }
                }
            });
        }

        super.setUserVisibleHint(isVisibleToUser);
    }

    @Subscribe
    public void onEventMainThread(OnDexEvent event) {
        getData(null, null);
    }

    @Override
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    @OnClick(R.id.include_right_btn)
    void onRight() {
        if (vi_gr.getVisibility() == View.GONE) {
            vi_gr.setVisibility(View.VISIBLE);
            button_view.setVisibility(View.GONE);
        } else {
            itemKnapsackAdapter.setIndexClothing();
            vi_gr.setVisibility(View.GONE);
            button_view.setVisibility(View.VISIBLE);
        }
    }

    @OnClick(R.id.btn_select_all)
    void btn_select_all() {
        itemKnapsackAdapter.setAllIndexClothing();
    }

    @OnClick(R.id.btn_delete)
    void btn_delete() {
        List<Integer> list = new ArrayList<>();
        ItemKnapsackAdapter adapter = (ItemKnapsackAdapter) knapsackLv.getAdapter();
        if (adapter != null) {
            for (KnapsacEntry.DataEntity dataBean : adapter.getIndexClothing()) {
                int shoppingCartId = dataBean.getShoppingCartId();
                list.add(shoppingCartId);
            }
            DeleteKnapsackDOTO deleteKnapsackDOTO = new DeleteKnapsackDOTO();
            deleteKnapsackDOTO.setCartIdList(list);
            new HttpServiceImpl().deleteKnapsack(deleteKnapsackDOTO, new HttpServiceImpl.OnObjectDataListener<DefaultEntity>() {
                @Override
                public void onData(DefaultEntity data) {
                    getData(null, null);
                }
            });
        }

    }
//    private void get() {
//        ItemKnapsackAdapter adapter = (ItemKnapsackAdapter) knapsackLv.getAdapter();
//        if (adapter != null) {
//            ArrayList<KnapsacEntry.DataBean> indexClothing = adapter.getIndexClothing();
//            if (indexClothing != null) {
//                if (indexClothing.size() != 0) {
//
//                } else {
//                    knapsackBtn.setBackgroundColor(getResources().getColor(R.color.colorLine));
//                }
//            } else {
//                knapsackBtn.setBackgroundColor(getResources().getColor(R.color.colorLine));
//            }
//        } else {
//            knapsackBtn.setBackgroundColor(getResources().getColor(R.color.colorLine));
//        }
//    }
}
