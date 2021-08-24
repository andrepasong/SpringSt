package com.example.jy.spring.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

//보통 Dao 라고 불리는 DB Layer 접근자, JPA 에서는 Repository 라고 불림.
//JpaRepository <Entity 클래스, PK 타입>을 상속하면 기본적인 CRUD 메소드가 자동생성
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
