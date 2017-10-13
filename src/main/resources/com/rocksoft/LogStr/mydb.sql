-- MySQL Script generated by MySQL Workbench
-- Thu Oct 12 13:00:00 2017
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
  `CREATED_AT` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `MODIFIED_AT` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`LOGISTS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`LOGISTS` (
  `ID` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(45) NOT NULL,
  `SURNAME` VARCHAR(45) NOT NULL,
  `ESTABLISHED_POST` VARCHAR(45) NOT NULL,
  `DATE_OF_BIRTH` DATE NOT NULL,
  `ADDRESSES_ID` INT UNSIGNED NOT NULL,
  `CREATED_AT` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `MODIFIED_AT` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC),
  INDEX `fk_LOGIST_ADDRESSES1_idx` (`ADDRESSES_ID` ASC),
  UNIQUE INDEX `ADDRESSES_ID_UNIQUE` (`ADDRESSES_ID` ASC),
  CONSTRAINT `fk_LOGIST_ADDRESSES1`
    FOREIGN KEY (`ADDRESSES_ID`)
    REFERENCES `mydb`.`ADDRESSES` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`DRIVERS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`DRIVERS` (
  `ID` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(45) NOT NULL,
  `SURNAME` VARCHAR(45) NOT NULL,
  `ESTABLISHED_POST` VARCHAR(45) NOT NULL,
  `DATE_OF_BIRTH` DATE NOT NULL,
  `CREATED_AT` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `MODIFIED_AT` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `ADDRESSES_ID` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC),
  INDEX `fk_DRIVERS_ADDRESSES1_idx` (`ADDRESSES_ID` ASC),
  CONSTRAINT `fk_DRIVERS_ADDRESSES1`
    FOREIGN KEY (`ADDRESSES_ID`)
    REFERENCES `mydb`.`ADDRESSES` (`ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`STOREKEEPERS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`STOREKEEPERS` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(45) NOT NULL,
  `SURNAME` VARCHAR(45) NOT NULL,
  `ESTABLISHED_POST` VARCHAR(45) NOT NULL,
  `DATE_OF_BIRTH` DATE NOT NULL,
  `ADDRESSES_ID` INT UNSIGNED NOT NULL,
  `CREATED_AT` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `MODIFIED_AT` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC),
  INDEX `fk_STOREKEEPER_ADDRESSES1_idx` (`ADDRESSES_ID` ASC),
  UNIQUE INDEX `ADDRESSES_ID_UNIQUE` (`ADDRESSES_ID` ASC),
  CONSTRAINT `fk_STOREKEEPER_ADDRESSES1`
    FOREIGN KEY (`ADDRESSES_ID`)
    REFERENCES `mydb`.`ADDRESSES` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`DIRECTORS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`DIRECTORS` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(45) NOT NULL,
  `SURNAME` VARCHAR(45) NOT NULL,
  `ESTABLISHED_POST` VARCHAR(45) NOT NULL,
  `DATE_OF_BIRTH` DATE NOT NULL,
  `ADDRESSES_ID` INT UNSIGNED NOT NULL,
  `CREATED_AT` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `MODIFIED_AT` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`),
  INDEX `fk_DIRECTOR_ADDRESSES1_idx` (`ADDRESSES_ID` ASC),
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC),
  UNIQUE INDEX `ADDRESSES_ID_UNIQUE` (`ADDRESSES_ID` ASC),
  CONSTRAINT `fk_DIRECTOR_ADDRESSES1`
    FOREIGN KEY (`ADDRESSES_ID`)
    REFERENCES `mydb`.`ADDRESSES` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`HEADS_OF_DEPARTMENTS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`HEADS_OF_DEPARTMENTS` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(45) NOT NULL,
  `SURNAME` VARCHAR(45) NOT NULL,
  `ESTABLISHED_POST` VARCHAR(45) NOT NULL,
  `DATE_OF_BIRTH` DATE NOT NULL,
  `ADDRESSES_ID` INT UNSIGNED NOT NULL,
  `CREATED_AT` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `MODIFIED_AT` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC),
  INDEX `fk_HEAD_OF_DEPARTMENT_ADDRESSES1_idx` (`ADDRESSES_ID` ASC),
  UNIQUE INDEX `ADDRESSES_ID_UNIQUE` (`ADDRESSES_ID` ASC),
  CONSTRAINT `fk_HEAD_OF_DEPARTMENT_ADDRESSES1`
    FOREIGN KEY (`ADDRESSES_ID`)
    REFERENCES `mydb`.`ADDRESSES` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`DRIVERS_CARS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`DRIVERS_CARS` (
  `ID` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `CAR_MODEL` VARCHAR(255) NOT NULL,
  `NUMBER` VARCHAR(6) NOT NULL,
  `CREATED_AT` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `MODIFIED_AT` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC),
  UNIQUE INDEX `NUMBER_UNIQUE` (`NUMBER` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`DRIVER_has_DRIVERS_CARS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`DRIVER_has_DRIVERS_CARS` (
  `DRIVER_ID` INT UNSIGNED NOT NULL,
  `DRIVERS_CARS_ID` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`DRIVER_ID`, `DRIVERS_CARS_ID`),
  INDEX `fk_DRIVER_has_DRIVERS_CARS_DRIVER1_idx` (`DRIVER_ID` ASC),
  INDEX `fk_DRIVER_has_DRIVERS_CARS_DRIVERS_CARS1_idx` (`DRIVERS_CARS_ID` ASC),
  CONSTRAINT `fk_DRIVER_has_DRIVERS_CARS_DRIVER1`
    FOREIGN KEY (`DRIVER_ID`)
    REFERENCES `mydb`.`DRIVERS` (`ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_DRIVER_has_DRIVERS_CARS_DRIVERS_CARS1`
    FOREIGN KEY (`DRIVERS_CARS_ID`)
    REFERENCES `mydb`.`DRIVERS_CARS` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ORDERS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`ORDERS` (
  `ID` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `OWNER_ORGANISATION_NAME` VARCHAR(255) NOT NULL,
  `OWNERSHIP_TYPE` VARCHAR(45) NOT NULL,
  `OPERATION_TYPE` VARCHAR(255) NOT NULL,
  `CREATED_AT` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `MODIFIED_AT` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `LOGISTS_ID` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC),
  UNIQUE INDEX `OPERATION_TYPE_UNIQUE` (`OPERATION_TYPE` ASC),
  UNIQUE INDEX `LOGISTS_ID_UNIQUE` (`LOGISTS_ID` ASC),
  CONSTRAINT `fk_ORDERS_LOGISTS1`
    FOREIGN KEY (`LOGISTS_ID`)
    REFERENCES `mydb`.`LOGISTS` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
