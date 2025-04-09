package com.example.jpaboard.controller;

import com.example.jpaboard.dto.BoardDTO;
import com.example.jpaboard.dto.PageRequestDTO;
import com.example.jpaboard.dto.PageResponseDTO;
import com.example.jpaboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/board/*")
@RequiredArgsConstructor
@Log4j2
public class BoardController {
    private final BoardService boardService;

    @GetMapping({"/list", "/register"})
    public void getListRegister(PageRequestDTO pageRequestDTO, Model model) {
        PageResponseDTO<BoardDTO> pageResponseDTO = boardService.listBoard(pageRequestDTO);
        model.addAttribute("pageRequestDTO", pageRequestDTO);
        model.addAttribute("pageResponseDTO", pageResponseDTO);
    }

    @PostMapping("/register")
    public String PostRegister(BoardDTO boardDTO) {
        boardService.registerBoard(boardDTO);
        return "redirect:/board/list";
    }

    @GetMapping({"/read", "/modify"})
    public void getBoard(@RequestParam("bno") Long bno, PageRequestDTO pageRequestDTO, Model model) {
        BoardDTO boardDTO = boardService.readBoard(bno);
        model.addAttribute("pageRequestDTO", pageRequestDTO);
        model.addAttribute("boardDTO", boardDTO);
    }

    @PostMapping("/modify")
    public String postModify(BoardDTO boardDTO) {
        boardService.updateBoard(boardDTO);
        return "redirect:/board/list";
    }

    @GetMapping("/delete")
    public String postDelete(@RequestParam("bno") Long bno) {
        boardService.deleteBoard(bno);
        return "redirect:/board/list";
    }
}
