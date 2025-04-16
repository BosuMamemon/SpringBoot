package org.pgm.jpaboard.repository;

import org.pgm.jpaboard.domain.BoardEntity;
import org.pgm.jpaboard.repository.search.BoardSearch;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> , BoardSearch {
//    attributePaths란? fetchType.LAZY일 때 fetch join을 수행할 테이블을 의미함.
//    지연 로딩이란 쿼리문을 수행할 때 페치할 엔티티를 프록시로 복제해서 쿼리문을 순차대로 천천히 수행하는 것을 의미함
//    즉시 로딩은 엔티티를 조인해서 쿼리문을 한꺼번에 수행하는 것을 의미함
//    이렇게 하면 N+1 같은 충돌 문제를 피할 수 있다고 함
    @EntityGraph(attributePaths = {"imageSet"})
    @Query("SELECT b FROM BoardEntity b WHERE b.bno = :bno")
    Optional<BoardEntity> findByIdWithImages(Long bno);
//    Optional 객체는 null을 담을 수 있는 클래스임
}
