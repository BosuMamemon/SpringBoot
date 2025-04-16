package org.pgm.jpaboard.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.BatchSize;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tbl_board")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"imageSet"})
public class BoardEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;
    @Column(nullable = false, length = 500)
    private String title;
    @Column(nullable = false, length = 3000)
    private String content;
    @Column(nullable = false, length = 50)
    private String author;
    private int readcount;
    @OneToMany(mappedBy = "boardEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
//    Cascade는 자식 테이블을 지우고, orphanRemoval은 고아 테이블을 지움
    @Builder.Default    // Builder로 생성할 때 디폴트로 만든다는 뜻
    @BatchSize(size = 20)   // Set의 기본 사이즈가 20이라는 뜻
    private Set<BoardImageEntity> imageSet = new HashSet<>();

    public void addImage(String uuid, String filename) {
        BoardImageEntity image = BoardImageEntity
                .builder()
                .uuid(uuid)
                .filename(filename)
                .boardEntity(this)
                .ord(imageSet.size())
                .build();
        imageSet.add(image);
    }

    public void removeImage() {
        imageSet.forEach(boardImageEntity -> boardImageEntity.changeBoardEntity(null));
        this.imageSet.clear();
    }

    public void updateReadcount() {
        readcount = readcount + 1;
    }
    public void change(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
