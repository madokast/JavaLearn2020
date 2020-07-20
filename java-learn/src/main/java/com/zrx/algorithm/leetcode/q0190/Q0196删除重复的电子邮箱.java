package com.zrx.algorithm.leetcode.q0190;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 删除重复的电子邮箱
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0196删除重复的电子邮箱 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0196删除重复的电子邮箱.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1, true
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                this.fun(true)
        );
    }

    @Code(info = """
            编写一个 SQL 查询，来删除 Person 表中所有重复的电子邮箱，重复的邮箱里只保留 Id 最小 的那个。

            +----+------------------+
            | Id | Email            |
            +----+------------------+
            | 1  | john@example.com |
            | 2  | bob@example.com  |
            | 3  | john@example.com |
            +----+------------------+
            Id 是这个表的主键。
            例如，在运行你的查询语句之后，上面的 Person 表应返回以下几行:

            +----+------------------+
            | Id | Email            |
            +----+------------------+
            | 1  | john@example.com |
            | 2  | bob@example.com  |
            +----+------------------+
             

            提示：

            执行 SQL 之后，输出是整个 Person 表。
            使用 delete 语句。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/delete-duplicate-emails
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public String fun(boolean b) {
        return "delete p1 from Person p1, Person p2 where p1.Email=p2.Email and p1.Id>p2.Id;";
    }
}
