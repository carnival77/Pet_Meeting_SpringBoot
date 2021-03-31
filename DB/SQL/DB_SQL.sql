-- -----------------------------------------------------
-- Schema petmeeting
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `petmeeting`;
USE `petmeeting`;

-- -----------------------------------------------------
-- CREATE TABLES
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Table `petmeeting`.`Image`
-- -----------------------------------------------------
DROP TABLE IF exists `petmeeting`.`Image`;

CREATE TABLE IF NOT exists `petmeeting`.`Image`(
	`ImgID` int not null auto_increment primary key,
	`Filename` varchar(45) not null,
    `MimeType` varchar(45) not null,
    `OriginalName` varchar(45) not null,
    `Size` int not null,
    unique index `ImgID_UNIQUE` (`Filename` ASC) VISIBLE)
	engine = InnoDB;
    
-- -----------------------------------------------------
-- Table `petmeeting`.`User`
-- -----------------------------------------------------
DROP TABLE IF exists `petmeeting`.`User`;

CREATE TABLE IF NOT exists `petmeeting`.`User`(
	`UID` int not null auto_increment primary key,
    `Username` varchar(45) not null,
    `Password` varchar(45) not null,
    `ImgID` int not null,
    `Email` varchar(45) null default null,
    `Phone` varchar(45) null default null,
    INDEX `US_ImgID_key_idx` (`ImgID` ASC) VISIBLE,
    constraint `US_ImgID_key`
		foreign key (`ImgID`) references `petmeeting`.`Image` (`ImgID`)
        ON delete restrict
        on update restrict)
	engine=InnoDB
    auto_increment = 9
    default character set = utf8mb4
    collate= utf8mb4_0900_ai_ci;
    
    
-- -----------------------------------------------------
-- Table `petmeeting`.`Showoff`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `petmeeting`.`Showoff` ;

CREATE TABLE IF NOT exists `petmeeting`.`Showoff`(
	`SID` int not null auto_increment primary key,
    `Text` Text not null,
    `Date` DATETIME not null,
    `ImgID` int not null,
    `UID` int not null,
    INDEX `UID_idx` (`UID` ASC) VISIBLE,
    index `SH_ImgID_key_idx` (`ImgID` ASC) visible,
    constraint `SH_UID_key`
		foreign key (`UID`) references `petmeeting`.`User` (`UID`),
    constraint `SH_ImgID_key`
		foreign key (`ImgID`) references `petmeeting`.`Image` (`ImgID`)
        ON delete restrict
        on update restrict)
	engine=InnoDB
    default character set = utf8mb4
    collate= utf8mb4_0900_ai_ci;

-- -----------------------------------------------------
-- Table `petmeeting`.`Vote`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `petmeeting`.`Vote` ;

CREATE TABLE IF NOT exists `petmeeting`.`Vote`(
	`UID` int not null,
    `SID` int not null,
    PRIMARY KEY (`UID`,`SID`),
    index `SID_idx` (`SID` ASC) visible,
    constraint `VO_SID_key` 
		foreign key (`SID`) references `petmeeting`.`Showoff` (`SID`)
        ON DELETE cascade,
	constraint `VO_UID_key`
		foreign key (`UID`) references `petmeeting`.`User` (`UID`)
        on delete no action)
	engine=InnoDB
    default character set = utf8mb4
    collate= utf8mb4_0900_ai_ci;
    
-- -----------------------------------------------------
-- Table `petmeeting`.`Worry`
-- -----------------------------------------------------
DROP TABLE IF exists `petmeeting`.`Worry`;

CREATE TABLE IF NOT exists `petmeeting`.`Worry`(
	`WID` int not null auto_increment primary key,
    `Title` varchar(45) not null,
    `Text` Text not null,
    `Date` datetime not null,
    `UID` int not null,
    index `UID_idx` (`UID` ASC) VISIBLE,
    constraint `WO_UID_key`
		foreign key (`UID`) references `petmeeting`.`User` (`UID`)
        on delete no action)
	engine = InnoDB
	default character set = utf8mb4
    collate= utf8mb4_0900_ai_ci;
    
-- -----------------------------------------------------
-- Table `petmeeting`.`BookMarkTo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `petmeeting`.`BookMarkTo` ;

CREATE TABLE IF NOT exists `petmeeting`.`BookMarkTo`(
	`WID` int not null,
    `UID` int not null,
    primary key (`WID`,`UID`),
    index `UID_idx` (`UID` ASC) VISIBLE,
    constraint `BO_UID_key`
		foreign key (`UID`) references `petmeeting`.`User` (`UID`)
        on delete cascade,
	constraint `BO_WID_key`
		foreign key (`WID`) references `petmeeting`.`Worry` (`WID`)
        on delete cascade)
	engine = InnoDB
	default character set = utf8mb4
    collate= utf8mb4_0900_ai_ci;
    
-- -----------------------------------------------------
-- Table `petmeeting`.`Comment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `petmeeting`.`Comment` ;

CREATE TABLE IF NOT exists `petmeeting`.`Comment`(
	`CID` int not null auto_increment primary key,
	`Text` TEXT NOT NULL,
	`Date` DATETIME NOT NULL,
	`CID_ReplyTo` INT NULL,
	`UID` INT NOT NULL,
	`WID` INT NOT NULL,
	  INDEX `CID_ReplyTo_idx` (`CID_ReplyTo` ASC) INVISIBLE,
	  INDEX `CO_UID_key_idx` (`UID` ASC) VISIBLE,
	  INDEX `CO_WID_key_idx` (`WID` ASC) VISIBLE,
	  CONSTRAINT `CO_CID_key`
		FOREIGN KEY (`CID_ReplyTo`)
		REFERENCES `petmeeting`.`Comment` (`CID`)
		ON DELETE CASCADE
		ON UPDATE RESTRICT,
	  CONSTRAINT `CO_UID_key`
		FOREIGN KEY (`UID`)
		REFERENCES `petmeeting`.`User` (`UID`)
		ON DELETE NO ACTION
		ON UPDATE RESTRICT,
	  CONSTRAINT `CO_WID_key`
		FOREIGN KEY (`WID`)
		REFERENCES `petmeeting`.`Worry` (`WID`)
		ON DELETE CASCADE
		ON UPDATE RESTRICT)
	ENGINE = InnoDB
	DEFAULT CHARACTER SET = utf8mb4
	COLLATE = utf8mb4_0900_ai_ci
	COMMENT = 'When CID=1, unknown issue occured\nSo, we never mind of index 1 of CID';

