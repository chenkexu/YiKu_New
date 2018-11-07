package com.dexfun.yiku.fragment.home;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dexfun.yiku.R;
import com.dexfun.yiku.entity.SelectClothEntity;
import com.squareup.picasso.Picasso;

public class ItemChooseStAdapter extends BaseAdapter {

    private List<SelectClothEntity.DataEntity.ClothingStylesEntity> objects = new ArrayList<>();

    private Context context;
    private LayoutInflater layoutInflater;


    public ItemChooseStAdapter(Context context, List<SelectClothEntity.DataEntity.ClothingStylesEntity> clothingStyles) {
        this.objects = clothingStyles;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public SelectClothEntity.DataEntity.ClothingStylesEntity getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_choose_st, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews(getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(SelectClothEntity.DataEntity.ClothingStylesEntity object, ViewHolder holder) {
        try {
            Picasso.get().load(object.getStyleImage()).into(holder.icon);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (object.isColor()) {
            holder.tvTitle.setTextColor(Color.parseColor("#EE2D2D"));
        } else {
            holder.tvTitle.setTextColor(Color.parseColor("#1A1A1A"));
        }

        holder.tvTitle.setText(object.getStyleName());
        System.err.println(object.getStyleName());
    }

    public void setColor(int color, boolean is) {
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).setColor(false);
        }
        objects.get(color).setColor(is);
        notifyDataSetChanged();
    }

    protected class ViewHolder {
        private ImageView icon;
        private TextView tvTitle;
        private LinearLayout content;

        public ViewHolder(View view) {
            icon = (ImageView) view.findViewById(R.id.icon);
            tvTitle = (TextView) view.findViewById(R.id.tv_title);
            content = view.findViewById(R.id.content);
        }
    }
}
