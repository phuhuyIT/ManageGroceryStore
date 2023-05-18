CREATE FULLTEXT INDEX idx_product_name 
ON products(`productname`);
CREATE FULLTEXT INDEX idx_fullName 
ON customers (fullName);
CREATE FULLTEXT INDEX idx_citizenIDCard 
ON customers (citizenIDNumber);
CREATE FULLTEXT INDEX idx_sfullName 
ON staff (fullName);
CREATE FULLTEXT INDEX idx_scitizenIDCard 
ON staff (staffIDCard);
ALTER TABLE productbatch ADD FULLTEXT INDEX idx_productbatch_sku (productSKU);
CREATE FULLTEXT INDEX idx_name
ON productcategories (name);

-- trigger tự động tính tổng doanh thu của bill sau khi tạo detailbill tương ứng
DELIMITER //
CREATE TRIGGER calculate_revenue
AFTER INSERT ON detailbill
FOR EACH ROW
BEGIN
    DECLARE total_revenue FLOAT(10,1);
    
    -- Tính tổng revenue từ detailbill cho billID mới được thêm vào
    SELECT SUM(currentPrice * quantity) INTO total_revenue
    FROM detailbill
    WHERE billID = NEW.billID;
    
    -- Cập nhật bảng bill với revenue mới tính được
    UPDATE bill
    SET revenue = total_revenue
    WHERE billid = NEW.billID;
END //
DELIMITER ; 
