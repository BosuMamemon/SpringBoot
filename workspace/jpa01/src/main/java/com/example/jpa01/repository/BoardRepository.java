package com.example.jpa01.repository;

import com.example.jpa01.domain.Board;
import com.example.jpa01.dto.BoardDTO;
import com.example.jpa01.repository.search.BoardSearch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BoardRepository extends JpaRepository<Board, Long>, BoardSearch {
//    기존 방식
//     @Query("SELECT b FROM Board b WHERE b.title LIKE CONCAT('%', :keyword, '%')")
//    Page<Board> searchTitle(String keyword, Pageable pageable);

//    JPQL 방식

}
