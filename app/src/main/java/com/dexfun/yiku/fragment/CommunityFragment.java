package com.dexfun.yiku.fragment;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.dexfun.yiku.R;
import com.dexfun.yiku.UserClass;
import com.dexfun.yiku.activity.ActivitiesActivity;
import com.dexfun.yiku.activity.AddArticleActivity;
import com.dexfun.yiku.activity.WebViewActivity;
import com.dexfun.yiku.base.BaseFragment;
import com.dexfun.yiku.entity.ArticlesHomePageEntity;
import com.dexfun.yiku.entity.ArticlesListEntity;
import com.dexfun.yiku.entity.AttentionListEntity;
import com.dexfun.yiku.entity.HomeEntity;
import com.dexfun.yiku.fragment.home.ItemCommunityAdapter;
import com.dexfun.yiku.service.impl.HttpServiceImpl;
import com.dexfun.yiku.utils.AnimatorUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * ArticlesHomePageEntity simple {@link Fragment} subclass.
 */
public class CommunityFragment extends BaseFragment {


    ImageView loopViewpagerArc;
    @BindView(R.id.list)
    ListView list;
    int page = 1;
    @BindView(R.id.home_refresh)
    SmartRefreshLayout refreshLayout;
    @BindView(R.id.push_content)
    View pushContent;
    ItemCommunityAdapter itemCommunityAdapter;

    private int mLastFirstPostion;
    private int mLastFirstTop;
    private int touchSlop;
    private boolean isShow = true;
    TextView Jx, Zx, Gz;
    ImageView image;
    int userId = 0;
    private int type = 1;
    public static List<Integer> dataData = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.fragment_community;
    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {
        itemCommunityAdapter = new ItemCommunityAdapter(getContext(), new ArrayList<>(), 1);
        list.setAdapter(itemCommunityAdapter);
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View headerView = inflater.inflate(R.layout.view_community_header, null);
        loopViewpagerArc = headerView.findViewById(R.id.loop_viewpager_arc);
        Jx = headerView.findViewById(R.id.btn_jx);
        image = headerView.findViewById(R.id.image);
        Zx = headerView.findViewById(R.id.btn_zx);
        Gz = headerView.findViewById(R.id.btn_gz);
        Jx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Jx.setTextColor(Color.parseColor("#FF1A1A1A"));
                Zx.setTextColor(Color.parseColor("#FF999999"));
                Gz.setTextColor(Color.parseColor("#FF999999"));
                userId = 0;
                type = 1;
                page = 1;
                getFreshClothList();
            }
        });
        Zx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Jx.setTextColor(Color.parseColor("#FF999999"));
                Zx.setTextColor(Color.parseColor("#FF1A1A1A"));
                Gz.setTextColor(Color.parseColor("#FF999999"));
                userId = 0;
                type = 0;
                page = 1;
                getFreshClothList();
            }
        });
        Gz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Jx.setTextColor(Color.parseColor("#FF999999"));
                Zx.setTextColor(Color.parseColor("#FF999999"));
                Gz.setTextColor(Color.parseColor("#FF1A1A1A"));
                userId = Integer.valueOf(UserClass.getInstance().getUserid());
                type = 0;
                page = 1;
                getFreshClothList();
            }
        });
        list.addHeaderView(headerView);
        refreshLayout.setRefreshHeader(new ClassicsHeader(getContext()).setSpinnerStyle(SpinnerStyle.Translate));
        refreshLayout.setRefreshFooter(new ClassicsFooter(getContext()).setSpinnerStyle(SpinnerStyle.Scale));

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


        list.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override
            public void onScroll(AbsListView absListView, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                int currentTop;

                View firstChildView = absListView.getChildAt(0);
                if (firstChildView != null) {
                    currentTop = absListView.getChildAt(0).getTop();
                } else {
                    //ListView初始化的时候会回调onScroll方法，此时getChildAt(0)仍是为空的
                    return;
                }
                //判断上次可见的第一个位置和这次可见的第一个位置
                if (firstVisibleItem != mLastFirstPostion) {
                    //不是同一个位置
                    if (firstVisibleItem > mLastFirstPostion) {
                        //TODO do down

//                        AnimatorUtils.hideGo(pushContent);
                    } else {
                        //TODO do up

//                        AnimatorUtils.showGo(pushContent);
                    }
                    mLastFirstTop = currentTop;
                } else {
                    //是同一个位置
                    if (Math.abs(currentTop - mLastFirstTop) > touchSlop) {
                        //避免动作执行太频繁或误触，加入touchSlop判断，具体值可进行调整
                        if (currentTop > mLastFirstTop) {
                            //TODO do up


                            if (!isShow) {
                                AnimatorUtils.showGo(pushContent);
                                isShow = !isShow;
                            }
                        } else if (currentTop < mLastFirstTop) {
                            //TODO do down

                            if (isShow) {
                                AnimatorUtils.hideGo(pushContent);
                                isShow = !isShow;
                            }
                        }
                        mLastFirstTop = currentTop;
                    }
                }
                mLastFirstPostion = firstVisibleItem;
            }
        });

    }

    private void getFreshClothList() {
        new HttpServiceImpl().getAttentionList(new HttpServiceImpl.OnObjectDataListener<AttentionListEntity>() {
            @Override
            public void onData(AttentionListEntity data) {
                if (data.getStatus() == 200) {
                    dataData = data.getData();
                } else {
                    dataData = new ArrayList<>();
                }
                new HttpServiceImpl().getArticlesList(page, 10, type, -1, userId, 0, new HttpServiceImpl.OnObjectDataListener<ArticlesListEntity>() {
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
                                if (page==1){
                                    itemCommunityAdapter.addData(data.getData().getArticleVOS(), page);
                                }
                                page--;
                                Toast.makeText(getContext(), "没有更多了", Toast.LENGTH_SHORT).show();
                                return;
                            }
                            itemCommunityAdapter.addData(data.getData().getArticleVOS(), page);
                        }

                    }
                });
            }
        });
    }

    @Override
    public void getData(View view, Bundle savedInstanceState) {
//        type


        new HttpServiceImpl().getArticlesHomePage(new HttpServiceImpl.OnObjectDataListener<ArticlesHomePageEntity>() {
            @Override
            public void onData(ArticlesHomePageEntity data) {
                List<ArticlesHomePageEntity.DataEntity.ArticleLoopPicVOSEntity> articleLoopPicVOS = data.getData().getArticleLoopPicVOS();
                ArticlesHomePageEntity.DataEntity.CommunityActivityEntity communityActivity = data.getData().getCommunityActivity();
                itemCommunityAdapter.setData(data.getData().getArticleVOS());
                Picasso.get().load(articleLoopPicVOS.get(0).getLoopPicUrl()).into(image);
                image.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getContext(), WebViewActivity.class).putExtra("url", articleLoopPicVOS.get(0).getLoopPicLinkUrl()));
                    }
                });
                Picasso.get().load(communityActivity.getMainDiagram()).into(loopViewpagerArc);
                loopViewpagerArc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getContext(), ActivitiesActivity.class).putExtra("id", communityActivity.getActivityId()));
                    }
                });
            }
        });


    }


    public class CLocalImageHolderView implements Holder<ArticlesHomePageEntity.DataEntity.ArticleLoopPicVOSEntity> {
        private ImageView imageView;


        @Override
        public void UpdateUI(Context context, int position, ArticlesHomePageEntity.DataEntity.ArticleLoopPicVOSEntity data) {

            Picasso.get().load(data.getLoopPicUrl()).into(imageView);
        }

        @Override
        public View createView(Context context) {
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            return imageView;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @OnClick(R.id.push_content)
    void push_content() {
        startActivity(new Intent(getContext(), AddArticleActivity.class));
    }
}
