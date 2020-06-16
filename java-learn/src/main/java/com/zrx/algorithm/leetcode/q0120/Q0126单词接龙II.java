package com.zrx.algorithm.leetcode.q0120;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.RepeatableSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Description
 * 单词接龙 II
 * <p>
 * Data
 * 2020/6/13-19:14
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0126单词接龙II implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0126单词接龙II.class);

    @Override
    public List<Input> getInputs() {

        //"qa"
        //"sq"
        //["si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"]

        return InputFactory.create(
                3,
                "hit", "cog", List.of("hot", "dot", "dog", "lot", "log", "cog"),
                "hit", "cog", List.of("hot", "dot", "dog", "lot", "log")
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                RepeatableSet.of(
                        List.of("hit", "hot", "dot", "dog", "cog"),
                        List.of("hit", "hot", "lot", "log", "cog")
                ),
                List.of()
        );
    }

    @Code(info = """
            给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：

            每次转换只能改变一个字母。
            转换后得到的单词必须是字典中的单词。
            说明:

            如果不存在这样的转换序列，返回一个空列表。
            所有单词具有相同的长度。
            所有单词只由小写字母组成。
            字典中不存在重复的单词。
            你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
            示例 1:

            输入:
            beginWord = "hit",
            endWord = "cog",
            wordList = ["hot","dot","dog","lot","log","cog"]

            输出:
            [
              ["hit","hot","dot","dog","cog"],
              ["hit","hot","lot","log","cog"]
            ]
            示例 2:

            输入:
            beginWord = "hit"
            endWord = "cog"
            wordList = ["hot","dot","dog","lot","log"]

            输出: []

            解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/word-ladder-ii
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public List<List<String>> findLadders方法超时(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return Collections.emptyList();

        List<List<String>> ans = new ArrayList<>();
        Deque<String> trace = new LinkedList<>();
        trace.push(beginWord);

        back(trace, endWord, wordList, ans);

        return ans;
    }

    private void back(Deque<String> trace, String endWord, List<String> wordList, List<List<String>> ans) {
        int size = wordList.size();
        int min = ans.stream().mapToInt(List::size).min().orElse(Integer.MAX_VALUE);
        int tSize = trace.size();
        if (tSize > size || tSize > min || tSize > Math.pow(2, endWord.length())) return;
        if (trace.peek().equals(endWord)) {
            if (tSize <= min) {
                if (tSize < min) ans.clear();
                ArrayList<String> t = new ArrayList<>(trace);
                Collections.reverse(t);
                ans.add(t);
            }
        } else {
            for (String s : wordList) {
                if (!trace.contains(s) && canConvert(s, trace.peek())) {
                    trace.push(s);
                    back(trace, endWord, wordList, ans);
                    trace.pop();
                }
            }
        }
    }

    private boolean canConvert(String w1, String w2) {
        int l1 = w1.length();
        int l2 = w2.length();

        if (l1 != l2) return false;

        int diff = 0;

        for (int i = 0; i < l1; i++) {
            char c1 = w1.charAt(i);
            char c2 = w2.charAt(i);

            if (c1 != c2) {
                diff++;
                if (diff > 1) return false;
            }
        }

        return diff == 1;
    }
}
