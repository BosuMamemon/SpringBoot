package com.example.jpaboard.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class PageResponseDTO<E> {
    private int page;
    private int size;
    private int total;
    private int start;
    private int end;
    private boolean prev;
    private boolean next;
    private List<E> dtoList;

    @Builder(builderMethodName = "withAll")
    public PageResponseDTO(PageRequestDTO pageRequestDTO, List<E> dtoList, int total) {
        if(total <= 0) {
            return;
        }
        this.page = pageRequestDTO.getPage();
        this.size = 3;
        this.total = total;
        this.dtoList = dtoList;
        this.end = (int)(Math.ceil(this.page / (double)this.size)) * this.size;
        this.start  = this.end - this.size + 1;
        int last = (int)(Math.ceil(total / (double)pageRequestDTO.getSize()));
        this.end = this.end > last ? last : this.end;
        this.prev = this.start > 1;
        this.next = total > this.end * pageRequestDTO.getSize();
    }
}
