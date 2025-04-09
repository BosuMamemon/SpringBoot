package com.example.jpaboard.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageRequestDTO {
    @Builder.Default
    private int page = 1;
    @Builder.Default
    private int size = 10;
    private String link;
    private String type;
    private String keyword;

    public Pageable getPageable(String...props) {
        return PageRequest.of(this.page - 1, this.size, Sort.by(props).descending());
    }

    public String getLink() {
        if(this.link == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("page=" + this.page);
            sb.append("&size=" + this.size);
            if(this.type != null && this.type.length() > 0) {
                sb.append("&type=" + this.type);
            }
            if(this.keyword != null) {
                sb.append("&keyword=" + this.keyword);
            }
            this.link = sb.toString();
        }
        return this.link;
    }

    public String[] getTypes() {
        if(this.type == null || this.type.isEmpty()) {
            return null;
        }
        return this.type.split("");
    }
}
