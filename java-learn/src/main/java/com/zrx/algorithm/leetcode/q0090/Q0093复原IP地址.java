package com.zrx.algorithm.leetcode.q0090;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

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

@Component
public class Q0093复原IP地址 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0093复原IP地址.class);

    @Override
    public List<Input> getInputs() {
        return null;
    }

    @Override
    public List<Answer> getAnswers() {
        return null;
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
        return null;
    }
}
