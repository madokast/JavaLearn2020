package com.zrx.algorithm.leetcode.object;

import com.zrx.algorithm.Equality;
import com.zrx.algorithm.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Description
 * 如果进行 equals 运算的对象，有方是 OptionalSet
 * 那么实际上进行的运算是
 * <p>
 * isEqual()
 * <p>
 *
 * @author madokast
 * @version 1.0
 */

public class OptionalSet<E> {

    private Set<E> set;

    public OptionalSet() {
        set = new HashSet<>();
    }

    public OptionalSet(Collection<E> c) {
        set = new HashSet<>(c);
    }

    public OptionalSet(E[] es) {
        set = new HashSet<>(Arrays.asList(es));
    }

    public static <E> OptionalSet<E> of() {
        return new OptionalSet<E>();
    }

    public static <E> OptionalSet<E> of(E e) {
        return new OptionalSet<E>(List.of(e));
    }

    public static <E> OptionalSet<E> of(E e1, E e2) {
        return new OptionalSet<E>(List.of(e1, e2));
    }

    public static <E> OptionalSet<E> of(E... es) {
        return new OptionalSet<E>(es);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        for (E e : set) {
            if (Equality.isEqual(e, o)) {
                return true;
            }
        }


        if (o == null || getClass() != o.getClass()) return false;

        OptionalSet<?> that = (OptionalSet<?>) o;

        for (E e : set) {
            for (Object ee : that.set) {
                if (Equality.isEqual(e, ee)) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(set);
    }

    @Override
    public String toString() {
        String collect = set.stream().map(ToString::apply).collect(Collectors.joining());

        return "OptionalSet{"
                + collect +
                '}';
    }
}
