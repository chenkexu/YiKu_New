package com.dexfun.yiku.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.dexfun.yiku.R;
import com.dexfun.yiku.base.BaseActivity;
import com.dexfun.yiku.entity.PopularityClothingPage;
import com.dexfun.yiku.entity.SuitWithPage;
import com.dexfun.yiku.fragment.home.ItemPushViewAdapter3;
import com.dexfun.yiku.service.impl.HttpServiceImpl;

import butterknife.BindView;

public class RenQiActivity extends BaseActivity {

    @BindView(R.id.grid_view)
    GridView gridView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_ren_qi;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

    }

    @Override
    public void getData(Bundle savedInstanceState) {
        if (getIntent().getIntExtra("type", 1) == 1) {
            setTitle("人气美衣");
            new HttpServiceImpl().popularityClothingPage("1", new HttpServiceImpl.OnObjectDataListener<PopularityClothingPage>() {
                @Override
                public void onData(PopularityClothingPage data) {
                    if (data.getStatus() == 200) {
                        gridView.setAdapter(new ItemPushViewAdapter3(RenQiActivity.this, data.getData().getContent()));
                    }
                }
            });
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    PopularityClothingPage.DataEntity.ContentEntity contentEntity = (PopularityClothingPage.DataEntity.ContentEntity) parent.getItemAtPosition(position);
                    int clothingId = contentEntity.getClothingId();
                    startActivity(new Intent(RenQiActivity.this, DetailActivity.class).putExtra("id", clothingId));
                }
            });
        } else {
            setTitle("人气配饰");
            new HttpServiceImpl().popularityClothingPage("2", new HttpServiceImpl.OnObjectDataListener<PopularityClothingPage>() {
                @Override
                public void onData(PopularityClothingPage data) {
                    gridView.setAdapter(new ItemPushViewAdapter3(RenQiActivity.this, data.getData().getContent()));
                }
            });
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    PopularityClothingPage.DataEntity.ContentEntity contentEntity = (PopularityClothingPage.DataEntity.ContentEntity) parent.getItemAtPosition(position);
                    int clothingId = contentEntity.getClothingId();
                    startActivity(new Intent(RenQiActivity.this, PSDetailActivity.class).putExtra("id", clothingId));
                }
            });
        }
    }
}
