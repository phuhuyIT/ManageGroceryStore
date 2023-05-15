CREATE FULLTEXT INDEX idx_product_name 
ON products(`productname`);
CREATE FULLTEXT INDEX idx_product_SKU 
ON products(`productSKU`);

-- trigger xóa lịch sử lương của nhân viên khi người đó cúcs
DELIMITER //
CREATE TRIGGER delete_monthly_salary 
BEFORE DELETE ON staff
FOR EACH ROW
BEGIN
    DELETE FROM monthly_salary WHERE staff_id = OLD.id;
END //
DELIMITER ;



-- trigger xóa detailBill khi 1 bill bị xóa
DELIMITER //
CREATE TRIGGER delete_detailBill
BEFORE DELETE ON bill
FOR EACH ROW
BEGIN
    DELETE FROM detailBill WHERE billID = OLD.billID;
END //
DELIMITER ;

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
