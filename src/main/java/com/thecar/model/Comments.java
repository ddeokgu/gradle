package com.thecar.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comments_seq", nullable = false)
    private int comments_seq;

    private String board_seq;

    private String commnets_contents;

    private String reg_id;
    private Date reg_date;

    private String dlt_yn;

    @PrePersist
    void reg_date() {
        this.reg_date = new Date();
    }

}
