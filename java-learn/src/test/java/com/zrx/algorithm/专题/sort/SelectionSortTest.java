package com.zrx.algorithm.专题.sort;

import com.zrx.utils.ArrayFactory;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

class SelectionSortTest {
    private final static Logger LOGGER = LoggerFactory.getLogger(SelectionSortTest.class);

    @Test
    void sort() {
        Sort sort = new SelectionSort();

        for (int i = 0; i < 10; i++) {
            int[] ints = ArrayFactory.randomInts(100, 10);
            LOGGER.info("ints-before = {}", ints);
            sort.sort(ints);
            LOGGER.info("ints-sort = {}", ints);
            Assert.assertTrue(Sort.sorted(ints));
        }
    }
}