package com.example.jpa01.repository;

import com.example.jpa01.domain.Board;
import com.example.jpa01.dto.BoardDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
