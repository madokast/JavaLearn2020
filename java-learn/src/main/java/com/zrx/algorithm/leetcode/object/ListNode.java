package com.zrx.algorithm.leetcode.object;

import com.zrx.utils.IntArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description
 * leetcode 对象 ListNode
 * <p>
 * Data
 * 2020/3/23-21:48
 *
 * @author zrx
 * @version 1.0
 */

public class ListNode {
    private final static Logger LOGGER = LoggerFactory.getLogger(ListNode.class);

    public int val;

    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode of(int... values) {
        ListNode head = new ListNode(values[0]);

        ListNode n = head;

        for (int i = 1; i < values.length; i++) {
            n.next = new ListNode(values[i]);
            n = n.next;
        }

        return head;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        ListNode n = this;

        while (n.next != null) {
            sb.append(n.val).append("->");

            n = n.next;
        }

        sb.append(n.val).append("]");

        return sb.toString();
    }

    private int[] toArray() {
        ListNode n = this;
        List<Integer> list = new ArrayList<>();

        while (n != null) {
            list.add(n.val);
            n = n.next;
        }

        return IntArray.create(list);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;

        return Arrays.equals(this.toArray(),listNode.toArray());

    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(toArray());
    }
}
