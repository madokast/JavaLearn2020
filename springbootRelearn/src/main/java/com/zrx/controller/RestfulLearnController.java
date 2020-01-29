package com.zrx.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zrx.SpringbootRelearnApplication;
import com.zrx.utils.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Description
 * 学习RESTFUL
 * <p>
 * Data
 * 15:05
 *
 * @author zrx
 * @version 1.0
 */

@CrossOrigin
@RestController
public class RestfulLearnController {
    private final ObjectMapper mapper = new ObjectMapper();

    @GetMapping("/emp/{id}")
    public String getEmp(@PathVariable("id") Integer id) throws JsonProcessingException {
        Logger.getLogger().info("/emp收到添加请求：" + id);
        return mapper.writeValueAsString(map.getOrDefault(id, new Employee(404, "员工不存在")));
    }

    @GetMapping("/emps")//GET 请求，获取全部数据
    public String list() throws JsonProcessingException {
        Logger.getLogger().info("/emps被访问（获取员工列表）");
        return mapper.writeValueAsString(map.values().toArray());
    }

    @PostMapping("/emp") //POST 请求，上传数据
    //使用@RequestBody 自动识别请求为application/json 然后封装为对象
    public String addEmps(@RequestBody Employee employee) throws JsonProcessingException {
        Logger.getLogger().info("/emp收到添加请求（添加员工）：" + employee);
        map.put(employee.id, employee);
        return mapper.writeValueAsString(new Employee(200, "OK"));
    }

    @PutMapping("/emp") //PUT 请求，修改员工
    public String updateEmp(@RequestBody Employee employee) throws JsonProcessingException {
        Logger.getLogger().info("/emp/{id} 修改员工" + employee);
        if (map.containsKey(employee.id)) {
            Employee oldEmp = map.get(employee.id);
            map.put(employee.id, employee);
            Logger.getLogger().info("成功修改员工" + employee);

            return mapper.writeValueAsString(oldEmp);
        } else {
            Logger.getLogger().info("要修改的员工不存在");
            return mapper.writeValueAsString(new Employee(404, "要修改的员工不存在"));
        }
    }

    @DeleteMapping("/emp/{id}")
    public String delEmp(@PathVariable("id") Integer id) throws JsonProcessingException{
        Logger.getLogger().info("/emp/{id} 删除员工" + id);
        Employee employee = map.getOrDefault(id, null);
        if(employee==null){
            Logger.getLogger().info("要删除的员工不存在");
            return mapper.writeValueAsString(new Employee(404, "要删除的员工不存在"));
        }else {
            Logger.getLogger().info("员工" + employee + "删除成功");
            map.remove(id);
            return mapper.writeValueAsString(employee);
        }
    }


    //数据
    Map<Integer, Employee> map = new HashMap<>();

    {
        for (int i = 0; i < 25; i++) {
            map.put(101 + i,
                    new Employee(101 + i, String.valueOf((char) ('a' + i)).repeat(3))
            );
        }
    }


    //员工类
    private static class Employee {
        private Integer id;
        private String name;

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }

        public Employee() {

        }

        public Employee(Integer id, String name) {
            this.id = id;
            this.name = name;
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
