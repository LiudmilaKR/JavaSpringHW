package com.example.task2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

/**
 * Класс Task1Controller обрабатывает запросы
 */
@Controller
public class Task2Controller {

    /**
     * настраиваемый аттрибут для первого кота
     */
    @Value("${chosen.cat1}")
    private String cat1;
    /**
     * настраиваемый аттрибут для второго кота
     */
    @Value("${chosen.cat2}")
    private String cat2;
    /**
     * настраиваемый аттрибут для третьего кота
     */
    @Value("${chosen.cat3}")
    private String cat3;

    /**
     * метод возвращает страницу по адресу http://localhost:8080/cat со случайным выбором кота
     * @param model карта, на которую помещаем данные для отображения на html странице
     * @return страница task2.html
     */
    @GetMapping("/cat")
    public String chooseCat(Model model) {
        int num = new Random().nextInt(3);
        String chosenCat;
        if (num == 0) chosenCat = "рыжий котёнок в корзинке";
        else if (num == 1) chosenCat = "полосатый котёнок в корзинке";
        else chosenCat = "котёнок на второй картинке";
        model.addAttribute("cat", chosenCat);
        return "task2";
    }

    /**
     * метод возвращает страницу по адресу http://localhost:8080/cat/(номер)
     * @param num номер кота
     * @param model карта, на которую помещаем данные для отображения на html странице
     * @return страница task2.html
     */
    @GetMapping("/cat/{num}")
    public String chooseCat(@PathVariable int num, Model model) {
        String chosenCat = "Вы не выбрали кота!";
        if (num == 1) chosenCat = "рыжий котёнок в корзинке";
        else if (num == 2) chosenCat = "полосатый котёнок в корзинке";
        else if (num == 3) chosenCat = "котёнок на второй картинке";
        model.addAttribute("cat", chosenCat);
        return "task2";
    }

    /**
     * метод возвращает страницу по адресу http://localhost:8080/cats?num=(номер)
     * @param num номер кота
     * @param model карта, на которую помещаем данные для отображения на html странице
     * @return страница task2.html
     */
    @GetMapping("/cats")
    public String chooseCat3(@RequestParam("num") int num, Model model) {
        String chosenCat = "Вы не выбрали кота!";
        if (num == 1) chosenCat = cat1;
        else if (num == 2) chosenCat = cat2;
        else if (num == 3) chosenCat = cat3;
        model.addAttribute("cat", chosenCat);
        return "task2";
    }
}
