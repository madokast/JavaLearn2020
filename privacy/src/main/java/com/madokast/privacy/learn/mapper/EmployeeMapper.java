package com.madokast.privacy.learn.mapper;

import com.madokast.privacy.learn.bean.Employee;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * mybatis 注解类
 * Employee
 *
 *     //    //create table Employee (
 *     //    //    eid int not null auto_increment primary key ,
 *     //    //    name varchar(30) not null ,
 *     //    //    deptId int not null ,
 *     //    //    createTime timestamp
 *     //    //)ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;
 *     //
 *     //    Integer employeeId;
 *     //    String name;
 *     //    Integer departmentId;
 *     //    Date date;
 */

@Repository
@Mapper
public interface EmployeeMapper {
    @Select("SELECT * FROM employee WHERE eid = #{id}")
    @Results({
            @Result(property = "employeeId",column = "eid",id = true),
            @Result(property = "departmentId",column = "deptId"),
            @Result(property = "date",column = "createTime")
    })
    Employee getEmployeeById(Integer id);

    @Select("SELECT * FROM employee")
    @Results({
            @Result(property = "employeeId",column = "eid",id = true),
            @Result(property = "departmentId",column = "deptId"),
            @Result(property = "date",column = "createTime")
    })
    List<Employee> getEmployees();

    @Insert("insert into employee (eid, name, deptId) VALUES (#{employeeId},#{name},#{departmentId});")
    void insertEmployee(Employee employee);
}
