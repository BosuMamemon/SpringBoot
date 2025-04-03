package org.pgm.board01.controller;

import lombok.extern.log4j.Log4j2;
import org.pgm.board01.dto.BoardDTO;
import org.pgm.board01.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Log4j2
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService boardService;
    @GetMapping("/list")
    public String getList(Model model) {
        List<BoardDTO> boardList = boardService.getList();
        model.addAttribute("boardList", boardList);
        return "board/list";
    }
    @GetMapping("/register")
    public void getRegister(){
    }
    @PostMapping("/register")
    public String postRegister(BoardDTO boardDTO) {
        boardService.register(boardDTO);
        return "redirect:/board/list";
    }
    @GetMapping({"/read","/modify"})
    public void read(int bno, Model model) {
        BoardDTO boardDTO = boardService.getBoard(bno);
        model.addAttribute("board", boardDTO);
    }
    @PostMapping("/modify")
    public String modify(BoardDTO boardDTO) {
        boardService.modify(boardDTO);
        return "redirect:/board/read?bno=" + boardDTO.getBno();
    }
    @GetMapping("/remove")
    public String remove(int bno) {
        boardService.remove(bno);
        return "redirect:/board/list";
    }
}
