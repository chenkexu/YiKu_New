package com.dexfun.yiku.activity.adapter;

import android.os.Bundle;
import android.widget.ListView;

import com.dexfun.yiku.R;
import com.dexfun.yiku.base.BaseActivity;
import com.dexfun.yiku.entity.HotWearPageEntity;
import com.dexfun.yiku.entity.SuitWithPage;
import com.dexfun.yiku.fragment.home.ItemAcAdapter;
import com.dexfun.yiku.fragment.home.ItemAcAdapter2;
import com.dexfun.yiku.service.impl.HttpServiceImpl;

import butterknife.BindView;

public class ArticleDetailsActivity extends BaseActivity {

    @BindView(R.id.list)
    ListView listView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_article_details;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

    }

    @Override
    public void getData(Bundle savedInstanceState) {
        if (getIntent().getIntExtra("type", 1) == 1) {
            setTitle("时尚穿搭");
            new HttpServiceImpl().hotWearPage(new HttpServiceImpl.OnObjectDataListener<HotWearPageEntity>() {
                @Override
                public void onData(HotWearPageEntity data) {
                    if (data.getStatus() == 200) {
                        listView.setAdapter(new ItemAcAdapter(ArticleDetailsActivity.this, data.getData().getContent()));
                    }
                }
            });
        } else if (getIntent().getIntExtra("type", 1) == 2) {
            setTitle("搭配成套");
            new HttpServiceImpl().suitWithPage(new HttpServiceImpl.OnObjectDataListener<SuitWithPage>() {
                @Override
                public void onData(SuitWithPage data) {
                    if (data.getStatus() == 200) {
                        listView.setAdapter(new ItemAcAdapter2(ArticleDetailsActivity.this, data.getData().getContent()));
                    }
                }
            });
        }

    }
}
