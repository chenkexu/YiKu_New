package com.dexfun.yiku.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dexfun.yiku.R;
import com.dexfun.yiku.base.BaseActivity;
import com.dexfun.yiku.widget.PhotoViewPager;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import io.rong.photoview.PhotoView;

public class PicViewActivity extends BaseActivity {

    @BindView(R.id.pic_pager)
    PhotoViewPager picPager;
    @BindView(R.id.pic_index)
    TextView picIndex;
    int index;

    @Override
    public int getLayoutId() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉信息栏
        return R.layout.activity_pic_view;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        ArrayList<String> urls = getIntent().getStringArrayListExtra("urls");
        index = getIntent().getIntExtra("index", 0);
        MyImageAdapter adapter = new MyImageAdapter(urls, this);
        picPager.setAdapter(adapter);
        picPager.setCurrentItem(index, false);
        picIndex.setText(String.format(Locale.SIMPLIFIED_CHINESE, "%d/%d", index + 1, urls.size()));
        picPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                index = position;
                picIndex.setText(String.format(Locale.SIMPLIFIED_CHINESE, "%d/%d", index + 1, urls.size()));
            }
        });
    }

    @Override
    public void getData(Bundle savedInstanceState) {

    }


    class MyImageAdapter extends PagerAdapter {
        private final String TAG = MyImageAdapter.class.getSimpleName();
        private List<String> imageUrls;
        private Activity activity;

        MyImageAdapter(List<String> imageUrls, Activity activity) {
            this.imageUrls = imageUrls;
            this.activity = activity;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            String url = imageUrls.get(position);
            PhotoView photoView = new PhotoView(activity);
            Glide.with(activity)
                    .load(url)
                    .into(photoView);
            container.addView(photoView);
            photoView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d(TAG, "onClick: ");
                    activity.finish();
                }
            });
            return photoView;
        }

        @Override
        public int getCount() {
            return imageUrls != null ? imageUrls.size() : 0;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }
    }
}
