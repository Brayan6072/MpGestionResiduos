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


-- Volcando estructura de base de datos para login
CREATE DATABASE IF NOT EXISTS `login` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `login`;

-- Volcando estructura para tabla login.rol
CREATE TABLE IF NOT EXISTS `rol` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla login.rol: ~0 rows (aproximadamente)

-- Volcando estructura para tabla login.usuarios
CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKkfsp0s1tflm1cwlj8idhqsad0` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla login.usuarios: ~0 rows (aproximadamente)

-- Volcando estructura para tabla login.usuarios_roles
CREATE TABLE IF NOT EXISTS `usuarios_roles` (
  `usuario_id` bigint NOT NULL,
  `rol_id` bigint NOT NULL,
  KEY `FK6yxg1lhuv5nievqea7rvn6afm` (`rol_id`),
  KEY `FKqcxu02bqipxpr7cjyj9dmhwec` (`usuario_id`),
  CONSTRAINT `FK6yxg1lhuv5nievqea7rvn6afm` FOREIGN KEY (`rol_id`) REFERENCES `rol` (`id`),
  CONSTRAINT `FKqcxu02bqipxpr7cjyj9dmhwec` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla login.usuarios_roles: ~0 rows (aproximadamente)


-- Volcando estructura de base de datos para monitoreo
CREATE DATABASE IF NOT EXISTS `monitoreo` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `monitoreo`;

-- Volcando estructura para tabla monitoreo.choferes
CREATE TABLE IF NOT EXISTS `choferes` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(160) DEFAULT NULL,
  `Apellidos` varchar(160) DEFAULT NULL,
  `Direccion` varchar(255) DEFAULT NULL,
  `Nacimiento` varchar(50) DEFAULT NULL,
  `IdUser` int DEFAULT NULL,
  `Estado` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `IdUser` (`IdUser`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla monitoreo.choferes: ~4 rows (aproximadamente)
INSERT INTO `choferes` (`Id`, `Nombre`, `Apellidos`, `Direccion`, `Nacimiento`, `IdUser`, `Estado`) VALUES
	(2, 'Brayan ', 'Delgado', 'fgdg', '10-15-2003', 1, 'Activo'),
	(3, 'ANGEL JAVIER ADAIR', 'BALAN VILLARRUEL', '1123 CASTILLO DE AMPUDIA', '10-10-2003', 1, 'Activo'),
	(4, 'Frank', 'Silva', 'El Salto', '10-15-2003', 3, 'Activo'),
	(5, 'ANGEL JAVIER ADAIR', 'BALAN VILLARRUEL', '1123 CASTILLO DE AMPUDIA', '20-08-2003', 6, 'Activo');

-- Volcando estructura para tabla monitoreo.estudiantes
CREATE TABLE IF NOT EXISTS `estudiantes` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(255) NOT NULL,
  `Apellidos` varchar(255) NOT NULL,
  `Direccion` varchar(255) NOT NULL,
  `Nacimiento` varchar(150) DEFAULT NULL,
  `IdUser` int NOT NULL,
  `Estado` varchar(50) DEFAULT 'Activo',
  PRIMARY KEY (`Id`),
  KEY `IdUser` (`IdUser`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla monitoreo.estudiantes: ~7 rows (aproximadamente)
INSERT INTO `estudiantes` (`Id`, `Nombre`, `Apellidos`, `Direccion`, `Nacimiento`, `IdUser`, `Estado`) VALUES
	(1, 'Brayab', 'erque', 'sdf', 'sdfs', 2, 'Activo'),
	(2, 'Brayan32', 'Delgado', 'El Salto, calle1', '30-11-2003', 2, 'Activo'),
	(3, 'BALAN', 'VILLARRUEL', '1123 CASTILLO DE AMPUDIA', 'sdfs', 2, 'Activo'),
	(4, 'Jorge', 'Alvares', 'El Salto, calle1', '10-10-2001', 2, 'Activo'),
	(5, 'Brayab', 'erque', 'Calle1', '08-11-2003', 2, 'Activo'),
	(7, 'Brayan', 'Delgado', 'El Salto', '10-15-2003', 3, 'Activo'),
	(8, 'ANGEL JAVIER ADAIR', 'BALAN VILLARRUEL', '1123 CASTILLO DE AMPUDIA', '15-12-2003', 1, 'Activo');

-- Volcando estructura para tabla monitoreo.horarios
CREATE TABLE IF NOT EXISTS `horarios` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Fecha` varchar(50) NOT NULL DEFAULT '',
  `Hora_de_salida` varchar(50) NOT NULL DEFAULT '',
  `Hora_de_llegada` varchar(50) NOT NULL DEFAULT '',
  `IdChofer` int NOT NULL,
  `Estado` varchar(50) DEFAULT 'Activo',
  PRIMARY KEY (`Id`),
  KEY `IdChofer` (`IdChofer`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla monitoreo.horarios: ~6 rows (aproximadamente)
INSERT INTO `horarios` (`Id`, `Fecha`, `Hora_de_salida`, `Hora_de_llegada`, `IdChofer`, `Estado`) VALUES
	(1, '2023-05-10', '21:00', '21:34', 5, 'Activo'),
	(2, '2023-05-10', '21:10', '21:34', 5, 'Activo'),
	(3, '2023-05-10', '21:34', '21:34', 5, 'Activo'),
	(4, 'Activo', '19:46', '19:46', 1, NULL),
	(5, '2023-05-17', '20:53', '20:53', 5, 'Activo'),
	(6, '2023-05-24', '21:40', '21:40', 1, 'Activo');

-- Volcando estructura para tabla monitoreo.usuarios
CREATE TABLE IF NOT EXISTS `usuarios` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(75) DEFAULT NULL,
  `Email` varchar(160) DEFAULT NULL,
  `Password` varchar(160) DEFAULT NULL,
  `TpUser` varchar(80) DEFAULT NULL,
  `Estado` varchar(50) DEFAULT 'Activo',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla monitoreo.usuarios: ~0 rows (aproximadamente)
INSERT INTO `usuarios` (`Id`, `Nombre`, `Email`, `Password`, `TpUser`, `Estado`) VALUES
	(1, 'Brayan', 'aa@dd', '123', 'Admin', 'Activo');


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
  `estatus` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT 'Rojo',
  `etiquetau` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla notificaciones.reportes: ~28 rows (aproximadamente)
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
	('2024-07-27', '16:35:32.479000', 15, 'Papel', 'Lleno', 'Verde', 'Bote I'),
	('2024-09-10', '22:40:44.592000', 16, 'Plasticos', 'Danado', 'Verde', 'Bote D'),
	('2024-09-10', '22:43:09.674000', 17, 'Vidrio', 'Basura Mezclada', 'Verde', 'Bote F'),
	('2024-09-14', '20:45:44.940000', 18, 'Papel', 'Lleno', 'Verde', 'Bote D'),
	('2024-09-14', '20:45:57.678000', 19, 'Papel', 'Lleno', 'Verde', 'Bote D'),
	('2024-09-14', '20:46:05.956000', 20, 'Papel', 'Lleno', 'Verde', 'Bote D'),
	('2024-09-14', '21:27:58.244000', 21, 'Papel', 'Lleno', 'Verde', 'Bote D'),
	('2024-09-16', '17:43:21.611000', 22, 'Papel', 'Lleno', 'Verde', 'Bote D'),
	('2024-09-16', '17:50:57.994000', 23, 'Papel', 'Lleno', 'Verde', 'Bote G'),
	('2024-09-16', '17:53:08.241000', 24, 'Metal', 'Danado', 'Verde', 'Bote K'),
	('2024-09-16', '17:57:03.819000', 25, 'Metal', 'Danado', 'Verde', 'Bote K'),
	('2024-09-16', '17:58:46.295000', 26, 'Plasticos', 'Basura Mezclada', 'Rojo', 'Bote D'),
	('2024-09-16', '18:05:43.916000', 27, 'Metal', 'Danado', 'Rojo', 'Bote K'),
	('2024-09-16', '18:06:22.944000', 28, 'Dificil Reciclaje', 'Basura Mezclada', 'Rojo', 'Bote J'),
	('2024-09-16', '18:08:47.640000', 29, 'Metal', 'Basura Mezclada', 'Rojo', 'Bote N'),
	('2024-09-16', '18:10:58.266000', 30, 'Plasticos', 'Danado', 'Verde', 'Bote U'),
	('2024-09-16', '18:34:09.841000', 31, 'Papel', 'Danado', 'Verde', 'Bote F'),
	('2024-09-16', '18:34:31.979000', 32, 'Papel', 'Basura Mezclada', 'Verde', 'Bote F'),
	('2024-09-19', '21:04:57.792000', 33, 'Metal', 'Danado', 'Rojo', 'Bote Q'),
	('2024-09-20', '14:37:17.371000', 34, 'Papel', 'Lleno', 'Rojo', 'Bote D');

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
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla securitydb.user: ~2 rows (aproximadamente)
INSERT INTO `user` (`id`, `lastname`, `name`, `password`, `phone`, `username`, `role`) VALUES
	(7, 'Delgado Diaz', 'BrayanD', '$2a$10$TlNHXVO65aX7JmxEPYaszOuEg7jdqraIc4WS3kkGZhrCunc7q3mda', '3337906715', 'brayan.delgado6072@alumnos.udg.mx', 'USER');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
