package com.example.taks2hw6.domain;

import lombok.Data;

import java.util.List;

@Data
public class Characters {

//    те результаты, которые пришлет доменный сервер
    Info info;
    List<Result> results;
}
