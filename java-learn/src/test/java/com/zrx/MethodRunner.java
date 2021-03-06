package com.zrx;

import com.zrx.utils.Container;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
class MethodRunner {
    private final static Logger LOGGER = LoggerFactory.getLogger(MethodRunner.class);

    /**
     * spring 容器
     */
    @Autowired
    private ApplicationContext applicationContext;

    private final static ThreadLocal<DateFormat> DATE_FORMAT_THREAD_LOCAL = ThreadLocal.withInitial(
            () -> new SimpleDateFormat("yyyy-MM-dd HH:mm")
    );

    @Test
    void allInvoking() {
        // 按照时间后先运行所有方法
        applicationContext.getBeansWithAnnotation(Invoking.class)
                .values()
                .stream()
                .parallel()
                .map(bean -> Container.BiContainer.create(bean, bean.getClass()))
                .flatMap(beanWithClass -> {
                    Object bean = beanWithClass.getE1();
                    Class<?> klass = beanWithClass.getE2();
                    return Stream.of(klass.getMethods())
                            .filter(method -> method.isAnnotationPresent(Invoking.class))
                            .map(method -> Container.BiContainer.create(bean, method));
                })
                .sorted(((o1, o2) -> {
                    String createdTime1 = o1.getE2().getAnnotation(Invoking.class).createdTime();
                    String createdTime2 = o2.getE2().getAnnotation(Invoking.class).createdTime();
                    DateFormat dateFormat = DATE_FORMAT_THREAD_LOCAL.get();
                    long time1 = 0;
                    long time2 = 0;
                    try {
                        time1 = dateFormat.parse(createdTime1).getTime();
                        time2 = dateFormat.parse(createdTime2).getTime();
                    } catch (ParseException e) {
                        LOGGER.error("dateFormat.parse error");
                    }

                    return -Long.compare(time1, time2);

                }))
                .collect(Collectors.toList())
                .forEach(beanWithMethod -> {
                    Method method = beanWithMethod.getE2();
                    Object bean = beanWithMethod.getE1();

                    String methodName = method.getName();
                    String info = method.getAnnotation(Invoking.class).info();
                    String createdTime = method.getAnnotation(Invoking.class).createdTime();
                    String[] details = method.getAnnotation(Invoking.class).details();
                    int repeat = method.getAnnotation(Invoking.class).repeat();

                    LOGGER.info("--- {}:::{} [{}] ---", methodName, details, createdTime);
                    for (String detail : details) {
                        LOGGER.info(detail);
                    }

                    try {
                        if (repeat > 1) {
                            for (int i = 1; i <= repeat; i++) {
                                LOGGER.info("重复执行第{}次", i);
                                method.invoke(bean);
                            }
                        } else {
                            method.invoke(bean);
                        }

                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    /**
     * 执行最新创建的有@Invoking的类下的@Invoking方法
     */
    @Test
    void latest() {
        LOGGER.info("运行最新方法");
        // getBeansWithAnnotation 拿到的是 map<bean名字,bean实例>
        List<Container.BiContainer<Object, Invoking.MethodWithCreatedTime>> collect =
                applicationContext.getBeansWithAnnotation(Invoking.class)
                        .values()
                        .stream()
                        .map(bean -> Container.BiContainer.create(bean, bean.getClass()))
                        .flatMap(beanWithClass -> {
                            Object bean = beanWithClass.getE1();
                            Class<?> klass = beanWithClass.getE2();
                            return Stream.of(klass.getMethods())
                                    .map(method -> Container.BiContainer.create(bean, method));
                        })
                        .filter(beanWithMethod -> beanWithMethod.getE2().isAnnotationPresent(Invoking.class))
                        .map(beanWithMethod -> {
                            Object bean = beanWithMethod.getE1();
                            Method method = beanWithMethod.getE2();
                            return Container.BiContainer.create(bean, Invoking.MethodWithCreatedTime.create(method));
                        })
                        .sorted(Comparator.comparingLong(beanWithMethodWithCreatedTime ->
                                beanWithMethodWithCreatedTime.getE2().getCreatedTimeMs()))
                        .collect(Collectors.toList());

        Container.BiContainer<Object, Invoking.MethodWithCreatedTime> lastIOne = collect.get(collect.size() - 1);
        Object bean = lastIOne.getE1();
        Method method = lastIOne.getE2().getMethod();

        String methodName = method.toString();
        int dotLast = methodName.lastIndexOf('.');
        int dotLastBut = methodName.lastIndexOf('.', dotLast - 1);
        methodName = methodName.substring(dotLastBut + 1, methodName.length() - 2);
        methodName = methodName.replace('.', '#');

        LOGGER.info("run {}", methodName);


        Invoking classInvoking = bean.getClass().getAnnotation(Invoking.class);
        String classInfo = classInvoking.info();
        String[] classDetails = classInvoking.details();

        Invoking methodInvoking = method.getAnnotation(Invoking.class);
        String methodInfo = methodInvoking.info();
        String[] MethodDetails = methodInvoking.details();
        int repeat = methodInvoking.repeat();


        LOGGER.info("[{}]]", classInfo);
        for (String detail : classDetails) {
            LOGGER.info("[{}]", detail);
        }
        LOGGER.info("[{}]]", methodInfo);
        for (String detail : MethodDetails) {
            LOGGER.info("[{}]", detail);
        }

        try {
            if (repeat > 1) {
                for (int i = 1; i <= repeat; i++) {
                    LOGGER.info("重复执行第{}次", i);
                    method.invoke(bean);
                }
            } else {
                method.invoke(bean);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
