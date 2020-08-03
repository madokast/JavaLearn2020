package com.zrx.fragment.concurrent.others;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Description
 * MyConcurrentHashMap17
 * jdk 1.7 的 hashMap
 * <p>
 * Data
 * 2020/7/29-11:06
 *
 * @author zrx
 * @version 1.0
 */

public class MyConcurrentHashMap17<K, V> {

    private final int CONCURRENT_LEVEL = 16;

    private final Map<K, V>[] segmentTable;

    public MyConcurrentHashMap17() {
        this.segmentTable = (Map<K, V>[]) new HashMap[CONCURRENT_LEVEL];
        for (int i = 0; i < segmentTable.length; i++) {
            segmentTable[i] = new HashMap<>();
        }
    }

    public void put(K key, V value) {
        int segmentIndex = key.hashCode() & (CONCURRENT_LEVEL - 1);
        Map<K, V> segment = segmentTable[segmentIndex];
        synchronized (segment) {
            segment.put(key, value);
        }
    }

    public V get(K key) {
        int segmentIndex = key.hashCode() & (CONCURRENT_LEVEL - 1);
        Map<K, V> segment = segmentTable[segmentIndex];
        synchronized (segment) {
            return segment.get(key);
        }
    }
}
