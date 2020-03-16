package com.madokast.privacy.learn.bean;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.madokast.privacy.learn.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Description
 * Employee 测试 bean
 * create table Employee (
 *     eid int not null auto_increment primary key ,
 *     name varchar(30) not null ,
 *     deptId int not null ,
 *     createTime timestamp
 * )ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;
 * <p>
 * Data
 * 15:09
 *
 * @author zrx
 * @version 1.0
 */

public class Employee implements Serializable {

    //create table Employee (
    //    eid int not null auto_increment primary key ,
    //    name varchar(30) not null ,
    //    deptId int not null ,
    //    createTime timestamp
    //)ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

    Integer employeeId;
    String name;
    Integer departmentId;
    Date date;

    public Employee() {
    }

    public Employee(Integer employeeId, String name, Integer departmentId) {
        this.employeeId = employeeId;
        this.name = name;
        this.departmentId = departmentId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String ret = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);

            return ret.replaceAll("[\r\n]","");
        }catch (Exception e){
            e.printStackTrace();
            return "Employee{" +
                    "employeeId=" + employeeId +
                    ", name='" + name + '\'' +
                    ", departmentId=" + departmentId +
                    ", date=" + date +
                    '}';
        }

    }


}
