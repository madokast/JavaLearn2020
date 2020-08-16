package com.zrx.algorithm.leetcode.q0270;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

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
public class Q027 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q027.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(

        );
    }

    @Code(info = """
            """)
    public boolean fun(boolean b) {
        return b;
    }
}
