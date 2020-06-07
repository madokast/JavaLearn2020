package com.zrx.algorithm.leetcode.q0080;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 搜索旋转排序数组 II
 * <p>
 * Data
 * 2020/6/2-11:47
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0081搜索旋转排序数组II implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0081搜索旋转排序数组II.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                2,
                ArrayFactory.create(2, 5, 6, 0, 0, 1, 2), 0,
                ArrayFactory.create(2, 5, 6, 0, 0, 1, 2), 3
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(true, false);
    }

    @Code(info = """
            假设按照升序排序的数组在预先未知的某个点上进行了旋转。

            ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。

            编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。

            示例 1:

            输入: nums = [2,5,6,0,0,1,2], target = 0
            输出: true
            示例 2:

            输入: nums = [2,5,6,0,0,1,2], target = 3
            输出: false
            进阶:

            这是 搜索旋转排序数组 的延伸题目，本题中的 nums  可能包含重复元素。
            这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public boolean search(int[] nums, int target) {
        if (nums.length == 0)
            return false;

        return searchInRotatedArray(nums, target, 0, nums.length - 1);
    }

    private boolean searchInRotatedArray(int[] a, int t, int left, int right) {
        if (left > right)
            return false;

        int mid = (left + right) / 2;
        int m = a[mid];

        if (m == t)
            return true;

        if (m > a[left]) {
            boolean low = searchInOrderArray(a, t, left, mid - 1);
            boolean hi = searchInRotatedArray(a, t, mid + 1, right);
            return low | hi;
        }

        if (m < a[right]) {
            boolean hi = searchInOrderArray(a, t, mid + 1, right);
            boolean lo = searchInRotatedArray(a, t, left, mid - 1);
            return lo | hi;
        }


        boolean lo = searchInRotatedArray(a, t, left, mid - 1);
        boolean hi = searchInRotatedArray(a, t, mid + 1, right);
        return lo | hi;

    }

    private boolean searchInOrderArray(int[] a, int t, int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;
            int m = a[mid];
            if (m > t) {
                right = mid - 1;
            } else if (m < t) {
                left = mid + 1;
            } else
                return true;
        }

        return false;
    }
}
