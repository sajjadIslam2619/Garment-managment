-- phpMyAdmin SQL Dump
-- version 4.0.9
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 11, 2014 at 06:05 PM
-- Server version: 5.5.34
-- PHP Version: 5.4.22

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `garments_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `orderinfo`
--

CREATE TABLE IF NOT EXISTS `orderinfo` (
  `orderID` int(11) NOT NULL AUTO_INCREMENT,
  `userID` int(11) NOT NULL,
  `orderTypeID` int(11) NOT NULL,
  `productAmount` int(11) NOT NULL,
  `orderEstimatedDate` date NOT NULL,
  `productID` int(11) NOT NULL,
  `orderDetail` varchar(500) NOT NULL,
  `statusID` int(11) NOT NULL,
  PRIMARY KEY (`orderID`),
  UNIQUE KEY `orderinfo_uniqe` (`orderID`,`userID`),
  KEY `orderstatus_orderinfo_fk` (`statusID`),
  KEY `productinfo_orderinfo_fk` (`productID`),
  KEY `ordertype_orderinfo_fk` (`orderTypeID`),
  KEY `user_orderinfo_fk` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `orderstatus`
--

CREATE TABLE IF NOT EXISTS `orderstatus` (
  `statusID` int(11) NOT NULL AUTO_INCREMENT,
  `orderStatusTypeID` int(11) NOT NULL,
  PRIMARY KEY (`statusID`),
  KEY `orderstatustype_orderstatus_fk` (`orderStatusTypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `orderstatustype`
--

CREATE TABLE IF NOT EXISTS `orderstatustype` (
  `orderStatusTypeID` int(11) NOT NULL AUTO_INCREMENT,
  `orderStatusName` varchar(55) NOT NULL,
  PRIMARY KEY (`orderStatusTypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `ordertype`
--

CREATE TABLE IF NOT EXISTS `ordertype` (
  `orderTypeID` int(11) NOT NULL AUTO_INCREMENT,
  `orderName` varchar(55) NOT NULL,
  PRIMARY KEY (`orderTypeID`),
  UNIQUE KEY `ordertype_unique` (`orderName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `productinfo`
--

CREATE TABLE IF NOT EXISTS `productinfo` (
  `productID` int(11) NOT NULL AUTO_INCREMENT,
  `productName` varchar(55) NOT NULL,
  `productTypeID` int(11) NOT NULL,
  `productPrice` double NOT NULL,
  `productImage` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`productID`),
  UNIQUE KEY `productinfo_unique` (`productName`,`productTypeID`),
  KEY `producttype_productinfo_fk` (`productTypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `producttype`
--

CREATE TABLE IF NOT EXISTS `producttype` (
  `productTypeID` int(11) NOT NULL AUTO_INCREMENT,
  `productTypeName` varchar(55) NOT NULL,
  PRIMARY KEY (`productTypeID`),
  UNIQUE KEY `producttype_unique` (`productTypeName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `rawmatarial`
--

CREATE TABLE IF NOT EXISTS `rawmatarial` (
  `rawMatarialID` int(11) NOT NULL AUTO_INCREMENT,
  `rawMaterialTypeID` int(11) NOT NULL,
  `rawMaterialAmount` int(11) NOT NULL,
  `perUnitPrice` double NOT NULL,
  PRIMARY KEY (`rawMatarialID`),
  KEY `rawmatarialtype_rawmatarial_fk` (`rawMaterialTypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `rawmatarialtype`
--

CREATE TABLE IF NOT EXISTS `rawmatarialtype` (
  `rawMaterialTypeID` int(11) NOT NULL AUTO_INCREMENT,
  `rawMaterialTypeName` varchar(55) NOT NULL,
  PRIMARY KEY (`rawMaterialTypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `userID` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(55) NOT NULL,
  `fullName` varchar(55) NOT NULL,
  `userEmail` varchar(55) NOT NULL,
  `userTypeID` int(11) NOT NULL,
  `password` varchar(55) NOT NULL,
  `companyName` varchar(55) DEFAULT NULL,
  PRIMARY KEY (`userID`),
  UNIQUE KEY `user_unique` (`userEmail`),
  KEY `usertype_user_fk` (`userTypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `usertype`
--

CREATE TABLE IF NOT EXISTS `usertype` (
  `userTypeID` int(11) NOT NULL AUTO_INCREMENT,
  `userTypeName` varchar(55) NOT NULL,
  PRIMARY KEY (`userTypeID`),
  UNIQUE KEY `usertype_uniqe` (`userTypeName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `orderinfo`
--
ALTER TABLE `orderinfo`
  ADD CONSTRAINT `user_orderinfo_fk` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `orderstatus_orderinfo_fk` FOREIGN KEY (`statusID`) REFERENCES `orderstatus` (`statusID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ordertype_orderinfo_fk` FOREIGN KEY (`orderTypeID`) REFERENCES `ordertype` (`orderTypeID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `productinfo_orderinfo_fk` FOREIGN KEY (`productID`) REFERENCES `productinfo` (`productID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `orderstatus`
--
ALTER TABLE `orderstatus`
  ADD CONSTRAINT `orderstatustype_orderstatus_fk` FOREIGN KEY (`orderStatusTypeID`) REFERENCES `orderstatustype` (`orderStatusTypeID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `productinfo`
--
ALTER TABLE `productinfo`
  ADD CONSTRAINT `producttype_productinfo_fk` FOREIGN KEY (`productTypeID`) REFERENCES `producttype` (`productTypeID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `rawmatarial`
--
ALTER TABLE `rawmatarial`
  ADD CONSTRAINT `rawmatarialtype_rawmatarial_fk` FOREIGN KEY (`rawMaterialTypeID`) REFERENCES `rawmatarialtype` (`rawMaterialTypeID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `usertype_user_fk` FOREIGN KEY (`userTypeID`) REFERENCES `usertype` (`userTypeID`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
