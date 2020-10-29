package com.example.demo.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author qpointwang
 * @create 2020/10/29 上午10:57
 */
@Component
@ConfigurationProperties("people.teacher")
// 在注解@ConfigurationProperties中配置属性前缀，将于pojo的属性名组成属性的全限定名去配置文件里查找，这样就能将对应的属性读入到pojo中
public class Teacher {
    String name = null;

    String age = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
