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
 * 合并两个有序数组
 * <p>
 * Data
 * 2020/6/2-11:56
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0088合并两个有序数组 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0088合并两个有序数组.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                4,
                ArrayFactory.create(1, 2, 3, 0, 0, 0), 3, ArrayFactory.create(2, 5, 6), 3
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                (Object) ArrayFactory.create(1, 2, 2, 3, 5, 6)
        );
    }

    @Code(info = """
            给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。

             

            说明:

            初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
            你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
             

            示例:

            输入:
            nums1 = [1,2,3,0,0,0], m = 3
            nums2 = [2,5,6],       n = 3

            输出: [1,2,2,3,5,6]

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/merge-sorted-array
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        // 双指针算法，不复制

        int i = m - 1;
        int j = n - 1;

        int p = m + n - 1;

        while (i >= 0 && j >= 0) {
            int n1 = nums1[i];
            int n2 = nums2[j];

            if (n1 >= n2) {
                nums1[p] = n1;
                i--;
            } else {
                nums1[p] = n2;
                j--;
            }
            p--;
        }

        if (j >= 0) {
            System.arraycopy(nums2, 0, nums1, 0, j+1);
        }


        return nums1;
    }


    public int[] merge复制法(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3 = new int[m];
        System.arraycopy(nums1, 0, nums3, 0, m);

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < m && j < n) {
            int n3 = nums3[i];
            int n2 = nums2[j];

            if (n3 <= n2) {
                nums1[k] = n3;
                i++;
            } else {
                nums1[k] = n2;
                j++;
            }

            k++;
        }

        if (i < m) {
            System.arraycopy(nums3, i, nums1, k, m - i);
        }

        if (j < n) {
            System.arraycopy(nums2, j, nums1, k, m - j);
        }

        return nums1;
    }
}
