package com.zrx.fragment.collection.test;

import com.zrx.Invoking;
import com.zrx.fragment.collection.MyLinkedList;
import com.zrx.fragment.collection.MyList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Description
 * MyLinkedList
 * <p>
 * Data
 * 2020/4/5-23:03
 *
 * @author zrx
 * @version 1.0
 */

@Component
@Invoking(createdTime = "2020-04-05 23:03", info = "MyLinkedList")
public class MyLinkedListTest {
    private final static Logger LOGGER = LoggerFactory.getLogger(MyLinkedListTest.class);

    @Invoking(createdTime = "2020-04-05 23:04", info = "addTest")
    public void addTest() {
        MyList<Integer> list = new MyLinkedList<>();

        LOGGER.info("list = {}", list);

        list.add(1);
        LOGGER.info("add 1 over");

        LOGGER.info("list.size() = {}", list.size());

        LOGGER.info("list = {}", list);

        list.add(2);
        list.add(100);

        LOGGER.info("list = {}", list);
    }

    @Invoking(createdTime = "2020-04-05 23:49", info = "addTest2")
    public void addTest2() {
        MyList<Integer> list = new MyLinkedList<>();

        list.add(0);
        list.add(0);
        list.add(0);

        LOGGER.info("list = {}", list);

        list.clear();
        LOGGER.info("list = {}", list);

        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);

        LOGGER.info("list = {}", list);
    }

    @Invoking(createdTime = "2020-04-05 23:51", info = "addTest3")
    public void addTest3() {
        MyList<Integer> list = new MyLinkedList<>();

        LOGGER.info("list = {}", list);

        list.add(0, 2);

        LOGGER.info("list = {}", list);

        list.clear();

        try {
            list.add(1, 2);
        } catch (ArrayIndexOutOfBoundsException e) {
            LOGGER.info("e.getMessage() = {}", e.getMessage());
        }
    }

    @Invoking(createdTime = "2020-04-05 23:57", info = "addTest4")
    public void addTest4() {
        MyList<Integer> list = new MyLinkedList<>();

        list.add(3);
        list.add(2);
        list.add(1);

        LOGGER.info("list = {}", list);// 3 2 1

        list.add(0, 4);

        LOGGER.info("list = {}", list);// 4 3 2 1

        list.add(list.size(), -1);

        LOGGER.info("list = {}", list);// 4 3 2 1 -1
    }

    @Invoking(createdTime = "2020-04-06 00:04", info = "getTest")
    public void getTest() {
        MyList<String> list = new MyLinkedList<>();

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");

        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            LOGGER.info("s = {}", s);
        }

        list.clear();

        list.add("z");

        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            LOGGER.info("s = {}", s);
        }

    }

    @Invoking(createdTime = "2020-04-06 00:14", info = "setTest")
    public void setTest () {
        MyList<String> list = new MyLinkedList<>();

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");

        LOGGER.info("list = {}", list);

        list.set(0,"1");
        list.set(1,"2");
        list.set(2,"3");
        list.set(3,"4");
        list.set(4,"5");

        LOGGER.info("list = {}", list);
    }

    @Invoking(createdTime = "2020-04-06 00:23",info = "remove")
    public void removeTest(){
        MyList<String> list = new MyLinkedList<>();

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");

        LOGGER.info("list = {}", list);
        list.remove("a");
        LOGGER.info("list = {}", list);
        list.remove("e");
        LOGGER.info("list = {}", list);
        list.remove("c");
        LOGGER.info("list = {}", list);
    }

    @Invoking(createdTime = "2020-04-06 00:22",info = "removeTest1")
    public void removeTest1(){
        MyList<String> list = new MyLinkedList<>();

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");

        LOGGER.info("list = {}", list);
        list.remove(0);
        LOGGER.info("list = {}", list);
        list.remove(list.size()-1);
        LOGGER.info("list = {}", list);
        list.remove(1);
        LOGGER.info("list = {}", list);
    }
}
