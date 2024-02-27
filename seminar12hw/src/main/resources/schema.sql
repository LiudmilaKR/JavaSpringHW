CREATE TABLE notes (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title CHAR(70),
    body VARCHAR(100),
    creation_date TIMESTAMP
--    creation_date CHAR(50)
);