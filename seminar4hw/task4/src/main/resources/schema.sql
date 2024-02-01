CREATE TABLE IF NOT EXISTS userTable (
    id INT AUTO_INCREMENT PRIMARY KEY,
    firstName VARCHAR(50) NOT NULL,
    lastName VARCHAR(50) NOT NULL
);

INSERT INTO userTable(firstName, lastName) VALUES
('Ivan', 'Perov'),
('Vasiliy', 'Serovich'),
('Мария', 'Kurikins');