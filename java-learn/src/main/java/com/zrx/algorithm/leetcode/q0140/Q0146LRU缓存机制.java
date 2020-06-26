package com.zrx.algorithm.leetcode.q0140;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.utils.MyLoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Description
 * LRU缓存机制
 * <p>
 * Data
 * 2020/6/27-0:02
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0146LRU缓存机制 implements Question {
    private final static Logger LOGGER = MyLoggerFactory.getLogger(Q0146LRU缓存机制.class);

    @Override
    public List<Input> getInputs() {
        boolean input = true;

        try {
            LRUCache cache = new LRUCache(2 /* 缓存容量 */);

            cache.put(1, 1);
            cache.put(2, 2);
            Assert.isTrue(cache.get(1) == 1, "返回  1");       // 返回  1
            cache.put(3, 3);    // 该操作会使得关键字 2 作废
            Assert.isTrue(cache.get(2) == -1, "返回 -1 (未找到)");       // 返回 -1 (未找到)
            cache.put(4, 4);    // 该操作会使得关键字 1 作废
            Assert.isTrue(cache.get(1) == -1, "返回 -1 (未找到)");       // 返回 -1 (未找到)
            Assert.isTrue(cache.get(3) == 3, "返回  3");       // 返回  3
            Assert.isTrue(cache.get(4) == 4, "返回  4");       // 返回  4
        } catch (Exception e) {
            input = false;
        }


        return InputFactory.create(
                1, input
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(true);
    }

    @Code(info = """
            运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。

            获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
            写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。

             

            进阶:

            你是否可以在 O(1) 时间复杂度内完成这两种操作？

             

            示例:

            LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

            cache.put(1, 1);
            cache.put(2, 2);
            cache.get(1);       // 返回  1
            cache.put(3, 3);    // 该操作会使得关键字 2 作废
            cache.get(2);       // 返回 -1 (未找到)
            cache.put(4, 4);    // 该操作会使得关键字 1 作废
            cache.get(1);       // 返回 -1 (未找到)
            cache.get(3);       // 返回  3
            cache.get(4);       // 返回  4

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/lru-cache
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public boolean enter(boolean b) {
        return b;
    }

    class LRUCache {

        public LRUCache(int capacity) {

        }

        public int get(int key) {
            return -1;
        }

        public void put(int key, int value) {

        }
    }
}
