package com.zrx.algorithm.leetcode.q0160;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description
 * 比较版本号
 * <p>
 * Data
 * 2020/7/4-22:30
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0165比较版本号 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0165比较版本号.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                2,
                "0.1", "1.1",
                "1.0.1", "1",
                "7.5.2.4", "7.5.3",
                "1.01", "1.001",
                "1.0", "1.0.1"
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                -1, 1, -1, 0, 0
        );
    }

    @Code(info = """
            比较两个版本号 version1 和 version2。
            如果 version1 > version2 返回 1，如果 version1 < version2 返回 -1， 除此之外返回 0。

            你可以假设版本字符串非空，并且只包含数字和 . 字符。

             . 字符不代表小数点，而是用于分隔数字序列。

            例如，2.5 不是“两个半”，也不是“差一半到三”，而是第二版中的第五个小版本。

            你可以假设版本号的每一级的默认修订版号为 0。例如，版本号 3.4 的第一级（大版本）和第二级（小版本）修订号分别为 3 和 4。
            其第三级和第四级修订号均为 0。
             

            示例 1:

            输入: version1 = "0.1", version2 = "1.1"
            输出: -1
            示例 2:

            输入: version1 = "1.0.1", version2 = "1"
            输出: 1
            示例 3:

            输入: version1 = "7.5.2.4", version2 = "7.5.3"
            输出: -1
            示例 4：

            输入：version1 = "1.01", version2 = "1.001"
            输出：0
            解释：忽略前导零，“01” 和 “001” 表示相同的数字 “1”。
            示例 5：

            输入：version1 = "1.0", version2 = "1.0.0"
            输出：0
            解释：version1 没有第三级修订号，这意味着它的第三级修订号默认为 “0”。
             

            提示：

            版本字符串由以点 （.） 分隔的数字字符串组成。这个数字字符串可能有前导零。
            版本字符串不以点开始或结束，并且其中不会有两个连续的点。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/compare-version-numbers
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int compareVersion(String version1, String version2) {
        List<Integer> intList1 = Arrays.stream(version1.split("\\.")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> intList2 = Arrays.stream(version2.split("\\.")).map(Integer::parseInt).collect(Collectors.toList());

        int size1 = intList1.size();
        int size2 = intList2.size();

        int i = 0;
        for (; i < size1 && i < size2; i++) {
            Integer n1 = intList1.get(i);
            Integer n2 = intList2.get(i);
            if (n1 > n2) return 1;
            if (n1 < n2) return -1;
        }

        if (size1 == size2) {
            return 0;
        } else if (size1 > size2) {
            while (i < size1) {
                Integer n1 = intList1.get(i);
                if (n1 > 0) return 1;
                i++;
            }

            return 0;
        } else {
            while (i < size2) {
                Integer n2 = intList2.get(i);
                if (n2 > 0) return -1;
                i++;
            }

            return 0;
        }

    }
}
