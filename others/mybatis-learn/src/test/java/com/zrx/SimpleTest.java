package com.zrx;


import com.zrx.entity.Class;
import com.zrx.mapper.ClassMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.List;

/**
 * Description
 * 单表查询
 * <p>
 * Data
 * 2020/8/3-14:02
 *
 * @author zrx
 * @version 1.0
 */

public class SimpleTest {
    private final static Log LOGGER = LogFactory.getLog(SimpleTest.class);

    /**
     * 不能把 SqlSession 放出来，因为线程不安全
     */
    SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void init() throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");

        sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
    }

    @Test
    public void select() {

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            LOGGER.debug(sqlSession.toString());

            ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);

            Class classById = mapper.getClassById(1);

            LOGGER.debug(classById.toString());
        }

    }

    @Test
    public void insert() {

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);

            Class cla = new Class();
            cla.setName("202003班");


            mapper.add(cla);

            // 手动提交
            sqlSession.commit();

            LOGGER.debug(cla.toString());
        }

    }

    @Test
    public void update() {

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);

            Class cla = new Class();
            cla.setId(3);
            cla.setName("202003班");


            mapper.update(cla);

            // 手动提交
            sqlSession.commit();

            LOGGER.debug(cla.toString());
        }

    }

    @Test
    public void del() {

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);

            mapper.deleteById(3);

            // 手动提交
            sqlSession.commit();
        }

    }


    @Test
    public void like() {

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);

            List<Class> classes = mapper.selectNameLike("%2020%");

            for (Class aClass : classes) {
                LOGGER.debug(aClass.toString());
            }
        }

    }
}
