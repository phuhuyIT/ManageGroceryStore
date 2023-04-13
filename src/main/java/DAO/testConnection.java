package DAO;

import Model.Customer;

public class testConnection {
    public static void main(String[] args) {
        CustomerDAO ctdao= new CustomerDAO();
        Customer ct= new Customer(1111,"ABC","Huy Nguyen","Binh Duong", "123456789","09876543","3456712","qwerty@gmail.com","1231");
        ctdao.insert(ct);
    }
}
