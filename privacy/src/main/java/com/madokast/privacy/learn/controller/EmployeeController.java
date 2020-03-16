package com.madokast.privacy.learn.controller;

import com.madokast.privacy.learn.bean.Employee;
import com.madokast.privacy.learn.service.EmployeeCacheService;
import com.madokast.privacy.learn.service.EmployeeRabbitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description
 * EmployeeController
 * <p>
 * Data
 * 17:04
 *
 * @author zrx
 * @version 1.0
 */

@RestController
@RequestMapping("/learn")
public class EmployeeController {
    Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    private final EmployeeCacheService employeeService;

    private final EmployeeRabbitService employeeRabbitService;

    public EmployeeController(EmployeeCacheService employeeService, EmployeeRabbitService employeeRabbitService) {
        this.employeeService = employeeService;
        this.employeeRabbitService = employeeRabbitService;
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable Integer id){
        LOGGER.info("网络请求查询{}号员工",id);
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/employee/{id}/send")
    public Employee send(@PathVariable Integer id){
        LOGGER.info("网络搜索employee[{}]并送至RabbitMq", id);
        return employeeRabbitService.getEmployeeByIdAndAddToRabbit(id);
    }
}
