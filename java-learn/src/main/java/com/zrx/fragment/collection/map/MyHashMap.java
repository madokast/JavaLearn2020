package com.zrx.fragment.collection.map;

import com.zrx.fragment.collection.list.MyArrayList;
import com.zrx.fragment.collection.list.MyList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Assert;

import java.lang.ref.Cleaner;
import java.lang.ref.PhantomReference;
import java.lang.ref.SoftReference;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Description
 * MyHashMap
 * 老版本，不写红黑树
 *
 * @author zrx
 * @version 1.0
 * @see java.util.HashMap
 * @see java.util.LinkedHashMap
 * <p>
 * Data
 * 2020/4/8-11:20
 */

public class MyHashMap<K, V> implements MyMap<K, V> {
    private final static Logger LOGGER = LoggerFactory.getLogger(MyHashMap.class);

    // 默认容量16
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    // 默认承载因子 0.75
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    float loadFactor;

    transient Node<K, V>[] table;

    int size;

    @SuppressWarnings("unchecked")
    public MyHashMap(int capacity, float loadFactor) {
        // 需要手动转泛型
        table = (Node<K, V>[]) new Node[capacity];

        this.loadFactor = loadFactor;
    }

    public MyHashMap() {
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap(int capacity) {
        this(capacity, DEFAULT_LOAD_FACTOR);
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(K key) {
        return toEntries().stream().map(Node::getKey).filter(k -> k.equals(key)).count() == 1;
    }

    @Override
    public boolean containsValue(V value) {
        return toEntries().stream().map(Node::getValue).filter(v -> Objects.equals(v, value)).count() >= 1;
    }

    @Override
    public V get(K key) {
        int hashCode = key.hashCode();
        int index = hashCode & (table.length - 1);

        Node<K, V> node = table[index];
        if (node == null)
            return null;
        else {
            if (node.hash == hashCode && node.key.equals(key))
                return node.value;
            else {
                while (node.next != null) {
                    node = node.next;
                    if (node.hash == hashCode && node.key.equals(key))
                        return node.value;
                }

                return null;
            }
        }
    }

    @Override
    public V put(K key, V value) {
        if (table.length * loadFactor < size) {
            reHash();
            put(key, value);
        }

        int hashcode = key.hashCode();
        int index = hashcode & (table.length - 1);

        if (table[index] == null) {
            // 肯定没有相同节点
            table[index] = new Node<>(hashcode, key, value, null);
            size++;
            return null;
        } else {
            // 表中已存在一个node
            Node<K, V> node = table[index];

            // 判断这个node的key和key是不是相同
            if (node.hash == hashcode && node.key.equals(key)) {
                // 是相同的，替换即可
                V oldValve = node.value;
                node.value = value;
                return oldValve;
            } else {
                // 不相同，那么就向下寻找
                while (node.next != null) {
                    // 如果node 下面还有，相同方法判断
                    Node<K, V> next = node.next;

                    if (next.hash == hashcode && next.key.equals(key)) {
                        // 是相同的，替换即可
                        V oldValve = next.value;
                        next.value = value;
                        return oldValve;
                    } else {
                        // next也不是的，那就继续往下搜索
                        node = next;
                    }
                }

                // 到这里，说明这个桶上链表，都没有和key一样的，那就插最后面

                node.next = new Node<>(hashcode, key, value, null);
                size++;
                return null;
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void reHash() {
        Node<K, V>[] oldTable = table;
        Node<K, V>[] newTable = null;

        if (table.length * loadFactor < size) {
            newTable = (Node<K, V>[]) (new Node[oldTable.length << 1]);
        }

        Objects.requireNonNull(newTable);

        MyList<Node<K, V>> entries = toEntries();

        size = 0;
        table = newTable;

        entries.forEach(node -> put(node.key, node.value));
    }

    @Override
    public V remove(K key) {
        int hashCode = key.hashCode();
        int index = hashCode & (table.length - 1);

        Node<K, V> node = table[index];
        if (node != null) {
            V v;

            if (node.hash == hashCode && node.key.equals(key)) {
                LOGGER.info("find in table");
                v = node.value;
                table[index] = node.next;
                size--;

                return v;

            }
            Node<K, V> pre = node;
            while (node.next != null) {
                node = node.next;
                if (node.hash == hashCode && node.key.equals(key)) {
                    v = node.value;
                    pre.next = node.next;
                    size--;
                    return v;
                }
            }
        }
        return null;
    }

    @Override
    public void clear() {
        size = 0;
        Arrays.fill(table, null);
    }

    public MyList<Node<K, V>> toEntries() {
        MyList<Node<K, V>> list = new MyArrayList<>(size);
        for (Node<K, V> node : table) {
            while (node != null) {
                list.add(node);
                node = node.next;
            }
        }
        Assert.isTrue(size == list.size(), "数目不对");
        return list;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Node<K, V> node : table) {
            if (node == null)
                sb.append("[null]");
            else {
                sb.append("[");
                while (node != null) {
                    sb.append(node);
                    if (node.next != null)
                        sb.append("->");
                    node = node.next;
                }
                sb.append("]");
            }
        }

        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    // -------------- 以下是复制的，但是要看懂
    public static class Node<K, V> implements MyMap.Entry<K, V> {
        // 一个node建立，hash和key设置位final，value可以修改，还需要一个next，成链表
        final int hash;
        final K key;
        V value;
        MyHashMap.Node<K, V> next;

        Node(int hash, K key, V value, MyHashMap.Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }

        public final String toString() {
            return "{" + key + ":" + value + "}";
        }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public final boolean equals(Object o) {
            if (o == this)
                return true;
            if (o instanceof Map.Entry) {
                Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;
                if (Objects.equals(key, e.getKey()) &&
                        Objects.equals(value, e.getValue()))
                    return true;
            }
            return false;
        }
    }
}
