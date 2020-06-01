package com.zrx.algorithm.leetcode.q0070;

import com.zrx.algorithm.Question;
import com.zrx.algorithm.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Stack;

/**
 * Description
 * 简化路径
 * <p>
 * Data
 * 2020/5/31-13:39
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0071简化路径 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0071简化路径.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                "/home/",
                "/../",
                "/home//foo/",
                "/a/./b/../../c/",
                "/a/../../b/../c//.//",
                "/a//b////c/d//././/.."
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                "/home",
                "/",
                "/home/foo",
                "/c",
                "/c",
                "/a/b/c"
        );
    }

    @Code(info = """
            以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。

            在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径

            请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。

             

            示例 1：

            输入："/home/"
            输出："/home"
            解释：注意，最后一个目录名后面没有斜杠。
            示例 2：

            输入："/../"
            输出："/"
            解释：从根目录向上一级是不可行的，因为根是你可以到达的最高级。
            示例 3：

            输入："/home//foo/"
            输出："/home/foo"
            解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
            示例 4：

            输入："/a/./b/../../c/"
            输出："/c"
            示例 5：

            输入："/a/../../b/../c//.//"
            输出："/c"
            示例 6：

            输入："/a//b////c/d//././/.."
            输出："/a/b/c"

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/simplify-path
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public String simplifyPath(String path) {
        Stack<String> paths = new Stack<>();

        String[] split = path.split("/+");
        LOGGER.info("split = {}", ToString.arrayToFormatString(split));

        for (String s : split) {
            switch (s) {
                case ".": case "":
                    break;
                case "..":
                    if (!paths.empty()) paths.pop();
                    break;
                default:
                    paths.push(s);
            }
        }

        LOGGER.info("paths = {}", paths);

        StringBuilder sb = new StringBuilder();
        if (paths.empty()) {
            sb.append("/");
        } else {
            paths.forEach(p -> sb.append("/").append(p));
        }
        return sb.toString();
    }
}
