package com.dexfun.yiku.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.chow.module.share.info.IShareInfo;
import com.chow.module.share.info.SimpleShareText;
import com.chow.module.share.templet.AbsWarpTemplateShare;
import com.chow.module.share.view.ShareView;
import com.dexfun.yiku.R;
import com.dexfun.yiku.UserClass;
import com.dexfun.yiku.activity.adapter.ItemDetailImageAdapter;
import com.dexfun.yiku.activity.adapter.XlPanelAdapter;
import com.dexfun.yiku.base.BaseActivity;
import com.dexfun.yiku.entity.BrandListEntity;
import com.dexfun.yiku.entity.DetailEntity;
import com.dexfun.yiku.entity.ProductListEntity;
import com.dexfun.yiku.fragment.home.ItemCommunityAdapter;
import com.dexfun.yiku.fragment.home.ItemPushViewAdapter2;
import com.dexfun.yiku.service.impl.HttpServiceImpl;
import com.dexfun.yiku.widget.CustomGridView;
import com.dexfun.yiku.widget.CustomListView;
import com.kelin.scrollablepanel.library.ScrollablePanel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class PSDetailActivity extends BaseActivity {
    @BindView(R.id.loop_viewpager_arc)
    ConvenientBanner convenientBanner;

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.img_d_ic)
    ImageView imgDIc;
    @BindView(R.id.tv_d_title)
    TextView tvDTitle;
    @BindView(R.id.list_detail)
    CustomListView listDetail;
    @BindView(R.id.list_push)
    CustomGridView listPush;
    @BindView(R.id.tab_xl)
    TabLayout tabXl;
    @BindView(R.id.to_brand)
    View toBrand;
    @BindView(R.id.to_kf)
    LinearLayout toKf;
    @BindView(R.id.to_yd)
    LinearLayout toYd;
    @BindView(R.id.add_cart)
    TextView addCart;
    @BindView(R.id.title_w)
    TextView titleW;
    @BindView(R.id.table)
    ScrollablePanel table;
    int id = -1;
    int type = -1;
    ShareView mShareView = null;

    @BindView(R.id.content)
    TextView content;
    @BindView(R.id.btn_edit_mys)
    TextView btnEditMys;
    @BindView(R.id.table_my)
    ScrollablePanel tableMy;
    @BindView(R.id.show_mys)
    LinearLayout showMys;
    @BindView(R.id.pic_list)
    ListView picList;
    @BindView(R.id.load_pic_all)
    TextView loadPicAll;
    @BindView(R.id.list_view)
    LinearLayout listView;
    @BindView(R.id.list_view2)
    LinearLayout listView2;

    @Override
    public int getLayoutId() {
        return R.layout.activity_detail;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        id = getIntent().getIntExtra("id", -1);
        findViewById(R.id.show_scm).setVisibility(View.GONE);
        listPush.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(PSDetailActivity.this, PSDetailActivity.class).putExtra("id", ((ItemPushViewAdapter2) listPush.getAdapter()).getItem(i).getClothingId()));
            }
        });
        mShareView = new ShareView(this, "分享");
        picList.setFocusable(false);
        picList.setFocusableInTouchMode(false);
    }

    @OnClick(R.id.share)
    void share() {
        mShareView.setShareInfo(this, new TestImpl(this));
        mShareView.show();
    }

    DetailEntity detailEntity;

    @Override
    public void getData(Bundle savedInstanceState) {
        listDetail.setFocusable(false);
        listPush.setFocusable(false);


        new HttpServiceImpl().getOrnamentInfo(id, data -> {
            if (data.getStatus() != 200) {
                return;
            }
            detailEntity = data;
            DetailEntity.DataEntity detail = data.getData();
            BrandListEntity brandDetail = detail.getBrandDetail();
            List<DetailEntity.DataEntity.ClothingBannerImgEntity> clothingBannerImg = detail.getClothingBannerImg();
            DetailEntity.DataEntity.ClothingDetailEntity clothingDetail = detail.getClothingDetail();
            List<ProductListEntity> productList = detail.getProductList();
            List<DetailEntity.DataEntity.ClothingDetailImgEntity> clothingDetailImg = detail.getClothingDetailImg();
            tvDTitle.setText(brandDetail.getBrandName());
            tvPrice.setText(String.valueOf(clothingDetail.getClothingPrice()));
            tvTitle.setText(Html.fromHtml("<font>来自：</font><font color=\"#FDDD55\">" + brandDetail.getBrandName() + "</font>"));
            titleW.setText(clothingDetail.getClothingName());
            Picasso.get().load(brandDetail.getBrandLargeLogo()).into(imgDIc);
            String clothingExplain = data.getData().getClothingDetail().getClothingExplain();
            content.setText(TextUtils.isEmpty(clothingExplain) ? "暂无" : clothingExplain);
            if (clothingBannerImg.size() != 0) {

                convenientBanner.setPages(() -> new LocalImageHolderView(), data.getData().getClothingBannerImg());
                convenientBanner.startTurning(2000);
                convenientBanner.setPageIndicator(new int[]{R.drawable.ic_page_indicator, R.drawable.ic_page_indicator_focused});

                convenientBanner.setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {
//                        startActivity(new Intent(DetailActivity.this, WebViewActivity.class).putExtra("url", data.getData().getClothingBannerImg().get(position).getClothingImgUrl()));
                    }
                });
            }
            tabXl.clearOnTabSelectedListeners();
            tabXl.removeAllTabs();
            for (DetailEntity.DataEntity.ClothingDetailEntity.ClothingStockDTOSEntity clothingStockDTOSEntity : clothingDetail.getClothingStockDTOS()) {
                tabXl.addTab(tabXl.newTab().setText(clothingStockDTOSEntity.getClothingStockType()));
            }
            type = clothingDetail.getClothingStockDTOS().get(0).getClothingStockId();
            tabXl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    type = clothingDetail.getClothingStockDTOS().get(tab.getPosition()).getClothingStockId();
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });
            listDetail.setAdapter(new ItemDetailImageAdapter(PSDetailActivity.this, clothingDetailImg));
            listPush.setAdapter(new ItemPushViewAdapter2(PSDetailActivity.this, productList));

            toBrand.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(PSDetailActivity.this, BrandDetailActivity.class).putExtra("id", data.getData().getBrandDetail().getBrandId()));

                }
            });
            DetailEntity.DataEntity.UserSizeTableEntity userSizeTable = detail.getUserSizeTable();
            if (userSizeTable.getUserSizeTableId() != null) {
                showMys.setVisibility(View.VISIBLE);
                ArrayList<List<String>> objects = new ArrayList<>();
                ArrayList<String> v1 = new ArrayList<>();
                v1.add("肩宽");
                v1.add("胸围");
                v1.add("腰围");
                v1.add("臀围");
                objects.add(v1);
                ArrayList<String> size = new ArrayList<>();
                size.add(String.valueOf(userSizeTable.getShoulderWidth()));
                size.add(String.valueOf(userSizeTable.getBust()));
                size.add(String.valueOf(userSizeTable.getTheWaist()));
                size.add(String.valueOf(userSizeTable.getHipline()));
                objects.add(size);
                tableMy.setPanelAdapter(new XlPanelAdapter(objects));
            } else {
                showMys.setVisibility(View.GONE);
            }
            if (data.getData().getArticle().size() == 0) {
                listView2.setVisibility(View.VISIBLE);
                listView.setVisibility(View.GONE);
            } else {
                listView.setVisibility(View.VISIBLE);
                listView2.setVisibility(View.GONE);
            }
            picList.setAdapter(new ItemCommunityAdapter(PSDetailActivity.this, data.getData().getArticle(), 0));

            List<DetailEntity.DataEntity.SizeTableVosEntity> sizeTableVos = detail.getSizeTableVos();
            if (sizeTableVos.size() == 0) {
                return;
            }
            int type = sizeTableVos.get(0).getType();
            ArrayList<List<String>> objects = new ArrayList<>();
            switch (type) {
                case 1:
                    ArrayList<String> v1 = new ArrayList<>();
                    v1.add("尺码");
                    v1.add("胸围");
                    v1.add("衣长");
                    v1.add("肩宽");
                    v1.add("袖长");
                    objects.add(v1);
                    for (DetailEntity.DataEntity.SizeTableVosEntity sizeTableVo : sizeTableVos) {
                        ArrayList<String> size = new ArrayList<>();
                        size.add(sizeTableVo.getModel());
                        size.add(sizeTableVo.getChestWidth());
                        size.add(sizeTableVo.getClothesLength());
                        size.add(sizeTableVo.getShoulderWidth());
                        size.add(sizeTableVo.getSleeveLength());
                        objects.add(size);
                    }
                    break;
                case 2:
                    ArrayList<String> v2 = new ArrayList<>();
                    v2.add("尺码");
                    v2.add("裤长");
                    v2.add("腰围");
                    v2.add("臀围");
                    objects.add(v2);
                    for (DetailEntity.DataEntity.SizeTableVosEntity sizeTableVo : sizeTableVos) {
                        ArrayList<String> size = new ArrayList<>();
                        size.add(sizeTableVo.getModel());
                        size.add(sizeTableVo.getTrousersLength());
                        size.add(sizeTableVo.getWaistline());
                        size.add(sizeTableVo.getHipline());
                        objects.add(size);
                    }
                    break;
                case 3:
                    ArrayList<String> v3 = new ArrayList<>();
                    v3.add("尺码");

                    if (!TextUtils.isEmpty(sizeTableVos.get(0).getSkirtLength())) {
                        v3.add("裙长");
                    }
                    if (!TextUtils.isEmpty(sizeTableVos.get(0).getChestWidth())) {
                        v3.add("胸围");
                    }
                    if (!TextUtils.isEmpty(sizeTableVos.get(0).getWaistline())) {
                        v3.add("腰围");
                    }
                    if (!TextUtils.isEmpty(sizeTableVos.get(0).getShoulderWidth())) {
                        v3.add("肩宽");
                    }
                    if (!TextUtils.isEmpty(sizeTableVos.get(0).getSleeveLength())) {
                        v3.add("袖长");
                    }

                    objects.add(v3);
                    for (DetailEntity.DataEntity.SizeTableVosEntity sizeTableVo : sizeTableVos) {
                        ArrayList<String> size = new ArrayList<>();
                        size.add(sizeTableVo.getModel());
                        if (!TextUtils.isEmpty(sizeTableVo.getSkirtLength())) {
                            size.add(sizeTableVo.getSkirtLength());
                        }
                        if (!TextUtils.isEmpty(sizeTableVo.getChestWidth())) {
                            size.add(sizeTableVo.getChestWidth());
                        }
                        if (!TextUtils.isEmpty(sizeTableVo.getWaistline())) {
                            size.add(sizeTableVo.getWaistline());
                        }
                        if (!TextUtils.isEmpty(sizeTableVo.getShoulderWidth())) {
                            size.add(sizeTableVo.getShoulderWidth());
                        }
                        if (!TextUtils.isEmpty(sizeTableVo.getSleeveLength())) {
                            size.add(sizeTableVo.getSleeveLength());
                        }
                        objects.add(size);
                    }
                    break;
                default:
            }
            table.setPanelAdapter(new XlPanelAdapter(objects));
        });

    }

    @OnClick(R.id.back)
    public void onBack() {
        onBackPressed();
    }

    @OnClick(R.id.load_pic_all)
    public void load_pic_all() {
        startActivity(new Intent(this, DetailCommunityActivity.class).putExtra("id", id));
    }


    @OnClick(R.id.btn_edit_mys)
    public void btn_edit_mys() {
        startActivity(new Intent(this, SizeTabActivity.class));
    }


    public class LocalImageHolderView implements Holder<DetailEntity.DataEntity.ClothingBannerImgEntity> {
        private ImageView imageView;


        @Override
        public void UpdateUI(Context context, int position, DetailEntity.DataEntity.ClothingBannerImgEntity data) {

            Picasso.get().load(data.getClothingImgUrl()).into(imageView);
        }

        @Override
        public View createView(Context context) {
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            return imageView;
        }
    }

    @OnClick({R.id.to_kf, R.id.to_yd, R.id.add_cart})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.to_kf:
                if (!UserClass.getInstance().isLogin(this)) return;
//                UserClass.connect(UserClass.getrToken());
//                CSCustomServiceInfo.Builder csBuilder = new CSCustomServiceInfo.Builder();
//                CSCustomServiceInfo csInfo = csBuilder.nickName(UserClass.getUserName()).build();
////                    RongIM.getInstance().startCustomerServiceChat(MainClass.getInstance(), "KEFU152024228589645", "客服", csInfo);
//                RongIM.getInstance().startConversation(MainClass.getInstance(), Conversation.ConversationType.CUSTOMER_SERVICE, "KEFU152024228589645", "客服");
                CenterDialog centerDialog = new CenterDialog(this);
                centerDialog.setMessage("客服服务时间 10:00-19:00");
                centerDialog.setNoOnclickListener("拨打电话", () -> {
                    //首先需要构造使用客服者的用户信息
                    centerDialog.dismiss();
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:010-52894251"));
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);


                });
                centerDialog.setYesOnclickListener("取消", () -> {
                    centerDialog.dismiss();
//                        CSCustomServiceInfo.Builder csBuilder = new CSCustomServiceInfo.Builder();
//                        CSCustomServiceInfo csInfo = csBuilder.nickName(tvUsername.getText().toString()).build();
////                    RongIM.getInstance().startCustomerServiceChat(MainClass.getInstance(), "KEFU152024228589645", "客服", csInfo);
//                        RongIM.getInstance().startConversation(getActivity(), Conversation.ConversationType.CUSTOMER_SERVICE, "KEFU152024228589645", "客服");

                });

                centerDialog.show();
                break;
            case R.id.to_yd:
                if (UserClass.getInstance().isLogin(this))
                    startActivity(new Intent(PSDetailActivity.this, CartActivity.class));
                break;
            case R.id.add_cart:
                if (UserClass.getInstance().isLogin(this))
                    new HttpServiceImpl().addClothingToCart(id, type, data -> {
                        switch (data.getStatus()) {
                            case 200:
                                Toast.makeText(PSDetailActivity.this, "已加入购物车", Toast.LENGTH_SHORT).show();
//                            startActivity(new Intent(DetailActivity.this, CartActivity.class));
                                break;
                            case 412:
                                Toast.makeText(PSDetailActivity.this, "商品不存在", Toast.LENGTH_SHORT).show();
                                break;
                            case 413:
                                Toast.makeText(PSDetailActivity.this, "商品库存不足", Toast.LENGTH_SHORT).show();
                                break;
                            case 414:
                                Toast.makeText(PSDetailActivity.this, "购物车存在该商品", Toast.LENGTH_SHORT).show();
                                break;
                            default:
                        }
                    });
                break;
            default:
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        mShareView.setOnActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }


    public class TestImpl extends AbsWarpTemplateShare {
        public TestImpl(Context context) {
            super(context);
        }

        @Override
        public IShareInfo warpWechatInfo() {
            return new SimpleShareText(detailEntity.getData().getClothingDetail().getClothingName(), "衣库家的这件衣服超美哦，忍不住想要分享给你", "http://img-cdn.xykoo.cn/appHtml/share/share.html?clothing_id=" + id, detailEntity.getData().getClothingDetail().getClothingImgUrl());
        }

        @Override
        public IShareInfo warpSinaInfo() {
            return new SimpleShareText(detailEntity.getData().getClothingDetail().getClothingName(), "衣库家的这件衣服超美哦，忍不住想要分享给你", "http://img-cdn.xykoo.cn/appHtml/share/share.html?clothing_id=" + id, detailEntity.getData().getClothingDetail().getClothingImgUrl());
        }

        @Override
        public IShareInfo warpQQInfo() {
            return new SimpleShareText(detailEntity.getData().getClothingDetail().getClothingName(), "衣库家的这件衣服超美哦，忍不住想要分享给你", "http://img-cdn.xykoo.cn/appHtml/share/share.html?clothing_id=" + id, detailEntity.getData().getClothingDetail().getClothingImgUrl());
        }

        @Override
        public IShareInfo warpMessageInfo() {
            return new SimpleShareText(detailEntity.getData().getClothingDetail().getClothingName(), "衣库家的这件衣服超美哦，忍不住想要分享给你", "http://img-cdn.xykoo.cn/appHtml/share/share.html?clothing_id=" + id, detailEntity.getData().getClothingDetail().getClothingImgUrl());
        }
    }
}
