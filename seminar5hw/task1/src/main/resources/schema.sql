CREATE TABLE tasks (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    description CHAR(70),
--    status ENUM ('NOT_STARTED', 'IN_PROGRESS', 'COMPLETED'),
    status CHAR(15),
--    creation_date TIMESTAMP
    creation_date CHAR(50)
);