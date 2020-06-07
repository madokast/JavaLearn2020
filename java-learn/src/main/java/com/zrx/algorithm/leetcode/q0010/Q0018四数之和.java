package com.zrx.algorithm.leetcode.q0010;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.ToString;
import com.zrx.algorithm.leetcode.object.RepeatableSet;
import com.zrx.utils.ArrayFactory;
import com.zrx.utils.MyLoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Description
 * 四数之和
 * <p>
 * Data
 * 2020/4/10-22:29
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0018四数之和 implements Question {
    private final static Logger LOGGER = MyLoggerFactory.getLogger(Q0018四数之和.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                2,
                ArrayFactory.create(1, 0, -1, 0, -2, 2), 0
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                RepeatableSet.of(
                        RepeatableSet.of(-1, 0, 0, 1),
                        RepeatableSet.of(-2, -1, 1, 2),
                        RepeatableSet.of(-2, 0, 0, 2)
                )
        );
    }

    @Code(info = {
            "给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，" +
                    "使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。\n" +
                    "注意：\n" +
                    "答案中不可以包含重复的四元组。\n" +
                    "示例：\n" +
                    "给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。\n" +
                    "满足要求的四元组集合为：\n" +
                    "  [-1,  0, 0, 1],\n" +
                    "  [-2, -1, 1, 2],\n" +
                    "  [-2,  0, 0, 2]\n" +
                    "]\n"
    })
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> ans = new HashSet<>(100);

        Map<Integer, List<int[]>> map = new HashMap<>(nums.length * 2);

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];

                List<int[]> get = map.getOrDefault(sum, new ArrayList<>());
                get.add(new int[]{i, j});
                map.put(sum, get);

                if (map.containsKey(target-sum)) {
                    List<int[]> ints = map.get(-sum);
                    for (int[] anInt : ints) {
                        if (anInt[0] != i && anInt[0] != j && anInt[1] != i && anInt[1] != j) {
                            ArrayList<Integer> list = new ArrayList<>(4);
                            list.add(nums[anInt[0]]);
                            list.add(nums[anInt[1]]);
                            list.add(nums[i]);
                            list.add(nums[j]);

                            list.sort(Integer::compareTo);

                            ans.add(list);
                        }
                    }
                }
            }
        }

        LOGGER.info("ToString.apply(map) = {}", ToString.apply(map));

        return ans.stream().collect(Collectors.toUnmodifiableList());
    }
}
