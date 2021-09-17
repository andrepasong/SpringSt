package com.example.jy.spring.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/// Repository Layer - Database 와 같이 데이터 저장소에 접근하는 영역

//보통 Dao 라고 불리는 DB Layer 접근자, JPA 에서는 Repository 라고 불림.
//JpaRepository <Entity 클래스, PK 타입>을 상속하면 기본적인 CRUD 메소드가 자동생성
public interface PostsRepository extends JpaRepository<Posts, Long> {

    //SpringDataJpa 에서 제공하지 않는 메소드는 쿼리로 작성할 수도 있다.
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}



/// 규모가 있는 프로젝트에서 복잡한 데이터 조회는 조회용 프레임워크를 추가로 사용
/// Querydsl 추천 - 타입안정성 보장, 많은 회사 사용, 레퍼런스가 많음.
