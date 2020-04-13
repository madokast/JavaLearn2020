package com.zrx.fragment.jvm.反射;

import com.fasterxml.jackson.databind.node.POJONode;
import com.zrx.Invoking;
import com.zrx.utils.Pointer;
import jdk.internal.misc.Unsafe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Description
 * 外部调用父类
 * <p>
 * Data
 * 2020/4/7-8:55
 *
 * @author zrx
 * @version 1.0
 */

//@Component
@Invoking(createdTime = "2020-04-07 08:56", info = "外部调用父类")
public class 外部调用父类 {
    private final static Logger LOGGER = LoggerFactory.getLogger(外部调用父类.class);

    private final static Unsafe unsafe = Pointer.getUnsafe();

    @Invoking(createdTime = "2020-04-07 17:01",info = "我成了")
    public void test(){
        String str = "abc";
        System.out.println(str.toString());// abc

        int klassWordOfObject = unsafe.getInt(new Object(), 8);
        unsafe.putInt(str,8,klassWordOfObject);// abc

        System.out.println(str.toString());// java.lang.Object@52b959df


        int klassWordOfString = unsafe.getInt(new String(), 8);
        unsafe.putInt(str,8,klassWordOfString);

        System.out.println(str.toString());// abc
    }

    class Father {
        int i = 1;
        String fun() {
            return "I am father";
        }
    }

    class Son extends Father {
        int i = 2;
        String fun() {
            return "I am son";
        }
    }


    @Invoking(createdTime = "2020-04-07 16:24",info = "子类对象调用被覆盖的方法")
    public void 子类对象调用被覆盖的方法() {
        Son son = new Son();
        int pson = System.identityHashCode(son);
        LOGGER.info("son.i = {}", son.i);
        String sonSonFun = son.fun();

        Father father = (Father) son;
        int pfarger = System.identityHashCode(father);
        LOGGER.info("father.i = {}", father.i);
        String sonFatherFun = father.fun();

        Pointer.putKlassWord(father,Pointer.getKlassWord(new Father()));
        int pfather2 = System.identityHashCode(father);
        LOGGER.info("father.i = {}", father.i);


        String fatherPut = father.fun();


        LOGGER.info("sonSonFun = {}", sonSonFun);

        LOGGER.info("sonFatherFun = {}", sonFatherFun);

        LOGGER.info("fatherPut = {}", fatherPut);

        LOGGER.info("pson = {}", pson);
        LOGGER.info("pfarger = {}", pfarger);
        LOGGER.info("pfather2 = {}", pfather2);
    }


    @Invoking(createdTime = "2020-04-07 16:11", info = "markWord klassWord 2")
    public void 修改对象元信息() {
        Object obj = new Object();
        String klassWordObject = Pointer.toHexadecimalFrom(Pointer.getKlassWord(obj));
        LOGGER.info("klassWordObject = {}", klassWordObject);

        String s = "abc";
        String klassWordString = Pointer.toHexadecimalFrom(Pointer.getKlassWord(s));
        LOGGER.info("klassWordString = {}", klassWordString);

        String str = String.valueOf(Math.random());
        String klassWordString2 = Pointer.toHexadecimalFrom(Pointer.getKlassWord(str));
        LOGGER.info("klassWordString2 = {}", klassWordString2);

        LOGGER.info("s.toString() = {}", s.toString());

        Pointer.putKlassWord(s, Pointer.getUnsafe().getInt(obj, 8));

        LOGGER.info("s.toString() = {}", s.toString());

    }

    @Invoking(createdTime = "2020-04-07 16:06", info = "markWord klassWord")
    public void 对象元信息() {
        Integer zero = 0;
        Integer min = Integer.MIN_VALUE;
        Integer max = Integer.MAX_VALUE;

        String k0 = Pointer.toHexadecimalFrom(Pointer.getKlassWord(zero));
        String k1 = Pointer.toHexadecimalFrom(Pointer.getKlassWord(min));
        String k2 = Pointer.toHexadecimalFrom(Pointer.getKlassWord(max));

        LOGGER.info("k0 = {}", k0);
        LOGGER.info("k1 = {}", k1);
        LOGGER.info("k2 = {}", k2);

        String m0 = Pointer.toHexadecimalFrom(Pointer.getMarkWord(zero));
        String m1 = Pointer.toHexadecimalFrom(Pointer.getMarkWord(min));
        String m2 = Pointer.toHexadecimalFrom(Pointer.getMarkWord(max));

        LOGGER.info("m0 = {}", m0);
        LOGGER.info("m1 = {}", m1);
        LOGGER.info("m2 = {}", m2);

        LOGGER.info("zero.hashCode() = {}", zero.hashCode());
        LOGGER.info("min.hashCode() = {}", min.hashCode());
        LOGGER.info("max.hashCode() = {}", max.hashCode());


        m0 = Pointer.toHexadecimalFrom(Pointer.getMarkWord(zero));
        m1 = Pointer.toHexadecimalFrom(Pointer.getMarkWord(min));
        m2 = Pointer.toHexadecimalFrom(Pointer.getMarkWord(max));

        LOGGER.info("m0 = {}", m0);
        LOGGER.info("m1 = {}", m1);
        LOGGER.info("m2 = {}", m2);

        synchronized (zero) {
            m0 = Pointer.toHexadecimalFrom(Pointer.getMarkWord(zero));
            LOGGER.info("m0 = {}", m0);
        }
    }

    @Invoking(createdTime = "2020-04-07 10:36", info = "指针修改Integer2")
    public void 指针修改Integer2() {
        Unsafe unsafe = Unsafe.getUnsafe();

        Integer zero = 0;
        Integer min = Integer.MIN_VALUE;
        Integer max = Integer.MAX_VALUE;


    }

    @Invoking(createdTime = "2020-04-07 10:01", info = "指针修改Integer")
    public void 指针修改Integer() throws NoSuchFieldException {
        /**
         * --add-opens java.base/jdk.internal.misc=ALL-UNNAMED
         */
        Unsafe unsafe = Unsafe.getUnsafe();

        Integer zero = 0;
        Integer min = Integer.MIN_VALUE;
        Integer max = Integer.MAX_VALUE;

        Field valueInteger = Integer.class.getDeclaredField("value");
        long offset = unsafe.objectFieldOffset(valueInteger);
        LOGGER.info("offset = {}", offset);


        int i1 = unsafe.getInt(zero, offset);
        int i2 = unsafe.getInt(min, offset);
        int i3 = unsafe.getInt(max, offset);

        LOGGER.info("i1 = {}", i1);
        LOGGER.info("i2 = {}", i2);
        LOGGER.info("i3 = {}", i3);


        for (int i = 0; i < 5; i++) {
            long anInt = unsafe.getAddress(max, i * 64);
            LOGGER.info("{}", Pointer.toHexadecimalFrom(anInt));
        }

        for (int i = 0; i < 5; i++) {
            int anInt = unsafe.getInt(max, i * 4);
            LOGGER.info("{}", Pointer.toHexadecimalFrom(anInt));
        }


        //int zeroFirst = unsafe.getInt(pzero);

        //LOGGER.info("zeroFirst = {}", zeroFirst);

        for (int i = 0; i < 20; i++) {
            int anInt = unsafe.getInt(max, i);
            LOGGER.info("{}", Pointer.toBinaryString(anInt));
        }
    }

    @Invoking(createdTime = "2020-04-07 09:55", info = "toHexadecimalFromTest")
    public void toHexadecimalFromTest() {
        Integer zero = 0;
        Integer min = Integer.MIN_VALUE;
        Integer max = Integer.MAX_VALUE;

        String h1 = Pointer.toHexadecimalFrom(zero);
        String h2 = Pointer.toHexadecimalFrom(min);
        String h3 = Pointer.toHexadecimalFrom(max);

        LOGGER.info("h1 = {}", h1);
        LOGGER.info("h2 = {}", h2);
        LOGGER.info("h3 = {}", h3);
    }


    @Invoking(createdTime = "2020-04-07 08:56", info = "外部调用父类")
    public void 外部调用父类() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String s = "abd";

        /**
         * --add-opens java.base/jdk.internal.misc=ALL-UNNAMED
         */
        Unsafe unsafe = Unsafe.getUnsafe();

        LOGGER.info("unsafe.addressSize() = " + unsafe.addressSize());

        Method toStringString = String.class.getMethod("toString");
        Method toStringObject = Object.class.getMethod("toString");


        long ps = unsafe.getAddress(s, 0);

        for (int i = 0; i < 5; i++) {
            int unsafeInt = unsafe.getInt(s, i * 32);
            LOGGER.info("{}", Integer.toHexString(unsafeInt));
        }

    }
}
