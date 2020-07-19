package com.zrx.algorithm.leetcode.q0180;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 部门工资前三高的所有员工
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0185部门工资前三高的所有员工 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0185部门工资前三高的所有员工.class);

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
            Employee 表包含所有员工信息，每个员工有其对应的工号 Id，姓名 Name，工资 Salary 和部门编号 DepartmentId 。

            +----+-------+--------+--------------+
            | Id | Name  | Salary | DepartmentId |
            +----+-------+--------+--------------+
            | 1  | Joe   | 85000  | 1            |
            | 2  | Henry | 80000  | 2            |
            | 3  | Sam   | 60000  | 2            |
            | 4  | Max   | 90000  | 1            |
            | 5  | Janet | 69000  | 1            |
            | 6  | Randy | 85000  | 1            |
            | 7  | Will  | 70000  | 1            |
            +----+-------+--------+--------------+
            Department 表包含公司所有部门的信息。

            +----+----------+
            | Id | Name     |
            +----+----------+
            | 1  | IT       |
            | 2  | Sales    |
            +----+----------+
            编写一个 SQL 查询，找出每个部门获得前三高工资的所有员工。例如，根据上述给定的表，查询结果应返回：

            +------------+----------+--------+
            | Department | Employee | Salary |
            +------------+----------+--------+
            | IT         | Max      | 90000  |
            | IT         | Randy    | 85000  |
            | IT         | Joe      | 85000  |
            | IT         | Will     | 70000  |
            | Sales      | Henry    | 80000  |
            | Sales      | Sam      | 60000  |
            +------------+----------+--------+
            解释：

            IT 部门中，Max 获得了最高的工资，Randy 和 Joe 都拿到了第二高的工资，Will 的工资排第三。销售部门（Sales）只有两名员工，Henry 的工资最高，Sam 的工资排第二。
            """)
    public String fun(boolean b) {
        return "select d.`Name` as Department, e.`Name` as Employee, e.Salary\n" +
                "from Employee e join Department d on e.DepartmentId = d.Id \n" +
                "where e.Salary >= (\n" +
                "    select min(s) from (\n" +
                "        select distinct e2.Salary as s from Employee e2 \n" +
                "        where e2.DepartmentId = e.DepartmentId\n" +
                "        order by e2.Salary desc\n" +
                "        limit 3\n" +
                "    )as m\n" +
                ");";
    }
}
