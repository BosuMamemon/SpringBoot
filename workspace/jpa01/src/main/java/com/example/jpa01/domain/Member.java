package com.example.jpa01.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "tbl_member") // 테이블 이름 재지정
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member {
    @Id // Id 어노테이션이 붙은 필드는 꼭 자료형을 래퍼 클래스로 줘야함... 레파지토리를 만들때 제네릭으로 만들어줘야해서 그럼 ㅇㅇ
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment의 기본키라는 뜻임
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
