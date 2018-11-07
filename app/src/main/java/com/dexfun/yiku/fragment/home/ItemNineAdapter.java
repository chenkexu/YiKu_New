package com.dexfun.yiku.fragment.home;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.dexfun.yiku.widget.NineGridAdapter;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Smile on 17/11/7.
 */

public class ItemNineAdapter extends NineGridAdapter {

    public ItemNineAdapter(Context context, List<String> list) {
        super(context, list);
    }

    @Override
    public int getCount() {
        return (list == null) ? 0 : list.size();
    }

    @Override
    public String getUrl(int position) {
        return getItem(position) == null ? null : (String) getItem(position);
    }

    @Override
    public Object getItem(int position) {
        return (list == null) ? null : list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view) {
        ImageView iv;
        if (view != null && view instanceof ImageView) {
            iv = (ImageView) view;
        } else {
            iv = new ImageView(context);
        }
        iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        iv.setBackgroundColor(context.getResources().getColor((android.R.color.transparent)));
        String url = getUrl(i);
        Glide.with(context).load(url).skipMemoryCache(true).fitCenter().placeholder(new ColorDrawable(Color.parseColor("#f5f5f5"))).into(iv);
        if (!TextUtils.isEmpty(url)) {
            iv.setTag(url);
        }
        return iv;
    }
}