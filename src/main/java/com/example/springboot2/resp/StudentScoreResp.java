package com.example.springboot2.resp;

import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
public class StudentScoreResp {
    private String sId;

    @NotBlank(message = "username不能为空")
    private String sName;

    private String sSex;

    private String cName;

    private String scScore;
}
