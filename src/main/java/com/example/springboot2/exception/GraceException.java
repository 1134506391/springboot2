package com.example.springboot2.exception;

public class GraceException {
    public static void display(String errMsg){
        throw new MyCustomException(errMsg);
    }
}
