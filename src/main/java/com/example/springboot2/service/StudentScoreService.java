package com.example.springboot2.service;

import com.example.springboot2.mapper.cust.StudentScoreMapperCust;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class StudentScoreService {
    @Resource
    private StudentScoreMapperCust studentScoreMapperCust;
    public Object queryList() {
        return studentScoreMapperCust.selectSCust();
    }
}
