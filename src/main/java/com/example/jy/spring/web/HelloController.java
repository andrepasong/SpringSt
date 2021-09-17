package com.example.jy.spring.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/// Web Layer - 외부 요청과 응답에 대한 전반적인 영역
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }
}