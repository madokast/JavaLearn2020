package com.zrx.fragment.Others;

import com.zrx.Invoking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * Description
 * SpringTest
 * <p>
 * Data
 * 2020/7/15-0:16
 *
 * @author zrx
 * @version 1.0
 */

@Invoking(createdTime = "2020-07-15 00:16")
public class SpringTest {
    private final static Logger LOGGER = LoggerFactory.getLogger(SpringTest.class);

    @Autowired
    private ApplicationContext ioc;

    @Invoking(createdTime = "2020-07-15 00:16")
    public void test(){

    }
}
