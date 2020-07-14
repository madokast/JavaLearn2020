package com.zrx.fragment.concurrent.Java高并发程序设计葛一鸣;

import com.zrx.Invoking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Description
 * A04并发容器
 * <p>
 * Data
 * 2020/7/12-19:19
 *
 * @author zrx
 * @version 1.0
 */

@Invoking(createdTime = "2020-07-12 19:19")
public class A04并发容器 {
    private final static Logger LOGGER = LoggerFactory.getLogger(A04并发容器.class);

    @Invoking(createdTime = "2020-07-12 19:19")
    public void test(){
        // implements List<E>, RandomAccess, Cloneable, java.io.Serializable
        // CopyOnWriteArrayList


        //public interface BlockingQueue<E> extends Queue<E>
        // BlockingQueue

        //public class ConcurrentSkipListMap<K,V> extends AbstractMap<K,V>
        //    implements ConcurrentNavigableMap<K,V>, Cloneable, Serializable
        // ConcurrentSkipListMap

        //ConcurrentLinkedQueue
    }
}
