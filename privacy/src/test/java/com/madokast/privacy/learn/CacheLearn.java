package com.madokast.privacy.learn;

import com.madokast.privacy.PrivacyApplication;
import com.madokast.privacy.learn.bean.Department;
import com.madokast.privacy.learn.bean.Employee;
import com.madokast.privacy.learn.controller.EmployeeController;
import com.madokast.privacy.learn.mapper.DepartmentMapper;
import com.madokast.privacy.learn.mapper.EmployeeMapper;
import com.madokast.privacy.utils.RandomUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.awt.image.IndexColorModel;
import java.util.List;

/**
 * Description
 * CacheLearn 测试
 * <p>
 * Data
 * 15:30
 *
 * @author zrx
 * @version 1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheLearn {
    private final Logger LOGGER = LoggerFactory.getLogger(CacheLearn.class);

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    DepartmentMapper departmentMapper;

    @Test
    public void employeeMapperTest() throws Exception{
        final Employee employeeById = employeeMapper.getEmployeeById(1);
        LOGGER.info("{}",employeeById);
    }

    @Test
    public void departmentMapperTest(){
        final Department departmentById = departmentMapper.getDepartmentById(100);
        LOGGER.info("{}",departmentById);
    }


    @After
    public void clear(){

    }

    @Before
    public void addData(){
        for (int i = 10258; i < 10258+100; i++) {
            Employee employeeById = employeeMapper.getEmployeeById(i);

            if(employeeById==null){
                employeeById = new Employee(i, RandomUtils.randomName(),
                        RandomUtils.randomInt(100,101));

                employeeMapper.insertEmployee(employeeById);
            }
        }

        LOGGER.info("数据添加成功");
        final List<Employee> employees = employeeMapper.getEmployees();
        final List<Department> departments = departmentMapper.getDepartments();
        LOGGER.info("employees.size = {}",employees.size());
        LOGGER.info("departments.size = {}",departments.size());
    }
}
