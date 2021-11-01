package uz.pdp.service;

import uz.pdp.model.Basket;

import java.util.ArrayList;
import java.util.UUID;

public class BasketService {
    ArrayList<Basket> baskets=new ArrayList<>();


    public BasketService(UUID adminId) {
        baskets.add(new Basket(adminId));
    }

    public UUID findByUserId(UUID userId){
        for (Basket basket : baskets) {
            if(basket.getUserId().equals(userId))
                return basket.getId();
        }
        return null;
    }


    public ArrayList<Basket> getBaskets() {
        return baskets;
    }

    public void addBaskets(Basket basket) {
        this.baskets.add(basket);
    }
}
