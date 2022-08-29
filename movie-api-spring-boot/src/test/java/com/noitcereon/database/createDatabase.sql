-- Note: This script is updated by manually copying the latest database export from Adminer (localhost:8080)
-- And replacing the script below.
SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

SET NAMES utf8mb4;

DROP TABLE IF EXISTS `Actor`;
CREATE TABLE `Actor` (
                         `id` bigint NOT NULL AUTO_INCREMENT,
                         `firstName` varchar(255) NOT NULL,
                         `lastName` varchar(255) NOT NULL,
                         `birthYear` smallint NOT NULL,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `Movie`;
CREATE TABLE `Movie` (
                         `id` bigint NOT NULL AUTO_INCREMENT,
                         `title` varchar(255) NOT NULL,
                         `releaseYear` smallint NOT NULL,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `MovieActor`;
CREATE TABLE `MovieActor` (
                              `id` bigint NOT NULL AUTO_INCREMENT,
                              `fkActorId` bigint NOT NULL,
                              `fkMovieId` bigint NOT NULL,
                              PRIMARY KEY (`id`),
                              KEY `fkMovieId` (`fkMovieId`),
                              KEY `fkActorId` (`fkActorId`),
                              CONSTRAINT `MovieActor_ibfk_1` FOREIGN KEY (`fkMovieId`) REFERENCES `Movie` (`id`),
                              CONSTRAINT `MovieActor_ibfk_2` FOREIGN KEY (`fkActorId`) REFERENCES `Actor` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;