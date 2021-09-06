package com.example.jy.spring.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
    // mustache 를 사용하게 되면 기본 경로(src/main/resources/templates)에서
    // 뒤에 확장자(.mustache)는 생략을 한 순수한 파일의 이름만 반환하면 된다.
    // 아래와 같이 index 를 반환하게 되면
    // src/main/resources/templates/index.mustache 를 찾아서 View Resolver 가 처리하게 된다.

    @GetMapping("/posts/save")
    public String postsSave() {
        return "post-save";
    }

}
