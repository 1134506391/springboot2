package com.example.springboot2.controller;

import com.example.springboot2.util.MyAsyncTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("test")
@Slf4j
public class TestController {
    @Autowired
    private MyAsyncTask myAsyncTask;

    @GetMapping("getAsyncTask")
    public String getMyConfig() {
        myAsyncTask.publishMsg();
        log.info("这是跳过异步任务的执行");
        return "这是跳过异步任务的执行";
    }
}
