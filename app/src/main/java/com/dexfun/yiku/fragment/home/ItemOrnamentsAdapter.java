package com.dexfun.yiku.fragment.home;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.dexfun.yiku.R;
import com.dexfun.yiku.UserClass;
import com.dexfun.yiku.entity.OrnamentEntity;
import com.dexfun.yiku.entity.ProductListEntity;
import com.dexfun.yiku.widget.CenterImage;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemOrnamentsAdapter extends BaseAdapter {

    private List<OrnamentEntity.DataEntity> objects = new ArrayList<>();
    private String token = UserClass.getInstance().getToken();
    private Context context;
    private LayoutInflater layoutInflater;

    public void setObjects(List<OrnamentEntity.DataEntity> datas) {
        this.objects.clear();
        this.objects.addAll(datas);
        notifyDataSetChanged();
    }

    public void addObjects(List<OrnamentEntity.DataEntity> datas) {
        this.objects.addAll(datas);
        notifyDataSetChanged();
    }

    public ItemOrnamentsAdapter(Context context, List<OrnamentEntity.DataEntity> objects) {
        this.objects = objects;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public OrnamentEntity.DataEntity getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_push_view, null, false);
            convertView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews(getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(OrnamentEntity.DataEntity object, ViewHolder holder) {
        if (TextUtils.isEmpty(token)|| token.equals("error")) {
            holder.freeView1.setVisibility(View.VISIBLE);
            holder.freeView2.setVisibility(View.VISIBLE);
        } else {
            holder.freeView1.setVisibility(View.GONE);
            holder.freeView2.setVisibility(View.GONE);
        }

        holder.pushTitle.setText(object.getClothingName());
        holder.pushSubtitle.setText(object.getBrandName());
        Picasso.get().load(object.getClothingImgUrl()).placeholder(R.drawable.load).into(holder.pushIcon);
        boolean oooooo = true;
        for (OrnamentEntity.DataEntity.ClothingStockDTOSEntity clothingStockDTOSEntity : object.getClothingStockDTOS()) {
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

        @BindView(R.id.free_t1)
        View freeView1;
        @BindView(R.id.free_t2)
        View freeView2;
        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
