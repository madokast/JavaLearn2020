package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Description
 * PaymentDao
 * <p>
 * Data
 * 2020/4/13-20:58
 *
 * @author zrx
 * @version 1.0
 */

@Mapper
public interface PaymentDao {

    int create(Payment payment);

    Payment getById(@Param("id") Long id);

}
