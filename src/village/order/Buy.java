package village.order;

import java.util.Random;

public class Buy extends Order {
    private BuyType buyType;

    public Buy( int quantity, BuyType buyType) {
        super(ServiceType.BUY, quantity);
        this.buyType = buyType;
    }



    public int getOrderPrice() {
        if (this.buyType.equals(BuyType.MILK)) {
            return this.getQuantity() * 2;
        }

        return this.getQuantity() * 23;
    }

    public enum BuyType {
        MILK, WAVE
    }

    public BuyType getBuyType() {
        return buyType;
    }
}
