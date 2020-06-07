package com.zrx.algorithm.leetcode.q0090;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.RepeatableSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Description
 * 复原IP地址
 * <p>
 * Data
 * 2020/6/6-16:29
 *
 * @author zrx
 * @version 1.0
 */

@SuppressWarnings("unchecked")
@Component
public class Q0093复原IP地址 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0093复原IP地址.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                "25525511135",
                "0000",
                "010010"
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                RepeatableSet.of(
                        "255.255.11.135",
                        "255.255.111.35"
                ),
                RepeatableSet.of(
                        "0.0.0.0"
                ),
                RepeatableSet.of(
                        "0.10.0.10",
                        "0.100.1.0"
                )
        );
    }

    @Code(info = """
            给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。

            有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。

            示例:

            输入: "25525511135"
            输出: ["255.255.11.135", "255.255.111.35"]

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/restore-ip-addresses
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();

        back(new LinkedList<>(), s, ans);

        return ans;
    }

    private void back(Deque<Integer> stack, String s, List<String> ans) {
        int length = s.length();

        int size = stack.size();
        if (size == 3) {
            int last = stack.getLast();

            if ((length - last) <= 3 && Integer.parseInt(s.substring(last)) <= 255) {
                if (length - last > 1 && s.charAt(last) == '0') return;

                ans.add(make((List<Integer>) stack, s));
            }

        } else if (size < 3) {
            Integer last = stack.isEmpty() ? 0 : stack.getLast();


            int pre = 256;

            for (int i = last + 1; i < length; i++) {
                if (i - last > 1 && s.charAt(last) == '0') continue;
                int parseInt = Integer.parseInt(s.substring(last, i));
                if (parseInt <= 255) {
                    if (pre == parseInt) continue;

                    pre = parseInt;

                    stack.addLast(i);
                    back(stack, s, ans);
                    stack.removeLast();
                } else break;
            }

        }
    }

    private String make(List<Integer> stack, String s) {
        Integer i0 = stack.get(0);
        Integer i1 = stack.get(1);
        Integer i2 = stack.get(2);

        return s.substring(0, i0) +
                '.' +
                s.substring(i0, i1) +
                '.' +
                s.substring(i1, i2) +
                '.' +
                s.substring(i2);
    }
}
