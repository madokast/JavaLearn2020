package com.zrx.algorithm.专题.专题001;

import com.zrx.Invoking;
import com.zrx.algorithm.Code;
import com.zrx.algorithm.Question;
import com.zrx.utils.ArrayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description
 * 活动安排之场数最多
 * <p>
 * Data
 * 2020/5/24-16:18
 *
 * @author zrx
 * @version 1.0
 */

@Invoking(createdTime = "2020-05-24 16:44",details = "活动安排之场数最多")
@Component
public class 活动安排之场数最多 implements Question {
    private final static Logger LOGGER = LoggerFactory.getLogger(活动安排之场数最多.class);

    @Override
    public List<Input> getInputs() {
        return InputFactory.create(
                2,
                ArrayFactory.create(1, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12),
                ArrayFactory.create(4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14)
        );
    }

    @Override
    public List<Answer> getAnswers() {
        return AnswerFactory.create(4);
    }

    @Code(group = "专题",number = 1)
    public int select(int[] startingTime, int[] finishingTime) {
        int prev = 0;
        int count = 1;

        for (int i = 1; i < startingTime.length; i++) {
            int prevF = finishingTime[prev];

            int curS = startingTime[i];
            int curF = finishingTime[i];

            if (curS >= prevF) {
                count++;
                prev = i;
            }
        }

        return count;
    }

    @Invoking(createdTime = "2020-05-24 16:19")
    public void 测试() {
        this.run();
    }
}
