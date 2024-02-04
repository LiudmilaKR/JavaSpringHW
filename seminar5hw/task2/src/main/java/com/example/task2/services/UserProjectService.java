package com.example.task2.services;

import com.example.task2.domain.Project;
import com.example.task2.domain.User;
import com.example.task2.domain.UsersProject;
import com.example.task2.repositories.ProjectRepository;
import com.example.task2.repositories.UserRepository;
import com.example.task2.repositories.UsersProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Класс UserProjectService - севис взаимодействий с базами данных
 */
@Service
@AllArgsConstructor
public class UserProjectService {

    /**
     * Поле доступа к базе данных users
     */
    private UserRepository userRepository;
    /**
     * Поле доступа к базе данных projects
     */
    private ProjectRepository projectRepository;
    /**
     * Поле доступа к базе данных users-project
     */
    private UsersProjectRepository usersProjectRepository;

    public List<User> userList() {
        return userRepository.findAll();
    }

    public List<Project> projectList() {
        return projectRepository.findAll();
    }

    public List<UsersProject> usersProjectList() {
        return usersProjectRepository.findAll();
    }

    public Project addProject(Project project) {
        project.setCreatedDate(LocalDate.now());
        return projectRepository.save(project);
    }

    public List<User> getUsersByProjectId(Long projectId) {
        return null;
    }

//     - метод, возвращающий список пользователей, связанных с определенным проектом

    public List<Project> getProjectsByUserId(Long userId) {
        return null;
    }
//     - метод, возвращающий список проектов, связанных с определенным пользователем

    public void addUserToProject(Long userId, Long projectId) {
        Optional<UsersProject> usersProject = usersProjectRepository.findById(projectId);
        if (usersProject.isPresent()) {
            usersProject.get().setRelatedUserId(userRepository.findById(userId).get());
        } else {
            UsersProject usersProject1 = usersProjectRepository.save(new UsersProject());
            usersProject1.setRelatedUserId(userRepository.findById(userId).get());
            usersProject1.setRelatedProjectId(projectRepository.findById(projectId).get());
        }
    }
//     - метод, добавляющий пользователя к проекту
    public void removeUserFromProject(Long userId, Long projectId) {

    }
//     - метод, удаляющий пользователя из проекта

}
