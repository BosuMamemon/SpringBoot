package com.example.board01.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Table(name = "tbl_table")
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class MemberDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)   // NOT NULL 제약조건 지정
    private String name;
    @Column(nullable = false)
    private String password;
    @Column(unique = true)  // UNIQUE 제약조건 지정
    private String email;
    //    @Column(name = "address") <- 컬럼이름 재지정
    private String address;
}
