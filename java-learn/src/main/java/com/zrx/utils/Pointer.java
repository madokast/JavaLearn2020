package com.zrx.utils;

import jdk.internal.misc.Unsafe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Description
 * 指针
 * <p>
 * Data
 * 2020/4/7-9:38
 *
 * @author zrx
 * @version 1.0
 */

public class Pointer {
    private final static Logger LOGGER = LoggerFactory.getLogger(Pointer.class);

    /**
     * --add-opens java.base/jdk.internal.misc=ALL-UNNAMED
     */
    private final static Unsafe unsafe = Unsafe.getUnsafe();

    private static boolean warn = false;

    private static void warning() {
        if (!warn) {
            LOGGER.warn("此方法不安全，仅限于64位JVM压缩指针下运行");
            warn = true;
        }
    }

    public static Unsafe getUnsafe() {
        return unsafe;
    }

    /**
     * 获得对象的 mark work
     * 注意：此方法不安全，仅限于64位JVM压缩指针下运行
     *
     * @param o 对象
     * @return mark work 十六进制表示
     */
    public static long getMarkWord(Object o) {
        warning();
        Objects.requireNonNull(o);
        return unsafe.getLong(o, 0);
    }

    /**
     * 获得对象的 klass work
     * 注意：此方法不安全，仅限于64位JVM压缩指针下运行
     *
     * @param o 对象
     * @return klass work 十六进制表示
     */
    public static int getKlassWord(Object o) {
        warning();
        Objects.requireNonNull(o);
        return unsafe.getInt(o, 8);
    }

    /**
     * 写入 klass word 到对象 o
     * 注意：此方法不安全，仅限于64位JVM压缩指针下运行
     *
     * @param o         对象
     * @param klassWord klass word
     */
    public static void putKlassWord(Object o, int klassWord) {
        warning();
        Objects.requireNonNull(o);

        unsafe.putInt(o, 8, klassWord);
    }


    /**
     * 32位数据以 十六进制表示
     * 返回格式 xx xx xx xx
     *
     * @param value 32位数据
     * @return 十六进制表示，字符串形式
     */
    public static String toHexadecimalFrom(int value) {
        String s = Integer.toHexString(value).toUpperCase();
        int zeroNumber = 8 - s.length();

        StringBuilder sb = new StringBuilder(s);

        sb.insert(0, "0".repeat(zeroNumber));

        sb.insert(6, " ");
        sb.insert(4, " ");
        sb.insert(2, " ");

        return sb.toString();
    }

    /**
     * 64位数据以 十六进制表示
     * 返回格式 xx xx xx xx xx xx xx xx
     *
     * @param value 64位数据
     * @return 十六进制表示，字符串形式
     */
    public static String toHexadecimalFrom(long value) {
        String s = Long.toHexString(value);
        int zeroNumber = 16 - s.length();

        StringBuilder sb = new StringBuilder(s);

        sb.insert(0, "0".repeat(zeroNumber));

        for (int i = 14; i >= 2; i -= 2) {
            sb.insert(i, " ");
        }

        return sb.toString();
    }

    /**
     * 32位数据以 二进制表示
     * 返回格式 01111111 11111111 11111111 11111111
     *
     * @param value 32位数据
     * @return 二进制表示，字符串形式
     */
    public static String toBinaryString(int value) {
        String s = Integer.toBinaryString(value);
        int zeroNumber = 32 - s.length();

        StringBuilder sb = new StringBuilder(s);

        sb.insert(0, "0".repeat(zeroNumber));

        sb.insert(24, " ");
        sb.insert(16, " ");
        sb.insert(8, " ");

        return sb.toString();
    }
}
