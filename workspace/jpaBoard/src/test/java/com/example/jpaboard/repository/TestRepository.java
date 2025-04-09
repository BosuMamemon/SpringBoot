package com.example.jpaboard.repository;

import com.example.jpaboard.domain.BoardEntity;
import com.example.jpaboard.domain.ReplyEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class TestRepository {
    @Autowired
    private ReplyRepository replyRepository;
    @Autowired
    private BoardRepository boardRepository;


    @Test
    public void testReplySave() {
        ReplyEntity replyEntity = new ReplyEntity();
        BoardEntity boardEntity = boardRepository.findById(1L).get();
        replyEntity.setReplyText("test");
        replyEntity.setAuthor("test");
        replyEntity.setBoardEntity(boardEntity);
        replyRepository.save(replyEntity);
    }
}
