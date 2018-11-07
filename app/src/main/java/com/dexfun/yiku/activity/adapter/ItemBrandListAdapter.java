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
import com.dexfun.yiku.activity.BrandListActivity;
import com.dexfun.yiku.entity.BrandAllListEntity;
import com.squareup.picasso.Picasso;

public class ItemBrandListAdapter extends BaseAdapter {

    private List<BrandAllListEntity.DataEntity.BrandVoListEntity> objects = new ArrayList<>();

    private Context context;
    private LayoutInflater layoutInflater;

    public ItemBrandListAdapter(Context context, List<BrandAllListEntity.DataEntity.BrandVoListEntity> objects) {
        this.objects = objects;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public BrandAllListEntity.DataEntity.BrandVoListEntity getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_brand_list, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews(getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(BrandAllListEntity.DataEntity.BrandVoListEntity object, ViewHolder holder) {
        try {
            Picasso.get().load(object.getBrandLittleLogo()).into(holder.imgIcon);
        }catch (Exception e){
            e.printStackTrace();
        }
        holder.tvBrand.setText(object.getBrandName());
    }

    protected class ViewHolder {
        private ImageView imgIcon;
        private TextView tvBrand;

        public ViewHolder(View view) {
            imgIcon = (ImageView) view.findViewById(R.id.img_icon);
            tvBrand = (TextView) view.findViewById(R.id.tv_brand);
        }
    }
}
