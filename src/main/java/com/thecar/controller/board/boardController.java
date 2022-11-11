package com.thecar.controller.board;

import org.springframework.web.bind.annotation.RequestMapping;

public class boardController {

    @RequestMapping("/goBoard.do")
    public String goBoard() {
        System.err.println("goBoard");
        return "/board";
    }
}
