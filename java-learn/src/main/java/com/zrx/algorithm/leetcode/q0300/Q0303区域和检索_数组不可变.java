package com.zrx.algorithm.leetcode.q0300;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 区域和检索 - 数组不可变
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0303区域和检索_数组不可变 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0303区域和检索_数组不可变.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(

        );
    }

    @Code(info = """
            给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。

            示例：

            给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()

            sumRange(0, 2) -> 1
            sumRange(2, 5) -> -1
            sumRange(0, 5) -> -3
            说明:

            你可以假设数组不可变。
            会多次调用 sumRange 方法。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/range-sum-query-immutable
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public boolean fun(boolean b) {
        return b;
    }

    class NumArray {

        public NumArray(int[] nums) {

        }

        public int sumRange(int i, int j) {
            return -1;
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
}
