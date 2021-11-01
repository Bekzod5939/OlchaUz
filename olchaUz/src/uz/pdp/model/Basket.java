package uz.pdp.model;

import uz.pdp.model.base.BaseModel;

import java.util.UUID;

public class Basket extends BaseModel {
    private UUID userId;

    public Basket(UUID userId) {
        this.userId = userId;
    }

    public Basket() {
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }


}
