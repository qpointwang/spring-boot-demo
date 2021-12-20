package com.example.demo.service;

import com.example.demo.annotation.AsyncTestAnnotation;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@AsyncTestAnnotation(name = "test3")
@AsyncTestAnnotation(name = "test4")
public class AsyncTestServiceC{

    @Async
    public void testAsyncC(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("testAsyncC invoked");
    }

}
