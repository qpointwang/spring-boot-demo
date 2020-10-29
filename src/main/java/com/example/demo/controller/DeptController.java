package com.example.demo.controller;

import com.example.demo.pojo.Animal;
import com.example.demo.pojo.BusinessPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {

    @Autowired
    BusinessPerson businessPerson;
    @Autowired
    Animal dog;

    // @ResponseBody
    @GetMapping("/test")
    public String test() {
         businessPerson.service();
         dog.use();
//        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
//        Animal animal = ctx.getBean("animal", Animal.class);
//        animal.use();
//        System.out.println(ctx.getBeanDefinitionCount());
        return "qpointwang";
    }
}
