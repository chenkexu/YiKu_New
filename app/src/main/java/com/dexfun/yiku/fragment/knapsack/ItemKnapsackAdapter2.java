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

import com.dexfun.yiku.R;
import com.dexfun.yiku.activity.DetailActivity;
import com.dexfun.yiku.activity.PSDetailActivity;
import com.dexfun.yiku.activity.ShoppingCartActivity;
import com.dexfun.yiku.activity.getAddCardActivity;
import com.dexfun.yiku.entity.DefaultEntity;
import com.dexfun.yiku.entity.KnapsacEntry;
import com.dexfun.yiku.entity.MainDexEvent;
import com.dexfun.yiku.entity.QueryAddClothingVoucher;
import com.dexfun.yiku.fragment.CurrentKnapsackFragment;
import com.dexfun.yiku.service.impl.HttpServiceImpl;
import com.dexfun.yiku.widget.SwipeMenuLayout;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

public class ItemKnapsackAdapter2 extends BaseAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    //    private ArrayList<KnapsacEntry.DataEntity> indexClothing = new ArrayList<>();
    private List<KnapsacEntry.DataEntity> objects = new ArrayList<>();

    //    private int maxNumber = 3;
//
//    public ArrayList<KnapsacEntry.DataEntity> getIndexClothing() {
//        return indexClothing;
//    }
//
//    public void setAllIndexClothing() {
//        if (indexClothing.size() > 0) {
//            this.indexClothing.clear();
//        } else {
//            this.indexClothing.clear();
//            indexClothing.addAll(objects);
//        }
//        notifyDataSetChanged();
//    }
//
//    public void setIndexClothing() {
//        this.indexClothing.clear();
//        notifyDataSetChanged();
//    }
    ShoppingCartActivity cartActivity;
    CurrentKnapsackFragment currentKnapsackFragment;


    public ItemKnapsackAdapter2(ShoppingCartActivity cartActivity, Context context, List<KnapsacEntry.DataEntity> list) {
        this.cartActivity = cartActivity;
        this.objects = list;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    public ItemKnapsackAdapter2(CurrentKnapsackFragment currentKnapsackFragment, Context context, List<KnapsacEntry.DataEntity> objects) {
        this.currentKnapsackFragment = currentKnapsackFragment;
        this.objects = objects;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    public void setObjects(List<KnapsacEntry.DataEntity> objects) {
        this.objects.clear();
//        indexClothing.clear();
        this.objects.addAll(objects);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public KnapsacEntry.DataEntity getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.view_item, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews(getItem(position), (ViewHolder) convertView.getTag(), position);
        return convertView;
    }

    private void initializeViews(KnapsacEntry.DataEntity object, ViewHolder holder, int position) {
//        holder.checkbox.setOnCheckedChangeListener(null);
//        holder.checkbox.setChecked(indexClothing.contains(object));
        holder.tv_st.setText(String.format("占%s个衣位", String.valueOf(object.getOccupySeat())));
        Picasso.get().load(object.getClothingImgUrl()).into(holder.imgIcon);

        holder.tvTitle.setText(object.getClothingName());
        holder.tvBrandTitle.setText(object.getClothingBrandName());
        holder.tvXl.setText(object.getClothingStockType());
        holder.tvPrice.setText(String.valueOf(object.getClothingPrice()));
        if (object.getClothingStockNum() == 0) {
//            holder.checkbox.setEnabled(false);
            holder.tv_st.setVisibility(View.VISIBLE);
            holder.tv_st.setText("库存不足");
        } else {
            holder.tv_st.setVisibility(View.INVISIBLE);
            holder.tv_st.setText("");
//            holder.checkbox.setEnabled(true);
        }
        if (object.isCopy()) {
            holder.viDelete.setVisibility(View.GONE);
            holder.copy.setVisibility(View.VISIBLE);
        } else {
            holder.viDelete.setVisibility(View.VISIBLE);
            holder.copy.setVisibility(View.GONE);
        }
        int occupySeat = object.getOccupySeat();
        holder.yiwei.setText(String.format("占%d个衣位", occupySeat));
        holder.viDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int shoppingCartId = object.getShoppingCartId();
                new HttpServiceImpl().deleteClothingToCart(shoppingCartId, new HttpServiceImpl.OnObjectDataListener<DefaultEntity>() {
                    @Override
                    public void onData(DefaultEntity data) {
                        if (data.getStatus() == 200) {
                            objects.remove(object);
                            notifyDataSetChanged();
                            Toast.makeText(context, "删除成功", Toast.LENGTH_SHORT).show();
                            if (cartActivity != null) {
                                cartActivity.getData(null, null);
                            }
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

//        holder.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                int clothingId = object.getClothingId();
//                if (b) {
//                    if (indexClothing.size() >= maxNumber) {
//                        //提示不能再选，设置当前选中的都设为false
////                        compoundButton.setChecked(false);
////                        new AlertDialog.Builder(context).setTitle("提示").setMessage("使用加衣券可以提高单次下单数量哦")
////                                .setPositiveButton("去使用or购买", new DialogInterface.OnClickListener() {
////                                    @Override
////                                    public void onClick(DialogInterface dialog, int which) {
////                                        new HttpServiceImpl().queryAddClothingVoucher(new HttpServiceImpl.OnObjectDataListener<QueryAddClothingVoucher>() {
////                                            @Override
////                                            public void onData(QueryAddClothingVoucher data) {
////                                                if (data.getStatus() == 200 && data.getData() != null) {
////                                                    if (!data.getData().isEmpty()) {
////                                                        Toast.makeText(context, "勾选左下角使用加衣券即可使用", Toast.LENGTH_SHORT).show();
////                                                    } else {
////                                                        context.startActivity(new Intent(context, getAddCardActivity.class));
////                                                    }
////                                                }
////                                            }
////                                        });
////                                    }
////                                }).setNegativeButton("下次再说", new DialogInterface.OnClickListener() {
////                            @Override
////                            public void onClick(DialogInterface dialog, int which) {
////                                dialog.cancel();
////                            }
////                        }).show();
//                    } else {
//                        indexClothing.add(object);
//                    }
//
//                } else {
//                    if (indexClothing.contains(object)) {
//                        indexClothing.remove(object);
//                    }
//
//                }
//
//            }
//        });
//        holder.checkbox.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                CheckBox checkbox = holder.checkbox;
//                int clothingId = object.getClothingId();
//
//                if (checkbox.isChecked()) {
//
//                    if (indexClothingId.size() >= 3) {
//                        //提示不能再选，设置当前选中的都设为false
//                        checkbox.setChecked(false);
//                        Toast.makeText(context, "只能选择3件商品", Toast.LENGTH_SHORT).show();
//                    } else {
//                        indexClothingId.add(clothingId);
//                    }
//
//                } else {
//                    if (indexClothingId.contains(object.getClothingId())) {
//                        indexClothingId.remove(Integer.valueOf(clothingId));
//                    }
//
//                }
//
//            }
//        });
    }
//
//    public int getMaxNumber() {
//        return maxNumber;
//    }
//
//    public void setMaxNumber(int maxNumber) {
//        this.maxNumber = maxNumber;
//    }

    protected class ViewHolder {

        private ImageView imgIcon;
        private View content;
        private TextView tvTitle;
        private TextView tvBrandTitle;
        private TextView tvXl;
        private TextView tvPrice;
        private TextView tv_st;
        private TextView yiwei;
        private View viDelete;
        private View copy;


        public ViewHolder(View view) {

            imgIcon = view.findViewById(R.id.img_icon);
            copy = view.findViewById(R.id.copy);
            content = view.findViewById(R.id.content);
            tvTitle = view.findViewById(R.id.tv_title);
            tvBrandTitle = view.findViewById(R.id.tv_brand_title);
            tvXl = view.findViewById(R.id.tv_xl);
            tvPrice = view.findViewById(R.id.tv_price);
            yiwei = view.findViewById(R.id.yiwei);
            viDelete = view.findViewById(R.id.delete);
            tv_st = view.findViewById(R.id.tv_st);
        }
    }
}
