package com.dexfun.yiku.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.transition.Slide;
import android.transition.Transition;
import android.util.Base64;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.dexfun.yiku.R;
import com.dexfun.yiku.base.BaseActivity;
import com.dexfun.yiku.entity.PayEntity;
import com.dexfun.yiku.service.impl.HttpServiceImpl;
import com.dexfun.yiku.utils.AliPay;
import com.dexfun.yiku.utils.UiUtils;
import com.dexfun.yiku.utils.WeChatPay;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Smile on 17/12/14.
 */

public class PayDialogClass extends BaseActivity {
    @BindView(R.id.ali_pay)
    RadioButton aliPay;
    @BindView(R.id.wexin_pay)
    RadioButton wexinPay;
    @BindView(R.id.cancel_pay)
    TextView cancelPay;
    @BindView(R.id.confirm_pay)
    TextView confirmPay;
    @BindView(R.id.pay_content)
    View payContent;
    @BindView(R.id.pay_activity)
    View payActivity;
    private static OnPayListener mListener;


    @Override
    public int getLayoutId() {
        UiUtils.setStatusBarLightMode(this);
        return R.layout.dialog_pay_type;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        aliPay.setChecked(true);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            Slide slide = new Slide();
            slide.setDuration(300);
            slide.setSlideEdge(Gravity.BOTTOM);
            getWindow().setEnterTransition(slide);
        }
        payContent.setOnClickListener(null);
    }

    @Override
    public void getData(Bundle savedInstanceState) {

    }

    @OnClick({R.id.cancel_pay, R.id.confirm_pay, R.id.pay_activity})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.cancel_pay:
                onBackPressed();
                break;
            case R.id.confirm_pay:
                new HttpServiceImpl().pay(aliPay.isChecked() ? 1 : 2, getIntent().getIntExtra("buyCardType", -1), getIntent().getIntExtra("hasYj", -1), getIntent().hasExtra("activity") ? getIntent().getIntExtra("activity", 0) : 0, new HttpServiceImpl.OnObjectDataListener<PayEntity>() {
                    @Override
                    public void onData(PayEntity data) {
                        if (data.getStatus() == 200) {
                            if (aliPay.isChecked()) {
                                new AliPay(PayDialogClass.this).setOnAliPayListener(new AliPay.OnAliPayListener() {
                                    @Override
                                    public void onSuccess() {

                                        if (mListener != null) mListener.onSuccess();
                                        onBackPressed();
                                    }

                                    @Override
                                    public void onCancel() {

                                        if (mListener != null) mListener.onCancel();
                                        onBackPressed();
                                    }

                                    @Override
                                    public void onWait() {
                                        onBackPressed();
                                        Toast.makeText(PayDialogClass.this, "请返回等待支付结果", Toast.LENGTH_SHORT).show();
                                    }
                                }).doPay(new String(Base64.decode(data.getData().getAlipay(), Base64.DEFAULT)));
                            } else {
                                new WeChatPay(PayDialogClass.this).setOnWeChatPayListener(new WeChatPay.OnWeChatPayListener() {
                                    @Override
                                    public void onSuccess() {
                                        if (mListener != null) mListener.onSuccess();
                                        onBackPressed();
                                    }

                                    @Override
                                    public void onCancel() {

                                        if (mListener != null) mListener.onCancel();
                                        onBackPressed();
                                    }
                                }).pay(data.getData().getPartnerid(), data.getData().getPrepayid(), data.getData().getNoncestr(), data.getData().getTimestamp(), data.getData().getSign());

                            }
                        } else if (data.getStatus() == 439) {
                            Toast.makeText(PayDialogClass.this, "请先交纳押金再来续费", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(PayDialogClass.this, data.getMsg(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                break;
            case R.id.pay_activity:

                onBackPressed();
                break;
            default:
        }
    }

    public static void startPayClass(Activity context, int buyCardType, int hasYj, int activity) {
        Intent intent = new Intent(context, PayDialogClass.class);
        intent.putExtra("buyCardType", buyCardType);
        intent.putExtra("hasYj", hasYj);
        intent.putExtra("activity", activity);
        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(context);
        context.startActivity(intent, activityOptionsCompat.toBundle());
    }

    public static void setOnPayListener(OnPayListener l) {
        mListener = l;
    }

    public abstract static class OnPayListener {
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
