package com.example.itemex.services;

import com.example.itemex.domain.Item;
import com.example.itemex.dto.ItemDTO;

import java.util.List;

public interface ItemService {
    void registerItem(ItemDTO itemDTO);
    ItemDTO readItem(Long id);
    void updateItem(ItemDTO itemDTO);
    void deleteItem(Long id);
    List<ItemDTO> listItem();

//    default method
    default ItemDTO entityToDto(Item item) {
        ItemDTO itemDTO = ItemDTO.builder()
                .regdate(item.getRegdate())
                .price(item.getPrice())
                .itemSellStatus(item.getItemSellStatus())
                .name(item.getName())
                .itemDetail(item.getItemDetail())
                .id(item.getId())
                .stockNumber(item.getStockNumber())
                .updatedate(item.getUpdatedate())
                .build();
        return itemDTO;
    }

    default Item dtoToEntity(ItemDTO itemDTO) {
        Item item = Item.builder()
                .itemSellStatus(itemDTO.getItemSellStatus())
                .id(itemDTO.getId())
                .price(itemDTO.getPrice())
                .itemDetail(itemDTO.getItemDetail())
                .name(itemDTO.getName())
                .stockNumber(itemDTO.getStockNumber())
                .build();
        return item;
    }
}
