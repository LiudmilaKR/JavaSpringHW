package com.example.task2.controllers;

import com.example.task2.domain.Project;
import com.example.task2.domain.User;
import com.example.task2.domain.UsersProject;
import com.example.task2.services.UserProjectService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/uspr")
    public List<UsersProject> usersProjectList() {
        return userProjectService.usersProjectList();
    }

    @PostMapping("/pr")
    private Project addProject(@RequestBody Project project) {
        return userProjectService.addProject(project);
    }

    @GetMapping("/uspr/{userId}/{projectId}")
    public void addUserToProject(@PathVariable Long userId, @PathVariable Long projectId) {
        userProjectService.addUserToProject(userId, projectId);
    }
}
