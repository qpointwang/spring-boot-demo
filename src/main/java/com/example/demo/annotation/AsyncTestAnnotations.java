package com.example.demo.annotation;


import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface AsyncTestAnnotations {

    AsyncTestAnnotation[] value();
}

