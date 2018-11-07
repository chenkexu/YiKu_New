package com.dexfun.yiku.fragment.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.dexfun.yiku.R;
import com.dexfun.yiku.entity.PopularityClothingPage;
import com.dexfun.yiku.entity.ProductListEntity;
import com.dexfun.yiku.widget.CenterImage;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemPushViewAdapter3 extends BaseAdapter {

    private List<PopularityClothingPage.DataEntity.ContentEntity> objects = new ArrayList<>();

    private Context context;
    private LayoutInflater layoutInflater;

    public ItemPushViewAdapter3(Context context, List<PopularityClothingPage.DataEntity.ContentEntity> objects) {
        this.objects = objects;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    public void addObjects(List<PopularityClothingPage.DataEntity.ContentEntity> objects) {
        this.objects.addAll(objects);
        notifyDataSetChanged();
    }

    public void setObjects(List<PopularityClothingPage.DataEntity.ContentEntity> objects) {
        this.objects.clear();
        this.objects.addAll(objects);
        notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public PopularityClothingPage.DataEntity.ContentEntity getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_push_view, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews(getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(PopularityClothingPage.DataEntity.ContentEntity object, ViewHolder holder) {
        holder.pushTitle.setText(object.getClothingName());
        holder.pushSubtitle.setText(object.getBrandName());
        try {
            Picasso.get().load(object.getClothingImgUrl()).placeholder(R.drawable.load).into(holder.pushIcon);
        }catch (Exception e){
            e.printStackTrace();
        }
        boolean oooooo = true;
        for (PopularityClothingPage.DataEntity.ContentEntity.ClothingStockDTOSEntity clothingStockDTOSEntity : object.getClothingStockDTOS()) {
            System.out.println(clothingStockDTOSEntity.getClothingStockNum() == 0);
            if (clothingStockDTOSEntity.getClothingStockNum() != 0) {
                oooooo = false;
            }
        }
        if (oooooo) {
            holder.daifangjia.setVisibility(View.VISIBLE);
        } else {
            holder.daifangjia.setVisibility(View.INVISIBLE);
        }

        if ((object.getClothingCreatedate() + 1000 * 60 * 60 * 24 * 2) > System.currentTimeMillis()) {
            if (oooooo) {
                holder.shangxin.setVisibility(View.INVISIBLE);
            } else {
                holder.shangxin.setVisibility(View.VISIBLE);
            }
        } else {
            holder.shangxin.setVisibility(View.INVISIBLE);
        }
    }

    static class ViewHolder {
        @BindView(R.id.push_icon)
        CenterImage pushIcon;
        @BindView(R.id.push_title)
        TextView pushTitle;
        @BindView(R.id.push_subtitle)
        TextView pushSubtitle;
        @BindView(R.id.vi_shangxin)
        View shangxin;
        @BindView(R.id.vi_daifanjia)
        View daifangjia;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
