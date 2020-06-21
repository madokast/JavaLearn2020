package com.zrx.utils;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SortsTest {
    private final static Logger LOGGER = LoggerFactory.getLogger(SortsTest.class);
    Random random = new Random();

    @Test
    public void 堆排序测试(){
        Sorts sorts = new Sorts.HeapSort();
        排序算法测试01(sorts);
        排序算法测试01(sorts);
        排序算法测试01(sorts);
        排序算法测试01(sorts);

        for (int i = 0; i < 50; i++) 排序算法测试02(sorts,1);
        for (int i = 0; i < 50; i++) 排序算法测试02(sorts,2);
        for (int i = 0; i < 50; i++) 排序算法测试02(sorts,3);
        for (int i = 0; i < 50; i++) 排序算法测试02(sorts,4);
        for (int i = 0; i < 50; i++) 排序算法测试02(sorts,5);


        for (int i = 0; i < 500; i++) 排序算法测试02(sorts,5000);
    }


    private void 排序算法测试01(Sorts sorts) {
        int[] ints = Stream.generate(() -> random.nextInt(100)).limit(15).mapToInt(Integer::intValue).toArray();
        int[] copy = Arrays.copyOf(ints, ints.length);
        LOGGER.info("原数组 = {}", ints);
        sorts.sort(ints);
        LOGGER.info("排序后 = {}", ints);

        Arrays.sort(copy);
        LOGGER.info("正解 = {}", copy);
        assertArrayEquals(ints,copy,"排序失败!");
    }

    private void 排序算法测试02(Sorts sorts,int len) {
        int[] ints = Stream.generate(() -> random.nextInt(100)).limit(len).mapToInt(Integer::intValue).toArray();
        int[] copy = Arrays.copyOf(ints, ints.length);
//        LOGGER.info("原数组 = {}", ints);
        sorts.sort(ints);
//        LOGGER.info("排序后 = {}", ints);

        Arrays.sort(copy);
//        LOGGER.info("正解 = {}", copy);
        assertArrayEquals(ints,copy,"排序失败!");
    }
}