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

public class A {
    private B b;

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "A{" +
                "b=" + b +
                '}';
    }
}
