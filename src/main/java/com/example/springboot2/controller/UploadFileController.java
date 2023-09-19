package com.example.springboot2.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;



@RestController
public class UploadFileController {

    @Value("${web.upload-path}")
    private String uploadPath;

    @PostMapping("upload")
    public String upload(MultipartFile file) throws Exception {
        file.transferTo(new File(uploadPath + file.getOriginalFilename()));
        return "上传成功";
    }
}
