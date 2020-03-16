package com.madokast.privacy.learn.service;

import com.madokast.privacy.learn.bean.Employee;
import com.madokast.privacy.learn.mapper.EmployeeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

/**
 * Description
 * EmployeeRabbitService
 * 消息队列 监听...
 * <p>
 * Data
 * 22:14
 *
 * @author zrx
 * @version 1.0
 */

@Service
public class EmployeeRabbitService {
    private final Logger LOGGER = LoggerFactory.getLogger(EmployeeRabbitService.class);

    private final RabbitTemplate rabbitTemplate;

    private final EmployeeMapper employeeMapper;

    public EmployeeRabbitService(RabbitTemplate rabbitTemplate, EmployeeMapper employeeMapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.employeeMapper = employeeMapper;
    }

    public Employee getEmployeeByIdAndAddToRabbit(Integer id){
        LOGGER.info("数据库查找Employee id={}",id);
        Employee employeeById = employeeMapper.getEmployeeById(id);

        LOGGER.info("发送数据库查找Employee{}到RabbitMq",employeeById);
        rabbitTemplate.convertAndSend("mdk.direct", "miao", employeeById);

        return employeeById;
    }

    @RabbitListener(queues = "miao")
    public void listen(Employee employee){
        LOGGER.info("RabbitMq监听到{}",employee);
    }
}
