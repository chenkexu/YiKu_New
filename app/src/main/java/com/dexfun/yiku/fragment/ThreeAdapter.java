package com.dexfun.yiku.fragment;

import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dexfun.yiku.R;

import java.util.ArrayList;
import java.util.List;

public class ThreeAdapter extends BaseQuickAdapter<Integer,BaseViewHolder> {
    public ThreeAdapter(int layoutResId, @Nullable List<Integer> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Integer item) {

        Glide.with(mContext).load(R.mipmap.text_indicator).into((ImageView) helper.getView(R.id.push_icon));

    }
}
