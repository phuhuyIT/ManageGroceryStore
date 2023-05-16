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

DELIMITER //
CREATE PROCEDURE getTopProducts()
BEGIN
  SELECT p.productName,SUM(d.quantity * p.sellingPrice) AS revenue, SUM(d.quantity) AS totalSold
  FROM detailBill d
  JOIN products p ON d.productID = p.PID
  JOIN BILL b ON d.billID = b.billID
  WHERE MONTH(b.purchaseDate) = MONTH(CURDATE()) AND YEAR(b.purchaseDate) = YEAR(CURDATE())
  GROUP BY p.productName
  ORDER BY revenue DESC
  LIMIT 5;
END //
DELIMITER ;
// thêm data cho bảng products
DELIMITER //
CREATE PROCEDURE insert_products()
BEGIN
  DECLARE i INT DEFAULT 1;
  DECLARE product_name VARCHAR(50);
  DECLARE category_id INT;
  DECLARE cost_price FLOAT;
  DECLARE selling_price FLOAT;
  DECLARE product_sku VARCHAR(100);
DECLARE supplierID INT;
  WHILE i <= 10000 DO
    SET product_name = CONCAT('Product ', i);
    SET category_id = FLOOR((i - 1) / 9) + 1;
    SET cost_price = i * 1000;
    SET selling_price = i * 1500;
    SET product_sku = CONCAT('SKU', i);
    SET supplierID = FLOOR((i - 1) / 39) + 1;
    INSERT INTO products (productname, sid, categoryid, costPrice, sellingPrice, productSKU)
    VALUES (product_name, supplierID, category_id, cost_price, selling_price, product_sku);
    
    SET i = i + 1;
  END WHILE;
END //
DELIMITER ;

CALL insert_products();
-- 
DELIMITER //
CREATE FUNCTION insert_productbatch_data(num_rows INT)
RETURNS INT
DETERMINISTIC
BEGIN
  DECLARE i INT DEFAULT 1;
DECLARE import_Date INT;
DECLARE manufacture_Date INT;
DECLARE expiration_Date INT;
DECLARE quantity_Add INT;
DECLARE pidVal INT;
  WHILE i <= num_rows DO
    SET import_Date = CURRENT_TIMESTAMP();
    SET manufacture_Date = DATE_ADD(CURRENT_DATE(), INTERVAL -(i % 30) DAY);
    SET expiration_Date = DATE_ADD( manufacture_Date, INTERVAL FLOOR(RAND() * 365) DAY);
    SET quantity_Add = FLOOR(RAND() * 100) + 1;
	SET pidVal = FLOOR(RAND() * (79-26)) + 26;
    INSERT INTO productbatch (pid, importDate, manufractureDate, expirationDate, quantity)
    VALUES (pidVal, import_Date, expiration_Date, expiration_Date, quantity_Add);
  END WHILE;
  RETURN i - 1;
END //
DELIMITER ;
SELECT insert_productbatch_data(50);
SET SESSION wait_timeout = 360000;
SET SESSION interactive_timeout = 360000;

DELIMITER //
CREATE PROCEDURE insert_productBatch()
BEGIN
  DECLARE i INT DEFAULT 1;
DECLARE manufacture_Date date;
DECLARE expiration_Date date;
DECLARE quantity_Add INT;
DECLARE pidVal INT;
  WHILE i <= 5 DO
    SET manufacture_Date = DATE_ADD('2022-01-01', INTERVAL FLOOR(RAND() * 365) DAY);
    SET expiration_Date = DATE_ADD('2023-01-01', INTERVAL FLOOR(RAND() * 365 *2) DAY);
    SET quantity_Add = FLOOR(RAND() * 100) + 1;
	SET pidVal = FLOOR(RAND() * (79-26)) + 26;
    INSERT INTO productbatch (pid,  manufractureDate, expirationDate, quantity)
    VALUES (pidVal, manufacture_Date, expiration_Date, quantity_Add);
  END WHILE;
END //
DELIMITER ;
CALL insert_productBatch();

