package com.example.demo.life;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author qpointwang
 * @create 2020/10/28 下午9:02
 */
@Component
public class BeanPostProcessorExample implements BeanPostProcessor {
    Logger logger = LoggerFactory.getLogger(BeanPostProcessorExample.class);

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("businessPerson")) {
            logger.info("4.Before " + beanName);
        }
        //System.out.println("4.Before " + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("businessPerson")) {
            logger.info("4.After " + beanName);
        }
        return bean;
    }

}
