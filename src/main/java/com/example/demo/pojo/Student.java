package com.example.demo.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author qpointwang
 * @create 2020/10/29 上午10:34
 */
@Component
public class Student {

    @Value("${people.student.name}")
    String name = null;

    Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    // @Value也可以加在方法上，读取配置文件
    @Value("${people.student.age}")
    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
