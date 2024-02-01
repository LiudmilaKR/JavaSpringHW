package com.example.task3.services;

import com.example.task3.domain.Cat;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс CatService - сервис действий над котиками
 */
@Service
public class CatService {

    /**
     * Поле список котиков
     */
    private List<Cat> catList;

    /**
     * Конструктор создания списка котиков
     */
    public CatService() {
        catList = new ArrayList<>();
        catList.add(new Cat(1, "нет имени", "рыжий котёнок в корзинке"));
        catList.add(new Cat(2, "нет имени", "полосатый котёнок в корзинке"));
        catList.add(new Cat(3, "нет имени", "котёнок на второй картинке"));
    }

    /**
     * Метод получения списка всех котиков
     * @return список всех котиков в catList
     */
    public List<Cat> getCatList() {
        return catList;
    }

    public Cat getCatByNumber(int numCat) {
        return catList.get(numCat);
    }
}
