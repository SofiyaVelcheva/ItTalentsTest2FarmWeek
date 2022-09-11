package village.order;

public abstract class Order {

    private ServiceType serviceType;
    private int quantity;

    public Order(ServiceType serviceType, int quantity) {
        this.serviceType = serviceType;
        // todo check quantity
        this.quantity = quantity;
    }

    public abstract int getOrderPrice();

    public enum ServiceType {
        BUY,
        PET,
        PLOUGH
    }

    public int getQuantity() {
        return quantity;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }


}
