package com.dexfun.yiku.activity.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.dexfun.yiku.R;
import com.dexfun.yiku.activity.BrandDetailActivity;
import com.dexfun.yiku.activity.DetailActivity;
import com.dexfun.yiku.activity.LogisticsDetailsActivity;
import com.dexfun.yiku.activity.LogisticsDetailsActivity2;
import com.dexfun.yiku.activity.MessageActivity;
import com.dexfun.yiku.activity.PSDetailActivity;
import com.dexfun.yiku.activity.PocketActivity;
import com.dexfun.yiku.activity.ReturnActivity;
import com.dexfun.yiku.entity.DefaultEntity;
import com.dexfun.yiku.entity.OrderEntity;
import com.dexfun.yiku.fragment.home.ItemPushViewAdapter2;
import com.dexfun.yiku.fragment.knapsack.ItemKnapsackAdapter;
import com.dexfun.yiku.service.impl.HttpServiceImpl;
import com.dexfun.yiku.widget.CustomListView;

public class ItemPocketAdapter extends BaseAdapter {

    private List<OrderEntity.DataEntity> objects = new ArrayList<>();

    private Context context;
    private int index;
    private LayoutInflater layoutInflater;

    public ItemPocketAdapter(int index, Context context, List<OrderEntity.DataEntity> objects) {
        this.index = index;
        this.objects = objects;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public OrderEntity.DataEntity getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_pocket, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews(getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(OrderEntity.DataEntity object, ViewHolder holder) {
        switch (object.getOrderStatus()) {
            case 3:
                holder.tvStatus.setText(String.format("衣袋状态：%s", "待签收"));
                holder.btnSf.setVisibility(View.VISIBLE);
                break;
            case 4:
                holder.btnWl.setVisibility(View.VISIBLE);
                holder.btnSf.setVisibility(View.GONE);
                holder.tvStatus.setText(String.format("衣袋状态：%s", "待归还"));
                break;
            case 5:
                holder.btnWl.setVisibility(View.GONE);
                holder.btnSf.setVisibility(View.GONE);
                holder.tvStatus.setText(String.format("衣袋状态：%s", "已归还"));
                break;
            case 2:
                holder.btnWl.setVisibility(View.GONE);
                holder.btnSf.setVisibility(View.GONE);
                holder.tvStatus.setText(String.format("衣袋状态：%s", "待发货"));
                break;
            case 1:
                holder.btnWl.setVisibility(View.GONE);
                holder.btnSf.setVisibility(View.GONE);
                holder.tvStatus.setText(String.format("衣袋状态：%s", "待配货"));
                break;
            case 6:
                holder.btnWl.setVisibility(View.GONE);
                holder.btnSf.setVisibility(View.GONE);
                holder.tvStatus.setText(String.format("衣袋状态：%s", "已取消"));
                break;
            case 8:
                holder.btnWl.setVisibility(View.GONE);
                holder.btnSf.setVisibility(View.GONE);
                holder.tvStatus.setText(String.format("衣袋状态：%s", "已完成"));
            default:
        }


        switch (index) {
            case 0:

                break;
            case 1:
                if (object.getOrderStatus() == 1) {
                    holder.tvStatus.setText("衣袋状态：待配货");
                }
                if (object.getOrderStatus() == 2) {
                    holder.tvStatus.setText("衣袋状态：待发货");
                }
//                holder.tvStatus.setText("物流状态：快件已到达上地南路");
//                holder.tvStatus.setTextColor(Color.parseColor("#FF676869"));
                holder.btnSf.setVisibility(View.VISIBLE);

                break;
            case 2:

                new HttpServiceImpl().getYTTrackResult(object.getOrderNo(), new HttpServiceImpl.OnObjectDataListener<Boolean>() {
                    @Override
                    public void onData(Boolean data) {
                        if (data) {
                            holder.btnSf.setVisibility(View.GONE);
                        } else {
                            holder.btnSf.setVisibility(View.VISIBLE);
                            TextView viewById = holder.btnSf.findViewById(R.id.btn_return);
                            viewById.setText("预约归还");
                        }
                    }
                });
                break;
            case 3:
                holder.btnSf.setVisibility(View.GONE);
                break;
            default:
        }

        ItemOnPocketListAdapter itemOnPocketListAdapter = new ItemOnPocketListAdapter(context, object.getOrderDetailsVoList());
        holder.listPo.setAdapter(itemOnPocketListAdapter);
        holder.listPo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int clothingId = itemOnPocketListAdapter.getItem(i).getClothingId();
                if (itemOnPocketListAdapter.getItem(i).getClassify()==1){
                    context.startActivity(new Intent(context, DetailActivity.class).putExtra("id", clothingId));
                }else {
                    context.startActivity(new Intent(context, PSDetailActivity.class).putExtra("id", clothingId));
                }

            }
        });
        holder.btnSf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index==2){
                    context.startActivity(new Intent(context, ReturnActivity.class).putExtra("id", object.getOrderNo()));
                }else {
                    new HttpServiceImpl().setUpdateOrder(object.getId(), 4, new HttpServiceImpl.OnObjectDataListener<DefaultEntity>() {
                        @Override
                        public void onData(DefaultEntity data) {
                            if (data.getStatus() == 200) {
                                Toast.makeText(context, "确认成功", Toast.LENGTH_SHORT).show();
                                ((PocketActivity) context).getData(null);
                            } else {
                                Toast.makeText(context, "发货后才能确认收货哦", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

            }
        });
        holder.btnWl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index == 2) {
                    context.startActivity(new Intent(context, LogisticsDetailsActivity2.class).putExtra("id", object.getOrderNo()));
                } else {
                    context.startActivity(new Intent(context, LogisticsDetailsActivity.class).putExtra("id", object.getOrderNo()));
                }

            }
        });
    }

    protected class ViewHolder {
        private TextView tvStatus;
        private LinearLayout btnWl;
        private LinearLayout btnSf;
        private CustomListView listPo;

        public ViewHolder(View view) {
            tvStatus = (TextView) view.findViewById(R.id.tv_status);
            btnWl = (LinearLayout) view.findViewById(R.id.btn_wl);
            btnSf = (LinearLayout) view.findViewById(R.id.btn_sf);
            listPo = (CustomListView) view.findViewById(R.id.list_po);
        }
    }
}
