package com.zrx.fragment.collection.list;

import com.zrx.fragment.collection.MyCollection;
import com.zrx.fragment.collection.MyIterator;
import com.zrx.utils.MyLoggerFactory;
import org.slf4j.Logger;

import java.util.Arrays;
import java.util.Objects;

/**
 * Description
 * MyArrayList
 * 数组扩容原理
 * 扩大：len += len/2
 *
 * @author zrx
 * @version 1.0
 * @see java.util.ArrayList
 * @see java.util.Vector
 *
 * <p>
 * Data
 * 2020/4/4-17:47
 */

@SuppressWarnings("unchecked")
public class MyArrayList<E> implements MyList<E> {
    private final static Logger LOGGER = MyLoggerFactory.getLogger(MyArrayList.class);

    private static final int DEFAULT_CAPACITY = 10;

    private Object[] elementData;

    private int size = 0;

    public MyArrayList(){
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int initialCapacity){
        elementData = new Object[initialCapacity];
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
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public MyIterator<E> iterator() {
        return new MyArrayListIterator<>(elementData,size);
    }

    @Override
    public boolean add(E e) {
        add(size,e);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index == -1)
            return false;
        else {
            remove(index);
            size--;
            return true;
        }
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return (E) elementData[index];
    }

    @Override
    public E set(int index, E element) {
        rangeCheck(index);
        E old = (E) elementData[index];
        elementData[index]=element;
        return old;
    }

    @Override
    public void add(int index, E element) {
        rangeCheck(index==0?0:index-1);
        ensureCapacity(size+1);
        System.arraycopy(elementData,index,elementData,index+1,size-index);
        elementData[index]=element;
        size++;
    }

    @Override
    public boolean addAll(MyCollection<? extends E> c) {
        MyIterator<? extends E> iterator = c.iterator();
        while (iterator.hasNext()){
            add(iterator.next());
        }

        return true;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);

        E removed = (E) elementData[index];

        // 需要移动的元素数目
        int numberMoved = size - index - 1;

        System.arraycopy(elementData, index + 1, elementData, index, numberMoved);

        return removed;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < elementData.length; i++) {
            if (Objects.equals(elementData[i],o))
                return i;
        }
        return -1;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOfRange(elementData,0,size);
    }

    @Override
    public String toString() {
        return "{size=" + size+", capacity=" + elementData.length + ", data=" + Arrays.deepToString(toArray()) + "}";
    }

    // --------------- private method

    private void rangeCheck(int index) {
        if (index < 0)
            throw new IllegalArgumentException("index = " + index);
        if (index > size)
            throw new ArrayIndexOutOfBoundsException("index = " + index + ", size =" + size);
    }

    private void ensureCapacity(int newSize) {
        int oldCapacity = elementData.length;
        if (newSize > oldCapacity) {
            LOGGER.info("MyList扩容");

            int newCapacity = oldCapacity + (oldCapacity >> 1);
            if (newCapacity < newSize)
                newCapacity = newSize;

            Object[] data = new Object[newCapacity];

            System.arraycopy(elementData, 0, data, 0, size);
            elementData = data;
        }
    }

    public static class MyArrayListIterator<E> implements MyIterator<E>{
        private final Object[] elementData;

        private final int size;

        private int index = 0;

        public MyArrayListIterator(Object[] elementData, int size) {
            this.elementData = elementData;
            this.size = size;
        }

        @Override
        public boolean hasNext() {
            return index<size;
        }

        @Override
        public E next() {
            return (E) elementData[index++];
        }
    }
}
