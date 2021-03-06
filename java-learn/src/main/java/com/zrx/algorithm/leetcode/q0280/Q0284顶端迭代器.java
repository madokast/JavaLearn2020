package com.zrx.algorithm.leetcode.q0280;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;

/**
 * Description
 * Q0284顶端迭代器
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0284顶端迭代器 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0284顶端迭代器.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1, true
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                true
        );
    }

    @Code(info = """
            给定一个迭代器类的接口，接口包含两个方法： next() 和 hasNext()。
            设计并实现一个支持 peek() 操作的顶端迭代器 -- 其本质就是把原本应由 next() 方法返回的元素 peek() 出来。

            示例:

            假设迭代器被初始化为列表 [1,2,3]。

            调用 next() 返回 1，得到列表中的第一个元素。
            现在调用 peek() 返回 2，下一个元素。在此之后调用 next() 仍然返回 2。
            最后一次调用 next() 返回 3，末尾元素。在此之后调用 hasNext() 应该返回 false。
            进阶：你将如何拓展你的设计？使之变得通用化，从而适应所有的类型，而不只是整数型？

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/peeking-iterator
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public boolean fun(boolean b) {
        return b;
    }

    class PeekingIterator implements Iterator<Integer> {
        boolean peeked = false;
        Integer peek = null;

        Iterator<Integer> agent;

        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            agent = iterator;
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            if (!peeked) {
                peek = agent.next();
                peeked = true;
            }

            return peek;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            if (peeked) {
                peeked = false;
                return peek;
            } else {
                return agent.next();
            }
        }

        @Override
        public boolean hasNext() {
            if (peeked) return true;
            else return agent.hasNext();

        }
    }
}
