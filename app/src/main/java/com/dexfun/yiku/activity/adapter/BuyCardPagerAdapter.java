package com.dexfun.yiku.activity.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;

import com.dexfun.yiku.R;
import com.dexfun.yiku.entity.BuyCardEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Smile on 18/7/24.
 */

public class BuyCardPagerAdapter extends PagerAdapter {


    private List<BuyCardEntity> datas;
    private Context context;

    public BuyCardPagerAdapter(Context context, List<BuyCardEntity> datas) {
        this.datas = datas;
        this.context = context;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View v = LayoutInflater.from(context).inflate(R.layout.adapter, null);
        ImageView viewById = v.findViewById(R.id.item_iv);


        viewById.setImageResource(datas.get(position).getRsd());

//        container.removeViewAt(position);

        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        container.removeViewAt(position);


    }
//    @Override
//    public float getPageWidth(int position) {
//        return (float) 0.33;
//    }

}
