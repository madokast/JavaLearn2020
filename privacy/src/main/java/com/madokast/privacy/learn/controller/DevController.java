package com.madokast.privacy.learn.controller;

import com.madokast.privacy.learn.bean.Employee;
import com.madokast.privacy.learn.service.EmployeeRabbitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Description
 * DevController
 * 测试热部署
 * <p>
 * Data
 * 21:35
 *
 * @author zrx
 * @version 1.0
 */

@RestController
public class DevController {
    private final Logger LOGGER = LoggerFactory.getLogger(DevController.class);

    private final EmployeeRabbitService employeeRabbitService;

    public DevController(EmployeeRabbitService employeeRabbitService) {
        this.employeeRabbitService = employeeRabbitService;
    }

    @GetMapping("/dev")
    public Object dev(){
        Employee employeeByIdAndAddToRabbit = employeeRabbitService.getEmployeeByIdAndAddToRabbit(2);

        LOGGER.info("employeeByIdAndAddToRabbit = {}", employeeByIdAndAddToRabbit);

        return employeeByIdAndAddToRabbit;
    }
}
