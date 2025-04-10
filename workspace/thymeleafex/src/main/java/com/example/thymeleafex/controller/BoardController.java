package com.example.thymeleafex.controller;

import com.example.thymeleafex.dto.BoardDTO;
import com.example.thymeleafex.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/list")
    public void getList(Model model) {
//        결과값이 void이면 매핑한 그 주소를 다시 리턴해서 forward함
        List<BoardDTO> bList = boardService.getList();
        model.addAttribute("bList", bList);
    }

    @GetMapping("/register")
    public void getRegister() {

    }

    @PostMapping("/register")
    public String postRegister(BoardDTO board) {
        boardService.register(board);
        return "redirect:/board/list";
    }

    @GetMapping({"/read", "/modify"})
    public void getRead(@RequestParam("bno") int bno, Model model) {
        BoardDTO board =  boardService.getBoard(bno);
        model.addAttribute("board", board);
    }

    @PostMapping("/modify")
    public String modify(BoardDTO board) {
        boardService.modify(board);
        return "redirect:/board/list";
    }

    @PostMapping("/remove")
    public String remove(BoardDTO board) {
        boardService.remove(board.getBno());
        return "redirect:/board/list";
    }
}
