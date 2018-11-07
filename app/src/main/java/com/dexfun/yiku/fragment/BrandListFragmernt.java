package com.dexfun.yiku.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.dexfun.yiku.R;
import com.dexfun.yiku.activity.BrandDetailActivity;
import com.dexfun.yiku.activity.WebViewActivity;
import com.dexfun.yiku.activity.adapter.ItemBrandListAdapter;
import com.dexfun.yiku.base.BaseFragment;
import com.dexfun.yiku.entity.BrandAllListEntity;
import com.dexfun.yiku.service.impl.HttpServiceImpl;
import com.dexfun.yiku.widget.CustomListView;
import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.BindView;

public class BrandListFragmernt extends BaseFragment {


    @BindView(R.id.loop_viewpager_arc)
    ConvenientBanner convenientBanner;
    @BindView(R.id.list_detail)
    CustomListView listDetail;
    @BindView(R.id.title_view)
    View titleView;


    @Override
    public int getLayoutId() {
        return R.layout.activity_brand_list;
    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {
        titleView.setVisibility(View.GONE);
        listDetail.setFocusable(false);
    }


    @Override
    public void getData(View view, Bundle savedInstanceState) {


    }

    public class LocalImageHolderView implements Holder<BrandAllListEntity.DataEntity.BrandBannerImgListEntity> {
        private ImageView imageView;


        @Override
        public void UpdateUI(Context context, int position, BrandAllListEntity.DataEntity.BrandBannerImgListEntity data) {

            Picasso.get().load(data.getBrandImgUrl()).into(imageView);
        }

        @Override
        public View createView(Context context) {
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            return imageView;
        }
    }

    public class LetterComparator implements Comparator<BrandAllListEntity.DataEntity.BrandVoListEntity> {

        @Override
        public int compare(BrandAllListEntity.DataEntity.BrandVoListEntity l, BrandAllListEntity.DataEntity.BrandVoListEntity r) {
            if (l == null || r == null) {
                return 0;
            }

            String lhsSortLetters = l.getBrandName().substring(0, 1).toUpperCase();
            String rhsSortLetters = r.getBrandName().substring(0, 1).toUpperCase();
            if (lhsSortLetters == null || rhsSortLetters == null) {
                return 0;
            }
            return lhsSortLetters.compareTo(rhsSortLetters);
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            new HttpServiceImpl().getBrandList(data -> {
                if (data.getStatus() != 200) {
                    return;
                }

                List<BrandAllListEntity.DataEntity.BrandVoListEntity> brandVoList = data.getData().getBrandVoList();
                Collections.sort(brandVoList, new LetterComparator());
                listDetail.setAdapter(new ItemBrandListAdapter(getContext(), brandVoList));
                listDetail.setOnItemClickListener((parent, view1, position, id)
                        -> startActivity(new Intent(getContext(), BrandDetailActivity.class)
                        .putExtra("id", brandVoList.get(position).getBrandId())));
                if (data.getData().getBrandBannerImgList().size() == 0) {
                    return;
                }

                convenientBanner.setPages(() -> new LocalImageHolderView(), data.getData().getBrandBannerImgList());
                convenientBanner.startTurning(2000);
                convenientBanner.setPageIndicator(new int[]{R.drawable.ic_page_indicator, R.drawable.ic_page_indicator_focused});

                convenientBanner.setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {
                        startActivity(new Intent(getContext(), WebViewActivity.class).putExtra("url", data.getData().getBrandBannerImgList().get(position).getBrandImgUrl()));
                    }
                });


            });
        }
    }
}
