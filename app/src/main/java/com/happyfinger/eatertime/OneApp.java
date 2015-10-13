package com.happyfinger.eatertime;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

/**
 * Created by jiaoyang on 7/23/15.
 */
public class OneApp extends Application {
    private static OneApp INSTANCE;
    private Handler mHandler;

    public OneApp() {
        INSTANCE = this;
        mHandler = new Handler(Looper.getMainLooper());
    }

    public static OneApp getInstance() {
        return INSTANCE;
    }

    public static Handler getHandler() {
        return INSTANCE.mHandler;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
