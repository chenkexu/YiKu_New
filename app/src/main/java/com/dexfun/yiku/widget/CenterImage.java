package com.dexfun.yiku.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.dexfun.yiku.R;

/**
 * Created by Smile on 18/1/29.
 */

public class CenterImage extends android.support.v7.widget.AppCompatImageView {
    private Paint paint;
    private boolean isCenterImgShow;
    private Bitmap bitmap;

    public void setCenterImgShow(boolean centerImgShow) {
        isCenterImgShow = centerImgShow;
        if (isCenterImgShow) {
            bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.yqk);
            invalidate();
        }
    }

    public CenterImage(Context context) {
        super(context);
        init();
    }

    public CenterImage(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CenterImage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isCenterImgShow && bitmap != null) {
            canvas.drawBitmap(bitmap, getMeasuredWidth() / 2 - bitmap.getWidth() / 2, getMeasuredHeight() / 2 - bitmap.getHeight() / 2, paint);
        }
    }
}