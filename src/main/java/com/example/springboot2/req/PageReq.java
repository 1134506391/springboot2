package com.example.springboot2.req;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Data
@ToString(callSuper = true)
public class PageReq {
    @NotNull(message = "【页码】不能为空")
    private Integer page;


    @NotNull(message = "【每页条数】不能为空")
    @Max(value = 100, message = "【每页条数】不能超过100")
    private Integer size;
}
