package com.dexfun.yiku.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.widget.Toast;


import com.dexfun.yiku.Constant;
import com.dexfun.yiku.entity.PayMsgEvent;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

/**
 * Created by Smile on 17/5/31.
 */

public class WeChatPay {


    public WeChatPay(Context mContext) {
        this.mContext = mContext;
    }

    private Context mContext;
    private OnWeChatPayListener mListener;


    /**
     * 调起支付
     *
     * @param partnerId
     * @param prepayId
     * @param nonceStr
     * @param timeStamp
     * @param sign
     */
    public void pay(String partnerId, String prepayId,
                    String nonceStr, String timeStamp, String sign) {
        if (!isWeixinAvilible()) {
            Toast.makeText(mContext, "微信都没装我看你怎么支付 :)", Toast.LENGTH_SHORT).show();
        }
        IWXAPI api = WXAPIFactory.createWXAPI(mContext, Constant.LocalKey.APP_ID);
        api.registerApp(Constant.LocalKey.APP_ID);
        EventBus.getDefault().register(this);
        boolean isPaySupported = api.getWXAppSupportAPI() >= Build.PAY_SUPPORTED_SDK_INT;
        if (!isPaySupported) {
            Toast.makeText(mContext, "请更新微信客户端 ):", Toast.LENGTH_SHORT).show();
            return;
        }
        PayReq request = new PayReq();
        request.appId = Constant.LocalKey.APP_ID;
        request.partnerId = partnerId;
        request.prepayId = prepayId;
        request.packageValue = "Sign=WXPay";
        request.nonceStr = nonceStr;
        request.timeStamp = timeStamp;
        request.sign = sign;
        System.out.println(request.checkArgs());
        api.sendReq(request);
    }


    /**
     * 判断微信是否安装
     *
     * @return
     */
    public boolean isWeixinAvilible() {
        final PackageManager packageManager = mContext.getPackageManager();// 获取packagemanager
        List<PackageInfo> pinfo = packageManager.getInstalledPackages(0);// 获取所有已安装程序的包信息
        if (pinfo != null) {
            for (int i = 0; i < pinfo.size(); i++) {
                String pn = pinfo.get(i).packageName;
                if (pn.equals("com.tencent.mm")) {
                    return true;
                }
            }
        }
        return false;
    }

    @Subscribe
    public void onEventMainThread(PayMsgEvent event) {
        if (event.isPay()) {
            if (mListener != null) {
                mListener.onSuccess();
            }
        } else {
            if (mListener != null) {
                mListener.onCancel();
            }
        }
        EventBus.getDefault().unregister(this);
    }

    public WeChatPay setOnWeChatPayListener(OnWeChatPayListener l) {
        mListener = l;
        return this;
    }

    public abstract static class OnWeChatPayListener {
        /**
         * 支付成功
         */
        public void onSuccess() {
        }

        /**
         * 支付取消
         */
        public void onCancel() {
        }
    }

}
