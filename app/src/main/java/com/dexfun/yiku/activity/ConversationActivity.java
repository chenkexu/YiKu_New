package com.dexfun.yiku.activity;
import android.os.Bundle;
import android.view.KeyEvent;

import com.dexfun.yiku.R;
import com.dexfun.yiku.base.BaseActivity;

import io.rong.imkit.fragment.ConversationFragment;

/**
 * @author Smile
 */
public class ConversationActivity extends BaseActivity {
    @Override
    public int getLayoutId() {
        return R.layout.activity_conversation;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setTitle("客服");
    }

    @Override
    public void getData(Bundle savedInstanceState) {

    }

    @Override
    public void onBackPressed() {
        ConversationFragment fragment = (ConversationFragment) getSupportFragmentManager().findFragmentById(R.id.conversation);
        if (!fragment.onBackPressed()) {
            finish();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);
    }
}
