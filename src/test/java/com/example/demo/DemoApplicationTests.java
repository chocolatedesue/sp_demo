package com.example.demo;

import com.example.demo.entity.teacher;
import com.example.demo.mapper.teacherMapper;
import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
    @Mapper
    @Autowired
    teacherMapper mapper;
    @Test
    void contextLoads() {
        mapper.addTeacher(new teacher("张三"));
    }

}
