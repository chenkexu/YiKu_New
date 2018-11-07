package com.dexfun.yiku.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.chow.module.share.info.IShareInfo;
import com.chow.module.share.info.SimpleShareText;
import com.chow.module.share.templet.AbsWarpTemplateShare;
import com.chow.module.share.view.ShareView;
import com.dexfun.yiku.R;
import com.dexfun.yiku.base.BaseActivity;
import com.dexfun.yiku.entity.GetUserInfoEntity;
import com.dexfun.yiku.service.impl.HttpServiceImpl;

import butterknife.BindView;
import butterknife.OnClick;

public class ShareActivity extends BaseActivity {

    @BindView(R.id.btn_share)
    TextView btnShare;
    ShareView mShareView = null;
    @Override
    public int getLayoutId() {
        return R.layout.activity_share;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        new HttpServiceImpl().getUserInfo(data -> {
            System.out.println("InviteActivity.onData");
            if (data.getStatus() == 200) {
                mShareView = new ShareView(ShareActivity.this, "分享");
                mShareView.setShareInfo(ShareActivity.this, new InviteActivity.TestImpl(ShareActivity.this, data.getData().getUserInfo().getUserId()));
            }
        });
        setTitle("分享");
    }

    @Override
    public void getData(Bundle savedInstanceState) {

    }

    @OnClick(R.id.btn_share)
    public void onViewClicked() {

        mShareView.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        mShareView.setOnActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }


}
