package com.madokast.privacy.learn;

import com.madokast.privacy.learn.bean.Employee;
import com.madokast.privacy.learn.service.EmployeeCacheService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Description
 * RedisLearn
 * <p>
 * Data
 * 21:24
 *
 * @author zrx
 * @version 1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisLearn {
    private final Logger LOGGER = LoggerFactory.getLogger(RedisLearn.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate; //操作字符串

    @Autowired
    private EmployeeCacheService employeeCacheService;

    @Autowired
    private RedisTemplate<String,Employee> employeeRedisTemplate;

    @Test
    public void redisTest(){
        String msg = stringRedisTemplate.opsForValue().get("msg");

        if(msg==null){
            stringRedisTemplate.opsForValue().set("msg","hello redis");
        }

        msg = stringRedisTemplate.opsForValue().get("msg");

        LOGGER.info("msg={}",msg);
        //2020-03-12 21:32:37.656  INFO 9632 --- [           main] com.madokast.privacy.learn.RedisLearn    : msg=hello!!
    }

    @Test
    public void redisJsonTest(){
        Employee employeeById = employeeRedisTemplate.opsForValue().get("emp-2");

        if(employeeById==null){
            employeeById = employeeCacheService.getEmployeeById(2);
        }

        employeeRedisTemplate.opsForValue().set("emp-2",employeeById);
        //{"employeeId":2,"name":"小王","departmentId":101,"date":1583974719000}

        employeeById = employeeRedisTemplate.opsForValue().get("emp-2");

        LOGGER.info("employeeById={}",employeeById);
    }
}
