package com.dexfun.yiku.utils;

import android.app.Activity;
import android.text.TextUtils;

import com.alipay.sdk.app.PayTask;

import java.lang.ref.WeakReference;
import java.util.Map;


/**
 * Created by Smile on 17/5/31.
 */

public class AliPay {

    private OnAliPayListener mListener;
    private WeakReference<Activity> mActivity;

    public AliPay(Activity activity) {
        mActivity = new WeakReference<>(activity);
    }

    public void doPay(String obj) {
        Activity activity = mActivity.get();
        if (activity == null) {
            return;
        }
        PayTask alipay = new PayTask(activity);
        new Thread(() -> {
            Map<String, String> result = alipay.payV2(obj, true);
            activity.runOnUiThread(() -> {
                for (Map.Entry<String, String> entry : result.entrySet()) {
                    System.out.println("key= " + entry.getKey() + " and value= "
                            + entry.getValue());
                }
                String resultStatus = result.get("resultStatus");
                if (TextUtils.equals(resultStatus, "9000")) {
                    if (mListener != null) {
                        mListener.onSuccess();
                    }
                } else {
                    if (TextUtils.equals(resultStatus, "8000")) {
                        if (mListener != null) {
                            mListener.onWait();
                        }
                    } else {
                        if (mListener != null) {
                            mListener.onCancel();
                        }
                    }
                }
            });
        }).start();
    }

    public AliPay setOnAliPayListener(OnAliPayListener l) {
        mListener = l;
        return this;
    }

    public abstract static class OnAliPayListener {
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

        /**
         * 等待确认
         */
        public void onWait() {
        }
    }

}
