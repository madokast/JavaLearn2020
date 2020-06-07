package com.zrx.algorithm.leetcode.q0030;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.utils.ArrayFactory;
import com.zrx.utils.MyLoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Description
 * Q0030串联所有单词的子串
 * <p>
 * Data
 * 2020/5/11-15:36
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0030串联所有单词的子串 implements Question {
    private final static Logger LOGGER = MyLoggerFactory.getLogger(Q0030串联所有单词的子串.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                2,
                "barfoothefoobarman", ArrayFactory.create("foo", "bar"),
                "wordgoodgoodgoodbestword", ArrayFactory.create("word", "good", "best", "word")
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                List.of(0, 9),
                List.of()
        );
    }

    @Code(info = """
            给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。

            注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。

            示例 1：

            输入：
              s = "barfoothefoobarman",
              words = ["foo","bar"]
            输出：[0,9]
            解释：
            从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
            输出的顺序不重要, [9,0] 也是有效答案。
            示例 2：

            输入：
              s = "wordgoodgoodgoodbestword",
              words = ["word","good","best","word"]
            输出：[]
            """)
    public List<Integer> findSubstring(String s, String[] words) {
        if(s==null||s.length()==0||words==null||words.length==0)
            return List.of();

        int sLength = s.length(); // s 长度

        int wordsLength = words.length; // word个数
        int wordLength = words[0].length(); // word 长度

        int length = wordLength * wordsLength; // 字段串长度

        if(length>sLength)
            return List.of();

        int hash = 0; //  hash窗口
        for (int i = 0; i < length; i++) {
            hash += s.charAt(i);
        }

        int wordsHash = 0; // 字段串的hash
        Map<Integer, List<String>> map = new HashMap<>(); // hash - words
        Map<String, Integer> wordMap = new HashMap<>(); // word - 出现次数
        for (String word : words) {
            int wordHash = 0;
            for (int i = 0; i < wordLength; i++) {
                wordHash += word.charAt(i);
            }
            List<String> get = map.getOrDefault(wordHash, new ArrayList<>());
            get.add(word);
            map.put(wordHash, get);

            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);

            wordsHash += wordHash;
        }

        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < sLength - length + 1; i++) {
            if (hash == wordsHash) {
                LOGGER.info("hash == wordsHash at {}", i);

                Map<String, Integer> wordMapCopy = new HashMap<>(wordMap);
                LOGGER.info("wordMapCopy = {}", wordMapCopy);


                for (int j = i; j < i + length; j += wordLength) {
                    int h = hash(s, j, j + wordLength);
                    if (map.containsKey(h)) {
                        String substring = s.substring(j, j + wordLength);
                        if (wordMapCopy.containsKey(substring)) {
                            Integer times = wordMapCopy.get(substring);
                            if (times == 0) {
                                break;
                            } else {
                                wordMapCopy.put(substring, times - 1);
                            }
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }

                boolean ok = true;
                for (Integer value : wordMapCopy.values()) {
                    if (value != 0) {
                        ok = false;
                        break;
                    }
                }

                if (ok) {
                    answer.add(i);
                }
            }

            if(i + length>=sLength)
                break;

            hash -= s.charAt(i);
            hash += s.charAt(i + length);
        }


        return answer;
    }

    private int hash(String s, int startIncluding, int endExcluding) {
        int hash = 0;
        for (int i = startIncluding; i < endExcluding; i++) {
            hash += s.charAt(i);
        }

        return hash;
    }
}
