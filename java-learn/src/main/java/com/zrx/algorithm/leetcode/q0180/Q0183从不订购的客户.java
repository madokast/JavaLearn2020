package com.zrx.algorithm.leetcode.q0180;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 从不订购的客户
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0183从不订购的客户 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0183从不订购的客户.class);

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
            某网站包含两个表，Customers 表和 Orders 表。编写一个 SQL 查询，找出所有从不订购任何东西的客户。

            Customers 表：

            +----+-------+
            | Id | Name  |
            +----+-------+
            | 1  | Joe   |
            | 2  | Henry |
            | 3  | Sam   |
            | 4  | Max   |
            +----+-------+
            Orders 表：

            +----+------------+
            | Id | CustomerId |
            +----+------------+
            | 1  | 3          |
            | 2  | 1          |
            +----+------------+
            例如给定上述表格，你的查询应返回：

            +-----------+
            | Customers |
            +-----------+
            | Henry     |
            | Max       |
            +-----------+
            """)
    public String fun(boolean b) {
        return "select `Name` as `Customers` from Customers left join Orders \n" +
                "on Customers.Id = Orders.CustomerId\n" +
                "where CustomerId is null;";
    }
}
