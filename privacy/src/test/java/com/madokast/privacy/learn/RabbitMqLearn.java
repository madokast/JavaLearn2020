package com.madokast.privacy.learn;

import com.madokast.privacy.learn.bean.Employee;
import com.madokast.privacy.learn.service.EmployeeCacheService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Description
 * RabbitMqLearn
 * <p>
 * Data
 * 21:21
 *
 * @author zrx
 * @version 1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqLearn {
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMqLearn.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private EmployeeCacheService employeeCacheService;

    @Test
    public void directTest(){
        LOGGER.info("rabbit mq 单播 direct 测试");

        //需要自己构造 message
        //rabbitTemplate.send(String exchange, String routingKey, Message message);
        //public Message(byte[] body, MessageProperties messageProperties)

        // 自动把 object 转为 message -- 默认 Java 序列化
        //rabbitTemplate.convertAndSend(String exchange, String routingKey, Object message);

        for (int i = 10262; i < 10262+80; i++) {
            final Employee employeeById = employeeCacheService.getEmployeeById(i);
            rabbitTemplate.convertAndSend("mdk.direct", "miao", employeeById);

        }

        for (int i = 10262; i < 10262+79; i++) {

            //接受消息
            final Object miao = rabbitTemplate.receiveAndConvert("miao");
            LOGGER.info("get from miao = {}",miao);
        }
    }

    @Test
    public void fanoutTest(){
        LOGGER.info("rabbit mq 广播 fanout 测试");
    }

    @Test
    public void topicTest(){
        LOGGER.info("rabbit mq 组播 topic 测试");
    }


    @Test
    public void send(){
        for (int i = 10262; i < 10262+50; i++) {
            final Employee employeeById = employeeCacheService.getEmployeeById(i);
            rabbitTemplate.convertAndSend("mdk.direct", "miao", employeeById);
        }
    }


    @RabbitListener(queues = {"miao"})
    public void listen(Employee employee){
        LOGGER.info("RabbitMq监听到{}",employee);
    }

    //----------------在程序中管理 rabbitMq

    @Autowired
    private AmqpAdmin amqpAdmin;

    private void amqpAdminLearn(){
        amqpAdmin.declareExchange(new DirectExchange("exchangeName"));

        amqpAdmin.declareQueue(new Queue("queueName"));

        amqpAdmin.declareBinding(new Binding("queueName",
                Binding.DestinationType.QUEUE,
                "exchangeName","key",null));
    }
}
