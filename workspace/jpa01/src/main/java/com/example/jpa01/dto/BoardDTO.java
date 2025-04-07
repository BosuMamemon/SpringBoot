package com.example.jpa01.dto;

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
public class BoardDTO {
    private Long bno;
//    Spring Boot Starter Validation 라이브러리가 있어야 쓸 수 있는 어노테이션
    @NotEmpty
    private String title;
    @NotEmpty
    private String content;
    @NotEmpty
    private String author;
    private int readcount;
    private LocalDateTime regdate;
    private LocalDateTime updatedate;
}
