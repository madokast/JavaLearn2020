package com.zrx.algorithm.leetcode.q0060;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.algorithm.ToString;
import com.zrx.utils.MyLoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description
 * Q0060第k个排列
 * <p>
 * Data
 * 2020/5/28-13:23
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Q0060第k个排列 implements Question {
    private final static Logger LOGGER = MyLoggerFactory.getLogger(Q0060第k个排列.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                2,
                3, 3,
                4, 9
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create("213", "2314");
    }

    @Code(info = """
            给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。

            按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：

            "123"
            "132"
            "213"
            "231"
            "312"
            "321"
            给定 n 和 k，返回第 k 个排列。

            说明：

            给定 n 的范围是 [1, 9]。
            给定 k 的范围是[1,  n!]。
            示例 1:

            输入: n = 3, k = 3
            输出: "213"
            示例 2:

            输入: n = 4, k = 9
            输出: "2314"

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/permutation-sequence
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            """)
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder(n);

        List<Integer> num = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            num.add(i + 1);
        }

        int[] f = new int[n + 1];
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] * i;
        }
        LOGGER.info(ToString.apply(f));

        k--;

        for (int i = n - 1; i > 0; i--) {
            Integer a = num.get(k / f[i]);
            sb.append(a);
            num.remove((Object)a);
            k %= f[i];
        }

        sb.append(num.get(0));

        return sb.toString();

    }

    public String getPermutation垃圾方法(int n, int k) {
        if (n == 1)
            return "1";


        int[] data = new int[n];
        for (int i = 0; i < data.length; i++) {
            data[i] = i + 1;
        }

//        int f = 1;
//        for (int i = 2; i <= n; i++) {
//            f *= i;
//        }
//
//        k = k % f;

        for (int i = 1; i < k; i++) {
            //LOGGER.info(Arrays.stream(data).mapToObj(String::valueOf).collect(Collectors.joining()));
            next(data);
        }

        return Arrays.stream(data).mapToObj(String::valueOf).collect(Collectors.joining());
    }

    private void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    private void next(int[] data) {
        int length = data.length;

        if (data[length - 1] > data[length - 2]) {
            swap(data, length - 1, length - 2);
        } else {
            int i = length - 1;
            while (data[i] < data[i - 1]) i--;
            i--;

            int j = length - 1;
            while (data[i] > data[j]) j--;

            swap(data, i, j);

            Arrays.sort(data, i + 1, length);
        }
    }
}
