package com.example.demo.service;

import com.example.demo.annotation.AsyncTestAnnotation;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@AsyncTestAnnotation(name = "test1")
public class AsyncTestServiceA implements AsyncTestService{

    @Async
    public void testAsyncA(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("testAsyncA invoked");
    }

    @Override
    public void test() {

    }
}
