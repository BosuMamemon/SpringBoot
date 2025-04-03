package com.example.board01;

import com.example.board01.dto.BoardDTO;
import com.example.board01.mapper.BoardMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
@Log4j2 // 이거 쓰려면 lombok 종속성이 필요함
public class DataSourceTest {
    @Autowired
    private DataSource dataSource;
    @Autowired
//    스프링이 알아서 인터페이스의 구현체 객체를 생성해서 Autowired를 해줌
    private BoardMapper boardMapper;

    @Test
    public void testDataSource() throws SQLException {
        Connection conn = dataSource.getConnection();
        log.info("11111111" + conn);
    }

    @Test
    public void insertTest() throws SQLException {
        BoardDTO board = new BoardDTO();
        board.setTitle("title33");
        board.setContent("content33");
        board.setAuthor("author33");
        boardMapper.insert(board);
    }

    @Test
    public void selectAllTest() throws SQLException {
        List<BoardDTO> list = boardMapper.selectAll();
        for(BoardDTO board : list) {
            log.info(board);
        }
    }

    @Test
    public void updateTest() throws SQLException {
        BoardDTO board = new BoardDTO();
        board.setTitle("아싸");
        board.setContent("또왔다나");
        board.setAuthor("기분좋아서나");
        board.setBno(1);
        boardMapper.update(board);
    }

    @Test
    public void deleteTest() throws SQLException {
        boardMapper.deleteByBno(2);
    }
}
