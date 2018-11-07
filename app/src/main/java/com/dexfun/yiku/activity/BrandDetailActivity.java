package com.dexfun.yiku.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dexfun.yiku.R;
import com.dexfun.yiku.base.BaseActivity;
import com.dexfun.yiku.entity.BrandCategoryEntity;
import com.dexfun.yiku.entity.BrandEntity;
import com.dexfun.yiku.entity.BrandListEntity;
import com.dexfun.yiku.entity.DetailEntity;
import com.dexfun.yiku.entity.FreshClothEntity;
import com.dexfun.yiku.entity.ProductListEntity;
import com.dexfun.yiku.fragment.home.ItemPushViewAdapter2;
import com.dexfun.yiku.service.impl.HttpServiceImpl;
import com.dexfun.yiku.widget.CustomGridView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BrandDetailActivity extends BaseActivity {

    @BindView(R.id.brand_image)
    ImageView brandImage;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.brand_icon)
    ImageView brandIcon;
    @BindView(R.id.brand_title)
    TextView brandTitle;
    @BindView(R.id.brand_dsc)
    TextView brandDsc;
    @BindView(R.id.brand_xl)
    TabLayout brandXl;
    @BindView(R.id.brand_list)
    CustomGridView brandList;
    @BindView(R.id.home_refresh)
    SmartRefreshLayout refreshLayout;
    List<BrandEntity.DataEntity.SecondLevelCategoryListEntity> secondLevelCategoryList;
    int page = 1, catId, brandId;
    ItemPushViewAdapter2 itemPushViewAdapter2;
    @BindView(R.id.title_w)
    TextView titleW;
    @Override
    public int getLayoutId() {
        return R.layout.activity_brand_detail;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        brandId = getIntent().getIntExtra("id", -1);
        brandList.setFocusable(false);
        itemPushViewAdapter2 = new ItemPushViewAdapter2(BrandDetailActivity.this, new ArrayList<>());
        brandList.setAdapter(itemPushViewAdapter2);
        refreshLayout.setRefreshHeader(new ClassicsHeader(this).setSpinnerStyle(SpinnerStyle.Translate));
        refreshLayout.setRefreshFooter(new ClassicsFooter(this).setSpinnerStyle(SpinnerStyle.Scale));
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                page++;
                new HttpServiceImpl().getFreshClothList(page, 6, 0,catId, 0, brandId, new HttpServiceImpl.OnObjectDataListener<FreshClothEntity>() {
                    @Override
                    public void onData(FreshClothEntity data) {
                        refreshlayout.finishLoadmore();
                        if (data.getData().size() == 0) {
                            page--;
                            Toast.makeText(BrandDetailActivity.this, "没有更多了", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        itemPushViewAdapter2.addObjects(data.getData());
                    }
                });
            }
        });

        brandList.setFocusable(false);
        back.setOnClickListener(view -> onBackPressed());
        brandList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(BrandDetailActivity.this, DetailActivity.class).putExtra("id", ((ItemPushViewAdapter2) brandList.getAdapter()).getItem(i).getClothingId()));
            }
        });

    }

    @Override
    public void getData(Bundle savedInstanceState) {
        new HttpServiceImpl().getBrandDetail(getIntent().getIntExtra("id", -1), new HttpServiceImpl.OnObjectDataListener<BrandEntity>() {
            @Override
            public void onData(BrandEntity data) {
                BrandListEntity brandDetail = data.getData().getBrandDetail();
                List<ProductListEntity> productList = data.getData().getProductList();
                secondLevelCategoryList = data.getData().getSecondLevelCategoryList();
                Picasso.get().load(brandDetail.getBrandLargeLogo()).into(brandIcon);
                Picasso.get().load(brandDetail.getBrandDetailImg()).into(brandImage);
                brandTitle.setText(brandDetail.getBrandName());
                titleW.setText(brandDetail.getBrandName());
                brandDsc.setText(brandDetail.getBrandDesc());
                brandXl.clearOnTabSelectedListeners();
                brandXl.removeAllTabs();
                for (BrandEntity.DataEntity.SecondLevelCategoryListEntity secondLevelCategoryListEntity : secondLevelCategoryList) {
                    brandXl.addTab(brandXl.newTab().setText(secondLevelCategoryListEntity.getCatName()));
                }
                itemPushViewAdapter2.setObjects(productList);
                brandXl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {

                        int position = tab.getPosition();
                        BrandEntity.DataEntity.SecondLevelCategoryListEntity secondLevelCategoryListEntity = secondLevelCategoryList.get(position);

                        catId = secondLevelCategoryListEntity.getCatId();
                        brandId = getIntent().getIntExtra("id", -1);
                        page = 1;
                        new HttpServiceImpl().getFreshClothList(page, 6,0, catId, 0, brandId, new HttpServiceImpl.OnObjectDataListener<FreshClothEntity>() {
                            @Override
                            public void onData(FreshClothEntity data) {
                                itemPushViewAdapter2.setObjects(data.getData());
                            }
                        });

//                        new HttpServiceImpl().getBrandPageByCategory(brandId, catId, new HttpServiceImpl.OnObjectDataListener<BrandCategoryEntity>() {
//                            @Override
//                            public void onData(BrandCategoryEntity data) {
//                                brandList.setAdapter(new ItemPushViewAdapter2(BrandDetailActivity.this, data.getProductListEntity()));
//
//                            }
//                        });

                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {

                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {

                    }
                });
                brandXl.post(() -> brandXl.setScrollPosition(0, 0, true));
            }
        });
    }
}
