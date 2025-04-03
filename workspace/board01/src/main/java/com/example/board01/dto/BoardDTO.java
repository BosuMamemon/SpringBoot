package com.example.board01.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor  // 기본 생성자를 만들어주는 어노테이션
@AllArgsConstructor // 생성자를 만들어주는 어노테이션
@Builder    // 위와는 다른 방법으로 객체를 만드는 어노테이션이라고 함...
public class BoardDTO {
    private int bno;
    private String title;
    private String content;
    private String author;
    private Date postdate;
    private int readcount;
}
