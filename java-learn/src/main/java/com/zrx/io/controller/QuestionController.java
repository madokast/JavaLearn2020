package com.zrx.io.controller;

import com.zrx.algorithm.AlgorithmHelper;
import com.zrx.algorithm.QuestionWrapper;
import com.zrx.io.DataWrapper;
import com.zrx.utils.Container;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

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

@CrossOrigin
@RestController
@RequestMapping("/question")
public class QuestionController {
    private final static Logger LOGGER = LoggerFactory.getLogger(QuestionController.class);

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
        //LOGGER.info("allQuestions = {}", allQuestions);

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


    private String resultKey;
    private static Map<String, QuestionWrapper> questionWrapperMap = new ConcurrentHashMap<>();

//    @Scheduled(cron = "0-59 * * * * *")
//    public void logMapInfo(){
//        LOGGER.info("questionWrapperMap = {}", questionWrapperMap);
//    }

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
    public DataWrapper<Map<String, String>> runQuestion(@PathVariable String group, @PathVariable int number)
            throws QuestionWrapper.QuestionWrapperNotFoundException {

        QuestionWrapper questionWrapper = getQuestionWrapper(group, number).getData();

        // 运行 这里自动加上 log
        algorithmHelper.run(questionWrapper); //@Async

        resultKey = Integer.toHexString(Math.abs(Objects.hash(group, number, new Date())));
        LOGGER.info("create RESULT_KEY = {}", resultKey);

        questionWrapperMap.put(resultKey,questionWrapper);

        return DataWrapper.createMap("run method", Container.BiContainer.create("RESULT_KEY", resultKey));
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
    @GetMapping("/result/{resultKey}")
    public DataWrapper<String> getQuestionResult(@PathVariable String resultKey)
            throws QuestionWrapper.NoRunningQuestionException {
        //LOGGER.info("/result/resultKey = {}", resultKey);

        QuestionWrapper questionWrapper = questionWrapperMap.get(resultKey);
        //LOGGER.info("questionWrapper = {}", questionWrapper);

        if (questionWrapper == null)
            throw new QuestionWrapper.NoRunningQuestionException();
        else {
            String poll = questionWrapper.poll();
            if (poll == null) {// 不应该发生
                poll = "result 结果没有正确的读取完毕，可能原因是方法运行时间过长？";
                questionWrapperMap.remove(resultKey);
            } else if (poll.equals(QuestionWrapper.END)) {
                questionWrapper.removeLogQueue();
                questionWrapperMap.remove(resultKey);
            } else {
                // wait for another
                questionWrapper.waitUntilHasNext();
            }

            return DataWrapper.create("get question result -- end", poll);
        }
    }

}
