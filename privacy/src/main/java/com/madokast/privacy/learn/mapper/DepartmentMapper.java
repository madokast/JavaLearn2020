package com.madokast.privacy.learn.mapper;

import com.madokast.privacy.learn.bean.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Description
 * DepartmentMapper
 *     //create table department (
 *     //    did int not null primary key ,
 *     //    name varchar(30) not null
 *     //)ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;
 *
 *     private Integer id;
 *     private String name;
 * <p>
 * Data
 * 16:30
 *
 * @author zrx
 * @version 1.0
 */

@Repository
@Mapper
public interface DepartmentMapper {

    @Select("SELECT * FROM department WHERE did = #{id}")
    @Results({
            @Result(property = "id",column = "did",id = true)
    })
    Department getDepartmentById(int id);


    @Select("SELECT * FROM department")
    @Results({
            @Result(property = "id",column = "did",id = true)
    })
    List<Department> getDepartments();


}
