package com.zrx.fragment.collection;

import com.zrx.fragment.collection.list.MyArrayList;
import com.zrx.fragment.collection.list.MyList;
import com.zrx.fragment.collection.map.MyHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Supplier;

/**
 * Description
 * MyHashSet
 * <p>
 * Data
 * 2020/4/10-20:46
 *
 * @author zrx
 * @version 1.0
 */

public class MyHashSet<E> implements MySet<E> {
    private final static Logger LOGGER = LoggerFactory.getLogger(MyHashSet.class);

    private MyHashMap<Object,Object> map;

    private final static Object OBJECT = new Object();

    public MyHashSet(){
        map = new MyHashMap<>();
    }

    public MyHashSet(int capacity){
        map = new MyHashMap<>(capacity);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public MyIterator<E> iterator() {
        return new MyHashSetIterator<>();
    }

    @Override
    public boolean add(E e) {
        map.put(e,OBJECT);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o)!=null;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @SuppressWarnings("unchecked")
    public class MyHashSetIterator<E> implements MyIterator<E>{
        MyIterator<E> myArrayListIterator;

        private MyHashSetIterator() {
            myArrayListIterator= map.toEntries().stream().
                    map(MyHashMap.Node::getKey).
                    collect(
                            (Supplier<MyArrayList<E>>) MyArrayList::new,
                            (l,e)->l.add((E)e),
                            MyList::addAll
                    ).iterator();
        }

        @Override
        public boolean hasNext() {
            return myArrayListIterator.hasNext();
        }

        @Override
        public E next() {
            return myArrayListIterator.next();
        }
    }
}
