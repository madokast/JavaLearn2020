package com.zrx.algorithm.leetcode.object;

import com.zrx.algorithm.Equality;
import com.zrx.algorithm.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Description
 * 可重复Set
 * 用于leetcode中，有的返回list不需要顺序一致
 * <p>
 * Data
 * 2020/4/5-16:57
 *
 * @author zrx
 * @version 1.0
 */

public class RepeatableSet<E> {
    private final static Logger LOGGER = LoggerFactory.getLogger(RepeatableSet.class);

    private List<E> data;

    public RepeatableSet() {
        this.data = new ArrayList<>();
    }

    public RepeatableSet(Collection<E> collection) {
        this.data = new ArrayList<>(collection);
    }

    public List<E> toList() {
        return data;
    }

    public static <E> RepeatableSet<E> of() {
        return new RepeatableSet<E>(List.of());
    }

    public static <E> RepeatableSet<E> of(E e) {
        return new RepeatableSet<E>(List.of(e));
    }

    public static <E> RepeatableSet<E> of(E e1, E e2) {
        return new RepeatableSet<E>(List.of(e1, e2));
    }

    public static <E> RepeatableSet<E> of(E e1, E e2, E e3) {
        return new RepeatableSet<E>(List.of(e1, e2, e3));
    }

    public static RepeatableSet<?> tryCreate(Object collection) {
        if (collection instanceof Collection)
            return new RepeatableSet<>((Collection<?>) collection);
        if (collection instanceof RepeatableSet)
            return (RepeatableSet<?>) collection;

        LOGGER.error("无法转为Object为RepeatableSet");

        return null;
    }

    @SafeVarargs
    public static <E> RepeatableSet<E> of(E... es) {
        return new RepeatableSet<>(List.of(es));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        RepeatableSet<?> that = (RepeatableSet<?>) o;

        List<?> l1 = this.data;
        List<?> l2 = that.data;

        if (l1.size() != l2.size())
            return false;

        List<?> ll1 = new LinkedList<>(l1);
        List<?> ll2 = new LinkedList<>(l2);

        while (ll1.size() > 0) {
            Object e1 = ll1.get(0);
            Object e2 = null;
            for (Object o2 : ll2) {
                if (Equality.isEqual(e1, o2))
                    e2 = o2;
            }

            if (e2 == null)
                return false;

            ll1.remove(e1);
            ll2.remove(e2);
        }

        return true;
    }

    @Override
    public int hashCode() {
        // 顺序无关
        return data.stream()
                .mapToInt(Objects::hashCode)
                .sum();
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
