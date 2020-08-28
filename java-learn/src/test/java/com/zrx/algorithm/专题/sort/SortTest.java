package com.zrx.algorithm.专题.sort;

import com.zrx.utils.ArrayFactory;
import com.zrx.utils.Timer;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SortTest {
    private final static Logger LOGGER = LoggerFactory.getLogger(SortTest.class);

    @Test
    void sorted() {
        for (int i = 0; i < 5; i++) {
            int[] ints = ArrayFactory.randomInts(100, 20);
            LOGGER.info("ints = {}", ints);
            Arrays.sort(ints);
            LOGGER.info("ints = {}", ints);
            Assert.assertTrue(Sort.sorted(ints));
        }
    }

    @Test
    void test() {
        List<Sort> sorts = List.of(
                new InsertionSort(),
                new SelectionSort(),
                new ShellSort()
        );

        Timer timer = Timer.create();
        sorts.forEach(sort -> {
            timer.start();
            for (int i = 0; i < 20; i++) {
                int len = new Random().nextInt(1000);
                int[] ints = ArrayFactory.randomInts(Integer.MAX_VALUE, len);
                sort.sort(ints);
                Assert.assertTrue("failed at " + sort, Sort.sorted(ints));
            }
            timer.stop();
            long duration = timer.getCurrentDuration();
            LOGGER.info("duration by {} = {}", sort.getClass(), duration);
            timer.reset();
        });
    }
}