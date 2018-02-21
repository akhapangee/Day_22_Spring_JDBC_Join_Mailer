-- MySQL dump 10.16  Distrib 10.1.29-MariaDB, for Win32 (AMD64)
--
-- Host: localhost    Database: online_enrollment
-- ------------------------------------------------------
-- Server version	10.1.29-MariaDB

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
-- Table structure for table `courses`
--

DROP TABLE IF EXISTS `courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `courses` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `code` varchar(3) DEFAULT NULL,
  `fees` int(11) DEFAULT NULL,
  `added_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses`
--

LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` VALUES (1,'Core Java','CJV',15000,'2018-02-18 15:22:37',1),(2,'Advanced Java','AJV',25000,'2018-02-18 15:22:37',1),(3,'Combo java','CMJ',35000,'2018-02-18 15:22:37',1),(4,'Asp.net MVC','ASP',35000,'2018-02-18 15:22:37',1);
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enquiries`
--

DROP TABLE IF EXISTS `enquiries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `enquiries` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(100) DEFAULT NULL,
  `last_name` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `contact_no` varchar(100) DEFAULT NULL,
  `message` text,
  `course_id` int(11) DEFAULT NULL,
  `enquiry_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `course_id` (`course_id`),
  KEY `status` (`status`),
  CONSTRAINT `enquiries_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`),
  CONSTRAINT `enquiries_ibfk_2` FOREIGN KEY (`status`) REFERENCES `enquiry_status` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enquiries`
--

LOCK TABLES `enquiries` WRITE;
/*!40000 ALTER TABLE `enquiries` DISABLE KEYS */;
INSERT INTO `enquiries` VALUES (1,'Akhilesh ','Khapangee','akhapangee@gmail.com','9849429054','Interested',2,'2018-02-18 15:34:47',4),(2,'Ankita','Paudel','ankita.paudel43@gmail.com','5353434','I am interested',1,'2018-02-19 15:33:37',3),(3,'Ram','Thapa','ankita.paudel43@gmail.com','4343535','I am interested in this course',2,'2018-02-19 15:34:19',4),(4,'Akhilesh ','Khapangee','akhapangee@gmail.com','3443','test',2,'2018-02-20 03:27:57',4),(5,'Akhilesh ','Khapangee','akhapangee@gmail.com','3443','test',2,'2018-02-20 03:29:07',4),(6,'Akhilesh ','Khapangee','akhapangee@gmail.com','4343','fsdf',2,'2018-02-20 03:30:53',4),(7,'Akhilesh ','Khapangee','akhapangee@gmail.com','4343','fsdf',2,'2018-02-20 03:32:20',4),(8,'Akhilesh ','Khapangee','akhapangee@gmail.com','4343','fsdf',2,'2018-02-20 03:35:06',4),(9,'Akhilesh ','Khapangee','akhapangee@gmail.com','4343','fsdf',2,'2018-02-20 03:36:01',4),(10,'Akhilesh ','Khapangee','akhapangee@gmail.com','4343','fsdf',2,'2018-02-20 03:37:10',4),(11,'Akhilesh ','Khapangee','akhapangee@gmail.com','4343','fsdf',2,'2018-02-20 03:38:00',4),(12,'Akhilesh ','Khapangee','akhapangee@gmail.com','4343','fsdf',2,'2018-02-20 03:38:48',4),(13,'Akhilesh ','Khapangee','akhapangee@gmail.com','4343','fsdf',2,'2018-02-20 03:41:20',4),(14,'Akhilesh ','Khapangee','akhapangee@gmail.com','4343','fsdf',2,'2018-02-20 03:42:42',4),(15,'Akhilesh ','Khapangee','akhapangee@gmail.com','4343','fsdf',2,'2018-02-20 03:44:17',4),(16,'Akhilesh ','Khapangee','akhapangee@gmail.com','9849429054','dfdsf',2,'2018-02-20 03:48:05',4),(17,'Akhilesh ','Khapangee','akhapangee@gmail.com','9849429054','dfdsf',2,'2018-02-20 03:50:17',4),(18,'Akhilesh ','Khapangee','akhapangee@gmail.com','9849429054','dfdsf',2,'2018-02-20 03:51:18',4),(19,'Akhilesh ','Khapangee','akhapangee@gmail.com','9849429054','dfdsf',2,'2018-02-20 03:52:52',4),(20,'Akhilesh ','Khapangee','akhapangee@gmail.com','9849429054','dfdsf',2,'2018-02-20 04:04:19',4),(21,'Akhilesh ','Khapangee','akhapangee@gmail.com','9849429054','dfdsf',2,'2018-02-20 04:05:53',4),(22,'Akhilesh ','Khapangee','akhapangee@gmail.com','9849429054','fdsfsd',3,'2018-02-20 04:08:04',4),(23,'Akhilesh ','Khapangee','akhapangee@gmail.com','9849429054','fdsfsd',3,'2018-02-20 04:09:18',4),(24,'Akhilesh ','Khapangee','akhapangee@gmail.com','9849429054','fdsfsd',3,'2018-02-20 04:10:06',4),(25,'Akhilesh ','Khapangee','akhapangee@gmail.com','9849429054','fdsfsd',3,'2018-02-20 04:11:43',4),(26,'Akhilesh ','Khapangee','akhapangee@gmail.com','9849429054','rfsdfds',1,'2018-02-20 04:14:06',4),(27,'Tenzin','Lama','tenzinchoezom@gmail.com','9849429054','Ifdfdfdf',3,'2018-02-20 04:17:44',4),(28,'Tenzin','Lama','tenzinchoezom@gmail.com','9849429054','Ifdfdfdf',3,'2018-02-20 04:19:38',4),(29,'Ram','Thapa','akhilesh.khapangee@bottomline.com','9849429054','Ifdfdfdf',3,'2018-02-20 04:20:23',4),(30,'Sujesh','Munankarmi','smunakarmi@bottomline.com','9849429054','eerfdfd',3,'2018-02-20 04:31:12',4),(31,'Raghav','Shrestha','rshrestha@bottomline.com','9849429054','eerfdfd',2,'2018-02-20 04:32:00',4),(32,'Akhilesh ','Khapangee','akhapangee@gmail.com','9849429054','jdjdjd',2,'2018-02-20 05:45:41',4),(33,'Akhilesh ','Khapangee','akhapangee@gmail.com','9849429054','jdjdjd',2,'2018-02-20 05:48:25',4),(34,'Akhilesh ','Thapa','akhapangee@gmail.com','9849429054','ggghh',3,'2018-02-20 05:49:53',4),(35,'Akhilesh ','Thapa','akhapangee@gmail.com','9849429054','ggghh',3,'2018-02-20 05:51:23',4),(36,'Akhilesh ','Thapa','akhapangee@gmail.com','9849429054','ggghh',3,'2018-02-20 05:51:34',4),(37,'Akhilesh ','Thapa','akhapangee@gmail.com','9849429054','ggghh',3,'2018-02-20 05:51:58',4),(38,'Akhilesh ','Khapangee','akhapangee@gmail.com','9849429054','sadsadas',2,'2018-02-20 05:54:02',4),(39,'Akhilesh ','Khapangee','akhapangee@gmail.com','9849429054','fsdfsdfsdf',2,'2018-02-20 07:39:38',4);
/*!40000 ALTER TABLE `enquiries` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enquiry_status`
--

DROP TABLE IF EXISTS `enquiry_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `enquiry_status` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `color` varchar(20) DEFAULT NULL,
  `added_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enquiry_status`
--

LOCK TABLES `enquiry_status` WRITE;
/*!40000 ALTER TABLE `enquiry_status` DISABLE KEYS */;
INSERT INTO `enquiry_status` VALUES (1,'Enrolled','green','2018-02-18 15:22:37',1),(2,'Interested','pink','2018-02-18 15:22:37',1),(3,'Not Interested','red','2018-02-18 15:22:37',1),(4,'Pending','white','2018-02-18 15:22:37',1);
/*!40000 ALTER TABLE `enquiry_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mail_templates`
--

DROP TABLE IF EXISTS `mail_templates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mail_templates` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `slug` varchar(255) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `content` text,
  `added_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mail_templates`
--

LOCK TABLES `mail_templates` WRITE;
/*!40000 ALTER TABLE `mail_templates` DISABLE KEYS */;
INSERT INTO `mail_templates` VALUES (1,'Enroll-Confirmation','Enrollment Confirmation','Hi [NAME],\r\n\r\nThank you for showing interest in learning \'[COURSE]\' with\r\nus.\r\n\r\nRegards\r\nTest Department\r\n','2018-02-18 15:22:37',1);
/*!40000 ALTER TABLE `mail_templates` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-21 12:08:03
