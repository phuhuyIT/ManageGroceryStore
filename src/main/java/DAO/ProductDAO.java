package DAO;

import Model.Product;

import java.util.ArrayList;

public class ProductDAO implements DaoInterface<Product> {

    public static ProductDAO getInstance(){
        return new ProductDAO();
    }

    @Override
    public void insert(Product product) {

    }

    @Override
    public int delete(Product product) {
        return 0;
    }

    @Override
    public int update(Product product) {
        return 0;
    }

    @Override
    public ArrayList<Product> selectALL(Product product) {
        return null;
    }

    @Override
    public Product selectByID(Product product) {
        return null;
    }

    @Override
    public int addFunction(Product product) {
        return 0;
    }
}
