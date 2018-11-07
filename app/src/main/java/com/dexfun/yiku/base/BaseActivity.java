package com.dexfun.yiku.base;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.dexfun.layout.DexLayoutActivity;
import com.dexfun.yiku.R;
import com.dexfun.yiku.utils.UiUtils;


import butterknife.ButterKnife;


/**
 * Created by Smile on 17/8/18.
 */

public abstract class BaseActivity extends DexLayoutActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        String simpleName = this.getClass().getSimpleName();
        boolean skip = simpleName.equals("LauncherActivity") || simpleName.equals("SelectIdentityActivity")  || simpleName.equals("PayDialogClass");
        if (skip) {
            UiUtils.setStatusBarTransparent(this);
        } else {
            UiUtils.setStatusBarLightMode(this);
        }
        setContentView(getLayoutId());
        UiUtils.setFitsSystemWindows(this, skip);
        ButterKnife.bind(this);
        initView(savedInstanceState);
        getData(savedInstanceState);
    }

    public abstract int getLayoutId();

    public abstract void initView(Bundle savedInstanceState);

    public abstract void getData(Bundle savedInstanceState);

    public void setTitle(CharSequence title) {
        TextView rightText = findViewById(R.id.include_title);
        if (rightText != null) {
            rightText.setText(title);
        }

        View back = findViewById(R.id.include_left_btn);
        if (back != null) {
            back.setOnClickListener(v -> onBackPressed());

        }
    }
    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();

    }
}
