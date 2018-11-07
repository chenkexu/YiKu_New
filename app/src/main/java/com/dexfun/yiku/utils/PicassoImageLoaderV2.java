package com.dexfun.yiku.utils;

import android.app.Activity;
import android.net.Uri;
import android.widget.ImageView;

import com.dexfun.yiku.R;
import com.lzy.imagepicker.loader.ImageLoader;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.io.File;

public class PicassoImageLoaderV2 implements ImageLoader {

    @Override
    public void displayImage(Activity activity, String path, ImageView imageView, int width, int height) {
        System.out.println("activity = [" + activity + "], path = [" + path + "], imageView = [" + imageView + "], width = [" + width + "], height = [" + height + "]");
        Picasso.get()//
                .load(Uri.fromFile(new File(path)))//
                .placeholder(R.drawable.ic_default_image)//
                .error(R.drawable.ic_default_image)//
                .resize(width, height)//
                .centerInside()//
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)//
                .into(imageView);
    }

    @Override
    public void displayImagePreview(Activity activity, String path, ImageView imageView, int width, int height) {
        Picasso.get()//
                .load(Uri.fromFile(new File(path)))//
                .resize(width, height)//
                .centerInside()//
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)//
                .into(imageView);
    }

    @Override
    public void clearMemoryCache() {
    }
}
