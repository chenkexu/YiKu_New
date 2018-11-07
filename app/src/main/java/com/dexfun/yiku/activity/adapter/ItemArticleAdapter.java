package com.dexfun.yiku.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dexfun.yiku.R;
import com.dexfun.yiku.activity.AddArticleActivity;
import com.dexfun.yiku.entity.ChooseClothesEntity;
import com.dexfun.yiku.entity.ProductListEntity;
import com.dexfun.yiku.widget.CenterImage;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemArticleAdapter extends BaseAdapter {

    private List<ChooseClothesEntity.DataEntity> objects = new ArrayList<>();

    private Context context;
    private LayoutInflater layoutInflater;

    public ItemArticleAdapter(AddArticleActivity context, List<ChooseClothesEntity.DataEntity> data) {
        this.objects = data;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    public void setObjects(List<ChooseClothesEntity.DataEntity> datas) {
        this.objects.clear();
        this.objects.addAll(datas);
        notifyDataSetChanged();
    }

    public void addObjects(List<ChooseClothesEntity.DataEntity> datas) {
        this.objects.addAll(datas);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public ChooseClothesEntity.DataEntity getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_next_knapsac, null, false);
            convertView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews(getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(ChooseClothesEntity.DataEntity object, ViewHolder holder) {
        holder.tv_xl.setText(object.getClothingStockType());
        holder.tv_price.setText(String.valueOf(object.getClothingPrice()));
        holder.pushTitle.setText(object.getClothingBrandName());
        holder.pushSubtitle.setText(object.getClothingName());
        Picasso.get().load(object.getClothingImgUrl()).into(holder.pushIcon);

    }

    static class ViewHolder {
        @BindView(R.id.img_icon)
        ImageView pushIcon;
        @BindView(R.id.tv_title)
        TextView pushTitle;
        @BindView(R.id.tv_brand_title)
        TextView pushSubtitle;
        @BindView(R.id.tv_xl)
        TextView tv_xl;
        @BindView(R.id.tv_price)
        TextView tv_price;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
