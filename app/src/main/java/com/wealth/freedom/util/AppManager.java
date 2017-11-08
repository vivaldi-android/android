package com.wealth.freedom.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

import java.util.Stack;

/**
 * Author:  captain
 * Time:  2017/11/8 0008
 * Describe: activity的进栈退栈管理
 */
public class AppManager {
    private static AppManager appManager;
    private Stack<Activity> activities;

    public AppManager() {
    }

    /**
     * 单例
     */
    public static AppManager getInstance() {
        if (appManager == null) {
            synchronized (AppManager.class) {
                if (appManager == null) {
                    appManager = new AppManager();
                }
            }
        }
        return appManager;
    }

    /**
     * 添加activity到堆栈
     *
     * @param activity
     */
    public void addActivity(Activity activity) {
        if (activities == null) {
            activities = new Stack<Activity>();
        }
        activities.add(activity);
    }

    /**
     * 获取当前Activity（堆栈中最后一个入栈）
     *
     * @return
     */
    public Activity currentActivity() {
        Activity activity = activities.lastElement();
        return activity;
    }

    /**
     * 结束最后一个进入堆栈的Activity
     */
    public void finishLastActivity() {
        Activity activity = activities.lastElement();
        finishTargrtActivity(activity);
    }

    /**
     * 结束指定的Activity
     *
     * @param activity
     */
    public void finishTargrtActivity(Activity activity) {
        if (activity != null) {
            activities.remove(activity);
            activity.finish();
            activity = null;
        }
    }

    /**
     * 结束指定类名的Activity
     *
     * @param cs
     */
    public void finishActivity(Class<?> cs) {
        for (Activity activity : activities) {
            if (activity.getClass().equals(cs)) {
                finishTargrtActivity(activity);
            }
        }
    }

    /**
     * 结束堆栈中所有的Activity
     */
    public void finishAllActivity() {
        for (int i = 0; i < activities.size(); i++) {
            if (null != activities.get(i)) {
                activities.get(i).finish();
            }
        }
        activities.clear();
    }

    /**
     * 退出应用程序
     *
     * @param context
     */
    public void exitApp(Context context) {
        try {
            finishAllActivity();
            ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            manager.killBackgroundProcesses(context.getPackageName());
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
