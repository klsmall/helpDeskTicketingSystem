-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: ticketingsystem490
-- ------------------------------------------------------
-- Server version	5.7.19-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tickets`
--

DROP TABLE IF EXISTS `tickets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tickets` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `createdBy` varchar(45) NOT NULL,
  `technician` varchar(45) NOT NULL,
  `compSpecs` varchar(45) NOT NULL,
  `description` varchar(256) NOT NULL,
  `openDate` varchar(45) NOT NULL,
  `closeDate` varchar(45) NOT NULL,
  `title` varchar(45) NOT NULL,
  `problemCatagory` varchar(45) NOT NULL,
  `photo` blob,
  `email` varchar(45) NOT NULL,
  `deviceType` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1124 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tickets`
--

LOCK TABLES `tickets` WRITE;
/*!40000 ALTER TABLE `tickets` DISABLE KEYS */;
INSERT INTO `tickets` VALUES (1122,'jeff','not Assigned','HP','so many toolbars','Wed 11.29.2017 at 12:48:35 AM EST','Open','browser','infected','¬\í\0sr\0java.io.File-¤E\r\äÿ\0L\0patht\0Ljava/lang/String;xpt\0(C:\\Users\\Gavin\\Desktop\\Mindsparkbars.pngw\0\\x','jeff@jeff.com','Laptop'),(1123,'jeff','not Assigned','HP','the printer will not print','Wed 11.29.2017 at 12:49:29 AM EST','Open','wont print','infected','¬\í\0sr\0java.io.File-¤E\r\äÿ\0L\0patht\0Ljava/lang/String;xpt\0\0w\0\\x','jeff@jeff.com','Printer');
/*!40000 ALTER TABLE `tickets` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-29  0:54:38
