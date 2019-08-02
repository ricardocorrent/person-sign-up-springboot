create TABLE IF NOT EXISTS person(
    id BINARY(16)   NOT NULL,
name VARCHAR(255)NOT NULL,
email VARCHAR(200)NOT NULL,
created_at DATETIME,
updated_at DATETIME,
PRIMARY KEY(id)
)
ENGINE = InnoDB
;

create TABLE IF NOT EXISTS person_information(
    id BINARY(16)   NOT NULL,
person_id BINARY(16)NOT NULL,
label VARCHAR(100)NOT NULL,
value VARCHAR(255)NOT NULL,
created_at DATETIME,
updated_at DATETIME,
PRIMARY KEY(id, person_id),
INDEX fk_person_information_person_idx(person_id ASC)VISIBLE,
CONSTRAINT fk_person_information_person
FOREIGN KEY(person_id)
REFERENCES person(id)
  ON
delete NO ACTION ON
update NO ACTION
)
            ENGINE = InnoDB;
