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
-- Table structure for table `periodolavorativo`
--

DROP TABLE IF EXISTS `periodolavorativo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `periodolavorativo` (
  `idperiodo` int(10) unsigned NOT NULL,
  `idpersona` int(10) unsigned NOT NULL,
  `idtipoqualifica` int(11) NOT NULL,
  `datainizio` date NOT NULL,
  `datafine` date DEFAULT NULL,
  `utenteope` varchar(16) DEFAULT NULL,
  `dataope` date DEFAULT NULL,
  PRIMARY KEY (`idperiodo`),
  KEY `FK_TIPO_QUALIFICA_idx` (`idtipoqualifica`),
  KEY `fk_persona_periodolavorativo_idx` (`idpersona`),
  CONSTRAINT `FK_TIPO_QUALIFICA` FOREIGN KEY (`idtipoqualifica`) REFERENCES `tipologicaqualifica` (`idtipoqualifica`),
  CONSTRAINT `fk_persona_periodolavorativo` FOREIGN KEY (`idpersona`) REFERENCES `persona` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `periodolavorativo`
--

LOCK TABLES `periodolavorativo` WRITE;
/*!40000 ALTER TABLE `periodolavorativo` DISABLE KEYS */;
/*!40000 ALTER TABLE `periodolavorativo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-02-24 12:13:11
