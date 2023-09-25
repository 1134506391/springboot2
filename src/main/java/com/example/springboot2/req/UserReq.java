package com.example.springboot2.req;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Data
@ToString
public class UserReq {
    private Integer id;

    @NotBlank(message = "username不能为空")
    private String name;

    private Integer age;
}
