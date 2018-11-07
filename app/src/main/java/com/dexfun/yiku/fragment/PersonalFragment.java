package com.dexfun.yiku.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dexfun.yiku.Constant;
import com.dexfun.yiku.R;
import com.dexfun.yiku.UserClass;
import com.dexfun.yiku.activity.BuyCardActivity;
import com.dexfun.yiku.activity.CenterDialog;
import com.dexfun.yiku.activity.CollectionActivity;
import com.dexfun.yiku.activity.CouponsListActivity;
import com.dexfun.yiku.activity.FAQActivity;
import com.dexfun.yiku.activity.InviteActivity;
import com.dexfun.yiku.activity.LoginActivity;
import com.dexfun.yiku.activity.PocketActivity;
import com.dexfun.yiku.activity.ReceiverAddressActivity;
import com.dexfun.yiku.activity.SettingActivity;
import com.dexfun.yiku.activity.UserInfoActivity;
import com.dexfun.yiku.activity.WalletActivity;
import com.dexfun.yiku.base.BaseFragment;
import com.dexfun.yiku.entity.GetUserInfoEntity;
import com.dexfun.yiku.entity.HomeMenuEntity;
import com.dexfun.yiku.entity.OnDexEvent;
import com.dexfun.yiku.service.impl.HttpServiceImpl;
import com.dexfun.yiku.utils.SharedPreferencesUtil;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;

public class PersonalFragment extends BaseFragment {

    @BindView(R.id.circleImageView)
    CircleImageView circleImageView;
    @BindView(R.id.tv_username)
    TextView tvUsername;
    @BindView(R.id.tv_day)
    TextView tv_day;
    @BindView(R.id.card_type)
    TextView card_type;
    @BindView(R.id.btn_buy)
    Button btn_buy;
    //    @BindView(R.id.vi_expiration)
//    LinearLayout viExpiration;
    @BindView(R.id.vi_not)
    LinearLayout viNot;
    @BindView(R.id.tv_status_user)
    TextView tv_status_user;
    @BindView(R.id.bg_vip)
    ImageView bgVip;
    //    @BindView(R.id.grid_view)
//    GridView gridView;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_personal;
    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {
        List<HomeMenuEntity> menuEntities = new ArrayList<>();
//        menuEntities.add(new HomeMenuEntity("我的钱包", R.mipmap.qianbao));
//        menuEntities.add(new HomeMenuEntity("个人资料", R.mipmap.ziliao));
//        menuEntities.add(new HomeMenuEntity("邀请有奖", R.mipmap.yaoqing));
//        menuEntities.add(new HomeMenuEntity("常见问题", R.mipmap.wenti));
//        menuEntities.add(new HomeMenuEntity("联系客服", R.mipmap.kefu));
//        menuEntities.add(new HomeMenuEntity("设置", R.mipmap.shezhi));
//        gridView.setAdapter(new ItemMenuAdapter(getContext(), menuEntities));
//        gridView.setOnItemClickListener((parent, view1, position, id) -> {
//            switch (position) {
//                case 0:
//                    if (UserClass.getInstance().isLogin(getContext())) {
//                        startActivity(new Intent(getContext(), WalletActivity.class));
//                    }
//                    break;
//                case 1:
//                    if (UserClass.getInstance().isLogin(getContext()))
//                        startActivity(new Intent(getContext(), UserInfoActivity.class));
//                    break;
//                case 2:
//                    if (UserClass.getInstance().isLogin(getContext()))
//                        startActivity(new Intent(getContext(), InviteActivity.class));
//                    break;
//                case 3:
//                    startActivity(new Intent(getContext(), FAQActivity.class));
//                    break;
//                case 4:
//                    if (!UserClass.getInstance().isLogin(getContext())) return;
//
//
//                    CenterDialog centerDialog = new CenterDialog(getActivity());
//                    centerDialog.setMessage("客服服务时间 10:00-19:00");
//                    centerDialog.setNoOnclickListener("拨打电话", () -> {
//                        //首先需要构造使用客服者的用户信息
//                        centerDialog.dismiss();
//                        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:010-52894251"));
//                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                        startActivity(intent);
//
//
//                    });
//                    centerDialog.setYesOnclickListener("取消", () -> {
//                        centerDialog.dismiss();
////                        CSCustomServiceInfo.Builder csBuilder = new CSCustomServiceInfo.Builder();
////                        CSCustomServiceInfo csInfo = csBuilder.nickName(tvUsername.getText().toString()).build();
//////                    RongIM.getInstance().startCustomerServiceChat(MainClass.getInstance(), "KEFU152024228589645", "客服", csInfo);
////                        RongIM.getInstance().startConversation(getActivity(), Conversation.ConversationType.CUSTOMER_SERVICE, "KEFU152024228589645", "客服");
//
//                    });
//
//                    centerDialog.show();
//                    break;
//                case 5:
//                    startActivity(new Intent(getContext(), SettingActivity.class));
//                    break;
//                default:
//            }
//        });
        try {
            EventBus.getDefault().register(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @OnClick(R.id.to_ins)
    void to_ins() {
        startActivity(new Intent(getContext(), InviteActivity.class));
    }

    ;


    @Override
    public void getData(View view, Bundle savedInstanceState) {
        new HttpServiceImpl().getUserInfo(data -> {
            if (data.getStatus() != 200) {
                if (data.getStatus() == 401) {
                    circleImageView.setImageResource(R.mipmap.my_icon);
//                    tvUsername.setText("请先登录");
//                    tv_status_user.setText("你还不是会员，请登录>");
                    tv_status_user.setText("登录");
//                    viExpiration.setVisibility(View.GONE);
                    viNot.setVisibility(View.GONE);
                }
                return;
            }
            tv_status_user.setText("查看个人信息>");
//            if (TextUtils.isEmpty(data.getData().getUserInfo().getPhone())) {
//                startActivity(new Intent(getContext(), UpdatePhoneActivity2.class));
//                return;
//            }
            viNot.setVisibility(View.VISIBLE);

            UserClass.setrToken(data.getData().getRongToken());
            UserClass.getInstance().setUserid(String.valueOf(data.getData().getUserInfo().getUserId()));
            UserClass.connect(data.getData().getRongToken());
            UserClass.setUserName(data.getData().getUserInfo().getNickname());
            GetUserInfoEntity.DataEntity.UserInfoEntity userInfo = data.getData().getUserInfo();
            GetUserInfoEntity.DataEntity.CardInfoEntity cardInfo = data.getData().getCardInfo();
            if (cardInfo.getEffective() == 0) {
                btn_buy.setText("成为包月会员");
                SharedPreferencesUtil.getInstance().put("isVIP", false);
                //没开通
                card_type.setText("你还不是会员");
            } else if (cardInfo.getEffective() == 1) {
                btn_buy.setText("续费");
                SharedPreferencesUtil.getInstance().put("isVIP", true);
//                viExpiration.setVisibility(View.VISIBLE);
                if (cardInfo.getCardType() == 1) {
                    card_type.setText("月卡会员");
                    btn_buy.setText("月卡会员>");
                    bgVip.setImageResource(R.mipmap.yueka1);
                } else if (cardInfo.getCardType() == 2) {
                    card_type.setText("季卡会员");
                    btn_buy.setText("季卡会员>");
                    bgVip.setImageResource(R.mipmap.jika1);
                } else if (cardInfo.getCardType() == 3) {
                    card_type.setText("年卡会员");
                    btn_buy.setText("年卡会员>");
                    bgVip.setImageResource(R.mipmap.nianka1);
                } else if (cardInfo.getCardType() == 6) {
                    card_type.setText("月卡会员");
                    btn_buy.setText("月卡会员>");
                    bgVip.setImageResource(R.mipmap.yueka1);
                } else {
                    card_type.setText("体验会员");
                    btn_buy.setText("成为会员>");
                    bgVip.setImageResource(R.mipmap.bg_gray);
                }
            } else if (cardInfo.getEffective() == 2) {
                card_type.setText("你还不是会员");
                btn_buy.setText("续费");
                SharedPreferencesUtil.getInstance().put("isVIP", false);
                //过期
            } else if (cardInfo.getEffective() == 3) {
                card_type.setText("暂停使用");
                //没押金
                SharedPreferencesUtil.getInstance().put("isVIP", false);
                btn_buy.setText("续费");
            }
            try {
                Picasso.get().load(userInfo.getPhoto()).into(circleImageView);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                tvUsername.setText(userInfo.getNickname());
            } catch (Exception e) {
                e.printStackTrace();
            }
            tv_day.setText(cardInfo.getValidity());
        });
    }

    @OnClick(R.id.fm_commonproblem)
    void commonProblem() {
        startActivity(new Intent(getContext(), FAQActivity.class));
    }

    @OnClick(R.id.btn_buy)//成为会员
    void btn_buy() {
        if (UserClass.getInstance().isLogin(getContext()))
            startActivity(new Intent(getContext(), BuyCardActivity.class));
    }

//    @OnClick(R.id.vi_expiration)
//    void vi_expiration() {
//        if (UserClass.getInstance().isLogin(getContext()))
//        startActivity(new Intent(getContext(), WalletActivity.class));
//    }


    @OnClick(R.id.frame_placeofreceipt)//我的地址
    void placeOfreceipt() {
        if (UserClass.getInstance().isLogin(getContext())) {
            startActivity(new Intent(getContext(), ReceiverAddressActivity.class));
        }
    }

    //
//    @OnClick(R.id.fm_personal)
//    void personal() {
//        startActivity(new Intent(getContext(), UserInfoActivity.class));
//    }
//
    @OnClick(R.id.yhq)//卡全包
    void yhq() {
        startActivity(new Intent(getContext(), CouponsListActivity.class).putExtra("fromMe", 0));
    }

    //
    @OnClick(R.id.circleImageView)//个人信息
    void circleImageView() {
        if (UserClass.getInstance().isLogin(getContext()))
            startActivity(new Intent(getContext(), UserInfoActivity.class));
    }

    @OnClick(R.id.tv_status_user)
    void tv_status_user() {
        if (UserClass.getInstance().isLogin(getContext()))
            startActivity(new Intent(getContext(), UserInfoActivity.class));
    }

    @OnClick(R.id.all)
    void all() {
        if (UserClass.getInstance().isLogin(getContext()))
            startActivity(new Intent(getContext(), CollectionActivity.class));
    }

    @OnClick(R.id.stay_get)//代签收
    void stayGet() {
        if (UserClass.getInstance().isLogin(getContext()))
            startActivity(new Intent(getContext(), PocketActivity.class).putExtra(Constant.LocalKey.INDEX, 1));
    }

    @OnClick(R.id.stay_return)
    void stayReturn() {
        if (UserClass.getInstance().isLogin(getContext()))
            startActivity(new Intent(getContext(), PocketActivity.class).putExtra(Constant.LocalKey.INDEX, 2));
    }

    @OnClick(R.id.on_return)
    void onReturn() {
        if (UserClass.getInstance().isLogin(getContext()))
            startActivity(new Intent(getContext(), WalletActivity.class));
    }

    //
    @OnClick(R.id.setting)
    void onSetting() {
        startActivity(new Intent(getContext(), SettingActivity.class));
    }
//

    @OnClick(R.id.dialing)
    void diaLing() {
        CenterDialog centerDialog = new CenterDialog(getActivity());
        centerDialog.setMessage("客服服务时间 10:00-19:00");
        centerDialog.setNoOnclickListener("拨打电话", () -> {
            //首先需要构造使用客服者的用户信息
            centerDialog.dismiss();
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:010-52894251"));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);


        });
        centerDialog.setYesOnclickListener("取消", () -> {
            centerDialog.dismiss();
        });

        centerDialog.show();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        System.out.println("hidden = [" + hidden + "]");
        if (!hidden)
            getData(null, null);
        super.onHiddenChanged(hidden);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        System.out.println("isVisibleToUser = [" + isVisibleToUser + "]");
        if (isVisibleToUser) {
            getData(null, null);
        }

        super.setUserVisibleHint(isVisibleToUser);
    }

    @Subscribe
    public void onEventMainThread(OnDexEvent event) {
        getData(null, null);
    }

}
