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
    `Username` varchar(45) not null unique,
    `Password` varchar(45) not null,
    `ImgID` int not null,
    `Email` varchar(45) null default null unique,
    `Phone` varchar(45) null default null unique,
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
		foreign key (`UID`) references `petmeeting`.`User` (`UID`)
        -- ----------------
        ON delete restrict
        on update restrict,
        -- -----------------
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
        ON DELETE cascade
        -- --------------------
        on update cascade,
        -- --------------------
	constraint `VO_UID_key`
		foreign key (`UID`) references `petmeeting`.`User` (`UID`)
        on delete no action
        -- --------------------
        on update cascade
        -- --------------------
        )
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
        on delete no action
        -- --------------------
        on update cascade
        -- --------------------
        )
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
        on delete cascade
		-- --------------------
        on update cascade
        -- --------------------
        ,
	constraint `BO_WID_key`
		foreign key (`WID`) references `petmeeting`.`Worry` (`WID`)
        on delete cascade
		-- --------------------
        on update cascade
        -- --------------------
        )
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
        ON UPDATE RESTRICT
        ,
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


-- -----------------------------------------------------
-- Table `petmeeting`.`Housing`
-- -----------------------------------------------------
DROP TABLE IF exists `petmeeting`.`Housing`;

CREATE TABLE IF NOT exists `petmeeting`.`Housing`(
	`HousingID` int not null auto_increment primary key,
    `Name` varchar(45) not null)
    ENGINE = InnoDB
	DEFAULT CHARACTER SET = utf8mb4
	COLLATE = utf8mb4_0900_ai_ci;
    
    
-- -----------------------------------------------------
-- Table `petmeeting`.`City`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `petmeeting`.`City` ;

CREATE TABLE IF NOT exists `petmeeting`.`City`(
	`CityID` int not null auto_increment primary key,
    `Name` varchar(45) not null)
	ENGINE = InnoDB
	DEFAULT CHARACTER SET = utf8mb4
	COLLATE = utf8mb4_0900_ai_ci;
    
    
-- -----------------------------------------------------
-- Table `petmeeting`.`Entrust_Application`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `petmeeting`.`Entrust_Application` ;

CREATE TABLE IF NOT exists `petmeeting`.`Entrust_Application`(
	`EID` int not null auto_increment primary key,
    `Text` text not null,
    `Start_Date` datetime not null,
    `End_Date` datetime not null,
    `Preypayment` int not null,
    `Toypayment` int not null,
    `Created_Date` datetime not null,
    `CityID` int not null,
    `UID` int not null,
    index `CityID_idx` (`CityID` ASC) VISIBLE,
    index `UID_idx` (`UID` ASC) VISIBLE,
    constraint `EN_CityID_key`
		foreign key (`CityID`) references `petmeeting`.`City` (`CityID`)
        on delete restrict
        on update restrict,
	constraint `EN_UID_key`
		foreign key (`UID`) references `petmeeting`.`User` (`UID`)
        on delete cascade
        on update restrict)
	ENGINE = InnoDB
	DEFAULT CHARACTER SET = utf8mb4
	COLLATE = utf8mb4_0900_ai_ci;

-- type 변환
-- Start_Date, End_Date : date -> datetime
-- Preypayment, Toypayment : tinyint -> int

    
--------- ----------------------------------------------
-- Table `petmeeting`.`Housings`
-----------------------------------------------------
DROP TABLE IF exists `petmeeting`.`Housings`;

CREATE TABLE IF NOT exists `petmeeting`.`Housings`(
	`EID` int not null,
    `HousingID` int not null,
    primary key(`EID`,`HousingID`),
    index `HousingID_idx` (`HousingID` ASC) invisible,
    constraint `HO_EID_key`
		foreign key (`EID`) references `petmeeting`.`Entrust_Application` (`EID`)
        on delete cascade,
	constraint `HO_HousingID_key`
		foreign key (`HousingID`) references `petmeeting`.`Housing`(`HousingID`))
	ENGINE = InnoDB
	DEFAULT CHARACTER SET = utf8mb4
	COLLATE = utf8mb4_0900_ai_ci;
    
-- -----------------------------------------------------
-- Table `petmeeting`.`Raise_Application`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `petmeeting`.`Raise_Application` ;

CREATE TABLE IF NOT EXISTS `petmeeting`.`Raise_Application` (
	`RID` INT NOT NULL AUTO_INCREMENT primary key,
	`Motivation` TEXT NOT NULL,
	`Text` TEXT NOT NULL,
	`HousingID` INT NOT NULL,
	`EID` INT NOT NULL,
	`UID` INT NOT NULL,
	INDEX `EID_idx` (`EID` ASC) VISIBLE,
	INDEX `HousingID_idx` (`HousingID` ASC) VISIBLE,
	INDEX `UID_idx` (`UID` ASC) VISIBLE,
	CONSTRAINT `RA_EID_key`
		FOREIGN KEY (`EID`)
		REFERENCES `petmeeting`.`Entrust_Application` (`EID`)
		ON DELETE CASCADE,
	CONSTRAINT `RA_HousingID_key`
		FOREIGN KEY (`HousingID`)
		REFERENCES `petmeeting`.`Housing` (`HousingID`)
		ON DELETE RESTRICT
		ON UPDATE RESTRICT,
	CONSTRAINT `RA_UID_key`
		FOREIGN KEY (`UID`)
		REFERENCES `petmeeting`.`User` (`UID`))
	ENGINE = InnoDB
	DEFAULT CHARACTER SET = utf8mb4
	COLLATE = utf8mb4_0900_ai_ci;

-- -----------------------------------------------------
-- Table `petmeeting`.`Species`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `petmeeting`.`Species` ;

CREATE TABLE IF NOT EXISTS `petmeeting`.`Species` (
	`SpeciesID` INT NOT NULL AUTO_INCREMENT,
	`Name` VARCHAR(45) NOT NULL,
	PRIMARY KEY (`SpeciesID`))
	ENGINE = InnoDB
	AUTO_INCREMENT = 4
	DEFAULT CHARACTER SET = utf8mb4
	COLLATE = utf8mb4_0900_ai_ci;

-- -----------------------------------------------------
-- Table `petmeeting`.`Breed`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `petmeeting`.`Breed` ;

CREATE TABLE IF NOT EXISTS `petmeeting`.`Breed` (
	`BreedID` INT NOT NULL AUTO_INCREMENT,
	`SpeciesID` INT NOT NULL,
	`Name` VARCHAR(45) NOT NULL,
	PRIMARY KEY (`BreedID`),
	INDEX `KI_Species_ID_idx` (`SpeciesID` ASC) VISIBLE,
	CONSTRAINT `KI_Species_ID`
		FOREIGN KEY (`SpeciesID`)
		REFERENCES `petmeeting`.`Species` (`SpeciesID`)
		ON DELETE CASCADE
		ON UPDATE RESTRICT)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;
-- COMMENT = 'í’ˆì¢…';

-- -----------------------------------------------------
-- Table `petmeeting`.`Gender`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `petmeeting`.`Gender` ;

CREATE TABLE IF NOT EXISTS `petmeeting`.`Gender` (
  `GenderID` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`GenderID`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `petmeeting`.`Pet`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `petmeeting`.`Pet` ;

CREATE TABLE IF NOT EXISTS `petmeeting`.`Pet` (
  `PID` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  `Year` INT NOT NULL,
  `GenderID` INT NOT NULL,
  `GradeRatio` INT NOT NULL,
  `Description` TEXT NOT NULL,
  `ImgID` INT NOT NULL,
  `EID` INT NULL DEFAULT NULL,
  `UID` INT NOT NULL,
  `BreedID` INT NOT NULL,
  PRIMARY KEY (`PID`),
  INDEX `EID_idx` (`EID` ASC) VISIBLE,
  INDEX `BreedID_idx` (`BreedID` ASC) VISIBLE,
  INDEX `UID_idx` (`UID` ASC) VISIBLE,
  INDEX `PE_ImgID_key_idx` (`ImgID` ASC) VISIBLE,
  INDEX `PE_Gender_key_idx` (`GenderID` ASC) VISIBLE,
  CONSTRAINT `PE_EID_key`
    FOREIGN KEY (`EID`)
    REFERENCES `petmeeting`.`Entrust_Application` (`EID`)
    ON DELETE SET NULL
    ON UPDATE RESTRICT,
  CONSTRAINT `PE_KindID_key`
    FOREIGN KEY (`BreedID`)
    REFERENCES `petmeeting`.`Breed` (`BreedID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `PE_UID_key`
    FOREIGN KEY (`UID`)
    REFERENCES `petmeeting`.`User` (`UID`)
    ON DELETE CASCADE,
  CONSTRAINT `PE_ImgID_key`
    FOREIGN KEY (`ImgID`)
    REFERENCES `petmeeting`.`Image` (`ImgID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `PE_Gender_key`
    FOREIGN KEY (`GenderID`)
    REFERENCES `petmeeting`.`Gender` (`GenderID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
KEY_BLOCK_SIZE = 16;
