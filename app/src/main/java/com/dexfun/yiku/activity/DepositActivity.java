package com.dexfun.yiku.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.dexfun.yiku.R;
import com.dexfun.yiku.base.BaseActivity;
import com.dexfun.yiku.entity.GetUserInfoEntity;
import com.dexfun.yiku.service.impl.HttpServiceImpl;
import com.dexfun.yiku.widget.BaseDialog;

import butterknife.BindView;
import butterknife.OnClick;

public class DepositActivity extends BaseActivity {

    @BindView(R.id.tv_status)
    TextView tvStatus;
    @BindView(R.id.btn_buy)
    TextView btnBuy;

    private boolean btnStatus = false;

    @Override
    public int getLayoutId() {
        return R.layout.activity_deposit;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setTitle("押金");
    }

    @Override
    public void getData(Bundle savedInstanceState) {
        new HttpServiceImpl().getUserInfo(data -> {
            if (data.getStatus() == 200) {
//                if (data.getData().getUserInfo().getNewUser() == 0) {
//
//                } else {
                    GetUserInfoEntity.DataEntity.CardInfoEntity cardInfo = data.getData().getCardInfo();
                    if (cardInfo.getDepositEffective() == 0 || cardInfo.getDepositEffective() == 2 || cardInfo.getDepositEffective() == 3) {
                        tvStatus.setText("缴纳押金享受以下权益");
                        btnBuy.setText("缴纳押金");
                        btnBuy.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                        btnBuy.setTextColor(getResources().getColor(R.color.white));
                        btnStatus = false;
                    } else {
                        tvStatus.setText("您当前正在享受以下权益");
                        btnBuy.setText("退回押金");
                        btnBuy.setBackgroundColor(Color.parseColor("#FFDDDDDD"));
                        btnBuy.setTextColor(Color.parseColor("#FFAFAFAF"));
                        btnStatus = true;
                    }
//                }

            }
        });
    }

    @OnClick(R.id.btn_buy)
    public void onViewClicked() {
        if (!btnStatus) {
            new BaseDialog(this, true)
                    .setMessage("确认缴纳押金")
                    .setPositiveButton("确定", (dialogInterface, i) -> {
                        dialogInterface.cancel();
                        PayDialogClass.setOnPayListener(new PayDialogClass.OnPayListener() {
                            @Override
                            public void onSuccess() {
                                Toast.makeText(DepositActivity.this, "缴纳成功", Toast.LENGTH_SHORT).show();
                                onBackPressed();
                            }

                            @Override
                            public void onCancel() {
                                Toast.makeText(DepositActivity.this, "支付取消", Toast.LENGTH_SHORT).show();
                            }
                        });
                        PayDialogClass.startPayClass(DepositActivity.this, 0,1,0);
                    })
                    .setNegativeButton("取消", (dialogInterface, i) -> dialogInterface.cancel())
                    .show();
        } else {
            new BaseDialog(this, true)
                    .setMessage("确认退回押金")
                    .setPositiveButton("确定", (dialogInterface, i) -> {
                        dialogInterface.cancel();
                        new HttpServiceImpl().getRefundApply(data -> {
                            if (data.getStatus() == 200) {
                                getData(null);
                                Toast.makeText(this, "退款成功 1-3个工作日返回原支付账户", Toast.LENGTH_SHORT).show();
                            } else if (data.getStatus() == 439) {
                                Toast.makeText(this, "押金都没交 你来这里想干啥子", Toast.LENGTH_SHORT).show();
                            } else if (data.getStatus() == 442) {
                                Toast.makeText(this, "还有订单未完成 请先完成再来", Toast.LENGTH_SHORT).show();
                            }
                        });
                    })
                    .setNegativeButton("取消", (dialogInterface, i) -> dialogInterface.cancel())
                    .show();
        }

    }

}
