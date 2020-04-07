package com.zrx.ichiwanspringboot.mapper;

import com.zrx.ichiwanspringboot.bean.EntryItem;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Description
 * 查找数据库
 * <p>
 * Data
 * 22:45
 *
 * @author zrx
 * @version 1.0
 */

@Mapper
@Repository
public interface EntryMapper {
    @Select("select id, dateDone, name, lengthMinute, describing, deleteBool from entries")
    List<EntryItem> findAll();

    @Select("select id, dateDone, name, lengthMinute, describing, deleteBool from entries where dateDone=#{date, jdbcType=DATE}")
    List<EntryItem> findEntryItemsAt(Date date);

    @Select("select dateDone from entries\n" +
            "where id=(select min(id) from entries where deleteBool=false)")
    Date firstDate();

    @Insert("INSERT INTO entries(dateDone, name, lengthMinute, describing) values(#{dateDone},#{name},#{lengthMinute},#{describing})")
    void insert(EntryItem entryItem);

    /**
     * 将表中最后一个 deleteBool = FALSE 的项，置为 TRUE
     * 因为 MySQL 不能在一条 SQL 中查询 A 表又修改 A 表，所以语句才这么繁琐
     * 欺骗 MySQL 查询的是一个叫 sub 的表
     */
    @Update("UPDATE entries AS e SET e.deleteBool = TRUE WHERE e.id = (\n" +
            "    SELECT maxid FROM (SELECT MAX(ee.id) AS maxid FROM entries ee WHERE ee.deleteBool = FALSE) AS sub)")
    void deleteLastOne();


}
