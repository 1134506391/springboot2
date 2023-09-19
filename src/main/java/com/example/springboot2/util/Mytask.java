package com.example.springboot2.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

@Configuration
@EnableScheduling
@Slf4j
public class Mytask {
    @Scheduled(cron = "*/5 * * * * ?")
    public void publishMsg(){
        log.warn("开始执行任务:"+ LocalDateTime.now());
    }
}
