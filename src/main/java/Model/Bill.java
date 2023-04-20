package Model;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

public class Bill {
    private int id;
    private String name;
    private BigDecimal amount;
    private Date dueDate;
    private boolean paid;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Bill() {}

    public Bill(String name, BigDecimal amount, Date dueDate) {
        this.name = name;
        this.amount = amount;
        this.dueDate = dueDate;
    }

    // getters and setters for all fields

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}