package com.example.demo.fragment;

import com.example.demo.Invoking;
import com.example.demo.utils.ThreadUtils;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

/**
 * Description
 * 学习 MONO 和 FLUX
 * <p>
 * Data
 * 2020/3/17-22:00
 *
 * @author zrx
 * @version 1.0
 */

@Component
@Invoking(createdTime = "2020-03-17 22:53",info = "学习 MONO 和 FLUX",details = {
        "MONO 0/1",
        "FLUX 0-n"
})
public class ReactorLearn {
    private final static Logger LOGGER = LoggerFactory.getLogger(ReactorLearn.class);

    @Invoking(createdTime = "2020-03-17 22:54",info = "流+响应式流")
    public void learn(){
        // reactor = 流 和 响应式流

        Flux.fromArray(new String[]{"1","2","3"})
                .map(Integer::parseInt)
        //以上是 流
        //以下是 响应式流
        .subscribe(subscriber());
    }

    @Invoking(createdTime = "2020-03-17 22:55",info = "latest",repeat = 3,details = {
            "完成了@Invoking注解和MethodRunner.latest方法",
            "现在是2020年3月18日00点21分"
    })
    public void latest(){
        LOGGER.info("latest");
    }

    @SuppressWarnings("all")
    private Subscriber<Integer> subscriber(){
        return new Subscriber<Integer>() {

            private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

            private Subscription subscription;

            @Override
            public void onSubscribe(Subscription subscription) {
                // 保持订阅关系，用它来给发布者相应
                this.subscription = subscription;

                //请求一个数据
                this.subscription.request(1);
            }

            @Override
            public void onNext(Integer integer) {
                //处理数据
                LOGGER.info("subscriber接收数据{}",integer);

                //休息1秒 处理数据..
                ThreadUtils.sleep(1000);

                //处理完后再请求数据
                this.subscription.request(1);

                //或者不再接受数据
                //this.subscription.cancel();
            }

            @Override
            public void onError(Throwable throwable) {
                LOGGER.error("subscriber收到异常");
                throwable.printStackTrace();

                //不再接受数据
                this.subscription.cancel();
            }

            @Override
            public void onComplete() {
                LOGGER.info("subscriber所有数据处理完毕");
            }
        };
    }
}
