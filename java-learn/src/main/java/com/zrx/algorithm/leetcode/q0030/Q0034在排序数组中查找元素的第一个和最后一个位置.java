package com.zrx.algorithm.leetcode.q0030;

import com.zrx.algorithm.Question;
import com.zrx.utils.ArrayFactory;
import com.zrx.utils.MyLoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 在排序数组中查找元素的第一个和最后一个位置
 * <p>
 * Data
 * 2020/5/13-17:46
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0034在排序数组中查找元素的第一个和最后一个位置 implements Question {
    private final static Logger LOGGER = MyLoggerFactory.getLogger(Q0034在排序数组中查找元素的第一个和最后一个位置.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                2,
                ArrayFactory.create(5, 7, 7, 8, 8, 10), 8,
                ArrayFactory.create(5, 7, 7, 8, 8, 10), 6,
                ArrayFactory.create(1, 1, 1, 1, 1, 1), 1,
                ArrayFactory.create(1, 1, 1, 1, 1, 1, 1), 1,
                ArrayFactory.create(1, 1, 2), 1,
                ArrayFactory.create(1, 2, 3, 3, 3, 3, 4, 5, 9), 3,
                ArrayFactory.create(2, 2), 3
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                ArrayFactory.create(3, 4),
                ArrayFactory.create(-1, -1),
                ArrayFactory.create(0, 5),
                ArrayFactory.create(0, 6),
                ArrayFactory.create(0, 1),
                ArrayFactory.create(2, 5),
                ArrayFactory.create(-1, -1)
        );

    }


    @Code(info = """
            给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

            你的算法时间复杂度必须是 O(log n) 级别。

            如果数组中不存在目标值，返回 [-1, -1]。

            示例 1:

            输入: nums = [5,7,7,8,8,10], target = 8
            输出: [3,4]
            示例 2:

            输入: nums = [5,7,7,8,8,10], target = 6
            输出: [-1,-1]

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return new int[]{-1, -1};

        if (nums.length == 1)
            return nums[0] == target ? new int[]{0, 0} : new int[]{-1, -1};

        return new int[]{
                findFirstAppear(nums, target),
                findLastAppear(nums, target)
        };

//        int index = binarySearch(nums, target);
//
//        if (index == -1)
//            return new int[]{-1, -1};
//        else {
//            int left = index;
//            int right = index;
//
//            while (left > 0) {
//                int temp = binarySearch(nums, target, 0, left - 1);
//                if (temp != -1)
//                    left = temp;
//                else
//                    break;
//            }
//
//            while (right < nums.length - 1) {
//                int temp = binarySearch(nums, target, right + 1, nums.length - 1);
//                if (temp != -1)
//                    right = temp;
//                else
//                    break;
//            }
//
//            return new int[]{left, right};
//        }
    }


    private int binarySearch(int[] arr, int target) {
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (arr[mid] > target) {
                max = mid - 1;
            } else if (arr[mid] < target) {
                min = mid + 1;
            } else
                return mid;
        }

        return -1;
    }

    private int binarySearch(int[] arr, int target, int startIn, int endIn) {
        while (startIn <= endIn) {
            int mid = (startIn + endIn) / 2;

            if (arr[mid] > target) {
                endIn = mid - 1;
            } else if (arr[mid] < target) {
                startIn = mid + 1;
            } else
                return mid;
        }

        return -1;
    }

    /**
     * 查找 [i] 元素第一次出现的位置
     *
     * @param arr 有序数组
     * @param i   i号元素
     * @return [i] 元素第一次出现的位置
     */
    @Deprecated
    private int findFirstAppeal(int[] arr, int i, int offset) {
        LOGGER.info("findFirstAppeal-{},{},{}", arr.length, i, offset);

        if (offset == 0)
            return i;
        if (i - offset < 0)
            offset = i;

        int target = arr[i];
        int tried = arr[i - offset];

        if (target == tried) {
            if (i - offset == 0) {
                return 0;
            } else {
                offset += (offset / 2) == 0 ? 1 : (offset / 2);
                return findFirstAppeal(arr, i, offset);
            }
        } else {
            if (offset == 2) {
                return arr[i - 1] == arr[i] ? i - 1 : i;
            }

            return findFirstAppeal(arr, i, offset / 2);
        }
    }

    @Deprecated
    private int findLastAppeal(int[] arr, int i, int offset) {
        LOGGER.info("findLastAppeal-{},{},{}", arr.length, i, offset);

        if (offset == 0)
            return i;
        if (i + offset >= arr.length)
            offset = arr.length - i - 1;

        int target = arr[i];
        int tried = arr[i + offset];

        if (target == tried) {
            if (i + offset == arr.length - 1) {
                return arr.length - 1;
            } else {
                offset += (offset / 2) == 0 ? 1 : (offset / 2);
                return findLastAppeal(arr, i, offset);
            }
        } else {
            if (offset == 2) {
                return arr[i + 1] == arr[i] ? i + 1 : i;
            }

            return findLastAppeal(arr, i, offset / 2);
        }
    }

    private int findFirstAppear(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int midVal = arr[mid];

            if (midVal > target) {
                right = mid - 1;
            } else if (midVal < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // 出循环 left =要插入 target 的位置

        return left == arr.length ? -1 : arr[left] == target ? left : -1;
    }

    private int findLastAppear(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int midVal = arr[mid];

            if (midVal > target) {
                right = mid - 1;
            } else if (midVal < target) {
                left = mid + 1;
            } else {
                left = mid + 1;
            }
        }

        // 出循环 left =要插入 target 的位置

        if (left == arr.length) {
            return arr[left - 1] == target ? right : -1;
        } else {
            return right == -1 ? -1 : arr[right] == target ? right : -1;
        }
    }
}
