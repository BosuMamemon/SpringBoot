package com.example.itemex.controllers;

import com.example.itemex.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/item/*")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/list")
    public void getList() {}
}
