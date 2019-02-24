-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: presenze
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `presenza`
--

DROP TABLE IF EXISTS `presenza`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `presenza` (
  `idgiorno` int(10) NOT NULL AUTO_INCREMENT,
  `iduser` int(10) unsigned NOT NULL,
  `giorno` date DEFAULT NULL,
  `oraentrata` varchar(5) DEFAULT NULL,
  `orauscita` varchar(5) DEFAULT NULL,
  `pausapranzo` int(10) DEFAULT NULL,
  `orepermesso` int(10) DEFAULT NULL,
  `permessomaternita` int(10) DEFAULT NULL,
  `permessomalattiafiglio` int(10) DEFAULT NULL,
  `congedoparentale` int(10) DEFAULT NULL,
  `malattia` varchar(1) DEFAULT NULL,
  `ferie` varchar(1) DEFAULT NULL,
  `verified` tinyint(3) unsigned DEFAULT '0',
  `utenteope` varchar(16) NOT NULL,
  `dataope` date NOT NULL,
  PRIMARY KEY (`idgiorno`),
  KEY `IDX_PRESENZA_GIORNO` (`giorno`),
  KEY `IDX_PRESENZA_USER` (`iduser`),
  CONSTRAINT `presenza_users` FOREIGN KEY (`iduser`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `presenza`
--

LOCK TABLES `presenza` WRITE;
/*!40000 ALTER TABLE `presenza` DISABLE KEYS */;
INSERT INTO `presenza` VALUES (1,101,'2019-02-09','08:00','18:00',120,0,0,0,0,'N','N',0,'admin','2019-02-23'),(2,101,'2019-02-12','08:00','17:00',60,0,0,0,0,'N','N',0,'admin','2019-02-13'),(3,101,'2019-02-11','00:00','00:00',0,0,0,0,0,'N','S',0,'admin','2019-02-13'),(4,101,'2019-01-22','08:00','17:00',60,0,0,0,0,'N','N',0,'admin','2019-02-23'),(5,101,'2019-02-20','09:00','18:00',60,0,0,0,0,'N','N',0,'admin','2019-02-23'),(6,101,'2019-02-19','00:00','00:00',0,0,0,0,0,'N','S',0,'admin','2019-02-23'),(7,101,'2019-02-16','09:00','18:00',60,0,0,0,0,'N','N',0,'admin','2019-02-23');
/*!40000 ALTER TABLE `presenza` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-02-24 12:13:10
