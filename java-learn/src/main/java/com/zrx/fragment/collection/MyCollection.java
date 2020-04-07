package com.zrx.fragment.collection;

import java.util.*;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * 2020年4月4日 学习Java集合/容器
 * 基本方法
 *
 * @see MyCollection#size()
 * @see MyCollection#isEmpty()
 * @see MyCollection#contains(Object)
 * @see MyCollection#iterator()
 * @see MyCollection#add(Object)
 * @see MyCollection#remove(Object)
 * @see MyCollection#clear()
 * @see Collection
 */

public interface MyCollection<E> extends MyIterable<E> {

    int size();

    boolean isEmpty();

    boolean contains(Object o);

    MyIterator<E> iterator();

    boolean add(E e);

    boolean remove(Object o);

    void clear();

    // --------------  throw new UnsupportedOperationException() -------------------

    default Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    default <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }

    default <T> T[] toArray(IntFunction<T[]> generator) {
        throw new UnsupportedOperationException();
    }


    default boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    default boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    default boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    default boolean removeIf(Predicate<? super E> filter) {
        throw new UnsupportedOperationException();
    }

    default boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    // Comparison and hashing
    boolean equals(Object o);

    int hashCode();

    @Override
    default Spliterator<E> spliterator() {
        throw new UnsupportedOperationException();
    }

    default Stream<E> stream() {
        throw new UnsupportedOperationException();
    }

    default Stream<E> parallelStream() {
        throw new UnsupportedOperationException();
    }
}
