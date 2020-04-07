package com.zrx.fragment.collection;

import java.util.Iterator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * 容器 list set都可以遍历
 * @param <T> 元素
 * @see Iterable
 */

public interface MyIterable<T>{
    MyIterator<T> iterator();

    default void forEach(Consumer<? super T> action) {
        Objects.requireNonNull(action);
        MyIterator<T> iterator = iterator();
        while (iterator.hasNext()){
            action.accept(iterator.next());
        }
    }

    /**
     * 可分割迭代器
     * @return 为了并行遍历元素而设计的一个迭代器
     */
    default Spliterator<T> spliterator() {
        throw new UnsupportedOperationException();
    }
}
