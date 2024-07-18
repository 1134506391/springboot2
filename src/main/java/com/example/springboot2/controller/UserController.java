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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("user")
@Slf4j
@Tag(name = "用户管理", description = "用户管理相关接口")
public class UserController {
    @Resource
    private UserService userService;
    @GetMapping("/query-list")

    @Operation(
            summary = "获取所有用户",
            description = "获取所有用户信息",

            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                description = "用户信息",
                required = true,
                content = {
                        @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = UserQueryReq.class)
                        )
            }),
            responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "响应成功",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(
                                        title = "UserQueryReq和PageResp组合模型",
                                        description = "返回实体，AjaxResult内data为" +
                                                "UserQueryReq模型(并且PageResp为集合)",
                                        anyOf = {UserQueryReq.class, PageResp.class})

                        )
                )
            }
    )
    public CommonResp<PageResp<UserQueryResp>> queryList(
            @Parameter(description = "用户实体", required = true,
                    examples = @ExampleObject(
                    name = "example",
                    summary = "示例用户查询请求体",
                    value = "{\"name\":\"张\", \"pageNum\":1, \"pageSize\":10}"
            ))
            @Valid @RequestBody UserQueryReq req) {
        PageResp<UserQueryResp> list = userService.queryList(req);
        return new CommonResp<>(list);
    }

    @PostMapping("/save")
    @Operation(summary = "保存用户", description = "保存用户信息")
    public CommonResp<Object> save(@Valid @RequestBody UserSaveReq req) {
        userService.save(req);
        return new CommonResp<>();
    }

    @PutMapping("/update")
    @Operation(summary = "修改用户", description = "修改用户信息")
    public CommonResp<Object> update(@Valid @RequestBody UserUpdateReq user) {
        userService.update(user);
        return new CommonResp<>();
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "删除用户", description = "删除用户信息")
    public CommonResp<Object> update( @Parameter(description = "用户id",example = "1",required = true)  @PathVariable Integer id) {
        userService.delete(id);
        return new CommonResp<>();
    }
}
