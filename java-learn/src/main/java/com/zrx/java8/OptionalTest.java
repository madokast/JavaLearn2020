package com.zrx.java8;

import com.zrx.Invoking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Description
 * TODO
 * <p>
 * Data
 * 2020/3/28-22:07
 *
 * @author zrx
 * @version 1.0
 */

@Component
@Invoking(createdTime = "2020-03-28 22:07",info = "OptionalTest")
public class OptionalTest {
    private final static Logger LOGGER = LoggerFactory.getLogger(OptionalTest.class);

    @Invoking(createdTime = "2020-03-28 22:15",info = "OptionalTest")
    public void test01(){
//        Optional.of()
//        Optional.empty()
//        Optional.ofNullable()
        Optional<Object> op = Optional.of(new Object());

//        op.isEmpty()
//        op.isEmpty()

//        op.orElse()
    }
}
