package com.zrx.algorithm.leetcode.q0180;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 连续出现的数字
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0180连续出现的数字 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0180连续出现的数字.class);

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
            编写一个 SQL 查询，查找所有至少连续出现三次的数字。

            +----+-----+
            | Id | Num |
            +----+-----+
            | 1  |  1  |
            | 2  |  1  |
            | 3  |  1  |
            | 4  |  2  |
            | 5  |  1  |
            | 6  |  2  |
            | 7  |  2  |
            +----+-----+
            例如，给定上面的 Logs 表， 1 是唯一连续出现至少三次的数字。

            +-----------------+
            | ConsecutiveNums |
            +-----------------+
            | 1               |
            +-----------------+

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/consecutive-numbers
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public String fun(boolean b) {
        return """
                select distinct t1.Num ConsecutiveNums
                from Logs t1,Logs t2, Logs t3
                where t1.Id=t2.Id-1
                and t1.Num=t2.Num
                and t1.Id=t3.Id+1
                and t1.Num=t3.Num;""";
    }
}
