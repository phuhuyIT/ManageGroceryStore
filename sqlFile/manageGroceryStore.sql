DROP DATABASE IF EXISTS managegrocerystore;
CREATE DATABASE MANAGEGROCERYSTORE
CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci ;
USE MANAGEGROCERYSTORE;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+07:00";



CREATE TABLE `customers` (
  `cid` int(11) PRIMARY KEY AUTO_INCREMENT,
  `customercode` varchar(100) NOT NULL,
  gender TINYINT(1) DEFAULT 0,
  `fullname` varchar(50) NOT NULL,
  `location` varchar(50) NOT NULL,
  `phone` varchar(50) NOT NULL,
  EMAIL varchar(100) DEFAULT NULL,
  avatarLink varchar(100) DEFAULT NULL
) ENGINE=InnoDB;


INSERT INTO `customers` (`customercode`, `fullname`, `location`, `phone`) VALUES
('cus1', 'ram1', 'ktm', '331'),
('cus2', 'ram2', 'ktm', '331'),
('cus3', 'ram3', 'ktm', '331'),
('cus4', 'ram4', 'ktm', '331'),
('cus5', 'ram5', 'ktm', '331'),
('cus6', 'ram6', 'ktm', '331');


CREATE TABLE `products` (
	`pid` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `productBarCode` varchar(100) NOT NULL,
  `productname` varchar(50) NOT NULL,
  `costprice` double NOT NULL,
  `sellingprice` double NOT NULL,
  sid INT DEFAULT NULL,
  categoryid INT DEFAULT NULL,
  productSKU varchar(100) DEFAULT NULL,
  thumbnail varchar(200) DEFAULT NULL
) ENGINE=InnoDB;


INSERT INTO `products` (`productbarcode`, `productname`, `costprice`, `sellingprice`, `SID`) VALUES
('prod6', 'qq', 3, 2, '1212'),
('prod7', 'pen', 20, 30, '1231'),
('prod8', 'wai wai', 400, 450, '312'),
('prod9', 'wai wai', 400, 450, '423'),
('prod10', 'Mobile', 500, 700, '634'),
('prod11', 'qq', 3, 2, '1121'),
('prod12', 'pen', 20, 30, '1212'),
('prod13', 'wai wai', 400, 450, '1121'),
('prod14', 'wai wai', 400, 450, '634'),
('prod15', 'Mobile', 500, 700, '123');
INSERT INTO `products` (`productbarcode`, `productname`, `costprice`, `sellingprice`, `SID`) VALUES
('prod16', 'qq', 3, 2, '1212');
SELECT LAST_INSERT_ID();
CREATE TABLE PRODUCTBATCH(
	BATCHID	int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	`pid`  int(11),
    importDate DATETIME DEFAULT CURRENT_TIMESTAMP,
    manufactureDate DATE NOT NULL,
    expirationDate DATE NOT NULL,
    quantity INT DEFAULT 11,
    FOREIGN KEY (pid) REFERENCES products(pid)
) ENGINE=InnoDB;
INSERT INTO PRODUCTBATCH (pid, manufactureDate, expirationDate, quantity)
VALUES ('6', '2022-01-01', '2022-12-31', 100),
('7', '2022-01-15', '2023-01-14', 50),
('1','2022-02-01', '2023-01-31', 80),
('1', '2022-02-15', '2023-02-14', 60),
('2', '2022-03-01', '2023-02-28', 120);

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
  `location` varchar(255) NOT NULL,
  `phone` varchar(15) NOT NULL
) ENGINE=InnoDB;

INSERT INTO `suppliers` (`sid`, `suppliercode`, `fullname`, `location`, `phone`) VALUES
(69, 'sup5', 'manish', 'ktm', '4123372'),
(68, 'sup4', 'sia', 'US', '11623231');

CREATE TABLE `users` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
  `fullname` varchar(50) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(256) NOT NULL,
  `category` varchar(20) DEFAULT 'ADMINISTRATOR',
  IMAGE varchar(200) DEFAULT NULL,
  EMAIL varchar(100) DEFAULT NULL
) ENGINE=InnoDB;

INSERT INTO `users` (`id`, `fullname`, `location`, `phone`, `username`, `password`, `category`) VALUES
(100, 'Sajan Rajbhandari', 'Pokhara', '9849284991', 'user4', 'cc03e747a6afbbcbf8be7668acfebee5', 'ADMINISTRATOR'),
(101, 'Ram', 'Kathmandu', '9849284991', 'user5', 'a791842f52a0acfbb3a783378c066b8', 'NORMAL USER'),
(102, 'shyam', 'ktm', '98239832', 'user6', 'affec3b64cf90492377a8114c86fc093', 'NORMAL USER');
SELECT LAST_INSERT_ID();
CREATE TABLE product_categories (
    categoryid INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    parent_id INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (parent_id) REFERENCES product_categories(categoryid) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO product_categories (name, description, parent_id) VALUES
('Thực phẩm', 'Danh mục thực phẩm', NULL),
('Thực phẩm tươi sống', 'Danh mục thực phẩm tươi sống', 1),
('Hoa quả', 'Danh mục hoa quả', 2),
('Rau củ', 'Danh mục rau củ', 2),
('Thực phẩm chế biến sẵn', 'Danh mục thực phẩm chế biến sẵn', 1),
('Thực phẩm đóng hộp', 'Danh mục thực phẩm đóng hộp', 5),
('Thực phẩm đóng túi', 'Danh mục thực phẩm đóng túi', 5),
('Đồ điện tử', 'Danh mục đồ điện tử', NULL),
('Điện thoại', 'Danh mục điện thoại', 8),
('Máy tính bảng', 'Danh mục máy tính bảng', 8),
('Laptop', 'Danh mục laptop', 8);

-- trigger--
-- DROP TRIGGER update_stock;
-- DELIMITER //

-- CREATE TRIGGER update_stock 
-- AFTER UPDATE ON Products
-- FOR EACH ROW
-- BEGIN
--         UPDATE CurrentStocks
--         SET quantity = quantity + inserted.quantity
--         WHERE productCode = currentstocks.productcode;
-- END//
-- DELIMITER ;

