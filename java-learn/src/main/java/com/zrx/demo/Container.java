package com.zrx.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Description
 * 带有泛型的容器
 * <p>
 * Data
 * 2020/3/17-23:36
 *
 * @author zrx
 * @version 1.0
 */

public class Container {
    private final static Logger LOGGER = LoggerFactory.getLogger(Container.class);

    public static class UniContainer<E>{
        private E e;

        public static <E> UniContainer<E> create(E e){
            return new UniContainer<>(e);
        }

        public UniContainer(E e) {
            this.e = e;
        }

        public E getE() {
            return e;
        }

        public void setE(E e) {
            this.e = e;
        }

        @Override
        public String toString() {
            return "UniContainer{" +
                    "e=" + e +
                    '}';
        }
    }

    public static class BiContainer<E1,E2>{
        private E1 e1;
        private E2 e2;

        public static <E1,E2> BiContainer<E1,E2> create(E1 e1,E2 e2){
            return new BiContainer<>(e1,e2);
        }

        public BiContainer(E1 e1, E2 e2) {
            this.e1 = e1;
            this.e2 = e2;
        }

        public E1 getE1() {
            return e1;
        }

        public void setE1(E1 e1) {
            this.e1 = e1;
        }

        public E2 getE2() {
            return e2;
        }

        public void setE2(E2 e2) {
            this.e2 = e2;
        }

        @Override
        public String toString() {
            return "BiContainer{" +
                    "e1=" + e1 +
                    ", e2=" + e2 +
                    '}';
        }
    }
}
