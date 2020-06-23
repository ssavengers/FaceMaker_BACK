-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: emotions
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `anger_table`
--

DROP TABLE IF EXISTS `anger_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `anger_table` (
  `no` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `src` varchar(150) COLLATE utf8_bin DEFAULT NULL,
  `stage` int DEFAULT NULL,
  `anger` double DEFAULT NULL,
  `contempt` double DEFAULT NULL,
  `fear` double DEFAULT NULL,
  `happiness` double DEFAULT NULL,
  `neutral` double DEFAULT NULL,
  `sadness` double DEFAULT NULL,
  `surprise` double DEFAULT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `anger_table`
--

LOCK TABLES `anger_table` WRITE;
/*!40000 ALTER TABLE `anger_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `anger_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contempt_table`
--

DROP TABLE IF EXISTS `contempt_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contempt_table` (
  `no` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `src` varchar(150) COLLATE utf8_bin DEFAULT NULL,
  `stage` int DEFAULT NULL,
  `anger` double DEFAULT NULL,
  `contempt` double DEFAULT NULL,
  `fear` double DEFAULT NULL,
  `happiness` double DEFAULT NULL,
  `neutral` double DEFAULT NULL,
  `sadness` double DEFAULT NULL,
  `surprise` double DEFAULT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contempt_table`
--

LOCK TABLES `contempt_table` WRITE;
/*!40000 ALTER TABLE `contempt_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `contempt_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fear_table`
--

DROP TABLE IF EXISTS `fear_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fear_table` (
  `no` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `src` varchar(150) COLLATE utf8_bin DEFAULT NULL,
  `stage` int DEFAULT NULL,
  `anger` double DEFAULT NULL,
  `contempt` double DEFAULT NULL,
  `fear` double DEFAULT NULL,
  `happiness` double DEFAULT NULL,
  `neutral` double DEFAULT NULL,
  `sadness` double DEFAULT NULL,
  `surprise` double DEFAULT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fear_table`
--

LOCK TABLES `fear_table` WRITE;
/*!40000 ALTER TABLE `fear_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `fear_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `happiness_table`
--

DROP TABLE IF EXISTS `happiness_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `happiness_table` (
  `no` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `src` varchar(150) COLLATE utf8_bin DEFAULT NULL,
  `stage` int DEFAULT NULL,
  `anger` double DEFAULT NULL,
  `contempt` double DEFAULT NULL,
  `fear` double DEFAULT NULL,
  `happiness` double DEFAULT NULL,
  `neutral` double DEFAULT NULL,
  `sadness` double DEFAULT NULL,
  `surprise` double DEFAULT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `happiness_table`
--

LOCK TABLES `happiness_table` WRITE;
/*!40000 ALTER TABLE `happiness_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `happiness_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `neutral_table`
--

DROP TABLE IF EXISTS `neutral_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `neutral_table` (
  `no` int NOT NULL AUTO_INCREMENT,
  `age` int DEFAULT NULL,
  `name` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `src` varchar(150) COLLATE utf8_bin DEFAULT NULL,
  `stage` int DEFAULT NULL,
  `anger` double DEFAULT NULL,
  `contempt` double DEFAULT NULL,
  `fear` double DEFAULT NULL,
  `happiness` double DEFAULT NULL,
  `neutral` double DEFAULT NULL,
  `sadness` double DEFAULT NULL,
  `surprise` double DEFAULT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `neutral_table`
--

LOCK TABLES `neutral_table` WRITE;
/*!40000 ALTER TABLE `neutral_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `neutral_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sadness_table`
--

DROP TABLE IF EXISTS `sadness_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sadness_table` (
  `no` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `src` varchar(150) COLLATE utf8_bin DEFAULT NULL,
  `stage` int DEFAULT NULL,
  `anger` double DEFAULT NULL,
  `contempt` double DEFAULT NULL,
  `fear` double DEFAULT NULL,
  `happiness` double DEFAULT NULL,
  `neutral` double DEFAULT NULL,
  `sadness` double DEFAULT NULL,
  `surprise` double DEFAULT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sadness_table`
--

LOCK TABLES `sadness_table` WRITE;
/*!40000 ALTER TABLE `sadness_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `sadness_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `surprise_table`
--

DROP TABLE IF EXISTS `surprise_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `surprise_table` (
  `no` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `src` varchar(150) COLLATE utf8_bin DEFAULT NULL,
  `stage` int DEFAULT NULL,
  `anger` double DEFAULT NULL,
  `contempt` double DEFAULT NULL,
  `fear` double DEFAULT NULL,
  `happiness` double DEFAULT NULL,
  `neutral` double DEFAULT NULL,
  `sadness` double DEFAULT NULL,
  `surprise` double DEFAULT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `surprise_table`
--

LOCK TABLES `surprise_table` WRITE;
/*!40000 ALTER TABLE `surprise_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `surprise_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userinfo`
--

DROP TABLE IF EXISTS `userinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userinfo` (
  `no` int NOT NULL AUTO_INCREMENT,
  `name` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `age` int DEFAULT NULL,
  `src` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userinfo`
--

LOCK TABLES `userinfo` WRITE;
/*!40000 ALTER TABLE `userinfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `userinfo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-23 15:26:01
