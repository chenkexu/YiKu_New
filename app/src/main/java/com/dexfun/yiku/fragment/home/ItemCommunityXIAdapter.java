package com.dexfun.yiku.fragment.home;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.dexfun.yiku.R;
import com.dexfun.yiku.activity.BrandDetailActivity;
import com.dexfun.yiku.activity.PicViewActivity;
import com.dexfun.yiku.entity.BrandListEntity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ItemCommunityXIAdapter extends RecyclerView.Adapter<ItemCommunityXIAdapter.ViewHolder> {

    ArrayList<String> datas = new ArrayList<>();

    Context context;

    public ItemCommunityXIAdapter(Context context, ArrayList<String> datas) {
        this.context = context;
        this.datas.addAll(datas);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comm_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//        holder.mTextView.setText(datas.get(position).getBrandName());
        Glide.with(context).load(datas.get(position)).into(holder.brandIcon);
        holder.brandIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, PicViewActivity.class).putExtra("urls", datas).putExtra("index", position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }


    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class ViewHolder extends RecyclerView.ViewHolder {
        //        public TextView mTextView;
        public ImageView brandIcon;
//        public View mContent;

        public ViewHolder(View view) {
            super(view);
//            mTextView = view.findViewById(R.id.brand_title);
            brandIcon = view.findViewById(R.id.brand_icon);
//            mContent = view.findViewById(R.id.layout);
        }
    }
}
