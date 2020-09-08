package com.zrx.fragment.Others;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Description
 * 异常被覆盖
 * <p>
 *
 * @author madokast
 * @version 1.0
 */

public class 异常被覆盖 {
    private final static Logger LOGGER = LoggerFactory.getLogger(异常被覆盖.class);

    public void test(){
        int[] arr = new int[1];

        try {

            try {
                System.out.println("arr = " + arr[3]);
            } finally {
                int a = 1/0;
                System.out.println("a = " + a);
            }


        }catch (Throwable e){
            if(e instanceof ArithmeticException){
                System.out.println("数组越界异常被覆盖了");
            }
        }
    }
}
