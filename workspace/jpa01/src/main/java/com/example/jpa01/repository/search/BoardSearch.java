package com.example.jpa01.repository.search;

import com.example.jpa01.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardSearch {
    Page<Board> searchOne(Pageable pageable);
    Page<Board> searchAll(String[] types, String keyword, Pageable pageable);
}
