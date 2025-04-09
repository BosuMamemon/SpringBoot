package com.example.jpaboard.repository;

import com.example.jpaboard.domain.ReplyEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReplyRepository extends JpaRepository<ReplyEntity, Long> {
    @Query("SELECT r FROM ReplyEntity r WHERE r.boardEntity.bno = :bno")
    Page<ReplyEntity> listOfBoard(long bno, Pageable pageable);

    void deleteByBoardEntity_Bno(Long bno);
}
