package com.example.jpaboard.service;

import com.example.jpaboard.domain.ReplyEntity;
import com.example.jpaboard.dto.PageRequestDTO;
import com.example.jpaboard.dto.PageResponseDTO;
import com.example.jpaboard.dto.ReplyDTO;

public interface ReplyService {
    void register(ReplyDTO replyDTO);
    ReplyDTO read(long rno);
    void modify(ReplyDTO replyDTO);
    void remove(long rno);
    PageResponseDTO<ReplyDTO> getListOfBoard(long bno, PageRequestDTO pageRequestDTO);

    default ReplyEntity dtoToEntity(ReplyDTO replyDTO) {
        ReplyEntity replyEntity = ReplyEntity.builder()
                .replyText(replyDTO.getReplyText())
                .author(replyDTO.getAuthor())
                .rno(replyDTO.getRno())
                .build();
        return replyEntity;
    }

    default ReplyDTO entityToDto(ReplyEntity replyEntity) {
        ReplyDTO replyDTO = ReplyDTO.builder()
                .author(replyEntity.getAuthor())
                .updatetime(replyEntity.getUpdatetime())
                .bno(replyEntity.getBoardEntity().getBno())
                .regdate(replyEntity.getRegdate())
                .rno(replyEntity.getRno())
                .replyText(replyEntity.getReplyText())
                .build();
        return replyDTO;
    }
}
