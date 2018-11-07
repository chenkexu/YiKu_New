package com.dexfun.yiku.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dexfun.layout.DexLinearLayout;

/**
 * @author Smile
 * @date 18/1/11
 */

public class SquareLinearLayout extends DexLinearLayout {

//    private boolean isDraw = true;

    public SquareLinearLayout(Context context) {
        super(context);
    }

    public SquareLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(getDefaultSize(0, widthMeasureSpec), getDefaultSize(0, heightMeasureSpec));
        int childWidthSize = getMeasuredWidth();
        heightMeasureSpec = widthMeasureSpec = MeasureSpec.makeMeasureSpec(childWidthSize, MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
//
//    @Override
//    protected void dispatchDraw(Canvas canvas) {
//        super.dispatchDraw(canvas);
//        if (isDraw) {
//            isDraw = false;
//            System.out.println("SquareLinearLayout.dispatchDraw");
//            View rootView = SquareLinearLayout.this;
//            ImageView imageView = (ImageView) getChildAt(0);
//            TextView textView = (TextView) getChildAt(1);
//            if (null == imageView || null == textView) {
//                return;
//            }
//            int width = rootView.getWidth();
//            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
//            layoutParams.height = width / 2;
//            layoutParams.width = width / 2;
//            imageView.setLayoutParams(layoutParams);
//            textView.setTextSize((float) (width / 2 / 2 / 2 / 2 / 2 * 1.4));
//            textView.setPadding(0, (int) (width / 2 / 2 / 2 / 2 / 2 * 2), 0, 0);
//        }
//    }

}
