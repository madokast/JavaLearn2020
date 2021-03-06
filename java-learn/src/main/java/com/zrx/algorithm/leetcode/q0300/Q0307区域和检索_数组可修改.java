package com.zrx.algorithm.leetcode.q0300;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 区域和检索 - 数组可修改
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0307区域和检索_数组可修改 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0307区域和检索_数组可修改.class);

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

            update(i, val) 函数可以通过将下标为 i 的数值更新为 val，从而对数列进行修改。

            示例:

            Given nums = [1, 3, 5]

            sumRange(0, 2) -> 9
            update(1, 2)
            sumRange(0, 2) -> 8
            说明:

            数组仅可以在 update 函数下进行修改。
            你可以假设 update 函数与 sumRange 函数的调用次数是均匀分布的。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/range-sum-query-mutable
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public boolean fun(boolean b) {
        return b;
    }

    class NumArray {

        public NumArray(int[] nums) {

        }

        public void update(int i, int val) {

        }

        public int sumRange(int i, int j) {
            return -1;
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
}
