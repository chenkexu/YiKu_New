package com.dexfun.yiku.fragment.home;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dexfun.yiku.R;
import com.dexfun.yiku.UserClass;
import com.dexfun.yiku.activity.DetailActivity;
import com.dexfun.yiku.entity.HOME_ENTITY;
import com.dexfun.yiku.utils.SharedPreferencesUtil;
import com.dexfun.yiku.widget.CenterImage;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Smile on 18/8/28.
 */

public class ItemCnmbAdapter extends PagerAdapter {

    Context context;
    List<List<HOME_ENTITY.DataEntity.BeautifulClothesEntity.ContentEntity>> mmpList = new ArrayList<>();
    private String token = UserClass.getInstance().getToken();
    private boolean isVip = SharedPreferencesUtil.getInstance().getBoolean("isVIP",false);
    public ItemCnmbAdapter(Context context, List<List<HOME_ENTITY.DataEntity.BeautifulClothesEntity.ContentEntity>> mmpList) {
        this.context = context;
        this.mmpList = mmpList;
    }

    @Override
    public int getCount() {
        System.out.println("ItemCnmbAdapter.getCount");
        return mmpList.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        System.out.println("container = [" + container + "], position = [" + position + "]");
        View view = View.inflate(context, R.layout.item_cnmb_vierpager_view, null);
        CenterImage pushIcon;
        TextView pushTitle;
        TextView pushSubtitle;
        CenterImage pushIcon1;
        TextView pushTitle1;
        TextView pushSubtitle1;
        View view0;
        View view1;

        View yx2;
        View yx22;

        pushIcon = (CenterImage) view.findViewById(R.id.push_icon);
        pushTitle = (TextView) view.findViewById(R.id.push_title);
        pushSubtitle = (TextView) view.findViewById(R.id.push_subtitle);
        pushIcon1 = (CenterImage) view.findViewById(R.id.push_icon1);
        pushTitle1 = (TextView) view.findViewById(R.id.push_title1);
        pushSubtitle1 = (TextView) view.findViewById(R.id.push_subtitle1);
        view0 = view.findViewById(R.id.view);
        view1 = view.findViewById(R.id.view1);
        View freeView1,freeView2,freeView3,freeView4;

        freeView1 = view.findViewById(R.id.free_t1);
        freeView2 = view.findViewById(R.id.free_t2);
        freeView3 = view.findViewById(R.id.free_t3);
        freeView4 = view.findViewById(R.id.free_t4);
        yx2 = view.findViewById(R.id.yx2);
        yx22 = view.findViewById(R.id.yx22);
        if (TextUtils.isEmpty(token) || token.equals("error")||!isVip) {
            freeView1.setVisibility(View.VISIBLE);
            freeView2.setVisibility(View.VISIBLE);
            freeView3.setVisibility(View.VISIBLE);
            freeView4.setVisibility(View.VISIBLE);
        } else {
            freeView1.setVisibility(View.GONE);
            freeView2.setVisibility(View.GONE);
            freeView3.setVisibility(View.GONE);
            freeView4.setVisibility(View.GONE);
        }

        HOME_ENTITY.DataEntity.BeautifulClothesEntity.ContentEntity contentEntity = mmpList.get(position).get(0);
        HOME_ENTITY.DataEntity.BeautifulClothesEntity.ContentEntity contentEntity1 = mmpList.get(position).get(1);
        if (contentEntity.getOccupySeat() == 2) {
            yx2.setVisibility(View.VISIBLE);
        } else {
            yx2.setVisibility(View.INVISIBLE);
        }
        if (contentEntity1.getOccupySeat() == 2) {
            yx22.setVisibility(View.VISIBLE);
        } else {
            yx22.setVisibility(View.INVISIBLE);
        }
        pushTitle.setText(contentEntity.getClothingName());
        String clothingName1 = contentEntity.getBrandName();
        pushSubtitle.setText(clothingName1.length() > 8 ? clothingName1.substring(0, 8) : clothingName1);
        Picasso.get().load(contentEntity.getClothingImgUrl()).placeholder(R.drawable.load).into(pushIcon);

        view0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, DetailActivity.class).putExtra("id", contentEntity.getClothingId()));
            }
        });

        pushTitle1.setText(contentEntity1.getClothingName());

        String clothingName = contentEntity1.getBrandName();
        pushSubtitle1.setText(clothingName.length() > 8 ? clothingName.substring(0, 8) : clothingName);
        Picasso.get().load(contentEntity1.getClothingImgUrl()).placeholder(R.drawable.load).into(pushIcon1);


        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, DetailActivity.class).putExtra("id", contentEntity1.getClothingId()));
            }
        });

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
