package com.example.jy.spring.domain.posts;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;


//SpringBootTest 를 사용할 경우 자동으로 H2 데이터베이스를 실행
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PostsRepositoryTest {

    //스프링이 관리하는 Bean 을 주입받는다
    @Autowired
    PostsRepository postsRepository;

    //단위 테스트가 끝날때 동작 지정
    @AfterEach
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void testCURD() {
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("test@mail.com")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        Assertions.assertThat(posts.getTitle()).isEqualTo(title);
        Assertions.assertThat(posts.getContent()).isEqualTo(content);
    }
}
