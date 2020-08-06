package com.zrx;


import com.zrx.entity.Class;
import com.zrx.mapper.ClassMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationHandler;

/**
 * Description
 * HelloTest
 * 学习源码
 * <p>
 * Data
 * 2020/8/5-19:44
 *
 * @author zrx
 * @version 1.0
 */

public class HelloTest {
    private final static Log LOGGER = LogFactory.getLog(SimpleTest.class);


    @Test
    public void hello() throws IOException {

        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        // mapperProxy
        ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);


        Class classById = mapper.getClassById(1);

        LOGGER.debug(classById.toString());
    }
}
