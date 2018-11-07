package com.dexfun.yiku.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.dexfun.yiku.R;
import com.dexfun.yiku.base.BaseActivity;
import com.dexfun.yiku.entity.ArticlesListEntity;
import com.dexfun.yiku.entity.AttentionListEntity;
import com.dexfun.yiku.entity.CommunityActivityEntity;
import com.dexfun.yiku.fragment.CommunityFragment;
import com.dexfun.yiku.fragment.home.ItemCommunityAdapter;
import com.dexfun.yiku.service.impl.HttpServiceImpl;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * @author Smile
 */
public class ActivitiesActivity extends BaseActivity {

    @BindView(R.id.list)
    ListView listView;

    private android.widget.ImageView icon;
    private android.widget.TextView tvtitle;
    private android.widget.Button btngo;
    private android.widget.TextView tvsubtitle;
    ItemCommunityAdapter itemCommunityAdapter;
    int page = 1;

    @BindView(R.id.home_refresh1)
    SmartRefreshLayout refreshLayout;

    @Override
    public int getLayoutId() {
        return R.layout.activity_activities;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setTitle("活动详情");
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View headerView = inflater.inflate(R.layout.view_activityes_header, null);
        this.tvsubtitle = (TextView) headerView.findViewById(R.id.tv_sub_title);
        this.btngo = (Button) headerView.findViewById(R.id.btn_go);
        this.tvtitle = (TextView) headerView.findViewById(R.id.tv_title);
        this.icon = (ImageView) headerView.findViewById(R.id.icon);
        listView.addHeaderView(headerView);
        itemCommunityAdapter = new ItemCommunityAdapter(this, new ArrayList<>(), 1);
        listView.setAdapter(itemCommunityAdapter);
        refreshLayout.setRefreshHeader(new ClassicsHeader(this).setSpinnerStyle(SpinnerStyle.Translate));
        refreshLayout.setRefreshFooter(new ClassicsFooter(this).setSpinnerStyle(SpinnerStyle.Scale));

        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                page++;
                getFreshClothList();
            }
        });

        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                page = 1;
                getFreshClothList();
            }
        });
        btngo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivitiesActivity.this, AddArticleActivity.class).putExtra("idx", getIntent().getIntExtra("id", 0)));
            }
        });
    }

    @Override
    public void getData(Bundle savedInstanceState) {
        new HttpServiceImpl().getCommunityActivity(new HttpServiceImpl.OnObjectDataListener<CommunityActivityEntity>() {
            @Override
            public void onData(CommunityActivityEntity data) {
                if (data.getStatus() == 200) {
                    CommunityActivityEntity.DataEntity dataData = data.getData();
                    tvtitle.setText(dataData.getActivityLabel());
                    tvsubtitle.setText(dataData.getActivityExplain());
                    Picasso.get().load(dataData.getExampleDiagram()).into(icon);
                }
            }
        });
        getFreshClothList();
    }

    private void getFreshClothList() {
        new HttpServiceImpl().getAttentionList(new HttpServiceImpl.OnObjectDataListener<AttentionListEntity>() {
            @Override
            public void onData(AttentionListEntity data) {
                if (data.getStatus() == 200) {
                    CommunityFragment.dataData = data.getData();
                } else {
                    CommunityFragment.dataData = new ArrayList<>();
                }
                new HttpServiceImpl().getArticlesList(page, 10, 0, -1, 0, getIntent().getIntExtra("id", 0), new HttpServiceImpl.OnObjectDataListener<ArticlesListEntity>() {
                    @Override
                    public void onData(ArticlesListEntity data) {
                        if (refreshLayout.isLoading()) {
                            refreshLayout.finishLoadmore();
                        }
                        if (refreshLayout.isRefreshing()) {
                            refreshLayout.finishRefresh();
                        }
                        if (data.getStatus() == 200) {
                            if (data.getData().getArticleVOS().size() == 0) {
                                page--;
                                Toast.makeText(ActivitiesActivity.this, "没有更多了", Toast.LENGTH_SHORT).show();
                                return;
                            }
                            itemCommunityAdapter.addData(data.getData().getArticleVOS(), page);
                        }

                    }
                });
            }
        });
    }

}
