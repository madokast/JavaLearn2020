package com.zrx.algorithm.leetcode.q0180;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 部门工资最高的员工
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0184部门工资最高的员工 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0184部门工资最高的员工.class);

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
            Employee 表包含所有员工信息，每个员工有其对应的 Id, salary 和 department Id。

            +----+-------+--------+--------------+
            | Id | Name  | Salary | DepartmentId |
            +----+-------+--------+--------------+
            | 1  | Joe   | 70000  | 1            |
            | 2  | Henry | 80000  | 2            |
            | 3  | Sam   | 60000  | 2            |
            | 4  | Max   | 90000  | 1            |
            +----+-------+--------+--------------+
            Department 表包含公司所有部门的信息。

            +----+----------+
            | Id | Name     |
            +----+----------+
            | 1  | IT       |
            | 2  | Sales    |
            +----+----------+
            编写一个 SQL 查询，找出每个部门工资最高的员工。例如，根据上述给定的表格，Max 在 IT 部门有最高工资，Henry 在 Sales 部门有最高工资。

            +------------+----------+--------+
            | Department | Employee | Salary |
            +------------+----------+--------+
            | IT         | Max      | 90000  |
            | Sales      | Henry    | 80000  |
            +------------+----------+--------+
            """)
    public String fun(boolean b) {
        return null;
    }
}
