package com.madokast.learnspringframework.bean;


/**
 * Description
 * Hello
 * <p>
 *
 * @author madokast
 * @version 1.0
 */

public class Hello {

    private String name;

    private Integer age;

    @Override
    public String toString() {
        return "Hello{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
