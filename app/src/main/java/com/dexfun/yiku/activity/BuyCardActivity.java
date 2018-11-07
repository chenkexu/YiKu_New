package com.dexfun.yiku.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dexfun.yiku.R;
import com.dexfun.yiku.activity.adapter.BuyCardPagerAdapter;
import com.dexfun.yiku.base.BaseActivity;
import com.dexfun.yiku.entity.AccountPEntity;
import com.dexfun.yiku.entity.BuyCardEntity;
import com.dexfun.yiku.entity.CardPriceEntity;
import com.dexfun.yiku.entity.GetUserInfoEntity;
import com.dexfun.yiku.service.impl.HttpServiceImpl;
import com.tencent.stat.StatService;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import me.shihao.library.XRadioGroup;

public class BuyCardActivity extends BaseActivity {

    @BindView(R.id.rd_month_card)
    RadioButton rdMonthCard;
    @BindView(R.id.rd_season_card)
    RadioButton rdSeasonCard;
    @BindView(R.id.rd_year_card)
    RadioButton rdYearCard;

    @BindView(R.id.cb_agreement)
    CheckBox cbAgreement;
    @BindView(R.id.tv_agreement)
    TextView tvAgreement;
    @BindView(R.id.btn_go)
    Button btnGo;

    @BindView(R.id.tv_yk)
    TextView tvYk;
    @BindView(R.id.tv_jk)
    TextView tvJk;
    @BindView(R.id.tv_nk)
    TextView tvNk;
    @BindView(R.id.tv_yj)
    TextView tvYj;
    @BindView(R.id.tv_lj)
    TextView tvLj;
    @BindView(R.id.tv_ya)
    TextView tvYa;
    @BindView(R.id.tv_mun)
    TextView tvMun;


    @BindView(R.id.id_mun_text)
    TextView 原价;
    @BindView(R.id.tv_zjzh)
    TextView 资金账户;
    @BindView(R.id.rc_msg)
    TextView rc_msg;
    @BindView(R.id.id_yjss)
    View id_yjss;

    @BindView(R.id.czxz)
    XRadioGroup 充值选择;
    @BindView(R.id.card_view)
    ViewPager viewPager;

    int ck = 0, yj = 0, yk = 0, jk = 0, nk = 0, dz = 0;//优惠券

    int type = 1, 活动选择 = 0;

    int zjzh = 0;

    private int hasYj = -1;//cardType 1是会员卡系列 2是乱七八糟的卡 payType 1是新用户 2是老用户


    private int index = 1;

    @Override
    public int getLayoutId() {
        return R.layout.activity_buy_card;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setTitle("购买会员");
        rdMonthCard.setChecked(true);
        tvAgreement.setText(Html.fromHtml("阅读并同意<u>充值说明</u>和<u>押金说明</u>"));
        cbAgreement.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) btnGo.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            else btnGo.setBackgroundColor(Color.parseColor("#FFDDDDDD"));
        });
        viewPager.setOffscreenPageLimit(3);//>=3
        viewPager.setPageMargin(20);
//        viewPager.setPageTransformer(true, new ViewPager.PageTransformer() {
//            @Override
//            public void transformPage(View page, float position) {
//                float v = Math.abs(position - 0.33f);
//                float v1 = (float) (2 * (v * v));
//                page.setScaleY(1 - v1);
//                page.setScaleX(1 - v1);
//            }
//        });

        findViewById(R.id.btn_left).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = index - 1;
                if (i != -1) {
                    viewPager.setCurrentItem(i, true);
                }
            }
        });

        findViewById(R.id.btn_right).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(index + 1, true);
            }
        });


    }


    @Override
    public void getData(Bundle savedInstanceState) {
        new HttpServiceImpl().getCardPrice(new HttpServiceImpl.OnObjectDataListener<CardPriceEntity>() {
            @Override
            public void onData(CardPriceEntity data) {
                if (data.getStatus() == 200) {
                    List<BuyCardEntity> imgList = new ArrayList<>();

//                    for (CardPriceEntity.DataEntity dataEntity : data.getData()) {
//                        if (dataEntity.getPriceType() == 4) {
//                            ck = dataEntity.getPrice();
//                            imgList.add(new BuyCardEntity("次卡", "一次三件", dataEntity.getPrice(), R.mipmap.cika));
//                        }
//
//                    }
                    for (CardPriceEntity.DataEntity dataEntity : data.getData()) {

                        if (dataEntity.getPriceType() == 0) {
                            tvYa.setText(String.format("￥%s元", String.valueOf(dataEntity.getPrice())));
                            yj = dataEntity.getPrice();
                        } else if (dataEntity.getPriceType() == 1) {
                            imgList.add(new BuyCardEntity("月卡", String.format("￥%d/天", dataEntity.getPrice() / 30), dataEntity.getPrice(), R.mipmap.yueka));
                            tvYk.setText(String.format("￥%s元", String.valueOf(dataEntity.getPrice())));
                            yk = dataEntity.getPrice();
                        } else if (dataEntity.getPriceType() == 2) {
                            imgList.add(new BuyCardEntity("季卡", String.format("￥%d/天", dataEntity.getPrice() / 30), dataEntity.getPrice(), R.mipmap.jika));
                            tvJk.setText(String.format("￥%s元", String.valueOf(dataEntity.getPrice())));
                            jk = dataEntity.getPrice();
                        } else if (dataEntity.getPriceType() == 3) {
                            imgList.add(new BuyCardEntity("年卡", String.format("￥%d/天", dataEntity.getPrice() / 30), dataEntity.getPrice(), R.mipmap.nianka));
                            nk = dataEntity.getPrice();
                            tvNk.setText(String.format("￥%s元", String.valueOf(dataEntity.getPrice())));
                        }

                    }
                    BuyCardPagerAdapter buyCardPagerAdapter = new BuyCardPagerAdapter(BuyCardActivity.this, imgList);
                    viewPager.setAdapter(buyCardPagerAdapter);
                    viewPager.setCurrentItem(1);
                    new HttpServiceImpl().queryAccount(new HttpServiceImpl.OnObjectDataListener<AccountPEntity>() {
                        @Override
                        public void onData(AccountPEntity data) {
                            if (data.getStatus() == 200) {
                                zjzh = data.getData().getCapital();
                            }

                            new HttpServiceImpl().getUserInfo(new HttpServiceImpl.OnObjectDataListener<GetUserInfoEntity>() {
                                @Override
                                public void onData(GetUserInfoEntity data) {
                                    GetUserInfoEntity.DataEntity.CardInfoEntity cardInfo = data.getData().getCardInfo();
                                    int newUser = data.getData().getUserInfo().getNewUser();
                                    //1是正式卡

                                    hasYj = cardInfo.getDepositEffective() != 1 ? 1 : 2;
                                    type = 1;
                                    if (!getIntent().hasExtra("id1")) {
                                        活动选择 = 0;
                                        dz = 0;
                                        tvLj.setText("选择优惠券>");
                                    } else {
                                        活动选择 = getIntent().getIntExtra("id1", 0);
                                        dz = getIntent().getIntExtra("p1", 0);
                                        tvLj.setText(String.format("-￥%d元", dz));
                                    }

                                    tvYj.setText(String.format("￥%s元", yk));
                                    原价.setText("月卡原价");
                                    int mun = yk;
                                    mun -= dz;


                                    if (mun - zjzh >= 1) {
                                        mun -= zjzh;
                                        资金账户.setText(String.format("账户剩余¥%d元，本次可抵¥%d元", zjzh, zjzh));
                                    } else {
                                        资金账户.setText(String.format("账户剩余¥%d元，本次可抵¥%d元", zjzh, mun - 1));
                                        mun = 1;
                                    }


                                    if (hasYj == 1) {
                                        id_yjss.setVisibility(View.VISIBLE);
                                        mun += yj;
                                    } else {
                                        id_yjss.setVisibility(View.GONE);
                                    }


                                    tvMun.setText(String.format("￥%d元", mun));
                                    btnGo.setText(String.format("去支付 ￥%d元", mun));


                                    viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                                        @Override
                                        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                                        }

                                        @Override
                                        public void onPageSelected(int position) {
                                            // 把当前显示的position传递出去
                                            System.out.println(position);
                                            index = position;
                                            tvLj.setText("选择优惠券>");
                                            tvLj.setEnabled(true);
                                            rc_msg.setOnClickListener(null);
                                            tvLj.setTextColor(getResources().getColor(R.color.red));
                                            if (position == -1) {
                                                rc_msg.setText(Html.fromHtml("次卡可享受衣库一次提供的无限换衣特权 <font color=\"#61ABFB\">查看详情</font>"));
                                                rc_msg.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        new AlertDialog.Builder(BuyCardActivity.this)
                                                                .setTitle("使用说明：")
                                                                .setMessage("1. 次卡购买后不可退订；\n" +
                                                                        "2. 从下单起开始计算日期，到归还衣袋为止，期限为7天；\n" +
                                                                        "3. 每超过期限一天，将从押金中扣除10元；超过7天期限，剩余押金将被冻结；\n" +
                                                                        "4. 如有疑问，请联系客服。")
                                                                .setPositiveButton("关闭", new DialogInterface.OnClickListener() {
                                                                    @Override
                                                                    public void onClick(DialogInterface dialog, int which) {

                                                                    }
                                                                }).show();
                                                    }
                                                });
                                                type = 4;
                                                tvYj.setText(String.format("￥%s元", ck));
                                                原价.setText("次卡原价");
                                                int mun = ck;


                                                if (mun - zjzh >= 1) {
                                                    mun -= zjzh;
                                                    资金账户.setText(String.format("账户剩余¥%d元，本次可抵¥%d元", zjzh, zjzh));
                                                } else {
                                                    资金账户.setText(String.format("账户剩余¥%d元，本次可抵¥%d元", zjzh, mun - 1));
                                                    mun = 1;
                                                }

                                                if (hasYj == 1) {
                                                    mun += yj;
                                                }

                                                tvMun.setText(String.format("￥%d元", mun));
                                                btnGo.setText(String.format("去支付 ￥%d元", mun));
                                                tvLj.setText("次卡不可使用优惠劵");
                                                tvLj.setEnabled(false);
                                                tvLj.setTextColor(getResources().getColor(R.color.colorAccent));
                                            } else if (position == 0) {
                                                rc_msg.setText("月卡可享受衣库30天内提供的无限换衣特权");
                                                tvYj.setText(String.format("￥%s元", yk));
                                                原价.setText("月卡原价");
                                                type = 1;

                                                int mun = yk;
                                                if (dz!=0){
                                                    tvLj.setText(String.format("-￥%d元", dz));
                                                }else {
                                                    tvLj.setText("选择优惠券>");
                                                }
                                                mun -= dz;

                                                if (mun - zjzh >= 1) {
                                                    mun -= zjzh;
                                                    资金账户.setText(String.format("账户剩余¥%d元，本次可抵¥%d元", zjzh, zjzh));
                                                } else {
                                                    资金账户.setText(String.format("账户剩余¥%d元，本次可抵¥%d元", zjzh, mun - 1));
                                                    mun = 1;
                                                }


                                                if (hasYj == 1) {
                                                    mun += yj;
                                                }
                                                tvMun.setText(String.format("￥%d元", mun));
                                                btnGo.setText(String.format("去支付 ￥%d元", mun));
                                            } else if (position == 1) {
                                                tvYj.setText(String.format("￥%s元", jk));
                                                原价.setText("季卡原价");
                                                rc_msg.setText("季卡可享受衣库90天内提供的无限换衣特权");
                                                type = 2;
                                                int mun = jk;
                                                if (dz!=0){
                                                    tvLj.setText(String.format("-￥%d元", dz));
                                                }else {
                                                    tvLj.setText("选择优惠券>");
                                                }
                                                mun -= dz;

                                                if (mun - zjzh >= 1) {
                                                    mun -= zjzh;
                                                    资金账户.setText(String.format("账户剩余¥%d元，本次可抵¥%d元", zjzh, zjzh));
                                                } else {
                                                    资金账户.setText(String.format("账户剩余¥%d元，本次可抵¥%d元", zjzh, mun - 1));
                                                    mun = 1;
                                                }

                                                if (hasYj == 1) {
                                                    mun += yj;
                                                }

                                                tvMun.setText(String.format("￥%d元", mun));
                                                btnGo.setText(String.format("去支付 ￥%d元", mun));

                                            } else if (position == 2) {
                                                tvYj.setText(String.format("￥%s元", nk));
                                                原价.setText("年卡原价");
                                                rc_msg.setText("年卡可享受衣库365天内提供的无限换衣特权");
                                                type = 3;

                                                if (dz!=0){
                                                    tvLj.setText(String.format("-￥%d元", dz));
                                                }else {
                                                    tvLj.setText("选择优惠券>");
                                                }
                                                int mun = nk;

                                                mun -= dz;


                                                if (mun - zjzh >= 1) {
                                                    mun -= zjzh;
                                                    资金账户.setText(String.format("账户剩余¥%d元，本次可抵¥%d元", zjzh, zjzh));
                                                } else {
                                                    资金账户.setText(String.format("账户剩余¥%d元，本次可抵¥%d元", zjzh, mun - 1));
                                                    mun = 1;
                                                }


                                                if (hasYj == 1) {
                                                    mun += yj;
                                                }

                                                tvMun.setText(String.format("￥%d元", mun));
                                                btnGo.setText(String.format("去支付 ￥%d元", mun));
                                            }


                                        }

                                        @Override
                                        public void onPageScrollStateChanged(int state) {

                                        }
                                    });


//                                    充值选择.setOnCheckedChangeListener(new XRadioGroup.OnCheckedChangeListener() {
//                                        @Override
//                                        public void onCheckedChanged(XRadioGroup xRadioGroup, int i) {
//                                            if (i == rdMonthCard.getId()) {
//                                                type = 1;
//
//                                                int mun = yk;
//                                                mun -= dz;
//                                                if (hasYj == 1) {
//                                                    mun += yj;
//                                                }
//                                                mun -= zjzh;
//                                                tvMun.setText(String.format("￥%d元", mun));
//                                                btnGo.setText(String.format("去支付 ￥%d元", mun));
//                                            } else if (i == rdSeasonCard.getId()) {
//                                                type = 2;
//                                                int mun = jk;
//
//                                                mun -= dz;
//                                                if (hasYj == 1) {
//                                                    mun += yj;
//                                                }
//                                                mun -= zjzh;
//                                                tvMun.setText(String.format("￥%d元", mun));
//                                                btnGo.setText(String.format("去支付 ￥%d元", mun));
//
//                                            } else if (i == rdYearCard.getId()) {
//                                                type = 3;
//
//
//                                                int mun = nk;
//                                                mun -= dz;
//                                                if (hasYj == 1) {
//                                                    mun += yj;
//                                                }
//                                                mun -= zjzh;
//                                                tvMun.setText(String.format("￥%d元", mun));
//                                                btnGo.setText(String.format("去支付 ￥%d元", mun));
//                                            }
//                                        }
//                                    });
                                }
                            });
                        }
                    });
                }
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @OnClick(R.id.btn_go)
    public void onViewClicked() {
        if (!cbAgreement.isChecked()) {
            Toast.makeText(this, "同意衣库协议才可使用", Toast.LENGTH_SHORT).show();
            return;
        }
        if (type ==4){
            Toast.makeText(this, "暂未开放购买 敬请期待", Toast.LENGTH_SHORT).show();
            return;
        }
        PayDialogClass.setOnPayListener(new PayDialogClass.OnPayListener() {
            @Override
            public void onSuccess() {
                StatService.trackCustomKVEvent(BuyCardActivity.this, "PayCard", null);
                Toast.makeText(BuyCardActivity.this, "购买成功", Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onCancel() {
                super.onCancel();
            }

            @Override
            public void onWait() {
                super.onWait();
            }
        });
        PayDialogClass.startPayClass(BuyCardActivity.this, type, hasYj, 活动选择);
    }

    @OnClick(R.id.tv_lj)
    public void btnShare() {
        startActivityForResult(new Intent(BuyCardActivity.this, CouponsListActivity.class), 6553);
    }

    @OnClick(R.id.tv_agreement)
    public void OnTvAgreement() {
        startActivity(new Intent(this, WebViewActivity.class).putExtra("url", "http://img-cdn.xykoo.cn/appHtml/userAgreement.html"));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 10005) {
            if (data.getIntExtra("id", 0) == 0) {
                活动选择 = 0;
                dz = 0;
                tvLj.setText("选择优惠券>");
            } else {
                活动选择 = data.getIntExtra("id", 0);
                dz = data.getIntExtra("p", 0);
                tvLj.setText(String.format("-￥%d元", dz));
            }
            System.err.println(活动选择);
            System.err.println(dz);
            if (index == -1) {
                int mun = ck;


                if (mun - zjzh >= 1) {
                    mun -= zjzh;
                    资金账户.setText(String.format("账户剩余¥%d元，本次可抵¥%d元", zjzh, zjzh));
                } else {
                    资金账户.setText(String.format("账户剩余¥%d元，本次可抵¥%d元", zjzh, mun - 1));
                    mun = 1;
                }

                if (hasYj == 1) {
                    mun += yj;
                }

                tvMun.setText(String.format("￥%d元", mun));
                btnGo.setText(String.format("去支付 ￥%d元", mun));
            }
            if (index == 0) {
                int mun = yk;
                mun -= dz;

                if (mun - zjzh >= 1) {
                    mun -= zjzh;
                    资金账户.setText(String.format("账户剩余¥%d元，本次可抵¥%d元", zjzh, zjzh));
                } else {
                    资金账户.setText(String.format("账户剩余¥%d元，本次可抵¥%d元", zjzh, mun - 1));
                    mun = 1;
                }
                if (hasYj == 1) {
                    mun += yj;
                }

                tvMun.setText(String.format("￥%d元", mun));
                btnGo.setText(String.format("去支付 ￥%d元", mun));
            }
            if (index == 1) {
                int mun = jk;
                mun -= dz;

                if (mun - zjzh >= 1) {
                    mun -= zjzh;
                    资金账户.setText(String.format("账户剩余¥%d元，本次可抵¥%d元", zjzh, zjzh));
                } else {
                    资金账户.setText(String.format("账户剩余¥%d元，本次可抵¥%d元", zjzh, mun - 1));
                    mun = 1;
                }
                if (hasYj == 1) {
                    mun += yj;
                }

                tvMun.setText(String.format("￥%d元", mun));
                btnGo.setText(String.format("去支付 ￥%d元", mun));

            }
            if (index == 2) {
                int mun = nk;
                mun -= dz;
                if (mun - zjzh >= 1) {
                    mun -= zjzh;
                    资金账户.setText(String.format("账户剩余¥%d元，本次可抵¥%d元", zjzh, zjzh));
                } else {
                    资金账户.setText(String.format("账户剩余¥%d元，本次可抵¥%d元", zjzh, mun - 1));
                    mun = 1;
                }
                if (hasYj == 1) {
                    mun += yj;
                }

                tvMun.setText(String.format("￥%d元", mun));
                btnGo.setText(String.format("去支付 ￥%d元", mun));
            }
        }
    }
}