package com.zrx.algorithm;

import com.zrx.utils.MyLoggerFactory;
import com.zrx.utils.Strings;
import org.slf4j.Logger;
import org.springframework.util.Assert;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Question for leet-code
 */

public interface Question {
    Logger LOGGER = MyLoggerFactory.getLogger(Question.class);

    List<Input> getInputs();

    List<Answer> getAnswers();

    default void run() {
        List<Input> inputs = getInputs();
        List<Answer> answers = getAnswers();
        Assert.isTrue(inputs.size() == answers.size(), getThisClass().getName() + "::输入和答案数目不匹配!");

        Object solutionInstance = getSolutionInstance();
        Method leetCodeMethod = getLeetCodeMethod();

        LOGGER.info("开始测试{}", Strings.classNameCutDown(1, getThisClass().getName()));

//        for (String s : getInfo()) {
//            LOGGER.info(s);
//        }

        for (int i = 0; i < inputs.size(); i++) {
            if (inputs.size() > 1)
                LOGGER.info("第{}组测试", ToString.apply(i + 1));

            Input input = inputs.get(i);
            Answer answer = answers.get(i);
            String[] inputNames = getInputNames();
            Object[] parametersArray = input.getParametersArray();


            LOGGER.info("input = {}", input.toString(inputNames));
            LOGGER.info("answer = {}", ToString.apply(answer));

            Object ret = null;
            try {
                ret = leetCodeMethod.invoke(solutionInstance, parametersArray);
            } catch (IllegalAccessException | InvocationTargetException e) {
                LOGGER.error("Leetcode 方法运行出现异常");
                e.printStackTrace();
                throw new RuntimeException(e);
            }

            LOGGER.info("ret = {}", ToString.apply(ret));

            // 再次打印入参
            for (int index : getParameterIndexNeedPrint()) {
                LOGGER.info("input[" + ToString.apply(inputNames[index]) + "]=" + ToString.apply(parametersArray[index]));
            }


            if (Equality.isEqual(answer.getAns(), ret))
                LOGGER.info("测试通过");
            else
                LOGGER.error("测试失败");

            if (i == inputs.size() - 1) {
                LOGGER.info("-------------------------------------------");
            }
        }
    }

    private Object getSolutionInstance() {
        try {
            return getThisClass().getConstructors()[0].newInstance((Object[]) null);
        } catch (InstantiationException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private Class<? extends Question> getThisClass() {
        return this.getClass();
    }

    private Method getLeetCodeMethod() {
        Class<? extends Question> thisClass = getThisClass();

        for (Method method : thisClass.getMethods()) {
            if (method.isAnnotationPresent(Code.class)) {
                return method;
            }
        }

        throw new RuntimeException("没有找到leetcode，忘记注解@Leetcode？");
    }

    private String[] getInputNames() {
        Method leetCodeMethod = getLeetCodeMethod();
        Parameter[] parameters = leetCodeMethod.getParameters();
        return Stream.of(parameters)
                .map(Parameter::getName)
                .collect(Collectors.toList())
                .toArray(new String[]{});
    }

    private int getInputLength() {
        return getLeetCodeMethod().getParameterCount();
    }

    default String[] getInfo() {
        String[] info = getLeetCodeMethod().getAnnotation(Code.class).info();

        if (info.length == 0) {
            return new String[]{Strings.classNameCutDown(1, getThisClass().getName())};
        } else {
            return Arrays.stream(info)
                    .flatMap(s -> {
                        String[] split = s.split("\n");
                        return Arrays.stream(split).map(String::trim).filter(ss -> ss.length() > 0);
                    })
                    .collect(Collectors.toList())
                    .toArray(String[]::new);
        }


    }

    default String getGroup() {
        return getLeetCodeMethod().getAnnotation(Code.class).group();
    }

    default int getNumber() {
        return getLeetCodeMethod().getAnnotation(Code.class).number();
    }

    default int[] getParameterIndexNeedPrint() {
        return getLeetCodeMethod().getAnnotation(Code.class).printInputParameters();
    }

    class Input {
        Object[] parametersArray;

        private Input() {
        }

        public static Input create(Object... parameters) {
            Objects.requireNonNull(parameters);
            Input input = new Input();
            input.parametersArray = parameters;
            return input;
        }

        public Object[] getParametersArray() {
            return parametersArray;
        }

        public String toString(String[] inputNames) {
            StringBuilder sb = new StringBuilder("{");
            for (int i = 0; i < parametersArray.length - 1; i++) {
                sb.append(inputNames[i]).append(": ")
                        .append(ToString.apply(parametersArray[i]))
                        .append(", ");
            }
            sb.append(inputNames[inputNames.length - 1]).append(": ").
                    append(ToString.apply(parametersArray[parametersArray.length - 1])).append("}");
            return sb.toString();
        }
    }

    class InputFactory {
        public static List<Input> create(int length, Object... parameters) {
            List<Input> inputs = new ArrayList<>(parameters.length / length);
            for (int i = 0; i < parameters.length; i += length) {
                inputs.add(Input.create(subArray(parameters, i, i + length)));
            }

            return inputs;

        }


        private static Object[] subArray(Object[] objects, int startIncluding, int endExcluding) {
            Object[] ret = new Object[endExcluding - startIncluding];

            System.arraycopy(objects, startIncluding, ret, 0, endExcluding - startIncluding);

            return ret;
        }
    }

    class Answer {
        Object ans;

        private Answer() {
        }

        public static Answer create(Object ans) {
            //bug#20200606 答案可空
            //Objects.requireNonNull(ans);
            Answer answer = new Answer();
            answer.ans = ans;
            return answer;
        }

        public Object getAns() {
            return ans;
        }

        @Override
        public String toString() {
            return ToString.apply(ans);
        }
    }

    class AnswerFactory {
        public static List<Answer> create(Object... answers) {
            return Stream.of(answers)
                    .map(Answer::create)
                    .collect(Collectors.toList());
        }
    }
}
