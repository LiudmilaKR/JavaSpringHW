INSERT INTO users(user_name, password, email, role)
VALUES ('Василий', '1', 'vas@test.com', 'администратор'),
        ('Иван', '2', 'iv@test.com', 'логист'),
        ('Мария', '3', 'mar@test.com', 'бухгалтер'),
        ('Петр', '4', 'pet@test.com', 'юрист');

INSERT INTO projects(name, description, created_date)
VALUES ('столовая', 'организация столовой в офисе', '2024-02-04'),
        ('игровая', 'ремонт игровой комнаты', '2024-02-04');

INSERT INTO users_project(related_user_id, related_project_id)
VALUES (1, 2), (2, 1), (3, 1), (4, 1);