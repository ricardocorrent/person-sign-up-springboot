create TABLE IF NOT EXISTS person(
    id BINARY(16)   NOT NULL,
name VARCHAR(150)NOT NULL,
email VARCHAR(255)NOT NULL,
created_at DATETIME,
updated_at DATETIME,
PRIMARY KEY(id)
)
ENGINE = InnoDB;