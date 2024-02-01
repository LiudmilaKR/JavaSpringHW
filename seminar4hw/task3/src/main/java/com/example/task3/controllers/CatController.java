package com.example.task3.controllers;

import com.example.task3.domain.Cat;
import com.example.task3.services.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Класс CatController обрабатывает запросы
 */
@Controller
public class CatController {

    /**
     * Поле сервиса действий над котиками
     */
    @Autowired
    private CatService catService;

    /**
     * Метод возвращает страницу по адресу http://localhost:8080/cats
     * @param model карта, на которую помещаем данные для отображения на html странице
     * @return страница task3.html
     */
    @GetMapping("/cats")
    public String getCatList(Model model) {
        model.addAttribute("catList", catService.getCatList());
        return "task3";
    }

    /**
     * Метод добавляет имя котика
     * @param numCat номер котика, которому даём имя
     * @param catName имя, которое даём котику
     * @param model карта, на которую помещаем данные для отображения на html странице
     * @return страница task3.html
     */
    @PostMapping("/cats")
    public String addNamesForCats(@RequestParam(value = "number") int numCat,
                                  @RequestParam(value = "name") String catName, Model model) {
        catService.getCatByNumber(numCat - 1).setName(catName);
        model.addAttribute("catList", catService.getCatList());
        return "task3";
    }
}
