package uz.pdp.model;

import uz.pdp.model.base.BaseModel;


public class Product extends BaseModel {
    private String name;
    private double price;
    private String description;
    private int warranty;
    private int categoryId;

    public Product(String name, double price, String description, int warranty, int categoryId) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.warranty = warranty;
        this.categoryId = categoryId;
    }

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getWarranty() {
        return warranty;
    }

    public void setWarranty(int warranty) {
        this.warranty = warranty;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
