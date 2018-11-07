package com.dexfun.yiku.activity.adapter;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.RadioButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.dexfun.yiku.R;
import com.dexfun.yiku.activity.EditAddressActivity;
import com.dexfun.yiku.activity.ReceiverAddressActivity;
import com.dexfun.yiku.entity.AllAddressEntity;
import com.dexfun.yiku.entity.DefaultEntity;
import com.dexfun.yiku.entity.DeleteAddressEntity;
import com.dexfun.yiku.service.impl.HttpServiceImpl;
import com.dexfun.yiku.widget.BaseDialog;
import com.squareup.picasso.Picasso;

public class ItemReceiverAddressAdapter extends BaseAdapter {

    private List<AllAddressEntity.DataBean> objects = new ArrayList<>();

    private Context context;
    private LayoutInflater layoutInflater;

    public ItemReceiverAddressAdapter(Context context, List<AllAddressEntity.DataBean> objects) {
        this.objects = objects;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public AllAddressEntity.DataBean getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_receiver_address, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews(getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(AllAddressEntity.DataBean object, ViewHolder holder) {
        holder.itemReceiverName.setText(object.getConsignee());
        holder.itemReceiverPhone.setText(object.getContactNumber());
        holder.itemReceiverAddress.setText(object.getRegion() + "-" + object.getDetailedAddress());
        holder.itemRadio.setChecked(object.getDefaultAddress() == 1);
        holder.itemCompile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, EditAddressActivity.class);
                intent.putExtra("address", object);
                context.startActivity(intent);
            }
        });
        holder.itemDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new BaseDialog(context, true).setMessage("确认删除该地址").setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        new HttpServiceImpl().deleteAddress(object.getAddressId(), new HttpServiceImpl.OnObjectDataListener<DeleteAddressEntity>() {
                            @Override
                            public void onData(DeleteAddressEntity data) {
                                if (data.isSuccess()) {
                                    Toast.makeText(context, "成功", Toast.LENGTH_SHORT).show();
                                    objects.remove(object);
                                    notifyDataSetChanged();
                                } else {
                                    Toast.makeText(context, "删除失败 错误代码-" + data.getStatus(), Toast.LENGTH_SHORT).show();
                                }

                            }
                        });
                    }
                }).show();

            }
        });
        holder.itemRadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new HttpServiceImpl().settingDefaultAddress(object.getAddressId(), new HttpServiceImpl.OnObjectDataListener<DefaultEntity>() {
                    @Override
                    public void onData(DefaultEntity data) {
                        if (null != data) {
                            Toast.makeText(context, data.getMsg(), Toast.LENGTH_SHORT).show();
                            if (data.getStatus() == 200) {
                                ReceiverAddressActivity context = (ReceiverAddressActivity) ItemReceiverAddressAdapter.this.context;
                                context.getData(null);
                            }

                        }
                    }
                });
            }
        });
        holder.content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.itemRadio.performClick();
            }
        });

    }

    protected class ViewHolder {
        private TextView itemReceiverName;
        private TextView itemReceiverPhone;
        private TextView itemReceiverAddress;
        private RadioButton itemRadio;
        private LinearLayout itemCompile;
        private LinearLayout itemDelete;
        private View content;

        public ViewHolder(View view) {
            itemReceiverName = (TextView) view.findViewById(R.id.item_receiver_name);
            itemReceiverPhone = (TextView) view.findViewById(R.id.item_receiver_phone);
            itemReceiverAddress = (TextView) view.findViewById(R.id.item_receiver_address);
            itemRadio = (RadioButton) view.findViewById(R.id.item_radio);
            itemCompile = (LinearLayout) view.findViewById(R.id.item_compile);
            itemDelete = (LinearLayout) view.findViewById(R.id.item_delete);
            content =  view.findViewById(R.id.content);
        }
    }
}
