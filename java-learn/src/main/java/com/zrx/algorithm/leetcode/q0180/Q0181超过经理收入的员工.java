package com.zrx.algorithm.leetcode.q0180;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 超过经理收入的员工
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0181超过经理收入的员工 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0181超过经理收入的员工.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(1, true);
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                this.fun(true)
        );
    }

    @Code(info = """
            SQL架构
            Employee 表包含所有员工，他们的经理也属于员工。每个员工都有一个 Id，此外还有一列对应员工的经理的 Id。

            +----+-------+--------+-----------+
            | Id | Name  | Salary | ManagerId |
            +----+-------+--------+-----------+
            | 1  | Joe   | 70000  | 3         |
            | 2  | Henry | 80000  | 4         |
            | 3  | Sam   | 60000  | NULL      |
            | 4  | Max   | 90000  | NULL      |
            +----+-------+--------+-----------+
            给定 Employee 表，编写一个 SQL 查询，该查询可以获取收入超过他们经理的员工的姓名。在上面的表格中，Joe 是唯一一个收入超过他的经理的员工。

            +----------+
            | Employee |
            +----------+
            | Joe      |
            +----------+
            """)
    public String fun(boolean b) {

        return """
                select e.`Name` as Employee from Employee e where e.ManagerId is not null and exists (
                    select 1 from Employee t where e.ManagerId = t.Id and e.Salary > t.Salary
                )
                """;
    }
}
