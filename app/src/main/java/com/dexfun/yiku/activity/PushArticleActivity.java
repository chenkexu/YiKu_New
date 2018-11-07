package com.dexfun.yiku.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.dexfun.yiku.MainClass;
import com.dexfun.yiku.R;
import com.dexfun.yiku.activity.adapter.ImagePickerAdapter;

import com.dexfun.yiku.base.BaseActivity;
import com.dexfun.yiku.entity.DefaultEntity;
import com.dexfun.yiku.service.impl.HttpServiceImpl;
import com.lzy.imagepicker.ImagePicker;
import com.lzy.imagepicker.bean.ImageItem;
import com.lzy.imagepicker.ui.ImageGridActivity;
import com.lzy.imagepicker.ui.ImagePreviewDelActivity;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import top.zibin.luban.CompressionPredicate;
import top.zibin.luban.Luban;
import top.zibin.luban.OnCompressListener;

public class PushArticleActivity extends BaseActivity implements ImagePickerAdapter.OnRecyclerViewItemClickListener {

    public static final int IMAGE_ITEM_ADD = -1;
    public static final int REQUEST_CODE_SELECT = 100;
    public static final int REQUEST_CODE_PREVIEW = 101;

    private ImagePickerAdapter adapter;
    private ArrayList<ImageItem> selImageList; //当前选择的所有图片
    private int maxImgCount = 6;               //允许选择图片最大数

    @BindView(R.id.include_right_btn)
    TextView rightBtn;
    @BindView(R.id.tv_edit)
    EditText input;
    @BindView(R.id.tv_status)
    TextView tvStatus;


    @Override
    public int getLayoutId() {
        return R.layout.activity_push_article;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setTitle("发布");
        rightBtn.setText("取消");
        rightBtn.setTextColor(getResources().getColor(R.color.black));
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        selImageList = new ArrayList<>();
        adapter = new ImagePickerAdapter(this, selImageList, maxImgCount);
        adapter.setOnItemClickListener(this);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void getData(Bundle savedInstanceState) {
        System.out.println(getIntent().getIntExtra("id", -1));
        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int length = s.toString().length();
                tvStatus.setText(String.format("%d/140", length));
                if (length > 140) {
                    tvStatus.setTextColor(getResources().getColor(R.color.red));
                } else {
                    tvStatus.setTextColor(getResources().getColor(R.color.colorAccent));
                }
            }
        });
    }


    @Override
    public void onItemClick(View view, int position) {
        switch (position) {
            case IMAGE_ITEM_ADD:
//                List<String> names = new ArrayList<>();
//                names.add("拍照");
//                names.add("相册");
//                showDialog(new SelectDialog.SelectDialogListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                        switch (position) {
//                            case 0: // 直接调起相机
//                                /**
//                                 * 0.4.7 目前直接调起相机不支持裁剪，如果开启裁剪后不会返回图片，请注意，后续版本会解决
//                                 *
//                                 * 但是当前直接依赖的版本已经解决，考虑到版本改动很少，所以这次没有上传到远程仓库
//                                 *
//                                 * 如果实在有所需要，请直接下载源码引用。
//                                 */
//                                //打开选择,本次允许选择的数量
//                                ImagePicker.getInstance().setSelectLimit(maxImgCount - selImageList.size());
//                                Intent intent = new Intent(PushArticleActivity.this, ImageGridActivity.class);
//                                intent.putExtra(ImageGridActivity.EXTRAS_TAKE_PICKERS, true); // 是否是直接打开相机
//                                startActivityForResult(intent, REQUEST_CODE_SELECT);
//                                break;
//                            case 1:
//                                //打开选择,本次允许选择的数量
//                                ImagePicker.getInstance().setSelectLimit(maxImgCount - selImageList.size());
//                                Intent intent1 = new Intent(PushArticleActivity.this, ImageGridActivity.class);
//                                /* 如果需要进入选择的时候显示已经选中的图片，
//                                 * 详情请查看ImagePickerActivity
//                                 * */
////                                intent1.putExtra(ImageGridActivity.EXTRAS_IMAGES,images);
//                                startActivityForResult(intent1, REQUEST_CODE_SELECT);
//                                break;
//                            default:
//                                break;
//                        }
//
//                    }
//                }, names);

                //打开选择,本次允许选择的数量
                ImagePicker.getInstance().setSelectLimit(maxImgCount - selImageList.size());
                Intent intent1 = new Intent(PushArticleActivity.this, ImageGridActivity.class);
                                /* 如果需要进入选择的时候显示已经选中的图片，
                                 * 详情请查看ImagePickerActivity
                                 * */
//                                intent1.putExtra(ImageGridActivity.EXTRAS_IMAGES,images);
                startActivityForResult(intent1, REQUEST_CODE_SELECT);
                break;
            default:
                //打开预览
                Intent intentPreview = new Intent(this, ImagePreviewDelActivity.class);
                intentPreview.putExtra(ImagePicker.EXTRA_IMAGE_ITEMS, (ArrayList<ImageItem>) adapter.getImages());
                intentPreview.putExtra(ImagePicker.EXTRA_SELECTED_IMAGE_POSITION, position);
                intentPreview.putExtra(ImagePicker.EXTRA_FROM_ITEMS, true);
                startActivityForResult(intentPreview, REQUEST_CODE_PREVIEW);
                break;
        }
    }

    ArrayList<ImageItem> images = null;

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == ImagePicker.RESULT_CODE_ITEMS) {
            //添加图片返回
            if (data != null && requestCode == REQUEST_CODE_SELECT) {
                images = (ArrayList<ImageItem>) data.getSerializableExtra(ImagePicker.EXTRA_RESULT_ITEMS);
                if (images != null) {
                    selImageList.addAll(images);
                    adapter.setImages(selImageList);
                }
            }
        } else if (resultCode == ImagePicker.RESULT_CODE_BACK) {
            //预览图片返回
            if (data != null && requestCode == REQUEST_CODE_PREVIEW) {
                images = (ArrayList<ImageItem>) data.getSerializableExtra(ImagePicker.EXTRA_IMAGE_ITEMS);
                if (images != null) {
                    selImageList.clear();
                    selImageList.addAll(images);
                    adapter.setImages(selImageList);
                }
            }
        }
    }

    @OnClick(R.id.include_right_btn)
    void include_right_btn() {
        MainClass.finishActivity(AddArticleActivity.class);
        finish();
    }

    @OnClick(R.id.btn_push)
    void btn_push() {
        String text = input.getText().toString();
        if (TextUtils.isEmpty(text)) {
            Toast.makeText(this, "内容不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (text.length() > 160) {
            Toast.makeText(this, "内容过长 请精简一下哟~", Toast.LENGTH_SHORT).show();
            return;
        }
        List<String> files = new ArrayList<>();
        List<File> filesDto = new ArrayList<>();
        for (ImageItem imageItem : selImageList) {
            files.add(imageItem.path);
        }
        System.out.println(files);

        ProgressDialog progressDialog = new ProgressDialog(PushArticleActivity.this);
        progressDialog.setCancelable(false);
        progressDialog.setTitle("请稍后...");
        progressDialog.show();
        Luban.with(this)
                .load(files)
                .ignoreBy(150)
                .filter(new CompressionPredicate() {
                    @Override
                    public boolean apply(String path) {
                        return !TextUtils.isEmpty(path);
                    }
                })
                .setCompressListener(new OnCompressListener() {
                    @Override
                    public void onStart() {

                    }

                    @Override
                    public void onSuccess(File file) {
                        // TODO 压缩成功后调用，返回压缩后的图片文件
                        System.out.println(file.getAbsolutePath());
                        filesDto.add(file);
                        System.out.println(filesDto.size() + "----" + files.size());
                        if (filesDto.size() == files.size()) {
                            new HttpServiceImpl().setPublishArticles(getIntent().getIntExtra("id", -1), text, filesDto, getIntent().getIntExtra("idx",0),new HttpServiceImpl.OnObjectDataListener<DefaultEntity>() {
                                @Override
                                public void onData(DefaultEntity data) {
                                    if (data.getStatus() == 200) {
                                        Toast.makeText(PushArticleActivity.this, "发布成功", Toast.LENGTH_SHORT).show();
                                        progressDialog.cancel();
                                        MainClass.finishActivity(AddArticleActivity.class);
                                        finish();
                                    } else {
                                        Toast.makeText(PushArticleActivity.this, "发布失败 " + data.getMsg(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        progressDialog.cancel();
                        Toast.makeText(PushArticleActivity.this, "发布失败 图片无法压缩", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }
                }).launch();

    }
}
