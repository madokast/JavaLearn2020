package com.zrx.fragment.Others;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Description
 * 泛型深入
 * <p>
 *
 * @author madokast
 * @version 1.0
 */

public class 泛型深入 {
    private final static Logger LOGGER = LoggerFactory.getLogger(泛型深入.class);

    public void object泛型(){
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);

        // 出错
        // List<Object> objectList = integerList;


        List<?> someList = integerList;

        // 出错
        // someList.add(1);
    }

    public void extend(){

        List<Object> objectList = new ArrayList<>();

        List<? super Integer> list = objectList; // 可以

        list.add(1);

        Object object = list.get(0);

    }
}
