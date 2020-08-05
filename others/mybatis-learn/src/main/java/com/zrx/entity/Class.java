package com.zrx.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * Description
 * 班级
 * create table tb_class
 * (
 *     `id`   int(11) primary key auto_increment comment '班级编号',
 *     `name` varchar(255) comment '班级名'
 * );
 * <p>
 * Data
 * 2020/8/3-13:55
 *
 * @author zrx
 * @version 1.0
 */

@Data
@ToString
public class Class implements Serializable {

    private Integer id;

    private String name;

}
