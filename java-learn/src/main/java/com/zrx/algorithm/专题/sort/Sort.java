package com.zrx.algorithm.专题.sort;

import com.zrx.utils.ArrayFactory;

public interface Sort {

    void sort(int[] arr);

    default void swap(int[] arr, int i, int j) {
        int ai = arr[i];
        int aj = arr[j];
        if (ai != aj) {
            arr[i] = aj;
            arr[j] = ai;
        }
    }

    static boolean sorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int pre = arr[i - 1];
            int cur = arr[i];

            if (pre > cur) return false;
        }

        return true;
    }
}
