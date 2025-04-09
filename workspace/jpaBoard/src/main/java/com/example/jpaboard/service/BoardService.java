package com.example.jpaboard.service;

import com.example.jpaboard.domain.BoardEntity;
import com.example.jpaboard.dto.BoardDTO;
import com.example.jpaboard.dto.PageRequestDTO;
import com.example.jpaboard.dto.PageResponseDTO;

public interface BoardService {
    void registerBoard(BoardDTO boardDTO);
    BoardDTO readBoard(Long bno);
    void updateBoard(BoardDTO boardDTO);
    void deleteBoard(Long bno);
    PageResponseDTO<BoardDTO> listBoard(PageRequestDTO pageRequestDTO);

    default BoardDTO entityToDto(BoardEntity boardEntity) {
        BoardDTO boardDTO = BoardDTO.builder()
                .bno(boardEntity.getBno())
                .title(boardEntity.getTitle())
                .author(boardEntity.getAuthor())
                .content(boardEntity.getContent())
                .readcount(boardEntity.getReadcount())
                .regdate(boardEntity.getRegdate())
                .updatetime(boardEntity.getUpdatetime())
                .build();
        return boardDTO;
    }

    default BoardEntity dtoToEntity(BoardDTO boardDTO) {
        BoardEntity boardEntity = BoardEntity.builder()
                .bno(boardDTO.getBno())
                .title(boardDTO.getTitle())
                .author(boardDTO.getAuthor())
                .content(boardDTO.getContent())
                .build();
        return boardEntity;
    }
}
