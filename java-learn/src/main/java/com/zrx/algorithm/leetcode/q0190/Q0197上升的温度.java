package com.zrx.algorithm.leetcode.q0190;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 上升的温度
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0197上升的温度 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0197上升的温度.class);

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
            给定一个 Weather 表，编写一个 SQL 查询，来查找与之前（昨天的）日期相比温度更高的所有日期的 Id。

            +---------+------------------+------------------+
            | Id(INT) | RecordDate(DATE) | Temperature(INT) |
            +---------+------------------+------------------+
            |       1 |       2015-01-01 |               10 |
            |       2 |       2015-01-02 |               25 |
            |       3 |       2015-01-03 |               20 |
            |       4 |       2015-01-04 |               30 |
            +---------+------------------+------------------+
            例如，根据上述给定的 Weather 表格，返回如下 Id:

            +----+
            | Id |
            +----+
            |  2 |
            |  4 |
            +----+

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/rising-temperature
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public String fun(boolean b) {
        return "select w1.Id from Weather w1, Weather w2 where w1.RecordDate=date_add(w2.RecordDate,interval 1 day) and w1.Temperature>w2.Temperature;";
    }
}
