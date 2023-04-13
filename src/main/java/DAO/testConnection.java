package DAO;

import Model.Customer;

public class testConnection {
    public static void main(String[] args) {
        CustomerDAO ctdao= new CustomerDAO();
        Customer ct= null;
        ctdao.insert(ct);
    }
}
