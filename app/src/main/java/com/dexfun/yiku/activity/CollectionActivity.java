package com.dexfun.yiku.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.chow.module.share.Setting;
import com.dexfun.yiku.HomeActivity;
import com.dexfun.yiku.MainClass;
import com.dexfun.yiku.R;
import com.dexfun.yiku.base.BaseActivity;
import com.dexfun.yiku.entity.AddCartEntity;
import com.dexfun.yiku.entity.AddToCartDOTO;
import com.dexfun.yiku.entity.CollectionEntity;
import com.dexfun.yiku.entity.DefaultEntity;
import com.dexfun.yiku.entity.DeleteKnapsackDOTO;
import com.dexfun.yiku.entity.KnapsacEntry;
import com.dexfun.yiku.entity.MainDexEvent;
import com.dexfun.yiku.fragment.knapsack.ItemCollectionAdapter;
import com.dexfun.yiku.fragment.knapsack.ItemKnapsackAdapter;
import com.dexfun.yiku.service.impl.HttpServiceImpl;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Smile
 */
public class CollectionActivity extends BaseActivity {

    @BindView(R.id.list)
    ListView list;
    @BindView(R.id.include_right_btn)
    TextView includeRightBtn;
    @BindView(R.id.all)
    Button all;
    @BindView(R.id.go)
    Button go;
    ItemCollectionAdapter itemCollectionAdapter;

    @BindView(R.id.en_view)
    View en_view;

    @Override
    public int getLayoutId() {
        return R.layout.activity_collection;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setTitle("收藏夹");
        includeRightBtn.setText("删除");
    }

    @Override
    public void getData(Bundle savedInstanceState) {
        new HttpServiceImpl().getCollectionFolder(new HttpServiceImpl.OnObjectDataListener<CollectionEntity>() {
            @Override
            public void onData(CollectionEntity data) {
                if (data.getData().isEmpty()) {
                    en_view.setVisibility(View.VISIBLE);
                    findViewById(R.id.button_view).setVisibility(View.GONE);
                } else {
                    en_view.setVisibility(View.GONE);
                    findViewById(R.id.button_view).setVisibility(View.VISIBLE);
                }
                itemCollectionAdapter = new ItemCollectionAdapter(CollectionActivity.this,CollectionActivity.this, data.getData());
                list.setAdapter(itemCollectionAdapter);
            }
        });
    }

    @OnClick({R.id.all, R.id.go, R.id.include_right_btn, R.id.rebtn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.all:
                itemCollectionAdapter.setAllIndexClothing();
                break;
            case R.id.go:
                ArrayList<CollectionEntity.DataEntity> indexClothing = itemCollectionAdapter.getIndexClothing();
                if (indexClothing.isEmpty()) {
                    Toast.makeText(this, "请先选择", Toast.LENGTH_SHORT).show();
                    return;
                }
                List<AddToCartDOTO> addToCartDOTOS = new ArrayList<>();
                for (CollectionEntity.DataEntity dataEntity : indexClothing) {
                    int clothingId = dataEntity.getClothingId();
                    int stockType = dataEntity.getClothingStockId();
                    addToCartDOTOS.add(new AddToCartDOTO(clothingId, stockType));
                }
                new HttpServiceImpl().batchAddition(addToCartDOTOS, new HttpServiceImpl.OnObjectDataListener<AddCartEntity>() {
                    @Override
                    public void onData(AddCartEntity data) {
                        Toast.makeText(CollectionActivity.this, data.getData(), Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case R.id.include_right_btn:
                if (itemCollectionAdapter != null) {
                    if (itemCollectionAdapter.getIndexClothing().isEmpty()) {
                        Toast.makeText(this, "所选内容不能为空", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                new AlertDialog.Builder(this).setTitle("提示").setMessage("是否删除收藏内容").setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        List<String> list = new ArrayList<>();
                        if (itemCollectionAdapter != null) {
                            for (CollectionEntity.DataEntity dataBean : itemCollectionAdapter.getIndexClothing()) {
                                String shoppingCartId = dataBean.getCollectionId();
                                list.add(shoppingCartId);
                            }
                            if (list.isEmpty()) {
                                Toast.makeText(CollectionActivity.this, "所选内容不能为空", Toast.LENGTH_SHORT).show();
                                return;
                            }
                            new HttpServiceImpl().deleteCollection(list, new HttpServiceImpl.OnObjectDataListener<DefaultEntity>() {
                                @Override
                                public void onData(DefaultEntity data) {
                                    getData(null);
                                }
                            });
                        }
                    }
                }).show();
                break;
            case R.id.rebtn:
                MainClass.finishActivityPassThis(HomeActivity.class);
                EventBus.getDefault().post(new MainDexEvent(1));
                break;
        }
    }
}
