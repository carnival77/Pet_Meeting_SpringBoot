-- MySQL Script generated by MySQL Workbench
-- Thu Oct  8 16:21:59 2020
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema petmeeting
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `petmeeting` ;

-- -----------------------------------------------------
-- Schema petmeeting
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `petmeeting` ;
USE `petmeeting` ;

-- -----------------------------------------------------
-- Table `petmeeting`.`Image`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `petmeeting`.`Image` ;

CREATE TABLE IF NOT EXISTS `petmeeting`.`Image` (
  `ImgID` INT NOT NULL AUTO_INCREMENT,
  `Filename` VARCHAR(45) NOT NULL,
  `MimeType` VARCHAR(45) NOT NULL,
  `OriginalName` VARCHAR(45) NOT NULL,
  `Size` INT NOT NULL,
  UNIQUE INDEX `ImgID_UNIQUE` (`Filename` ASC) VISIBLE,
  PRIMARY KEY (`ImgID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `petmeeting`.`User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `petmeeting`.`User` ;

CREATE TABLE IF NOT EXISTS `petmeeting`.`User` (
  `UID` INT NOT NULL AUTO_INCREMENT,
  `Username` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(45) NOT NULL,
  `ImgID` INT NOT NULL,
  `Email` VARCHAR(45) NULL DEFAULT NULL,
  `Phone` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`UID`),
  INDEX `US_ImgID_key_idx` (`ImgID` ASC) VISIBLE,
  CONSTRAINT `US_ImgID_key`
    FOREIGN KEY (`ImgID`)
    REFERENCES `petmeeting`.`Image` (`ImgID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `petmeeting`.`Worry`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `petmeeting`.`Worry` ;

CREATE TABLE IF NOT EXISTS `petmeeting`.`Worry` (
  `WID` INT NOT NULL AUTO_INCREMENT,
  `Title` VARCHAR(45) NOT NULL,
  `Text` TEXT NOT NULL,
  `Date` DATETIME NOT NULL,
  `UID` INT NOT NULL,
  PRIMARY KEY (`WID`),
  INDEX `UID_idx` (`UID` ASC) VISIBLE,
  CONSTRAINT `WO_UID_key`
    FOREIGN KEY (`UID`)
    REFERENCES `petmeeting`.`User` (`UID`)
    ON DELETE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `petmeeting`.`BookMarkTo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `petmeeting`.`BookMarkTo` ;

CREATE TABLE IF NOT EXISTS `petmeeting`.`BookMarkTo` (
  `WID` INT NOT NULL,
  `UID` INT NOT NULL,
  PRIMARY KEY (`WID`, `UID`),
  INDEX `UID_idx` (`UID` ASC) VISIBLE,
  CONSTRAINT `BO_UID_key`
    FOREIGN KEY (`UID`)
    REFERENCES `petmeeting`.`User` (`UID`)
    ON DELETE CASCADE,
  CONSTRAINT `BO_WID_key`
    FOREIGN KEY (`WID`)
    REFERENCES `petmeeting`.`Worry` (`WID`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `petmeeting`.`City`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `petmeeting`.`City` ;

CREATE TABLE IF NOT EXISTS `petmeeting`.`City` (
  `CityID` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`CityID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `petmeeting`.`Comment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `petmeeting`.`Comment` ;

CREATE TABLE IF NOT EXISTS `petmeeting`.`Comment` (
  `CID` INT NOT NULL AUTO_INCREMENT,
  `Text` TEXT NOT NULL,
  `Date` DATETIME NOT NULL,
  `CID_ReplyTo` INT NULL,
  `UID` INT NOT NULL,
  `WID` INT NOT NULL,
  PRIMARY KEY (`CID`),
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


-- -----------------------------------------------------
-- Table `petmeeting`.`Entrust_Application`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `petmeeting`.`Entrust_Application` ;

CREATE TABLE IF NOT EXISTS `petmeeting`.`Entrust_Application` (
  `EID` INT NOT NULL AUTO_INCREMENT,
  `Text` TEXT NOT NULL,
  `Start_Date` DATE NOT NULL,
  `End_Date` DATE NOT NULL,
  `Preypayment` TINYINT NOT NULL,
  `Toypayment` TINYINT NOT NULL,
  `Created_Date` DATETIME NOT NULL,
  `CityID` INT NOT NULL,
  `UID` INT NOT NULL,
  PRIMARY KEY (`EID`),
  INDEX `CityID_idx` (`CityID` ASC) VISIBLE,
  INDEX `UID_idx` (`UID` ASC) VISIBLE,
  CONSTRAINT `EN_CityID_key`
    FOREIGN KEY (`CityID`)
    REFERENCES `petmeeting`.`City` (`CityID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `EN_UID_key`
    FOREIGN KEY (`UID`)
    REFERENCES `petmeeting`.`User` (`UID`)
    ON DELETE CASCADE
    ON UPDATE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `petmeeting`.`Housing`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `petmeeting`.`Housing` ;

CREATE TABLE IF NOT EXISTS `petmeeting`.`Housing` (
  `HousingID` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`HousingID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `petmeeting`.`Housings`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `petmeeting`.`Housings` ;

CREATE TABLE IF NOT EXISTS `petmeeting`.`Housings` (
  `EID` INT NOT NULL,
  `HousingID` INT NOT NULL,
  PRIMARY KEY (`EID`, `HousingID`),
  INDEX `HousingID_idx` (`HousingID` ASC) INVISIBLE,
  CONSTRAINT `HO_EID_key`
    FOREIGN KEY (`EID`)
    REFERENCES `petmeeting`.`Entrust_Application` (`EID`)
    ON DELETE CASCADE,
  CONSTRAINT `HO_HousingID_key`
    FOREIGN KEY (`HousingID`)
    REFERENCES `petmeeting`.`Housing` (`HousingID`))
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
COLLATE = utf8mb4_0900_ai_ci
COMMENT = 'í’ˆì¢…';


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


-- -----------------------------------------------------
-- Table `petmeeting`.`Raise_Application`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `petmeeting`.`Raise_Application` ;

CREATE TABLE IF NOT EXISTS `petmeeting`.`Raise_Application` (
  `RID` INT NOT NULL AUTO_INCREMENT,
  `Motivation` TEXT NOT NULL,
  `Text` TEXT NOT NULL,
  `HousingID` INT NOT NULL,
  `EID` INT NOT NULL,
  `UID` INT NOT NULL,
  PRIMARY KEY (`RID`),
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
-- Table `petmeeting`.`Showoff`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `petmeeting`.`Showoff` ;

CREATE TABLE IF NOT EXISTS `petmeeting`.`Showoff` (
  `SID` INT NOT NULL AUTO_INCREMENT,
  `ImgID` INT NOT NULL,
  `Text` TEXT NOT NULL,
  `Date` DATETIME NOT NULL,
  `UID` INT NOT NULL,
  PRIMARY KEY (`SID`),
  INDEX `UID_idx` (`UID` ASC) VISIBLE,
  INDEX `SH_ImgID_key_idx` (`ImgID` ASC) VISIBLE,
  CONSTRAINT `SH_UID_key`
    FOREIGN KEY (`UID`)
    REFERENCES `petmeeting`.`User` (`UID`),
  CONSTRAINT `SH_ImgID_key`
    FOREIGN KEY (`ImgID`)
    REFERENCES `petmeeting`.`Image` (`ImgID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `petmeeting`.`Vote`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `petmeeting`.`Vote` ;

CREATE TABLE IF NOT EXISTS `petmeeting`.`Vote` (
  `UID` INT NOT NULL,
  `SID` INT NOT NULL,
  PRIMARY KEY (`UID`, `SID`),
  INDEX `SID_idx` (`SID` ASC) VISIBLE,
  CONSTRAINT `VO_SID_key`
    FOREIGN KEY (`SID`)
    REFERENCES `petmeeting`.`Showoff` (`SID`)
    ON DELETE CASCADE,
  CONSTRAINT `VO_UID_key`
    FOREIGN KEY (`UID`)
    REFERENCES `petmeeting`.`User` (`UID`)
    ON DELETE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

USE `petmeeting` ;

-- -----------------------------------------------------
-- Placeholder table for view `petmeeting`.`PetView`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `petmeeting`.`PetView` (`PID` INT, `Name` INT, `Year` INT, `Gender` INT, `GradeRatio` INT, `Description` INT, `EID` INT, `UID` INT, `Username` INT, `Species` INT, `Breed` INT, `Filename` INT);

-- -----------------------------------------------------
-- View `petmeeting`.`PetView`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `petmeeting`.`PetView`;
DROP VIEW IF EXISTS `petmeeting`.`PetView` ;
USE `petmeeting`;
CREATE OR REPLACE VIEW petmeeting.PetView AS
SELECT p.PID, p.Name, p.Year, g.Name AS Gender, p.GradeRatio, p.Description,
		p.EID, p.UID, u.Username, sb.Species, sb.Breed, i.Filename
FROM petmeeting.Pet AS p
JOIN petmeeting.Image AS i
JOIN petmeeting.Gender AS g
JOIN petmeeting.User AS u
JOIN (SELECT b.BreedID, s.Name AS Species, b.Name AS Breed FROM petmeeting.Breed AS b
		JOIN petmeeting.Species AS s ON b.SpeciesID = s.SpeciesID) AS sb
WHERE p.ImgID = i.ImgID AND p.GenderID = g.GenderID
		AND p.UID = u.UID AND p.BreedID = sb.BreedID;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `petmeeting`.`Image`
-- -----------------------------------------------------
START TRANSACTION;
USE `petmeeting`;
INSERT INTO `petmeeting`.`Image` (`ImgID`, `Filename`, `MimeType`, `OriginalName`, `Size`) VALUES (1, 'd1fc1eb1ffc5f81979854e1de6895da3', 'image/jpeg', 'sample.jpg', 113177);
INSERT INTO `petmeeting`.`Image` (`ImgID`, `Filename`, `MimeType`, `OriginalName`, `Size`) VALUES (2, 'fcf27442a9564a0b051aaad5904b8bd3', 'image/jpeg', 'go.jpg', 115838);
INSERT INTO `petmeeting`.`Image` (`ImgID`, `Filename`, `MimeType`, `OriginalName`, `Size`) VALUES (3, '3ed970196ccf11ded2de2c760f34cbe4', 'image/jpeg', 'hangang.jpg', 4274129);
INSERT INTO `petmeeting`.`Image` (`ImgID`, `Filename`, `MimeType`, `OriginalName`, `Size`) VALUES (4, '03e16c347a8803f0ec39b0265778f90f', 'image/jpeg', 'guitar.jpg', 166777);

COMMIT;


-- -----------------------------------------------------
-- Data for table `petmeeting`.`User`
-- -----------------------------------------------------
START TRANSACTION;
USE `petmeeting`;
INSERT INTO `petmeeting`.`User` (`UID`, `Username`, `Password`, `ImgID`, `Email`, `Phone`) VALUES (1, 'Son', 'Sung', 1, 'sonjeff@naver.com', '010-4095-7558');
INSERT INTO `petmeeting`.`User` (`UID`, `Username`, `Password`, `ImgID`, `Email`, `Phone`) VALUES (2, 'a', 'b', 2, 'what@gmail.com', '010-9248-8162');
INSERT INTO `petmeeting`.`User` (`UID`, `Username`, `Password`, `ImgID`, `Email`, `Phone`) VALUES (3, 'KKK', 'BLM', 3, 'kkk@blm.xyz', '054-895-7512');

COMMIT;


-- -----------------------------------------------------
-- Data for table `petmeeting`.`Worry`
-- -----------------------------------------------------
START TRANSACTION;
USE `petmeeting`;
INSERT INTO `petmeeting`.`Worry` (`WID`, `Title`, `Text`, `Date`, `UID`) VALUES (1, 'Something wrong', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electr', '2020-10-03-12-19-00', 1);
INSERT INTO `petmeeting`.`Worry` (`WID`, `Title`, `Text`, `Date`, `UID`) VALUES (2, 'Yes, I did it', 'Sunghun is great guy I ever seen before', '2020-10-03-11-19-00', 1);
INSERT INTO `petmeeting`.`Worry` (`WID`, `Title`, `Text`, `Date`, `UID`) VALUES (3, 'And Then There Were None', 'Ten little Soldier Boys went out to dine;', '2020-09-03-19-19-35', 2);
INSERT INTO `petmeeting`.`Worry` (`WID`, `Title`, `Text`, `Date`, `UID`) VALUES (4, 'To be or not to be', 'To be, or not to be, that is the question:', '2020-08-09-08-09-52', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `petmeeting`.`BookMarkTo`
-- -----------------------------------------------------
START TRANSACTION;
USE `petmeeting`;
INSERT INTO `petmeeting`.`BookMarkTo` (`WID`, `UID`) VALUES (1, 1);
INSERT INTO `petmeeting`.`BookMarkTo` (`WID`, `UID`) VALUES (3, 2);
INSERT INTO `petmeeting`.`BookMarkTo` (`WID`, `UID`) VALUES (1, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `petmeeting`.`City`
-- -----------------------------------------------------
START TRANSACTION;
USE `petmeeting`;
INSERT INTO `petmeeting`.`City` (`CityID`, `Name`) VALUES (1, 'Seoul');
INSERT INTO `petmeeting`.`City` (`CityID`, `Name`) VALUES (2, 'Pohang');

COMMIT;


-- -----------------------------------------------------
-- Data for table `petmeeting`.`Comment`
-- -----------------------------------------------------
START TRANSACTION;
USE `petmeeting`;
INSERT INTO `petmeeting`.`Comment` (`CID`, `Text`, `Date`, `CID_ReplyTo`, `UID`, `WID`) VALUES (5, 'love me through it all', '2020-10-06-02-05-16', null, 1, 1);
INSERT INTO `petmeeting`.`Comment` (`CID`, `Text`, `Date`, `CID_ReplyTo`, `UID`, `WID`) VALUES (2, 'Love is shared by each other', '2020-10-06-12-05-16', null, 1, 1);
INSERT INTO `petmeeting`.`Comment` (`CID`, `Text`, `Date`, `CID_ReplyTo`, `UID`, `WID`) VALUES (3, 'When I\'m still in love with you?', '2020-09-23-02-05-16', null, 2, 1);
INSERT INTO `petmeeting`.`Comment` (`CID`, `Text`, `Date`, `CID_ReplyTo`, `UID`, `WID`) VALUES (4, 'Take my hand and walk this journey with me.', '2020-10-23-22-05-16', 2, 2, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `petmeeting`.`Housing`
-- -----------------------------------------------------
START TRANSACTION;
USE `petmeeting`;
INSERT INTO `petmeeting`.`Housing` (`HousingID`, `Name`) VALUES (1, 'Apartment');
INSERT INTO `petmeeting`.`Housing` (`HousingID`, `Name`) VALUES (2, 'Villa');
INSERT INTO `petmeeting`.`Housing` (`HousingID`, `Name`) VALUES (3, 'Normal House');

COMMIT;


-- -----------------------------------------------------
-- Data for table `petmeeting`.`Species`
-- -----------------------------------------------------
START TRANSACTION;
USE `petmeeting`;
INSERT INTO `petmeeting`.`Species` (`SpeciesID`, `Name`) VALUES (1, 'Cat');
INSERT INTO `petmeeting`.`Species` (`SpeciesID`, `Name`) VALUES (2, 'Dog');
INSERT INTO `petmeeting`.`Species` (`SpeciesID`, `Name`) VALUES (3, 'Spider');

COMMIT;


-- -----------------------------------------------------
-- Data for table `petmeeting`.`Breed`
-- -----------------------------------------------------
START TRANSACTION;
USE `petmeeting`;
INSERT INTO `petmeeting`.`Breed` (`BreedID`, `SpeciesID`, `Name`) VALUES (1, 1, 'Singapura');
INSERT INTO `petmeeting`.`Breed` (`BreedID`, `SpeciesID`, `Name`) VALUES (2, 1, 'Abyssinian');
INSERT INTO `petmeeting`.`Breed` (`BreedID`, `SpeciesID`, `Name`) VALUES (3, 1, 'Norwegian Forest');
INSERT INTO `petmeeting`.`Breed` (`BreedID`, `SpeciesID`, `Name`) VALUES (4, 1, 'Devon Rex');

COMMIT;


-- -----------------------------------------------------
-- Data for table `petmeeting`.`Gender`
-- -----------------------------------------------------
START TRANSACTION;
USE `petmeeting`;
INSERT INTO `petmeeting`.`Gender` (`GenderID`, `name`) VALUES (1, 'Male');
INSERT INTO `petmeeting`.`Gender` (`GenderID`, `name`) VALUES (2, 'Female');
INSERT INTO `petmeeting`.`Gender` (`GenderID`, `name`) VALUES (3, 'None');

COMMIT;


-- -----------------------------------------------------
-- Data for table `petmeeting`.`Pet`
-- -----------------------------------------------------
START TRANSACTION;
USE `petmeeting`;
INSERT INTO `petmeeting`.`Pet` (`PID`, `Name`, `Year`, `GenderID`, `GradeRatio`, `Description`, `ImgID`, `EID`, `UID`, `BreedID`) VALUES (1, 'Rosemary', 8, 1, 1.5, '', 1, NULL, 1, 1);
INSERT INTO `petmeeting`.`Pet` (`PID`, `Name`, `Year`, `GenderID`, `GradeRatio`, `Description`, `ImgID`, `EID`, `UID`, `BreedID`) VALUES (2, 'Dandelion', 5, 2, 5.2, '', 2, NULL, 1, 2);
INSERT INTO `petmeeting`.`Pet` (`PID`, `Name`, `Year`, `GenderID`, `GradeRatio`, `Description`, `ImgID`, `EID`, `UID`, `BreedID`) VALUES (3, 'Lily', 2, 2, 5.3, '', 3, NULL, 2, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `petmeeting`.`Showoff`
-- -----------------------------------------------------
START TRANSACTION;
USE `petmeeting`;
INSERT INTO `petmeeting`.`Showoff` (`SID`, `ImgID`, `Text`, `Date`, `UID`) VALUES (1, 1, 'asy to use, stylish placeholders', '2020-10-03-01-03-12', 1);
INSERT INTO `petmeeting`.`Showoff` (`SID`, `ImgID`, `Text`, `Date`, `UID`) VALUES (2, 2, 'I want a hero: an uncommon want,', '2020-10-03-02-06-25', 1);
INSERT INTO `petmeeting`.`Showoff` (`SID`, `ImgID`, `Text`, `Date`, `UID`) VALUES (3, 3, 'Childe Harold was he hight:â€”but whence his name', '2020-10-02-23-21-02', 2);
INSERT INTO `petmeeting`.`Showoff` (`SID`, `ImgID`, `Text`, `Date`, `UID`) VALUES (4, 4, 'When we two parted In silence and tears,', '2020-09-01-02-06-02', 3);
INSERT INTO `petmeeting`.`Showoff` (`SID`, `ImgID`, `Text`, `Date`, `UID`) VALUES (5, 4, 'She walks in beauty, like the night Of cloudless climes and starry skies;', '2020-09-01-03-06-09', 1);
INSERT INTO `petmeeting`.`Showoff` (`SID`, `ImgID`, `Text`, `Date`, `UID`) VALUES (6, 2, 'So, weâ€™ll go no more a roving So late into the night,', '2020-08-26-12-25-21', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `petmeeting`.`Vote`
-- -----------------------------------------------------
START TRANSACTION;
USE `petmeeting`;
INSERT INTO `petmeeting`.`Vote` (`UID`, `SID`) VALUES (1, 1);
INSERT INTO `petmeeting`.`Vote` (`UID`, `SID`) VALUES (1, 2);
INSERT INTO `petmeeting`.`Vote` (`UID`, `SID`) VALUES (1, 6);
INSERT INTO `petmeeting`.`Vote` (`UID`, `SID`) VALUES (2, 1);
INSERT INTO `petmeeting`.`Vote` (`UID`, `SID`) VALUES (2, 2);
INSERT INTO `petmeeting`.`Vote` (`UID`, `SID`) VALUES (2, 3);
INSERT INTO `petmeeting`.`Vote` (`UID`, `SID`) VALUES (2, 4);
INSERT INTO `petmeeting`.`Vote` (`UID`, `SID`) VALUES (3, 3);
INSERT INTO `petmeeting`.`Vote` (`UID`, `SID`) VALUES (3, 2);
INSERT INTO `petmeeting`.`Vote` (`UID`, `SID`) VALUES (3, 6);

COMMIT;
