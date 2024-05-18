CREATE TABLE IF NOT EXISTS files (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(256) NOT NULL,
    content LONGBLOB NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT uc_files_name UNIQUE(name),
    INDEX idx_files_id (id),
    INDEX idx_files_name (name)
) engine=InnoDB;