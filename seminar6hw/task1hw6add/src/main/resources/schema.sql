CREATE TABLE IF NOT EXISTS notes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    content VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL
    );