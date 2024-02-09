package com.example.taks2hw6.domain;

import lombok.Data;

@Data
public class Info {
//    какая страница в данном случае
    private Integer count;
    private Integer page;
    private String next;
    private String prev;
}
