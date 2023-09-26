package com.example.springboot2;

import com.example.springboot2.service.StudentScoreService;
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
