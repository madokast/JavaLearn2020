package com.zrx.algorithm.leetcode.q0060;

import com.zrx.algorithm.Question;
import com.zrx.utils.ArrayFactory;
import com.zrx.utils.MyLoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Base64;
import java.util.LinkedList;
import java.util.List;

/**
 * Description
 * 文本左右对齐
 * <p>
 * Data
 * 2020/5/28-13:58
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0068文本左右对齐 implements Question {
    private final static Logger LOGGER = MyLoggerFactory.getLogger(Q0068文本左右对齐.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                2,
                ArrayFactory.create("This", "is", "an", "example", "of", "text", "justification."), 16,
                ArrayFactory.create("What", "must", "be", "acknowledgment", "shall", "be"), 16,
                ArrayFactory.create("Science", "is", "what", "we", "understand", "well", "enough", "to", "explain",
                        "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"), 20
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                List.of(
                        "This    is    an",
                        "example  of text",
                        "justification.  "
                ),
                List.of(
                        "What   must   be",
                        "acknowledgment  ",
                        "shall be        "
                ),
                List.of("Science  is  what we",
                        "understand      well",
                        "enough to explain to",
                        "a  computer.  Art is",
                        "everything  else  we",
                        "do                  "
                )
        );
    }

    @Code(info = """
            给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。

            你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。

            要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。

            文本的最后一行应为左对齐，且单词之间不插入额外的空格。

            说明:

            单词是指由非空格字符组成的字符序列。
            每个单词的长度大于 0，小于等于 maxWidth。
            输入单词数组 words 至少包含一个单词。
            示例:

            输入:
            words = ["This", "is", "an", "example", "of", "text", "justification."]
            maxWidth = 16
            输出:
            [
               "This    is    an",
               "example  of text",
               "justification.  "
            ]
            示例 2:

            输入:
            words = ["What","must","be","acknowledgment","shall","be"]
            maxWidth = 16
            输出:
            [
              "What   must   be",
              "acknowledgment  ",
              "shall be        "
            ]
            解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
                 因为最后一行应为左对齐，而不是左右两端对齐。
                 第二行同样为左对齐，这是因为这行只包含一个单词。
            示例 3:

            输入:
            words = ["Science","is","what","we","understand","well","enough","to","explain",
                     "to","a","computer.","Art","is","everything","else","we","do"]
            maxWidth = 20
            输出:
            [
              "Science  is  what we",
              "understand      well",
              "enough to explain to",
              "a  computer.  Art is",
              "everything  else  we",
              "do                  "
            ]

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/text-justification
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ret = new LinkedList<>();

        // 单词总数目
        int length = words.length;

        // 用数组 wordLengths 存储每个单词长度
        // 提前计算好，免去重复调用string.length()的开销
        int[] wordLengths = new int[length];
        for (int i = 0; i < length; i++) {
            wordLengths[i] = words[i].length();
        }

        // 双指针
        // startIncluding 指向当前行第一个单词
        // endExcluding-1 指向当前行最后一个单词
        int startIncluding = 0;
        int endExcluding = 1;

        // 开始搜索
        while (true){
            // 如果 endExcluding == length，说明当前行是最后一行
            if (endExcluding == length) {
                // makeEnd() 方法专用于构造最后一行（因为构造最后一行的规则不同于其他行）
                String make = makeEnd(startIncluding, endExcluding, words, maxWidth, wordLengths);
                ret.add(make);
                // 最后一行构造完毕，返回
                return ret;
            }

            // remainSizeForWords() 方法，用于计算填充[startIncluding~endExcluding]的单词后，剩余的空间
            // 例如要求一行长度为 6 时
            // 填单词 an 时，有 "an xxx"，说明剩余空间为 3
            // 填单词 do i 时，有 "do i x"，说明剩余空间为 1
            int remainSizeForWords = remainSizeForWords(startIncluding, endExcluding, maxWidth, wordLengths);

            // 如果剩余空间 >=下一个单词的长度 wordLengths[endExcluding]，则 endExcluding++
            if (remainSizeForWords >= wordLengths[endExcluding]) {
                endExcluding++;
                continue;
            }

            // 否则，直接构造当前行
            String make = make(startIncluding, endExcluding, words, maxWidth, wordLengths);
            ret.add(make);

            // 构造完毕，指针前移
            startIncluding = endExcluding;
            endExcluding = startIncluding + 1;
        }
    }

    private static final String[] blacks = new String[60];

    static {
        blacks[0] = "";
        for (int i = 1; i < blacks.length; i++) {
            blacks[i] = blacks[i - 1] + " ";
        }
    }

    private String makeEnd(int startIn, int endEx, String[] words, int maxWidth, int[] wordLengths) {
        StringBuilder sb = new StringBuilder(maxWidth);
        for (int i = startIn; i < endEx; i++) {
            sb.append(words[i]);
            sb.append(" ");
        }

        sb.deleteCharAt(sb.length() - 1);


        int length = sb.length();
        if (length < maxWidth)
            sb.append(blacks[maxWidth - length]);

        return sb.toString();
    }

    private int remainSizeForWords(int startIn, int endEx, int maxWidth, int[] wordLengths) {
        int usedSize = 0;

        for (int i = startIn; i < endEx; i++) {
            usedSize += wordLengths[i];
            usedSize++; // black
        }

        return maxWidth - usedSize;
    }

    private String make(int startIn, int endEx, String[] words, int maxWidth, int[] wordLengths) {
        int wordNumber = endEx - startIn; // 单词数

        if (wordNumber == 1) {
            int wordLength = wordLengths[startIn];
            String word = words[startIn];

            return word + blacks[maxWidth - wordLength];
        } else {
            int blankNumber = wordNumber - 1; // 空隙数目
            int blankLength = remainSizeForWords(startIn, endEx, maxWidth, wordLengths) + blankNumber + 1; // 空格总长度

            int perBlankLength = blankLength / blankNumber; // 每个空隙的空格数
            int remain = blankLength - blankNumber * perBlankLength; // 余留的空格

            StringBuilder sb = new StringBuilder(maxWidth);
            for (int i = startIn; i < endEx - 1; i++) {
                sb.append(words[i]);
                sb.append(blacks[perBlankLength]);

                if (remain > 0) {
                    sb.append(" ");
                    remain--;
                }
            }

            // 最后一个单词
            sb.append(words[endEx - 1]);

            return sb.toString();
        }
    }
}
