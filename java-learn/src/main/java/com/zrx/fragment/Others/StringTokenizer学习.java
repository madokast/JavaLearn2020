package com.zrx.fragment.Others;

import com.zrx.Invoking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.CharArrayReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.StringTokenizer;

/**
 * Description
 * StringTokenizer
 * <p>
 *
 * @author madokast
 * @version 1.0
 */

@Invoking(createdTime = "2020-08-31 11:02")
public class StringTokenizer学习 {
    private final static Logger LOGGER = LoggerFactory.getLogger(StringTokenizer学习.class);

    public void test01() {
//        StringTokenizer
//        StreamTokenizer

        StringTokenizer stringTokenizer = new StringTokenizer("This is an apple", " ", false);
        while (stringTokenizer.hasMoreTokens()) {
            String token = stringTokenizer.nextToken();
            LOGGER.info("token = {}", token);
        }
    }

    public void test2() throws IOException {
        String exp = "int a = 5*(1+2); //end";
        StreamTokenizer streamTokenizer = new StreamTokenizer(new CharArrayReader(exp.toCharArray()));

        int next;
        while ((next = streamTokenizer.nextToken()) != StreamTokenizer.TT_EOF) {
            LOGGER.info("next = {}", next);
            String sval = streamTokenizer.sval;
            double nval = streamTokenizer.nval;
            LOGGER.info("sval = {}", sval);
            LOGGER.info("nval = {}", nval);
        }
    }
}
