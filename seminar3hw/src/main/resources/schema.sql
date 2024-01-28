CREATE TABLE IF NOT EXISTS userTable (
    firstName VARCHAR(50) NOT NULL PRIMARY KEY,
    age INT,
    email VARCHAR(50) NOT NULL
);

INSERT INTO userTable VALUES
('Ivan', 30, 'ivan@test.com'),
('Vasiliy', 21, 'vasiliy@test.com'),
('Мария', 28, 'maria@test.com');