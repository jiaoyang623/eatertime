package com.happyfinger.eatertime.utils;

import android.util.Log;

/**
 * Created by jiaoyang on 9/26/15.
 */
public class UU {
    public static void log(String tag, Object... param) {
        if (param == null && param.length == 0) {
            return;
        }
        StringBuilder builder = new StringBuilder();
        for (Object obj : param) {
            builder.append(obj).append(", ");
        }
        Log.i(tag, builder.toString());
    }

    public static void j(Object... param) {
        log("jy", param);
    }
}
