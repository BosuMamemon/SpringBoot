package com.example.securityexam.service;

import com.example.securityexam.domain.Board;
import com.example.securityexam.domain.User;
import com.example.securityexam.repository.BoardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@Log4j2
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
    private final BoardRepository boardRepository;

    @Override
    public void insert(Board board, User user) {
        board.setUser(user);
        boardRepository.save(board);
    }

    @Override
    public List<Board> list() {
        return boardRepository.findAll();
    }

    @Override
    public Board findById(Long num) {
        Board board = boardRepository.findById(num).orElse(null);
        if(board == null) {
            return null;
        }
        board.updateHitcount();
        boardRepository.save(board);
        return board;
    }

    @Override
    public void update(Board board, User user) {
        Board oldBoard = boardRepository.findById(board.getNum()).orElse(null);
        oldBoard.setUser(user);
        oldBoard.change(board.getTitle(), board.getContent());
        boardRepository.save(oldBoard);
    }

    @Override
    public void delete(Long num) {
        boardRepository.deleteById(num);
    }
}
