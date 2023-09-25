package com.example.springboot2;

import com.example.springboot2.domain.Student;
import com.example.springboot2.domain.User;
import com.example.springboot2.req.UserReq;
import com.example.springboot2.service.StudentScoreService;
import com.example.springboot2.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class Springboot2ApplicationTests {

    @Autowired
    private StudentScoreService studentScoreService;

    @Test
    void contextLoads() {
    }

    @Test
    public void testInsertUser(){

       log.info("queryList:"+studentScoreService.queryList());

    }

}
