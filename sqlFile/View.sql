-- tạo view
CREATE VIEW billDetails AS
SELECT b.revenue, b.billid, b.billCode, b.purchaseDate, 
       s.fullname AS staffName, 
       c.fullname AS customerName, 
       p.productName, db.quantity, 
       (db.quantity * db.currentPrice) AS productRevenue
FROM bill b 
JOIN detailBill db ON b.billID = db.billID
JOIN products p ON db.productID = p.PID
JOIN customers c ON db.customerID = c.CID
JOIN staff s ON db.staffID = s.ID;