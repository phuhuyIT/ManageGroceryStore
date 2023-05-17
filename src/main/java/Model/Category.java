package Model;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private int id;
    private String name;
    private String description;
    private ArrayList<Product> productList;
    private int parentId;

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public Category() {
    }
    public Category(int ID, String name, int parentId) {
        this.name=name;
        this.parentId = parentId;
        this.id=ID;
    }
    public Category(int ID, String name, ArrayList<Product> productList, int parentId) {
        this.productList = productList;
        this.name=name;
        this.parentId = parentId;
        this.id=ID;
    }

    public Category(int id, String name, String description, ArrayList<Product> productList) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.productList = productList;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }
}


