package com.example.task2.controllers;

import com.example.task2.domain.Project;
import com.example.task2.domain.User;
import com.example.task2.services.UserProjectService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserProjectController {

    private UserProjectService userProjectService;

    @GetMapping("/us")
    public List<User> userList() {
        return userProjectService.userList();
    }

    @GetMapping("/pr")
    public List<Project> projectList() {
        return userProjectService.projectList();
    }
}
