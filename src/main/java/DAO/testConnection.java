package DAO;

import Model.Customer;

import java.util.ArrayList;

public class    testConnection {
    public static void main(String[] args) {
//        ArrayList<Customer>customersList =CustomerDAO.getInstance().selectALL();
//        for (Customer cus: customersList){
//            System.out.println(cus.toString());
//        }
        Customer a= new Customer(1,"abc","cc","cc","cc","cc","cc","cc");
        System.out.println(a.hashCode());
    }
}
