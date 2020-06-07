package com.zrx.algorithm.leetcode.q0040;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.ToString;
import com.zrx.algorithm.leetcode.object.RepeatableSet;
import com.zrx.utils.ArrayFactory;
import com.zrx.utils.MyLoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Description
 * Q0046全排列
 * <p>
 * Data
 * 2020/5/24-9:55
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0046全排列 implements Question {
    private final static Logger LOGGER = MyLoggerFactory.getLogger(Q0046全排列.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                (Object) ArrayFactory.create(1, 2, 3)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                RepeatableSet.of(
                        RepeatableSet.of(1, 2, 3),
                        RepeatableSet.of(1, 3, 2),
                        RepeatableSet.of(2, 1, 3),
                        RepeatableSet.of(2, 3, 1),
                        RepeatableSet.of(3, 1, 2),
                        RepeatableSet.of(3, 2, 1)
                )
        );
    }

    @Code(info = """
            给定一个 没有重复 数字的序列，返回其所有可能的全排列。

            示例:

            输入: [1,2,3]
            输出:
            [
              [1,2,3],
              [1,3,2],
              [2,1,3],
              [2,3,1],
              [3,1,2],
              [3,2,1]
            ]
            """)
    // 回溯算法版本二
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0)
            return List.of();
        else {
            List<List<Integer>> answer = new ArrayList<>();

            List<Integer> number = new ArrayList<>(nums.length);
            for (int num : nums) {
                number.add(num);
            }

            backSearch(number, answer, 0);

            return answer;
        }
    }

    private void backSearch(List<Integer> number, List<List<Integer>> answer, int local) {
        if (local == number.size())
            answer.add(new ArrayList<>(number));
        else {
            for (int i = local; i < number.size(); i++) {
                Collections.swap(number, i, local);
                backSearch(number, answer, local + 1);
                Collections.swap(number, i, local);
            }
        }
    }


    public List<List<Integer>> permute回溯算法版本一(int[] nums) {
        if (nums.length == 0)
            return List.of();
        else {
            List<List<Integer>> answer = new ArrayList<>();

            backSearch(nums, new ArrayList<>(), answer);

            return answer;
        }
    }

    private void backSearch(int[] nums, ArrayList<Integer> cur, List<List<Integer>> answer) {
        if (cur.size() == nums.length)
            answer.add(new ArrayList<>(cur));
        else {
            for (int num : nums) {
                // 这个判断存在大问题
                if (!cur.contains(num)) {
                    cur.add(num);
                    backSearch(nums, cur, answer);
                    cur.remove((Integer) num);
                }
            }
        }
    }


    // 采用最快法
    public List<List<Integer>> permuteQuick(int[] nums) {
        // nums 长度
        int len = nums.length;

        if (len == 0)
            return Collections.emptyList();
        else if (len == 1)
            return List.of(List.of(nums[0]));
        else if (len == 2)
            return List.of(
                    List.of(nums[0], nums[1]),
                    List.of(nums[1], nums[0])
            );
        else {
            // 排列数目
            int size = 1;
            for (int i = 1; i <= len; i++) {
                size *= i;
            }

            // 解
            List<List<Integer>> ans = new ArrayList<>(size);

            // 首先排序
            Arrays.sort(nums);

            // 箭头数组
            // false 表示 左
            boolean[] arrow = new boolean[len];

            for (; ; ) {
                ans.add(toList(nums));

                // 寻找最大的可动元素
                int movableIndex = -1;
                int movingElement = Integer.MIN_VALUE;
                boolean movingDirect = false;

                for (int i = 0; i < len; i++) {
                    int e = nums[i];
                    boolean d = arrow[i];
                    if (d) {
                        // 右
                        if (i < len - 1 && e > nums[i + 1] && e > movingElement) {
                            movableIndex = i;
                            movingElement = nums[i];
                            movingDirect = d;
                        }
                    } else {
                        // 左
                        if (i > 0 && e > nums[i - 1] && e > movingElement) {
                            movableIndex = i;
                            movingElement = nums[i];
                            movingDirect = d;
                        }
                    }
                }

                if (movableIndex == -1) {
                    // 结束
                    break;
                } else {

                    // 移动

                    if (movingDirect) {
                        // 右移动
                        swap(nums, movableIndex, movableIndex + 1);
                        swap(arrow, movableIndex, movableIndex + 1);
                    } else {
                        swap(nums, movableIndex, movableIndex - 1);
                        swap(arrow, movableIndex, movableIndex - 1);
                    }

                    // 比 movingElement 大的元素箭头反向
                    for (int i = 0; i < len; i++) {
                        if (nums[i] > movingElement)
                            arrow[i] = !arrow[i];
                    }
                }
                LOGGER.info("nums = {}, arrow = {}", ToString.apply(nums), ToString.apply(arrow));

            }


            return ans;
        }
    }

    private List<Integer> toList(int[] arr) {
        return new List<Integer>() {

            private int[] data = Arrays.copyOf(arr, arr.length);

            private int size = arr.length;

            @Override
            public int size() {
                return size;
            }

            @Override
            public boolean isEmpty() {
                return size == 0;
            }

            @Override
            public boolean contains(Object o) {
                throw new UnsupportedOperationException();
            }


            @Override
            public Iterator<Integer> iterator() {
                return new Iterator<Integer>() {
                    int i = 0;

                    @Override
                    public boolean hasNext() {
                        return i < size;
                    }

                    @Override
                    public Integer next() {
                        return data[i++];
                    }
                };
            }


            @Override
            public Object[] toArray() {
                System.out.println("SLOW");
                Integer[] arr = new Integer[data.length];
                for (int i = 0; i < data.length; i++) {
                    arr[i] = data[i];
                }
                return arr;
            }


            @Override
            public <T> T[] toArray(T[] a) {
                throw new UnsupportedOperationException();
            }

            @Override
            public boolean add(Integer integer) {
                throw new UnsupportedOperationException();
            }

            @Override
            public boolean remove(Object o) {
                throw new UnsupportedOperationException();
            }

            @Override
            public boolean containsAll(java.util.Collection<?> c) {
                throw new UnsupportedOperationException();
            }

            @Override
            public boolean addAll(java.util.Collection<? extends Integer> c) {
                throw new UnsupportedOperationException();
            }

            @Override
            public boolean addAll(int index, java.util.Collection<? extends Integer> c) {
                throw new UnsupportedOperationException();
            }

            @Override
            public boolean removeAll(java.util.Collection<?> c) {
                throw new UnsupportedOperationException();
            }

            @Override
            public boolean retainAll(java.util.Collection<?> c) {
                throw new UnsupportedOperationException();
            }

            @Override
            public void clear() {
                throw new UnsupportedOperationException();
            }

            @Override
            public Integer get(int index) {
                return data[index];
            }

            @Override
            public Integer set(int index, Integer element) {
                throw new UnsupportedOperationException();
            }

            @Override
            public void add(int index, Integer element) {
                throw new UnsupportedOperationException();
            }

            @Override
            public Integer remove(int index) {
                throw new UnsupportedOperationException();
            }

            @Override
            public int indexOf(Object o) {
                throw new UnsupportedOperationException();
            }

            @Override
            public int lastIndexOf(Object o) {
                throw new UnsupportedOperationException();
            }


            @Override
            public ListIterator<Integer> listIterator() {
                return listIterator(0);
            }


            @Override
            public ListIterator<Integer> listIterator(int index) {
                return new ListIterator<Integer>() {

                    int i = index;

                    @Override
                    public boolean hasNext() {
                        return i < size;
                    }

                    @Override
                    public Integer next() {
                        return data[i++];
                    }

                    @Override
                    public boolean hasPrevious() {
                        return i > 0;
                    }

                    @Override
                    public Integer previous() {
                        return data[i--];
                    }

                    @Override
                    public int nextIndex() {
                        return i + 1;
                    }

                    @Override
                    public int previousIndex() {
                        return i - 1;
                    }

                    @Override
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }

                    @Override
                    public void set(Integer integer) {
                        throw new UnsupportedOperationException();
                    }

                    @Override
                    public void add(Integer integer) {
                        throw new UnsupportedOperationException();
                    }
                };
            }


            @Override
            public List<Integer> subList(int fromIndex, int toIndex) {
                throw new UnsupportedOperationException();
            }
        };
    }

    private void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    private void swap(boolean[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
