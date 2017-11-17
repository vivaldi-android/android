package com.wealth.freedom.util;


import com.wealth.freedom.entry.RegexConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: captain
 * Time:  2017/11/17 0017
 * Describe:
 */
public class RegexUtils {
    private RegexUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 验证手机号（简单）
     *
     * @param mobile
     * @return
     */
    public static boolean isMobileSimple(final CharSequence mobile) {
        return isMatch(RegexConstants.REGEX_MOBILE_SIMPLE, mobile);
    }

    /**
     * 验证手机号码（精准）
     *
     * @param mobile
     * @return
     */
    public static boolean isMoblieAccuracy(final CharSequence mobile) {
        return isMatch(RegexConstants.REGEX_MOBLIE_ACCURACY, mobile);
    }

    /**
     * 验证电话号码（精准）
     *
     * @param tel
     * @return
     */
    public static boolean isTel(final CharSequence tel) {
        return isMatch(RegexConstants.REGEX_TEL, tel);
    }

    /**
     * 验证身份证号码 十五位数
     *
     * @param idCard
     * @return
     */
    public static boolean isIDCardOld(final CharSequence idCard) {
        return isMatch(RegexConstants.REGEX_ID_CARD15, idCard);
    }

    /**
     * 验证身份证号码 十八位数
     *
     * @param idCard
     * @return
     */
    public static boolean isIDCardNew(final CharSequence idCard) {
        return isMatch(RegexConstants.REGEX_ID_CARD18, idCard);
    }

    /**
     * 验证邮箱
     *
     * @param emial
     * @return
     */
    public static boolean isEmail(final CharSequence emial) {
        return isMatch(RegexConstants.REGEX_EMAIL, emial);
    }

    /**
     * 验证网址
     *
     * @param url
     * @return
     */
    public static boolean isUrl(final CharSequence url) {
        return isMatch(RegexConstants.REGEX_URL, url);
    }

    /**
     * 验证中文
     *
     * @param chinese
     * @return
     */
    public static boolean isChinese(final CharSequence chinese) {
        return isMatch(RegexConstants.REGEX_ZH, chinese);
    }

    /**
     * 判断是否匹配正则
     *
     * @param regex        正则表达式
     * @param charSequence
     * @return
     */
    public static boolean isMatch(final String regex, final CharSequence charSequence) {
        return charSequence != null && charSequence.length() > 0 && Pattern.matches(regex, charSequence);
    }

    /**
     * 验证用户名
     * <p>取值范围为a-z,A-Z,0-9,"_",汉字，不能以"_"结尾,用户名必须是6-20位</p>
     *
     * @param input
     * @return
     */
    public static boolean isUsername(final CharSequence input) {
        return isMatch(RegexConstants.REGEX_USERNAME, input);
    }

    /**
     * 验证yyyy-MM-dd格式的日期校验，已考虑平闰年
     *
     * @param input
     * @return
     */
    public static boolean isDate(final CharSequence input) {
        return isMatch(RegexConstants.REGEX_DATE, input);
    }

    /**
     * 验证IP地址
     *
     * @param input
     * @return
     */
    public static boolean isIP(final CharSequence input) {
        return isMatch(RegexConstants.REGEX_IP, input);
    }

    /**
     * 验证双字节字符
     *
     * @param input
     * @return
     */
    public static boolean isDoubleByte(final CharSequence input) {
        return isMatch(RegexConstants.REGEX_DOUBLE_BYTE_CHAR, input);
    }

    /**
     * 验证空白行
     *
     * @param input
     * @return
     */
    public static boolean isSplaceLine(final CharSequence input) {
        return isMatch(RegexConstants.REGEX_BLANK_LINE, input);
    }

    /**
     * 验证QQ
     *
     * @param input
     * @return
     */
    public static boolean isQQ(final CharSequence input) {
        return isMatch(RegexConstants.REGEX_TENCENT_NUM, input);
    }

    /**
     * 验证邮编
     *
     * @param input
     * @return
     */
    public static boolean isPostalCode(final CharSequence input) {
        return isMatch(RegexConstants.REGEX_ZIP_CODE, input);
    }

    /**
     * 验证正整数
     *
     * @param input
     * @return
     */
    public static boolean isPositiveInteger(final CharSequence input) {
        return isMatch(RegexConstants.REGEX_POSITIVE_INTEGER, input);
    }

    /**
     * 验证负整数
     *
     * @param input
     * @return
     */
    public static boolean isNegativeInteger(final CharSequence input) {
        return isMatch(RegexConstants.REGEX_NEGATIVE_INTEGER, input);
    }

    /**
     * 验证整数
     *
     * @param input
     * @return
     */
    public static boolean isInteger(final CharSequence input) {
        return isMatch(RegexConstants.REGEX_INTEGER, input);
    }

    /**
     * 验证非负整数
     *
     * @param input
     * @return
     */
    public static boolean isNotNegativeInteger(final CharSequence input) {
        return isMatch(RegexConstants.REGEX_NOT_NEGATIVE_INTEGER, input);
    }

    /**
     * 验证非正整数
     *
     * @param input
     * @return
     */
    public static boolean isNotPositiveInteger(final CharSequence input) {
        return isMatch(RegexConstants.REGEX_NOT_POSITIVE_INTEGER, input);
    }

    /**
     * 验证正浮点数
     *
     * @param input
     * @return
     */
    public static boolean isPositiveFloat(final CharSequence input) {
        return isMatch(RegexConstants.REGEX_POSITIVE_FLOAT, input);
    }

    /**
     * 验证负浮点数
     *
     * @param input
     * @return
     */
    public static boolean isNegativeFloat(final CharSequence input) {
        return isMatch(RegexConstants.REGEX_NEGATIVE_FLOAT, input);
    }

    /**
     * 获取正则匹配的部分
     *
     * @param regex 正则表达式
     * @param input 要匹配的字符串
     * @return 正则匹配的部分
     */
    public static List<String> getMatches(final String regex, final CharSequence input) {
        if (input == null) {
            return null;
        }
        List<String> matches = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            matches.add(matcher.group());
        }
        return matches;
    }

    /**
     * 获取正则匹配分组
     *
     * @param input 要分组的字符串
     * @param regex 正则表达式
     * @return 正则匹配分组
     */
    public static String[] getSplits(final String input, final String regex) {
        if (input == null) {
            return null;
        }
        return input.split(regex);
    }

    /**
     * 替换正则匹配的第一部分
     *
     * @param input       要替换的字符串
     * @param regex       正则表达式
     * @param replacement 代替者
     * @return 替换正则匹配的第一部分
     */
    public static String getReplaceFirst(final String input, final String regex, final String replacement) {
        if (input == null) {
            return null;
        }
        return Pattern.compile(regex).matcher(input).replaceFirst(replacement);
    }

    /**
     * 替换所有正则匹配的部分
     *
     * @param input       要替换的字符串
     * @param regex       正则表达式
     * @param replacement 代替者
     * @return 替换所有正则匹配的部分
     */
    public static String getReplaceAll(final String input, final String regex, final String replacement) {
        if (input == null) {
            return null;
        }

        return Pattern.compile(regex).matcher(input).replaceAll(replacement);
    }
}
