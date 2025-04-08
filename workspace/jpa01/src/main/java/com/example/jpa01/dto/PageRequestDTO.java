package com.example.jpa01.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.net.URLEncoder;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDTO {
//    필드
    @Builder.Default    // 필드에 디폴트값을 지정하는 어노테이션
    private int page = 1;
    @Builder.Default
    private int size = 10;
    private String link;
    private String type;
    private String keyword;

//    메소드
    public Pageable getPageable(String...props) {
        return PageRequest.of(this.page - 1, this.size, Sort.by(props).descending());
    }
    public String getLink() {
        if(this.link == null) {
            StringBuilder builder = new StringBuilder();
            builder.append("page=" + this.page);
            builder.append("&size=" + this.size);
            if(type != null && type.length() > 0) {
                builder.append("&type=" + type);
            }
            if(keyword != null) {
                builder.append("&keyword=" + URLEncoder.encode(keyword));
            }
            this.link = builder.toString();
        }
        return this.link;
    }
    public String[] getTypes() {
        if(type == null || type.isEmpty()) {
            return null;
        }
        return type.split("");
    }
}
