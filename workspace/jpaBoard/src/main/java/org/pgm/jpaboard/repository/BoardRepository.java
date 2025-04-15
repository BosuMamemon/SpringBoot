package org.pgm.jpaboard.repository;

import org.pgm.jpaboard.domain.BoardEntity;
import org.pgm.jpaboard.repository.search.BoardSearch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> , BoardSearch {
}
