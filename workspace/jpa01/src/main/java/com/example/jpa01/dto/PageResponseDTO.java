package com.example.jpa01.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class PageResponseDTO<E> {
//    필드
    private int page;   // 현재 페이지 번호
    private int size = 3;   // 블록 크기
    private int total;  // 전체 레코드 수
    private int start;  // 시작 페이지 번호
    private int end;    // 끝 페이지 번호
    private boolean prev;   // 이전 페이지 존재 여부
    private boolean next;   // 다음 페이지 존재 여부
    private List<E> dtoList;    // 페이징 할 DTO 리스트

//    메소드
    @Builder(builderMethodName = "withAll")
    public PageResponseDTO(
            PageRequestDTO pageRequestDTO,
            List<E> dtoList,
            int total
    ) {
        if(total <= 0) {
            return;
        }
        this.page = pageRequestDTO.getPage();
        this.total = total;
        this.dtoList = dtoList;
        this.end = (int)(Math.ceil(this.page / (double)this.size)) * this.size;
        this.start  = this.end - this.size + 1;
        int last = (int)(Math.ceil(total / (double)pageRequestDTO.getSize()));
        this.end = this.end > last ? last : this.end;   // 마지막 블록은 last가 end가 되도록 설정
        this.prev = this.start > 1;
        this.next = total > this.end * pageRequestDTO.getSize();
    }
}
