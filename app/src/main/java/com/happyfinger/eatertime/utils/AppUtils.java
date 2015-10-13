package com.happyfinger.eatertime.utils;


import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import com.happyfinger.eatertime.OneApp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiaoyang on 7/23/15.
 */
public class AppUtils {
    public static String getVersionName() {
        Context ctx = OneApp.getInstance();

        PackageInfo pm;
        try {
            pm = ctx.getPackageManager().getPackageInfo(ctx.getPackageName(),
                    PackageManager.GET_CONFIGURATIONS);
            return pm.versionName;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static int getVersionCode() {
        Context ctx = OneApp.getInstance();
        PackageInfo pm;
        try {
            pm = ctx.getPackageManager().getPackageInfo(ctx.getPackageName(),
                    PackageManager.GET_CONFIGURATIONS);
            return pm.versionCode;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int getOSVersion() {
        return Build.VERSION.SDK_INT;
    }

    public static String getChannel() {
        Context context = OneApp.getInstance();
        String channel;
        try {
            ApplicationInfo appInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            channel = appInfo.metaData.getString("UMENG_CHANNEL");
        } catch (NameNotFoundException e) {
            channel = "10001";
        }

        return channel;
    }

    public static List<String> getAppList() {
        List<PackageInfo> packageInfoList = OneApp.getInstance().
                getPackageManager().getInstalledPackages(0); //返回已安装的包信息列表
        List<String> appList = new ArrayList<String>(packageInfoList.size());
        for (PackageInfo packageInfo : packageInfoList) {
                /*
                 * 判断是否为非系统应用
                 * */
            if ((packageInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 0) {
                appList.add(packageInfo.packageName);
            }
        }
        return appList;
    }
}

