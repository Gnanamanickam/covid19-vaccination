-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: covid_vaccination
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `vaccination_details`
--

DROP TABLE IF EXISTS `vaccination_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vaccination_details` (
  `id` int NOT NULL AUTO_INCREMENT,
  `location` varchar(45) DEFAULT NULL,
  `region` varchar(45) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `location_iso` varchar(10) DEFAULT NULL,
  `region_iso` varchar(10) DEFAULT NULL,
  `total_vaccinations` int DEFAULT NULL,
  `people_vaccinated` int DEFAULT NULL,
  `people_fully_vaccinated` int DEFAULT NULL,
  `total_vaccinations_per_100` double DEFAULT NULL,
  `people_vaccinated_per_100` double DEFAULT NULL,
  `people_fully_vaccinated_per_100` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vaccination_details`
--

LOCK TABLES `vaccination_details` WRITE;
/*!40000 ALTER TABLE `vaccination_details` DISABLE KEYS */;
INSERT INTO `vaccination_details` VALUES (1,'Argentina','Tucuman','2021-01-31 00:07:00','AR','AR-T',1181468,896419,0,70.55,53.53,17.02),(2,'Argentina','Tucuman','2021-01-31 00:07:00','AR','AR-T',1181468,896419,0,70.55,53.53,17.02),(3,'Argentina','Corrientes','2021-01-10 00:05:00','AR','AR-W',192149,167948,0,17.29,15.12,2.18);
/*!40000 ALTER TABLE `vaccination_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-31 17:47:31
