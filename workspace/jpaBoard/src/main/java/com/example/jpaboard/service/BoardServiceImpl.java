package com.example.jpaboard.service;

import com.example.jpaboard.domain.BoardEntity;
import com.example.jpaboard.dto.BoardDTO;
import com.example.jpaboard.dto.PageRequestDTO;
import com.example.jpaboard.dto.PageResponseDTO;
import com.example.jpaboard.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;

    @Override
    public void registerBoard(BoardDTO boardDTO) {
        BoardEntity boardEntity = this.dtoToEntity(boardDTO);
        boardRepository.save(boardEntity);
    }

    @Override
    public BoardDTO readBoard(Long bno) {
        BoardEntity boardEntity = boardRepository.findById(bno).orElse(null);
        boardEntity.updateReadCount();
        return this.entityToDto(boardEntity);
    }

    @Override
    public void updateBoard(BoardDTO boardDTO) {
        BoardEntity boardEntity = boardRepository.findById(boardDTO.getBno()).orElse(null);
        boardEntity.change(boardDTO.getTitle(), boardDTO.getContent());
        boardRepository.save(boardEntity);
    }

    @Override
    public void deleteBoard(Long bno) {
        boardRepository.deleteById(bno);
    }

    @Override
    public PageResponseDTO<BoardDTO> listBoard(PageRequestDTO pageRequestDTO) {
        Pageable pageable = pageRequestDTO.getPageable("bno");
        Page<BoardEntity> result = boardRepository.searchAll(pageRequestDTO.getTypes(), pageRequestDTO.getKeyword(), pageable);
        List<BoardDTO> dtoList = result.stream().map(boardEntity -> entityToDto(boardEntity)).collect(Collectors.toList());
        return PageResponseDTO.<BoardDTO>withAll().pageRequestDTO(pageRequestDTO).dtoList(dtoList).total((int)result.getTotalElements()).build();
    }
}
