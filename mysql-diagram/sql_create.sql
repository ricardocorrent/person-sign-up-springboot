
-- MySQL Script generated by MySQL Workbench
-- Thu 18 Jul 2019 09:52:12 PM -03
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- drop schema `mydb`;
-- -----------------------------------------------------
-- Schema person-sign-up-springboot
-- -----------------------------------------------------
-- CREATE SCHEMA IF NOT EXISTS `person-sign-up-springboot` ;
USE `person-sign-up-springboot`;

-- -----------------------------------------------------
-- Table `mydb`.`person`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `person-sign-up-springboot`.`person` (
  `id` VARCHAR(255) NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  `email` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`person_information`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `person-sign-up-springboot`.`person_information` (
  `id` VARCHAR(255) NOT NULL COMMENT '	',
  `person_id` VARCHAR(255) NOT NULL,
  `key` VARCHAR(100) NOT NULL,
  `value` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`, `person_id`),
  INDEX `fk_person_information_person_idx` (`person_id` ASC) VISIBLE,
  CONSTRAINT `fk_person_information_person`
    FOREIGN KEY (`person_id`)
    REFERENCES `person-sign-up-springboot`.`person` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

