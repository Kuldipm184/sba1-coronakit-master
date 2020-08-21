CREATE DATABASE  IF NOT EXISTS `coronakitdb` ;
USE `coronakitdb`;

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(45) DEFAULT NULL,
  `cost` varchar(45) DEFAULT NULL,
  `product_description` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
INSERT INTO `product` (`product_name`, `cost`, `product_description`)  VALUES ('Sanetizer',100,'Hand Sanitizer with Quick & Persistent Action Protects Your Hands from Viruses');
INSERT INTO `product` (`product_name`, `cost`, `product_description`)  VALUES ('Gloves',200,'To protect an individual hand from germs ');
INSERT INTO `product` (`product_name`, `cost`, `product_description`)  VALUES ('PPE Suit',1000,'Suit made to protect you whole body to get in contact with virus');
INSERT INTO `product` (`product_name`, `cost`, `product_description`)  VALUES ('N95 Mask',200,'Best for Covid 19 ');
