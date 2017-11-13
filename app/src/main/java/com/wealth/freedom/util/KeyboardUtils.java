package com.wealth.freedom.util;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * @author: captain
 * Time:  2017/11/13 0013
 * Describe: 键盘相关工具类
 */
public class KeyboardUtils {
    private KeyboardUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 显示软键盘
     * @param view
     * @param mContext
     */
    public static void showKeyboard(View view, Context mContext)
    {
        InputMethodManager imm = (InputMethodManager) mContext
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(view, InputMethodManager.RESULT_SHOWN);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,
                InputMethodManager.HIDE_IMPLICIT_ONLY);
    }


    /**
     * 隐藏软键盘
     * @param view
     * @param mContext
     */
    public static void hideKeyboard(View  view, Context mContext)
    {
        InputMethodManager imm = (InputMethodManager) mContext
                .getSystemService(Context.INPUT_METHOD_SERVICE);

        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
