package com.zrx.algorithm.leetcode.q0040;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.RepeatableSet;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Description
 * Q0047全排列II
 * <p>
 * Data
 * 2020/5/24-11:11
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0047全排列II implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0047全排列II.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                (Object) ArrayFactory.create(1, 1, 2),
                (Object) ArrayFactory.create(1, 1, 2, 2),
                (Object) ArrayFactory.create(1, 2, 3),
                (Object) ArrayFactory.create(3, 3, 0, 3)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                RepeatableSet.of(
                        RepeatableSet.of(1, 1, 2),
                        RepeatableSet.of(1, 2, 1),
                        RepeatableSet.of(2, 1, 1)
                ),
                //[[1,1,2,2],[1,2,1,2],[1,2,2,1],[2,1,1,2],[2,1,2,1],[2,2,1,1]]
                RepeatableSet.of(
                        RepeatableSet.of(1, 1, 2, 2),
                        RepeatableSet.of(1, 2, 1, 2),
                        RepeatableSet.of(1, 2, 2, 1),
                        RepeatableSet.of(2, 1, 1, 2),
                        RepeatableSet.of(2, 1, 2, 1),
                        RepeatableSet.of(2, 2, 1, 1)
                ),
                RepeatableSet.of(
                        RepeatableSet.of(1, 2, 3),
                        RepeatableSet.of(1, 3, 2),
                        RepeatableSet.of(2, 1, 3),
                        RepeatableSet.of(2, 3, 1),
                        RepeatableSet.of(3, 1, 2),
                        RepeatableSet.of(3, 2, 1)
                ),
                //[[0,3,3,3],[3,0,3,3],[3,3,0,3],[3,3,3,0]]
                RepeatableSet.of(
                        RepeatableSet.of(0, 3, 3, 3),
                        RepeatableSet.of(3, 0, 3, 3),
                        RepeatableSet.of(3, 3, 0, 3),
                        RepeatableSet.of(3, 3, 3, 0)
                )
        );
    }

    @Code(info = """
            给定一个可包含重复数字的序列，返回所有不重复的全排列。

            示例:

            输入: [1,1,2]
            输出:
            [
              [1,1,2],
              [1,2,1],
              [2,1,1]
            ]
            """)
    public List<List<Integer>> permuteUnique(int[] nums) {
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
            // 已经填过的数
            Set<Integer> alreadyInsertedNumberSet = new HashSet<>();

            for (int i = local; i < number.size(); i++) {
                Integer currentNeedInsert = number.get(i); // 当前要填到 local 位置的数
                if (alreadyInsertedNumberSet.contains(currentNeedInsert)) // 如果上一次也是填这个数，那就跳过
                    continue;

                alreadyInsertedNumberSet.add(currentNeedInsert);

                Collections.swap(number, i, local);
                backSearch(number, answer, local + 1);
                Collections.swap(number, i, local);
            }
        }
    }


    public List<List<Integer>> permuteUnique错误算法(int[] nums) {
        // nums 长度
        int len = nums.length;

        if (len == 0)
            return Collections.emptyList();
        else if (len == 1)
            return List.of(List.of(nums[0]));
        else if (len == 2) {
            if (nums[0] == nums[1]) {
                return List.of(
                        List.of(nums[0], nums[1])
                );
            } else {
                return List.of(
                        List.of(nums[0], nums[1]),
                        List.of(nums[1], nums[0])
                );
            }
        } else {

            List<List<Integer>> ans = new ArrayList<>();

            ans.add(toList(nums));

            for (int[] swap : swaps(nums.length)) {
                int i = swap[0];
                int j = swap[1];

                if (nums[i] == nums[j]) {
                    continue;
                } else {
                    swap(nums, i, j);
                    ans.add(toList(nums));
                }
            }

            return ans;
        }
    }

    // 失败
    private void permuteUniqueSolve(int[] nums, int i, List<List<Integer>> ans, LinkedList<Integer> list) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(list));
        } else {
            int e = nums[i];

            int index = 0;
            while (index <= list.size()) {
                list.add(index, e);
                permuteUniqueSolve(nums, i + 1, ans, list);
                list.remove(index);


                if (!list.isEmpty() && index < list.size() && list.get(index) == e) {
                    index += 2;
                } else {
                    index++;
                }
            }
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

    private int[][] swaps(int len) {
        // 排列数目
        int size = 1;
        for (int i = 1; i <= len; i++) {
            size *= i;
        }

        int[][] swaps = new int[size - 1][];

        int[] nums = new int[len];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }

        // 箭头数组
        // false 表示 左
        boolean[] arrow = new boolean[len];

        int index = 0;

        for (; ; ) {
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

                    swaps[index++] = new int[]{movableIndex, movableIndex + 1};
                } else {
                    swap(nums, movableIndex, movableIndex - 1);
                    swap(arrow, movableIndex, movableIndex - 1);

                    swaps[index++] = new int[]{movableIndex, movableIndex - 1};
                }

                // 比 movingElement 大的元素箭头反向
                for (int i = 0; i < len; i++) {
                    if (nums[i] > movingElement)
                        arrow[i] = !arrow[i];
                }
            }

        }


        return swaps;
    }
}
