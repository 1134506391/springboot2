package com.example.springboot2.controller;

import com.example.springboot2.service.StudentScoreService;
import com.example.springboot2.util.JSONResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("student")
public class StudentController {
    @Resource
    private StudentScoreService studentScoreService;
    @GetMapping("query-list")
    public JSONResult queryList(){
        return JSONResult.ok(studentScoreService.queryList());
    }
}
