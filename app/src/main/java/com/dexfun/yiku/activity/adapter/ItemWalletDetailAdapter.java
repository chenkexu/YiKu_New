package com.dexfun.yiku.activity.adapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.dexfun.yiku.R;
import com.dexfun.yiku.entity.WalletDetailEntity;

public class ItemWalletDetailAdapter extends BaseAdapter {

    private List<WalletDetailEntity.DataEntity> objects = new ArrayList<>();

    private Context context;
    private LayoutInflater layoutInflater;

    public ItemWalletDetailAdapter(Context context, List<WalletDetailEntity.DataEntity> objects) {
        this.objects = objects;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public WalletDetailEntity.DataEntity getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_wallet_detail, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews(getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(WalletDetailEntity.DataEntity object, ViewHolder holder) {
        if (object.getClassification() == 1) {

            if (object.getTransactionType() == 1) {
                holder.tvStatus.setText("缴纳押金");
            } else if (object.getTransactionType() == 2) {
                holder.tvStatus.setText("退押金");
            } else {
                holder.tvStatus.setText("Boom!");
            }

        } else if (object.getClassification() == 2) {

            if (object.getTransactionType() == 1) {
                holder.tvStatus.setText("购买会员卡");
            } else if (object.getTransactionType() == 2) {
                holder.tvStatus.setText("退会员卡");
            } else {
                holder.tvStatus.setText("Boom!");
            }
        } else if (object.getClassification() == 3) {
            holder.tvStatus.setText("缴纳押金+购买会员卡");
        } else {
            holder.tvStatus.setText("退款成功");
        }
        holder.tvPrice.setText(String.valueOf(object.getTransactionAmount()));
        holder.tvDate.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.SIMPLIFIED_CHINESE).format(object.getTradingTime()));
        holder.tvType.setText(object.getPaymentMethod() == 1 ? "支付宝" : "wxiconx");
    }

    protected class ViewHolder {
        private TextView tvStatus;
        private TextView tvPrice;
        private TextView tvDate;
        private TextView tvType;

        public ViewHolder(View view) {
            tvStatus = view.findViewById(R.id.tv_status);
            tvPrice = view.findViewById(R.id.tv_price);
            tvDate = view.findViewById(R.id.tv_date);
            tvType = view.findViewById(R.id.tv_type);
        }
    }
}
