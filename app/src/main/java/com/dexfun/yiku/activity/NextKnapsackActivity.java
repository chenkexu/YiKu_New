package com.dexfun.yiku.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.dexfun.yiku.HomeActivity;
import com.dexfun.yiku.R;
import com.dexfun.yiku.activity.adapter.ItemNextKnapsacAdapter;
import com.dexfun.yiku.base.BaseActivity;
import com.dexfun.yiku.entity.GetUserInfoEntity;
import com.dexfun.yiku.entity.KnapsacEntry;
import com.dexfun.yiku.service.impl.HttpServiceImpl;
import com.dexfun.yiku.utils.CKENTITY;
import com.dexfun.yiku.utils.GsonUtil;
import com.dexfun.yiku.widget.BaseDialog;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Up on 2017/12/6.
 */

public class NextKnapsackActivity extends BaseActivity {

    @BindView(R.id.verify_listview)
    ListView lvVerify;
    @BindView(R.id.btn_create_order)
    Button btnCreate;
    ArrayList<KnapsacEntry.DataEntity> dataBeans;
    HashMap<String, Object> map = new HashMap<>();
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.vi_address)
    LinearLayout viAddress;
    @BindView(R.id.vi_add_address)
    LinearLayout viAddAddress;
    int addressId = -1;


    @Override
    public int getLayoutId() {
        return R.layout.activity_next_knapsack;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setTitle("确认衣袋");
        map.put("cardType", 1);
        dataBeans = (ArrayList<KnapsacEntry.DataEntity>) getIntent().getSerializableExtra("list");
        if (null != dataBeans) {
            lvVerify.setAdapter(new ItemNextKnapsacAdapter(this, dataBeans));
            lvVerify.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    ItemNextKnapsacAdapter adapter = (ItemNextKnapsacAdapter) adapterView.getAdapter();
                    Intent intent;
                    if (adapter.getItem(i).getClassify() == 1) {
                        intent = new Intent(NextKnapsackActivity.this, DetailActivity.class);
                    } else {
                        intent = new Intent(NextKnapsackActivity.this, PSDetailActivity.class);
                    }

                    intent.putExtra("id", adapter.getItem(i).getClothingId());
                    startActivity(intent);
                }
            });
        }

        new HttpServiceImpl().queryFrequencyCard(new HttpServiceImpl.OnObjectDataListener<CKENTITY>() {
            @Override
            public void onData(CKENTITY data) {
                new HttpServiceImpl().getUserInfo(new HttpServiceImpl.OnObjectDataListener<GetUserInfoEntity>() {
                    @Override
                    public void onData(GetUserInfoEntity data1) {
                        if (data1.getStatus() == 200) {
                            String effective = data1.getData().getCardInfo().getValidity();
                            int cardType = data1.getData().getCardInfo().getCardType();
                            String cardName = "";
                            //1-月 2-季 3-年 4-体验 5-助力 6-买一赠一卡
                            switch (cardType) {
                                case 1:
                                case 6:
                                    cardName = "月卡";
                                    break;
                                case 2:
                                    cardName = "季卡";
                                    break;
                                case 3:
                                    cardName = "年卡";
                                    break;
                                case 4:
                                    cardName = "体验卡";
                                    break;
                                case 5:
                                    cardName = "助力卡";
                                    break;
                            }
                            RadioButton viewById1 = findViewById(R.id.yk);
                            viewById1.setText(String.format("%s剩余%s天，本次使用%s", cardName, effective,cardName));
                        }
                    }
                });
                if (data.getStatus() == 200 && data.getData().getSurplusNumber() > 0) {
                    findViewById(R.id.vig).setVisibility(View.VISIBLE);
                    RadioGroup viewById = findViewById(R.id.rg);
                    RadioButton ck = findViewById(R.id.ck);
                    ck.setText(String.format("次卡剩余%s次，本次使用次卡",  String.valueOf(data.getData().getSurplusNumber())));
                    viewById.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup group, int checkedId) {
                            map.remove("cardType");
                            if (checkedId == R.id.ck) {
                                map.put("cardType", 2);
                            }
                            if (checkedId == R.id.yk) {
                                map.put("cardType", 1);
                            }
                        }
                    });
                }
            }
        });
    }

    @Override
    public void getData(Bundle savedInstanceState) {
        new HttpServiceImpl().getDefaultAddress(data -> {
            if (data.getStatus() == 200) {
                viAddress.setVisibility(View.VISIBLE);
                viAddAddress.setVisibility(View.GONE);

                addressId = data.getData().getAddressId();
                map.put("addressId", addressId);

                tvName.setText(String.format("收货人：%s", data.getData().getConsignee()));
                tvAddress.setText(data.getData().getRegion() + " " + data.getData().getDetailedAddress());
                tvPhone.setText(data.getData().getContactNumber());
            } else {
                viAddress.setVisibility(View.GONE);
                viAddAddress.setVisibility(View.VISIBLE);
            }

        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        getData(null);

    }

    @OnClick({R.id.vi_address, R.id.vi_add_address})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.vi_address:
                startActivity(new Intent(NextKnapsackActivity.this, ReceiverAddressActivity.class));
                break;
            case R.id.vi_add_address:
                startActivity(new Intent(NextKnapsackActivity.this, ReceiverAddressActivity.class));
                break;
        }
    }

    @OnClick(R.id.btn_create_order)
    public void onViewClicked() {
//        Calendar instance = Calendar.getInstance();
//        instance.set(2018, 2, 23);
//        long timeInMillis = instance.getTimeInMillis();
//        if (System.currentTimeMillis() < timeInMillis) {
//            AlertDialog.Builder builder = new AlertDialog.Builder(NextKnapsackActivity.this);
//            builder.setTitle("提示");
//            builder.setMessage("小仙女，快递小哥回家过年了，现在下单23号以后才可以正常发货哦");
//            builder.setPositiveButton("继续下单", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    dialog.cancel();
//                    next();
//                }
//            }).setNegativeButton("停止下单", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    dialog.cancel();
//                }
//            }).show();
//        } else {
//            next();
//        }
        next();
    }

    private void next() {
        ArrayList<Integer> ids = new ArrayList<>();
        for (KnapsacEntry.DataEntity dataBean : dataBeans) {
            ids.add(dataBean.getShoppingCartId());
        }

        map.put("shoppingCartIdList", ids);
        new HttpServiceImpl().createOrder(map, data -> {
            int status = data.getStatus();
            switch (status) {
                case 200:
                    startActivity(new Intent(NextKnapsackActivity.this, OrderSuccessfulActivity.class).putExtra("key", GsonUtil.create().toJson(data)));
                    onBackPressed();
                    break;
                case 422:
                    Toast.makeText(this, "商品数量异常", Toast.LENGTH_SHORT).show();
                    break;
                case 423:
                    Toast.makeText(this, "创建订单失败", Toast.LENGTH_SHORT).show();
                    break;
                case 426:
                    Toast.makeText(this, "非会员", Toast.LENGTH_SHORT).show();
                    break;
                case 427:
                    Toast.makeText(this, "会员过期", Toast.LENGTH_SHORT).show();
                    break;
                case 428:
                    Toast.makeText(this, "购物车没有该商品", Toast.LENGTH_SHORT).show();
                    break;
                case 429:
                    Toast.makeText(this, "无效的地址", Toast.LENGTH_SHORT).show();
                    break;
                case 437:
                    Toast.makeText(this, "会员卡过期", Toast.LENGTH_SHORT).show();
                    break;
                case 438:
                    Toast.makeText(this, "没有开通会员", Toast.LENGTH_SHORT).show();
                    break;
                case 442:
                    Toast.makeText(this, "存在未完成订单", Toast.LENGTH_SHORT).show();
                    break;
                case 444:
                    Toast.makeText(this, "存在未签收订单 请在签收后再下单", Toast.LENGTH_SHORT).show();
                    break;
                case 439:
                    new BaseDialog(NextKnapsackActivity.this, true)
                            .setMessage("缴纳押金后才可下单")
                            .setPositiveButton("去缴纳", (dialogInterface, i) -> {
                                dialogInterface.cancel();
                                startActivity(new Intent(NextKnapsackActivity.this, WalletActivity.class));
                            })
                            .setNegativeButton("取消", (dialogInterface, i) -> {
                                dialogInterface.cancel();

                            })
                            .show();
                    break;
                default:
                    Toast.makeText(this, data.getMsg(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}
