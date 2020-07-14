package com.zrx.algorithm.leetcode.q0190;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Description
 * TODO
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

//@Component
public class Q019 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q019.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(1, true);
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(

        );
    }

    @Code(info = """
            """)
    public String fun(boolean b) {
        return null;
    }
}
