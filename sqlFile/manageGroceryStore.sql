DROP DATABASE IF EXISTS manageinventorystore;
CREATE DATABASE manageinventorystore
CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci ;
USE manageinventorystore;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+07:00";



CREATE TABLE `customers` (
  `cid` int(11) PRIMARY KEY AUTO_INCREMENT,
  `citizenIDNumber` varchar(100) NOT NULL , -- UNIQUE
  gender TINYINT(1) DEFAULT 0 CHECK (`gender` IN (0, 1)),
  `fullname` varchar(50) NOT NULL,
  `location` varchar(255) NOT NULL,
  birthDate DATE DEFAULT '1999-01-01' ,
  `phone` varchar(50) NOT NULL CHECK (LENGTH(`phone`) >= 10),
  EMAIL varchar(100) DEFAULT NULL  CHECK (`email` IS NULL OR `email` LIKE '%_@__%.__%'), -- UNIQUE
  avatarLink varchar(100) DEFAULT NULL
) ENGINE=InnoDB;

CREATE TABLE `suppliers` (
  `sid` int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `suppliercode` varchar(100) NOT NULL UNIQUE,
  `fullname` varchar(50) NOT NULL,
  `location` varchar(255) NOT NULL,
  `phone` varchar(15) NOT NULL CHECK (LENGTH(`phone`) >= 10)
) ENGINE=InnoDB;




CREATE TABLE productCategories (
    categoryid INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    parent_id INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (parent_id) REFERENCES productCategories(categoryid) ON DELETE CASCADE ON UPDATE CASCADE
);




CREATE TABLE `products` (
	`pid` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `productname` varchar(50) NOT NULL,
  sid INT,
  categoryid INT DEFAULT NULL,
  costPrice FLOAT DEFAULT 0 CHECK (`costPrice` >= 0),
  sellingPrice FLOAT DEFAULT 0 CHECK (`sellingPrice` >= 0),
  thumbnail varchar(200) DEFAULT NULL,
  productBarcode varchar(200) DEFAULT NULL,
  CONSTRAINT `fk_products_category` FOREIGN KEY (`categoryid`) REFERENCES `productCategories`(`categoryid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_products_suppliers` FOREIGN KEY (sid) REFERENCES `suppliers`(`sid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;

CREATE TABLE PRODUCTBATCH(
	productSKU varchar(100) NOT NULL PRIMARY KEY,
	`pid` int(11),
	importDate DATETIME DEFAULT CURRENT_TIMESTAMP,
	manufractureDate DATE NOT NULL,
	expirationDate DATE NOT NULL,
	quantity INT DEFAULT 11,
	CHECK (PRODUCTBATCH.manufractureDate <= PRODUCTBATCH.expirationDate),
	CHECK (PRODUCTBATCH.quantity >= 0),
	FOREIGN KEY (pid) REFERENCES products(pid) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;



CREATE TABLE `users` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
  `fullname` varchar(50) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(256) NOT NULL,
  `category` varchar(20) DEFAULT 'NORMAL USER',
  IMAGE varchar(200) DEFAULT NULL,
  EMAIL varchar(100) DEFAULT NULL
) ENGINE=InnoDB;



CREATE TABLE staff (
    id INT(11) NOT NULL AUTO_INCREMENT,
    fullname VARCHAR(50) NOT NULL,
    staffIDCard VARCHAR(20) NOT NULL,
    position VARCHAR(50),
    phone VARCHAR(20) CHECK (LENGTH(`phone`) >= 10),
    email VARCHAR(50) DEFAULT NULL CHECK (`email` IS NULL OR `email` LIKE '%_@__%.__%'),
    joinDate DATETIME DEFAULT NOW(),
    location VARCHAR(255) DEFAULT NULL,
    basicSalary FLOAT CHECK (basicSalary >= 22500),
    avatarLink VARCHAR(150) DEFAULT NULL,
    gender TINYINT DEFAULT 0 CHECK (`gender` IN (0, 1)),
    BIRTHDATE DATE DEFAULT '1990-01-01' ,
	`username` varchar(20) DEFAULT NULL UNIQUE,
    `password` varchar(256) DEFAULT NULL UNIQUE,
    PRIMARY KEY (id)
);


CREATE TABLE monthly_salary (
    id INT(11) NOT NULL AUTO_INCREMENT,
    staffid INT(11) NOT NULL,
    monthSalary DATE NOT NULL,
    workingHours INT(11) NOT NULL CHECK (workingHours >= 0),
    overtimeHours INT(11) NOT NULL CHECK (overtimeHours >= 0),
    allowance FLOAT NOT NULL CHECK (allowance >= 0),
    deduction FLOAT NOT NULL CHECK (deduction >= 0),
    PRIMARY KEY (id),
    FOREIGN KEY (staffid) REFERENCES staff(id) ON DELETE CASCADE
);



       
CREATE TABLE bill (
  billid INT(11) NOT NULL AUTO_INCREMENT,
  billCode VARCHAR(50) NOT NULL UNIQUE,
customerID INT(11),
  purchaseDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    staffID INT(11),
  revenue FLOAT(10,1) DEFAULT 0,
  PRIMARY KEY (billID),
    FOREIGN KEY (CUSTOMERID) REFERENCES CUSTOMERS(CID),
  FOREIGN KEY (STAFFID) REFERENCES STAFF(ID)
)ENGINE=InnoDB;
-- tạo event để xóa bill sau 30 ngày
SET GLOBAL event_scheduler = ON;
CREATE EVENT delete_old_bills
ON SCHEDULE
EVERY 1 DAY
STARTS '2023-05-17 00:00:00'
DO
DELETE FROM bill WHERE purchaseDate < DATE_SUB(NOW(), INTERVAL 30 DAY);
SHOW EVENTS;



CREATE TABLE detailBill (
  id INT(11) NOT NULL AUTO_INCREMENT,
  billID INT(11),
  productID INT(11),
  currentPrice INT(11),
  quantity INT(11) CHECK( Quantity>0),
  PRIMARY KEY (id),
  FOREIGN KEY (billID) REFERENCES BILL(billID),
  FOREIGN KEY (PRODUCTID) REFERENCES PRODUCTS(PID)
)ENGINE=InnoDB;

create table verify_mail(
	id INT auto_increment primary key,
    mail VARCHAR(100) NOT NULL,
    otp VARCHAR(10) NOT NULL,
	created_at timestamp default current_timestamp
)ENGINE=InnoDB;
-- test query

CALL getTop5StaffRevenues();



CALL top5CustomersRevenues();

--
SELECT 
  p.productName AS Product_Name,
  SUM(d.quantity * p.sellingPrice) AS Revenue,
  SUM(d.quantity) AS Quantity_Sold
FROM 
  detailBill d
  JOIN products p ON d.productID = p.PID
  JOIN bill b ON d.billID = b.billID
WHERE MONTH(b.purchaseDate) = MONTH(CURDATE()) AND YEAR(b.purchaseDate) = YEAR(CURDATE())
GROUP BY 
  Product_Name
ORDER BY 
  Revenue DESC
LIMIT 5;

CALL getTopProducts();

SELECT 
  b.billID, 
  b.billCode, 
  b.revenue, 
  b.staffName,
  b.customerName,
  b.purchaseDate,
  GROUP_CONCAT(DISTINCT CONCAT(productName,'|', quantity,'|',productRevenue ) SEPARATOR ', ') AS productList
FROM billDetails b
GROUP BY b.billID
ORDER BY b.billID ASC;
SELECT THUMBNAIL, PRODUCTNAME, Categoryid, p.Pid, COSTPRICE, SELLINGPRICE, PRODUCTSKU, manufractureDate, expirationDate,SID  FROM products p JOIN productbatch pb On p.pid=pb.pid;  

SELECT pid FROM products WHERE pid BETWEEN 26 AND 80;
SELECT COUNT(*) FROM suppliers;
select fullname, location, phone from suppliers where sid=?;
SELECT suppliercode AS SupplierCode, fullname AS Name, location as Address, phone AS Phone FROM suppliers;
SELECT suppliercode AS SupplierCode, fullname AS Name, location as Address, phone AS Phone FROM suppliers WHERE fullname LIKE searchTxt OR location LIKE searchTxt OR suppliercode LIKE searchTxt OR phone LIKE searchTxt;


SELECT * FROM products p join productcategories pc on p.categoryid=pc.categoryid  WHERE MATCH(pc.name) AGAINST('"Thực phẩm đóng hộp"');
UPDATE productbatch
SET quantity = quantity+110
WHERE productSKU ='100-329-6809';


