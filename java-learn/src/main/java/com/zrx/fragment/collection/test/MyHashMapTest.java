package com.zrx.fragment.collection.test;

import com.zrx.Invoking;
import com.zrx.fragment.collection.map.MyHashMap;
import com.zrx.fragment.collection.map.MyMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Description
 * MyHashMapTest
 * <p>
 * Data
 * 2020/4/8-11:57
 *
 * @author zrx
 * @version 1.0
 */

@Component
@Invoking(createdTime = "2020-04-08 11:57",info = "MyHashMapTest")
public class MyHashMapTest {
    private final static Logger LOGGER = LoggerFactory.getLogger(MyHashMapTest.class);

    @Invoking(createdTime = "2020-04-10 20:36",info = "removeTest")
    public void removeTest(){
        MyMap<Integer,Integer> myMap = new MyHashMap<>(2);

        myMap.put(1,1);
        myMap.put(3,3);

        LOGGER.info("myMap = {}", myMap);

        myMap.remove(1);

        LOGGER.info("myMap = {}", myMap);
    }

    @Invoking(createdTime = "2020-04-10 20:15",info = "reHash")
    public void reHashTest(){
        MyMap<Integer,Integer> myMap = new MyHashMap<>(2);

        for (int i = 0; i < 20; i++) {
            myMap.put(i,i+i);
            //LOGGER.info("myMap = {}", myMap);
        }
    }

    @Invoking(createdTime = "2020-04-10 20:00",info = "getTest")
    public void getTest(){
        MyMap<Integer,String> myMap = new MyHashMap<>(2);
        myMap.put(2,"b");
        myMap.put(4,"d");

        LOGGER.info("myMap = {}", myMap);

        LOGGER.info("myMap.get(1) = {}", myMap.get(1));
        LOGGER.info("myMap.get(2) = {}", myMap.get(2));
        LOGGER.info("myMap.get(4) = {}", myMap.get(4));
        LOGGER.info("myMap.get(6) = {}", myMap.get(6));
    }

    @Invoking(createdTime = "2020-04-08 11:58",info = "putTest")
    public void putTest(){
        MyMap<Integer,String> map = new MyHashMap<>(2);

        LOGGER.info("map = {}", map);

        map.put(1,"a");
        map.put(2,"b");
        map.put(3,"c");
        map.put(4,"d");

        LOGGER.info("map = {}", map);


        map.put(1,"a1");
        map.put(2,"b2");
        map.put(3,"c3");
        map.put(4,"d4");

        LOGGER.info("map = {}", map);

        map.put(1,"a");
        map.put(2,"b");
        map.put(3,"c");
        map.put(4,"d");

        LOGGER.info("map = {}", map);
    }
}
