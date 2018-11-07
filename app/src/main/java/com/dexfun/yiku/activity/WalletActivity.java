package com.dexfun.yiku.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.dexfun.yiku.Constant;
import com.dexfun.yiku.R;
import com.dexfun.yiku.activity.adapter.ItemWalletCardAdapter;
import com.dexfun.yiku.base.BaseActivity;
import com.dexfun.yiku.entity.AccountPEntity;
import com.dexfun.yiku.entity.CouponsListEntity;
import com.dexfun.yiku.entity.DefaultEntity;
import com.dexfun.yiku.entity.GetUserInfoEntity;
import com.dexfun.yiku.service.impl.HttpServiceImpl;
import com.dexfun.yiku.widget.CustomListView;
import com.kennyc.view.MultiStateView;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by pupu on 2017/12/16.
 */

public class WalletActivity extends BaseActivity {

    @BindView(R.id.tv_status)
    TextView tvStatus;
    @BindView(R.id.btn_go)
    TextView btnGo;
    @BindView(R.id.include_right_btn)
    TextView includeRightBtn;
    @BindView(R.id.tv_mp)
    TextView tv_mp;


    @Override
    public int getLayoutId() {
        return R.layout.activity_wallet;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setTitle("资金账户");
        includeRightBtn.setText("明细");
    }

    @Override
    protected void onResume() {
        getData(null);
        super.onResume();
    }

    @Override
    public void getData(Bundle savedInstanceState) {
        new HttpServiceImpl().getUserInfo(data -> {
            if (data.getStatus() == 200) {
                GetUserInfoEntity.DataEntity.CardInfoEntity cardInfo = data.getData().getCardInfo();

                if (cardInfo.getDepositEffective() == 0 || cardInfo.getDepositEffective() == 2 || cardInfo.getDepositEffective() == 3) {
                    tvStatus.setText("未缴押金，缴纳押金享受会员权益");
                } else {
                    tvStatus.setText("已交押金，可享受平台各种会员服务");
                }

            }
        });
        new HttpServiceImpl().queryAccount(new HttpServiceImpl.OnObjectDataListener<AccountPEntity>() {
            @Override
            public void onData(AccountPEntity data) {
                if (data.getStatus() == 200) {
                    tv_mp.setText(String.format("￥%d", data.getData().getCapital()));
                }
            }
        });


    }

    @OnClick(R.id.btn_get)
    void btn_get() {
        new HttpServiceImpl().withdraw(new HttpServiceImpl.OnObjectDataListener<DefaultEntity>() {
            @Override
            public void onData(DefaultEntity data) {
                if (data.getStatus() == 410) {
                    IWXAPI wxapi = WXAPIFactory.createWXAPI(WalletActivity.this, Constant.LocalKey.APP_ID, false);
                    wxapi.registerApp(Constant.LocalKey.APP_ID);
                    SendAuth.Req req = new SendAuth.Req();
                    req.scope = "snsapi_userinfo";
                    req.state = "diandi_wx_login";
                    wxapi.sendReq(req);
                }
                Toast.makeText(WalletActivity.this, data.getMsg(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @OnClick({R.id.btn_go, R.id.btn_share, R.id.include_right_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_share:
                startActivity(new Intent(WalletActivity.this, InviteActivity.class));
                break;
            case R.id.btn_go:
                startActivity(new Intent(WalletActivity.this, DepositActivity.class));
                break;
            case R.id.include_right_btn:
                startActivity(new Intent(WalletActivity.this, BuyListActivity.class));
                break;
        }
    }
}
