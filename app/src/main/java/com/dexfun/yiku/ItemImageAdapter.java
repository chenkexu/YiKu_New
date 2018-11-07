package com.dexfun.yiku;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dexfun.yiku.activity.WebViewActivity;
import com.dexfun.yiku.entity.HomeEntity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ItemImageAdapter extends PagerAdapter {

    Context context;
    List<HomeEntity.DataEntity.ImgListEntity> url;

    public ItemImageAdapter(Context context, List<HomeEntity.DataEntity.ImgListEntity> url) {
        this.context = context;
        this.url = url;
    }

    @Override
    public int getCount() {
        return url.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return false;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = View.inflate(context, R.layout.item_image, null);
        ImageView viewById = view.findViewById(R.id.image);
        Picasso.get().load(url.get(position).getHomeImgUrl()).into(viewById);
        viewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, WebViewActivity.class);
                intent.putExtra("url", url.get(position).getHomeLinkUrl());
                context.startActivity(intent);
            }
        });
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

}
