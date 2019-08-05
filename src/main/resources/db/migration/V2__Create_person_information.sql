create TABLE IF NOT EXISTS person_information(
id BINARY(16) NOT NULL,
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

CREATE TABLE IF NOT EXISTS `user` (
  `id` BINARY(16) NOT NULL,
  `user_name` VARCHAR(255) NOT NULL,
  `full_name` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `account_non_expired` TINYINT NULL DEFAULT NULL,
  `account_non_locked` TINYINT NULL DEFAULT NULL,
  `credentials_non_expired` TINYINT NULL DEFAULT NULL,
  `actived` TINYINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `permission` (
  `id` BINARY(16) NOT NULL,
  `description` VARCHAR(255) NULL DEFAULT 'null',
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `user_permission` (
  `user_id` BINARY(16) NOT NULL,
  `permission_id` BINARY(16) NOT NULL,
  PRIMARY KEY (`user_id`, `permission_id`),
  INDEX `fk_users_has_permission_permission1_idx` (`permission_id` ASC) VISIBLE,
  INDEX `fk_users_has_permission_users1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_users_has_permission_users1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_users_has_permission_permission1`
    FOREIGN KEY (`permission_id`)
    REFERENCES `permission` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

