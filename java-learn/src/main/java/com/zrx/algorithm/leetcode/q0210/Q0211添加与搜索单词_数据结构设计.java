package com.zrx.algorithm.leetcode.q0210;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 添加与搜索单词 - 数据结构设计
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0211添加与搜索单词_数据结构设计 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0211添加与搜索单词_数据结构设计.class);

    @Override
    public List<Input> getInputs() {

        WordDictionary w = new WordDictionary();

        w.addWord("bad");
        w.addWord("dad");
        w.addWord("mad");
        boolean b1 = !w.search("pad");// -> false
        boolean b2 = w.search("bad");// -> true
        boolean b3 = w.search(".ad");// -> true
        boolean b4 = w.search("b..");// -> true

        return InputFactory.create(
                1, b1 & b2 & b3 & b4
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                true
        );
    }

    @Code(info = """
            设计一个支持以下两种操作的数据结构：

            void addWord(word)
            bool search(word)
            search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。

            示例:

            addWord("bad")
            addWord("dad")
            addWord("mad")
            search("pad") -> false
            search("bad") -> true
            search(".ad") -> true
            search("b..") -> true
            说明:

            你可以假设所有单词都是由小写字母 a-z 组成的。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/add-and-search-word-data-structure-design
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public boolean fun(boolean b) {
        return b;
    }

    class WordDictionary {

        Node root;

        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {
            root = new Node();
        }

        /**
         * Adds a word into the data structure.
         */
        public void addWord(String word) {
            Node cur = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (cur.next[index] == null) {
                    cur.next[index] = new Node();
                }

                cur = cur.next[index];
            }
            cur.end = true;
        }

        /**
         * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
         */
        public boolean search(String word) {
            char[] chars = word.toCharArray();
            if (chars.length == 0) {
                return root.end;
            } else {
                return search(root, chars, 0);
            }

        }

        private boolean search(Node root, char[] word, int index) {
            if (root == null) return false;
            if (word.length == index) return root.end;

            char c = word[index];
            if (c == '.') {
                for (int i = 0; i < 26; i++) {
                    if (search(root.next[i], word, index + 1)) return true;
                }
                return false;
            } else {
                int nodeIndex = c - 'a';
                return search(root.next[nodeIndex], word, index + 1);
            }
        }


        class Node {
            boolean end = false;
            Node[] next = new Node[27];
        }
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
}
