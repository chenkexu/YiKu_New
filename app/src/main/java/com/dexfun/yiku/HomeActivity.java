package com.dexfun.yiku;

import android.*;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.dexfun.layout.*;
import com.dexfun.yiku.BuildConfig;
import com.dexfun.yiku.activity.DepositActivity;
import com.dexfun.yiku.activity.DetailActivity;
import com.dexfun.yiku.activity.PayDialogClass;
import com.dexfun.yiku.activity.ShoppingCartActivity;
import com.dexfun.yiku.activity.ZYWActivity;
import com.dexfun.yiku.base.BaseActivity;
import com.dexfun.yiku.entity.GetUserInfoEntity;
import com.dexfun.yiku.entity.MainDexEvent;
import com.dexfun.yiku.entity.OnDexEvent;
import com.dexfun.yiku.entity.VersionEntity;
import com.dexfun.yiku.fragment.ChooseFragment;
import com.dexfun.yiku.fragment.ChooseMainFragment;
import com.dexfun.yiku.fragment.HomeFragment;
import com.dexfun.yiku.fragment.KnapsackFragment;
import com.dexfun.yiku.fragment.MainFragment;
import com.dexfun.yiku.fragment.PersonalFragment;
import com.dexfun.yiku.fragment.WishListFragment;
import com.dexfun.yiku.service.impl.HttpServiceImpl;
import com.dexfun.yiku.utils.SharedPreferencesUtil;
import com.dexfun.yiku.utils.UiUtils;
import com.dexfun.yiku.widget.BaseDialog;
import com.tencent.stat.MtaSDkException;
import com.tencent.stat.StatService;
import com.yinglan.alphatabs.AlphaTabsIndicator;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;

public class HomeActivity extends BaseActivity {

    @BindView(R.id.bottomNavigationView)
    AlphaTabsIndicator mBottomNavigationView;
    private long exitTime = 0;
    private Fragment mContentFragment = null;
    private Fragment mPersonalFragment = null;
    private Fragment mHomeFragment = null;
    private Fragment mChooseFragment = null;
    private ShoppingCartActivity mKnapsackFragment = null;
    private Fragment mWishListFragment = null;
    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        EventBus.getDefault().register(this);
        if (Build.VERSION.SDK_INT >= 23) {
            int phone = ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_PHONE_STATE);
            int write = ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
            if (phone != PackageManager.PERMISSION_GRANTED || write != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.READ_PHONE_STATE, android.Manifest.permission.WRITE_EXTERNAL_STORAGE, android.Manifest.permission.READ_EXTERNAL_STORAGE, android.Manifest.permission.MOUNT_UNMOUNT_FILESYSTEMS}, 1013);
            } else {
                try {
// 第三个参数必须为：com.tencent.stat.common.StatConstants.VERSION
                    StatService.startStatService(this, "AGNQ18V3YH1B",
                            com.tencent.stat.common.StatConstants.VERSION);
                    Log.d("MTA", "MTA初始化成功");

                } catch (MtaSDkException e) {
// MTA初始化失败
                    Log.d("MTA", "MTA初始化失败" + e);
                }
            }
        }
//        if (SharedPreferencesUtil.getInstance().getBoolean(Constant.LocalKey.ZYW, true)) {
//            startActivity(new Intent(this, ZYWActivity.class));
//            SharedPreferencesUtil.getInstance().put(Constant.LocalKey.ZYW, false);
//        }
        mContentFragment = new Fragment();
        mHomeFragment = new HomeFragment();
        mChooseFragment = new ChooseMainFragment();
        mKnapsackFragment = new ShoppingCartActivity();
        mPersonalFragment = new PersonalFragment();
        mWishListFragment = new WishListFragment();
        switchContent(mHomeFragment);
        mBottomNavigationView.setOnTabChangedListner(tabNum -> {
            switch (tabNum) {
                case 0:
                    UiUtils.setStatusBarLightMode(this);
                    switchContent(mHomeFragment);
                    break;
                case 1:
                    UiUtils.setStatusBarLightMode(this);
                    switchContent(mChooseFragment);
                    break;
                case 2:
                    UiUtils.setStatusBarLightMode(this);
                    switchContent(mWishListFragment);
                    break;
                case 3:
                    UiUtils.setStatusBarLightMode(this);
                    switchContent(mKnapsackFragment);
                    break;
                case 4:
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
                        getWindow().setStatusBarColor(Color.parseColor("#1A1A1A"));
                    }
                    switchContent(mPersonalFragment);
                    break;
                default:
            }
        });

    }

    @Override
    public void getData(Bundle savedInstanceState) {
        try {
            String id = getIntent().getStringExtra("id");
            if (!TextUtils.isEmpty(id)) {

                startActivity(new Intent(this, DetailActivity.class).putExtra("id", Integer.parseInt(id)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

//        startActivity(new Intent(this,  LoginActivity.class));
        new HttpServiceImpl().checkTheLatestVersion(new HttpServiceImpl.OnObjectDataListener<VersionEntity>() {
            @Override
            public void onData(VersionEntity data) {
                int anInt = Integer.parseInt(data.getData().getServerNewVersion().replace(".", ""));
                int parseInt = Integer.parseInt(BuildConfig.VERSION_NAME.replace(".", ""));

                System.out.println(anInt);
                System.out.println(parseInt);
                if (anInt > parseInt) {
                    new BaseDialog(HomeActivity.this, true)
                            .setCancel(false)
                            .setMessage(data.getData().getUpgradeInfo())
                            .setPositiveButton("更新", (dialogInterface, i) -> {
                                dialogInterface.cancel();
                                Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse(data.getData().getUpdateUrl()));
                                startActivity(it);
                                finish();
                            })
                            .setNegativeButton("退出程序", (dialogInterface, i) -> {
                                dialogInterface.cancel();
                                finish();
                            })
                            .show();
                }
            }
        });

        new HttpServiceImpl().getUserInfo(new HttpServiceImpl.OnObjectDataListener<GetUserInfoEntity>() {
            @Override
            public void onData(GetUserInfoEntity data) {
                if (data.getStatus() == 200) {
                    UserClass.getInstance().setUserid(String.valueOf(data.getData().getUserInfo().getUserId()));
                }
            }
        });


    }

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
    }

    private void switchContent(Fragment to) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (mContentFragment != to) {
            if (!to.isAdded()) {
                transaction.hide(mContentFragment).add(R.id.frame, to).commitAllowingStateLoss();
            } else {
                transaction.hide(mContentFragment).show(to).commitAllowingStateLoss();
            }
            mContentFragment = to;
        } else {
            transaction.replace(R.id.frame, to).commitAllowingStateLoss();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次返回桌面", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                MainClass.finishAllActivity();
//                Intent intent = new Intent(Intent.ACTION_MAIN);
//                intent.addCategory(Intent.CATEGORY_HOME);
//                startActivity(intent);
            }
//            Intent intent = new Intent(Intent.ACTION_MAIN);
//            intent.addCategory(Intent.CATEGORY_HOME);
//            startActivity(intent);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onRestart() {
        EventBus.getDefault().post(new OnDexEvent(0));
        super.onRestart();
    }

    //迷之代码 勿动！！！
    //迷之代码 勿动！！！
    //迷之代码 勿动！！！
    @Subscribe
    public void onEventMainThread(MainDexEvent event) {
        switch (event.getType()) {
            case 0:
                mBottomNavigationView.setTabCurrenItem(0);
                break;
            case 1:
                mBottomNavigationView.setTabCurrenItem(1);
//                if (mChooseFragment != null) {
//                    new Thread(new Runnable() {
//                        @Override
//                        public void run() {
//                            do {
//                                if (mChooseFragment.getTabPx() != null) {
//                                    runOnUiThread(new Runnable() {
//                                        @Override
//                                        public void run() {
//                                            ChooseFragment.ck = true;
//                                            mChooseFragment.getGridView().smoothScrollToPositionFromTop(2, 500);
//                                            mChooseFragment.getTabPx().setScrollPosition(1, 0, true);
//                                            mChooseFragment.getTabPx().getTabAt(1).select();
//                                        }
//                                    });
//                                }
//                            } while (mChooseFragment.getTabPx() == null);
//                        }
//                    }).start();
//                }
                break;
            case 2:
//                mBottomNavigationView.setTabCurrenItem(2);
                mKnapsackFragment.getData(null, null);
                break;
            default:
        }
    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1013) {
            if (Build.VERSION.SDK_INT >= 23) {
                int phone = ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_PHONE_STATE);
                int write = ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
                if (phone != PackageManager.PERMISSION_GRANTED || write != PackageManager.PERMISSION_GRANTED) {
//                    ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.READ_PHONE_STATE, android.Manifest.permission.WRITE_EXTERNAL_STORAGE, android.Manifest.permission.READ_EXTERNAL_STORAGE, android.Manifest.permission.MOUNT_UNMOUNT_FILESYSTEMS}, 1013);
                } else {
                    try {
                        StatService.startStatService(this, "AGNQ18V3YH1B",
                                com.tencent.stat.common.StatConstants.VERSION);
                        Log.d("MTA", "MTA初始化成功");
                    } catch (MtaSDkException e) {
                        Log.d("MTA", "MTA初始化失败" + e);
                    }
                }
            }
        }
    }
}
