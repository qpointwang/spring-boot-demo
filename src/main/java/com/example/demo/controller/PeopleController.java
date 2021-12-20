package com.example.demo.controller;

import com.example.demo.mapper.PeopleMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: cheewang
 * @date: 2021/10/12 9:04 下午
 */
@RestController
@Slf4j
public class PeopleController {

    @Autowired
    PeopleMapper peopleMapper;

//    @GetMapping("/test")
//    public String test() {
//        log.info("-------------{}-------------", "start");
//        peopleMapper.getPeople();
//        log.info("-------------{}-------------", " end ");
//        return "cheewang";
//    }
}
