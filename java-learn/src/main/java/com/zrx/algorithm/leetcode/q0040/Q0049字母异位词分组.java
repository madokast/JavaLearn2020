package com.zrx.algorithm.leetcode.q0040;

import com.zrx.Invoking;
import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.leetcode.object.RepeatableSet;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description
 * <p>
 * Data
 * 2020/5/24-21:42
 *
 * @author zrx
 * @version 1.0
 */

//@Invoking(createdTime = "2020-05-26 11:46")
@Component
public class Q0049字母异位词分组 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(Q0049字母异位词分组.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                1,
                (Object) ArrayFactory.create("eat", "tea", "tan", "ate", "nat", "bat")
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(
                RepeatableSet.of(
                        RepeatableSet.of("ate", "eat", "tea"),
                        RepeatableSet.of("nat", "tan"),
                        RepeatableSet.of("bat")
                )
        );
    }

    @Code(info = """
            给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

            示例:

            输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
            输出:
            [
              ["ate","eat","tea"],
              ["nat","tan"],
              ["bat"]
            ]
            说明：

            所有输入均为小写字母。
            不考虑答案输出的顺序。

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/group-anagrams
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new ArrayList<>();

        Map<Long, List<Integer>> hashIndexesMap = new HashMap<>();

        for (String str : strs) {
            long hash = hash(str);

            if (hashIndexesMap.containsKey(hash)) {
                List<Integer> indexes = hashIndexesMap.get(hash);

                boolean add = false;
                for (Integer index : indexes) {
                    List<String> strings = ret.get(index);
                    String s = strings.get(0);
                    if (isAnagrams(s, str)) {
                        strings.add(str);
                        add = true;
                        break;
                    }
                }

                if (!add) {
                    List<String> newList = new ArrayList<>();
                    newList.add(str);
                    indexes.add(ret.size());
                    ret.add(newList);
                }


            } else {
                List<String> newList = new ArrayList<>();
                newList.add(str);

                List<Integer> indexes = new ArrayList<>();
                indexes.add(ret.size());

                hashIndexesMap.put(hash, indexes);
                ret.add(newList);
            }
        }

        return ret;
    }

    private long hash(String s) {
        long hash = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c <= 's') {
                long k = (c - 'a' + 1L) << 3L;
                hash += (1L << k);
            } else {
                long k = (c - 'a' + 1L) << 2L;
                hash += (1L << (k+5L));
            }
        }
        hash += s.length();

        return hash;
    }

    private Map<Character, Integer> isAnagramsHelperMap = new HashMap<>();

    private boolean isAnagrams(String a, String b) {
        int length = a.length();
        if (length != b.length())
            return false;

        isAnagramsHelperMap.clear();

        for (int i = 0; i < length; i++) {
            char c = a.charAt(i);
            isAnagramsHelperMap.put(c, isAnagramsHelperMap.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < length; i++) {
            char c = b.charAt(i);
            if (isAnagramsHelperMap.containsKey(c)) {
                Integer times = isAnagramsHelperMap.get(c);
                isAnagramsHelperMap.put(c, times - 1);
            } else {
                return false;
            }
        }

        for (Integer times : isAnagramsHelperMap.values()) {
            if (times != 0)
                return false;
        }

        return true;
    }


    @Invoking(createdTime = "2020-05-26 11:45")
    public void test() {
        long ids = hash("ids");
        long tic = hash("tic");

        LOGGER.info("tic = {}", tic);
        LOGGER.info("ids = {}", ids);

        LOGGER.info("hash(\"ned\") = {}", hash("ned"));
        LOGGER.info("hash(\"ned\") = {}", hash("fed"));
        LOGGER.info("hash(\"ned\") = {}", hash("ned"));
    }
}
