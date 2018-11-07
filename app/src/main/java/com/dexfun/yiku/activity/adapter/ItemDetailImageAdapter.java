package com.dexfun.yiku.activity.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.dexfun.yiku.R;
import com.dexfun.yiku.entity.DetailEntity;
import com.squareup.picasso.Picasso;

public class ItemDetailImageAdapter extends BaseAdapter {

    private List<DetailEntity.DataEntity.ClothingDetailImgEntity> objects = new ArrayList<>();

    private Context context;
    private LayoutInflater layoutInflater;

    public ItemDetailImageAdapter(Context context, List<DetailEntity.DataEntity.ClothingDetailImgEntity> objects) {
        this.objects = objects;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public DetailEntity.DataEntity.ClothingDetailImgEntity getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_detail_image, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews(getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(DetailEntity.DataEntity.ClothingDetailImgEntity object, ViewHolder holder) {
        Picasso.get().load(object.getClothingImgUrl()).into(holder.imegeDetail);
    }

    protected class ViewHolder {
        private ImageView imegeDetail;

        public ViewHolder(View view) {
            imegeDetail = (ImageView) view.findViewById(R.id.imege_detail);
        }
    }
}
