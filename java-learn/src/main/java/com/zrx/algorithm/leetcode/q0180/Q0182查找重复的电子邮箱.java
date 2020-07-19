package com.zrx.algorithm.leetcode.q0180;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 查找重复的电子邮箱
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0182查找重复的电子邮箱 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0182查找重复的电子邮箱.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(1, true);
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                fun(true)
        );
    }

    @Code(info = """
            SQL架构
            编写一个 SQL 查询，查找 Person 表中所有重复的电子邮箱。

            示例：

            +----+---------+
            | Id | Email   |
            +----+---------+
            | 1  | a@b.com |
            | 2  | c@d.com |
            | 3  | a@b.com |
            +----+---------+
            根据以上输入，你的查询应返回以下结果：

            +---------+
            | Email   |
            +---------+
            | a@b.com |
            +---------+
            说明：所有电子邮箱都是小写字母。
            """)
    public String fun(boolean b) {
        return "select distinct a.Email from Person a, Person b where a.Id<>b.Id and a.Email = b.Email;";
    }
}
