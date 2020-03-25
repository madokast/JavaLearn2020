package com.zrx.io.controller;

import com.zrx.algorithm.AlgorithmHelper;
import com.zrx.algorithm.QuestionWrapper;
import com.zrx.io.DataWrapper;
import com.zrx.utils.Container;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Description
 * 运行任务的 Controller
 *
 * <p>
 * Data
 * 2020/3/24-12:26
 *
 * @author zrx
 * @version 1.0
 */

@RestController
@RequestMapping("/question")
public class QuestionController {
    private final static Logger LOGGER = LoggerFactory.getLogger(QuestionController.class);

    private final static String SESSION_KEY = String.valueOf(Objects.hash(QuestionController.class, new Date()));

    private final AlgorithmHelper algorithmHelper;

    public QuestionController(AlgorithmHelper algorithmHelper) {
        this.algorithmHelper = algorithmHelper;
    }

    /**
     * @return 返回所有的 question
     */
    @GetMapping("/all")
    public Object getAllQuestion() {

        List<QuestionWrapper> allQuestions = algorithmHelper.findAllQuestions();
        LOGGER.info("allQuestions = {}", allQuestions);

        return DataWrapper.create("all questions", algorithmHelper.findAllQuestions());
    }


    /**
     * 跟组 分组 和 编号 寻找 question
     *
     * @param group  分组
     * @param number 编号
     * @return 跟组 分组 和 编号 寻找 question
     * @throws QuestionWrapper.QuestionWrapperNotFoundException 没有找到时抛出
     */
    @GetMapping("/group/{group}/number/{number}")
    public DataWrapper<QuestionWrapper> getQuestionWrapper(@PathVariable String group, @PathVariable int number)
            throws QuestionWrapper.QuestionWrapperNotFoundException {
        return DataWrapper.create("question finding", algorithmHelper.findQuestion(group, number));
    }

    /**
     * 运行 分组 下 编号 的方法
     *
     * @param group   分组
     * @param number  编号
     * @param session session
     * @return url 用于接受方法结果
     * @throws QuestionWrapper.QuestionWrapperNotFoundException 没有此方法时抛出
     */
    @SuppressWarnings("all")
    @GetMapping("/group/{group}/number/{number}/run")
    public DataWrapper<Map<String, String>> runQuestion(@PathVariable String group, @PathVariable int number, HttpSession session)
            throws QuestionWrapper.QuestionWrapperNotFoundException {

        QuestionWrapper questionWrapper = getQuestionWrapper(group, number).getData();

        if (session.getAttribute(SESSION_KEY) != null) {
            LOGGER.error("当前SESSION中已有一个question在运行？");
        }

        session.setAttribute(SESSION_KEY, questionWrapper);

        algorithmHelper.run(questionWrapper);

        return DataWrapper.createMap("run method", Container.BiContainer.create("SESSION_KEY", SESSION_KEY));
    }

    /**
     * 获取方法执行中的LOG数据，首先需要调用
     * GetMapping("/group/{group}/number/{number}/run")
     * 执行方法，然后上方法会返回 一个 SESSION_KEY
     * 用这个 SESSION_KEY 调用次方法，就获得方法的执行结果
     * 当返回 QuestionWrapper.END 时，表示此方法执行完毕
     *
     * @param session    session
     * @param sessionKey SESSION_KEY
     * @return 获得方法的执行结果
     * @throws QuestionWrapper.NoRunningQuestionException 没有方法被执行
     */
    @SuppressWarnings("all")
    @GetMapping("result/{sessionKey}")
    public DataWrapper<String> getQuestionResult(HttpSession session, String sessionKey)
            throws QuestionWrapper.NoRunningQuestionException {
        QuestionWrapper questionWrapper = (QuestionWrapper) session.getAttribute(SESSION_KEY);

        if (questionWrapper == null)
            throw new QuestionWrapper.NoRunningQuestionException();
        else {
            String poll = questionWrapper.poll();
            if (poll == null) {
                // 不应该发生
                LOGGER.error("poll == null，不应该，我有两个info才会返回这个结果的");
                throw new NullPointerException("poll == null，不应该，我有两个info才会返回这个结果的");
            }

            if (poll.equals(QuestionWrapper.END)) {
                questionWrapper.romeLogQueue();
                session.removeAttribute(SESSION_KEY);
            } else {
                // wait for another
                questionWrapper.waitUntilHasNext();
            }

            return DataWrapper.create("get question result -- end", poll);
        }
    }

}
