package com.dexfun.yiku.activity.adapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dexfun.yiku.R;
import com.dexfun.yiku.activity.BuyCardActivity;
import com.dexfun.yiku.activity.WalletActivity;
import com.dexfun.yiku.entity.CouponsListEntity;
import com.dexfun.yiku.entity.DefaultEntity;
import com.dexfun.yiku.entity.GetUserInfoEntity;
import com.dexfun.yiku.service.impl.HttpServiceImpl;

/**
 * @author Smile
 */
public class ItemWalletCardAdapter extends BaseAdapter {

    private List<CouponsListEntity.DataEntity> objects = new ArrayList<>();

    private Context context;
    private LayoutInflater layoutInflater;

    public ItemWalletCardAdapter(Context context, List<CouponsListEntity.DataEntity> objects) {
        this.context = context;
        this.objects = objects;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public CouponsListEntity.DataEntity getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_wallet_card, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews(getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(CouponsListEntity.DataEntity object, ViewHolder holder) {
        holder.time.setText(new SimpleDateFormat("yyy.MM.dd").format(object.getExpiryTime()) + "前有效");
        if (object.getCouponStatus() == 3) {//过期 1未使用 2已使用
            holder.img.setImageResource(R.mipmap.e2);
            holder.title.setTextColor(Color.parseColor("#FF8B8B8B"));
            holder.p.setTextColor(Color.parseColor("#FF8B8B8B"));
            holder.ps.setTextColor(Color.parseColor("#FF8B8B8B"));
            holder.time.setText("已过期");
        }
        if (object.getCouponStatus() == 1) {
            holder.img.setImageResource(R.mipmap.e1);
            holder.title.setTextColor(Color.parseColor("#FFFDDD55"));
            holder.p.setTextColor(Color.parseColor("#FFFDDD55"));
            holder.ps.setTextColor(Color.parseColor("#FFFDDD55"));
        }
        if (object.getCouponStatus() == 2) {
            holder.img.setImageResource(R.mipmap.e2);
            holder.title.setTextColor(Color.parseColor("#FF8B8B8B"));
            holder.p.setTextColor(Color.parseColor("#FF8B8B8B"));
            holder.ps.setTextColor(Color.parseColor("#FF8B8B8B"));
            holder.time.setText("已使用");
        }
        holder.title.setText(object.getCouponName());

        holder.p.setText(object.getCouponType() == 1 ? String.valueOf(object.getCouponDays()) : String.valueOf(object.getCouponAmount()));
        holder.ps.setText(object.getCouponType() == 1 ? "天" : "元");
        holder.btnRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (object.getCouponType() == 2) {
                    context.startActivity(new Intent(context, BuyCardActivity.class).putExtra("id1", object.getCouponId()).putExtra("p1", object.getCouponAmount()));
                    return;
                }
                new HttpServiceImpl().clipCoupons(object.getCouponId(), new HttpServiceImpl.OnObjectDataListener<DefaultEntity>() {
                    @Override
                    public void onData(DefaultEntity data) {
                        if (data.getStatus() == 200) {
                            Toast.makeText(context, "使用成功", Toast.LENGTH_SHORT).show();
                            WalletActivity context = (WalletActivity) ItemWalletCardAdapter.this.context;
                            context.getData(null);
                        } else {
                            Toast.makeText(context, data.getMsg(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });

            }
        });
    }

    protected class ViewHolder {
        private ImageView img;
        private TextView p;
        private TextView ps;
        private TextView title;
        private TextView time;
        private View btnRed;

        public ViewHolder(View view) {
            img = view.findViewById(R.id.img);
            p = (TextView) view.findViewById(R.id.p);
            ps = (TextView) view.findViewById(R.id.ps);
            title = (TextView) view.findViewById(R.id.title);
            time = (TextView) view.findViewById(R.id.time);
            btnRed = (View) view.findViewById(R.id.btn_red);
        }
    }
}
