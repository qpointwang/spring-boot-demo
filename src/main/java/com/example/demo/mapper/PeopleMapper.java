package com.example.demo.mapper;

import com.example.demo.pojo.People;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: cheewang
 * @date: 2021/10/12 9:04 下午
 */
@Mapper
public interface PeopleMapper {

    List<People> getPeople();
}
