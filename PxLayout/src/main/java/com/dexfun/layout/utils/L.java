package com.dexfun.layout.utils;

import android.util.Log;

public class L
{
    public static boolean debug = false;
    private static final String TAG = "DEX_LAYOUT";

    public static void e(String msg)
    {
        if (debug)
        {
            Log.e(TAG, msg);
        }
    }


}
