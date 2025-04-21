package com.example.securityexam.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity(name = "t_board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;
    private String title;
    private String writer;
    private String content;
    @CreationTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime regDate;
    private Long hitcount;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public void change(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void updateHitcount() {
        this.hitcount = this.hitcount + 1;
    }

    @PrePersist // 엔티티가 저장되기 전에 자동 호출한다는 어노테이션
    public void prePersist() {
        this.hitcount = this.hitcount == null ? 0 : this.hitcount;
    }
}
