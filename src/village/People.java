package village;

import village.order.Order;

public class People {
    private Order order;

    public People(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }
}
