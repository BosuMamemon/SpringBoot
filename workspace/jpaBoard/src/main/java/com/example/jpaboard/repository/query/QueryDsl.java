package com.example.jpaboard.repository.query;

import com.example.jpaboard.domain.BoardEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QueryDsl {
    Page<BoardEntity> searchAll(String[] types, String keyword, Pageable pageable);
}
