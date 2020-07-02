package com.zrx.algorithm;

import com.zrx.utils.MyLoggerFactory;
import com.zrx.utils.ThreadUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.sql.Time;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Description
 * 算法类下 助手
 * <p>
 * Data
 * 2020/3/24-12:47
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class AlgorithmHelper {
    private final static Logger LOGGER = LoggerFactory.getLogger(AlgorithmHelper.class);

    private static final String LEETCODE = "leetcode";
    private static final int LEETCODE_START_INDEX = "com.zrx.algorithm.leetcode.q0860.Q".length();

    private static final String OTHERS = "others";

    private final ApplicationContext applicationContext;

    public AlgorithmHelper(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public List<QuestionWrapper> findAllQuestions() {
        Map<String, Question> questionMap = applicationContext.getBeansOfType(Question.class);

        return questionMap.values()
                .stream()
                .map(QuestionWrapper::create)
                .sorted((q1, q2) -> {
                    // 先按照 group 排序 后按照 number 排序
                    if (q1.getGroup().equals(q2.getGroup())) {
                        return Integer.compare(q1.getNumber(), q2.getNumber());
                    } else
                        return q1.getGroup().compareTo(q2.getGroup());
                })
                .collect(Collectors.toList());

    }

    @Cacheable(cacheNames = "algorithmQuestion")
    public QuestionWrapper findQuestion(String group, int number) throws QuestionWrapper.QuestionWrapperNotFoundException {
        return findAllQuestions()
                .stream()
                .filter(qw -> {
                    return qw.getGroup().equals(group) && qw.getNumber() == number;
                })
                .findFirst()
                .orElseThrow(QuestionWrapper.QuestionWrapperNotFoundException::new);
    }


    public void run(QuestionWrapper questionWrapper) {
        ThreadUtils.timedRun(() -> {
            questionWrapper.log(QuestionWrapper.START);
            questionWrapper.getQuestion().run();
            questionWrapper.log(QuestionWrapper.END);
        }, 200, TimeUnit.MILLISECONDS);
        //questionWrapper.romeLogQueue(); 不在这里移走
    }
}
