CREATE TABLE IF NOT EXISTS files (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(256) NOT NULL,
    path VARCHAR(512) NOT NULL,
    url TEXT NOT NULL,
    content LONGBLOB NOT NULL,
    created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    CONSTRAINT uc_files_url UNIQUE(path),
    INDEX idx_files_id (id),
    INDEX idx_files_url (path)
) engine=InnoDB CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;