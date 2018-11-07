package com.dexfun.yiku.fragment.home;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dexfun.yiku.R;

import com.dexfun.yiku.UserClass;
import com.dexfun.yiku.entity.ProductListEntity;
import com.dexfun.yiku.utils.SharedPreferencesUtil;
import com.dexfun.yiku.widget.CenterImage;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemPushViewAdapter2 extends BaseAdapter {

    private List<ProductListEntity> objects = new ArrayList<>();

    private Context context;
    private LayoutInflater layoutInflater;
    private String token = UserClass.getInstance().getToken();
    private boolean isVip = SharedPreferencesUtil.getInstance().getBoolean("isVIP", false);

    public ItemPushViewAdapter2(Context context, List<ProductListEntity> objects) {
        this.objects = objects;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    public void addObjects(List<ProductListEntity> objects) {
        this.objects.addAll(objects);
        notifyDataSetChanged();
    }

    public void setObjects(List<ProductListEntity> objects) {
        this.objects.clear();
        this.objects.addAll(objects);
        notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public ProductListEntity getItem(int position) {
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

    private void initializeViews(ProductListEntity object, ViewHolder holder) {

        if (TextUtils.isEmpty(token) || token.equals("error") || !isVip) {
            holder.freeView1.setVisibility(View.VISIBLE);
            holder.freeView2.setVisibility(View.VISIBLE);
        } else {
            holder.freeView1.setVisibility(View.GONE);
            holder.freeView2.setVisibility(View.GONE);
        }
        holder.pushTitle.setText(object.getClothingName());
        holder.pushSubtitle.setText(object.getBrandName());
        try {
            Picasso.get().load(object.getClothingImgUrl()).placeholder(R.drawable.load).into(holder.pushIcon);
        } catch (Exception e) {
            e.printStackTrace();
        }
        boolean oooooo = true;
        for (ProductListEntity.ClothingStockDTOSEntity clothingStockDTOSEntity : object.getClothingStockDTOS()) {
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
        if (object.getOccupySeat() == 2) {
            holder.yx2.setVisibility(View.VISIBLE);
        } else {
            holder.yx2.setVisibility(View.INVISIBLE);
        }

        if (object.getStarSameStyle() != null && object.getStarSameStyle() == 1) {
            holder.shangxin.setVisibility(View.VISIBLE);
            holder.shangxin.setText("明星同款");
        } else {
            if ((object.getClothingCreatedate() + 1000 * 60 * 60 * 24 * 2) > System.currentTimeMillis()) {
                if (oooooo) {
                    holder.shangxin.setVisibility(View.INVISIBLE);
                } else {
                    holder.shangxin.setText("刚刚上新");
                    holder.shangxin.setVisibility(View.VISIBLE);
                }
            } else {
                holder.shangxin.setVisibility(View.INVISIBLE);
            }
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
        TextView shangxin;
        @BindView(R.id.vi_daifanjia)
        View daifangjia;
        @BindView(R.id.free_t1)
        View freeView1;
        @BindView(R.id.free_t2)
        View freeView2;
        @BindView(R.id.yx2)
        View yx2;
        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
