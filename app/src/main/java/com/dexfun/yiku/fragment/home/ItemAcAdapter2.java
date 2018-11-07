package com.dexfun.yiku.fragment.home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.dexfun.yiku.R;
import com.dexfun.yiku.activity.WebViewActivity;
import com.dexfun.yiku.entity.HotWearPageEntity;
import com.dexfun.yiku.entity.SuitWithPage;

import java.util.ArrayList;
import java.util.List;

public class ItemAcAdapter2 extends BaseAdapter {

    private List<SuitWithPage.DataEntity.ContentEntity> objects = new ArrayList<>();

    private Context context;
    private LayoutInflater layoutInflater;

    public ItemAcAdapter2(Context context, List<SuitWithPage.DataEntity.ContentEntity> content) {
        this.context = context;
        objects = content;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public SuitWithPage.DataEntity.ContentEntity getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_ac, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews(getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(SuitWithPage.DataEntity.ContentEntity object, ViewHolder holder) {
        String hotWearImg = object.getImgUrl();
        Glide.with(context).load(hotWearImg).into(holder.image);
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, WebViewActivity.class).putExtra("url", object.getLinkUrl()));
            }
        });
    }

    protected class ViewHolder {
        private ImageView image;

        public ViewHolder(View view) {
            image = (ImageView) view.findViewById(R.id.image);
        }
    }
}
