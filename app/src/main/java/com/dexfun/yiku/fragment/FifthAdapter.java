package com.dexfun.yiku.fragment;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dexfun.yiku.R;
import com.dexfun.yiku.utils.SharedPreferencesUtil;

import java.util.List;

public class FifthAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public FifthAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

        helper.setText(R.id.content, item)
                .addOnClickListener(R.id.content);

        CheckBox content = helper.getView(R.id.content);
        TextView ok = helper.getView(R.id.ok);

        content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                content.setChecked(true);
                if (content.isChecked()) {
                    content.setTextColor(Color.parseColor("#F34520"));
                    ok.setVisibility(View.VISIBLE);
                } else {
                    content.setTextColor(Color.parseColor("#1A1A1A"));
                    ok.setVisibility(View.GONE);
                }
                SharedPreferencesUtil instance = SharedPreferencesUtil.getInstance();
                instance.put("ok","ok");
//                instance.
            }
        });


    }
}
