package com.example.demo;

import com.example.demo.pojo.BusinessPerson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
// @ComponentScan(lazyInit = true)
public class DemoApplication {
    private Logger log = LoggerFactory.getLogger(DemoApplication.class);

    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = SpringApplication.run(DemoApplication.class, args);

//        BusinessPerson businessPerson = applicationContext.getBean(BusinessPerson.class);
//        System.out.println(applicationContext.getBean("businessPerson"));
//        businessPerson.service();
//        businessPerson.selfDestroy();
//        businessPerson.destroy();
    }

}
