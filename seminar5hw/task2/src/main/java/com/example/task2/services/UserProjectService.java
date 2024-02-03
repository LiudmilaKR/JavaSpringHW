package com.example.task2.services;

import com.example.task2.domain.Project;
import com.example.task2.domain.User;
import com.example.task2.repositories.ProjectRepository;
import com.example.task2.repositories.UserRepository;
import com.example.task2.repositories.UsersProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserProjectService {

    private UserRepository userRepository;
    private ProjectRepository projectRepository;
//    private UsersProjectRepository usersProjectRepository;

    public List<User> userList() {
        return userRepository.findAll();
    }

    public List<Project> projectList() {
        return projectRepository.findAll();
    }
}
