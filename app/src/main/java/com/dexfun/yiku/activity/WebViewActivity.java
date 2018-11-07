package com.dexfun.yiku.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.ConsoleMessage;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;

import com.chow.module.share.info.IShareInfo;
import com.chow.module.share.info.SimpleShareText;
import com.chow.module.share.templet.AbsWarpTemplateShare;
import com.chow.module.share.view.ShareView;
import com.dexfun.yiku.BuildConfig;
import com.dexfun.yiku.R;
import com.dexfun.yiku.UserClass;
import com.dexfun.yiku.base.BaseActivity;
import com.dexfun.yiku.service.impl.HttpServiceImpl;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WebViewActivity extends BaseActivity {


    @BindView(R.id.web_view)
    WebView webView;
    @BindView(R.id.include_right_btn)
    ImageButton include_right_btn;

    @Override
    public int getLayoutId() {
        return R.layout.activity_web_view;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        include_right_btn.setImageResource(R.mipmap.fenxiang);
        String url = getIntent().getStringExtra("url");
        setTitle("");
        setToken();
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (!url.substring(0, 5).contains("http")||url.contains("SkipYou")) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    return true;
                }
                view.loadUrl(url);
                return true;
            }
        });
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                setTitle(view.getTitle());
                super.onProgressChanged(view, newProgress);
            }

            @Override
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                if (consoleMessage.message().equals("startWalletActivity")) {
                    startActivity(new Intent(WebViewActivity.this, WalletActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                }
                if (consoleMessage.message().equals("GoToPayPage")) {
                    startActivity(new Intent(WebViewActivity.this, BuyCardActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                }
                if (consoleMessage.message().contains("GoToDetail")) {

                    startActivity(new Intent(WebViewActivity.this, DetailActivity.class).putExtra("id", Integer.valueOf(consoleMessage.message().replace("GoToDetail[", "").replace("]", ""))).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                }
                if (consoleMessage.message().equals("GoToLogin")) {

                    startActivity(new Intent(WebViewActivity.this, LoginActivity.class));
                }
                return super.onConsoleMessage(consoleMessage);
            }
        });

        webView.loadUrl(url);
    }

    @OnClick(R.id.include_right_btn)
    void include_right_btn() {
        ShareView mShareView = null;
        mShareView = new ShareView(WebViewActivity.this, "分享");
        mShareView.setShareInfo(WebViewActivity.this, new TestImpl(WebViewActivity.this, webView.getUrl(), webView.getTitle(), webView.getTitle()));
        mShareView.show();
    }

    public static class TestImpl extends AbsWarpTemplateShare {
        String url;
        String title;
        String subTitle;

        public TestImpl(Context context) {
            super(context);
        }


        public TestImpl(Context context, String url, String title, String subTitle) {
            super(context);
            this.url = url;
            this.title = title;
            this.subTitle = subTitle;
        }

        @Override
        public IShareInfo warpWechatInfo() {
            return new SimpleShareText(title, subTitle, url, "http://img-cdn.xykoo.cn/ic_launcher.png");
        }

        @Override
        public IShareInfo warpSinaInfo() {
            return new SimpleShareText(title, subTitle, url, "http://img-cdn.xykoo.cn/ic_launcher.png");
        }

        @Override
        public IShareInfo warpQQInfo() {
            return new SimpleShareText(title, subTitle, url, "http://img-cdn.xykoo.cn/ic_launcher.png");
        }

        @Override
        public IShareInfo warpMessageInfo() {
            return new SimpleShareText(title, subTitle, url, "http://img-cdn.xykoo.cn/ic_launcher.png");
        }
    }

    @Override
    public void getData(Bundle savedInstanceState) {

    }

    @Override
    protected void onPause() {
        webView.onPause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        setToken();
        webView.onResume();
        super.onResume();
    }

    private void setToken() {
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setCookie("activity.xykoo.cn", "token=" + UserClass.getInstance().getToken());
        CookieSyncManager.getInstance().sync();
    }

    @Override
    protected void onDestroy() {
        webView.destroy();
        System.exit(0);
        super.onDestroy();
    }
}
