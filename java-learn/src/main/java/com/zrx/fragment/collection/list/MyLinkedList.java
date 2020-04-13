package com.zrx.fragment.collection.list;

import com.zrx.fragment.collection.MyIterator;
import com.zrx.utils.MyLoggerFactory;
import org.slf4j.Logger;

import java.util.Objects;

/**
 * Description
 * MyLinkedList
 * 双向链表
 *
 * @author zrx
 * @version 1.0
 * @see java.util.LinkedList
 * <p>
 * Data
 * 2020/4/4-19:29
 */

public class MyLinkedList<E> implements MyList<E> {
    private final static Logger LOGGER = MyLoggerFactory.getLogger(MyLinkedList.class);

    private Node<E> first;

    private Node<E> last;

    private int size;

    public MyLinkedList() {
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
        MyIterator<E> iterator = iterator();
        while (iterator.hasNext()) {
            E e = iterator.next();
            if (Objects.equals(e, o))
                return true;
        }
        return false;
    }

    @Override
    public MyIterator<E> iterator() {
        return new MyLinkedListIterator<>(first);
    }

    @Override
    public boolean add(E e) {
        Node<E> node = new Node<E>(e);

        if (isEmpty()) {
            first = node;

        } else {
            // 加到 last后面

            last.next = node;
            node.previous = last;

            // 自己成为last

        }

        last = node;

        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int i = indexOf(o);
        if (i == -1) {
            return false;
        } else {
            remove(i);
            return true;
        }
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    private Node<E> get0(int index) {
        if (index < size / 2)
            return getFromFirst(index);
        else
            return getFromLast(index);
    }

    private Node<E> getFromFirst(int index) {
        LOGGER.info("getFromFirst");
        Node<E> header = first;

        while (index > 0) {
            index--;
            header = header.next;
        }

        return header;
    }

    private Node<E> getFromLast(int index) {
        LOGGER.info("getFromLast");
        index = size - index - 1;

        Node<E> tail = last;

        while (index > 0) {
            index--;
            tail = tail.previous;
        }

        return tail;
    }

    @Override
    public E get(int index) {
        if (index < 0)
            throw new IllegalArgumentException("index " + index);

        if (index >= size)
            throw new ArrayIndexOutOfBoundsException("index " + index + " size " + size);


        return get0(index).e;
    }

    @Override
    public E set(int index, E element) {
        if (index < 0)
            throw new IllegalArgumentException("index " + index);

        if (index >= size)
            throw new ArrayIndexOutOfBoundsException("index " + index + " size " + size);

        Node<E> node = get0(index);
        E old = node.e;
        node.e = element;

        return old;
    }

    @Override
    public void add(int index, E element) {
        if (index > size)
            throw new ArrayIndexOutOfBoundsException("index " + index + " size " + size);

        Node<E> node = new Node<>(element);

        if (isEmpty() || index == size) {
            add(element);
            return;
        }

        if (index == 0) {
            node.next = first;
            first.previous = node;

            first = node;
            size++;

            return;
        }


        Node<E> cur = first;
        Node<E> pre = null;
        while (cur != null && index > 0) {
            cur = cur.next;
            index--;
        }

        pre = cur.previous;

        cur.previous = node;
        node.next = cur;

        pre.next = node;
        node.previous = pre;

        size++;
    }

    @Override
    public E remove(int index) {
        if (index < 0)
            throw new IllegalArgumentException("index " + index);

        if (index >= size)
            throw new ArrayIndexOutOfBoundsException("index " + index + " size " + size);

        Node<E> node = get0(index);
        E e = node.e;

        if (size == 1) {
            last = null;
            first = null;
        } else if (node == first) {
            first = first.next;
        } else if (node == last) {
            Node<E> previous = last.previous;
            last.previous = null;
            last = previous;
            last.next = null;
        } else {
            Node<E> next = node.next;
            Node<E> previous = node.previous;

            previous.next = next;
            next.previous = previous;
        }

        size--;
        return e;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;

        MyIterator<E> iterator = iterator();

        while (iterator.hasNext()) {
            E next = iterator.next();
            if (Objects.equals(o, next))
                return index;

            index++;
        }

        return -1;
    }

    @Override
    public String toString() {
        if (isEmpty())
            return "[]";

        StringBuilder sb = new StringBuilder("[");
        MyIterator<E> iterator = iterator();

        while (iterator.hasNext()) {
            sb.append(iterator.next()).append("->");
        }


        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");


        return sb.toString();
    }

    private static class MyLinkedListIterator<E> implements MyIterator<E> {
        private Node<E> first;

        public MyLinkedListIterator(Node<E> first) {
            this.first = first;
        }

        @Override
        public boolean hasNext() {
            return first != null;
        }

        @Override
        public E next() {
            E e = first.e;
            first = first.next;
            return e;
        }
    }

    private static class Node<E> {
        private Node<E> previous;
        private E e;
        private Node<E> next;

        public Node(E e) {
            this.e = e;
        }
    }
}
