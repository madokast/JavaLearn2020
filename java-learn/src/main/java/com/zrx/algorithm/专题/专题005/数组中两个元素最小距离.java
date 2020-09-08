package com.zrx.algorithm.专题.专题005;

import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 数组中两个元素最小距离
 * <p>
 *
 * @author madokast
 * @version 1.0
 */

@Component
public class 数组中两个元素最小距离 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(数组中两个元素最小距离.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                3,
                ArrayFactory.create(4, 5, 6, 4, 7, 4, 6, 4, 7, 8, 5, 6, 4, 3, 10, 8), 4, 8,
                ArrayFactory.create(4, 5, 6, 4, 7, 4, 6, 4, 7, 8, 5, 6, 4, 3, 10, 8), 8, 4
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(2, 2);
    }

    @Code(group = "专题", number = 5)
    public int solve(int[] arr, int e1, int e2) {
        int length = arr.length;

        int e1Index = -length - 1;
        int e2Index = -length - 1;

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int cur = arr[i];
            if (cur == e1) {
                e1Index = i;
                ans = Math.min(ans, e1Index - e2Index);
            } else if (cur == e2) {
                e2Index = i;
                ans = Math.min(ans, e2Index - e1Index);
            }
        }

        return ans;
    }
}
