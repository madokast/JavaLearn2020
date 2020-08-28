package com.zrx.algorithm.专题;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class 中缀表达式求值Test {

    private final static Logger LOGGER = LoggerFactory.getLogger(中缀表达式求值Test.class);

    List<String> questions = List.of(
            "1",
            "123",
            "1+1",
            "11+1",
            "123+321",
            "12-21",
            "12*21",
            "12/21",
            "12+21+21",
            "12*12/12",
            "12+12*12",
            "(1+1)",
            "(21+12)",
            "(1+1)*2",
            "(12+21)*10",
            "12+(21-21)",
            "12*(1-1)",
            "(12-12)*(123-123)",
            "(12-21*(12-11))",
            "((4/2)+3)"
    );

    中缀表达式求值 obj = new 中缀表达式求值();

    @Test
    void parse() {
        questions.forEach(s -> {
            List<中缀表达式求值.Token> parse = obj.parse(s);
            LOGGER.info("parse = {}", parse);
            String back = parse.stream().map(Objects::toString).collect(Collectors.joining());
            Assert.assertEquals(back, s);
        });
    }

    @Test
    void cal() {
        questions.forEach(s -> {
            if(s.equals("(1+1)")){
                int a = 1+1;
            }

            int cal = obj.cal(s);
            LOGGER.info("{} = {}", s, cal);
        });
    }
}