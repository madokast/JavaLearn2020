package com.zrx.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Description
 * 访问mybatis数据库
 * <p>
 * Data
 * 23:09
 *
 * @author zrx
 * @version 1.0
 */

@Repository
@Mapper //告诉 mybatis 这是一个操作数据库的mapper
public interface PersonMapper {

    @Select("select * from person where id = #{id}")
    public Person getPersonById(Integer id);

    public static class Person{
        private Integer id;
        private String name;

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
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
    }
}
