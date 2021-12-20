package com.example.demo.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(AsyncTestAnnotations.class)
@Inherited
public @interface AsyncTestAnnotation {
    String name(); // 限频器名字

    int interval() default 1000; // 时间间隔，单位为毫秒

    int maxInterval() default 20; // 单位时间间隔内允许的最大次数
}
