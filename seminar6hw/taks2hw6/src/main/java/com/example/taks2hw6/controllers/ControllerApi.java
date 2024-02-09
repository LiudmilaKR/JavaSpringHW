package com.example.taks2hw6.controllers;

import com.example.taks2hw6.domain.Characters;
import com.example.taks2hw6.services.ServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerApi {

    @Autowired
    private ServiceApi serviceApi;

    @GetMapping("/")
    public String getCharacters(Model model) {
//        Characters allCharacters = serviceApi.getAllCharacters();
//        allCharacters.getResults()
//        model.addAttribute("pages", serviceApi.getAllCharacters().getInfo());
        model.addAttribute("characters", serviceApi.getAllCharacters().getResults());
//        model.addAttribute("characters", serviceApi.getAllCharacters());
        return "index";
    }
//    public ResponseEntity<Characters> getCharacters() {
//        return new ResponseEntity<>(serviceApi.getAllCharacters(), HttpStatus.OK);
//    }
}
