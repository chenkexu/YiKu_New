package com.dexfun.yiku.fragment.home;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dexfun.yiku.R;
import com.dexfun.yiku.activity.BrandDetailActivity;
import com.dexfun.yiku.activity.WebViewActivity;
import com.dexfun.yiku.entity.BrandListEntity;
import com.dexfun.yiku.entity.HOME_ENTITY;
import com.dexfun.yiku.entity.HomeEntity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Smile
 */
public class ItemHomeViewAdapter extends RecyclerView.Adapter<ItemHomeViewAdapter.ViewHolder> {

    private List<HOME_ENTITY.DataEntity.ThematicActivitiesEntity> datas = new ArrayList<>();

    private Context context;


    public ItemHomeViewAdapter(Context context, List<HOME_ENTITY.DataEntity.ThematicActivitiesEntity> datas) {
        this.context = context;
        this.datas.addAll(datas);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_lo_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Picasso.get().load(datas.get(position).getSpecialImg()).into(holder.brandIcon);
        holder.brandIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, WebViewActivity.class).putExtra("url", datas.get(position).getSpecialLink()));

//                context.startActivity(new Intent(context, BrandDetailActivity.class).putExtra("id", datas.get(position).getBrandId()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }


    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView brandIcon;

        public ViewHolder(View view) {
            super(view);
            brandIcon = view.findViewById(R.id.image);
        }
    }
}
