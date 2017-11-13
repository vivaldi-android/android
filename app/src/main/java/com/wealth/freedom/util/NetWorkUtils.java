package com.wealth.freedom.util;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

/**
 * @author: captain
 * Time:  2017/11/13 0013
 * Describe: 网络相关的工具类
 * 需要{android.permission.ACCESS_NETWORK_STATE权限}
 */
public class NetWorkUtils {
    private NetWorkUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 获取活动网络信息
     * @param context
     * @return
     */
    public static NetworkInfo getNetworkInfo(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager!=null){
            return  connectivityManager.getActiveNetworkInfo();
        }
        return null;
    }

    /**
     * 当前网络是否连接
     * @param context
     * @return
     */
    public static boolean isConnected(Context context) {
        NetworkInfo networkInfo = getNetworkInfo(context);
        if (networkInfo != null && networkInfo.isConnected()) {
            if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断当前网络是否连接可用
     * @param context
     * @return
     */
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager == null) {
            return false;
        } else {
            NetworkInfo[] networkInfo = connectivityManager.getAllNetworkInfo();
            if (networkInfo != null && networkInfo.length > 0) {
                for (int i = 0; i < networkInfo.length; i++) {
                    if (networkInfo[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    /**
     * 当前网络是否为WIFI
     * @param context
     * @return
     */
    public static boolean isWifi(Context context) {
        NetworkInfo networkInfo = getNetworkInfo(context);
        if (networkInfo != null && networkInfo.isConnected()) {
            int type = networkInfo.getType();
            if (type == ConnectivityManager.TYPE_WIFI) {
                return true;
            }
        }
        return false;
    }

    /**
     * 当前网络是否为4G
     * @param context
     * @return
     */
    public static boolean is4G(Context context) {
        NetworkInfo networkInfo = getNetworkInfo(context);
        if (networkInfo != null && networkInfo.isConnected()) {
            int type = networkInfo.getType();
            if (type == TelephonyManager.NETWORK_TYPE_LTE) {
                return true;
            }
        }
        return false;
    }

    /**
     * 打开网络设置页面
     * @param activity
     */
    public static void openNetSetting(Activity activity){
        Intent intent;
        if(android.os.Build.VERSION.SDK_INT>10){
            intent = new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS);
        }else{
            intent = new Intent();
            ComponentName component = new ComponentName("com.android.settings","com.android.settings.WirelessSettings");
            intent.setComponent(component);
            intent.setAction("android.intent.action.VIEW");
        }
        activity.startActivityForResult(intent, 0);
    }
}
