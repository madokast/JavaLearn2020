package com.zrx.algorithm.leetcode.q0230;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

/**
 * Description
 * 似乎新的数据结构？？
 * 大佬的答案：
 * <pre>
 *     class Solution {
 *
 *     public int[] maxSlidingWindow(int[] nums, int k) {
 *         int[] ans = new int[nums.length - k + 1];
 *         int maxIndex = -1;
 *         int j = 0;
 *         for(int i = 0; i <= nums.length - k; i++){
 *             if(i <= maxIndex && maxIndex < i + k){
 *                 if(nums[maxIndex] <= nums[i+k-1]){
 *                     maxIndex = i+k-1;
 *                 }
 *             } else {
 *                 maxIndex = i;
 *                 for(int m = i; m <= i + k -1; m++){
 *                     if(nums[maxIndex] < nums[m]) maxIndex = m;
 *                 }
 *             }
 *             ans[j++] = nums[maxIndex];
 *         }
 *         return ans;
 *     }
 * }
 *
 * 作者：july-k8is7UZSAI
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum/solution/zhi-xing-yong-shi-2-ms-zai-suo-you-java-ti-jiao-88/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * </pre>
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0239滑动窗口最大值 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0239滑动窗口最大值.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                2,
                ArrayFactory.create(1, 3, -1, -3, 5, 3, 6, 7), 3
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                (Object) ArrayFactory.create(3, 3, 5, 5, 6, 7)
        );
    }

    @Code(info = """
            给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
            你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。

            返回滑动窗口中的最大值。

             

            进阶：

            你能在线性时间复杂度内解决此题吗？

             

            示例:

            输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
            输出: [3,3,5,5,6,7]\040
            解释:\040

              滑动窗口的位置                最大值
            ---------------               -----
            [1  3  -1] -3  5  3  6  7       3
             1 [3  -1  -3] 5  3  6  7       3
             1  3 [-1  -3  5] 3  6  7       5
             1  3  -1 [-3  5  3] 6  7       5
             1  3  -1  -3 [5  3  6] 7       6
             1  3  -1  -3  5 [3  6  7]      7
             

            提示：

            1 <= nums.length <= 10^5
            -10^4 <= nums[i] <= 10^4
            1 <= k <= nums.length

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/sliding-window-maximum
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int[] maxSlidingWindow(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());

        int length = nums.length;
        int[] ans = new int[length - k + 1];
        int ans_i = 0;

        int i = 0;
        for (; i < k; i++) {
            int num = nums[i];
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (; i < length; i++) {
            int num = nums[i];

            ans[ans_i] = map.firstKey();
            ans_i++;

            int del = nums[i - k];
            Integer time = map.get(del);
            if (time == 1) map.remove(del);
            else map.put(del, time - 1);

            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        ans[ans_i] = map.firstKey();


        return ans;
    }


    // 看了一下
    // 我大概知道了
    public int[] maxSlidingWindow大佬的答案(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        int maxIndex = -1;
        int j = 0;
        for (int i = 0; i <= nums.length - k; i++) {
            if (i <= maxIndex && maxIndex < i + k) {
                if (nums[maxIndex] <= nums[i + k - 1]) {
                    maxIndex = i + k - 1;
                }
            } else {
                maxIndex = i;
                for (int m = i; m <= i + k - 1; m++) {
                    if (nums[maxIndex] < nums[m]) maxIndex = m;
                }
            }
            ans[j++] = nums[maxIndex];
        }
        return ans;
    }


}
