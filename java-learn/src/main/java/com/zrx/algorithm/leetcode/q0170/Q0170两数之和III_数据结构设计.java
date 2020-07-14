package com.zrx.algorithm.leetcode.q0170;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * Description
 * 两数之和 III - 数据结构设计
 * <p>
 * Data
 * 2020/7/6-9:22
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0170两数之和III_数据结构设计 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0170两数之和III_数据结构设计.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(1,true);
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(true);
    }

    @Code(info = """
            设计并实现一个 TwoSum 的类，使该类需要支持 add 和 find 的操作。

            add 操作 -  对内部数据结构增加一个数。
            find 操作 - 寻找内部数据结构中是否存在一对整数，使得两数之和与给定的数相等。

            示例 1:

            add(1); add(3); add(5);
            find(4) -> true
            find(7) -> false
            示例 2:

            add(3); add(1); add(2);
            find(3) -> true
            find(6) -> false

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/two-sum-iii-data-structure-design
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public boolean fun(boolean b) {
        return b;
    }

    static class TwoSum {

        private Map<Integer, Integer> map;

        /**
         * Initialize your data structure here.
         */
        public TwoSum() {
            map = new HashMap<>();
        }

        /**
         * Add the number to an internal data structure..
         */
        public void add(int number) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        /**
         * Find if there exists any pair of numbers which sum is equal to the value.
         */
        public boolean find(int value) {
            for (Integer key : map.keySet()) {
                int s = value - key;
                if (map.containsKey(s)) {
                    if (s != key) {
                        return true;
                    } else if(map.get(key) > 1){
                        return true;
                    }
                }
            }

            return false;
        }
    }

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
}
