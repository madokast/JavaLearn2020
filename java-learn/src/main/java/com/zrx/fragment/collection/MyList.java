package com.zrx.fragment.collection;

import java.util.*;
import java.util.function.UnaryOperator;

/**
 * @param <E> 元素
 * @see MyCollection#size()
 * @see MyCollection#isEmpty()
 * @see MyCollection#contains(Object)
 * @see MyCollection#iterator()
 * @see MyCollection#add(Object)
 * @see MyCollection#remove(Object)
 * @see MyCollection#clear()
 * @see MyList#get(int)
 * @see MyList#set(int, Object)
 * @see MyList#add(int, Object)
 * @see MyList#remove(int)
 * @see MyList#indexOf(Object)
 * @see MyList#lastIndexOf(Object)
 * @see List
 */

public interface MyList<E> extends MyCollection<E> {

    //  --------------- from collection

    int size();

    boolean isEmpty();

    boolean contains(Object o);

    MyIterator<E> iterator();

    boolean add(E e);

    boolean remove(Object o);

    void clear();

    // ---------------  new in list

    E get(int index);

    E set(int index, E element);

    void add(int index, E element);

    E remove(int index);

    int indexOf(Object o);

    default int lastIndexOf(Object o){throw new UnsupportedOperationException();}

    // --------------  throw new UnsupportedOperationException(); -------------------

    default boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }


    default boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }


    default boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }


    default boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }


    default boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }


    default void replaceAll(UnaryOperator<E> operator) {
        throw new UnsupportedOperationException();
    }

    default void sort(Comparator<? super E> c) {
        throw new UnsupportedOperationException();
    }


    boolean equals(Object o);


    int hashCode();

    default ListIterator<E> listIterator() {
        throw new UnsupportedOperationException();
    }

    default ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    default List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }


    default Spliterator<E> spliterator() {
        throw new UnsupportedOperationException();
    }

    static <E> List<E> of() {
        throw new UnsupportedOperationException();
    }


    static <E> List<E> of(E e1) {
        throw new UnsupportedOperationException();
    }

    static <E> List<E> of(E e1, E e2) {
        throw new UnsupportedOperationException();
    }


    static <E> List<E> of(E e1, E e2, E e3) {
        throw new UnsupportedOperationException();
    }

    static <E> List<E> of(E e1, E e2, E e3, E e4) {
        throw new UnsupportedOperationException();
    }


    static <E> List<E> of(E e1, E e2, E e3, E e4, E e5) {
        throw new UnsupportedOperationException();
    }

    static <E> List<E> of(E e1, E e2, E e3, E e4, E e5, E e6) {
        throw new UnsupportedOperationException();
    }


    static <E> List<E> of(E e1, E e2, E e3, E e4, E e5, E e6, E e7) {
        throw new UnsupportedOperationException();
    }

    static <E> List<E> of(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8) {
        throw new UnsupportedOperationException();
    }

    static <E> List<E> of(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9) {
        throw new UnsupportedOperationException();
    }

    static <E> List<E> of(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10) {
        throw new UnsupportedOperationException();
    }

    static <E> List<E> of(E... elements) {
        throw new UnsupportedOperationException();
    }

    static <E> List<E> copyOf(Collection<? extends E> coll) {
        throw new UnsupportedOperationException();
    }
}
