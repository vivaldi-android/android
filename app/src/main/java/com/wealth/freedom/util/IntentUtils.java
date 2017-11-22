package com.wealth.freedom.util;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * @author: vavaldi
 * Time:  2017/11/22
 * Describe:
 */

public class IntentUtils {
    /**
     * 跳转页面
     *
     * @param context
     * @param cls
     */
    public static void openActivity(Context context, Class<?> cls) {
        openActivity(context, cls, null);
    }

    /**
     * 跳转页面传递数据
     *
     * @param context
     * @param cls
     */
    public static void openActivity(Context context, Class<?> cls, Bundle bundle) {
        Intent intent = new Intent();
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.setClass(context, cls);
        context.startActivity(intent);
    }
}
