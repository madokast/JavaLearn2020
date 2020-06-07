package com.zrx.algorithm.leetcode.q0000;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.utils.ArrayFactory;
import com.zrx.utils.MyLoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Description
 * Q0004寻找两个有序数组的中位数
 * <p>
 * Data
 * 2020/3/29-23:12
 *
 * @author zrx
 * @version 1.0
 */
@Component
public class Q0004寻找两个有序数组的中位数 implements Question {
    private final static Logger LOGGER = MyLoggerFactory.getLogger(Q0004寻找两个有序数组的中位数.class);

    @Override
    public List<Input> getInputs() {
        return List.of(
                Input.create(ArrayFactory.create(1, 2), ArrayFactory.create(3)),
                Input.create(ArrayFactory.create(1, 2), ArrayFactory.create(3, 4)),
                Input.create(ArrayFactory.create(1, 2, 5, 6), ArrayFactory.create(3, 4)),
                Input.create(ArrayFactory.create(1, 2, 5, 6, 7), ArrayFactory.create(3, 4)),
                Input.create(ArrayFactory.create(2, 3), ArrayFactory.create(1)),
                Input.create(ArrayFactory.create(1), ArrayFactory.create(2)),
                Input.create(ArrayFactory.create(1), ArrayFactory.create(1)),
                Input.create(ArrayFactory.create(1, 2, 4), ArrayFactory.create(3)),
                Input.create(ArrayFactory.create(1, 2, 3, 5, 6), ArrayFactory.create(4))
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return List.of(
                Answer.create(2.0),
                Answer.create(2.5),
                Answer.create(3.5),
                Answer.create(4.0),
                Answer.create(2.0),
                Answer.create(1.5),
                Answer.create(1.0),
                Answer.create(2.5),
                Answer.create(3.5)
        );
    }

    @Code(info = {
            "给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。\n" +
                    "\n" +
                    "请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。\n" +
                    "\n" +
                    "你可以假设 nums1 和 nums2 不会同时为空。\n" +
                    "\n" +
                    "示例 1:\n" +
                    "\n" +
                    "nums1 = [1, 3]\n" +
                    "nums2 = [2]\n" +
                    "\n" +
                    "则中位数是 2.0\n" +
                    "示例 2:\n" +
                    "\n" +
                    "nums1 = [1, 2]\n" +
                    "nums2 = [3, 4]\n" +
                    "\n" +
                    "则中位数是 (2 + 3)/2 = 2.5\n"
    })
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int i = m / 2; // 0 ... m
        int j; // 0 ... n

        int max = m;
        int min = 0;

        if ((m + n) % 2 == 0) {
            // even
            int half = (m + n) / 2;


            while (true) {
                LOGGER.info("i = {}", i);
                j = half - i;
                if (j > n) { // j is too big, make i bigger
                    min = i + 1;
                    i = (min + max) / 2;
                } else if (j < 0) { // j is too small, make i smaller
                    max = i - 1;
                    i = (min + max) / 2;
                } else { // good
                    int leftMax = Math.max(max(nums1, 0, i), max(nums2, 0, j));
                    int rightMin = Math.min(min(nums1, i, m), min(nums2, j, n));

                    if (leftMax <= rightMin)
                        return (leftMax + rightMin) / 2.0;
                    else {
                        if (i > 0 && leftMax == nums1[i - 1]) { // [i] is bigger
                            max = i - 1;
                            i = (min + max) / 2;
                        } else { // [j] is bigger
                            min = i + 1;
                            i = (min + max) / 2;
                        }
                    }
                }
            }
        } else {
            //odd
            int half = (m + n) / 2;

            while (true) {
                j = half - i;
                if (j > n) { // j is too big, make i bigger
                    min = i + 1;
                    i = (min + max) / 2;
                } else if (j < 0) { // j is to small, make i smaller
                    max = i - 1;
                    i = (min + max) / 2;
                } else { // good
                    int leftMax = Math.max(max(nums1, 0, i), max(nums2, 0, j));
                    int rightMin = Math.min(min(nums1, i, m), min(nums2, j, n));

                    if (leftMax <= rightMin)
                        return rightMin;
                    else {
                        if (i > 0 && leftMax == nums1[i - 1]) { // [i] is bigger
                            max = i - 1;
                            i = (min + max) / 2;
                        } else { // [j] is bigger
                            min = i + 1;
                            i = (min + max) / 2;
                        }
                    }
                }
            }
        }
    }

    private int max(int[] arr, int startIn, int endEx) {
        if (startIn >= endEx)
            return Integer.MIN_VALUE;

        int max = arr[startIn];
        for (int i = startIn; i < endEx; i++) {
            max = Math.max(max, arr[i]);
        }

        return max;
    }

    private int min(int[] arr, int startIn, int endEx) {
        if (startIn >= endEx)
            return Integer.MAX_VALUE;

        return Arrays.stream(arr)
                .skip(startIn)
                .limit(endEx - startIn)
                .min()
                .orElse(0);
    }
}
