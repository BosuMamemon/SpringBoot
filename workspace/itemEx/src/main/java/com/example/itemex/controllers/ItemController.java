package com.example.itemex.controllers;

import com.example.itemex.domain.ItemSellStatus;
import com.example.itemex.dto.ItemDTO;
import com.example.itemex.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        model.addAttribute("itemList", itemList);
    }

    @GetMapping("/register")
    public void getRegister() {}

    @PostMapping("/register")
    public String postRegister(ItemDTO itemDTO) {
        itemService.registerItem(itemDTO);
        return "redirect:/item/list";
    }

    @GetMapping({"/read", "/modify"})
    public void getRead(@RequestParam("id") Long id, Model model) {
        ItemDTO itemDTO = itemService.readItem(id);
        model.addAttribute("itemDTO", itemDTO);
    }

    @GetMapping("/delete")
    public String getDelete(@RequestParam("id") Long id) {
        itemService.deleteItem(id);
        return "redirect:/item/list";
    }

    @PostMapping("/modify")
    public String postModify(ItemDTO itemDTO) {
        itemService.updateItem(itemDTO);
        return "redirect:/item/list";
    }
}
