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

-- User 테이블의 username을 unique로 변경
alter table user
modify column Username varchar(50) unique;

alter table user
modify column Email varchar(50) unique;

alter table user
modify column Phone varchar(45) unique;

commit;

START TRANSACTION;
USE `petmeeting`;
INSERT INTO `petmeeting`.`User` (`Username`, `Password`, `ImgID`, `Email`, `Phone`) VALUES ('Shin', '0325', 1, 'stamsdm@naver.com', '010-2039-5246');

COMMIT;