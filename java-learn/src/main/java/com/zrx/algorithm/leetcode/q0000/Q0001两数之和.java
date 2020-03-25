package com.zrx.algorithm.leetcode.q0000;

import com.zrx.algorithm.Question;
import com.zrx.utils.IntArray;
import com.zrx.utils.MyLoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description
 * Q0001 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * Data
 * 2020/3/23-17:55
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0001两数之和 implements Question {
    private final static Logger LOGGER = MyLoggerFactory.getLogger(Q0001两数之和.class);

    @Override
    public List<Input> getInputs() {
        return List.of(
                Input.create(IntArray.create(2, 7, 11, 15),9)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return List.of(
                Answer.create(IntArray.create(0,1))
        );
    }

    @Code(info = {
            "给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标",
            "你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素",
            "给定 nums = [2, 7, 11, 15], target = 9",
            "因为 nums[0] + nums[1] = 2 + 7 = 9",
            "所以返回 [0, 1]"
    })
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            int b = target-a;

            if(map.containsKey(b)){
                int ib = map.get(b);
                return new int[]{ib,i};
            }else
                map.put(a,i);
        }

        return null;
    }
}
