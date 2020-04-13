package com.zrx.algorithm.leetcode.q0010;

import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.RepeatableSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Description
 * 电话号码的字母组合
 * <p>
 * Data
 * 2020/4/5-17:31
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0017电话号码的字母组合 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0017电话号码的字母组合.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                "23"
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                //尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序
                RepeatableSet.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf")
        );
    }

    @Code(info = {
            "给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。\n" +
                    "给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。\n" +
                    "示例:\n" +
                    "输入：\"23\"\n" +
                    "输出：[\"ad\", \"ae\", \"af\", \"bd\", \"be\", \"bf\", \"cd\", \"ce\", \"cf\"].\n" +
                    "说明:\n" +
                    "尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。\n",
            "2 abc",
            "3 def",
            "4 ghi",
            "5 jkl",
            "6 mno",
            "7 pqrs",
            "8 tuv",
            "9 wxyz"
    })
    public List<String> letterCombinations(String digits) {
        if(digits==null||digits.length()==0)
            return List.of();

        List<List<Character>> list = new LinkedList<>();

        int n = digits.charAt(0) - '0';
        char[] chars = map[n];
        for (char aChar : chars) {
            List<Character> sb  = new ArrayList<>(10);
            sb.add(aChar);
            list.add(sb);
        }
        int size;

        for (int i = 1; i < digits.length(); i++) {
            n = digits.charAt(i) - '0';
            chars = map[n];
            size = list.size();
            for (int j = 0; j < size; j++) {
                List<Character> remove = list.remove(0);

                for (int k = 0; k < chars.length; k++) {
                    List<Character> copy = new ArrayList<>(remove);
                    copy.add(chars[k]);
                    list.add(copy);
                }
            }
        }

        return list.stream().map(characters -> {
            StringBuilder stringBuilder = new StringBuilder(10);
            characters.forEach(stringBuilder::append);
            return stringBuilder.toString();
        }).collect(Collectors.toList());
    }

    public static final char[][] map = new char[][]{
            {},//0
            {},//1
            {'a', 'b', 'c'},//2
            {'d', 'e', 'f'},//3
            {'g', 'h', 'i'},//4
            {'j', 'k', 'l'},//5
            {'m', 'n', 'o'},//6
            {'p', 'q', 'r', 's'},//7
            {'t', 'u', 'v'},//8
            {'w', 'x', 'y', 'z'},//9
    };

}
