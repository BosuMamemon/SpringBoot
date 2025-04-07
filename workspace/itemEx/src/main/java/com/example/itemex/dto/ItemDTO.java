package com.example.itemex.dto;

import com.example.itemex.domain.ItemSellStatus;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemDTO {
    private Long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private int price;
    @NotEmpty
    private int stockNumber;
    @NotEmpty
    private String itemDetail;
    private ItemSellStatus itemSellStatus;
    private LocalDateTime regdate;
    private LocalDateTime updatedate;
}
