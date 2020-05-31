package com.zrx.algorithm.leetcode.q0070;

import com.zrx.algorithm.Question;
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

@Component
public class Q0075颜色分类 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0075颜色分类.class);

    @Override
    public List<Input> getInputs() {
        return null;
    }

    @Override
    public List<Answer> getAnswers() {
        return null;
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
    public void sortColors(int[] nums) {

    }
}
