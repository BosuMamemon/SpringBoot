package org.pgm.jpaboard.repository;

import org.pgm.jpaboard.domain.BoardEntity;
import org.pgm.jpaboard.repository.search.BoardSearch;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> , BoardSearch {
//    쿼리를 수행할 때 WHERE절과 관련된 attributePaths를 함께 검색한다는 의미
    @EntityGraph(attributePaths = {"imageSet"})
    @Query("SELECT b FROM BoardEntity b WHERE b.bno = :bno")
    Optional<BoardEntity> findByIdWithImages(Long bno);
//    Optional 객체는 null을 담을 수 있는 클래스임
}
