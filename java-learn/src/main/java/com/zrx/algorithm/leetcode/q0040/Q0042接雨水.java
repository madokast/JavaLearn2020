package com.zrx.algorithm.leetcode.q0040;

import com.zrx.algorithm.Question;
import com.zrx.algorithm.ToString;
import com.zrx.utils.ArrayFactory;
import com.zrx.utils.MyLoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

/**
 * Description
 * 接雨水
 * <p>
 * 单调栈解法
 * <pre>
 * public class Solution {
 *     public int trap(int[] height) {
 *         if (height == null) {
 *             return 0;
 *         }
 *         Stack<Integer> stack = new Stack<>();
 *         int ans = 0;
 *         for (int i = 0; i < height.length; i++) {
 *                   // 栈非空   [i]>[栈顶]
 *             while(!stack.isEmpty() && height[stack.peek()] < height[i]) {
 *                 int curIdx = stack.pop(); // pop
 *                 // 如果栈顶元素一直相等，那么全都pop出去，只留第一个。
 *                 while (!stack.isEmpty() && height[stack.peek()] == height[curIdx]) {
 *                     stack.pop();
 *                 }
 *                 // 非空
 *                 if (!stack.isEmpty()) {
 *                      // 再一个栈顶
 *                     int stackTop = stack.peek();
 *                     // stackTop此时指向的是此次接住的雨水的左边界的位置。右边界是当前的柱体，即i。
 *                     // Math.min(height[stackTop], height[i]) 是左右柱子高度的min，减去height[curIdx]就是雨水的高度。
 *                     // i - stackTop - 1 是雨水的宽度。
 *                     ans += (Math.min(height[stackTop], height[i]) - height[curIdx]) * (i - stackTop - 1);
 *                 }
 *             }
 *             stack.add(i);
 *         }
 *         return ans;
 *     }
 * }
 *
 * 作者：sweetiee
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water/solution/dan-diao-zhan-jie-jue-jie-yu-shui-wen-ti-by-sweeti/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * </pre>
 * Data
 * 2020/5/20-18:12
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0042接雨水 implements Question {
    private final static Logger LOGGER = MyLoggerFactory.getLogger(Q0042接雨水.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                (Object) ArrayFactory.create(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1),
                (Object) ArrayFactory.create(6, 4, 2, 0, 3, 2, 0, 3, 1, 4, 5, 3, 2, 7, 5, 3, 0, 1, 2, 1, 3, 4, 6, 8, 1, 3)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(6, 83);
    }

    @Code(info = """
            给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
            上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
             感谢 Marcos 贡献此图。

            示例:

            输入: [0,1,0,2,1,0,1,3,2,1,2,1]
            输出: 6
            """)
    // 双指针，左右夹，每次动小的一边
    public int trap(int[] height) {


//        return solveByLeftRightPointer(height);

        return solveByStack(height);
    }

    // 单调栈
    private int solveByStack(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>(height.length);

        int val = 0;

        for (int i = 0; i < height.length; i++) {

            while (!stack.isEmpty() && height[stack.peekLast()] < height[i]) {
                Integer pop = stack.removeLast();

                while (!stack.isEmpty() && height[stack.peekLast()] < height[pop]) stack.removeLast();

                if (!stack.isEmpty()) {
                    Integer left = stack.peekLast();
                    int curHeight = Math.min(height[i], height[left]) - height[pop];
                    val += curHeight * (i - left - 1);
                }
            }
            stack.addLast(i);
        }
        return val;
    }

    // 双指针，左右夹，每次动小的一边
    private int solveByLeftRightPointer(int[] height) {
        if (height.length == 0) return 0;

        // waters 数组表示，i位置的水位（不一定有水）
        int[] waters = new int[height.length];

        // 左右双指针
        int left = 0;
        int right = height.length - 1;

        // 当前水位
        int currentHeight = 0;

        // 除去前后 0
        while (left < height.length && height[left] == 0) left++;
        while (right >= 0 && height[right] == 0) right--;

        if (left >= right) return 0;

        // 除去前后0后水位，即左右低的一边
        currentHeight = Math.min(height[left], height[right]);

        // 放水
        for (int i = left; i <= right; i++) waters[i] = currentHeight;

        // 左右夹
        while (left < right) {
            // 左边矮，因此动左边
            while (left < right && height[left] <= currentHeight) left++;
            // 重新计算水位
            currentHeight = Math.min(height[left], height[right]);
            // 防水
            for (int i = left; i <= right; i++) waters[i] = currentHeight;
            // 右边矮，方法同上
            while (left < right && height[right] <= currentHeight) right--;

            currentHeight = Math.min(height[left], height[right]);

            for (int i = left; i <= right; i++) waters[i] = currentHeight;
        }

        // 计算总水量
        int val = 0;

        for (int i = 0; i < waters.length; i++) val += Math.max(waters[i] - height[i], 0);

        LOGGER.info("waters = {}", ToString.apply(waters));

        return val;
    }
}
