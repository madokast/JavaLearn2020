package com.zrx;


import com.zrx.entity.Class;
import com.zrx.mapper.ClassMapper;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Properties;

/**
 * Description
 * 插件开发测试
 * <p>
 * Data
 * 2020/8/6-22:00
 *
 * @author zrx
 * @version 1.0
 */

public class PluginTest {
    private final static Log LOGGER = LogFactory.getLog(PluginTest.class);

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

    class LogInterceptor implements Interceptor {
        private final Log LOGGER = LogFactory.getLog(LogInterceptor.class);

        Properties properties = null;

        @Override
        public Object intercept(Invocation invocation) throws Throwable {
            LOGGER.debug("intercept(Invocation invocation) + " + invocation.toString());
            return invocation.proceed();
        }

        @Override
        public Object plugin(Object target) {
            LOGGER.debug("plugin(Object target) + " + target.toString());
            return target;
        }

        @Override
        public void setProperties(Properties properties) {
            LOGGER.debug("setProperties(properties) = " + properties.toString());
            this.properties = properties;
        }
    }

}
