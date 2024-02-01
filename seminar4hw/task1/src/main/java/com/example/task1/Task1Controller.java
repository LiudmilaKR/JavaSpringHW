package com.example.task1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Класс Task1Controller обрабатывает запросы
 */
@Controller
@RequestMapping("/")
public class Task1Controller {

    /**
     * метод возвращает статическую страницу по адресу http://localhost:8080/
     * @return статическая страница task1.html
     */
    @GetMapping
    public String showPage() {
        return "task1.html";
    }
}
