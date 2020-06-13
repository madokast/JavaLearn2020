package com.zrx.algorithm.leetcode.q0110;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Description
 * 杨辉三角
 * <p>
 * Data
 * 2020/6/9-19:33
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0118杨辉三角 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0118杨辉三角.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                4
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                List.of(
                        List.of(1),
                        List.of(1, 1),
                        List.of(1, 2, 1),
                        List.of(1, 3, 3, 1)
                )
        );
    }

    @Code(info = """
            给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。



            在杨辉三角中，每个数是它左上方和右上方的数的和。

            示例:

            输入: 5
            输出:
            [
                 [1],
                [1,1],
               [1,2,1],
              [1,3,3,1],
             [1,4,6,4,1]
            ]

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/pascals-triangle
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public List<List<Integer>> generate(int numRows) {
        if(numRows<=0) return Collections.emptyList();

        List<List<Integer>> ans = new ArrayList<>(numRows);
        ans.add(List.of(1));

        for (int i = 1; i < numRows; i++) {
            List<Integer> pre = ans.get(i - 1);
            List<Integer> cur = new ArrayList<>(i + 1);
            cur.add(1);
            for (int j = 1; j < pre.size(); j++) {
                Integer c = pre.get(j);
                Integer nc = pre.get(j - 1);
                cur.add(c+nc);
            }
            cur.add(1);

            ans.add(cur);
        }

        return ans;
    }
}
