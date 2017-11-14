package com.wealth.freedom.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author: vavaldi
 * Time:  2017/11/14
 * Describe:
 */

public class DateUtils {
    /**
     * @return 获取当天的时间
     */
    public static String getTodayDateTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",
                Locale.getDefault());
        return format.format(new Date());
    }

    /**
     * @param longtime
     * @return 通过longTime 获取时间
     */
    public static String getTimeBylong(long longtime) {
        Date date = new Date(longtime);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",
                Locale.getDefault());
        String currentTime = format.format(date);
        return currentTime;
    }

    /**
     * @return 获取当天的日期
     */
    public static String getTodayDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd",
                Locale.getDefault());
        return format.format(new Date());
    }
}
