package com.dexfun.layout;

import android.content.Context;

import android.support.v7.widget.CardView;
import android.util.AttributeSet;

import com.dexfun.layout.utils.DexLayoutHelper;



public class DexCardView extends CardView {
    private final DexLayoutHelper mHelper = new DexLayoutHelper(this);

    public DexCardView(Context context) {
        super(context);
    }

    public DexCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DexCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public DexFrameLayout.LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new DexFrameLayout.LayoutParams(getContext(), attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (!isInEditMode()) {
            mHelper.adjustChildren();
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }


}
