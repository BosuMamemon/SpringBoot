package com.example.itemex.controllers;

import com.example.itemex.domain.ItemSellStatus;
import com.example.itemex.dto.ItemDTO;
import com.example.itemex.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/item/*")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/list")
    public void getList(Model model) {
        List<ItemDTO> itemList = itemService.listItem();
        List<ItemSellStatus> itemSellStatus = Arrays.stream(ItemSellStatus.values()).toList();
        model.addAttribute("itemList", itemList);
        model.addAttribute("itemSellStatus", itemSellStatus);
    }

    @GetMapping("/register")
    public void getRegister() {}
}
