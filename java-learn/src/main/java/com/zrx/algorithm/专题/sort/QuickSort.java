package com.zrx.algorithm.专题.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

/**
 * Description
 * QuickSort
 * <p>
 *
 * @author madokast
 * @version 1.0
 */

public class QuickSort implements Sort {
    private final static Logger LOGGER = LoggerFactory.getLogger(QuickSort.class);

    @Override
    public void sort(int[] arr) {
        sort(arr, 0, arr.length);
    }

    private void sort(int[] arr, int startIn, int endEx) {
        if (startIn >= endEx) return;

        int i = startIn;
        int j = endEx - 1;

        int pivotIndex = findPivotIndex(arr, startIn, endEx);

        int pivot = arr[pivotIndex];

        arr[pivotIndex] = arr[i];

        while (i < j) {
            while (j > i && arr[j] >= pivot) j--;
            if (j > i) arr[i] = arr[j];

            while (i < j && arr[i] < pivot) i++;
            if (i < j) arr[j] = arr[i];
        }

        Assert.isTrue(i == j, "QuickSort i == j  fails");

        arr[i] = pivot;

        sort(arr, startIn, i);
        sort(arr, i+1, endEx);

    }

    private int findPivotIndex(int[] arr, int startIn, int endEx) {
        return (startIn + endEx) / 2;
    }


}
