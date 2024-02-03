CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_name CHAR(30),
    password CHAR(30),
    email CHAR(30),
    role CHAR(30)
);

CREATE TABLE projects (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name CHAR(30),
    description CHAR(50),
    created_date CHAR(50)
);