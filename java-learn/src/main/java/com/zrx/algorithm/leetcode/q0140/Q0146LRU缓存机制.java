package com.zrx.algorithm.leetcode.q0140;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.utils.MyLoggerFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.naming.OperationNotSupportedException;
import java.util.*;

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
            Assert.isTrue(cache.get(1) == 1, "1返回  1");       // 返回  1
            cache.put(3, 3);    // 该操作会使得关键字 2 作废
            Assert.isTrue(cache.get(2) == -1, "2返回 -1 (未找到)");       // 返回 -1 (未找到)
            cache.put(4, 4);    // 该操作会使得关键字 1 作废
            Assert.isTrue(cache.get(1) == -1, "3返回 -1 (未找到)");       // 返回 -1 (未找到)
            Assert.isTrue(cache.get(3) == 3, "4返回  3");       // 返回  3
            Assert.isTrue(cache.get(4) == 4, "5返回  4");       // 返回  4
        } catch (Exception e) {
            String message = e.getMessage();
            LOGGER.info("message = {}", message);
            input = false;
        }

        try {
            //["LRUCache","put","put","get","put","put","get"]
            //[[2],       [2,1],[2,2],[2],  [1,1],[4,1], [2]]

            LRUCache cache = new LRUCache(2 /* 缓存容量 */);
            LOGGER.info("cache = {}", cache);
            cache.put(2, 1);
            LOGGER.info("cache = {}", cache);
            cache.put(2, 2);
            LOGGER.info("cache = {}", cache);
            cache.get(2);
            LOGGER.info("cache = {}", cache);
            cache.put(1, 1);
            LOGGER.info("cache = {}", cache);
            cache.put(4, 1);
            LOGGER.info("cache = {}", cache);
            cache.get(2);
            LOGGER.info("cache = {}", cache);
        } catch (Exception e) {
            String message = e.getMessage();
            e.printStackTrace();
            LOGGER.info("message = {}", message);
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
        LinkedHashMap map;
        return b;
    }

    class LRUCache {
        private final int capacity;

        private Entry[] table;
        private final int tableLength;
        private int size = 0;

        private final Entry HEAD = new Entry();
        private final Entry TAIL = new Entry();
        private final Entry REMOVE_HELPER = new Entry();

        {
            HEAD.next = TAIL;
            TAIL.pre = HEAD;
        }

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.table = new Entry[capacity * 4];
            this.tableLength = this.table.length;
        }

        public int get(int key) {
            int index = key % tableLength;
            Entry entry = table[index];
            Entry find = null;
            while (entry != null) {
                if (entry.key == key) {
                    find = entry;
                    break;
                } else {
                    entry = entry.tableNext;
                }
            }

            if (find == null) {
                return -1;
            } else {
                int value = find.value;

                Entry headNext = HEAD.next;
                if (find != headNext) {

                    Entry next = find.next;
                    Entry pre = find.pre;

                    next.pre = pre;
                    pre.next = next;

                    find.pre = HEAD;
                    find.next = headNext;

                    HEAD.next = find;
                    headNext.pre = find;
                }

                return value;
            }
        }

        private void remove(int key) {
            int index = key % tableLength;
            Entry entry = table[index];
            Entry tablePre = REMOVE_HELPER;
            tablePre.tableNext = entry;
            Entry find = null;
            while (entry != null) {
                if (entry.key == key) {
                    find = entry;
                    break;
                } else {
                    entry = entry.tableNext;
                    tablePre = tablePre.tableNext;
                }
            }



            if (find != null) {
                if(table[index]==find){
                    table[index] = find.tableNext;
                }

                tablePre.tableNext = find.tableNext;

                Entry next = find.next;
                Entry pre = find.pre;

                pre.next = next;
                next.pre = pre;

                size--;
            }
        }

        public void put(int key, int value) {
            remove(key);
            if (size < capacity) {
                Entry newNode = new Entry();
                newNode.key = key;
                newNode.value = value;

                Entry headNext = HEAD.next;

                newNode.pre = HEAD;
                newNode.next = headNext;

                HEAD.next = newNode;
                headNext.pre = newNode;

                int index = key % tableLength;
                Entry entry = table[index];
                if (entry == null) {
                    table[index] = newNode;
                } else {
                    while (entry.next != null) {
                        entry = entry.next;
                    }
                    entry.next = newNode;
                }

                size++;
            } else {
                Entry oldestNode = TAIL.pre;
                Entry oldestNodePre = oldestNode.pre;

                oldestNodePre.next = TAIL;
                TAIL.pre = oldestNodePre;

                int oldestKey = oldestNode.key;
                int index = oldestKey % tableLength;
                Entry entry = table[index];
                if (entry.key == oldestKey) {
                    table[index] = entry.tableNext;
                } else {
                    Entry tablePre = entry;
                    entry = entry.tableNext;

                    while (entry.key != key) {
                        tablePre = tablePre.tableNext;
                        entry = entry.tableNext;
                    }

                    tablePre.tableNext = entry.tableNext;
                }


                //oldestNode = null; // help gc

                size--;

                put(key, value);
            }
        }

        @Override
        public String toString() {
            List<Entry> entryList = new LinkedList<>();
            Entry entry = HEAD;
            while (entry != null) {
                entryList.add(entry);
                entry = entry.next;
            }

            return Arrays.toString(table) + "\n" + entryList.toString();
        }

        class Entry {
            int key;
            int value;
            Entry pre;
            Entry next;
            Entry tableNext;


            @Override
            public String toString() {
                return "Entry{" +
                        "key=" + key +
                        ", value=" + value +
                        '}';
            }
        }
    }
}
