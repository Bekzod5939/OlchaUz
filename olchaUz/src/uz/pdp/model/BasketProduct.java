package uz.pdp.model;

import java.util.UUID;

public class BasketProduct {
    private UUID basketId;
    private UUID productId;
    private int count;

    public BasketProduct(UUID basketId, UUID productId) {
        this.basketId = basketId;
        this.productId = productId;
        this.count = 1;
    }

    public BasketProduct() {
    }

    public UUID getBasketId() {
        return basketId;
    }

    public void setBasketId(UUID basketId) {
        this.basketId = basketId;
    }

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
