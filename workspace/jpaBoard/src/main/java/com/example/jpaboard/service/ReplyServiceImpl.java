package com.example.jpaboard.service;

import com.example.jpaboard.domain.BoardEntity;
import com.example.jpaboard.domain.ReplyEntity;
import com.example.jpaboard.dto.PageRequestDTO;
import com.example.jpaboard.dto.PageResponseDTO;
import com.example.jpaboard.dto.ReplyDTO;
import com.example.jpaboard.repository.BoardRepository;
import com.example.jpaboard.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {
    private final ReplyRepository replyRepository;
    private final BoardRepository boardRepository;

    @Override
    public void register(ReplyDTO replyDTO) {
        ReplyEntity replyEntity = dtoToEntity(replyDTO);
        BoardEntity boardEntity = boardRepository.findById(replyDTO.getBno()).get();
        replyEntity.setBoardEntity(boardEntity);
        replyRepository.save(replyEntity);
    }

    @Override
    public ReplyDTO read(long rno) {
        return null;
    }

    @Override
    public void modify(ReplyDTO replyDTO) {

    }

    @Override
    public void remove(long rno) {

    }

    @Override
    public PageResponseDTO<ReplyDTO> getListOfBoard(long bno, PageRequestDTO pageRequestDTO) {
        return null;
    }
}
