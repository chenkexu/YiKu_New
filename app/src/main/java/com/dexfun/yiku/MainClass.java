package com.dexfun.yiku;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.chow.module.share.ShareManager;
import com.chow.module.share.way.SHARE_MEDIA;
import com.dexfun.yiku.entity.DefaultEntity;
import com.dexfun.yiku.utils.GlideImageLoader;
import com.dexfun.yiku.utils.GsonUtil;
import com.igexin.sdk.PushManager;
import com.king.thread.nevercrash.NeverCrash;
import com.lzy.imagepicker.ImagePicker;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.cache.CacheMode;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;

import cn.jpush.android.api.JPushInterface;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;



/**
 * Created by Smile on 17/5/10.
 */
public class MainClass extends Application {

    private static final String TAG = "MainClass";
    private static MainClass instance;
    private static final List<Activity> activitys = Collections.synchronizedList(new LinkedList<Activity>());


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initLogger();
//        SAK.init(this);

        NeverCrash.init(new NeverCrash.CrashHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                Log.e("ERROR-", Log.getStackTraceString(e));
//                e.printStackTrace();
            }
        });

//        if (getApplicationInfo().packageName.equals(getCurProcessName(getApplicationContext())) ||
//                "io.rong.push".equals(getCurProcessName(getApplicationContext()))) {
//            RongIMClient.init(this, "25wehl3u2s52w");
//        }
//        RongIM.init(this, "25wehl3u2s52w");
        // com.getui.demo.DemoPushService 为第三方自定义推送服务
        PushManager.getInstance().initialize(this.getApplicationContext(), DemoPushService.class);
        PushManager.getInstance().registerPushIntentService(this.getApplicationContext(), DemoIntentService.class);
        registerActivityListener();
        initHttp(this);
        initImagePicker();
        //配置所有的分享方式
        LinkedHashMap<SHARE_MEDIA, Integer> iconMap = new LinkedHashMap<>();
        iconMap.put(SHARE_MEDIA.WEICHAT, R.mipmap.wxiconx);
        iconMap.put(SHARE_MEDIA.WEICHATCIRCLE, R.mipmap.pyqiconx);
        iconMap.put(SHARE_MEDIA.SINA, R.drawable.share_sina);
        iconMap.put(SHARE_MEDIA.QQ, R.drawable.share_qq);
        iconMap.put(SHARE_MEDIA.QQZONE, R.drawable.share_qzeon);
        iconMap.put(SHARE_MEDIA.MESSAGE, R.drawable.share_message);

        //初始化分享相关的key、appId 信息
        ShareManager.init()
                .setShareWayIconMap(iconMap)
                //应用的名字
                .setAppName(getString(R.string.app_name))
                .setDefShareImageUrl("https://www.dexfun.com/img/logo200x200.png")
                .addShareMedia(SHARE_MEDIA.WEICHAT, SHARE_MEDIA.WEICHATCIRCLE)//, SHARE_MEDIA.SINA, SHARE_MEDIA.QQ, SHARE_MEDIA.QQZONE
                //如果要自定义分享的图标，可以通过下面的方式进行设置，使用的默认分享图标，注释该方法即可
                //.setShareWayIconMap(iconMap)
//                .setQQAppId("自己申请的appId")
//                .setWeiboAppId("自己申请的appId")
//                .setWechatAppId( Constant.LocalKey.APP_ID)
                .setQQAppId("1104680275")
                .setWeiboAppId("1962535544")
                .setWechatAppId(Constant.LocalKey.APP_ID)
                .setSinaRedirectUrl("https://api.weibo.com/oauth2/default.html")
                .setScope("email,direct_messages_read,direct_messages_write,\"\n" +
                        "            + \"friendships_groups_read,friendships_groups_write,statuses_to_me_read,\"\n" +
                        "            + \"follow_app_official_microblog,\" + \"invitation_write")
                .setDefImageUrlId(R.drawable.lollipop);
        JPushInterface.setDebugMode(false);
        JPushInterface.init(this);
    }

    private void initLogger() {
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
        .showThreadInfo(false)  // (Optional) Whether to show thread info or not. Default true
        .methodCount(0)         // (Optional) How many method line to show. Default 2
        .methodOffset(7)        // (Optional) Hides internal method calls up to offset. Default 5
        .tag("okgo")   // (Optional) Global tag for every log. Default PRETTY_LOGGER
        .build();
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy) {

        });
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        android.support.multidex.MultiDex.install(this);
    }

    public static MainClass getInstance() {
        return instance;
    }

    private void initImagePicker() {
        ImagePicker imagePicker = ImagePicker.getInstance();
        imagePicker.setImageLoader(new GlideImageLoader());   //设置图片加载器
        imagePicker.setShowCamera(true);                      //显示拍照按钮

    }

    private void initHttp(Application context) {
        OkGo.init(context);
        try {
            OkGo okGo = OkGo.getInstance();
            okGo.getOkHttpClientBuilder().addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request.Builder builder = chain.request().newBuilder();
                    builder.addHeader("X-Time", String.valueOf(System.currentTimeMillis()));
                    builder.addHeader("X-Auth-Token", UserClass.getInstance().getToken());
                    Response response = chain.proceed(builder.build());
                    return response.newBuilder().build();
                }
            });
            okGo.debug("OkGo", Level.INFO, true)
                    .setConnectTimeout(OkGo.DEFAULT_MILLISECONDS)  //全局的连接超时时间
                    .setReadTimeOut(OkGo.DEFAULT_MILLISECONDS)     //全局的读取超时时间
                    .setWriteTimeOut(OkGo.DEFAULT_MILLISECONDS)    //全局的写入超时时间
                    .setCacheMode(CacheMode.FIRST_CACHE_THEN_REQUEST)
                    .setCacheTime(CacheEntity.CACHE_NEVER_EXPIRE)
                    //可以全局统一设置超时重连次数,默认为三次,那么最差的情况会请求4次(一次原始请求,三次重连请求),不需要可以设置为0
                    .setRetryCount(3)
//              .setCookieStore(new MemoryCookieStore())            //cookie使用内存缓存（app退出后，cookie消失）
//                    .setCookieStore(new PersistentCookieStore())        //cookie持久化存储，如果cookie不过期，则一直有效
                    //可以设置https的证书,以下几种方案根据需要自己设置
                    .setCertificates()                         //方法一：信任所有证书,不安全有风险
//                    .addCommonHeaders(headers);//设置全局公共头
//                    .addCommonParams(params);   //设置全局公共参数
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request.Builder builder = chain.request().newBuilder();
                            Response response = chain.proceed(builder.build());
                            String body = response.body().string();
                            System.out.println(builder.build().url().toString());
                            if (GsonUtil.create().fromJson(body, DefaultEntity.class).getStatus() == 401) {
//                            startActivity(new Intent(getApplicationContext(), LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                                UserClass.getInstance().rmToken();
                            }
                            return response.newBuilder().body(ResponseBody.create(MediaType.parse("application/json;charset=UTF-8"), body)).code(200).build();
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * @param activity 作用说明 ：添加一个activity到管理里
     */
    public void pushActivity(Activity activity) {
        activitys.add(activity);
        Log.d(TAG, "activityList:size:" + activitys.size());
    }

    /**
     * @param activity 作用说明 ：删除一个activity在管理里
     */
    public void popActivity(Activity activity) {
        activitys.remove(activity);
        Log.d(TAG, "activityList:size:" + activitys.size());
    }


    /**
     * get current Activity 获取当前Activity（栈中最后一个压入的）
     */
    public static Activity currentActivity() {
        if (activitys == null || activitys.isEmpty()) {
            return null;
        }
        return activitys.get(activitys.size() - 1);
    }

    /**
     * 结束当前Activity（栈中最后一个压入的）
     */
    public static void finishCurrentActivity() {
        if (activitys == null || activitys.isEmpty()) {
            return;
        }
        Activity activity = activitys.get(activitys.size() - 1);
        finishActivity(activity);
    }

    /**
     * 结束指定的Activity
     */
    public static void finishActivity(Activity activity) {
        if (activitys == null || activitys.isEmpty()) {
            return;
        }
        if (activity != null) {
            activitys.remove(activity);
            activity.finish();
        }
    }

    /**
     * 结束指定的Activity之外的其他Activity
     */
    public static void finishActivityPassThis(Class<?> cls) {
        if (activitys == null || activitys.isEmpty()) {
            return;
        }
        for (Activity activity : activitys) {
            if (!activity.getClass().equals(cls)) {
                finishActivity(activity);
            }
        }
    }

    /**
     * 结束指定类名的Activity
     */
    public static void finishActivity(Class<?> cls) {
        if (activitys == null || activitys.isEmpty()) {
            return;
        }
        for (Activity activity : activitys) {
            if (activity.getClass().equals(cls)) {
                finishActivity(activity);
            }
        }
    }

    /**
     * 按照指定类名找到activity
     *
     * @param cls
     * @return
     */
    public static Activity findActivity(Class<?> cls) {
        Activity targetActivity = null;
        if (activitys != null) {
            for (Activity activity : activitys) {
                if (activity.getClass().equals(cls)) {
                    targetActivity = activity;
                    break;
                }
            }
        }
        return targetActivity;
    }

    /**
     * @return 作用说明 ：获取当前最顶部activity的实例
     */
    public Activity getTopActivity() {
        Activity mBaseActivity;
        synchronized (activitys) {
            final int size = activitys.size() - 1;
            if (size < 0) {
                return null;
            }
            mBaseActivity = activitys.get(size);
        }
        return mBaseActivity;

    }

    /**
     * @return 作用说明 ：获取当前最顶部的acitivity 名字
     */
    public String getTopActivityName() {
        Activity mBaseActivity = null;
        synchronized (activitys) {
            final int size = activitys.size() - 1;
            if (size < 0) {
                return null;
            }
            mBaseActivity = activitys.get(size);
        }
        return mBaseActivity.getClass().getName();
    }

    /**
     * 结束所有Activity
     */
    public static void finishAllActivity() {
        if (activitys == null) {
            return;
        }
        for (Activity activity : activitys) {
            activity.finish();
        }
        activitys.clear();
    }

    private void registerActivityListener() {
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                /**
                 *  监听到 Activity创建事件 将该 Activity 加入list
                 */
                pushActivity(activity);

            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                if (null == activitys || activitys.isEmpty()) {
                    return;
                }
                if (activitys.contains(activity)) {
                    /**
                     *  监听到 Activity销毁事件 将该Activity 从list中移除
                     */
                    popActivity(activity);
                }
            }
        });
    }


}