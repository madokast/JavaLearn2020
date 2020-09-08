package com.madokast.learnspringframework.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Description
 * <p>
 *
 * @author madokast
 * @version 1.0
 */

public class B {
    private A a;

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "B{" +
                "a=" + a +
                '}';
    }
}
