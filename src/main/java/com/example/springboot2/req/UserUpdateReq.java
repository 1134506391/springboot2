package com.example.springboot2.req;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserUpdateReq {

    @NotNull(message = "【id】不能为空")
    private Integer id;

    private String name;

    private Integer age;
}
