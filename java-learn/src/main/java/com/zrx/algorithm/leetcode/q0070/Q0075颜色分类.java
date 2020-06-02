package com.zrx.algorithm.leetcode.q0070;

import com.zrx.Invoking;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.ToString;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 颜色分类
 * <p>
 * Data
 * 2020/5/31-13:44
 *
 * @author zrx
 * @version 1.0
 */

@Invoking(createdTime = "2020-06-02 09:32")
@Component
public class Q0075颜色分类 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0075颜色分类.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                (Object) ArrayFactory.create(2, 0, 2, 1, 1, 0),
                (Object) ArrayFactory.create(2, 0, 1),
                (Object) ArrayFactory.create(2, 2)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                (Object) ArrayFactory.create(0, 0, 1, 1, 2, 2),
                (Object) ArrayFactory.create(0, 1, 2),
                (Object) ArrayFactory.create(2, 2)
        );
    }

    @Code(info = """
            给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

            此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

            注意:
            不能使用代码库中的排序函数来解决这道题。

            示例:

            输入: [2,0,2,1,1,0]
            输出: [0,0,1,1,2,2]
            进阶：

            一个直观的解决方案是使用计数排序的两趟扫描算法。
            首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
            你能想出一个仅使用常数空间的一趟扫描算法吗？

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/sort-colors
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int[] sortColors(int[] nums) {
        int length = nums.length;

        int left = 0;
        int i = 0;
        int right = length - 1;

        int t;

        while (i <= right) {
            switch (nums[i]) {
                case 0:
                    if (i == left) {
                        left++;
                        i++;
                    } else {
                        swap(nums, i, left);
                        left++;
                    }
                    break;
                case 1:
                    i++;
                    break;
                case 2:
                    swap(nums, i, right);
                    right--;
            }
        }

        return nums;

    }

    public void swap(int[] a, int i, int j) {
        if (i == j)
            return;
        if (a[i] == a[j])
            return;

        a[i] = a[i] ^ a[j];
        a[j] = a[i] ^ a[j];
        a[i] = a[i] ^ a[j];
    }

    @Invoking(createdTime = "2020-06-02 09:33")
    public void swapTest() {
        int[] m = {2, 2};
        LOGGER.info("m = {}", ToString.apply(m));
        swap(m, 0, 1);
        LOGGER.info("m = {}", ToString.apply(m));
    }
}
