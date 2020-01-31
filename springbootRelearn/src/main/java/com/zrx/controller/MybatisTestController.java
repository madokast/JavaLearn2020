package com.zrx.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zrx.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


/**
 * Description
 * 学习配置mybatis
 * <p>
 * Data
 * 23:15
 *
 * @author zrx
 * @version 1.0
 */

@RestController
public class MybatisTestController {
    @Autowired
    PersonMapper personMapper;

    ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/person/{id}")
    public PersonMapper.Person getPersonById(@PathVariable("id") Integer id)
            throws JsonProcessingException {
        return personMapper.getPersonById(id);
    }
}
