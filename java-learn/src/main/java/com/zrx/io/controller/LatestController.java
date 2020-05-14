package com.zrx.io.controller;

import com.zrx.Invoking;
import com.zrx.utils.Container;
import com.zrx.utils.ThreadUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Description
 * LatestController
 * 执行最新 invoke 方法
 * <p>
 * Data
 * 2020/5/10-17:42
 *
 * @author zrx
 * @version 1.0
 */

@RequestMapping("/latest")
@RestController
@CrossOrigin
public class LatestController {
    private final static Logger LOGGER = LoggerFactory.getLogger(LatestController.class);

    private final static AtomicInteger ATOMIC_INTEGER = new AtomicInteger(0);

    /**
     * spring 容器
     */
    private final ApplicationContext applicationContext;

    public LatestController(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @GetMapping("/just")
    @SuppressWarnings("all")
    public void latest() {
        Thread t = ThreadUtils.newThread(this::latest0, "latest-" + ATOMIC_INTEGER.getAndAdd(1));
        t.start();

        ThreadUtils.sleep(2000);

        if (t.isAlive()) {
            LOGGER.error("latest方法运行超时，强制停止");
            t.stop();
        }
    }


    private void latest0() {
        // LOGGER.info("运行最新方法");
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


        Invoking classInvoking = bean.getClass().getAnnotation(Invoking.class);
        String classInfo = classInvoking.info();
        String[] classDetails = classInvoking.details();

        Invoking methodInvoking = method.getAnnotation(Invoking.class);
        String methodInfo = methodInvoking.info();
        String[] MethodDetails = methodInvoking.details();
        int repeat = methodInvoking.repeat();

        LOGGER.info("[{}-{}] run [{}]", classInfo, methodInfo, methodName);

        for (String detail : classDetails) {
            LOGGER.info("[{}]", detail);
        }
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
            LOGGER.error("{}",e.toString());
        }
    }
}
