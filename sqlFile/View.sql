-- tạo view
CREATE VIEW billDetails AS
SELECT b.revenue, b.billid, b.billCode, b.purchaseDate, 
		db.currentPrice,
       s.fullname AS staffName, 
       c.fullname AS customerName, 
       p.productName, db.quantity, 
       (db.quantity * db.currentPrice) AS productRevenue
FROM bill b 
JOIN detailBill db ON b.billID = db.billID
JOIN products p ON db.productID = p.PID
JOIN customers c ON b.customerID = c.CID
JOIN staff s ON b.staffID = s.ID;
SELECT FULLNAME,GENDER,cid,PHONE,AVATARLINK FROM customers WHERE MATCH(fullname) AGAINST ('Nguyen');
--
CREATE VIEW product_view AS
SELECT p.pid, p.productname, p.sid, p.categoryid, p.costPrice, p.sellingPrice, p.thumbnail,
       pb.productSKU, pb.importDate, pb.manufractureDate, pb.expirationDate, pb.quantity
FROM products p
INNER JOIN productbatch pb ON p.pid = pb.pid;
