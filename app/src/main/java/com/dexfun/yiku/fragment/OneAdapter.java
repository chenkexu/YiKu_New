package com.dexfun.yiku.fragment;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dexfun.yiku.R;

import java.util.List;



public class OneAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public OneAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.aText, item);
//        TextView aText = helper.getView(R.id.aText);
//        aText.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                aText.setTextColor(Color.parseColor("#ee2c2c"));
//            }
//        });
//                .addOnClickListener(R.id.aText);
    }
}
