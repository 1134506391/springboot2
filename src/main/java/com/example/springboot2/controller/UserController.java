package com.example.springboot2.controller;


import com.example.springboot2.domain.User;
import com.example.springboot2.req.UserQueryReq;
import com.example.springboot2.req.UserSaveReq;
import com.example.springboot2.req.UserUpdateReq;
import com.example.springboot2.resp.CommonResp;
import com.example.springboot2.resp.PageResp;
import com.example.springboot2.resp.UserQueryResp;
import com.example.springboot2.service.UserService;
import com.example.springboot2.util.JSONResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("user")
@Slf4j
public class UserController {
    @Resource
    private UserService userService;
    @GetMapping("/query-list")
    public CommonResp<PageResp<UserQueryResp>> queryList(@Valid @RequestBody UserQueryReq req) {
        PageResp<UserQueryResp> list = userService.queryList(req);
        return new CommonResp<>(list);
    }

    @PostMapping("/save")
    public CommonResp<Object> save(@Valid @RequestBody UserSaveReq req) {
        userService.save(req);
        return new CommonResp<>();
    }

    @PutMapping("/update")
    public CommonResp<Object> update(@Valid @RequestBody UserUpdateReq user) {
        userService.update(user);
        return new CommonResp<>();
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp<Object> update(@PathVariable Integer id) {
        userService.delete(id);
        return new CommonResp<>();
    }
}
