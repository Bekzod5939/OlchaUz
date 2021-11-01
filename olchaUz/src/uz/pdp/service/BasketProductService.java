package uz.pdp.service;

import uz.pdp.model.BasketProduct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class BasketProductService {
    ArrayList<BasketProduct> basketProducts=new ArrayList<>();

    public ArrayList<BasketProduct> getBasketProducts() {
        return basketProducts;
    }

    public void addBasketProducts(BasketProduct basketProduct) {
        boolean has=false;
        for (int i=0;i<basketProducts.size();i++) {
            if(basketProducts.get(i).getProductId().equals(basketProduct.getProductId())&&
            basketProducts.get(i).getBasketId().equals(basketProduct.getBasketId())){
                basketProducts.get(i).setCount(basketProducts.get(i).getCount()+1);
                has=true;
            }
        }
        if(!has)
        this.basketProducts.add(basketProduct);
    }

    public HashMap<UUID,Integer> getProductsIdFromBasket(UUID basketId){
        HashMap<UUID,Integer> products=new HashMap<>();
        for (BasketProduct basketProduct : basketProducts) {
            if(basketProduct.getBasketId().equals(basketId))
                products.put(basketProduct.getProductId(),basketProduct.getCount());
        }
        return products;
    }
}
