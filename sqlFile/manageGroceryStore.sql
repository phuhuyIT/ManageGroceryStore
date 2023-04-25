DROP DATABASE IF EXISTS managegrocerystore;
CREATE DATABASE MANAGEGROCERYSTORE
CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci ;
USE MANAGEGROCERYSTORE;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+07:00";

CREATE TABLE `currentstocks` (
  `productcode` varchar(100) NOT NULL,
  `quantity` int(11) NOT NULL,
  CONSTRAINT quantity CHECK (QUANTITY>=0)
) ENGINE=InnoDB ;


INSERT INTO `currentstocks` (`productcode`, `quantity`) VALUES
('p2', 30),
('p1', 1),
('p10', 0),
('prod1', 0),
('prod2', 10);


CREATE TABLE `customers` (
  `cid` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `customercode` varchar(100) NOT NULL,
  `fullname` varchar(50) NOT NULL,
  `location` varchar(50) NOT NULL,
  `phone` varchar(50) NOT NULL
) ENGINE=InnoDB;


INSERT INTO `customers` (`cid`, `customercode`, `fullname`, `location`, `phone`) VALUES
(2, 'cus3', 'ram', 'ktm', '331');


CREATE TABLE `products` (
  `pid` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `productcode` varchar(100) NOT NULL,
  `productname` varchar(50) NOT NULL,
  `costprice` double NOT NULL,
  `sellingprice` double NOT NULL,
  `brand` varchar(50) NOT NULL
) ENGINE=InnoDB;


INSERT INTO `products` (`pid`, `productcode`, `productname`, `costprice`, `sellingprice`, `brand`) VALUES
(73, 'prod3', 'qq', 3, 2, '4d'),
(72, 'prod2', 'pen', 20, 30, 'techno'),
(71, 'prod1', 'wai wai', 400, 450, 'cg'),
(74, 'prod4', 'wai wai', 400, 450, 'cg2'),
(78, 'prod5', 'Mobile', 500, 700, 'cg');

CREATE TABLE `purchaseinfo` (
  `purchaseid` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `suppliercode` varchar(200) NOT NULL,
  `productcode` varchar(200) NOT NULL,
  `date` varchar(200) NOT NULL,
  `quantity` int(11) NOT NULL,
  `totalcost` double NOT NULL
) ENGINE=InnoDB;
INSERT INTO `purchaseinfo` (`purchaseid`, `suppliercode`, `productcode`, `date`, `quantity`, `totalcost`) VALUES
(19, 's1', 'p2', 'Wed Jan 14 00:15:19 NPT 2015', 40, 1320),
(20, 's1', 'p1', 'Wed Jan 07 16:42:44 NPT 2015', 4, 80000),
(21, 's6', 'p10', 'Tue Jan 06 16:51:44 NPT 2015', 20, 400000),
(22, 'sup4', 'prod1', 'Thu Jan 15 15:25:45 NPT 2015', 4, 1600),
(23, 'sup5', 'prod1', 'Thu Jan 15 00:00:00 NPT 2015', 6, 2400),
(29, 'sup4', 'prod2', 'Fri Jan 16 23:09:17 NPT 2015', 5, 150);

CREATE TABLE `salesreport` (
  `salesid` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `date` varchar(40) NOT NULL,
  `productcode` varchar(100) NOT NULL,
  `customercode` varchar(100) NOT NULL,
  `quantity` int(11) NOT NULL,
  `revenue` double NOT NULL,
  `soldby` varchar(50) NOT NULL
) ENGINE=InnoDB;

INSERT INTO `salesreport` (`salesid`, `date`, `productcode`, `customercode`, `quantity`, `revenue`, `soldby`) VALUES
(1, 'Fri Jan 16 23:12:40 NPT 2015', 'prod2', 'cus3', 4, 120, 'user4'),
(2, 'Thu Jan 08 21:30:51 NPT 2015', 'prod1', 'cus3', 5, 2250, 'sazanrjb'),
(3, 'Thu Jan 15 21:26:47 NPT 2015', 'prod1', 'cus3', 5, 2250, 'sazanrjb'),
(4, 'Sat Jan 17 10:08:20 NPT 2015', 'prod3', 'cus3', 1, 2, 'user4');


CREATE TABLE `suppliers` (
  `sid` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `suppliercode` varchar(100) NOT NULL,
  `fullname` varchar(50) NOT NULL,
  `location` varchar(50) NOT NULL,
  `phone` varchar(10) NOT NULL
) ENGINE=InnoDB;

INSERT INTO `suppliers` (`sid`, `suppliercode`, `fullname`, `location`, `phone`) VALUES
(69, 'sup5', 'manish', 'ktm', '4123372'),
(68, 'sup4', 'sia', 'US', '11623231');

CREATE TABLE `users` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
  `fullname` varchar(50) DEFAULT NULL,
  `location` varchar(50) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(256) NOT NULL,
  `category` varchar(20) DEFAULT 'ADMINISTRATOR',
  IMAGE varchar(200) DEFAULT NULL
) ENGINE=InnoDB;

INSERT INTO `users` (`id`, `fullname`, `location`, `phone`, `username`, `password`, `category`) VALUES
(54, 'Sajan Rajbhandari', 'Pokhara', '9849284991', 'user4', 'cc03e747a6afbbcbf8be7668acfebee5', 'ADMINISTRATOR'),
(56, 'Ram', 'Kathmandu', '9849284991', 'user5', 'a791842f52a0acfbb3a783378c066b8', 'NORMAL USER'),
(57, 'shyam', 'ktm', '98239832', 'user6', 'affec3b64cf90492377a8114c86fc093', 'NORMAL USER');

