package com.thecar.repositoryImpl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.thecar.model.Board;
import com.thecar.repository.BoardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardRepositoryImpl implements BoardRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public BoardRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public Page<Board> selectBoardList(String searchVal, Pageable pageable) {
        List<Board> content = getBoardMemberDtos(searchVal, pageable);
        Long count = getCount(searchVal);
        return new PageImpl<>(content, pageable, count);
    }

    private Long getCount(String searchVal) {
        Long count = jpaQueryFactory
                .select(board.count())
                .from(board)
                .fetchOne();
        return count;
    }

    private List<Board> getBoardMemberDtos(String searchVal, Pageable pageable){
        List<Board> content = jpaQueryFactory
                .select(new QBoardDto(
                        board.id
                        ,board.title
                        ,board.content
                        ,board.regDate
                        ,board.uptDate
                        ,board.viewCount
                        ,member.username))
                .from(board)
                .leftJoin(board.member, member)
                .orderBy(board.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
        return content;
    }
}
