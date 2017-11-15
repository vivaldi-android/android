package com.wealth.freedom.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

/**
 * @author: captain
 * Time:  2017/11/15 0015
 * Describe: 屏幕有关的辅助类
 */
public class ScreenUtils {

    private ScreenUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 获取屏幕宽度
     *
     * @param context
     * @return
     */
    public static int getScreenWidth(Context context) {
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(metrics);
        int width = metrics.widthPixels;
        return width;
    }

    /**
     * 获取屏幕高度
     *
     * @param context
     * @return
     */
    public static int getScreenHeight(Context context) {
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(metrics);
        int height = metrics.heightPixels;
        return height;
    }

    /**
     * 获取状态栏的高度
     *
     * @param context
     * @return
     */
    public static int getStatusHeight(Context context) {
        int statusHeight = -1;
        try {
            Class<?> cla = Class.forName("com.android.internal.R$dimen");
            Object object = cla.newInstance();
            int height = Integer.parseInt(cla.getField("status_bar_height").get(object).toString());
            statusHeight = context.getResources().getDimensionPixelSize(height);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusHeight;
    }

    /**
     * 获取当前屏幕截图，包括状态栏
     * @param activity
     * @return
     */
    public static Bitmap screenShotWithStatusBar(Activity activity) {
        View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap bit = view.getDrawingCache();
        int width = getScreenWidth(activity);
        int height = getScreenHeight(activity);
        Bitmap bitmap=null;
        bitmap = Bitmap.createBitmap(bit,0,0,width,height);
        view.destroyDrawingCache();
        Log.e("tag","截图生成了");
        return bitmap;
    }

    /**
     * 获取当前屏幕截图，不包括状态栏
     * @param activity
     * @return
     */
    public static Bitmap screenShotNoStatusBar(Activity activity){
        View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap bit = view.getDrawingCache();
        Rect rect= new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int statusHeight = rect.top;
        int width = getScreenWidth(activity);
        int height = getStatusHeight(activity);
        Bitmap bitmap=null;
        bitmap = Bitmap.createBitmap(bit,0,statusHeight,width,height-statusHeight);
        view.destroyDrawingCache();
        return bitmap;
    }

}
