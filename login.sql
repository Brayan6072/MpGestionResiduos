-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         8.3.0 - MySQL Community Server - GPL
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para securitydb
CREATE DATABASE IF NOT EXISTS `securitydb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `securitydb`;

-- Volcando estructura para tabla securitydb.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `lastname` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  `role` enum('ADMIN','USER') DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKsb8bbouer5wak8vyiiy4pf2bx` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla securitydb.user: ~6 rows (aproximadamente)
INSERT INTO `user` (`id`, `lastname`, `name`, `password`, `phone`, `username`, `role`) VALUES
	(7, 'Delgado Diaz', 'Marcela', '$2a$10$TlNHXVO65aX7JmxEPYaszOuEg7jdqraIc4WS3kkGZhrCunc7q3mda', '3337906715', 'brayan.delgado6072@alumnos.udg.mx', 'USER'),
	(8, 'Delgado Diaz', 'Brayan', '$2a$10$B7vL7VQQAvz0o2ofDlhXUugbk4SwOZfS7ITscopEEG.GuqWIKsHqy', '33 1959 9137', 'ben10delgado@gmail.com', 'USER'),
	(10, 'Delgado Diaz', 'Plan', '$2a$10$I9GrMoSPduETaq07XSUO9Oy4jzNTHjOyTi0To.HVikZtP22rnoEGG', '3337906715', 'brayandelgadodiaz03@gmail.com', 'USER'),
	(12, 'Delgado Diaz', 'Plan', '$2a$10$y9o5nl7xNSb5SvehaUNxj.uTwOOUSQgLFx7hZKuMounvIkGlnOb5a', '3337906715', 'brayandelgadodiaz032@gmail.com', 'USER'),
	(13, 'Delgado Diaz', 'Brayan', '$2a$10$HRXTCnZMOT5SgMHLL2AwMeNpMAqyQVa6bCWWhNe5Zy2B9nJNOyt76', '3337906715', 'brayandelgado6072dsd@alumnos.udg.mx', 'USER'),
	(17, 'Delgado Diaz', 'Marcela', '$2a$10$Dqyd076F5jREqBoKYZR9ZeYpF7AvPg8dJ2Pyp/Tw82H1AS71QDyFa', '3337906715', 'eldfgfgfelaaksdfd51@gmail.com', 'USER'),
	(18, 'asd', 'Brayan', '$2a$10$8g2das60OuwPe5RsTC07XeNHerEV.hE4EeI6/.H6V4yOKY8rMRK6W', '331959 9137', '3333eldelaaksdfd51@gmail.com', 'USER'),
	(19, 'asd', 'Brayanssss', '$2a$10$jsvGZHAyLzoQTAQuUtD/a.o8PJgFGiOcedGKGC8ptDzvrL6BMbgx2', '3337044054', 'eldssssdssselaaksdfd51@gmail.com', 'USER');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
