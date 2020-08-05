package com.zrx.entity;


import lombok.Data;
import lombok.ToString;

/**
 * Description
 * 学生 有冗余字段
 * create table tb_student
 * create table tb_student2
 * (
 * `id`         int(11) primary key auto_increment comment '学生编号',
 * `class_id`   int(11) comment '所属班级编号',
 * `class_name` varchar(255) comment '所属班级名字',
 * `name`       varchar(255) comment '学生性名'
 * <p>
 * );
 * <p>
 * Data
 * 2020/8/3-13:58
 *
 * @author zrx
 * @version 1.0
 */

@Data
@ToString
public class Student2 {

    private Integer id;

    private Integer classId;

    private String className;


    private String name;
}

