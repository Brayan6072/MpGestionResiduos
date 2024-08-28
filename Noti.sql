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


-- Volcando estructura de base de datos para notificaciones
CREATE DATABASE IF NOT EXISTS `notificaciones` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `notificaciones`;

-- Volcando estructura para tabla notificaciones.reportes
CREATE TABLE IF NOT EXISTS `reportes` (
  `fecha` date DEFAULT NULL,
  `hora` time(6) DEFAULT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `clasificacion` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `estatus` varchar(255) DEFAULT NULL,
  `etiquetau` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla notificaciones.reportes: ~12 rows (aproximadamente)
INSERT INTO `reportes` (`fecha`, `hora`, `id`, `clasificacion`, `estado`, `estatus`, `etiquetau`) VALUES
	('2024-06-10', '18:46:42.140000', 1, 'Papel', 'Danado', 'Verde', 'Bote D'),
	('2024-06-10', '18:46:50.684000', 2, 'Dificil Reciclaje', 'Danado', 'Verde', 'Bote K'),
	('2024-06-10', '18:46:56.780000', 3, 'Papel', 'Basura Mezclada', 'Verde', 'Bote C'),
	(NULL, NULL, 4, NULL, NULL, 'Verde', NULL),
	('2024-06-13', '19:32:38.034000', 5, 'Papel', 'Danado', 'Verde', 'Bote C'),
	('2024-06-13', '19:32:44.980000', 6, 'Papel', 'Basura Mezclada', 'Verde', 'Bote G'),
	('2024-06-13', '19:32:50.547000', 7, 'Plasticos', 'Basura Mezclada', 'Verde', 'Bote J'),
	('2024-06-14', '13:22:18.329000', 8, 'Papel', 'Lleno', 'Verde', 'Bote C'),
	('2024-06-14', '13:22:24.518000', 9, 'Papel', 'Danado', 'Verde', 'Bote G'),
	('2024-06-14', '14:12:24.757000', 10, 'Papel', 'Danado', 'Verde', 'Bote C'),
	('2024-06-14', '14:12:30.885000', 11, 'Papel', 'Basura Mezclada', 'Verde', 'Bote G'),
	('2024-06-14', '14:19:10.720000', 12, 'Dificil Reciclaje', 'Danado', 'Verde', 'Bote J'),
	('2024-06-14', '14:19:17.854000', 13, 'Papel', 'Danado', 'Verde', 'Bote R'),
	('2024-07-18', '13:34:26.195000', 14, 'Organicos', 'Danado', 'Verde', 'Bote C'),
	('2024-07-27', '16:35:32.479000', 15, 'Papel', 'Lleno', 'Rojo', 'Bote I');

-- Volcando estructura para tabla notificaciones.usuarios
CREATE TABLE IF NOT EXISTS `usuarios` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(75) DEFAULT NULL,
  `Email` varchar(160) DEFAULT NULL,
  `Telefono` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `Password` varchar(160) DEFAULT NULL,
  `TpUser` varchar(80) DEFAULT NULL,
  `Estado` varchar(50) DEFAULT 'Activo',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla notificaciones.usuarios: ~3 rows (aproximadamente)
INSERT INTO `usuarios` (`Id`, `Nombre`, `Email`, `Telefono`, `Password`, `TpUser`, `Estado`) VALUES
	(1, 'Brayan Delgado Diaz', 'brayan.delgado6072@alumnos.udg.mx', '12345659789', '$2a$10$hpGFOCzG3hr97xBBlntBTeS5D1aCEaqIQ.BXL5IgP5O253lH9EZ2q', 'encargado', 'Activo'),
	(2, 'Brayan', 'ben10delgado@gmail.com', '3424242', '$2a$10$MMC7ssl0UTkBoA.kC/CcFuv047wi48uYr0/dHFjscoG4ZCzGHNg86', 'encargado', 'Activo');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
