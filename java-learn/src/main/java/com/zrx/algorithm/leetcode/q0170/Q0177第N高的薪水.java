package com.zrx.algorithm.leetcode.q0170;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 第N高的薪水
 * <p>
 * Data
 * 2020/7/6-9:22
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0177第N高的薪水 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0177第N高的薪水.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(1,true);
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(" select distinct Salary from Employee order by Salary desc limit N,1");
    }

    @Code(info = """
            编写一个 SQL 查询，获取 Employee 表中第 n 高的薪水（Salary）。

            +----+--------+
            | Id | Salary |
            +----+--------+
            | 1  | 100    |
            | 2  | 200    |
            | 3  | 300    |
            +----+--------+
            例如上述 Employee 表，n = 2 时，应返回第二高的薪水 200。如果不存在第 n 高的薪水，那么查询应返回 null。

            +------------------------+
            | getNthHighestSalary(2) |
            +------------------------+
            | 200                    |
            +------------------------+

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/nth-highest-salary
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public String fun(boolean b) {
        return " select distinct Salary from Employee order by Salary desc limit N,1";
    }
}
