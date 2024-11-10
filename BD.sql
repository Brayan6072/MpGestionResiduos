-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         9.0.1 - MySQL Community Server - GPL
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.8.0.6908
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

-- Volcando estructura para tabla notificaciones.clasificacion
CREATE TABLE IF NOT EXISTS `clasificacion` (
  `id` int DEFAULT NULL,
  `tipo` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla notificaciones.clasificacion: ~0 rows (aproximadamente)

-- Volcando estructura para tabla notificaciones.estado
CREATE TABLE IF NOT EXISTS `estado` (
  `id` int DEFAULT NULL,
  `estado` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla notificaciones.estado: ~0 rows (aproximadamente)

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
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla notificaciones.reportes: ~38 rows (aproximadamente)
INSERT INTO `reportes` (`fecha`, `hora`, `id`, `clasificacion`, `estado`, `estatus`, `etiquetau`) VALUES
	('2024-06-10', '18:46:42.140000', 1, 'Papel', 'Danado', 'Verde', 'Contenedores D'),
	('2024-06-10', '18:46:50.684000', 2, 'Plasticos', 'Danado', 'Verde', 'Contenedores K'),
	('2024-06-10', '18:46:56.780000', 3, 'Papel', 'Basura Mezclada', 'Verde', 'Contenedores C'),
	('2024-06-13', '19:32:38.034000', 5, 'Papel', 'Danado', 'Verde', 'Contenedores C'),
	('2024-06-13', '19:32:44.980000', 6, 'Papel', 'Basura Mezclada', 'Verde', 'Contenedores G'),
	('2024-06-13', '19:32:50.547000', 7, 'Plasticos', 'Basura Mezclada', 'Verde', 'Contenedores J'),
	('2024-06-14', '13:22:18.329000', 8, 'Papel', 'Lleno', 'Verde', 'Contenedores C'),
	('2024-06-14', '13:22:24.518000', 9, 'Papel', 'Danado', 'Verde', 'Contenedores G'),
	('2024-06-14', '14:12:24.757000', 10, 'Papel', 'Danado', 'Verde', 'Contenedores C'),
	('2024-06-14', '14:12:30.885000', 11, 'Papel', 'Basura Mezclada', 'Verde', 'Contenedores G'),
	('2024-06-14', '14:19:10.720000', 12, 'Plasticos', 'Danado', 'Verde', 'Contenedores J'),
	('2024-06-14', '14:19:17.854000', 13, 'Papel', 'Danado', 'Verde', 'Contenedores R'),
	('2024-07-18', '13:34:26.195000', 14, 'Organicos', 'Danado', 'Verde', 'Contenedores C'),
	('2024-07-27', '16:35:32.479000', 15, 'Papel', 'Lleno', 'Verde', 'Contenedores I'),
	('2024-10-13', '15:21:26.808000', 16, 'Papel', 'Danado', 'Verde', 'Contenedores I'),
	('2024-10-15', '10:43:28.867000', 17, 'Metal', 'Lleno', 'Verde', 'Contenedores K'),
	('2024-10-15', '16:40:40.791000', 18, 'Papel', 'Lleno', 'Verde', 'Contenedores D'),
	('2024-10-15', '16:40:47.281000', 19, 'Vidrio', 'Danado', 'Verde', 'Contenedores L'),
	('2024-10-15', '16:40:53.168000', 20, 'Plasticos', 'Basura Mezclada', 'Rojo', 'Contenedores D'),
	('2024-10-15', '16:40:57.039000', 21, 'Metal', 'Lleno', 'Rojo', 'Contenedores K'),
	('2024-10-15', '16:41:02.570000', 22, 'Metal', NULL, 'Verde', 'Contenedores K'),
	('2024-10-15', '16:41:06.735000', 23, 'Papel', 'Danado', 'Rojo', 'Contenedores G'),
	('2024-10-15', '16:41:28.232000', 24, 'Plasticos', 'Lleno', 'Rojo', 'Contenedores Q'),
	('2024-10-15', '16:41:34.403000', 25, 'Organicos', 'Danado', 'Rojo', 'Contenedores G'),
	('2024-10-27', '19:19:42.956000', 26, 'Papel', 'Lleno', 'Verde', 'Contenedores A'),
	('2024-10-31', '20:45:53.827000', 27, 'Papel', 'Lleno', 'Verde', 'Contenedores D'),
	('2024-11-01', '20:29:01.933000', 28, 'Vidrio', 'Danado', 'Rojo', 'Contenedores D'),
	('2024-11-01', '20:29:16.878000', 29, 'Organicos', 'Basura Mezclada', 'Rojo', 'Contenedores A'),
	('2024-11-01', '20:29:25.853000', 30, 'Plasticos', 'Danado', 'Rojo', 'Contenedores G'),
	('2024-11-01', '20:29:32.741000', 31, 'Vidrio', 'Danado', 'Verde', 'Contenedores U'),
	('2024-11-02', '16:01:52.999000', 32, 'Dificil Reciclaje', 'Basura Mezclada', 'Rojo', 'Contenedores G'),
	('2024-11-02', '23:50:24.759000', 33, 'Organicos', 'Danado', 'Rojo', 'Contenedores C'),
	('2024-11-07', '13:20:29.917000', 34, 'Papel', 'Basura Mezclada', 'Rojo', 'Contenedores C'),
	('2024-11-07', '17:39:58.927000', 35, 'Metal', 'Danado', 'Rojo', 'Contenedores I'),
	('2024-11-08', '19:07:33.413000', 36, 'Dificil Reciclaje', 'Danado', 'Rojo', 'Contenedores D'),
	('2024-11-08', '21:38:23.674000', 37, 'Dificil Reciclaje', 'Basura Mezclada', 'Rojo', 'Contenedores D'),
	('2024-11-08', '21:57:41.632000', 38, 'Inorganicos', 'Danado', 'Rojo', 'Contenedores A'),
	('2024-11-08', '22:13:28.927000', 39, 'Dificil Reciclaje', 'Lleno', 'Rojo', 'Contenedores G'),
	('2024-11-09', '16:05:41.714000', 40, 'Inorganicos', 'Lleno', 'Rojo', 'Contenedores A'),
	('2024-11-09', '16:11:52.042000', 41, 'Organicos', 'Lleno', 'Rojo', 'Contenedores G'),
	('2024-11-09', '16:28:12.899000', 42, 'Plasticos', 'Danado', 'Rojo', 'Contenedores K'),
	('2024-11-09', '18:11:47.640000', 43, 'Metal', 'Lleno', 'Rojo', 'Contenedores J'),
	('2024-11-09', '18:18:27.706000', 44, 'Vidrio', 'Lleno', 'Rojo', 'Contenedores F'),
	('2024-11-09', '19:20:06.230000', 45, 'Dificil Reciclaje', 'Lleno', 'Rojo', 'Contenedores D');


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
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla securitydb.user: ~0 rows (aproximadamente)
INSERT INTO `user` (`id`, `lastname`, `name`, `password`, `phone`, `username`, `role`) VALUES
	(7, 'Delgado Diaz', 'BrayanD', '$2a$10$TlNHXVO65aX7JmxEPYaszOuEg7jdqraIc4WS3kkGZhrCunc7q3mda', '3337906715', 'brayan.delgado6072@alumnos.udg.mx', 'USER'),
	(24, 'Delgado', 'Brayan03', '$2a$10$fGQ/KJ0Er.GWqA6nbBpenuajfHCDQlN/GfZ9.53yNpTTdxPN06/CS', '54545645', 'ben10delgado@gmail.com', 'USER');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
