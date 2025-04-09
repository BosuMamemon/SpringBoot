package com.example.jpaboard.repository;

import com.example.jpaboard.domain.BoardEntity;
import com.example.jpaboard.repository.query.QueryDsl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardEntity, Long>, QueryDsl {
}
