package com.zrx.algorithm.leetcode.q0210;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Description
 * 单词搜索 II
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0212单词搜索II implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0212单词搜索II.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                2,
                ArrayFactory.createTwoDimensionsIntArray(
                        'o', 'a', 'a', 'n', null,
                        'e', 't', 'a', 'e', null,
                        'i', 'h', 'k', 'r', null,
                        'i', 'f', 'l', 'v'
                ),
                ArrayFactory.create("oath", "pea", "eat", "rain"),
                ArrayFactory.createTwoDimensionsIntArray(
                        'o', 'a', 'a', 'n', null,
                        'e', 't', 'a', 'e', null,
                        'i', 'h', 'k', 'r', null,
                        'i', 'f', 'l', 'v'
                ),
                ArrayFactory.create("eat")
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                List.of("eat", "oath"),
                List.of("eat")
        );
    }

    @Code(info = """
            给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。

            单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。

            示例:

            输入:\040
            words = ["oath","pea","eat","rain"] and board =
            [
              ['o','a','a','n'],
              ['e','t','a','e'],
              ['i','h','k','r'],
              ['i','f','l','v']
            ]

            输出: ["eat","oath"]
            说明:
            你可以假设所有输入都由小写字母 a-z 组成。

            提示:

            你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？
            如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？
            散列表是否可行？为什么？
             前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/word-search-ii
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public List<String> findWords(char[][] board, String[] words) {
        Tire tire = new Tire();

        for (String w : words) tire.add(w);

        List<String> ans = new ArrayList<>(words.length);

        Map<Character, List<int[]>> map = new HashMap<>();
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                char ch = board[r][c];
                List<int[]> orDefault = map.getOrDefault(ch, new ArrayList<>());
                orDefault.add(new int[]{r, c});

                map.put(ch, orDefault);
            }
        }

        dps(ans, tire.root, board, map, new StringBuilder(), new LinkedList<int[]>());

        return ans;
    }

    private void dps(List<String> ans, Node root, char[][] board, Map<Character, List<int[]>> map, StringBuilder sb, Deque<int[]> stack) {
        if (root.end) {
            String key = sb.toString();
            if(!ans.contains(key)) ans.add(key);
        }
        for (int i = 0; i < root.next.length; i++) {
            Node node = root.next[i];
            if (node != null) {
                char ch = (char) (i + 'a');
                List<int[]> curList = map.getOrDefault(ch, Collections.emptyList());
                if (stack.isEmpty()) {
                    for (int[] pp : curList) {
                        int row = pp[0];
                        int col = pp[1];
                        board[row][col] += 256;
                        sb.append(ch);
                        stack.push(pp);
                        dps(ans, node, board, map, sb, stack);

                        board[row][col] -= 256;
                        stack.pop();
                        sb.deleteCharAt(sb.length() - 1);
                    }
                } else {
                    int[] prep = stack.peek();
                    for (int[] pp : curList) {
                        int row = pp[0];
                        int col = pp[1];
                        if (board[row][col] > 'z') continue;

                        if (near(pp, prep)) {
                            board[row][col] += 256;
                            sb.append(ch);
                            stack.push(pp);
                            dps(ans, node, board, map, sb, stack);

                            board[row][col] -= 256;
                            stack.pop();
                            sb.deleteCharAt(sb.length() - 1);
                        }

                    }
                }
            }
        }
    }

    private boolean near(int[] pp, int[] prep) {
        int row = pp[0];
        int col = pp[1];

        int rowPre = prep[0];
        int colPre = prep[1];

        return (Math.abs(rowPre - row) + Math.abs(colPre - col)) == 1;
    }


    static class Tire {
        Node root;

        public Tire() {
            root = new Node();
        }

        public void add(String word) {
            Node cur = root;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (cur.next[i] == null) cur.next[i] = new Node();
                cur = cur.next[i];
            }
            cur.end = true;
            cur.allNull = false;
        }
    }

    static class Node {
        boolean end = false;
        Node[] next = new Node[26];
        boolean allNull = true;
    }
}
