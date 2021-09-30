package com.example.jy.spring.web;

import com.example.jy.spring.service.PostsService;
import com.example.jy.spring.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/// Web Layer - 외부 요청과 응답에 대한 전반적인 영역
@Slf4j
@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostsService postsService;

    // mustache 를 사용하게 되면 기본 경로(src/main/resources/templates)에 mustache 파일이 위치하게 된다.(html 등등의 기본위치)
    // 뒤에 확장자(.mustache)는 생략한 순수한 파일이름만 반환하면 된다.
    // 아래와 같이 index 를 반환하게 되면
    // src/main/resources/templates/index.mustache 를 찾아서 View Resolver 가 처리하게 된다.
    @GetMapping("/")
    public String index(Model model) {
        //Model - 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장
        model.addAttribute("posts", postsService.findAllDese());
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "post-save";
    }


    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {

        log.debug("##### Post update ~~~");
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "post-update";
    }

}
