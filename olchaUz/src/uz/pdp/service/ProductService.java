package uz.pdp.service;

import uz.pdp.model.Product;

import java.util.ArrayList;
import java.util.UUID;

public class ProductService {
    private ArrayList<Product> products=new ArrayList<>();

    public ProductService() {
        products.add(new Product("ARTEL LED",400,"UZ",12,4));
        products.add(new Product("NOKIA 5443",60,"HARD",12,8));
        products.add(new Product("MacBook",1050,"M1/8/256",12,11));
        products.add(new Product("Shirt",15,"XL Nice",6,23));
        products.add(new Product("Adventure",10,"100 Pages",6,32));
    }


    public ArrayList<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public double getProductFromId(UUID id,int count){
        for (Product product : products) {
            if(product.getId().equals(id)){
                System.out.println("Name: "+product.getName());
                System.out.println("Price: "+product.getPrice()+" $");
                System.out.println("Warranty: "+product.getWarranty()+" month");
                System.out.println("Description: "+product.getDescription());
                System.out.println("Count: "+count);
                System.out.println("---------------------------------------------------------");
                return product.getPrice();
            }
        }
        return 0;
    }

    public Product getProductById(UUID id){
        for (Product product : products) {
            if(product.getId().equals(id))
                return product;
        }
        return null;
    }
}
