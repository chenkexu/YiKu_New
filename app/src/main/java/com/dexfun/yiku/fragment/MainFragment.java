package com.dexfun.yiku.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Toast;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.dexfun.yiku.R;
import com.dexfun.yiku.activity.BuyCardActivity;
import com.dexfun.yiku.activity.DetailActivity;
import com.dexfun.yiku.activity.InviteActivity;
import com.dexfun.yiku.activity.MessageActivity;
import com.dexfun.yiku.activity.RenQiActivity;
import com.dexfun.yiku.activity.WebViewActivity;
import com.dexfun.yiku.activity.adapter.ArticleDetailsActivity;
import com.dexfun.yiku.base.BaseFragment;
import com.dexfun.yiku.entity.ArticlesHomePageEntity;
import com.dexfun.yiku.entity.FreshClothEntity;
import com.dexfun.yiku.entity.HOME_ENTITY;
import com.dexfun.yiku.entity.HomeEntity;
import com.dexfun.yiku.entity.MainDexEvent;

import com.dexfun.yiku.fragment.home.ItemCnmbAdapter;
import com.dexfun.yiku.fragment.home.ItemCnmbAdapter2;
import com.dexfun.yiku.fragment.home.ItemCommunityAdapter;
import com.dexfun.yiku.fragment.home.ItemHomeViewAdapter;
import com.dexfun.yiku.fragment.home.ItemPushViewAdapter;
import com.dexfun.yiku.fragment.home.ItemRecyclerCnmmbAdapter;
import com.dexfun.yiku.fragment.home.ItemRecyclerCnmmbAdapter2;
import com.dexfun.yiku.fragment.home.RecyclerLayoutAdapter;
import com.dexfun.yiku.fragment.home.TabAdapter;
import com.dexfun.yiku.service.impl.HttpServiceImpl;
import com.dexfun.yiku.widget.CustomListView;
import com.dexfun.yiku.widget.GridViewWithHeaderAndFooter;
import com.dexfun.yiku.widget.ScaleRecyclerViewPager;
import com.dexfun.yiku.widget.ViewPagerForScrollView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


public class MainFragment extends BaseFragment {


    //    @BindView(R.id.loop_viewpager_arc)
    ConvenientBanner convenientBanner;

    //    @BindView(R.id.brand_list)
    RecyclerView brandList;
    View footerBar;
    View footerBtn;

    @BindView(R.id.grid_view)
    GridViewWithHeaderAndFooter gridView;
    @BindView(R.id.home_refresh)
    SmartRefreshLayout refreshLayout;
    ItemPushViewAdapter itemPushViewAdapter;
    int page = 1;


    private ImageView suitWithImage, fashionWearsImage;
    private CustomListView customListView;
    //    private RecyclerView recyclerView, recyclerView1;
    private View rq_1, rq_2, rq_3;
    private View ps_1, ps_2, ps_3;
    //    private ScaleRecyclerViewPager hotWear;
    private ViewPagerForScrollView viewPager1, viewPager2;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View headerView = inflater.inflate(R.layout.view_home_header, null);
        View foot = inflater.inflate(R.layout.view_home_footer, null);
        footerBar = foot.findViewById(R.id.footer_bar);
        footerBtn = foot.findViewById(R.id.footer_btn);
        footerBar.setVisibility(View.GONE);
        footerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new MainDexEvent(1));
//                Toast.makeText(getContext(), "ddd", Toast.LENGTH_SHORT).show();
            }
        });
        convenientBanner = headerView.findViewById(R.id.loop_viewpager_arc);
        brandList = headerView.findViewById(R.id.brand_list);
        suitWithImage = headerView.findViewById(R.id.dpct);
        fashionWearsImage = headerView.findViewById(R.id.sscd);
        customListView = headerView.findViewById(R.id.sqst);
        viewPager1 = headerView.findViewById(R.id.rqmy);
        viewPager2 = headerView.findViewById(R.id.rqps);
        rq_1 = headerView.findViewById(R.id.rq_1);
        rq_2 = headerView.findViewById(R.id.rq_2);
        rq_3 = headerView.findViewById(R.id.rq_3);
        ps_1 = headerView.findViewById(R.id.ps_1);
        ps_2 = headerView.findViewById(R.id.ps_2);
        ps_3 = headerView.findViewById(R.id.ps_3);

        headerView.findViewById(R.id.sscd_vi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), ArticleDetailsActivity.class).putExtra("type", 1));
            }
        });
        headerView.findViewById(R.id.banner).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), BuyCardActivity.class));
            }
        });
        headerView.findViewById(R.id.dpct_vi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), ArticleDetailsActivity.class).putExtra("type", 2));
            }
        });
        headerView.findViewById(R.id.rqmy_vi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), RenQiActivity.class).putExtra("type", 1));
            }
        });
        headerView.findViewById(R.id.rqps_vi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), RenQiActivity.class).putExtra("type", 2));
            }
        });

//        LinearLayoutManager layout = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
//        hotWear.setLayoutManager(layout);
//        hotWear.setHasFixedSize(true);
//        hotWear.setLongClickable(true);
        brandList.setFocusable(false);
        gridView.setFocusable(false);
        gridView.addFooterView(foot);
        gridView.addHeaderView(headerView); // 他需要在setAdapter()之前
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());

        mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        brandList.setLayoutManager(mLayoutManager);
        brandList.setHasFixedSize(true);

//        LinearLayoutManager mLayoutManager1 = new LinearLayoutManager(getContext());
//
//        mLayoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
//
//        recyclerView.setLayoutManager(mLayoutManager1);
//        recyclerView.setHasFixedSize(true);
//
//
//        LinearLayoutManager mLayoutManager2 = new LinearLayoutManager(getContext());
//
//        mLayoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
//
//        recyclerView1.setLayoutManager(mLayoutManager2);
//        recyclerView1.setHasFixedSize(true);

//        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            //用来标记是否正在向最后一个滑动
//            boolean isSlidingToLast = false;
//
//            @Override
//            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
//                //设置什么布局管理器,就获取什么的布局管理器
//                LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();
//                // 当停止滑动时
//                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
//                    //获取最后一个完全显示的ItemPosition ,角标值
//                    int lastVisibleItem = manager.findLastCompletelyVisibleItemPosition();
//                    //所有条目,数量值
//                    int totalItemCount = manager.getItemCount();
//                    System.out.println(lastVisibleItem);
//                    // 判断是否滚动到底部，并且是向右滚动
//                    if (lastVisibleItem == (totalItemCount - 1) ) {
//                        rq_1.setBackgroundResource(R.drawable.r2);
//                        rq_3.setBackgroundResource(R.drawable.r);
//                        //加载更多功能的代码
//                        System.out.println("---------");
//                    }else {
//                        rq_1.setBackgroundResource(R.drawable.r);
//                        rq_3.setBackgroundResource(R.drawable.r2);
//                    }
//                }
//            }
//
//            @Override
//            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//                //dx用来判断横向滑动方向，dy用来判断纵向滑动方向
//                //dx>0:向右滑动,dx<0:向左滑动
//                //dy>0:向下滑动,dy<0:向上滑动
//                if (dy > 0) {
//                    isSlidingToLast = true;
//                } else {
//                    isSlidingToLast = false;
//                }
//            }
//        });

        viewPager1.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    rq_1.setBackgroundResource(R.drawable.r);
                    rq_2.setBackgroundResource(R.drawable.r2);
                    rq_3.setBackgroundResource(R.drawable.r2);

                } else if (position == 1) {
                    rq_1.setBackgroundResource(R.drawable.r2);
                    rq_2.setBackgroundResource(R.drawable.r);
                    rq_3.setBackgroundResource(R.drawable.r2);
                } else if (position == 2) {
                    rq_1.setBackgroundResource(R.drawable.r2);
                    rq_2.setBackgroundResource(R.drawable.r2);
                    rq_3.setBackgroundResource(R.drawable.r);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager2.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    ps_1.setBackgroundResource(R.drawable.r);
                    ps_2.setBackgroundResource(R.drawable.r2);
                    ps_3.setBackgroundResource(R.drawable.r2);

                } else if (position == 1) {
                    ps_1.setBackgroundResource(R.drawable.r2);
                    ps_2.setBackgroundResource(R.drawable.r);
                    ps_3.setBackgroundResource(R.drawable.r2);
                } else if (position == 2) {
                    ps_1.setBackgroundResource(R.drawable.r2);
                    ps_2.setBackgroundResource(R.drawable.r2);
                    ps_3.setBackgroundResource(R.drawable.r);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        refreshLayout.setRefreshHeader(new ClassicsHeader(getContext()).setSpinnerStyle(SpinnerStyle.Translate));
        refreshLayout.setRefreshFooter(new ClassicsFooter(getContext()).setSpinnerStyle(SpinnerStyle.Scale));

        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                page++;
                getFreshClothList();
            }
        });

        itemPushViewAdapter = new ItemPushViewAdapter(getContext(), new ArrayList<>());
        gridView.setAdapter(itemPushViewAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(getContext(), DetailActivity.class).putExtra("id", itemPushViewAdapter.getItem(i).getClothingId()));
            }
        });

    }

    @Override
    public void getData(View view, Bundle savedInstanceState) {
        new HttpServiceImpl().getHomePage(data -> {
            if (data.getStatus() != 200) {
                return;
            }
            List<HOME_ENTITY.DataEntity.LoopPicEntity> imgList = data.getData().getLoopPic();

            brandList.setAdapter(new ItemHomeViewAdapter(getContext(), data.getData().getThematicActivities()));
            itemPushViewAdapter.setObjects(data.getData().getRecommendClothing());
            List<ArticlesHomePageEntity.DataEntity.ArticleVOSEntity> articleVOS = data.getData().getArticle().getArticleVOS();
            customListView.setAdapter(new ItemCommunityAdapter(getActivity(), data.getData().getArticle().getArticleVOS(), 1));

            //自定义你的Holder，实现更多复杂的界面，不一定是图片翻页，其他任何控件翻页亦可。
            convenientBanner.setPages(() -> new LocalImageHolderView(), imgList);
            convenientBanner.startTurning(4000);
            if (imgList.size() == 1) {
                convenientBanner.stopTurning();
            }
            convenientBanner.setPageIndicator(new int[]{R.drawable.ic_page_indicator, R.drawable.ic_page_indicator_focused});

            convenientBanner.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(int position) {
                    startActivity(new Intent(getContext(), WebViewActivity.class).putExtra("url", imgList.get(position).getHomeLinkUrl()));
                }
            });


//            hotWear.setAdapter(new RecyclerLayoutAdapter(getContext(), hotWear, data.getData().getHotWears()));
//            hotWear.smoothScrollToPosition(1);
            List<HOME_ENTITY.DataEntity.FashionWearsEntity> fashionWears = data.getData().getFashionWears();

            HOME_ENTITY.DataEntity.SuitWithEntity suitWith = data.getData().getSuitWith();
            String suitWithimgUrl = suitWith.getContent().get(0).getImgUrl();
            String suitWithlinkUrl = suitWith.getContent().get(0).getLinkUrl();

            HOME_ENTITY.DataEntity.FashionWearsEntity fashionWearsEntity = fashionWears.get(0);
            String hotWearImg = fashionWearsEntity.getHotWearImg();
            String hotWearUrl = fashionWearsEntity.getHotWearUrl();

            Picasso.get().load(suitWithimgUrl).into(suitWithImage);
            suitWithImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getContext(), WebViewActivity.class).putExtra("url", suitWithlinkUrl));

                }
            });

            Picasso.get().load(hotWearImg).into(fashionWearsImage);
            fashionWearsImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getContext(), WebViewActivity.class).putExtra("url", hotWearUrl));

                }
            });

            List<HOME_ENTITY.DataEntity.BeautifulClothesEntity.ContentEntity> beautifulContent = data.getData().getBeautifulClothes().getContent();
            List<HOME_ENTITY.DataEntity.OrnamentsEntity.ContentEntityX> ornaments = data.getData().getOrnaments().getContent();


            List<List<HOME_ENTITY.DataEntity.BeautifulClothesEntity.ContentEntity>> mmpList = new ArrayList<>();
            mmpList.add(Arrays.asList(beautifulContent.get(0), beautifulContent.get(1)));
            mmpList.add(Arrays.asList(beautifulContent.get(2), beautifulContent.get(3)));
            mmpList.add(Arrays.asList(beautifulContent.get(4), beautifulContent.get(5)));

            List<List<HOME_ENTITY.DataEntity.OrnamentsEntity.ContentEntityX>> rqps = new ArrayList<>();
            rqps.add(Arrays.asList(ornaments.get(0), ornaments.get(1)));
            rqps.add(Arrays.asList(ornaments.get(2), ornaments.get(3)));
            rqps.add(Arrays.asList(ornaments.get(4), ornaments.get(5)));

            viewPager1.setAdapter(new ItemCnmbAdapter(getActivity(), mmpList));

            viewPager2.setAdapter(new ItemCnmbAdapter2(getContext(), rqps));


//            recyclerView1.setAdapter(new ItemRecyclerCnmmbAdapter2(getContext(), recyclerView1, rqps));
        });

    }


    public class LocalImageHolderView implements Holder<HOME_ENTITY.DataEntity.LoopPicEntity> {
        private ImageView imageView;


        @Override
        public void UpdateUI(Context context, int position, HOME_ENTITY.DataEntity.LoopPicEntity data) {

            Picasso.get().load(data.getHomeImgUrl()).into(imageView);
        }

        @Override
        public View createView(Context context) {
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            return imageView;
        }
    }

    public void getFreshClothList() {
        new HttpServiceImpl().getFreshClothList(page, 20, 0, 0, 2, 0, new HttpServiceImpl.OnObjectDataListener<FreshClothEntity>() {
            @Override
            public void onData(FreshClothEntity data) {
                refreshLayout.finishLoadmore(0);
                if (data.getData().size() > 0) {
                    itemPushViewAdapter.addObjects(data.getData());
                } else {
                    footerBar.setVisibility(View.VISIBLE);
                    footerBar.post(new Runnable() {
                        @Override
                        public void run() {
                            refreshLayout.setEnableLoadmore(false);
                            gridView.tryToScrollToBottomSmoothly();
                        }
                    });
                    Toast.makeText(getContext(), "没有更多了", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @OnClick(R.id.go_top)
    void go_top() {
        startActivity(new Intent(getContext(), InviteActivity.class));
    }

}
