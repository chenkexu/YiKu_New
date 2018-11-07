package com.dexfun.yiku.fragment.home;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dexfun.yiku.R;
import com.dexfun.yiku.activity.BrandDetailActivity;
import com.dexfun.yiku.entity.BrandListEntity;
import com.dexfun.yiku.entity.HomeEntity;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemBrandViewAdapter extends RecyclerView.Adapter<ItemBrandViewAdapter.ViewHolder> {

    List<BrandListEntity> datas = new ArrayList<>();

    Context context;

    public ItemBrandViewAdapter(Context context, List<BrandListEntity> datas) {
        this.context = context;
        this.datas.addAll(datas);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_brand_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//        holder.mTextView.setText(datas.get(position).getBrandName());
        Picasso.get().load(datas.get(position).getBrandLargeLogo()).into(holder.brandIcon);
        holder.brandIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, BrandDetailActivity.class).putExtra("id", datas.get(position).getBrandId()));
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
