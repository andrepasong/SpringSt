package com.example.jy.spring.domain.posts;

import com.example.jy.spring.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {
    //Entity 클래스에는 절대 setter 를 만들지 않는다.
    //해당 목적과 의도를 알수 있는 메소드 만들어서 이용.
    //Entity 는 데이터베이스와 매칭되는 클래스로 Request/Response 로 사용하지 않는다.

    //보통 id는 자동증가로 잡는걸 추천, 복합키로 하면 난감할 수 있음
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
