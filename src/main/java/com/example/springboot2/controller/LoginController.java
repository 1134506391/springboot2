package com.example.springboot2.controller;

import com.example.springboot2.util.JSONResult;
import com.example.springboot2.util.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController()
@RequestMapping("login")
@Slf4j
public class LoginController {

    @PostMapping("")
    public JSONResult login(@RequestBody Map<String, Object> map){
        String username = (String) map.get("username");
        String password = (String) map.get("password");
        Boolean isAge = map.containsKey("age");
        if(map.containsKey("age")){
            log.info("aaa"+isAge);
        }else{
            log.info("bbb"+isAge);
        }


        if(!(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("123456"))){
            return JSONResult.errorMsg("账号密码错误");
        }

        String token = JWTUtils.createToken(username.toString());
        Map<String,Object> res = new HashMap<>();
        res.put("token",token);

        return JSONResult.ok(res);
    }
}
