package com.dexfun.yiku.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.bumptech.glide.Glide;
import com.chow.module.share.info.IShareInfo;
import com.chow.module.share.info.SimpleShareText;
import com.chow.module.share.templet.AbsWarpTemplateShare;
import com.chow.module.share.way.WeichatShareImpl;
import com.dexfun.yiku.R;
import com.dexfun.yiku.base.BaseActivity;
import com.dexfun.yiku.entity.GetUserInfoEntity;
import com.dexfun.yiku.service.impl.HttpServiceImpl;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Smile
 */
public class InviteActivity extends BaseActivity {


    @BindView(R.id.m_left)
    ImageView mLeft;
    @BindView(R.id.m_ViewPager)
    ViewPager mViewPager;
    @BindView(R.id.m_right)
    ImageView mRight;
    private List<View> mList = new ArrayList<>();
    private List<Integer> mUrlList = new ArrayList<>();
    private int pos;

    @Override
    public int getLayoutId() {
        return R.layout.activity_invite;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setTitle("邀请有奖");

        mUrlList.add(R.mipmap.tanchuangtu);
        mUrlList.add(R.mipmap.shangpin);
        mUrlList.add(R.mipmap.fenxiang);
        mUrlList.add(R.mipmap.jiantou);
        //初始化ImageView
        for (int i = 0; i < mUrlList.size(); i++) {
            ImageView mImageView = new ImageView(this);
            Glide.with(this).load(mUrlList.get(i)).into(mImageView);
            mList.add(mImageView);
        }
        ViewPagerAdapter adapter = new ViewPagerAdapter(mList);
        mViewPager.setAdapter(adapter);
        mLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.arrowScroll(1);
            }
        });
        mRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.arrowScroll(2);
            }
        });

    }

    @Override
    public void getData(Bundle savedInstanceState) {

    }


    @OnClick(R.id.wx)
    void btn_share() {
        new HttpServiceImpl().getUserInfo(new HttpServiceImpl.OnObjectDataListener<GetUserInfoEntity>() {
            @Override
            public void onData(GetUserInfoEntity data) {
                System.out.println("InviteActivity.onData");
                if (data.getStatus() == 200) {
                    new WeichatShareImpl(InviteActivity.this, R.mipmap.ic_launcher, "", 1).shareToWeixin("快来和我一起尝试“包月换衣”", "衣库共享衣橱，首月149元，上万件大牌时装无限换穿！", "http://img-cdn.xykoo.cn/ic_launcher.png", false, "http://img-cdn.xykoo.cn/appHtml/invite/invite.html?id=" + data.getData().getUserInfo().getUserId());

                }
            }
        });
    }

    @OnClick(R.id.pyq)
    void btn_pyq() {
        new HttpServiceImpl().getUserInfo(new HttpServiceImpl.OnObjectDataListener<GetUserInfoEntity>() {
            @Override
            public void onData(GetUserInfoEntity data) {
                System.out.println("InviteActivity.onData");
                if (data.getStatus() == 200) {
                    new WeichatShareImpl(InviteActivity.this, R.mipmap.ic_launcher, "", 1).shareToWeixin("快来和我一起尝试“包月换衣”", "衣库共享衣橱，首月149元，上万件大牌时装无限换穿！", "http://img-cdn.xykoo.cn/ic_launcher.png", true, "http://img-cdn.xykoo.cn/appHtml/invite/invite.html?id=" + data.getData().getUserInfo().getUserId());
                }
            }
        });
    }

    public static class TestImpl extends AbsWarpTemplateShare {
        int id;

        public TestImpl(Context context) {
            super(context);
        }

        public TestImpl(Context context, int id) {
            super(context);
            this.id = id;
        }

        @Override
        public IShareInfo warpWechatInfo() {
            return new SimpleShareText("快来和我一起尝试“包月换衣”", mContext.getString(R.string.app_share_info), "http://img-cdn.xykoo.cn/appHtml/invite/invite.html?id=" + this.id, "http://img-cdn.xykoo.cn/ic_launcher.png");
        }

        @Override
        public IShareInfo warpSinaInfo() {
            return new SimpleShareText("快来和我一起尝试“包月换衣”", mContext.getString(R.string.app_share_info), "http://img-cdn.xykoo.cn/appHtml/invite/invite.html?id=" + this.id, "http://img-cdn.xykoo.cn/ic_launcher.png");
        }

        @Override
        public IShareInfo warpQQInfo() {
            return new SimpleShareText("快来和我一起尝试“包月换衣”", mContext.getString(R.string.app_share_info), "http://img-cdn.xykoo.cn/appHtml/invite/invite.html?id=" + this.id, "http://img-cdn.xykoo.cn/ic_launcher.png");
        }

        @Override
        public IShareInfo warpMessageInfo() {
            return new SimpleShareText("快来和我一起尝试“包月换衣”", mContext.getString(R.string.app_share_info), "http://img-cdn.xykoo.cn/appHtml/invite/invite.html?id=" + this.id, "http://img-cdn.xykoo.cn/ic_launcher.png");
        }
    }

    public class ViewPagerAdapter extends PagerAdapter {
        private List<View> mList;

        public ViewPagerAdapter(List<View> mList) {
            this.mList = mList;
        }

        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        /**
         *
         * */
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mList.get(position));
        }


        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mList.get(position), 0);
            return mList.get(position);
        }
    }

}
