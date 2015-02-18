-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               5.6.23-log - MySQL Community Server (GPL)
-- ОС Сервера:                   Win64
-- HeidiSQL Версия:              9.1.0.4867
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Дамп структуры базы данных delta_stubs
CREATE DATABASE IF NOT EXISTS `delta_stubs` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `delta_stubs`;


-- Дамп структуры для таблица delta_stubs.tran_data
CREATE TABLE IF NOT EXISTS `tran_data` (
  `tran_id` int(9) NOT NULL,
  `key` varchar(100) NOT NULL,
  `value` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы delta_stubs.tran_data: ~18 rows (приблизительно)
/*!40000 ALTER TABLE `tran_data` DISABLE KEYS */;
INSERT INTO `tran_data` (`tran_id`, `key`, `value`) VALUES
	(1, 'Name', 'REPL_LOAD'),
	(2, 'Name', 'SAFE_OPERATIONS'),
	(3, 'Name', 'SAFE_TOTALS'),
	(4, 'Name', 'REPL_UNLOAD'),
	(5, 'Name', 'SAFE_STATE'),
	(6, 'DispensedAmount', '100'),
	(7, 'AcceptedAmount', '100'),
	(7, 'DispensedAmount', '0'),
	(8, 'DispensedAmount1', '10000000'),
	(8, 'AcceptedAmount1', '10000000'),
	(8, 'DispensedCurrency1', 'RUB'),
	(8, 'AcceptedCurrency1', 'RUB'),
	(8, 'DispensedAmount2', '10000000'),
	(8, 'AcceptedAmount2', '10000000'),
	(8, 'DispensedCurrency2', 'RUB'),
	(8, 'AcceptedCurrency2', 'RUB'),
	(10, 'Name', 'SAFE_STATE'),
	(11, 'Name', 'SAFE_STATE');
/*!40000 ALTER TABLE `tran_data` ENABLE KEYS */;


-- Дамп структуры для таблица delta_stubs.tran_type
CREATE TABLE IF NOT EXISTS `tran_type` (
  `tran_id` int(9) NOT NULL,
  `type` int(1) NOT NULL,
  PRIMARY KEY (`tran_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы delta_stubs.tran_type: ~11 rows (приблизительно)
/*!40000 ALTER TABLE `tran_type` DISABLE KEYS */;
INSERT INTO `tran_type` (`tran_id`, `type`) VALUES
	(1, 2),
	(2, 2),
	(3, 2),
	(4, 2),
	(5, 2),
	(6, 3),
	(7, 4),
	(8, 5),
	(9, 1),
	(10, 2),
	(11, 2);
/*!40000 ALTER TABLE `tran_type` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
