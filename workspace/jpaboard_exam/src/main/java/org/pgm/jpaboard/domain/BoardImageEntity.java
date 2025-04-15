package org.pgm.jpaboard.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardImageEntity implements Comparable<BoardImageEntity> {
    @Id
    private String uuid;
    private String filename;
    private int ord;
    @ManyToOne
    @JoinColumn(name = "bno")
    private BoardEntity boardEntity;
    
//    comparable 인터페이스를 구현해서 비교가 가능하도록 만들고 아래 메소드를 오버라이드해야함
    public int compareTo(BoardImageEntity other) {
        return this.ord - other.ord;
    }

    public void changeBoardEntity(BoardEntity boardEntity) {
        this.boardEntity = boardEntity;
    }
}
