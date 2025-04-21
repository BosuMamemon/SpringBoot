package com.example.securityexam.service;

import com.example.securityexam.domain.Board;
import com.example.securityexam.domain.User;

import java.util.List;

public interface BoardService {
    void insert(Board board, User user);
    List<Board> list();
    Board findById(Long num);
    void update(Board board, User user);
    void delete(Long num);
}
