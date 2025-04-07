package com.example.jpa01.service;

import com.example.jpa01.domain.Board;
import com.example.jpa01.dto.BoardDTO;
import com.example.jpa01.repository.BoardRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardRepository boardRepository;

    @Override
    public void registerBoard(BoardDTO boardDTO) {
        Board board = dtoToEntity(boardDTO);
        boardRepository.save(board);
    }

    @Override
    public BoardDTO readBoard(Long bno) {
        Board board = boardRepository.findById(bno).get();
        board.updateReadCount();
        boardRepository.save(board);
        BoardDTO boardDTO = entityToDto(board);
        return boardDTO;
    }

    @Override
    public void updateBoard(BoardDTO boardDTO) {
        Board board = boardRepository.findById(boardDTO.getBno()).get();
        board.change(boardDTO.getTitle(), boardDTO.getContent());
        boardRepository.save(board);
    }

    @Override
    public void deleteBoard(Long bno) {
        boardRepository.deleteById(bno);
    }

    @Override
    public List<BoardDTO> readAllBoards() {
        List<Board> boards = boardRepository.findAll();
        List<BoardDTO> boardDTOs = boards.stream().map(board -> entityToDto(board)).collect(Collectors.toList());
        return boardDTOs;
    }
}
