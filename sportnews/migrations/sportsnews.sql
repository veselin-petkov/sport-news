-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: sportnews
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `categories`
--

create database sportnews1;
use sportnews1;

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories` (
  `category` varchar(255) NOT NULL,
  PRIMARY KEY (`category`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES ('Basketball'),('Boulevard'),('Football'),('Levski'),('Motorsport'),('Tennis'),('Volleyball');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comments` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `content` varchar(255) NOT NULL,
  `date` datetime DEFAULT CURRENT_TIMESTAMP,
  `news_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `news_id` (`news_id`),
  CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `comments_ibfk_2` FOREIGN KEY (`news_id`) REFERENCES `news` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` VALUES (1,1,'PEDAL SI','2022-06-15 18:16:11',1),(2,1,'some cool comments','2022-06-15 18:58:47',2),(3,1,'some cool comments','2022-06-15 18:58:49',3),(4,1,'some cool comments','2022-06-15 18:58:50',4),(5,1,'some cool comments','2022-06-15 18:58:51',5),(6,1,'some cool comments','2022-06-15 19:02:38',1),(7,1,'pls','2022-06-16 12:15:20',1);
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `news`
--

DROP TABLE IF EXISTS `news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `news` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `content` text NOT NULL,
  `date` datetime DEFAULT CURRENT_TIMESTAMP,
  `category` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `category` (`category`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `news_ibfk_1` FOREIGN KEY (`category`) REFERENCES `categories` (`category`),
  CONSTRAINT `news_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news`
--

LOCK TABLES `news` WRITE;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` VALUES (1,1,'Левски се похвали с първи постъпения от \'Левски на левскарите\'','Сдружението \'Левски на Левскарите\' преведе сумата от 100 000 лева по сметката на Левски. Това беше обявено от официалната Фейсбук страница на \'сините\', както и от страницата на самото сдружение. В съобщението се споменава, че надеждата е плащанията тепърва да предстоят, за да може столичният гранд да си стъпи на краката, финансово. ','2022-06-10 12:38:28','Football','https://firebasestorage.googleapis.com/v0/b/sportsnewsbg-753cb.appspot.com/o/images%2F735-459-levski-sofiia-septemvri-sofiia.jpg?alt=media&token=529a226e-7932-4ab2-ba86-bc6910f95759'),(2,1,'Неделев се прибира в България, всички се надяват да няма силен насрещен вятър','Футболистът на Ботев Пловдив и националния отбор на България - Тодор Неделев, ще се прибере в България в сряда. Това ще се случи със специален медицински самолет, който БФС е осигурил. \n\nКакто е известно, Тошко пострада сериозно в катастрофа в Грузия и бе опериран по спешност, тъй като бе със счупен череп. Добрата новина е, че възстановяването му върви по план.','2022-06-13 18:00:15','Football','https://firebasestorage.googleapis.com/v0/b/sportsnewsbg-753cb.appspot.com/o/images%2F960-600-bylgariia-severna-irlandiia-lap.jpg?alt=media&token=de1072dc-a0a2-46b3-af7a-1dd4abe7c888'),(3,1,'ЦСКА - София чака четиримата си национали днес','Националните състезатели на ЦСКА - София Жорди Кайседо, Иван Турицов, Георги Йомов и Яник Вилдсхут трябва да се присъединият днес към лагера на “червените” в Австрия. Четиримата бяха ангажирани със селекциите съответно на Еквадор, България и Суринам, а след това получиха и няколко дни почивка, посочва “Тема спорт”. С тяхното пристигане наставникът Саша Илич ще има на разположение всички играчи, които имат договори с клуба.','2022-06-13 18:00:24','Football','https://firebasestorage.googleapis.com/v0/b/sportsnewsbg-753cb.appspot.com/o/images%2F237e7591-92a7-4bb4-bc7e-a5ef174fc31b.webp?alt=media&token=40969570-a381-40d3-84e0-92b60901688a'),(4,1,'Сестрата на Божинов се глези с национал от Левски (снимка)','Националът на Левски Андриан Краев е на море с очарователната си половинка Михаела Ангелова. Офанзивният футболист и сестрата на Валери Божинов избраха да почиват в Созопол. \n\nВлюбената двойка се показа в огромно дървено сърце на плажа с панорамен изглед към морето. Краев публикува снимката в социалните мрежи с текст към нея: \'Летни усещания\'. ','2022-06-13 18:00:26','Boulevard','https://firebasestorage.googleapis.com/v0/b/sportsnewsbg-753cb.appspot.com/o/images%2F960-600-mihaela-angelova.jpg?alt=media&token=2cbc2a59-1823-4b8c-9aeb-3cc57be16898'),(5,1,'Сериозни проблеми за Саша Илич','Сериозни тревоги надвиснаха над Саша Илич още след неофициалния му дебют начело на ЦСКА - София. В 29-ата минута на съботната контрола с Гройтер Фюрт (1:4) Енес Махмутович, за когото това също бе първи мач, тъй като нямаше картотека през пролетта, бе заменен принудително. Бранителят получи удар в крака. Националът на Люксембург изпитва сериозни болки в коляното и заради тях пропусна вчерашната тренировка. Днес той ще премине медицински изследвания, които ще определят за колко време ще отсъства от терена. Опасенията на треньорския щаб са, че бранителят може да бъде аут от сметките за повече от месец. ','2022-06-13 18:00:27','Football','https://firebasestorage.googleapis.com/v0/b/sportsnewsbg-753cb.appspot.com/o/images%2Fc23e4a9d-38f5-44db-aafc-0af3a54422ce.webp?alt=media&token=0d95b9ca-09dd-4ed4-a882-1df5828854a9'),(10,1,'Изключителна драма! България загуби от Белгия след 5 гейма и страхотна битка','Женският национален отбор на България не успя да продължи победния си път във Волейболната лига на нациите. \n\nМомичетата на треньора Лоренцо Мичели отстъпиха на Белгия след 5 гейма драматична битка 3:2 (22:25, 23:25, 25:20, 25:20, 15:17) в последния си мач от втория уикенд в Лигата на нациите в Кесон Сити (Филипините). \n\nТака българските волейболистки взеха ценна точка, но остават само с 2 победи засега в Лигата на нациите. ','2022-06-14 11:16:23','Volleyball','https://firebasestorage.googleapis.com/v0/b/sportsnewsbg-753cb.appspot.com/o/images%2F1227cd58-5382-4315-8c86-ee40227f0e01.webp?alt=media&token=524b6dcc-f067-4193-9696-bac48f76b121'),(11,1,'Безгрешен Верстапен не трепна под натиска на Сайнц и спечели в Канада','Световният шампион Макс Верстапен направи едно безгрешно каране на пистата „Жил Вилньов“ в Канада и заслужено стигна до своята шеста победа от началото на сезона във Формула 1. Нидерландецът трябваше да устои на силната преса на своя бивш съотборник Карлос Сайнц в последните обиколки. Двамата бяха събрани при късното излизането на колата за сигурност, като испанецът разполагаше с шест обиколки по-свежи гуми. ','2022-06-14 18:39:57','Motorsport','https://firebasestorage.googleapis.com/v0/b/sportsnewsbg-753cb.appspot.com/o/images%2Fimage.jpg?alt=media&token=515e6017-5386-4f4d-9d11-5156603de289'),(26,1,'Верстапен със златен шанс да увеличи преднината си в генералното класиране','Световният шампион във Формула 1 Макс Верстапен завоюва своя втори полпозишън от началото на сезон 2022 след като спечели снощната квалификация за Гран При на Канада. По-важното за пилота на Ред Бул преди старта в Монреал е, че неговите основни преследвачи в спора за титлата – Серхио Перес и Шарл Леклер ще бъдат във втората половина на стартовата решетка.','2022-06-19 18:38:53','Motorsport','https://firebasestorage.googleapis.com/v0/b/sportsnewsbg-753cb.appspot.com/o/images%2Fc2f17c5a-f045-4678-ba83-319b3a885e68.webpe0b7de2d-dcff-4560-829f-2a854f2b2995?alt=media&token=49f2bb2c-0fb1-40ce-a6fc-f6f4860ee7d4'),(27,1,'Златната династия на Голдън Стейт си заслужи още един триумф в НБА!','Отборът на Голдън Стейт Уориърс е новият шампион в НБА! \"Воините\" завоюваха седмата титла в клубната си история, след като надиграха Бостън Селтикс с 4-2 победи на финала в най-силната лига в света. Възпитаниците на старши треньора Стив Кър се завърнаха на върха отвъд океана тази нощ, след като спечелиха мач №6 от серията с \"келтите\" с крайното 103:90 (27:22, 27:17, 22:27, 27:24) в зала \"Ти Ди Гардън\" в Масачузетс.','2022-06-20 12:17:22','Basketball','https://firebasestorage.googleapis.com/v0/b/sportsnewsbg-753cb.appspot.com/o/images%2F5d69d181-a2dc-4f23-b4bf-70b5a5635e17.jpg?alt=media&token=3beabf54-edcd-4928-a9fa-1d76fa5cc83d'),(28,1,'Григор с място нагоре в ранглистата, ново рекордно класиране за Кузманов','Най-добрият български тенисист Григор Димитров се изкачи с една позиция в световната ранглиста и се завърна на 21-ата с актив от 1785 точки. През миналата седмица той участва на турнира в Куинс, но отпадна рано, записвайки изненадващо поражение от Ботик ван де Зандсхул във втория си мач. Спечелените в Лондон 45 точки и загубата на Алекс Де Минор в ранен етап обаче помогнаха на Димитров да направи крачка нагоре в класацията в навечерието на “Уимбълдън”.\n\nНово рекордно класиране записа втората ракета на мъжкия ни тенис Димитър Кузманов, който се изкачи с 4 места до №175 със 321 точки.','2022-06-20 12:20:24','Tennis','https://firebasestorage.googleapis.com/v0/b/sportsnewsbg-753cb.appspot.com/o/images%2Fbec0f8c8-6bbd-46e8-a621-bb535d84d7a3.webp53bb065d-6ccc-4005-9501-791de83978f1?alt=media&token=5d04ae36-91b1-4fc2-8193-9ba79c4eeb1f');
/*!40000 ALTER TABLE `news` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tag_news_relationship`
--

DROP TABLE IF EXISTS `tag_news_relationship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tag_news_relationship` (
  `news_id` int NOT NULL,
  `tag_id` int NOT NULL,
  PRIMARY KEY (`news_id`,`tag_id`),
  KEY `tag_id` (`tag_id`),
  CONSTRAINT `tag_news_relationship_ibfk_1` FOREIGN KEY (`news_id`) REFERENCES `news` (`id`),
  CONSTRAINT `tag_news_relationship_ibfk_2` FOREIGN KEY (`tag_id`) REFERENCES `tags` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tag_news_relationship`
--

LOCK TABLES `tag_news_relationship` WRITE;
/*!40000 ALTER TABLE `tag_news_relationship` DISABLE KEYS */;
INSERT INTO `tag_news_relationship` VALUES (1,1),(2,1),(3,1),(5,1),(1,3),(3,3),(3,4),(5,4);
/*!40000 ALTER TABLE `tag_news_relationship` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tags`
--

DROP TABLE IF EXISTS `tags`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tags` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tag_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tags`
--

LOCK TABLES `tags` WRITE;
/*!40000 ALTER TABLE `tags` DISABLE KEYS */;
INSERT INTO `tags` VALUES (1,'BG Futbol'),(2,'Evropeiski futbol'),(3,'Levski'),(4,'CSKA-Sofia'),(5,'Ludogorets');
/*!40000 ALTER TABLE `tags` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_roles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role_name` enum('USER','ADMIN','MODERATOR','BANNED') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (1,'USER'),(2,'ADMIN'),(3,'MODERATOR'),(4,'BANNED');
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `registration_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `role_id` int DEFAULT '1',
  `salt` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `users_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `user_roles` (`id`),
  CONSTRAINT `chk_email` CHECK ((`email` like _utf8mb4'%_@__%.__%')),
  CONSTRAINT `username` CHECK ((length(`username`) >= 4))
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin','3a65f8cc5299c5a81f73b44fa3328d55396bdfdd7d005a4164c351e8ffb693d3',NULL,'2022-06-10 11:54:55',2,'LpfHFPZ7BZ/8n5+Knpa2PE10CF4='),(3,'belo','123','user@user.com','2022-06-10 11:57:00',1,'LpfHFPZ7BZ/8n5+Knpa2PE10CF4='),(4,'denislav.berberov','123','user@user.com','2022-06-10 12:01:04',1,'LpfHFPZ7BZ/8n5+Knpa2PE10CF4='),(5,'warnimal','123','user@user.com','2022-06-10 13:19:31',1,'LpfHFPZ7BZ/8n5+Knpa2PE10CF4='),(6,'blago','123','user@user.com','2022-06-10 16:35:02',1,'LpfHFPZ7BZ/8n5+Knpa2PE10CF4='),(7,'ivaylo','123','user@user.com','2022-06-10 18:05:27',1,'LpfHFPZ7BZ/8n5+Knpa2PE10CF4='),(11,'admin123','3a65f8cc5299c5a81f73b44fa3328d55396bdfdd7d005a4164c351e8ffb693d3','user@user.com','2022-06-10 18:08:48',1,'LpfHFPZ7BZ/8n5+Knpa2PE10CF4='),(12,'dasdasd','dasdas','user@user.com','2022-06-13 12:37:13',1,'LpfHFPZ7BZ/8n5+Knpa2PE10CF4='),(13,'viktor4o','123','user@user.com','2022-06-13 14:38:23',1,'LpfHFPZ7BZ/8n5+Knpa2PE10CF4='),(14,'user123','123','user@user.com','2022-06-13 15:13:30',1,'LpfHFPZ7BZ/8n5+Knpa2PE10CF4='),(15,'springuser','spring123','user@user.com','2022-06-15 13:51:57',1,NULL),(16,'didwehash','3a65f8cc5299c5a81f73b44fa3328d55396bdfdd7d005a4164c351e8ffb693d3','user@user.com','2022-06-17 12:58:47',1,'LpfHFPZ7BZ/8n5+Knpa2PE10CF4='),(17,'user','523371b7b9884db44ee1882282eb73eebb66c304c743f216bd02ec6cbe55e5e2','user@user.com','2022-06-20 13:04:50',1,'ZpmIkZbhnH033dmUij7Icx2TjDI=');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-20 13:11:46
