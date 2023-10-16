-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: sephora_project
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `address_id` int NOT NULL AUTO_INCREMENT,
  `district` varchar(255) NOT NULL,
  `state` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `zip_code` int NOT NULL,
  `customer_customer_id` int DEFAULT NULL,
  PRIMARY KEY (`address_id`),
  KEY `FK214xlexe9f13rdbg15mw73h5a` (`customer_customer_id`),
  CONSTRAINT `FK214xlexe9f13rdbg15mw73h5a` FOREIGN KEY (`customer_customer_id`) REFERENCES `customer` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'satara','maha','karad',415124,1),(2,'sangali','karnataka','karve',415115,5),(3,'kolhapur','gujrat','satara',478963,5);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `cart_id` int NOT NULL AUTO_INCREMENT,
  `customer_customer_id` int DEFAULT NULL,
  PRIMARY KEY (`cart_id`),
  UNIQUE KEY `UK_qg2yj5twlynuydiojrp3dgc5i` (`customer_customer_id`),
  CONSTRAINT `FK9hpirec8qm60sghwjqvu0s6ic` FOREIGN KEY (`customer_customer_id`) REFERENCES `customer` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (1,1),(2,2),(4,4),(5,5);
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart_products`
--

DROP TABLE IF EXISTS `cart_products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart_products` (
  `carts_cart_id` int NOT NULL,
  `products_product_id` int NOT NULL,
  KEY `FKs05ud3dow9bi7li6q05gmh546` (`products_product_id`),
  KEY `FKf8v3delxr18ywdddxjq33sc6y` (`carts_cart_id`),
  CONSTRAINT `FKf8v3delxr18ywdddxjq33sc6y` FOREIGN KEY (`carts_cart_id`) REFERENCES `cart` (`cart_id`),
  CONSTRAINT `FKs05ud3dow9bi7li6q05gmh546` FOREIGN KEY (`products_product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart_products`
--

LOCK TABLES `cart_products` WRITE;
/*!40000 ALTER TABLE `cart_products` DISABLE KEYS */;
INSERT INTO `cart_products` VALUES (1,1),(2,1);
/*!40000 ALTER TABLE `cart_products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `customer_id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone_number` varchar(10) DEFAULT NULL,
  `role` varchar(255) NOT NULL,
  PRIMARY KEY (`customer_id`),
  UNIQUE KEY `UK_dwk6cx0afu8bs9o4t536v1j5v` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'shrikhade9096@gmail.com','Shrishambho','Khade','$2a$10$bqPRIqQhHbIid8CwZJmQ7OvqfmEo8K41IC.o62yniMUl8kXPfeCsS','7040801427','ROLE_USER'),(2,'avikhade9527@gmail.com','Avishkar','Khade','$2a$10$bHDHKXrtJcgHiCk4iHnQIOBMR6q1fIvLXLfgYXMNm0TIHa1TxNtcq','7040801427','ROLE_ADMIN'),(4,'aaa@gmail.com','aaa','Khade','$2a$10$haLer/es6AYNfbsDy2wwP.zOJGGumRo/SQ/IzyJDW2fByzCTt9EZW','7040801427','ROLE_USER'),(5,'ddd@gmail.com','ddd','Khade','$2a$10$i3mI3h268L9ICb7984NtBuPUclBIF9/UHXbVZUm9Jk1Zdl1FblPGK','7040801427','ROLE_USER');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `customer_customer_id` int DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `FKgk0a4775o5scnc1sjrg2w8afa` (`customer_customer_id`),
  CONSTRAINT `FKgk0a4775o5scnc1sjrg2w8afa` FOREIGN KEY (`customer_customer_id`) REFERENCES `customer` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'2023-10-15',1);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders_products`
--

DROP TABLE IF EXISTS `orders_products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders_products` (
  `orders_order_id` int NOT NULL,
  `products_product_id` int NOT NULL,
  KEY `FKdux2vo9i0l0w3l5kwyclffhe8` (`products_product_id`),
  KEY `FKkvbdnmkt6wjt1f11o0yxf6602` (`orders_order_id`),
  CONSTRAINT `FKdux2vo9i0l0w3l5kwyclffhe8` FOREIGN KEY (`products_product_id`) REFERENCES `product` (`product_id`),
  CONSTRAINT `FKkvbdnmkt6wjt1f11o0yxf6602` FOREIGN KEY (`orders_order_id`) REFERENCES `orders` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders_products`
--

LOCK TABLES `orders_products` WRITE;
/*!40000 ALTER TABLE `orders_products` DISABLE KEYS */;
INSERT INTO `orders_products` VALUES (1,1),(1,2),(1,3);
/*!40000 ALTER TABLE `orders_products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payments`
--

DROP TABLE IF EXISTS `payments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payments` (
  `payment_id` int NOT NULL AUTO_INCREMENT,
  `amount` double NOT NULL,
  `payment_method` varchar(255) NOT NULL,
  `customer_customer_id` int DEFAULT NULL,
  `orders_order_id` int DEFAULT NULL,
  PRIMARY KEY (`payment_id`),
  UNIQUE KEY `UK_9xhj4t0higpiu2v3nt1lpcmip` (`orders_order_id`),
  KEY `FKluekg5d0ofxx1i1kltyf5kil1` (`customer_customer_id`),
  CONSTRAINT `FK2e4v6lwlnjkoc6wh3ml2sok4i` FOREIGN KEY (`orders_order_id`) REFERENCES `orders` (`order_id`),
  CONSTRAINT `FKluekg5d0ofxx1i1kltyf5kil1` FOREIGN KEY (`customer_customer_id`) REFERENCES `customer` (`customer_id`),
  CONSTRAINT `payments_chk_1` CHECK ((`amount` >= 0))
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payments`
--

LOCK TABLES `payments` WRITE;
/*!40000 ALTER TABLE `payments` DISABLE KEYS */;
INSERT INTO `payments` VALUES (1,80000,'card',1,1);
/*!40000 ALTER TABLE `payments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `product_id` int NOT NULL AUTO_INCREMENT,
  `price` double NOT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `quantity` int NOT NULL,
  PRIMARY KEY (`product_id`),
  CONSTRAINT `product_chk_1` CHECK ((`price` >= 0)),
  CONSTRAINT `product_chk_2` CHECK ((`quantity` >= 1))
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,8800,'Mobile',100),(2,12000,'TV set',78),(3,80000,'Laptop',700),(4,155.55,'Remotes',8900),(5,750,'Key Board',900),(6,1750,'Fan',1800);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-16  8:33:51
