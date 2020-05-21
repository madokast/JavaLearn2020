package com.zrx.algorithm.leetcode.q0030;

import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.RepeatableSet;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Description
 * Q0039组合总和
 * 解出来了，但是速度太慢
 * ---------------
 * 网友 动态规划版本
 * 读完后，我还以为怎么去重呢，原来就这样
 * <pre>
 *     public List<List<Integer>> combinationSum(int[] candidates, int target) {
 *       List<List<Integer>> result = new ArrayList<>();
 *       Map<Integer,Set<List<Integer>>> map = new HashMap<>();
 *       //对candidates数组进行排序
 *       Arrays.sort(candidates);
 *       int len = candidates.length;
 *       for(int i = 1;i <= target;i++){
 *           //初始化map
 *           map.put(i,new HashSet<>());
 *           //对candidates数组进行循环
 *           for(int j = 0;j < len&&candidates[j] <= target;j++){
 *               if(i == candidates[j]){
 *                   //相等即为相减为0的情况，直接加入set集合即可
 *                   List<Integer> temp = new ArrayList<>();
 *                   temp.add(i);
 *                   map.get(i).add(temp);
 *               }else if(i > candidates[j]){
 *                   //i-candidates[j]是map的key
 *                   int key = i-candidates[j];
 *                   //使用迭代器对对应key的set集合进行遍历
 *                   //如果candidates数组不包含这个key值，对应的set集合会为空，故这里不需要做单独判断
 *                   for(Iterator iterator = map.get(key).iterator();iterator.hasNext();){
 *                       List list = (List) iterator.next();
 *                       //set集合里面的每一个list都要加入candidates[j]，然后放入到以i为key的集合中
 *                       List tempList = new ArrayList<>();
 *                       tempList.addAll(list);
 *                       tempList.add(candidates[j]);
 *                       //排序是为了通过set集合去重
 *                       Collections.sort(tempList);
 *                       map.get(i).add(tempList);
 *                   }
 *               }
 *           }
 *       }
 *       result.addAll(map.get(target));
 *       return result;
 *   }
 *
 * 作者：chun-meng-da-xiao-yang
 * 链接：https://leetcode-cn.com/problems/combination-sum/solution/chao-qiang-gifzhu-ni-shi-yong-dong-tai-gui-hua-qiu/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * </pre>
 * <p>
 * Data
 * 2020/5/19-23:46
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0039组合总和 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0039组合总和.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                2,
                ArrayFactory.create(2, 3, 6, 7), 7,
                ArrayFactory.create(2, 3, 5), 8
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                RepeatableSet.of(
                        List.of(7),
                        List.of(2, 2, 3)
                ),
                RepeatableSet.of(
                        RepeatableSet.of(2, 2, 2, 2),
                        RepeatableSet.of(2, 3, 3),
                        RepeatableSet.of(3, 5)
                )
        );
    }

    @Code(info = """
            给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

            candidates 中的数字可以无限制重复被选取。

            说明：

            所有数字（包括 target）都是正整数。
            解集不能包含重复的组合。 
            示例 1:

            输入: candidates = [2,3,6,7], target = 7,
            所求解集为:
            [
              [7],
              [2,2,3]
            ]
            示例 2:

            输入: candidates = [2,3,5], target = 8,
            所求解集为:
            [
              [2,2,2,2],
              [2,3,3],
              [3,5]
            ]
            """)
    // 动态规划
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // sort
        Arrays.sort(candidates);

        // data[i] 表示 target = i 时的解
        Set<List<Integer>>[] data = new HashSet[target + 1];
        for (int i = 0; i < data.length; i++) {
            data[i] = new HashSet<>();
        }

        // 最小的物品
        int smallest = candidates[0];

        if(smallest>target)
            return Collections.emptyList();

        data[smallest].add(List.of(smallest));

        for (int i = smallest + 1; i <= target; i++) {
            for (int candidate : candidates) {
                int r = i - candidate;
                if (r > 0) {
                    for (List<Integer> rr : data[r]) {
                        ArrayList<Integer> list = new ArrayList<>(rr);
                        list.add(candidate);
                        list.sort(Integer::compareTo);
                        data[i].add(list);
                    }
                } else if (r == 0) {
                    data[i].add(List.of(candidate));
                }
            }
        }

        return new ArrayList<>(data[target]);
    }


    // 回溯算法
    public List<List<Integer>> combinationSum回溯(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> ans = new ArrayList<>();

        solveNew(0, new LinkedList<>(), 0, candidates, target, ans);

        return ans;
    }


    private void solveNew(int start, Deque<Integer> trace, int sum, int[] candidates, int target, List<List<Integer>> ans) {
        if (sum > target) {
            return;
        } else if (sum == target) {
            ans.add(new ArrayList<>(trace));
        } else {
            for (int i = start; i < candidates.length; i++) {
                trace.addLast(candidates[i]);
                solveNew(i, trace, sum + candidates[i], candidates, target, ans);
                trace.removeLast();
            }
        }
    }

    // 无法去重
    // 新的方法，不需要去重
    private List<Integer> save(Stack<Integer> indexStack, int[] candidates) {
        int size = indexStack.size();
        List<Integer> list = new ArrayList<>(size);
        for (Integer integer : indexStack) {
            list.add(candidates[integer]);
        }

        return list;
    }


    // 垃圾回溯
    // 错了，回溯没大问题
    // 继续修改 —— 这个回溯算法，会往里面添加一次元素
    // 及时判断是不是超出 target
    private int back(Stack<Integer> indexStack, int sum, int[] candidates, int target) {

        // 如果 stack 里面只有一个元素，但是需要回溯，那肯定不会再有满足的解了
        // 换句话说，必须 pop 两次，或以上
        if (indexStack.size() == 1)
            return -1;

        int length = candidates.length;

        Integer pop = indexStack.pop();
        sum -= candidates[pop];

        do {
            pop = indexStack.pop();
            sum -= candidates[pop];
        } while (pop == length - 1 && !indexStack.empty());

        if (pop == length - 1 && indexStack.empty())
            return -1;
        else {
            indexStack.push(pop + 1);
            sum = sum + candidates[pop + 1];

            return sum;
        }
    }

//    private int back2(Stack<Integer> indexStack, int sum, int[] candidates) {
//        int length = candidates.length;
//
//        Integer pop;
//
//        // 只要 pop 出的东西是 len-1 最后一个，那就需要继续 pop
//        do {
//            pop = indexStack.pop();
//            sum -= candidates[pop];
//        } while (pop == length - 1 && !indexStack.empty());
//
//        if (pop == length - 1 && indexStack.empty())
//            return -1;
//        else {
//            if(indexStack.empty()){
//                indexStack.push(pop + 1);
//                return candidates[pop + 1];
//            }else {
//                Integer pop2 = indexStack.pop();
//
//
//            }
//        }
//    }

    // 速度慢 （56 ms）
    private void solve(List<Integer> cur, int sum, int[] candidates, int target, List<List<Integer>> ans) {
        for (int candidate : candidates) {
            int newSum = sum + candidate;

            if (newSum == target) {
                ArrayList<Integer> copy = new ArrayList<>(cur);
                copy.add(candidate);

                copy.sort(Integer::compareTo);

                if (!ans.contains(copy))
                    ans.add(copy);
            } else if (newSum < target) {
                ArrayList<Integer> copy = new ArrayList<>(cur);
                copy.add(candidate);

                solve(copy, newSum, candidates, target, ans);
            }
        }

    }
}
