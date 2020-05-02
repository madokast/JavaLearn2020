package com.atguigu.springcloud.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Description
 * IMessageProvider
 * <p>
 * Data
 * 2020/4/30-22:41
 *
 * @author zrx
 * @version 1.0
 */

public interface IMessageProvider {

    void send(String message);

}
