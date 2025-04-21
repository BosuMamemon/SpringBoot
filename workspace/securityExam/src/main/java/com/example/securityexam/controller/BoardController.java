package com.example.securityexam.controller;

import com.example.securityexam.config.auth.PrincipalDetails;
import com.example.securityexam.domain.Board;
import com.example.securityexam.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
@Log4j2
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/register")
    public void getRegister() {}

    @PostMapping("/register")
    public String postRegister(Board board, @AuthenticationPrincipal PrincipalDetails principal) {
        boardService.insert(board, principal.getUser());
        return "redirect:/board/list";
    }

    @GetMapping("/list")
    public void getList(Model model) {
        model.addAttribute("boardList", boardService.list());
    }

    @GetMapping({"/read", "/modify"})
    public void getRead(@RequestParam("num") Long num, Model model) {
        model.addAttribute("board", boardService.findById(num));
    }

    @PostMapping("/modify")
    public String postModify(Board board, @AuthenticationPrincipal PrincipalDetails principal, RedirectAttributes redirectAttributes) {
        boardService.update(board, principal.getUser());
        redirectAttributes.addAttribute("num", board.getNum());
        return "redirect:/board/read";
    }

    @PostMapping("/remove")
    public String delete(@RequestParam("num") Long num) {
        boardService.delete(num);
        return "redirect:/board/list";
    }
}
