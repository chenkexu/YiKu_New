package com.dexfun.yiku.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.dexfun.yiku.R;
import com.dexfun.yiku.activity.adapter.ItemArticleAdapter;
import com.dexfun.yiku.base.BaseActivity;
import com.dexfun.yiku.entity.ChooseClothesEntity;
import com.dexfun.yiku.service.impl.HttpServiceImpl;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class AddArticleActivity extends BaseActivity {

    ItemArticleAdapter itemArticleAdapter;
    @BindView(R.id.grid_view)
    ListView gridView;
    @BindView(R.id.home_refresh)
    SmartRefreshLayout refreshLayout;
    int page = 1;

    @Override
    public int getLayoutId() {
        return R.layout.activity_add_article;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setTitle("选择衣服");
        refreshLayout.setRefreshHeader(new ClassicsHeader(this).setSpinnerStyle(SpinnerStyle.Translate));
        refreshLayout.setRefreshFooter(new ClassicsFooter(this).setSpinnerStyle(SpinnerStyle.Scale));
        itemArticleAdapter = new ItemArticleAdapter(AddArticleActivity.this, new ArrayList<>());
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View headerView = inflater.inflate(R.layout.add_article_header_view, null);
        headerView.setEnabled(false);
        gridView.addHeaderView(headerView);
        gridView.setAdapter(itemArticleAdapter);
//        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
//            @Override
//            public void onLoadmore(RefreshLayout refreshlayout) {
//                page++;
//                getData(null);
//            }
//        });
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) return;
                ChooseClothesEntity.DataEntity item = itemArticleAdapter.getItem(position - 1);
                startActivity(new Intent(AddArticleActivity.this, PushArticleActivity.class)
                        .putExtra("id", item.getClothingId())
                        .putExtra("idx", getIntent().getIntExtra("idx", 0)));
            }
        });
    }

    @Override
    public void getData(Bundle savedInstanceState) {
        new HttpServiceImpl().getChooseClothes(page, 10, new HttpServiceImpl.OnObjectDataListener<ChooseClothesEntity>() {
            @Override
            public void onData(ChooseClothesEntity data) {
                if (refreshLayout.isLoading()) {
                    refreshLayout.finishLoadmore();
                }
                if (data.getStatus() == 200) {
                    if (data.getData().size() != 0) {
                        itemArticleAdapter.addObjects(data.getData());
                    } else {
                        page--;
                        Toast.makeText(AddArticleActivity.this, "没有更多了", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    page--;
                }
            }
        });
    }
}
