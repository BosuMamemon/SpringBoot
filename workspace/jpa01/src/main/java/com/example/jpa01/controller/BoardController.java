package com.example.jpa01.controller;

import com.example.jpa01.domain.Board;
import com.example.jpa01.dto.BoardDTO;
import com.example.jpa01.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/board/*")
@RequiredArgsConstructor
@Log4j2
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/list")
    public void getList(Model model) {
        List<BoardDTO> bList = boardService.readAllBoards();
        model.addAttribute("bList", bList);
    }

    @GetMapping("/register")
    public void getRegister() {}

    @PostMapping("/register")
    public String postRegister(BoardDTO boardDTO) {
        boardService.registerBoard(boardDTO);
        return "redirect:/board/list";
    }

    @GetMapping({"/read", "/modify"})
    public void getRead(@RequestParam("bno") Long bno, Model model) {
        BoardDTO boardDTO = boardService.readBoard(bno);
        model.addAttribute("board", boardDTO);
    }

    @GetMapping("/delete")
    public String getDelete(@RequestParam("bno") Long bno) {
        boardService.deleteBoard(bno);
        return "redirect:/board/list";
    }

    @PostMapping("/modify")
    public String postModify(BoardDTO boardDTO) {
        boardService.updateBoard(boardDTO);
        log.info(boardDTO);
        return "redirect:/board/list";
    }
}
