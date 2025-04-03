package org.pgm.board01;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.pgm.board01.dto.BoardDTO;
import org.pgm.board01.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
@Log4j2
public class DataSourceTest {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private BoardMapper boardMapper;

    @Test
    public void testDataSource() throws SQLException {
        Connection conn=dataSource.getConnection();
        log.info("1111111111"+conn);
    }
    @Test
    public void insertTest() throws SQLException {
        BoardDTO dto = new BoardDTO();
        dto.setTitle("title22");
        dto.setContent("content22");
        dto.setAuthor("author22");
        boardMapper.insertBoard(dto);
    }
    @Test
    public void selectAllTest() throws SQLException {
        List<BoardDTO> list = boardMapper.selectAll();
        for (BoardDTO dto : list) {
            log.info(dto);
        }
    }
    @Test
    public void selectOneTest() throws SQLException {
        BoardDTO dto = boardMapper.selectByBno(1);
        log.info(dto);
    }
    @Test
    public void updateTest() throws SQLException {
        BoardDTO dto = new BoardDTO();
        dto.setTitle("title수정");
        dto.setContent("content수정");
        dto.setAuthor("user00");
        dto.setBno(1);
        boardMapper.updateByBno(dto);
    }
    @Test
    public void deleteTest() throws SQLException {
        boardMapper.deleteByBno(1);
    }
}
