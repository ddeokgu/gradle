package com.thecar.controller.board;

import com.thecar.model.Board;
import com.thecar.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class boardController {

    private final BoardRepository boardRepository;

    @RequestMapping("/goBoard.do")
    public String goBoard(String searchVal, Pageable pageable, Model model) {
        System.err.println("goBoard");
        Page<Board> resultList = boardRepository.selectBoardList(searchVal, pageable);
        model.addAttribute("list", resultList);
        model.addAttribute("maxPage", 5);
        pageModelPut(resultList, model);
        return "/board";
    }

    private void pageModelPut(Page<Board> results, Model model) {
        model.addAttribute("totalCount", results.getTotalElements());
        model.addAttribute("size", results.getPageable().getPageSize());
        model.addAttribute("number", results.getPageable().getPageNumber());
    }

    @GetMapping("/write")
    public String write() {
        return "/board/write";
    }

    @GetMapping("/update")
    public String update(){
        return "/board/update";
    }
}
