package com.example.taks2hw6.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Result {
//    описание каждого характера
    private Integer id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private String image;
    private String url;
    private Date created;
}
