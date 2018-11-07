package com.dexfun.yiku.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.dexfun.yiku.R;
import com.dexfun.yiku.activity.PSDetailActivity;
import com.dexfun.yiku.base.BaseFragment;
import com.dexfun.yiku.entity.OrnamentEntity;
import com.dexfun.yiku.fragment.home.ItemOrnamentsAdapter;
import com.dexfun.yiku.service.impl.HttpServiceImpl;
import com.dexfun.yiku.widget.GridViewWithHeaderAndFooter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * @author Smile
 */
public class OrnamentsFragment extends BaseFragment {

    @BindView(R.id.grid_view)
    GridViewWithHeaderAndFooter gridViewWithHeaderAndFooter;
    @BindView(R.id.home_refresh)
    SmartRefreshLayout refreshLayout;

    ItemOrnamentsAdapter itemOrnamentsAdapter;

    int page = 1;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_ornaments;
    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {
        itemOrnamentsAdapter = new ItemOrnamentsAdapter(getContext(), new ArrayList<>());
        gridViewWithHeaderAndFooter.setAdapter(itemOrnamentsAdapter);
        refreshLayout.setRefreshHeader(new ClassicsHeader(getContext()).setSpinnerStyle(SpinnerStyle.Translate));
        refreshLayout.setRefreshFooter(new ClassicsFooter(getContext()).setSpinnerStyle(SpinnerStyle.Scale));
        gridViewWithHeaderAndFooter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getContext(), PSDetailActivity.class).putExtra("id", itemOrnamentsAdapter.getItem(position).getClothingId()));
            }
        });
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                page++;
                getData(null, null);
            }
        });
    }

    @Override
    public void getData(View view, Bundle savedInstanceState) {
        new HttpServiceImpl().getOrnamentPage(page, 10, new HttpServiceImpl.OnObjectDataListener<OrnamentEntity>() {
            @Override
            public void onData(OrnamentEntity data) {
                if (refreshLayout.isLoading()) {
                    refreshLayout.finishLoadmore();
                }
                if (data.getStatus() == 200) {
                    if (data.getData().isEmpty()) {
                        Toast.makeText(getContext(), "没有更多了", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    itemOrnamentsAdapter.addObjects(data.getData());

                }
            }
        });
    }
}
