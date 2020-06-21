package com.zrx.algorithm.leetcode.q0120;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Description
 * 单词接龙
 * <p>
 * Data
 * 2020/6/13-19:14
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0127单词接龙 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0127单词接龙.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                3,
                "hit", "cog", List.of("hot", "dot", "dog", "lot", "log", "cog"),
                "hit", "cog", List.of("hot", "dot", "dog", "lot", "log"),
                "a", "b", List.of("b")
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(5, 0, 2);
    }

    @Code(info = """
            给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：

            每次转换只能改变一个字母。
            转换过程中的中间单词必须是字典中的单词。
            说明:

            如果不存在这样的转换序列，返回 0。
            所有单词具有相同的长度。
            所有单词只由小写字母组成。
            字典中不存在重复的单词。
            你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
            示例 1:

            输入:
            beginWord = "hit",
            endWord = "cog",
            wordList = ["hot","dot","dog","lot","log","cog"]

            输出: 5

            解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
                 返回它的长度 5。
            示例 2:

            输入:
            beginWord = "hit"
            endWord = "cog"
            wordList = ["hot","dot","dog","lot","log"]

            输出: 0

            解释: endWord "cog" 不在字典中，所以无法进行转换。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/word-ladder
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        // 制作数据结构

        Map<String, Integer> indexString = new HashMap<>(wordList.size() + 1);
        List<String> words = new ArrayList<>(wordList.size() + 1);
        Set<String> wordSet = new HashSet<>(wordList.size() + 1);

        wordSet.add(beginWord);
        words.add(beginWord);
        indexString.put(beginWord, 0);

        int i = 1;
        for (String word : wordList) {
            if (!wordSet.contains(word)) {
                wordSet.add(word);
                words.add(word);
                indexString.put(word, i);
                i++;
            }
        }

        // 制作临接矩阵
        int size = wordSet.size();
        boolean[][] tab = new boolean[size][size];
        for (i = 0; i < words.size(); i++) {
            String word = words.get(i);
            for (int j = 0; j < wordList.size(); j++) {
                String w2 = words.get(j);
                if (canConvert(word, w2)) {
                    tab[i][j] = tab[j][i] = true;
                }
            }
        }

        // 每个单词的 cost
//        int[] costs = new int[size];
//        Arrays.fill(costs, Integer.MAX_VALUE);
        Deque<Integer> queueTop = new ArrayDeque<>(size);
        queueTop.addLast(0);
//        costs[0] = 0;
        Integer endId = indexString.get(endWord);
        Deque<Integer> queueDown = new ArrayDeque<>(size);
        queueDown.addLast(endId);


        int top = 0;
        int down = 0;

        boolean[] visitedTop = new boolean[size];
        boolean[] visitedDown = new boolean[size];

        while (!queueDown.isEmpty() && !queueTop.isEmpty()) {
            Deque<Integer> deque = new ArrayDeque<>(size);
            if (queueTop.size() <= queueDown.size()) {
                //top
                top++;
                boolean[] subVisited = new boolean[size];
                while (!queueTop.isEmpty()) {

                    while (!queueTop.isEmpty()) {
                        Integer first = queueTop.removeFirst();
                        for (int j = 0; j < size; j++) {
                            if (tab[first][j] && !visitedTop[j]) {
                                if (queueDown.contains(j)) {
                                    return top + down + 1;
                                }
                                deque.addFirst(j);
                                subVisited[j]  =true;
                            }
                        }
                    }
                }
                queueTop = deque;
                for (int j = 0; j < subVisited.length; j++) {
                    if(subVisited[j]){
                        visitedTop[j]=true;
                    }
                }
            } else {
                down++;
                boolean[] subVisited = new boolean[size];
                while (!queueDown.isEmpty()) {
                    while (!queueDown.isEmpty()) {
                        Integer first = queueDown.removeFirst();
                        for (int j = 0; j < size; j++) {
                            if (tab[first][j]&& !visitedDown[j]) {
                                if (queueTop.contains(j)) {
                                    return top + down + 1;
                                }
                                deque.addFirst(j);
                                subVisited[j]  =true;
                            }
                        }
                    }

                }
                queueDown = deque;
                for (int j = 0; j < subVisited.length; j++) {
                    if(subVisited[j]){
                        visitedDown[j]=true;
                    }
                }
            }

        }

        return 0;
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

    public static void main(String[] args) {
        new Q0127单词接龙().run();
    }
}
