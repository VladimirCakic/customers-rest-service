CREATE DATABASE  IF NOT EXISTS `web_customer_tracker`;
USE `web_customer_tracker`;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;

INSERT INTO `customer` VALUES 
	(1,'Milan','Novakovic','milan@eposta.com'),
	(2,'Ana','Petrovic','ana@eposta.com'),
	(3,'Nemanja','Djordjevic','nemanja@eposta.com'),
	(4,'Marija','Misic','mary@eposta.com'),
	(5,'Ljubica','Stankovic','ljubica@eposta.com');

UNLOCK TABLES;
