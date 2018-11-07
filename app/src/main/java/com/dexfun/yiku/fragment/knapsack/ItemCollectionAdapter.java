package com.dexfun.yiku.fragment.knapsack;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.dexfun.yiku.R;
import com.dexfun.yiku.activity.CollectionActivity;
import com.dexfun.yiku.activity.DetailActivity;
import com.dexfun.yiku.activity.PSDetailActivity;
import com.dexfun.yiku.activity.getAddCardActivity;
import com.dexfun.yiku.entity.AddCartEntity;
import com.dexfun.yiku.entity.CollectionEntity;
import com.dexfun.yiku.entity.DefaultEntity;
import com.dexfun.yiku.entity.KnapsacEntry;
import com.dexfun.yiku.entity.MainDexEvent;
import com.dexfun.yiku.entity.QueryAddClothingVoucher;
import com.dexfun.yiku.service.impl.HttpServiceImpl;
import com.dexfun.yiku.widget.SwipeMenuLayout;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

public class ItemCollectionAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<CollectionEntity.DataEntity> indexClothing = new ArrayList<>();
    private List<CollectionEntity.DataEntity> objects = new ArrayList<>();
    CollectionActivity collectionActivity;

    public ArrayList<CollectionEntity.DataEntity> getIndexClothing() {
        return indexClothing;
    }

    public void setAllIndexClothing() {
        if (indexClothing.size() > 0) {
            this.indexClothing.clear();
        } else {
            this.indexClothing.clear();
            indexClothing.addAll(objects);
        }
        notifyDataSetChanged();
    }

    public void setIndexClothing() {
        this.indexClothing.clear();
        notifyDataSetChanged();
    }

    public ItemCollectionAdapter(CollectionActivity collectionActivity, Context context, List<CollectionEntity.DataEntity> list) {
        this.collectionActivity = collectionActivity;
        this.objects = list;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    public void setObjects(List<CollectionEntity.DataEntity> objects) {
        this.objects.clear();
        indexClothing.clear();
        this.objects.addAll(objects);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public CollectionEntity.DataEntity getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_knapsack, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews(getItem(position), (ViewHolder) convertView.getTag(), position);
        return convertView;
    }

    private void initializeViews(CollectionEntity.DataEntity object, ViewHolder holder, int position) {
        holder.checkbox.setOnCheckedChangeListener(null);
        holder.checkbox.setChecked(indexClothing.contains(object));

        Glide.with(context).load(object.getClothingImgUrl()).into(holder.imgIcon);

        holder.tvTitle.setText(object.getClothingName());
        holder.tvBrandTitle.setText(object.getClothingBrandName());
        holder.tvXl.setText(object.getStockType());
        holder.tvPrice.setText(String.valueOf(object.getClothingPrice()));
        if (object.getStockNumber() == 0) {
            holder.checkbox.setEnabled(false);
            holder.tv_st.setVisibility(View.VISIBLE);
            holder.tv_st.setText("库存不足");
        } else {
            holder.tv_st.setVisibility(View.INVISIBLE);
            holder.tv_st.setText("");
            holder.checkbox.setEnabled(true);
        }
        holder.viDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int shoppingCartId = object.getClothingId();
                holder.swipeMenu.smoothClose();
                new HttpServiceImpl().deleteCollectionByClothingId(shoppingCartId, new HttpServiceImpl.OnObjectDataListener<AddCartEntity>() {
                    @Override
                    public void onData(AddCartEntity data) {
                        if (data.getStatus() == 200) {
                            objects.remove(object);
                            notifyDataSetChanged();
                            Toast.makeText(context, "删除成功", Toast.LENGTH_SHORT).show();
                            if (objects.isEmpty())
                                collectionActivity.getData(null);
                        } else {
                            Toast.makeText(context, "删除失败", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        holder.content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                if (object.getClassify() == 1) {
                    intent = new Intent(context, DetailActivity.class);
                } else {
                    intent = new Intent(context, PSDetailActivity.class);
                }
                intent.putExtra("id", object.getClothingId());
                context.startActivity(intent);
            }
        });

        holder.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    indexClothing.add(object);

                } else {
                    if (indexClothing.contains(object)) {
                        indexClothing.remove(object);
                    }

                }

            }
        });
    }


    protected class ViewHolder {
        private CheckBox checkbox;
        private ImageView imgIcon;
        private View content;
        private TextView tvTitle;
        private TextView tvBrandTitle;
        private TextView tvXl;
        private TextView tvPrice;
        private TextView tv_st;
        private View viDelete;
        private SwipeMenuLayout swipeMenu;

        public ViewHolder(View view) {
            checkbox = view.findViewById(R.id.checkbox);
            imgIcon = view.findViewById(R.id.img_icon);
            content = view.findViewById(R.id.content);
            tvTitle = view.findViewById(R.id.tv_title);
            tvBrandTitle = view.findViewById(R.id.tv_brand_title);
            tvXl = view.findViewById(R.id.tv_xl);
            tvPrice = view.findViewById(R.id.tv_price);
            viDelete = view.findViewById(R.id.vi_delete);
            swipeMenu = view.findViewById(R.id.swipe_menu);
            tv_st = view.findViewById(R.id.tv_st);
        }
    }
}
