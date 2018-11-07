package com.dexfun.yiku.activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.dexfun.yiku.R;
import com.dexfun.yiku.activity.adapter.test.SchoolListActivity2;
import com.dexfun.yiku.base.BaseActivity;
import com.dexfun.yiku.entity.DefaultEntity;
import com.dexfun.yiku.entity.GetUserInfoEntity;
import com.dexfun.yiku.service.impl.HttpServiceImpl;
import com.dexfun.yiku.utils.PicassoImageLoader;
import com.lzy.imagepicker.DataHolder;
import com.lzy.imagepicker.ImagePicker;
import com.lzy.imagepicker.adapter.ImageRecyclerAdapter;
import com.lzy.imagepicker.bean.ImageFolder;
import com.lzy.imagepicker.bean.ImageItem;
import com.lzy.imagepicker.ui.ImageCropActivity;
import com.lzy.imagepicker.ui.ImageGridActivity;
import com.lzy.imagepicker.ui.ImagePreviewActivity;
import com.lzy.imagepicker.util.Utils;
import com.lzy.imagepicker.view.CropImageView;
import com.lzy.imagepicker.view.GridSpacingItemDecoration;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import cn.addapp.pickers.common.LineConfig;
import cn.addapp.pickers.listeners.OnItemPickListener;
import cn.addapp.pickers.picker.SinglePicker;
import de.hdodenhof.circleimageview.CircleImageView;

public class UserInfoActivity extends BaseActivity {

    @BindView(R.id.img_icon)
    CircleImageView imgIcon;
    @BindView(R.id.btn_set_phone)
    FrameLayout btnSetPhone;
    @BindView(R.id.btn_set_sex)
    FrameLayout btnSetSex;
    private static final int REQUEST_CODE_SELECT = 155;
    @BindView(R.id.tv_name)
    EditText tvName;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_sex)
    TextView tvSex;
    @BindView(R.id.tv_set_school)
    TextView tv_set_school;
    private int schoolId = 0;
    private boolean directPhoto = true; // 默认不是直接调取相机
    private ImagePicker imagePicker;
    public static final String EXTRAS_TAKE_PICKERS = "TAKE";
    public static final String EXTRAS_IMAGES = "IMAGES";
    ImageRecyclerAdapter mRecyclerAdapter;

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        directPhoto = savedInstanceState.getBoolean(EXTRAS_TAKE_PICKERS, true);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(EXTRAS_TAKE_PICKERS, directPhoto);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_user_info;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setTitle("个人资料");
        ImagePicker imagePicker = ImagePicker.getInstance();
        imagePicker.setMultiMode(false);
        imagePicker.setImageLoader(new PicassoImageLoader());   //设置图片加载器
        imagePicker.setShowCamera(true);  //显示拍照按钮
        imagePicker.setCrop(true);        //允许裁剪（单选才有效）
        imagePicker.setSaveRectangle(true); //是否按矩形区域保存
        imagePicker.setSelectLimit(9);    //选中数量限制
        imagePicker.setStyle(CropImageView.Style.RECTANGLE);  //裁剪框的形状
        imagePicker.setFocusWidth(800);   //裁剪框的宽度。单位像素（圆形自动取宽高最小值）
        imagePicker.setFocusHeight(800);  //裁剪框的高度。单位像素（圆形自动取宽高最小值）
        imagePicker.setOutPutX(1000);//保存文件的宽度。单位像素
        imagePicker.setOutPutY(1000);//保存文件的高度。单位像素
    }

    @Override
    public void getData(Bundle savedInstanceState) {
        new HttpServiceImpl().getUserInfo(new HttpServiceImpl.OnObjectDataListener<GetUserInfoEntity>() {
            @Override
            public void onData(GetUserInfoEntity data) {
                if (data.getStatus() == 200) {
                    GetUserInfoEntity.DataEntity.UserInfoEntity userInfo = data.getData().getUserInfo();
                    tvName.setText(userInfo.getNickname());
                    tvPhone.setText(userInfo.getPhone());
                    tvSex.setText(userInfo.getGender() == 2 ? "男" : "女");
                    Picasso.get()//
                            .load(userInfo.getPhoto())//
                            .placeholder(R.drawable.lollipop)//
                            .error(R.drawable.lollipop)//
                            .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)//
                            .into(imgIcon);
                    if (!TextUtils.isEmpty(data.getData().getSchool().getSchoolName())) {
                        tv_set_school.setText(data.getData().getSchool().getSchoolName());
                    }

                }

            }
        });
    }

    //选择器dialog
    public void showDialog() {
        SinglePicker<String> picker = new SinglePicker<>(this,
                new String[]{
                        "男", "女"
                });
//        picker.setCanLoop(false);//不禁用循环
        picker.setTopBackgroundColor(0xFFEEEEEE);
        picker.setTopHeight(50);
        picker.setTopLineColor(0xFF33B5E5);
        picker.setTopLineHeight(1);
        picker.setTitleText("请选择");
        picker.setTitleTextColor(0xFF999999);
        picker.setTitleTextSize(12);
        picker.setCancelTextColor(0xFF33B5E5);
        picker.setCancelTextSize(13);
        picker.setSubmitTextColor(0xFF33B5E5);
        picker.setSubmitTextSize(13);
        picker.setSelectedTextColor(0xFFEE0000);
        picker.setUnSelectedTextColor(0xFF999999);
        LineConfig config = new LineConfig();
        config.setColor(0xFFEE0000);//线颜色
        config.setAlpha(140);//线透明度
        config.setRatio((float) (1.0 / 8.0));//线比率
        picker.setLineConfig(config);
        picker.setItemWidth(200);
        picker.setBackgroundColor(0xFFE1E1E1);
        //picker.setSelectedItem(isChinese ? "处女座" : "Virgo");
//        picker.setSelectedIndex(7);
        picker.setOnItemPickListener(new OnItemPickListener<String>() {
            @Override
            public void onItemPicked(int index, String item) {
                tvSex.setText(item);
            }
        });
        picker.show();
    }

    @OnClick(R.id.btn_set_s)
    void setSize() {
        startActivity(new Intent(this, SizeTabActivity.class));
    }

    @OnClick({R.id.img_icon, R.id.btn_set_phone, R.id.btn_set_sex, R.id.btn_set_school})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_icon:
                View update_head = LayoutInflater.from(this).inflate(R.layout.update_head, null);
                LinearLayout camera = update_head.findViewById(R.id.camera);
                LinearLayout photo = update_head.findViewById(R.id.photo);
                TextView cancel = update_head.findViewById(R.id.cancel);
                PopupWindow popupWindow = new PopupWindow(update_head, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
                camera.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        imagePicker = ImagePicker.getInstance();
                        imagePicker.clear();
                        imagePicker.addOnImageSelectedListener(new ImagePicker.OnImageSelectedListener() {
                            @Override
                            public void onImageSelected(int position, ImageItem item, boolean isAdd) {

                            }
                        });


                        Intent data = getIntent();
                        // 新增可直接拍照
                        if (data != null && data.getExtras() != null) {
                            directPhoto = data.getBooleanExtra(EXTRAS_TAKE_PICKERS, false); // 默认不是直接打开相机
                            if (directPhoto) {
                                if (!(checkPermission(Manifest.permission.CAMERA))) {
                                    ActivityCompat.requestPermissions(UserInfoActivity.this, new String[]{Manifest.permission.CAMERA}, ImageGridActivity.REQUEST_PERMISSION_CAMERA);
                                } else {
                                    imagePicker.takePicture(UserInfoActivity.this, ImagePicker.REQUEST_CODE_TAKE);
                                }
                            }
                            ArrayList<ImageItem> images = (ArrayList<ImageItem>) data.getSerializableExtra(EXTRAS_IMAGES);
                            imagePicker.setSelectedImages(images);
                        }
                        mRecyclerAdapter = new ImageRecyclerAdapter(UserInfoActivity.this, null);
                    }
                });
                photo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(UserInfoActivity.this, ImageGridActivity.class);
                        intent.putExtra(EXTRAS_TAKE_PICKERS, false); // 是否是直接打开相机
                        startActivityForResult(intent, REQUEST_CODE_SELECT);
                    }
                });
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });
                popupWindow.showAtLocation(update_head, Gravity.BOTTOM, 0, 0);
                break;
            case R.id.btn_set_phone:
                Intent phone = new Intent(UserInfoActivity.this, UpdatePhoneActivity.class).putExtra("phone", tvPhone.getText().toString());
                startActivityForResult(phone, 601);
                break;
            case R.id.btn_set_sex:
                showDialog();
                break;
            case R.id.btn_set_school:
                startActivityForResult(new Intent(UserInfoActivity.this, SchoolListActivity2.class), 1118);
                break;
            default:
        }
    }

    private boolean checkPermission(String camera) {
        return false;
    }

    @Override
    public void onBackPressed() {
        new HttpServiceImpl()
                .setUserInfo(tvName.getText().toString()
                        , tvSex.getText().toString().equals("男") ? 2 : 1, schoolId
                        , new HttpServiceImpl.OnObjectDataListener<DefaultEntity>() {
                            @Override
                            public void onData(DefaultEntity data) {
//                if (data.getStatus()==200){
//                    Toast.makeText(UserInfoActivity.this, "更新成功", Toast.LENGTH_SHORT).show();
//                }else {
//                    Toast.makeText(UserInfoActivity.this, "更新失败", Toast.LENGTH_SHORT).show();
//                }
                            }
                        });
        super.onBackPressed();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == ImagePicker.RESULT_CODE_ITEMS) {
            if (data != null && requestCode == REQUEST_CODE_SELECT) {
                ArrayList<ImageItem> images = (ArrayList<ImageItem>) data.getSerializableExtra(ImagePicker.EXTRA_RESULT_ITEMS);
                Picasso.get()//
                        .load(Uri.fromFile(new File(images.get(0).path)))//
//                        .placeholder(R.mipmap.youjiantou)//
//                        .error(R.drawable.lollipop)//
                        .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)//
                        .into(imgIcon);
                new HttpServiceImpl().setUploadFile(new File(images.get(0).path));
            } else {
                Toast.makeText(this, "没有数据", Toast.LENGTH_SHORT).show();
            }
        }
        if (resultCode == 602) {
            tvPhone.setText(data.getStringExtra("phone"));
        }
        if (requestCode == 1118 || resultCode == 100) {
            schoolId = data.getIntExtra("schoolId", 0);
            tv_set_school.setText(data.getStringExtra("name"));
            new HttpServiceImpl().setSchoolList(schoolId, new HttpServiceImpl.OnObjectDataListener<DefaultEntity>() {
                @Override
                public void onData(DefaultEntity data) {
                    Toast.makeText(UserInfoActivity.this, data.getMsg(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

}
