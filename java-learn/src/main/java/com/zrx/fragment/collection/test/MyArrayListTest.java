package com.zrx.fragment.collection.test;

import com.zrx.Invoking;
import com.zrx.fragment.collection.MyArrayList;
import com.zrx.fragment.collection.MyIterator;
import com.zrx.fragment.collection.MyList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Description
 * MyArrayListTest
 * <p>
 * Data
 * 2020/4/4-19:03
 *
 * @author zrx
 * @version 1.0
 */

@Component
@Invoking(createdTime = "2020-04-04 19:03",info = "MyArrayListTest")
public class MyArrayListTest {
    private final static Logger LOGGER = LoggerFactory.getLogger(MyArrayListTest.class);

    @Invoking(createdTime = "2020-04-04 19:04",info = "addTest")
    public void addTest(){
        MyArrayList<String> list = new MyArrayList<>(4);

        list.add("aa");
        list.add("aa");
        list.add("bb");

        LOGGER.info("list = {}", list);
    }

    @Invoking(createdTime = "2020-04-04 19:13",info = "扩容测试")
    public void 扩容测试(){
        MyList<String> list = new MyArrayList<>(2);

        for (int i = 0; i < 4; i++) {
            list.add("aa" + i);
        }

        LOGGER.info("list = {}", list);
    }

    @Invoking(createdTime = "2020-04-04 19:18",info = "遍历器")
    public void 遍历器(){
        MyList<String> list = new MyArrayList<>(2);

        for (int i = 0; i < 4; i++) {
            list.add("aa" + i);
        }

        MyIterator<String> iterator = list.iterator();

        while (iterator.hasNext()){
            String next = iterator.next();
            LOGGER.info("next = {}", next);
        }

        list.forEach(e-> LOGGER.info("e = {}", e));
        //2020-04-04 19:19:56.187  INFO 7060 --- [           main] c.z.f.collection.test.MyArrayListTest    : next = aa0
        //2020-04-04 19:19:56.187  INFO 7060 --- [           main] c.z.f.collection.test.MyArrayListTest    : next = aa1
        //2020-04-04 19:19:56.187  INFO 7060 --- [           main] c.z.f.collection.test.MyArrayListTest    : next = aa2
        //2020-04-04 19:19:56.187  INFO 7060 --- [           main] c.z.f.collection.test.MyArrayListTest    : next = aa3
        //2020-04-04 19:19:56.188  INFO 7060 --- [           main] c.z.f.collection.test.MyArrayListTest    : e = aa0
        //2020-04-04 19:19:56.189  INFO 7060 --- [           main] c.z.f.collection.test.MyArrayListTest    : e = aa1
        //2020-04-04 19:19:56.189  INFO 7060 --- [           main] c.z.f.collection.test.MyArrayListTest    : e = aa2
        //2020-04-04 19:19:56.189  INFO 7060 --- [           main] c.z.f.collection.test.MyArrayListTest    : e = aa3
    }

    @Invoking(createdTime = "2020-04-04 19:20",info = "getTest")
    public void getTest(){
        MyList<String> list = new MyArrayList<>(2);

        for (int i = 0; i < 4; i++) {
            list.add("aa" + i);
        }

        for (int i = 0; i < 4; i++) {
            String get = list.get(i);
            LOGGER.info("get = {}", get);
        }
    }

    @Invoking(createdTime = "2020-04-04 19:21",info = "setTest")
    public void setTest(){
        MyList<String> list = new MyArrayList<>(2);

        for (int i = 0; i < 4; i++) {
            list.add("aa" + i);
        }

        LOGGER.info("list = {}", list);

        list.set(1,"bb");

        LOGGER.info("list = {}", list);
    }

    @Invoking(createdTime = "2020-04-04 19:22",info = "removeTest")
    public void removeTest(){
        MyList<String> list = new MyArrayList<>(2);

        for (int i = 0; i < 4; i++) {
            list.add("aa" + i);
        }

        LOGGER.info("list = {}", list);

        LOGGER.info("list.remove(\"bb\") = {}", list.remove("bb"));
        LOGGER.info("list.remove(\"aa1\") = {}", list.remove("aa1"));

        LOGGER.info("list = {}", list);
    }
}

