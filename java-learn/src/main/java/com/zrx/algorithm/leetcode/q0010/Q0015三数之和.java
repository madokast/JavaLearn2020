package com.zrx.algorithm.leetcode.q0010;

import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.RepeatableSet;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description
 * 三数之和
 * <p>
 * Data
 * 2020/4/5-12:34
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0015三数之和 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0015三数之和.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                (Object) ArrayFactory.create(-1, 0, 1, 2, -1, -4),
                (Object) ArrayFactory.create(0, 0, 0, 0),
                (Object) ArrayFactory.create(-2, 0, 1, 1, 2),
                (Object) ArrayFactory.create(0, -4, -1, -4, -2, -3, 2)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                (Object) RepeatableSet.of((Object) RepeatableSet.of(-1, 0, 1), (Object) RepeatableSet.of(-1, -1, 2)),
                (Object) RepeatableSet.of((Object) RepeatableSet.of(0, 0, 0)),
                (Object) RepeatableSet.of((Object) RepeatableSet.of(-2, 0, 2), (Object) RepeatableSet.of(-2, 1, 1)),
                (Object) RepeatableSet.of((Object) RepeatableSet.of(-2, 0, 2))
        );
    }

    @Code(info = {
            "给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。\n" +
                    "注意：答案中不可以包含重复的三元组。\n" +
                    "示例：\n" +
                    "给定数组 nums = [-1, 0, 1, 2, -1, -4]，\n" +
                    "满足要求的三元组集合为：\n" +
                    "  [-1, 0, 1],\n" +
                    "  [-1, -1, 2]\n"
    })
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> listList = new ArrayList<>();
        int a;
        int j;
        int k;

        // sort
        Arrays.sort(nums);
        LOGGER.info("nums = {}", Arrays.toString(nums));

        for (int i = 0; i < nums.length - 2; i++) {
            // smallest i

            if (nums[i] > 0)
                break;
            while (i >= 1 && i <= nums.length - 2 && nums[i - 1] == nums[i])
                i++;
            if (i >= nums.length - 2)
                break;

            a = nums[i];
            j = i + 1;
            k = nums.length - 1;
            while (k > j) {
                LOGGER.info("i,j,k={},{},{}", i, j, k);

                while (k > j && a + nums[j] + nums[k] > 0)
                    k--;
                while (k > j && a + nums[j] + nums[k] < 0)
                    j++;
                if (k > j && a + nums[j] + nums[k] == 0) {
                    listList.add(List.of(a, nums[j], nums[k]));
                    do {
                        k--;
                    } while (k > j && nums[k] == nums[k + 1]);

                    do {
                        j++;
                    } while (k > j && nums[j] == nums[j - 1]);
                }
            }
        }

        return listList;
    }
}
