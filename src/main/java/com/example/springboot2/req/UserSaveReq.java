package com.example.springboot2.req;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@ToString
public class UserSaveReq {

    private Integer id;

    @NotNull(message = "【name】不能为空")
    private String name;

    @NotNull(message = "【age】不能为空")
    private Integer age;
}
