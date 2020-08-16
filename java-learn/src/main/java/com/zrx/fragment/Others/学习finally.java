package com.zrx.fragment.Others;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Description
 * 学习finally
 * <p>
 *
 * @author madokast
 * @version 1.0
 */

public class 学习finally {
    private final static Logger LOGGER = LoggerFactory.getLogger(学习finally.class);

    public int fun01(){
        try {return 3;}
        finally { return 4; }
    }

    public int fun02(){
        int ret = 5;
        try {return ret;}
        finally { ret+=5; }
    }

    public List<Integer> fun03(){
        List<Integer> list = new ArrayList<>();
        list.add(7);
        try {return list;}
        finally { list.add(8); }
    }
}
