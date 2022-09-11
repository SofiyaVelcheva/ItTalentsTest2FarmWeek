package farm.farmer;

import farm.Farm;
import farm.animal.Animal;
import farm.animal.KindAnimal;
import farm.animal.WorkingAnimal;
import village.order.Buy;
import village.order.Order;
import village.order.Pet;
import village.order.Plough;

import java.util.List;
import java.util.Map;

public abstract class Farmer {

    private String name;
    private String tea;
    private int moneyFarmer = 0;
    private Order order = null;

    public Farmer(String name, String tea) {
        this.name = name;
        this.tea = tea;
    }

    public void drinkTea() {
        System.out.println("Good morning. Farmer " + this.name + " drinks " + this.tea+" tea.");
    }

    public void takeOrder(Order o) {
        order = o;
    }

    public abstract void caretaker();

    public void pickOrders() {
        Farm farm = Farm.getFarm();
        if (!farm.getOrders().isEmpty()) {
            Order order = farm.getOrders().pop();
            this.takeOrder(order);
        }
    }

    public void executeOrders() {
        Farm farm = Farm.getFarm();
        Map<Buy.BuyType, Integer> prod = farm.getProduction();

        switch (this.order.getServiceType()) {
            case BUY:
                buyCase(farm, prod);
                break;
            case PET:
                petCase(farm);
                break;
            case PLOUGH:
                ploughCase(farm);
                break;
        }
        this.order = null;
    }

    private void ploughCase(Farm farm) {
        Map<KindAnimal, List<Animal>> allWorkingAnimal = farm.getAnimals()
                .get(Animal.TypeAnimal.WORKING);

        boolean hasAnimal = false;

        for (List<Animal> allAnimals : allWorkingAnimal.values()) {
            for (Animal animal : allAnimals) {
                if (!((WorkingAnimal) animal).isTired()) {
                    hasAnimal = true;
                    farm.setCounterPlug(this.order.getQuantity());
                    ((WorkingAnimal) animal).setTired(true);
                    farm.addMoneyFarm(((Plough) order).getOrderPrice());
                    this.setMoneyFarmer(((Plough) order).getOrderPrice());
                }
            }
        }

        if (!hasAnimal) {
            farm.addOrder(this.order);
        } else {
            farm.setCounterDeal();
        }
    }

    private void buyCase(Farm farm, Map<Buy.BuyType, Integer> prod) {
        boolean hasDeal = false;

        switch (((Buy) order).getBuyType()) {
            case MILK:
                if (this.order.getQuantity() <= prod.get(Buy.BuyType.MILK)) {
                    prod.put(Buy.BuyType.MILK, prod.get(Buy.BuyType.MILK) - this.order.getQuantity());
                    farm.addMoneyFarm(((Buy) order).getOrderPrice());
                    this.setMoneyFarmer(((Buy) order).getOrderPrice());
                    hasDeal = true;
                }
                break;
            case WAVE:
                if (this.order.getQuantity() <= prod.get(Buy.BuyType.WAVE)) {
                    prod.put(Buy.BuyType.WAVE, prod.get(Buy.BuyType.WAVE) - this.order.getQuantity());
                    farm.addMoneyFarm(((Buy) order).getOrderPrice());
                    this.setMoneyFarmer(((Buy) order).getOrderPrice());
                    hasDeal = true;
                }
                break;
        }

        if (!hasDeal) {
            farm.addOrder(this.order);
        } else {
            farm.setCounterDeal();
        }
    }

    private void petCase(Farm farm) {
        farm.addMoneyFarm(((Pet) order).getOrderPrice());
        this.setMoneyFarmer(((Pet) order).getOrderPrice());
        farm.setCounterDeal();
    }

    public int getMoneyFarmer() {
        return moneyFarmer;
    }

    public void setMoneyFarmer(int moneyFarmer) {
        this.moneyFarmer = this.moneyFarmer + moneyFarmer;
    }

    @Override
    public String toString() {
        return "Farmer " + getClass().getSimpleName()
                + " with name: " + this.name
                + ". Earn " + this.moneyFarmer;
    }

    public String getName() {
        return name;
    }
}


