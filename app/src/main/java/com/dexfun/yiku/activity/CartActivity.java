package com.dexfun.yiku.activity;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.dexfun.yiku.R;
import com.dexfun.yiku.base.BaseActivity;
import com.dexfun.yiku.entity.OnDexEvent;
import com.dexfun.yiku.fragment.KnapsackFragment;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CartActivity extends BaseActivity {

    @BindView(R.id.frame)
    FrameLayout frame;

    @Override
    public int getLayoutId() {
        return R.layout.activity_cart;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        Bundle args = new Bundle();
        args.putInt("t", 1);
        ShoppingCartActivity knapsackFragment = new ShoppingCartActivity();
        knapsackFragment.setArguments(args);
        getSupportFragmentManager().beginTransaction().add(R.id.frame, knapsackFragment).commit();
    }

    @Override
    public void getData(Bundle savedInstanceState) {

    }

    @OnClick(R.id.include_left_btn)
    void include_left_btn(){
        onBackPressed();
    }

    @Override
    protected void onRestart() {
        EventBus.getDefault().post(new OnDexEvent(0));
        super.onRestart();
    }
}
