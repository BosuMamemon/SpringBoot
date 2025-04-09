package com.example.jpaboard.dto;

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
public class ReplyDTO {
    private long rno;
    @NotEmpty
    private long bno;
    @NotEmpty
    private String replyText;
    @NotEmpty
    private String author;
    private LocalDateTime regdate, updatetime;
}
