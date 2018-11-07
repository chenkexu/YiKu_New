package com.dexfun.yiku.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.dexfun.yiku.BuildConfig;
import com.dexfun.yiku.HomeActivity;
import com.dexfun.yiku.R;
import com.dexfun.yiku.base.BaseActivity;
import com.dexfun.yiku.entity.VersionEntity;
import com.dexfun.yiku.service.impl.HttpServiceImpl;
import com.dexfun.yiku.widget.BaseDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UPActivity extends BaseActivity {


    @BindView(R.id.text)
    TextView text;
    @BindView(R.id.btn_c)
    TextView btnC;

    @Override
    public int getLayoutId() {
        return R.layout.activity_up;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setTitle("检查更新");
    }

    @Override
    public void getData(Bundle savedInstanceState) {
        text.setText(String.format("当前版本：V%s", BuildConfig.VERSION_NAME));
    }

    @OnClick(R.id.btn_c)
    public void onViewClicked() {
        new HttpServiceImpl().checkTheLatestVersion(new HttpServiceImpl.OnObjectDataListener<VersionEntity>() {
            @Override
            public void onData(VersionEntity data) {
                int anInt = Integer.parseInt(data.getData().getServerNewVersion().replace(".", ""));
                int parseInt = Integer.parseInt(BuildConfig.VERSION_NAME.replace(".", ""));

                System.out.println(anInt);
                System.out.println(parseInt);
                if (anInt > parseInt) {
                    new BaseDialog(UPActivity.this, true)
                            .setMessage(data.getData().getUpgradeInfo())
                            .setPositiveButton("更新", (dialogInterface, i) -> {
                                dialogInterface.cancel();
                                Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse(data.getData().getUpdateUrl()));
                                startActivity(it);
                                finish();
                            })
                            .setNegativeButton("退出程序", (dialogInterface, i) -> {
                                dialogInterface.cancel();
                                finish();
                            })
                            .show();
                } else {
                    Toast.makeText(UPActivity.this, "已是最新版本", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
