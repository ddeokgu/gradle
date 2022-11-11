package com.thecar.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_seq", nullable = false)
    private int board_seq; // seq auto increment

    private String board_title; // 제목

    private String board_contents; // 내용

    private String reg_id; // 등록자

    private LocalDate reg_date; // 등록 날짜

    private String dlt_yn; // 삭제 여부


}
