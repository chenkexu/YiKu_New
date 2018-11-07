package com.dexfun.yiku.activity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.dexfun.yiku.R;
import com.dexfun.yiku.base.BaseActivity;
import com.dexfun.yiku.entity.ArticlesListEntity;
import com.dexfun.yiku.fragment.home.ItemCommunityAdapter;
import com.dexfun.yiku.service.impl.HttpServiceImpl;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;

import java.util.ArrayList;

import butterknife.BindView;

public class DetailCommunityActivity extends BaseActivity {

    Integer page = 1;
    Integer id = -1;
    ItemCommunityAdapter itemCommunityAdapter;
    @BindView(R.id.list)
    ListView list;
    @BindView(R.id.home_refresh)
    SmartRefreshLayout refreshLayout;

    @Override
    public int getLayoutId() {
        return R.layout.activity_detail_community;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setTitle("晒图评论");
        id = getIntent().getIntExtra("id",-1);
        itemCommunityAdapter = new ItemCommunityAdapter(this, new ArrayList<>(), 0);
        list.setAdapter(itemCommunityAdapter);

        refreshLayout.setRefreshFooter(new ClassicsFooter(this).setSpinnerStyle(SpinnerStyle.Scale));
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                page++;
                getData(null);
            }
        });
    }

    @Override
    public void getData(Bundle savedInstanceState) {

        new HttpServiceImpl().getArticlesList(page, 10, 0, id,0, 0,new HttpServiceImpl.OnObjectDataListener<ArticlesListEntity>() {
            @Override
            public void onData(ArticlesListEntity data) {
                refreshLayout.finishLoadmore();
                if (data.getStatus() == 200) {
                    if (data.getData().getArticleVOS().size() == 0) {
                        page--;
                        Toast.makeText(DetailCommunityActivity.this, "没有更多了", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    itemCommunityAdapter.addData(data.getData().getArticleVOS());
                }

            }
        });
    }
}
