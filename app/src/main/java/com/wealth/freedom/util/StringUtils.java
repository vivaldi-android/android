package com.wealth.freedom.util;

/**
 * @author: captain
 * Time:  2017/11/17 0017
 * Describe:字符串相关判断
 */
public class StringUtils {
    private StringUtils() {
        throw new UnsupportedOperationException("cannot cannot be instantiated");
    }

    /**
     * 判断字符串长度为0或者为空
     *
     * @param s 字符串
     * @return true ：空；false ：不为空
     */
    public static boolean isEmpty(final CharSequence s) {
        return s == null || s.length() == 0;
    }

    /**
     * 判断字符串是否为空或者全部为空格
     *
     * @param s 字符串
     * @return true:为空或者全为空格；false：不为空且不全是空格
     */
    public static boolean isTrimeEmpty(final String s) {
        return (s == null || s.trim().length() == 0);
    }

    /**
     * 判断字符串是否为null或者全空白符
     *
     * @param s 字符串
     * @return true：null或全空白符；false ：不为空且不全是空白符
     */
    public static boolean isSpace(final String s) {
        if (s == null) {
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isWhitespace(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断两个字符串是否相等
     * @param s1 字符串一
     * @param s2 字符串二
     * @return true 相等；false 不相等
     */
    public static boolean equals(final CharSequence s1, final CharSequence s2) {
        if (s1 == s2) {
            return true;
        }
        int length = s1.length();
        if (s1 != null && s2 != null && length == s2.length()) {
            if (s1 instanceof String && s2 instanceof String) {
                return s1.equals(s2);
            } else {
                for (int i = 0; i < length; i++) {
                    if (s1.charAt(i) != s2.charAt(i)) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    /**
     * 判断两个字符串是否相等，忽略大小写
     * @param s1
     * @param s2
     * @return
     */
    public static boolean equalsIgnoreCase(final String s1,final String s2){
        return s1==null?s2==null:s1.equalsIgnoreCase(s2);
    }


    /**
     * 获取字符串的长度
     * @param s
     * @return 字符串为null返回0
     */
    public static int getLength(final CharSequence s){
        return s==null ? 0:s.length();
    }

    /**
     * 字符串首字母大写
     * @param s
     * @return
     */
    public static String upFirstLetter(final String s){
        if(isEmpty(s)|| !Character.isLowerCase(s.charAt(0))){
            return s;
        }
        return String.valueOf((char)(s.charAt(0)-32))+s.substring(1);
    }

    /**
     * 字符串首字母小写
     * @param s
     * @return
     */
    public static String lowerFirstLetter(final String s){
        if(isEmpty(s)|| !Character.isUpperCase(s.charAt(0))){
            return s;
        }
        return String.valueOf((char)(s.charAt(0)+32))+s.substring(1);
    }

    /**
     * 反转字符串
     * @param s
     * @return
     */
    public static String reversal(final String s){
      int len = getLength(s);
        if(len<=1){
            return s;
        }
        int mid = len>>1;
        char[] chars = s.toCharArray();
        char c;
        for (int i = 0; i < mid; ++i) {
            c = chars[i];
            chars[i] = chars[len - i - 1];
            chars[len - i - 1] = c;
        }
        return new String(chars);
    }


}
