package com.example.jpa01.service;

import com.example.jpa01.domain.Board;
import com.example.jpa01.dto.BoardDTO;

import java.util.List;

public interface BoardService {
    void registerBoard(BoardDTO board);
    BoardDTO readBoard(Long bno);
    void updateBoard(BoardDTO board);
    void deleteBoard(Long bno);
    List<BoardDTO> readAllBoards();

//    default method
    default Board dtoToEntity(BoardDTO boardDTO) {
        Board board = Board.builder()
                .author(boardDTO.getAuthor())
                .bno(boardDTO.getBno())
                .content(boardDTO.getContent())
                .title(boardDTO.getTitle())
                .readcount(boardDTO.getReadcount())
                .build();
        return board;
    }
    default BoardDTO entityToDto(Board board) {
        BoardDTO boardDTO = BoardDTO.builder()
                .author(board.getAuthor())
                .bno(board.getBno())
                .content(board.getContent())
                .readcount(board.getReadcount())
                .regdate(board.getRegdate())
                .title(board.getTitle())
                .updatedate(board.getUpdatedate())
                .build();
        return boardDTO;
    }
}
