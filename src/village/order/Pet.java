package village.order;

import village.order.Order;

import java.util.Random;

public class Pet extends Order {

    private PetType petType;
    private int quantity;

    public Pet(int quantity) {
        super(ServiceType.PET, quantity);
        this.petType = getRandomType();
    }

    private PetType getRandomType() {
        return new Random().nextBoolean() ? PetType.CAT : PetType.DOG;
    }

    @Override
    public int getOrderPrice() {
        if (this.petType.equals(PetType.DOG)) {
            return this.getQuantity() * 3;
        }
        return this.getQuantity() * 5;
    }


    public enum PetType {
        CAT, DOG
    }

    public PetType getPetType() {
        return petType;
    }
}
