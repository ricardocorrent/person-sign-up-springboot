CREATE TABLE IF NOT EXISTS `person` (
  `id` binary(16) NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  `email` VARCHAR(200) NOT NULL,
  `createAt` DATETIME,
  `updateAt` DATETIME,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB;