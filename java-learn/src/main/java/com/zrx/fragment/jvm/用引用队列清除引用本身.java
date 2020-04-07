package com.zrx.fragment.jvm;

import com.zrx.Invoking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Description
 * 我有个list，里面存放 softR<Obj>，这样Obj没有强引用时，会被回收
 * 此时 list中的 softR 里的对象已经是null，但是 softR本身还在list中，这不好！
 * 怎么清除呢？
 * 这里用弱引用代替
 * <p>
 * Data
 * 2020/4/4-15:13
 *
 * @author zrx
 * @version 1.0
 */

@Component
@Invoking(createdTime = "2020-04-04 15:14",info = "用引用队列清除引用本身")
@SuppressWarnings("unchecked")
public class 用引用队列清除引用本身 {
    private final static Logger LOGGER = LoggerFactory.getLogger(用引用队列清除引用本身.class);

    @Invoking(createdTime = "2020-04-04 15:14",info = "test")
    public void test(){

        List<WeakReference<Object>> list = new ArrayList<>();

        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();

        for (int i = 0; i < 10; i++) {
            WeakReference<Object> objR = new WeakReference<>(new Byte[4*1024*1024],referenceQueue);
            list.add(objR);
        }

        LOGGER.info("手动GC");
        System.gc();

        LOGGER.info("list.size = {}", list.size());

        // 可以看到 list 中的弱引用都空了，但是list中还有 objR，怎么清除呢？
        LOGGER.info("清除list中的引用");
        for(;;){
            WeakReference<Object> poll = (WeakReference<Object>)referenceQueue.poll();
            if(poll==null){
                break;
            }else {
                list.remove(poll);
            }
        }

        LOGGER.info("list.size = {}", list.size());

        //2020-04-04 15:26:21.576  INFO 14120 --- [           main] com.zrx.fragment.jvm.用引用队列清除引用本身         : list.size = 10
        //2020-04-04 15:26:21.576  INFO 14120 --- [           main] com.zrx.fragment.jvm.用引用队列清除引用本身         : 清除list中的引用
        //2020-04-04 15:26:21.577  INFO 14120 --- [           main] com.zrx.fragment.jvm.用引用队列清除引用本身         : list.size = 0
    }
}
