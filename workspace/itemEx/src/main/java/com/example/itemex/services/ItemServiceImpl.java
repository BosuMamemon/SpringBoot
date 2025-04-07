package com.example.itemex.services;

import com.example.itemex.domain.Item;
import com.example.itemex.dto.ItemDTO;
import com.example.itemex.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public void registerItem(ItemDTO itemDTO) {
        Item item = dtoToEntity(itemDTO);
        itemRepository.save(item);
    }

    @Override
    public ItemDTO readItem(Long id) {
        Item item = itemRepository.findById(id).get();
        return entityToDto(item);
    }

    @Override
    public void updateItem(ItemDTO itemDTO) {
        Item item = itemRepository.findById(itemDTO.getId()).get();
        item.builder()
                .price(itemDTO.getPrice())
                .itemSellStatus(itemDTO.getItemSellStatus())
                .name(itemDTO.getName())
                .itemDetail(itemDTO.getItemDetail())
                .stockNumber(itemDTO.getStockNumber())
                .build();
        itemRepository.save(item);
    }

    @Override
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

    @Override
    public List<ItemDTO> listItem() {
        List<Item> items = itemRepository.findAll();
        List<ItemDTO> itemDTOs = items.stream().map(item -> entityToDto(item)).collect(Collectors.toList());
        return itemDTOs;
    }
}
