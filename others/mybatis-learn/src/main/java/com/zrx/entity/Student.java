package com.zrx.entity;


import lombok.Data;
import lombok.ToString;

/**
 * Description
 * 学生 没有冗余字段
 * create table tb_student
 * (
 *     `id`       int(11) primary key auto_increment comment '学生编号',
 *     `class_id` int(11) comment '所属班级编号',
 *     `name`     varchar(255) comment '学生性名'
 *
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
public class Student {

    private Integer id;

    private Integer classId;

    private String name;
}

