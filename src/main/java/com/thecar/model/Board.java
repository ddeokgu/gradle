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
    private int board_seq;

    private String board_title;

    private String board_contents;

    private String reg_id;

    private LocalDate reg_date;

    private String dlt_yn;

}
