package com.example.jpa01.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_item")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item {
    @Id
    @Column(name = "item_id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    // 상품코드
    @Column(nullable = false, length = 50)
    private String itemName;
    @Column(name = "item_price", nullable = false)
    @ColumnDefault(value = "1000")  // 기본값 지정
    private int price;
    @Column(columnDefinition = "int default 10 not null")
    private int stockNumber;
    @Lob    // LOB란? 구조화되지 않은 대형 오브젝트(Large OBject)를 뜻함
    @Column(nullable = false)
    private String itemDetail;
    @Enumerated(EnumType.STRING)
    private ItemSellStatus itemSellStatus;
    @CreationTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @UpdateTimestamp
    private LocalDateTime updateTime;
    @Transient  // 테이블에 매핑하고 싶지 않은 필드를 이렇게 지정
    private String memo;
}
