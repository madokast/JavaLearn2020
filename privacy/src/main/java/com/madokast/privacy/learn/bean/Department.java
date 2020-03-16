package com.madokast.privacy.learn.bean;

/**
 * Description
 * Department 测试 bean
 *
 * create table department (
 *     did int not null primary key ,
 *     name varchar(30) not null
 * )ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;
 * <p>
 * Data
 * 15:11
 *
 * @author zrx
 * @version 1.0
 */

public class Department {
    //create table department (
    //    did int not null primary key ,
    //    name varchar(30) not null
    //)ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

    private Integer id;
    private String name;

    public Department() {
    }

    public Department(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
