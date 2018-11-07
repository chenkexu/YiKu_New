package com.dexfun.yiku.fragment.home;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.dexfun.yiku.R;
import com.dexfun.yiku.activity.WebViewActivity;
import com.dexfun.yiku.entity.HomeEntity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Smile
 */
public class RecyclerLayoutAdapter extends RecyclerView.Adapter<RecyclerLayoutAdapter.SimpleViewHolder> {


    private final Context mContext;
    private final RecyclerView mRecyclerView;
    private List<HomeEntity.DataEntity.HotWearsEntity> mItems;


    public static class SimpleViewHolder extends RecyclerView.ViewHolder {
        public final ImageView image;

        public SimpleViewHolder(View view) {
            super(view);
            image = view.findViewById(R.id.image);
        }
    }

    public RecyclerLayoutAdapter(Context context, RecyclerView recyclerView, List<HomeEntity.DataEntity.HotWearsEntity> hotWears) {
        this(context, recyclerView, hotWears.size());
        this.mItems = hotWears;
    }

    public RecyclerLayoutAdapter(Context context, RecyclerView recyclerView, int itemCount) {
        mContext = context;
        mRecyclerView = recyclerView;
    }

    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(mContext).inflate(R.layout.item, parent, false);
        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SimpleViewHolder holder, int position) {
        Picasso.get().load(mItems.get(position% mItems.size()).getHotWearImg()).into(holder.image);
        final View itemView = holder.itemView;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(mItems.get(position% mItems.size()).getHotWearUrl())) {
                    return;
                }
                mContext.startActivity(new Intent(mContext, WebViewActivity.class).putExtra("url", mItems.get(position% mItems.size()).getHotWearUrl()));

            }
        });

    }

    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }
}
