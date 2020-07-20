package com.zrx.algorithm.leetcode.q0190;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 转置文件
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0194转置文件 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0194转置文件.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,true
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                this.fun(true)
        );
    }

    @Code(info = """
            给定一个文件 file.txt，转置它的内容。

            你可以假设每行列数相同，并且每个字段由 ' ' 分隔.

            示例:

            假设 file.txt 文件内容如下：

            name age
            alice 21
            ryan 30
            应当输出：

            name alice ryan
            age 21 30

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/transpose-file
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public String fun(boolean b) {
        return "awk '{ #这个大括号里的代码是 对正文的处理\n" +
                "    # NF表示列数，NR表示已读的行数\n" +
                "    # 注意for中的i从1开始，i前没有类型\n" +
                "    for (i=1; i<=NF; i++){#对每一列\n" +
                "        if(NR==1){       #如果是第一行\n" +
                "            #将第i列的值存入res[i],$i表示第i列的值，i为数组的下标，以列序号为下标，\n" +
                "            #数组不用定义可以直接使用\n" +
                "            res[i]=$i;   \n" +
                "        }\n" +
                "        else{\n" +
                "            #不是第一行时，将该行对应i列的值拼接到res[i]\n" +
                "            res[i]=res[i] \" \" $i\n" +
                "        }\n" +
                "    }\n" +
                "}\n" +
                "# BEGIN{} 文件进行扫描前要执行的操作；END{} 文件扫描结束后要执行的操作。\n" +
                "END{\n" +
                "    #输出数组\n" +
                "\tfor (i=1; i<=NF; i++){\n" +
                "\t\tprint res[i]\n" +
                "\t}\n" +
                "}' file.txt";
    }
}
