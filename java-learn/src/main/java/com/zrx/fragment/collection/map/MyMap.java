package com.zrx.fragment.collection.map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Description
 * Map 接口
 * @see java.util.Map
 * <p>
 * Data
 * 2020/4/8-11:11
 *
 * @author zrx
 * @version 1.0
 */

public interface MyMap<K, V> {
    int size();

    boolean isEmpty();

    boolean containsKey(K key);

    boolean containsValue(V value);

    V get(K key);

    // 返回null或旧值
    V put(K key,V value);

    V remove(K key);

    void clear();

    boolean equals(Object o);
    int hashCode();
    String toString();

    interface Entry<K, V>{
        K getKey();
        V getValue();
        V setValue(V value);
        boolean equals(Object o);
        int hashCode();
        String toString();
    }
}
