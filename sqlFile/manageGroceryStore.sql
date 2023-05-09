DROP DATABASE IF EXISTS managegrocerystore;
CREATE DATABASE MANAGEGROCERYSTORE
CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci ;
USE MANAGEGROCERYSTORE;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+07:00";



CREATE TABLE `customers` (
  `cid` int(11) PRIMARY KEY AUTO_INCREMENT,
  `citizenIDNumber` varchar(100) NOT NULL,
  gender TINYINT(1) DEFAULT 0,
  `fullname` varchar(50) NOT NULL,
  `location` varchar(255) NOT NULL,
  birthDate DATE DEFAULT '1999-01-01',
  `phone` varchar(50) NOT NULL,
  EMAIL varchar(100) DEFAULT NULL,
  avatarLink varchar(100) DEFAULT NULL
) ENGINE=InnoDB;


INSERT INTO `customers` (`citizenIDNumber`, `fullname`, `location`, `phone`) VALUES
('cus1', 'ram1', 'ktm', '331'),
('cus2', 'ram2', 'ktm', '331'),
('cus3', 'ram3', 'ktm', '331'),
('cus4', 'ram4', 'ktm', '331'),
('cus5', 'ram5', 'ktm', '331'),
('cus6', 'ram6', 'ktm', '331');
INSERT INTO `customers` (`citizenIDNumber`, `fullname`, `location`, `phone`) VALUES
('cus7', 'abc', 'ktm', '331'),
('cus8', 'ropd', 'ktm', '3111'),
('cus9', 'emcs', 'ktm', '3221');

CREATE TABLE `suppliers` (
  `sid` int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `suppliercode` varchar(100) NOT NULL,
  `fullname` varchar(50) NOT NULL,
  `location` varchar(255) NOT NULL,
  `phone` varchar(15) NOT NULL
) ENGINE=InnoDB;

INSERT INTO `suppliers` (`sid`, `suppliercode`, `fullname`, `location`, `phone`) VALUES
(1, 'sup5', 'manish', 'ktm', '4123372'),
(2, 'sup4', 'sia', 'US', '11623231');

CREATE TABLE product_categories (
    categoryid INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    parent_id INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (parent_id) REFERENCES product_categories(categoryid) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO product_categories (name,parent_id) VALUES
('Thực phẩm', NULL),
('Thực phẩm tươi sống', 1),
('Thực phẩm chế biến sẵn', 1),
('Hàng gia dụng',NULL),
('Đồ dùng cá nhân',NULL),
('Vật dụng học tập và văn phòng phẩm',NULL),
('Hóa phẩm và chất tẩy rửa',NULL),
('Đồ chơi và quà tặng',NULL),
('Thuốc và vật dụng y tế',NULL),
('Hoa quả', 2),
('Rau củ', 2),
('Thực phẩm đóng hộp', 3),
('Thực phẩm đóng túi', 3);

CREATE TABLE `products` (
	`pid` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `productBarCode` varchar(100) NOT NULL,
  `productname` varchar(50) NOT NULL,
  `costprice` double NOT NULL,
  `sellingprice` double NOT NULL,
  sid INT,
  categoryid INT DEFAULT NULL,
  productSKU varchar(100) DEFAULT NULL,
  thumbnail varchar(200) DEFAULT NULL,
  CONSTRAINT `fk_products_category` FOREIGN KEY (`categoryid`) REFERENCES `product_categories`(`categoryid`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_products_suppliers` FOREIGN KEY (sid) REFERENCES `suppliers`(`sid`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB;
SELECT COUNT(pid) as numberProduct FROM products;

INSERT INTO `products` (`productbarcode`, `productname`, `costprice`, `sellingprice`, `SID`) VALUES
('prod6', 'qq', 3, 2, 1),
('prod7', 'pen', 20, 30, 2),
('prod8', 'wai wai', 400, 450, 1),
('prod9', 'wai wai', 400, 450, 1),
('prod10', 'Mobile', 500, 700, 2),
('prod11', 'qq', 3, 2, 2),
('prod12', 'pen', 20, 30, 1),
('prod13', 'wai wai', 400, 450, 1),
('prod14', 'wai wai', 400, 450, 2),
('prod15', 'Mobile', 500, 700, 1);
INSERT INTO `products` (`productbarcode`, `productname`, `costprice`, `sellingprice`, `SID`) VALUES
('prod16', 'qq', 3, 2, 1);
SELECT LAST_INSERT_ID();
CREATE TABLE PRODUCTBATCH(
	BATCHID	int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	`pid`  int(11),
    importDate DATETIME DEFAULT CURRENT_TIMESTAMP,
    manufractureDate DATE NOT NULL,
    expirationDate DATE NOT NULL,
    quantity INT DEFAULT 11,
    FOREIGN KEY (pid) REFERENCES products(pid)
) ENGINE=InnoDB;
INSERT INTO PRODUCTBATCH (pid, manufractureDate, expirationDate, quantity)
VALUES ('1', '2022-01-01', '2022-12-31', 100),
('2', '2022-01-15', '2023-01-14', 50),
('3','2022-02-01', '2023-01-31', 80),
('4', '2022-02-15', '2023-02-14', 60),
('5', '2022-03-01', '2023-02-28', 120),
('6', '2022-01-01', '2022-12-31', 100),
('7', '2022-01-15', '2023-01-14', 50),
('8','2022-02-01', '2023-01-31', 80),
('1', '2022-02-15', '2023-02-14', 60),
('1', '2022-03-01', '2023-02-28', 120);


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

INSERT INTO `users` (`id`, `fullname`, `location`, `phone`, `username`, `password`, `category`) VALUES
(100, 'Sajan Rajbhandari', 'Pokhara', '9849284991', 'user4', 'cc03e747a6afbbcbf8be7668acfebee5', 'ADMINISTRATOR'),
(101, 'Ram', 'Kathmandu', '9849284991', 'user5', 'a791842f52a0acfbb3a783378c066b8', 'NORMAL USER'),
(102, 'shyam', 'ktm', '98239832', 'user6', 'affec3b64cf90492377a8114c86fc093', 'NORMAL USER');
SELECT LAST_INSERT_ID();

CREATE TABLE staff (
    id INT(11) NOT NULL AUTO_INCREMENT,
    fullname VARCHAR(50) NOT NULL,
    staffIDCard VARCHAR(20) NOT NULL,
    position VARCHAR(50),
    phone VARCHAR(20),
    email VARCHAR(50) DEFAULT NULL,
    joinDate DATETIME DEFAULT NOW(),
    location VARCHAR(255) DEFAULT NULL,
    basicSalary FLOAT CHECK (basicSalary >= 22500),
    avatarLink VARCHAR(150) DEFAULT NULL,
    gender TINYINT DEFAULT 0,
    BIRTHDATE DATE DEFAULT '1990-01-01',
    PRIMARY KEY (id)
);
DELIMITER //
CREATE TRIGGER delete_monthly_salary
BEFORE DELETE ON staff
FOR EACH ROW
BEGIN
    DELETE FROM monthly_salary WHERE staff_id = OLD.id;
END //
DELIMITER ;

INSERT INTO staff (fullname, staffIDCard, position, phone, joinDate, basicSalary)
VALUES
('Nguyễn Văn A', 'NV001', 'Nhân viên bán hàng', '0901234567', '2022-01-01', 150000),
('Trần Thị B', 'NV002', 'Quản lý cửa hàng', '0902345678', '2021-07-01', 200000),
('Lê Văn C', 'NV003', 'Nhân viên bán hàng', '0903456789', '2021-10-01', 120000),
('Phạm Thị D', 'NV004', 'Nhân viên vệ sinh', '0904567890', '2022-02-01', 90000),
('Trần Văn E', 'NV005', 'Nhân viên bán hàng', '0905678901', '2022-03-01', 140000),
('Nguyễn Thị F', 'NV006', 'Nhân viên vệ sinh', '0906789012', '2021-08-01', 90000),
('Lê Văn G', 'NV007', 'Nhân viên bảo vệ', '0907890123', '2021-12-01', 100000),
('Phạm Văn H', 'NV008', 'Nhân viên bán hàng', '0908901234', '2021-09-01', 130000),
('Nguyễn Thị I', 'NV009', 'Nhân viên bán hàng', '0909012345', '2022-04-01', 160000),
('Trần Văn K', 'NV010', 'Nhân viên vệ sinh', '0900123456', '2021-06-01', 80000),
('Lê Thị L', 'NV011', 'Nhân viên bảo vệ', '0901234567', '2021-11-01', 110000),
('Phạm Văn M', 'NV012', 'Nhân viên bán hàng', '0902345678', '2022-05-01', 170000);
CREATE TABLE monthly_salary (
    id INT(11) NOT NULL AUTO_INCREMENT,
    staffid INT(11) NOT NULL,
    monthSalary DATE NOT NULL,
    workingHours INT(11) NOT NULL,
    overtimeHours INT(11) NOT NULL,
    allowance FLOAT NOT NULL,
    deduction FLOAT NOT NULL,
    salary FLOAT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (staffid) REFERENCES staff(id) ON DELETE CASCADE
);
DELIMITER //
CREATE TRIGGER calculate_salary
BEFORE INSERT ON monthly_salary
FOR EACH ROW
BEGIN
  DECLARE _basicSalary FLOAT;
  DECLARE _totalSalary FLOAT;

  -- Lấy giá trị basicSalary từ bảng staff
  SELECT basicSalary INTO _basicSalary FROM staff WHERE id = NEW.staffid;

  -- Tính toán lương từ các thông tin trong bảng monthly_salary và bảng staff
  SET _totalSalary = (_basicSalary * NEW.workingHours)
                     + (_basicSalary * NEW.overtimeHours * 1.5)
                     + NEW.allowance
                     - NEW.deduction;

  -- Gán giá trị tính toán vào cột salary của bản ghi đó
  SET NEW.salary = _totalSalary;
END //
DELIMITER ;

INSERT INTO monthly_salary (staffid, monthSalary, workingHours, overtimeHours, allowance, deduction)
VALUES (1, '2022-01-01', 176, 8, 1000000, 500000),
       (2, '2022-01-01', 150, 6, 800000, 200000),
       (3, '2022-01-01', 120, 5, 500000, 100000);

CREATE TABLE bill (
  billid INT(11) NOT NULL AUTO_INCREMENT,
  billCode VARCHAR(50) NOT NULL,
  purchaseDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  revenue FLOAT(10,1) DEFAULT 0,
  PRIMARY KEY (billID)
)ENGINE=InnoDB;
INSERT INTO bill (billCode, purchaseDate)
VALUES
  ('1', '2023-05-01'),
  ('2', '2023-05-02'),
  ('3', '2023-05-03'),
  ('4', '2023-05-04'),
  ('5', '2023-05-05');
  INSERT INTO bill (billCode)
VALUES
  ('6'),
  ('7');
-- tạo event để xóa bill sau 30 ngày
SET GLOBAL event_scheduler = ON;
CREATE EVENT delete_old_bills
ON SCHEDULE
EVERY 1 DAY
STARTS '2023-05-09 03:00:00'
DO
DELETE FROM bill WHERE purchaseDate < DATE_SUB(NOW(), INTERVAL 30 DAY);
SHOW EVENTS;


CREATE TABLE detailBill (
  id INT(11) NOT NULL AUTO_INCREMENT,
  billID INT(11),
  productID INT(11),
  customerID INT(11),
  staffID INT(11),
  quantity INT(11),
  PRIMARY KEY (id),
  FOREIGN KEY (billID) REFERENCES BILL(billID),
  FOREIGN KEY (PRODUCTID) REFERENCES PRODUCTS(PID),
  FOREIGN KEY (CUSTOMERID) REFERENCES CUSTOMERS(CID),
  FOREIGN KEY (STAFFID) REFERENCES STAFF(ID)
)ENGINE=InnoDB;
-- trigger xóa detailBill khi 1 bill bị xóa
DELIMITER //
CREATE TRIGGER delete_detailBill
BEFORE DELETE ON bill
FOR EACH ROW
BEGIN
    DELETE FROM detailBill WHERE billID = OLD.billID;
END //
DELIMITER ;
-- trigger tự động tính tổng doanh thu của bill sau khi tạo detailbill tương
DELIMITER $$
CREATE TRIGGER calculate_revenue
AFTER INSERT ON detailBill
FOR EACH ROW
BEGIN
    UPDATE bill SET revenue = (SELECT SUM(sellingPrice * quantity)
                               FROM products JOIN detailBill ON products.PID = detailBill.productID
                               WHERE detailBill.billID = bill.billID)
    WHERE bill.billID = NEW.billID;
END $$
DELIMITER ;
-- Thêm dữ liệu cho bảng detailBill
INSERT INTO detailBill(billID, productID, customerID, staffID, quantity) VALUES
('1', 2, '1', 1, 5),
('1', 3, '1', 1, 2),
('2', 1, '2', 2, 3),
('3', 4, '3', 3, 1),
('4', 2, '4', 4, 4),
('4', 3, '4', 4, 2),
('5', 5, '5', 5, 2);

-- test query
SELECT DATE_FORMAT(purchaseDate, '%Y-%m') AS month, SUM(revenue) AS total_revenue
FROM bill
GROUP BY month;
SELECT YEAR(purchaseDate) AS year, SUM(revenue) AS total_revenue
FROM bill
GROUP BY year;
DROP PROCEDURE IF EXISTS getTopStaffRevenue;

DELIMITER //
CREATE PROCEDURE getTop5StaffRevenues()
BEGIN
  SELECT STAFF.fullname, SUM(bill.revenue) as total_revenue
  FROM detailBill
  JOIN bill ON detailBill.billID = bill.billID
  JOIN STAFF ON detailBill.staffID = STAFF.ID
  WHERE MONTH(bill.purchaseDate) = MONTH(CURDATE()) AND YEAR(bill.purchaseDate) = YEAR(CURDATE())
  GROUP BY detailBill.staffID
  ORDER BY total_revenue DESC
  LIMIT 5;
END//
DELIMITER ;
CALL getTop5StaffRevenues();

DELIMITER //
CREATE PROCEDURE top5CustomersRevenues()
BEGIN
  SELECT CUSTOMERS.FULLNAME, SUM(bill.revenue) AS revenue
  FROM detailBill
  JOIN CUSTOMERS ON CUSTOMERS.CID = detailBill.customerID
  JOIN bill ON bill.billID = detailBill.billID
  WHERE MONTH(bill.purchaseDate) = MONTH(CURDATE()) AND YEAR(bill.purchaseDate) = YEAR(CURDATE())
  GROUP BY detailBill.customerID
  ORDER BY revenue DESC
  LIMIT 5;
END//
DELIMITER ;
CALL top5CustomersRevenues();

CREATE VIEW detailBillView AS
SELECT b.billCode, b.purchaseDate, c.cid as customerID, s.ID as staffID, p.pID as productID, db.quantity, b.revenue
FROM detailBill db
INNER JOIN bill b ON db.billID = b.billID
INNER JOIN customers c ON db.customerID = c.CID
INNER JOIN staff s ON db.staffID = s.ID
INNER JOIN products p ON db.productID = p.PID;


