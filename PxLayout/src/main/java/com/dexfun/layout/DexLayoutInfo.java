package com.dexfun.layout;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dexfun.layout.attr.Attrs;
import com.dexfun.layout.attr.AutoAttr;
import com.dexfun.layout.attr.HeightAttr;
import com.dexfun.layout.attr.MarginBottomAttr;
import com.dexfun.layout.attr.MarginLeftAttr;
import com.dexfun.layout.attr.MarginRightAttr;
import com.dexfun.layout.attr.MarginTopAttr;
import com.dexfun.layout.attr.MaxHeightAttr;
import com.dexfun.layout.attr.MaxWidthAttr;
import com.dexfun.layout.attr.MinHeightAttr;
import com.dexfun.layout.attr.MinWidthAttr;
import com.dexfun.layout.attr.PaddingBottomAttr;
import com.dexfun.layout.attr.PaddingLeftAttr;
import com.dexfun.layout.attr.PaddingTopAttr;
import com.dexfun.layout.attr.TextSizeAttr;
import com.dexfun.layout.attr.WidthAttr;
import com.dexfun.layout.attr.PaddingRightAttr;

import java.util.ArrayList;
import java.util.List;

public class DexLayoutInfo
{
    private List<AutoAttr> autoAttrs = new ArrayList<>();

    public void addAttr(AutoAttr autoAttr)
    {
        autoAttrs.add(autoAttr);
    }


    public void fillAttrs(View view)
    {
        for (AutoAttr autoAttr : autoAttrs)
        {
            autoAttr.apply(view);
        }
    }


    public static DexLayoutInfo getAttrFromView(View view, int attrs, int base)
    {
        ViewGroup.LayoutParams params = view.getLayoutParams();
        if (params == null) return null;
        DexLayoutInfo dexLayoutInfo = new DexLayoutInfo();

        // width & height
        if ((attrs & Attrs.WIDTH) != 0 && params.width > 0)
        {
            dexLayoutInfo.addAttr(WidthAttr.generate(params.width, base));
        }

        if ((attrs & Attrs.HEIGHT) != 0 && params.height > 0)
        {
            dexLayoutInfo.addAttr(HeightAttr.generate(params.height, base));
        }

        //margin
        if (params instanceof ViewGroup.MarginLayoutParams)
        {
            if ((attrs & Attrs.MARGIN) != 0)
            {
                dexLayoutInfo.addAttr(MarginLeftAttr.generate(((ViewGroup.MarginLayoutParams) params).leftMargin, base));
                dexLayoutInfo.addAttr(MarginTopAttr.generate(((ViewGroup.MarginLayoutParams) params).topMargin, base));
                dexLayoutInfo.addAttr(MarginRightAttr.generate(((ViewGroup.MarginLayoutParams) params).rightMargin, base));
                dexLayoutInfo.addAttr(MarginBottomAttr.generate(((ViewGroup.MarginLayoutParams) params).bottomMargin, base));
            }
            if ((attrs & Attrs.MARGIN_LEFT) != 0)
            {
                dexLayoutInfo.addAttr(MarginLeftAttr.generate(((ViewGroup.MarginLayoutParams) params).leftMargin, base));
            }
            if ((attrs & Attrs.MARGIN_TOP) != 0)
            {
                dexLayoutInfo.addAttr(MarginTopAttr.generate(((ViewGroup.MarginLayoutParams) params).topMargin, base));
            }
            if ((attrs & Attrs.MARGIN_RIGHT) != 0)
            {
                dexLayoutInfo.addAttr(MarginRightAttr.generate(((ViewGroup.MarginLayoutParams) params).rightMargin, base));
            }
            if ((attrs & Attrs.MARGIN_BOTTOM) != 0)
            {
                dexLayoutInfo.addAttr(MarginBottomAttr.generate(((ViewGroup.MarginLayoutParams) params).bottomMargin, base));
            }
        }

        //padding
        if ((attrs & Attrs.PADDING) != 0)
        {
            dexLayoutInfo.addAttr(PaddingLeftAttr.generate(view.getPaddingLeft(), base));
            dexLayoutInfo.addAttr(PaddingTopAttr.generate(view.getPaddingTop(), base));
            dexLayoutInfo.addAttr(PaddingRightAttr.generate(view.getPaddingRight(), base));
            dexLayoutInfo.addAttr(PaddingBottomAttr.generate(view.getPaddingBottom(), base));
        }
        if ((attrs & Attrs.PADDING_LEFT) != 0)
        {
            dexLayoutInfo.addAttr(MarginLeftAttr.generate(view.getPaddingLeft(), base));
        }
        if ((attrs & Attrs.PADDING_TOP) != 0)
        {
            dexLayoutInfo.addAttr(MarginTopAttr.generate(view.getPaddingTop(), base));
        }
        if ((attrs & Attrs.PADDING_RIGHT) != 0)
        {
            dexLayoutInfo.addAttr(MarginRightAttr.generate(view.getPaddingRight(), base));
        }
        if ((attrs & Attrs.PADDING_BOTTOM) != 0)
        {
            dexLayoutInfo.addAttr(MarginBottomAttr.generate(view.getPaddingBottom(), base));
        }

        //minWidth ,maxWidth , minHeight , maxHeight
        if ((attrs & Attrs.MIN_WIDTH) != 0)
        {
            dexLayoutInfo.addAttr(MinWidthAttr.generate(MinWidthAttr.getMinWidth(view), base));
        }
        if ((attrs & Attrs.MAX_WIDTH) != 0)
        {
            dexLayoutInfo.addAttr(MaxWidthAttr.generate(MaxWidthAttr.getMaxWidth(view), base));
        }
        if ((attrs & Attrs.MIN_HEIGHT) != 0)
        {
            dexLayoutInfo.addAttr(MinHeightAttr.generate(MinHeightAttr.getMinHeight(view), base));
        }
        if ((attrs & Attrs.MAX_HEIGHT) != 0)
        {
            dexLayoutInfo.addAttr(MaxHeightAttr.generate(MaxHeightAttr.getMaxHeight(view), base));
        }

        //textsize

        if (view instanceof TextView)
        {
            if ((attrs & Attrs.TEXTSIZE) != 0)
            {
                dexLayoutInfo.addAttr(TextSizeAttr.generate((int) ((TextView) view).getTextSize(), base));
            }
        }
        return dexLayoutInfo;
    }


    @Override
    public String toString()
    {
        return "AutoLayoutInfo{" +
                "autoAttrs=" + autoAttrs +
                '}';
    }
}