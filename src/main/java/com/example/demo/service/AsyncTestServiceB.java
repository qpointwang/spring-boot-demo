package com.example.demo.service;

import com.example.demo.annotation.AsyncTestAnnotation;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@AsyncTestAnnotation(name = "test2")
public class AsyncTestServiceB implements AsyncTestService{

    public void testAsyncB(){
        try {
            TimeUnit.SECONDS.sleep(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("testAsyncB invoked");
    }

    @Override
    public void test() {

    }
}
