package com.example.springboot2.controller;


import com.example.springboot2.domain.User;
import com.example.springboot2.req.UserReq;
import com.example.springboot2.service.UserService;
import com.example.springboot2.util.JSONResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @Resource
    private UserService userService;
    @GetMapping("list")
    public JSONResult userList(@RequestBody Map<String, Object> req) {
        return JSONResult.ok(userService.queryList(req));
    }

    @PostMapping("/insert")
    public JSONResult insert(@Valid @RequestBody UserReq req) {
        userService.insert(req);
        return JSONResult.ok();
    }

    @PutMapping("/update")
    public JSONResult update(@RequestBody User user) {
        userService.update(user);
        return JSONResult.ok();
    }

    @DeleteMapping("/delete/{id}")
    public JSONResult update(@PathVariable Integer id) {
        userService.delete(id);
        return JSONResult.ok();
    }
}
