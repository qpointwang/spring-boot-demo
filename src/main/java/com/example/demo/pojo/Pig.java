package com.example.demo.pojo;

import org.springframework.stereotype.Component;

@Component
//@Primary // @Primary告诉IoC容器，当发现多个同样类型的bean时，请优先使用这个进行注入。
public class Pig implements Animal {
    @Override
    public void use() {
        System.out.println("Pig");
    }
}
