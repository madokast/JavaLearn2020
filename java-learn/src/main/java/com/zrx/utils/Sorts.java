package com.zrx.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Description
 * 排序算法
 * <p>
 * Data
 * 2020/6/21-20:24
 *
 * @author zrx
 * @version 1.0
 */

@SuppressWarnings("all")
public interface Sorts {
    Logger LOGGER = LoggerFactory.getLogger(Sorts.class);

    void sort(int[] arr);


    class HeapSort implements Sorts {
        /**
         * 堆排序算法
         * 2020年6月21日
         *
         * @param arr 数组
         */
        @Override
        public void sort(int[] arr) {
            // 首先整个数组成堆
            // 从最大的非叶子节点 len/2-1 开始，到顶点 0
            // 依次调用 adjustHeap
            // 这样就可以成堆了
            // 调整过程中，可以处理因此调整了子堆，导致子子堆被破坏的情况
            int length = arr.length;
            for (int i = length / 2 - 1; i >= 0; i--) {
                adjustHeap(arr, i, length);
            }

            // 现在 [0] 即最大元素
            // 把他放到堆外面
            // 剩余的元素继续成堆
            // 这次的成堆算法 和 上面的流程不一样
            // 因为是由 顶点堆（最顶层的堆）被破坏
            // 左右只需要调用一次 adjustHeap
            // 其他的堆都是完好的堆
            for (int i = length - 1; i >= 0; i--) {
                Sorts.swap(arr, 0, i);
                adjustHeap(arr, 0, i);
            }
        }

        /**
         * 这个方法对 数组 [0,heapLength) 表示的堆进行调整
         * 但是只调整的一部分，具体来说
         * waitForAdjustFatherNodeIndex 表示要调整的子堆的父节点，下面用 w 表示
         * w 是要调整子堆的父节点
         * 父节点的两个子节点是：左节点 2w+1，右节点 2w+2
         * 方法首先将 arr[w] 设为 max([w],[2w+1],[2w+2])
         * 然后如果发生了交换——例如 swap(w, 2w+1)
         * 则以 2w+1 为父节点的堆，很可能被破坏了，需要重新调整，因此方法递归进行
         *
         * @param arr                          数组：表示堆
         * @param waitForAdjustFatherNodeIndex 需要进行调整的子堆的父节点
         * @param heapLength                   堆的长度。堆总是从 0 开始，到 heapLength-1 结束
         */
        private void adjustHeap(int[] arr, int waitForAdjustFatherNodeIndex, int heapLength) {
            int fatherVal = arr[waitForAdjustFatherNodeIndex];
            int leftIndex = waitForAdjustFatherNodeIndex * 2 + 1;
            int rightIndex = waitForAdjustFatherNodeIndex * 2 + 2;

            if (rightIndex < heapLength) {
                // 子节点都存在

                // 找出最大的子节点
                int maxChildVal; // 最大的子节点的值
                int maxChildIndex; // 最大的子节点的索引
                boolean isLeft; // 最大子节点是不是左子树
                if (arr[leftIndex] >= arr[rightIndex]) {
                    maxChildVal = arr[leftIndex];
                    maxChildIndex = leftIndex;
                    isLeft = true;
                } else {
                    maxChildVal = arr[rightIndex];
                    maxChildIndex = rightIndex;
                    isLeft = false;
                }

                // 查看是不是比父节点大
                if (fatherVal < maxChildVal) {
                    // 需要调整
                    Sorts.swap(arr, waitForAdjustFatherNodeIndex, maxChildIndex);
                    // 这是还需要调整变动了的子节点
                    if (isLeft) {
                        // 变动的子节点是 left
                        // 调整 left 子堆
                        adjustHeap(arr, leftIndex, heapLength);
                    } else {
                        adjustHeap(arr, rightIndex, heapLength);
                    }
                } else {
                    // 不需要调整
                    return;
                }
            } else if (leftIndex < heapLength) {
                // 只有左子树

                int leftVal = arr[leftIndex];

                // 是否需要调整
                if (fatherVal < leftVal) {
                    // 调整
                    swap(arr, waitForAdjustFatherNodeIndex, leftIndex);
                    // leftIndex 发生变动，调整对于的子树
                    adjustHeap(arr, leftIndex, heapLength);
                }

            } else {
                // 没有左子树
                // 不同调整
                return;
            }
        }
    }


    // 辅助函数
    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
