package com.example.jpaboard.repository.query;

import com.example.jpaboard.domain.BoardEntity;
import com.example.jpaboard.domain.QBoardEntity;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class QueryDslImpl extends QuerydslRepositorySupport implements QueryDsl {
    public QueryDslImpl() {
        super(BoardEntity.class);
    }

    @Override
    public Page<BoardEntity> searchAll(String[] types, String keyword, Pageable pageable) {
        QBoardEntity boardEntity = QBoardEntity.boardEntity;
        JPQLQuery<BoardEntity> query = from(boardEntity);

        if((types != null && types.length > 0) && keyword != null) {
            BooleanBuilder booleanBuilder = new BooleanBuilder();
            for(String type : types) {
                switch(type) {
                    case "t":
                        booleanBuilder.or(boardEntity.title.contains(keyword)); break;
                    case "a":
                        booleanBuilder.or(boardEntity.author.contains(keyword)); break;
                    case "c":
                        booleanBuilder.or(boardEntity.content.contains(keyword)); break;
                }
            }
            query.where(booleanBuilder);
        }

        this.getQuerydsl().applyPagination(pageable, query);
        List<BoardEntity> list = query.fetch();
        long count = query.fetchCount();

        return new PageImpl<>(list, pageable, count);
    }
}
