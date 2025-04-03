package com.example.thymeleafex.mapper;

import com.example.thymeleafex.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<BoardDTO> selectAll();
    void insert(BoardDTO board);
    BoardDTO selectByBno(int bno);
    void deleteByBno(int bno);
    void update(BoardDTO board);
    void updateReadCount(int bno);
}
