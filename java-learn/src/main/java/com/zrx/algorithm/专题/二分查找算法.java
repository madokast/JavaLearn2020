package com.zrx.algorithm.专题;

import com.zrx.Invoking;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.ToString;
import com.zrx.utils.ArrayFactory;
import com.zrx.utils.Container;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description
 * 二分查找算法
 * <p>
 * Data
 * 2020/5/15-9:36
 *
 * @author zrx
 * @version 1.0
 */

@Invoking(createdTime = "2020-05-15 09:36", info = "二分查找")
public class 二分查找算法 {
    private final static Logger LOGGER = LoggerFactory.getLogger(二分查找算法.class);

    @Invoking(createdTime = "2020-05-15 09:51", info = "简单二分搜索1")
    public void 简单二分搜索() {
        List<Container.BiContainer<int[], Integer>> input = input();
        List<?> answer = answer();

        int size = input.size();

        for (int i = 0; i < size; i++) {
            Container.BiContainer<int[], Integer> integerBiContainer = input.get(i);
            Object o = answer.get(i);

            LOGGER.info("[{}, {}]", integerBiContainer.getE1(), integerBiContainer.getE2());
            LOGGER.info("ans = {}", ToString.apply(o));

            int ret0 = Arrays.binarySearch(integerBiContainer.getE1(), integerBiContainer.getE2());

            int ret1 = simpleBinarySearch版本一(
                    integerBiContainer.getE1(), integerBiContainer.getE2()
            );

            int ret2 = simpleBinarySearch版本二(
                    integerBiContainer.getE1(), integerBiContainer.getE2()
            );

            LOGGER.info("ret0 = {}", ToString.apply(ret0));
            LOGGER.info("ret1 = {}", ToString.apply(ret1));
            LOGGER.info("ret2 = {}", ToString.apply(ret2));
        }
    }

    /**
     * 最简单的二分查找 版本一
     *
     * @param arr    数组
     * @param target 目标
     * @return 目标元素的下标，没有则返回 -1
     */
    private int simpleBinarySearch版本一(int[] arr, int target) {

        // 闭区间搜索
        int left = 0;
        int right = arr.length - 1;

        // while 条件永远是，这个区间内还有元素
        // 对于闭区间来说，[1,1]表示区间内还有元素 [1]
        // 只有[1,0]时，才没有元素
        // 所以用等号
        while (left <= right) {
            int mid = left + (right - left) / 2; // 为了防止溢出

            if (arr[mid] > target) { // 这里总之就是缩小区间
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else
                return mid;
        }

        // 退出循环时，必须有
        Assert.isTrue(right==left-1,"退出循环时，必须有right==left-1");
        LOGGER.info("left = {}", left);
        LOGGER.info("right = {}", right);


        // 没有找到返回 -1
        return -1;
    }


    /**
     * 最简单的二分查找 版本二
     *
     * @param arr    数组
     * @param target 目标
     * @return 目标元素的下标，没有则返回 -1
     */
    private int simpleBinarySearch版本二(int[] arr, int target) {
        // 右开区间搜索
        int left = 0;
        int right = arr.length;

        // 因为是右开区间搜索
        // 所以当 [1,1] 时，区间长度已经是0 ，不需要继续
        while (left < right) {
            // 这里 mid 永远不会等于 arr.length
            int mid = left + (right - left) / 2; // 为了防止溢出

            if (arr[mid] > target) { // 这里总之就是缩小区间
                right = mid; //  这里和 一 不同，因为右边是开区间
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else
                return mid;
        }

        // 退出循环时，必须有
        Assert.isTrue(left==right,"退出循环时，必须有 left==right");
        LOGGER.info("left = {}", left);
        LOGGER.info("right = {}", right);

        return -1;
    }


    private List<Container.BiContainer<int[], Integer>> input() {
        List<Question.Input> inputs = Question.InputFactory.create(
                2,
                ArrayFactory.create(5, 7, 7, 8, 8, 10), 8,
                ArrayFactory.create(5, 7, 7, 8, 8, 10), 6,
                ArrayFactory.create(1, 1, 1, 1, 1, 1), 1,
                ArrayFactory.create(1, 1, 1, 1, 1, 1, 1), 1,
                ArrayFactory.create(1, 1, 2), 1,
                ArrayFactory.create(1, 2, 3, 3, 3, 3, 4, 5, 9), 3
        );

        List<Container.BiContainer<int[], Integer>> list = new ArrayList<>(inputs.size());

        for (Question.Input input : inputs) {
            list.add(Container.BiContainer.create(
                    (int[]) input.getParametersArray()[0],
                    (Integer) input.getParametersArray()[1]
            ));
        }

        return list;
    }

    private List<?> answer() {
        return Question.AnswerFactory.create(
                ArrayFactory.create(3, 4),
                ArrayFactory.create(-1, -1),
                ArrayFactory.create(0, 5),
                ArrayFactory.create(0, 6),
                ArrayFactory.create(0, 1),
                ArrayFactory.create(2, 5)
        );
    }
}
