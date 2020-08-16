package com.zrx.fragment.Others;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 学习finallyTest {

    学习finally f = new 学习finally();

    @Test
    void testFun01() {
        int r = f.fun01();
        System.out.println("r = " + r);
    }

    @Test
    void testFun02() {
        int r = f.fun02();
        System.out.println("r = " + r);
    }

    @Test
    void testFun03() {
        Object r = f.fun03();
        System.out.println("r = " + r);
    }
}