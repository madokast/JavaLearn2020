package com.zrx.mapper;

import com.zrx.entity.Class;

import java.util.List;

public interface ClassMapper {

    Class getClassById(Integer id);

    void add(Class c);

    void update(Class c);

    void deleteById(Integer id);

    List<Class> selectNameLike(String name);
}
