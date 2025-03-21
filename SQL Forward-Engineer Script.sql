-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema cpa_project
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema cpa_project
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cpa_project` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `cpa_project` ;

-- -----------------------------------------------------
-- Table `cpa_project`.`records`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cpa_project`.`records` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `owner` VARCHAR(45) NOT NULL DEFAULT 'unknown',
  `type` VARCHAR(45) NOT NULL DEFAULT 'personal',
  `total_revenue` DECIMAL(64,2) UNSIGNED ZEROFILL NULL DEFAULT '00000000000000000000000000000000000000000000000000000000000000.00',
  `taxes_paid` DECIMAL(64,2) UNSIGNED ZEROFILL NULL DEFAULT '00000000000000000000000000000000000000000000000000000000000000.00',
  `taxes_owed` DECIMAL(64,2) UNSIGNED ZEROFILL NULL DEFAULT '00000000000000000000000000000000000000000000000000000000000000.00',
  `status` VARCHAR(45) NOT NULL DEFAULT 'unfiled',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 82
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `cpa_project`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cpa_project`.`users` (
  `id` INT NOT NULL,
  `username` VARCHAR(45) NULL DEFAULT NULL,
  `password` VARCHAR(45) NULL DEFAULT NULL,
  `license` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
