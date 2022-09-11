package village.order;

import village.order.Order;

public class Plough extends Order {

    public Plough(int quantity) {
        super(ServiceType.PLOUGH, quantity);
    }

    @Override
    public int getOrderPrice() {
        return this.getQuantity() * 60;
    }
}
