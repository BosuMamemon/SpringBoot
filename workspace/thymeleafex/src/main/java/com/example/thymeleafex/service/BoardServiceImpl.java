package com.example.thymeleafex.service;

import com.example.thymeleafex.dto.BoardDTO;
import com.example.thymeleafex.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor    // Autowired는 setter로 주입받고 이 어노테이션은 생성자로 주입받음
// 근데 생성자로 주입받으면 지역변수처리 될 수도 있어서 상수로 만들어줘야 함
public class BoardServiceImpl implements BoardService {
    private final BoardMapper boardMapper;

    @Override
    public List<BoardDTO> getList() {
        return boardMapper.selectAll();
    }

    @Override
    public BoardDTO getBoard(int bno) {
        boardMapper.updateReadCount(bno);
        return boardMapper.selectByBno(bno);
    }

    @Override
    public void register(BoardDTO board) {
        boardMapper.insert(board);
    }

    @Override
    public void modify(BoardDTO board) {
        boardMapper.update(board);
    }

    @Override
    public void remove(int bno) {
        boardMapper.deleteByBno(bno);
    }
}
