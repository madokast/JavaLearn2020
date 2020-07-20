package com.zrx.algorithm.leetcode.q0200;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 实现 Trie (前缀树)
 * <p>
 * Data
 * 2020/7/6-11:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0208实现Trie前缀树 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0208实现Trie前缀树.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(

        );
    }

    @Code(info = """
            实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。

            示例:

            Trie trie = new Trie();

            trie.insert("apple");
            trie.search("apple");   // 返回 true
            trie.search("app");     // 返回 false
            trie.startsWith("app"); // 返回 true
            trie.insert("app");\040\040\040
            trie.search("app");     // 返回 true
            说明:

            你可以假设所有的输入都是由小写字母 a-z 构成的。
            保证所有输入均为非空字符串。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public String fun(boolean b) {
        return null;
    }


    ///**
    // * Your Trie object will be instantiated and called as such:
    // * Trie obj = new Trie();
    // * obj.insert(word);
    // * boolean param_2 = obj.search(word);
    // * boolean param_3 = obj.startsWith(prefix);
    // */
    class Trie {

        /**
         * Initialize your data structure here.
         */
        public Trie() {

        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {

        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            return false;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            return false;
        }
    }
}
