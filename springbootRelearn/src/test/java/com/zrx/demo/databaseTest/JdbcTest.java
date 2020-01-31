package com.zrx.demo.databaseTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Description
 * 使用jdbc访问数据库的测试
 * <p>
 * Data
 * 21:52
 *
 * @author zrx
 * @version 1.0
 */

@SpringBootTest
public class JdbcTest {
    @Autowired
    private DataSource dataSource;

    @Test
    public void dataSourceInject() throws SQLException {
        System.out.println("dataSource = " + dataSource);
        System.out.println("dataSource.getClass() = " + dataSource.getClass());

        //dataSource = HikariDataSource (null)
        //dataSource.getClass() = class com.zaxxer.hikari.HikariDataSource

        Connection connection = dataSource.getConnection();

        //connection = HikariProxyConnection@1994834032 wrapping com.mysql.cj.jdbc.ConnectionImpl@184afb78

        System.out.println("connection = " + connection);

        connection.close();
    }

    //换druid后
    //dataSource = {
    //	CreateTime:"2020-01-30 22:09:45",
    //	ActiveCount:0,
    //	PoolingCount:0,
    //	CreateCount:0,
    //	DestroyCount:0,
    //	CloseCount:0,
    //	ConnectCount:0,
    //	Connections:[
    //	]
    //}
    //dataSource.getClass() = class com.alibaba.druid.pool.DruidDataSource
    //connection = com.mysql.cj.jdbc.ConnectionImpl@2f09e6b2
}
