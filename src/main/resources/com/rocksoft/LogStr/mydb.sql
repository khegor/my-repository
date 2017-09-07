-- MySQL Script generated by MySQL Workbench
-- Thu Sep  7 22:28:32 2017
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`ADDRESSES`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`ADDRESSES` (
  `ID` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `COUNTRY` VARCHAR(45) NOT NULL,
  `CITY` VARCHAR(45) NOT NULL,
  `STREET` VARCHAR(45) NOT NULL,
  `HOME_NUMBER` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`LOGIST`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`LOGIST` (
  `ID` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(45) NOT NULL,
  `SURNAME` VARCHAR(45) NOT NULL,
  `ESTABLISHED_POST` VARCHAR(45) NOT NULL,
  `ADDRESSES_ID` INT UNSIGNED NOT NULL,
  `DATE_OF_BIRTH` TIMESTAMP NOT NULL,
  PRIMARY KEY (`ID`, `ADDRESSES_ID`),
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC),
  INDEX `fk_WORKERS_ADDRESSES_idx` (`ADDRESSES_ID` ASC),
  CONSTRAINT `fk_WORKERS_ADDRESSES`
    FOREIGN KEY (`ADDRESSES_ID`)
    REFERENCES `mydb`.`ADDRESSES` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`DRIVER`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`DRIVER` (
  `ID` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(45) NOT NULL,
  `SURNAME` VARCHAR(45) NOT NULL,
  `ESTABLISHED_POST` VARCHAR(45) NOT NULL,
  `ADDRESSES_ID` INT UNSIGNED NOT NULL,
  `DATE_OF_BIRTH` TIMESTAMP NOT NULL,
  PRIMARY KEY (`ID`, `ADDRESSES_ID`),
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC),
  UNIQUE INDEX `NAME_UNIQUE` (`NAME` ASC),
  UNIQUE INDEX `SURNAME_UNIQUE` (`SURNAME` ASC),
  INDEX `fk_ADMINISTRATIONS_ADDRESSES1_idx` (`ADDRESSES_ID` ASC),
  CONSTRAINT `fk_ADMINISTRATIONS_ADDRESSES1`
    FOREIGN KEY (`ADDRESSES_ID`)
    REFERENCES `mydb`.`ADDRESSES` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`STOREKEEPER`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`STOREKEEPER` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(45) NOT NULL,
  `SURNAME` VARCHAR(45) NOT NULL,
  `ESTABLISHED_POST` VARCHAR(45) NOT NULL,
  `ADDRESSES_ID` INT UNSIGNED NOT NULL,
  `DATE_OF_BIRTH` TIMESTAMP NOT NULL,
  PRIMARY KEY (`ID`, `ADDRESSES_ID`),
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC),
  INDEX `fk_STOREKEEPER_ADDRESSES1_idx` (`ADDRESSES_ID` ASC),
  CONSTRAINT `fk_STOREKEEPER_ADDRESSES1`
    FOREIGN KEY (`ADDRESSES_ID`)
    REFERENCES `mydb`.`ADDRESSES` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`DIRECTOR`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`DIRECTOR` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(45) NOT NULL,
  `SURNAME` VARCHAR(45) NOT NULL,
  `ESTABLISHED_POST` VARCHAR(45) NOT NULL,
  `ADDRESSES_ID` INT UNSIGNED NOT NULL,
  `DATE_OF_BIRTH` TIMESTAMP NOT NULL,
  PRIMARY KEY (`ID`, `ADDRESSES_ID`),
  INDEX `fk_DIRECTOR_ADDRESSES1_idx` (`ADDRESSES_ID` ASC),
  CONSTRAINT `fk_DIRECTOR_ADDRESSES1`
    FOREIGN KEY (`ADDRESSES_ID`)
    REFERENCES `mydb`.`ADDRESSES` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`HEAD_OF_DEPARTMENT`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`HEAD_OF_DEPARTMENT` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(45) NOT NULL,
  `SURNAME` VARCHAR(45) NOT NULL,
  `ESTABLISHED_POST` VARCHAR(45) NOT NULL,
  `ADDRESSES_ID` INT UNSIGNED NOT NULL,
  `DATE_OF_BIRTH` TIMESTAMP NOT NULL,
  PRIMARY KEY (`ID`, `ADDRESSES_ID`),
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC),
  INDEX `fk_HEAD_OF_DEPARTMENT_ADDRESSES1_idx` (`ADDRESSES_ID` ASC),
  CONSTRAINT `fk_HEAD_OF_DEPARTMENT_ADDRESSES1`
    FOREIGN KEY (`ADDRESSES_ID`)
    REFERENCES `mydb`.`ADDRESSES` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
