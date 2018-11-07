package com.dexfun.yiku.fragment.home;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dexfun.yiku.R;
import com.dexfun.yiku.activity.DetailActivity;
import com.dexfun.yiku.activity.WebViewActivity;
import com.dexfun.yiku.entity.HOME_ENTITY;
import com.dexfun.yiku.entity.HomeEntity;
import com.dexfun.yiku.widget.CenterImage;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Smile
 */
public class ItemRecyclerCnmmbAdapter extends RecyclerView.Adapter<ItemRecyclerCnmmbAdapter.SimpleViewHolder> {


    private final Context mContext;
    private final RecyclerView mRecyclerView;
    private List<List<HOME_ENTITY.DataEntity.BeautifulClothesEntity.ContentEntity>> objects = new ArrayList<>();


    public static class SimpleViewHolder extends RecyclerView.ViewHolder {
        private CenterImage pushIcon;
        private TextView pushTitle;
        private TextView pushSubtitle;
        private CenterImage pushIcon1;
        private TextView pushTitle1;
        private TextView pushSubtitle1;
        private View view0;
        private View view1;

        public SimpleViewHolder(View view) {
            super(view);
            pushIcon = (CenterImage) view.findViewById(R.id.push_icon);
            pushTitle = (TextView) view.findViewById(R.id.push_title);
            pushSubtitle = (TextView) view.findViewById(R.id.push_subtitle);
            pushIcon1 = (CenterImage) view.findViewById(R.id.push_icon1);
            pushTitle1 = (TextView) view.findViewById(R.id.push_title1);
            pushSubtitle1 = (TextView) view.findViewById(R.id.push_subtitle1);
            view0 = view.findViewById(R.id.view);
            view1 = view.findViewById(R.id.view1);
        }
    }

    public ItemRecyclerCnmmbAdapter(Context context, RecyclerView recyclerView, List<List<HOME_ENTITY.DataEntity.BeautifulClothesEntity.ContentEntity>> objects) {
        this(context, recyclerView, objects.size());
        this.objects = objects;
    }

    public ItemRecyclerCnmmbAdapter(Context context, RecyclerView recyclerView, int itemCount) {
        mContext = context;
        mRecyclerView = recyclerView;
    }

    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(mContext).inflate(R.layout.item_cnmb_vierpager_view, parent, false);
        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SimpleViewHolder holder, int position) {
        System.err.println(objects);

        HOME_ENTITY.DataEntity.BeautifulClothesEntity.ContentEntity contentEntity = objects.get(position).get(0);
        HOME_ENTITY.DataEntity.BeautifulClothesEntity.ContentEntity contentEntity1 = objects.get(position).get(1);

        holder.pushTitle.setText(contentEntity.getBrandName());
        String clothingName1 = contentEntity.getClothingName();
        holder.pushSubtitle.setText(clothingName1.length()>8?clothingName1.substring(0,8):clothingName1);
        Picasso.get().load(contentEntity.getClothingImgUrl()).placeholder(R.drawable.load).into(holder.pushIcon);

        holder.view0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, DetailActivity.class).putExtra("id", contentEntity.getClothingId()));
            }
        });
//        boolean oooooo = true;
//        for (HOME_ENTITY.DataEntity.BeautifulClothesEntity.ContentEntity.ClothingStockDTOSEntity clothingStockDTOSEntity : contentEntity.getClothingStockDTOS()) {
//            System.out.println(clothingStockDTOSEntity.getClothingStockNum() == 0);
//            if (clothingStockDTOSEntity.getClothingStockNum() != 0) {
//                oooooo = false;
//            }
//        }
//        if (oooooo) {
//            holder.viDaifanjia.setVisibility(View.VISIBLE);
//        } else {
//            holder.viDaifanjia.setVisibility(View.INVISIBLE);
//        }
//
//        if ((contentEntity.getClothingCreatedate() + 1000 * 60 * 60 * 24 * 2) > System.currentTimeMillis()) {
//            if (oooooo) {
//                holder.viShangxin.setVisibility(View.INVISIBLE);
//            } else {
//                holder.viShangxin.setVisibility(View.VISIBLE);
//            }
//        } else {
//            holder.viShangxin.setVisibility(View.INVISIBLE);
//        }





        holder.pushTitle1.setText(contentEntity1.getBrandName());

        String clothingName = contentEntity1.getClothingName();
        holder.pushSubtitle1.setText(clothingName.length()>8?clothingName.substring(0,8):clothingName);
        Picasso.get().load(contentEntity1.getClothingImgUrl()).placeholder(R.drawable.load).into(holder.pushIcon1);
//        boolean oooooo1 = true;
//        for (HOME_ENTITY.DataEntity.BeautifulClothesEntity.ContentEntity.ClothingStockDTOSEntity clothingStockDTOSEntity : contentEntity1.getClothingStockDTOS()) {
//            System.out.println(clothingStockDTOSEntity.getClothingStockNum() == 0);
//            if (clothingStockDTOSEntity.getClothingStockNum() != 0) {
//                oooooo1 = false;
//            }
//        }
//        if (oooooo1) {
//            holder.viDaifanjia1.setVisibility(View.VISIBLE);
//        } else {
//            holder.viDaifanjia1.setVisibility(View.INVISIBLE);
//        }
//
//        if ((contentEntity1.getClothingCreatedate() + 1000 * 60 * 60 * 24 * 2) > System.currentTimeMillis()) {
//            if (oooooo1) {
//                holder.viShangxin1.setVisibility(View.INVISIBLE);
//            } else {
//                holder.viShangxin1.setVisibility(View.VISIBLE);
//            }
//        } else {
//            holder.viShangxin1.setVisibility(View.INVISIBLE);
//        }

        holder.view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, DetailActivity.class).putExtra("id", contentEntity1.getClothingId()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }
}
