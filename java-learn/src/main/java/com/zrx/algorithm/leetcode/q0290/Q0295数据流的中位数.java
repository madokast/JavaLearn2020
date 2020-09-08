package com.zrx.algorithm.leetcode.q0290;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Description
 * 数据流的中位数
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0295数据流的中位数 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0295数据流的中位数.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(

        );
    }

    @Code(info = """
            中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。

            例如，

            [2,3,4] 的中位数是 3

            [2,3] 的中位数是 (2 + 3) / 2 = 2.5

            设计一个支持以下两种操作的数据结构：

            void addNum(int num) - 从数据流中添加一个整数到数据结构中。
            double findMedian() - 返回目前所有元素的中位数。
            示例：

            addNum(1)
            addNum(2)
            findMedian() -> 1.5
            addNum(3)\040
            findMedian() -> 2
            进阶:

            如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
            如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/find-median-from-data-stream
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public boolean fun(boolean b) {
        return b;
    }


    class MedianFinder {

        PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {

        }

        public void addNum(int num) {
            Integer bigInLeft = left.peek();
            if (bigInLeft == null || num <= bigInLeft) {
                left.add(num);
            } else {
                right.add(num);
            }

            balance();
        }

        private void balance() {
            int ls = left.size();
            int rs = right.size();

            if (ls - rs > 1) {
                Integer poll = left.poll();
                right.add(poll);
            } else if (rs > ls) {
                Integer poll = right.poll();
                left.add(poll);
            }
        }

        public double findMedian() {
            int ls = left.size();
            int rs = right.size();

            if (ls == rs) {
                Integer l = left.peek();
                Integer r = right.peek();

                return (l + r) / 2.;
            } else {
                return left.peek();
            }
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
}
