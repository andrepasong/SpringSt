package com.example.jy.spring.service;

import com.example.jy.spring.domain.posts.PostsRepository;
import com.example.jy.spring.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;


    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

}
