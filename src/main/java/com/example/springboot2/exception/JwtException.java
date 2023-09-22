package com.example.springboot2.exception;

public class JwtException extends RuntimeException {
    public  JwtException(String errorMsg){
        super(errorMsg);
    }
}
