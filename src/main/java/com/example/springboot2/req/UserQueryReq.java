package com.example.springboot2.req;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class UserQueryReq extends PageReq{

    private String name;

    private Integer age;

}

