package com.example.demo.pojo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Component
public class BusinessPerson implements Person, BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {
    Logger logger = LoggerFactory.getLogger(BusinessPerson.class);
    @Autowired
    @Qualifier("pig")
    private Animal animal = null;

//    public BussinessPerson(@Autowired @Qualifier("dog") Animal animal) {
//        logger.info("依赖注入");
//        this.animal = animal;
//    }

    @Override
    public void service() {
        this.animal.use();
    }

    @Override
    public void setAnimal(Animal animal) {
        System.out.println("setAnimal");
        this.animal = animal;
    }

    // 实现BeanNameAware接口，Spring将Bean的Id传递给setBeanName()方法
    @Override
    public void setBeanName(String s) {
        logger.info("1.实现BeanNameAware接口，Bean的名字为：" + s);
    }

    // Bean实现了BeanFactoryAware接口，调用setBeanFactory，将BeanFactory容器实例传入
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        logger.info("2.Bean实现了BeanFactoryAware接口，调用setBeanFactory，将BeanFactory容器实例传入");
    }

    // Bean实现了ApplicationContextAware接口，Spring将调用Bean的setApplicationContext()方法，将bean所在应用上下文引用传入进来。
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        logger.info("3.Bean实现了ApplicationContextAware接口");
    }

    @PostConstruct
    public void init() {
        logger.info("5.注解@PostConstruct定义的自定义初始化方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("6.Bean实现了InitializingBean接口，调用afterPropertiesSet方法");
    }

    // 以下两个销毁方法
    // 在主动调用会执行；或者程序结束时bean死亡前会执行
    @PreDestroy
    public void selfDestroy() {
        logger.info("7.注解@PreDestroy的自定义销毁方法");
    }

    @Override
    public void destroy() throws Exception {
        // 该方法内需要定义destroy()真正销毁bean的方法体
        logger.info("8.Bean实现了DisposableBean接口，调用destroy方法");
    }

//    @Autowired
//    public void getAnimal() {
//        System.out.println("getAnimal");
//    }
}
