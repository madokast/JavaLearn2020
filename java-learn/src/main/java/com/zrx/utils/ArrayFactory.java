package com.zrx.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Description
 * IntArray
 * <p>
 * Data
 * 2020/3/23-17:56
 *
 * @author zrx
 * @version 1.0
 */

public class ArrayFactory {
    private final static Logger LOGGER = LoggerFactory.getLogger(ArrayFactory.class);

    public static int[] create(int... ints) {
        return ints;
    }

    public static int[][] create(int[]... intArrArr) {
        return intArrArr;
    }

    public static String[] create(String... strings) {
        return strings;
    }

    public static <T> T empty(Class<T> returnType) {
        if (!returnType.isArray()) {
            throw new IllegalArgumentException("returnType必须是数据类型，returnType=" + returnType);
        }
        return (T) Array.newInstance(returnType.getComponentType(), 0);
    }

    public static int[] create(List<Integer> list) {
        Objects.requireNonNull(list);
        int[] ret = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }

    /**
     * 创建二维数组 int[][]
     * 例如 1,2,null,3,4
     * 返回[1,2],[3,4]
     *
     * @param integers 不定参数，null作为分隔符
     * @return int[][]
     */
    public static int[][] createTwoDimensionsIntArray(Integer... integers) {
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>());
        for (Integer integer : integers) {
            if (integer == null) {
                answer.add(new ArrayList<>());
            } else {
                List<Integer> last = answer.get(answer.size() - 1);
                last.add(integer);
            }
        }

        return answer.stream()
                .map(ArrayFactory::create)
                .collect(Collectors.toList())
                .toArray(int[][]::new);
    }

    public static char[][] createTwoDimensionsIntArray(Character... characters) {
        List<List<Character>> answer = new ArrayList<>();
        answer.add(new ArrayList<>());
        for (Character c : characters) {
            if (c == null) {
                answer.add(new ArrayList<>());
            } else {
                List<Character> last = answer.get(answer.size() - 1);
                last.add(c);
            }
        }

        return answer.stream()
                .map(charactersList -> {
                    char[] chars = new char[charactersList.size()];
                    for (int i = 0; i < charactersList.size(); i++) {
                        chars[i] = charactersList.get(i);
                    }
                    return chars;
                })
                .collect(Collectors.toList())
                .toArray(char[][]::new);
    }

    /**
     * 构建二维int数组
     * 输入：
     * [
     *   [0,1,0],
     *   [0,0,1],
     *   [1,1,1],
     *   [0,0,0]
     * ]
     *
     * @param data data
     * @return int[][]
     */
    public static int[][] createTwoDimensionsIntArray(String data) {
        data = removeBlack(data);
        if (data.charAt(0) != '[' || data.charAt(data.length() - 1) != ']') {
            throw new IllegalArgumentException("无法由" + data + "构建int二维数组");
        }

        List<int[]> ans = new ArrayList<>();

        boolean inLeft = false;
        int leftIndex = -1;
        for (int i = 1; i < data.length() - 1; i++) {
            char c = data.charAt(i);
            if (c == '[') {
                if (inLeft) {
                    throw new IllegalArgumentException("无法由" + data + "构建int二维数组");
                }

                inLeft = true;
                leftIndex = i;
            } else if (c == ']') {
                if (!inLeft) {
                    throw new IllegalArgumentException("无法由" + data + "构建int二维数组");
                }

                ans.add(createIntArray(data.substring(leftIndex, i + 1)));
                inLeft = false;
            }
        }

        return ans.toArray(int[][]::new);
    }

    /**
     * 构建一维数组
     * 输入[0,1,0]
     *
     * @param data data
     * @return int[]
     */
    public static int[] createIntArray(String data) {
        //[0,0,0]
        data = removeBlack(data);
        if (data.charAt(0) != '[' || data.charAt(data.length() - 1) != ']') {
            throw new IllegalArgumentException("无法由" + data + "构建int数组");
        }

        String[] split = data.substring(1, data.length() - 1).split(",");

        try {
            return Arrays.stream(split).map(String::trim).mapToInt(Integer::parseInt).toArray();
        } catch (Exception e) {
            throw new IllegalArgumentException("无法由" + data + "构建int数组");
        }
    }

    private static String removeBlack(String src) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < src.length(); i++) {
            char c = src.charAt(i);

            if (c != ' ' && c != '\n') {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    /**
     * 建立 char 数组
     * 传入String[]，取每个 s.charAt(0) 作为 char
     *
     * @param chars 传入String[]
     * @return char 数组
     */
    public static char[] createChars(String... chars) {
        char[] ret = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            ret[i] = chars[i].charAt(0);
        }

        return ret;
    }

    /**
     * 创建二维数组 char[][]
     * 例如输入 "a c b d", "c d"
     * 返回 [
     * ['a', 'c', 'b', 'd'],
     * ['c', 'd']
     * ]
     *
     * @param strings 见示例
     * @return char[][]
     */
    public static char[][] createTwoDimensionsCharArray(String... strings) {
        List<char[]> ans = new ArrayList<>();
        for (String string : strings) {
            String[] s = string.split(" ");
            char[] chars = new char[s.length];
            for (int i = 0; i < s.length; i++) {
                chars[i] = s[i].charAt(0);
            }
            ans.add(chars);
        }

        return ans.toArray(char[][]::new);
    }


    public static int[] randomInts(int bound, int length) {
        Random random = new Random();

        return Stream.generate(() -> random.nextInt(bound)).limit(length).mapToInt(Integer::intValue).toArray();
    }
}
