package com.example.thymeleafex.service;

import com.example.thymeleafex.dto.BoardDTO;

import java.util.List;

public interface BoardService {
    List<BoardDTO> getList();
    BoardDTO getBoard(int bno);
    void register(BoardDTO board);
    void modify(BoardDTO board);
    void remove(int bno);
}
