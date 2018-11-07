package com.dexfun.yiku.activity.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.dexfun.yiku.R;
import com.dexfun.yiku.entity.NewOrderEntity;

public class ItemNewOrderAdapter extends BaseAdapter {

    private List<NewOrderEntity.DataEntity.ClothingListEntity> objects = new ArrayList<>();

    private Context context;
    private LayoutInflater layoutInflater;

    public ItemNewOrderAdapter(Context context, List<NewOrderEntity.DataEntity.ClothingListEntity> obj) {
        this.context = context;
        this.objects = obj;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public NewOrderEntity.DataEntity.ClothingListEntity getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_new_order, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews(getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(NewOrderEntity.DataEntity.ClothingListEntity object, ViewHolder holder) {
        holder.name.setText(object.getClothingName());
        holder.mode.setText(object.getClothingModel());
        holder.pc.setText("￥" + object.getClothingPrice());
    }

    protected class ViewHolder {
        private TextView name;
        private TextView mode;
        private TextView pc;

        public ViewHolder(View view) {
            name = (TextView) view.findViewById(R.id.name);
            mode = (TextView) view.findViewById(R.id.mode);
            pc = (TextView) view.findViewById(R.id.pc);
        }
    }
}
