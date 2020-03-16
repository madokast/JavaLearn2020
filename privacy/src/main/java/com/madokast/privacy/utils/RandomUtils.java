package com.madokast.privacy.utils;

import java.util.Random;

/**
 * Description
 * 随机类
 * <p>
 * Data
 * 16:46
 *
 * @author zrx
 * @version 1.0
 */

public class RandomUtils {
    private static Random random = new Random();

    /**
     * 随机数字
     * @param smallIncluding 最小
     * @param bigIncluding 最大
     * @return 随机数
     */
    public static int randomInt(int smallIncluding,int bigIncluding){
        return random.nextInt(bigIncluding-smallIncluding + 1) + smallIncluding;
    }

    /**
     * 随机英文名字
     * @param length 长度
     * @return 随机英文名字
     */
    public static String randomName(int length) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            final int nextInt = random.nextInt(26);
            stringBuilder.append((char)('a' + nextInt));
        }

        return stringBuilder.toString();
    }

    /**
     * 随机英文名字
     * @param shortLength 最短长度
     * @param longLength 最长长度
     * @return 随机英文名字
     */
    public static String randomName(int shortLength, int longLength) {
        return randomName(randomInt(shortLength,longLength));
    }

    /**
     * 随机英文名字 长度 [3,9]
     * @return 随机英文名字
     */
    public static String randomName(){
        return randomName(3,9);
    }
}
