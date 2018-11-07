package com.dexfun.layout;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;

public class DexLayoutActivity extends AppCompatActivity {
    private static final String LAYOUT_LINEAR_LAYOUT = "LinearLayout";
    private static final String LAYOUT_FRAME_LAYOUT = "FrameLayout";
    private static final String LAYOUT_RELATIVE_LAYOUT = "RelativeLayout";
    private static final String LAYOUT_CARD_LAYOUT = "android.support.v7.widget.CardView";
    private static final String LAYOUT_TAB_LAYOUT = "android.support.v7.widget.TabLayout";
    private static final String LAYOUT_TOOL_BAR = "android.support.v7.widget.Toolbar";


    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        View view = null;
//        System.out.println(name);
        switch (name) {
            case LAYOUT_FRAME_LAYOUT:
                view = new DexFrameLayout(context, attrs);
                break;
            case LAYOUT_LINEAR_LAYOUT:
                view = new DexLinearLayout(context, attrs);
                break;
            case LAYOUT_RELATIVE_LAYOUT:
                view = new DexRelativeLayout(context, attrs);
                break;
            case LAYOUT_CARD_LAYOUT:
                view = new DexCardView(context, attrs);
                break;
            case LAYOUT_TAB_LAYOUT:
                view = new DexTabLayout(context, attrs);
                break;
        }
        if (view != null) return view;
        return super.onCreateView(name, context, attrs);
    }


}
