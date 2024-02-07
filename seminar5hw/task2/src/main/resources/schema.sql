CREATE TABLE users (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_name CHAR(30) NOT NULL,
    password CHAR(30) NOT NULL,
    email CHAR(30) NOT NULL,
    role CHAR(30) NOT NULL
);

CREATE TABLE projects (
    id INT  NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name CHAR(30) NOT NULL,
    description CHAR(50) NOT NULL,
    created_date DATE
);

CREATE TABLE users_project (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    related_user_id INT,
    related_project_id INT,
    CONSTRAINT project_id FOREIGN KEY (related_project_id) REFERENCES projects (id),
    CONSTRAINT user_id FOREIGN KEY (related_user_id) REFERENCES users (id)
);
--CREATE TABLE users_project (
--    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
--    related_entity_id INT,
--    project_id INT,
--    user_id INT,
--    CONSTRAINT related_project_id FOREIGN KEY (project_id) REFERENCES projects (id),
--    CONSTRAINT related_user_id FOREIGN KEY (user_id) REFERENCES users (id)
--);