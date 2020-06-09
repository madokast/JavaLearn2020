package com.zrx.algorithm.leetcode.q0110;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 杨辉三角 II
 * <p>
 * Data
 * 2020/6/9-19:33
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0119杨辉三角II implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0119杨辉三角II.class);

    @Override
    public List<Input> getInputs() {
        return null;
    }

    @Override
    public List<Answer> getAnswers() {
        return null;
    }

    @Code(info = """
            给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。



            在杨辉三角中，每个数是它左上方和右上方的数的和。

            示例:

            输入: 3
            输出: [1,3,3,1]
            进阶：

            你可以优化你的算法到 O(k) 空间复杂度吗？

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/pascals-triangle-ii
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public List<Integer> getRow(int rowIndex) {
        return null;
    }
}
