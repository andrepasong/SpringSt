package com.example.jy.spring.web;

import com.example.jy.spring.service.PostsService;
import com.example.jy.spring.web.dto.PostsResponseDto;
import com.example.jy.spring.web.dto.PostsSaveRequestDto;
import com.example.jy.spring.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/// Web Layer - 외부 요청과 응답에 대한 전반적인 영역
@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    //POST 는 생성일때
    @PostMapping("/api/v1/posts")
    public long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    //PUT 은 수정일때
    @PutMapping("/api/v1/posts/{id}")
    public long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    //GET 은 읽기일때
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }

}
