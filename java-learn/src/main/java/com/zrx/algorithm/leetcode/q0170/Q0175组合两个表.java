package com.zrx.algorithm.leetcode.q0170;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 组合两个表
 * <p>
 * Data
 * 2020/7/6-9:22
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0175组合两个表 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0175组合两个表.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(1, true);
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create("select FirstName, LastName, City, State from Person p left join Address a on p.PersonId = a.PersonId;");
    }

    @Code(info = """
            表1: Person

            +-------------+---------+
            | 列名         | 类型     |
            +-------------+---------+
            | PersonId    | int     |
            | FirstName   | varchar |
            | LastName    | varchar |
            +-------------+---------+
            PersonId 是上表主键
            表2: Address

            +-------------+---------+
            | 列名         | 类型    |
            +-------------+---------+
            | AddressId   | int     |
            | PersonId    | int     |
            | City        | varchar |
            | State       | varchar |
            +-------------+---------+
            AddressId 是上表主键
             

            编写一个 SQL 查询，满足条件：无论 person 是否有地址信息，都需要基于上述两表提供 person 的以下信息：

             

            FirstName, LastName, City, State

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/combine-two-tables
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public String fun(boolean b) {
        return "select FirstName, LastName, City, State from Person p left join Address a on p.PersonId = a.PersonId;";
    }
}
