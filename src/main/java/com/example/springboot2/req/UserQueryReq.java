package com.example.springboot2.req;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true) //要加上callSuper = true，否则extends不生效
@Schema(description = "用户响应")
public class UserQueryReq extends PageReq{
    @Schema(description = "用户姓名", example = "张三")
    private String name;
    @Schema(description = "用户年龄", example = "10")
    private Integer age;

}

