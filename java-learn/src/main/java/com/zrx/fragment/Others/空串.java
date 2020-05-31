package com.zrx.fragment.Others;

import com.zrx.Invoking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Base64;

/**
 * Description
 * 空串
 * <p>
 * Data
 * 2020/5/31-12:10
 *
 * @author zrx
 * @version 1.0
 */

@Invoking(createdTime = "2020-05-31 12:10")
public class 空串 {
    private final static Logger LOGGER = LoggerFactory.getLogger(空串.class);

    @Invoking(createdTime = "2020-05-31 12:11")
    public void 空串相加(){
        String a = " ";
        LOGGER.info("a = |{}|", a);

        a = a+ " ";

        LOGGER.info("a = |{}|", a);
    }

    @Invoking(createdTime = "2020-05-31 12:12")
    public void 空串append(){
        StringBuilder sb = new StringBuilder("ab");
        LOGGER.info("sb = |{}|", sb);

        for (int i = 0; i < 3; i++) {
            sb.append(" ");
            LOGGER.info("sb = |{}|", sb);
        }
    }

    private static final String[] blacks = new String[30];
    static {
        blacks[0] = "";
        for (int i = 1; i < blacks.length; i++) {
            blacks[i] = blacks[i-1]+" ";
        }
    }

    @Invoking(createdTime = "2020-05-31 12:14")
    public void 空串数组(){
        for (String black : blacks) {
            LOGGER.info("black = |{}|", black);
        }
    }
}
