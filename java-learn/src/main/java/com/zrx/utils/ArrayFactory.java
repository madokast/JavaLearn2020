package com.zrx.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
}
