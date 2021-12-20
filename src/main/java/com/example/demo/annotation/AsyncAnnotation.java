package com.example.demo.annotation;


import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;

@Component
public class AsyncAnnotation implements InitializingBean {
    @Autowired
    ApplicationContext applicationContext;

    @Override
    public void afterPropertiesSet() {
        Map<String, Object> beans = applicationContext.getBeansWithAnnotation(AsyncTestAnnotation.class);
        System.out.println("AsyncTestAnnotation注解的数量为：" + beans.size());
        System.out.println("-----------------------------------------------------------------------------------------");
        for (String beanName : beans.keySet()) {
            boolean isJdkDynamicProxy = AopUtils.isJdkDynamicProxy(beans.get(beanName));
            boolean isAopProxy = AopUtils.isAopProxy(beans.get(beanName));
            boolean isCglibProxy = AopUtils.isCglibProxy(beans.get(beanName));
            System.out.println("beanName:" + beanName + ", isJdkDynamicProxy:" + isJdkDynamicProxy +
                    ", isAopProxy:" + isAopProxy + ", isCglibProxy:" + isCglibProxy);
        }
        System.out.println("-----------------------------------------------------------------------------------------");
        for (String beanName : beans.keySet()) {
            System.out.println("beanName:" + beanName + ", beanClass:" + beans.get(beanName).getClass());
            AsyncTestAnnotation[] annotations = beans.get(beanName).getClass().getAnnotationsByType(AsyncTestAnnotation.class);
            for (int i = 0; i < annotations.length; i++) {
                System.out.println(annotations[i]);
            }
        }
        System.out.println("-----------------------------------------------------------------------------------------");
        for (String beanName : beans.keySet()) {
            Class<?> beanType = applicationContext.getType(beanName);
            // 当注解不能重复标注在同一个类上时，AnnotatedElementUtils.getMergedRepeatableAnnotations(beanType, AsyncTestAnnotation.class);有如下错误
            // Annotation type must be a repeatable annotation: failed to resolve container type for com.example.demo.annotation.AsyncTestAnnotation
            Set<AsyncTestAnnotation> asyncAnnotationSet = AnnotatedElementUtils.getMergedRepeatableAnnotations(beanType, AsyncTestAnnotation.class);
            System.out.println("beanType:" + beanType + ", " + asyncAnnotationSet);
        }
        System.out.println("-----------------------------------------------------------------------------------------");
        for (String beanName : beans.keySet()) {
            AsyncTestAnnotation asyncTestAnnotation = AnnotationUtils.findAnnotation(beans.get(beanName).getClass(), AsyncTestAnnotation.class);
            System.out.println(asyncTestAnnotation);
            Set<AsyncTestAnnotation> asyncTestAnnotationSet = AnnotationUtils.getRepeatableAnnotations(beans.get(beanName).getClass(), AsyncTestAnnotation.class);
            System.out.println(asyncTestAnnotationSet);
        }
        System.out.println("-----------------------------------------------------------------------------------------");

    }
}
