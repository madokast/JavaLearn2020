package com.atguigu.springcloud.entity;


import java.io.Serializable;

/**
 * Description
 * create table if not exists payment (
 *     id
 *         bigint
 *         not null
 *         auto_increment,
 *     serial
 *         varchar(200)
 *         default '',
 *     primary key
 *         (id)
 * )engine=innoDB auto_increment=1 default charset =utf8mb4;
 * <p>
 * Data
 * 2020/4/13-20:50
 *
 * @author zrx
 * @version 1.0
 */

public class Payment implements Serializable {

    private Long id;
    private String serial;

    // getter setter

    public Payment() {
    }

    public Payment(Long id, String serial) {
        this.id = id;
        this.serial = serial;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", serial='" + serial + '\'' +
                '}';
    }
}
