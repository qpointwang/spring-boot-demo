package com.example.demo.controller;

import com.example.demo.AppConfig;
import com.example.demo.pojo.Animal;
import com.example.demo.pojo.BusinessPerson;
import com.example.demo.pojo.Student;
import com.example.demo.pojo.Teacher;
import com.example.demo.scope.ScopeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {

    @Autowired
    ApplicationContext applicationContext;
    @Autowired
    BusinessPerson businessPerson;
    @Autowired
    Animal dog;
    @Autowired
    Student student;
    @Autowired
    Teacher teacher;

    @GetMapping("/test")
    public String test() {
        businessPerson.service();
        dog.use();
        System.out.println(student.toString());
        System.out.println(teacher.toString());
//        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
//        Animal animal = ctx.getBean("animal", Animal.class);
//        animal.use();
//        System.out.println(ctx.getBeanDefinitionCount());
        return "qpointwang";
    }

    @GetMapping("/scope")
    public String scope() {
        ScopeBean scopeBean1 = applicationContext.getBean(ScopeBean.class);
        ScopeBean scopeBean2 = applicationContext.getBean(ScopeBean.class);
        System.out.println(scopeBean1 == scopeBean2);
        return "qpointwang";
    }

    @RequestMapping
    public String cheewang(){
        System.out.println("hhhhhh");
        return "cheewang";
    }
}
