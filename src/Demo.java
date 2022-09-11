
import farm.Farm;
import farm.animal.DomesticAnimal;
import farm.animal.WorkingAnimal;
import farm.animal.livestock.Cow;
import farm.animal.livestock.Sheep;
import farm.farmer.BaiJoro;
import farm.farmer.ChochoKiro;
import farm.farmer.Farmer;
import farm.farmer.KakaMilka;
import village.People;
import village.order.Buy;
import village.order.Order;
import village.order.Pet;
import village.order.Plough;

import java.util.Random;


public class Demo {
    public static Random r;
    public static final int ALL_ORDERS = 10;

    public static void main(String[] args) {

        r = new Random();

        Farm.getInstanceFarm("El Craso");
        Farm farm = Farm.getFarm();

        for (int i = 0; i < 2; i++) {
            farm.addAnimal(new DomesticAnimal(DomesticAnimal.KindDomesticAnimal.CAT, "Cat name:" + (i + 1), "Random Breed"));
            farm.addAnimal(new DomesticAnimal(DomesticAnimal.KindDomesticAnimal.DOG, "Dog name:" + (i + 1), "Random Breed"));
        }

        for (int j = 0; j < 3; j++) {
            farm.addAnimal(new WorkingAnimal(WorkingAnimal.KindWorkingAnimal.HORSE));
            farm.addAnimal(new WorkingAnimal(WorkingAnimal.KindWorkingAnimal.OX));
        }

        for (int i = 0; i < 15; i++) {
            farm.addAnimal(new Sheep());
        }

        for (int i = 0; i < 10; i++) {
            farm.addAnimal(new Cow());
        }

        farm.addFarmer(new KakaMilka(getRandomName(), getRandomTea()));
        farm.addFarmer(new ChochoKiro(getRandomName(), getRandomTea()));
        farm.addFarmer(new BaiJoro(getRandomName(), getRandomTea()));

        farm.setCounterOrder(ALL_ORDERS);

        for (int i = 0; i < ALL_ORDERS; i++) {
            People people = new People(getRandomOrder());
            farm.addOrder(people.getOrder());
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < farm.getFarmers().size(); j++) {
                Farmer currentFarmer = farm.getFarmers().get(j);
                currentFarmer.drinkTea();
                currentFarmer.caretaker();

                currentFarmer.pickOrders();
                currentFarmer.executeOrders();
            }
        }

        farm.printStatistics();

    }

    private static Order getRandomOrder() {
        Order order = null;
        int chance = r.nextInt(3);
        switch (chance) {
            case 0:
                Buy.BuyType buyType = new Random().nextBoolean() ? Buy.BuyType.MILK : Buy.BuyType.WAVE;
                order = new Buy(3, buyType);
                break;
            case 1:
                order = new Pet(2);
                break;
            case 2:
                order = new Plough(1);
                break;
        }
        return order;
    }

    private static String getRandomTea() {
        String[] teas = new String[]{"green", "black", "red"};
        return teas[r.nextInt(teas.length)];
    }

    private static String getRandomName() {
        String[] names = new String[]{"Curo", "Rocky", "Bard"};
        return names[r.nextInt(names.length)];
    }


}
