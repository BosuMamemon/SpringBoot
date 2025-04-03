package com.example.thymeleafex.controller;

import com.example.thymeleafex.dto.SampleDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@Log4j2
public class SampleController {
    @GetMapping("/hello")
    public void hello(Model model) {
        model.addAttribute("msg", "Hello, World!");
    }

    @GetMapping("/arrData")
    public void arrData(Model model) {
        List<String> list = Arrays.asList("aa", "bb", "cc");
        model.addAttribute("list", list);
    }
    @GetMapping("/ex01")
    public void ex01() {}

    @GetMapping("/hello1")
    public void hello1(String name, int age, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("age", age);
    }

    @GetMapping("/hello2")
    public void hello2(String name, int age, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("age", age);
    }

    @GetMapping("/hello3")
    public void hello3(@RequestParam(name = "names") List<String> names, int age, Model model) {
        model.addAttribute("names", names);
        model.addAttribute("age", age);
    }

    @GetMapping("/ex02")
    public void ex02(Model model) {
        log.info("ex02");
        List<String> strList2 = new ArrayList<>();
        List<String> strList = IntStream.range(1, 10).mapToObj(i->"Data"+i).collect(Collectors.toList());
        for(int i = 1; i < 10; i++) {
            strList2.add("Data" + i);
        }
        model.addAttribute("strList", strList);
        model.addAttribute("strList2", strList2);

        Map<String, Integer> maps = new HashMap<>();
        maps.put("정현민", 80);
        maps.put("이준목", 75);
        maps.put("조유빈", 85);
        model.addAttribute("maps", maps);

        SampleDTO sample = new SampleDTO("정현민", 29, "디지몬");
        model.addAttribute("sample", sample);
    }

    @GetMapping("/ex/ex001")
    public void ex001() {}

    @GetMapping("/sample")
    public void sample() {}
}
