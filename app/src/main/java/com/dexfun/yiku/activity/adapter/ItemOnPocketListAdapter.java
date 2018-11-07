package com.dexfun.yiku.activity.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dexfun.yiku.R;
import com.dexfun.yiku.entity.OrderEntity;
import com.squareup.picasso.Picasso;

public class ItemOnPocketListAdapter extends BaseAdapter {

    private List<OrderEntity.DataEntity.OrderDetailsVoListEntity> objects = new ArrayList<>();

    private Context context;
    private LayoutInflater layoutInflater;

    public ItemOnPocketListAdapter(Context context, List<OrderEntity.DataEntity.OrderDetailsVoListEntity> objects) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.objects = objects;
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public OrderEntity.DataEntity.OrderDetailsVoListEntity getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_on_pocket_list, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews(getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(OrderEntity.DataEntity.OrderDetailsVoListEntity object, ViewHolder holder) {
        Picasso.get().load(object.getClothingImgUrl()).into(holder.imgIcon);
        holder.tvTitle.setText(object.getClothingName());
        holder.tvBrandTitle.setText(object.getClothingBrandName());
        holder.tvXl.setText(object.getClothingStockType());
        holder.tvPrice.setText(String.valueOf(object.getClothingPrice()));
    }

    protected class ViewHolder {
        private ImageView imgIcon;
        private TextView tvTitle;
        private TextView tvBrandTitle;
        private TextView tvXl;
        private TextView tvPrice;

        public ViewHolder(View view) {
            imgIcon = view.findViewById(R.id.img_icon);
            tvTitle = view.findViewById(R.id.tv_title);
            tvBrandTitle = view.findViewById(R.id.tv_brand_title);
            tvXl = view.findViewById(R.id.tv_xl);
            tvPrice = view.findViewById(R.id.tv_price);
        }
    }
}
