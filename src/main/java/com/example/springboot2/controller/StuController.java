package com.example.springboot2.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("stu")
@Slf4j
public class StuController {
    @GetMapping("{stuId}/get")
    public String getStu(@PathVariable("stuId") String stuId,
                         @RequestParam Integer id,
                         @RequestParam String name){
        log.info("stuId="+stuId);
        log.info("id="+id);
        log.info("name="+name);
        return "查询stuId";
    }

    @PostMapping("create")
    public String createStu(@RequestBody Map<String, Object> map,
                            @RequestHeader("token") String token,
                            @CookieValue("clientId") String clientId,
                            HttpServletRequest request) {
        log.info("token=" + token);
        log.info("clientId=" + clientId);
        log.info("map=" + map.toString());

        String headerToken = request.getHeader("token");
        log.info("token=" + headerToken);
        return "新增Stu";
    }

    @PutMapping("update")
    public String updateStu(){
        return "修改Stu";
    }

    @DeleteMapping("delete")
    public String deleteStu(){
        return "删除Stu";
    }
}
