package com.thecar.repository;

import com.thecar.model.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardRepository {

    Page<Board> selectBoardList(String searchVal, Pageable pageable);


}
