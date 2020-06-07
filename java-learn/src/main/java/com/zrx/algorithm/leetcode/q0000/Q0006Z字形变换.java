package com.zrx.algorithm.leetcode.q0000;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.utils.MyLoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * Q0006Z字形变换
 * <p>
 * Data
 * 2020/3/31-20:21
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0006Z字形变换 implements Question {
    private final static Logger LOGGER = MyLoggerFactory.getLogger(Q0006Z字形变换.class);

    @Override
    public List<Input> getInputs() {
        return List.of(
                Input.create("LEETCODEISHIRING",3),
                Input.create("LEETCODEISHIRING",4)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return List.of(
                Answer.create("LCIRETOESIIGEDHN"),
                Answer.create("LDREOEIIECIHNTSG")
        );
    }

    @Code(info = {
            "将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。\n" +
                    "比如输入字符串为 \"LEETCODEISHIRING\" 行数为 3 时，排列如下：\n" +
                    "L   C   I   R\n" +
                    "E T O E S I I G\n" +
                    "E   D   H   N\n" +
                    "之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如：\"LCIRETOESIIGEDHN\"。\n" +
                    "请你实现这个将字符串进行指定行数变换的函数：\n" +
                    "string convert(string s, int numRows);\n" +
                    "示例 1:\n" +
                    "输入: s = \"LEETCODEISHIRING\", numRows = 3\n" +
                    "输出: \"LCIRETOESIIGEDHN\"\n" +
                    "示例 2:\n" +
                    "输入: s = \"LEETCODEISHIRING\", numRows = 4\n" +
                    "输出: \"LDREOEIIECIHNTSG\"\n" +
                    "解释:\n" +
                    "L     D     R\n" +
                    "E   O E   I I\n" +
                    "E C   I H   N\n" +
                    "T     S     G\n",
            "数学方法"
    })
    public String convert(String s, int numRows) {
        if(numRows==1)
            return s;

        StringBuilder[] stringBuilders = new StringBuilder[numRows];
        for (int i = 0; i < stringBuilders.length; i++) {
            stringBuilders[i] = new StringBuilder();
        }


        int currentLine = 0;
        boolean align = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            stringBuilders[currentLine].append(c);

            if(align){
                currentLine++;
            }else {
                currentLine--;
            }

            if(currentLine==numRows){
                currentLine=numRows-2;
                align=false;
            }
            if(currentLine==-1){
                align=true;
                currentLine=1;
            }
        }

        for (StringBuilder stringBuilder : stringBuilders) {
            LOGGER.info("stringBuilder = {}", stringBuilder);
        }

        for (int i = 1; i < stringBuilders.length; i++) {
            stringBuilders[0].append(stringBuilders[i]);
        }

        return stringBuilders[0].toString();
    }
}
