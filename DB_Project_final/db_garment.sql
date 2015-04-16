-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 12, 2014 at 03:15 PM
-- Server version: 5.5.27
-- PHP Version: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `db_garment`
--

-- --------------------------------------------------------

--
-- Table structure for table `order_info`
--

CREATE TABLE IF NOT EXISTS `order_info` (
  `id_order_info` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) NOT NULL,
  `id_order_type` int(11) NOT NULL,
  `product_amount` int(11) NOT NULL,
  `order_estimated_date` date NOT NULL,
  `id_product` int(11) NOT NULL,
  `order_detail` varchar(500) DEFAULT NULL,
  `id_order_status` int(11) NOT NULL,
  PRIMARY KEY (`id_order_info`),
  UNIQUE KEY `orderinfo_uniqe` (`id_order_info`,`id_user`),
  KEY `orderstatus_orderinfo_fk` (`id_order_status`),
  KEY `productinfo_orderinfo_fk` (`id_product`),
  KEY `ordertype_orderinfo_fk` (`id_order_type`),
  KEY `user_orderinfo_fk` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `order_status`
--

CREATE TABLE IF NOT EXISTS `order_status` (
  `id_order_status` int(11) NOT NULL AUTO_INCREMENT,
  `id_order_status_type` int(11) NOT NULL,
  PRIMARY KEY (`id_order_status`),
  KEY `orderstatustype_orderstatus_fk` (`id_order_status_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `order_status_type`
--

CREATE TABLE IF NOT EXISTS `order_status_type` (
  `id_order_status_type` int(11) NOT NULL AUTO_INCREMENT,
  `order_status_name` varchar(55) NOT NULL,
  PRIMARY KEY (`id_order_status_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `order_type`
--

CREATE TABLE IF NOT EXISTS `order_type` (
  `id_order_type` int(11) NOT NULL AUTO_INCREMENT,
  `order_name` varchar(55) NOT NULL,
  PRIMARY KEY (`id_order_type`),
  UNIQUE KEY `ordertype_unique` (`order_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `product_info`
--

CREATE TABLE IF NOT EXISTS `product_info` (
  `id_product` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(55) NOT NULL,
  `id_product_type` int(11) NOT NULL,
  `product_price` double NOT NULL,
  `product_image` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_product`),
  UNIQUE KEY `productinfo_unique` (`product_name`,`id_product_type`),
  KEY `producttype_productinfo_fk` (`id_product_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `product_type`
--

CREATE TABLE IF NOT EXISTS `product_type` (
  `id_product_type` int(11) NOT NULL AUTO_INCREMENT,
  `product_type_name` varchar(55) NOT NULL,
  PRIMARY KEY (`id_product_type`),
  UNIQUE KEY `producttype_unique` (`product_type_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `raw_matarial`
--

CREATE TABLE IF NOT EXISTS `raw_matarial` (
  `id_raw_matarial` int(11) NOT NULL AUTO_INCREMENT,
  `id_raw_material_type` int(11) NOT NULL,
  `raw_material_amount` int(11) NOT NULL,
  `per_unit_price` double NOT NULL,
  PRIMARY KEY (`id_raw_matarial`),
  KEY `rawmatarialtype_rawmatarial_fk` (`id_raw_material_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `raw_matarial_type`
--

CREATE TABLE IF NOT EXISTS `raw_matarial_type` (
  `id_raw_material_type` int(11) NOT NULL AUTO_INCREMENT,
  `raw_material_type_name` varchar(55) NOT NULL,
  PRIMARY KEY (`id_raw_material_type`),
  UNIQUE KEY `rawmatarialtype_idx` (`raw_material_type_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `user_info`
--

CREATE TABLE IF NOT EXISTS `user_info` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(55) NOT NULL,
  `full_name` varchar(55) NOT NULL,
  `user_email` varchar(55) NOT NULL,
  `id_user_type` int(11) NOT NULL,
  `password` varchar(55) NOT NULL,
  `company_name` varchar(55) DEFAULT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `user_unique` (`user_email`),
  KEY `usertype_user_fk` (`id_user_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `user_type`
--

CREATE TABLE IF NOT EXISTS `user_type` (
  `id_user_type` int(11) NOT NULL AUTO_INCREMENT,
  `user_type_name` varchar(55) NOT NULL,
  PRIMARY KEY (`id_user_type`),
  UNIQUE KEY `usertype_uniqe` (`user_type_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1 ;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `order_info`
--
ALTER TABLE `order_info`
  ADD CONSTRAINT `orderstatus_orderinfo_fk` FOREIGN KEY (`id_order_status`) REFERENCES `order_status` (`id_order_status`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ordertype_orderinfo_fk` FOREIGN KEY (`id_order_type`) REFERENCES `order_type` (`id_order_type`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `productinfo_orderinfo_fk` FOREIGN KEY (`id_product`) REFERENCES `product_info` (`id_product`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `user_orderinfo_fk` FOREIGN KEY (`id_user`) REFERENCES `user_info` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `order_status`
--
ALTER TABLE `order_status`
  ADD CONSTRAINT `orderstatustype_orderstatus_fk` FOREIGN KEY (`id_order_status_type`) REFERENCES `order_status_type` (`id_order_status_type`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `product_info`
--
ALTER TABLE `product_info`
  ADD CONSTRAINT `producttype_productinfo_fk` FOREIGN KEY (`id_product_type`) REFERENCES `product_type` (`id_product_type`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `raw_matarial`
--
ALTER TABLE `raw_matarial`
  ADD CONSTRAINT `rawmatarialtype_rawmatarial_fk` FOREIGN KEY (`id_raw_material_type`) REFERENCES `raw_matarial_type` (`id_raw_material_type`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `user_info`
--
ALTER TABLE `user_info`
  ADD CONSTRAINT `usertype_user_fk` FOREIGN KEY (`id_user_type`) REFERENCES `user_type` (`id_user_type`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
