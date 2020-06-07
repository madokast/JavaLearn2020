package com.zrx.algorithm.leetcode.q0080;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Description
 * 格雷编码
 * <p>
 * Data
 * 2020/6/2-11:58
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0089格雷编码 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0089格雷编码.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                2
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                List.of(0, 1, 3, 2) //  or 0231
        );
    }

    @Code(info = """
            格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。

            给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。即使有多个不同答案，你也只需要返回其中一种。

            格雷编码序列必须以 0 开头。

             

            示例 1:

            输入: 2
            输出: [0,1,3,2]
            解释:
            00 - 0
            01 - 1
            11 - 3
            10 - 2

            对于给定的 n，其格雷编码序列并不唯一。
            例如，[0,2,3,1] 也是一个有效的格雷编码序列。

            00 - 0
            10 - 2
            11 - 3
            01 - 1
            示例 2:

            输入: 0
            输出: [0]
            解释: 我们定义格雷编码序列必须以 0 开头。
                 给定编码总位数为 n 的格雷编码序列，其长度为 2n。当 n = 0 时，长度为 20 = 1。
                 因此，当 n = 0 时，其格雷编码序列为 [0]。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/gray-code
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public List<Integer> grayCode(int n) {

        if (n == 0)
            return List.of(0);

        List<Integer> list = grayCode(n - 1);
        List<Integer> ans = new ArrayList<>(list);
        for (int i = list.size() - 1; i >= 0; i--) {
            Integer integer = list.get(i);
            ans.add(integer + (1 << (n - 1)));
        }

        return ans;
    }
}
