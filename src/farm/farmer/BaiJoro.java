package farm.farmer;

import farm.Farm;
import farm.animal.Animal;
import farm.animal.KindAnimal;
import farm.animal.livestock.Cow;
import farm.animal.livestock.LiveStock;
import farm.animal.livestock.Sheep;
import village.order.Buy;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class BaiJoro extends Farmer {
    public BaiJoro(String name, String tea) {
        super(name, tea);
    }

    @Override
    public void caretaker() {
        System.out.println(this.getName() + " feed animals, milk animals and shear sheep.");
        this.getAnimalToEat();
        this.getMilkOrWave();
    }

    private void getMilkOrWave() {
        Farm farm = Farm.getFarm();

        Map<KindAnimal, List<Animal>> allLiveStockAnimal = farm.getAnimals()
                .get(Animal.TypeAnimal.LIVESTOCK);

        for (List<Animal> animals : allLiveStockAnimal.values()) {
            for (Animal animal : animals) {
                if (!((LiveStock) animal).isHungry() &&
                        animal.getKind().equals(LiveStock.KindLiveStock.COW)) {
                    farm.addProduction(Buy.BuyType.MILK, 5);
                    farm.setCounterMilkLiter(5);
                } else if (animal.getKind().equals(LiveStock.KindLiveStock.SHEEP)) {
                    if (!((LiveStock) animal).isHungry()) {
                        farm.addProduction(Buy.BuyType.MILK, 2);
                        farm.setCounterMilkLiter(2);
                    }

                    int chance = new Random().nextInt(100);

                    if (chance < 2 && !((Sheep) animal).isShear()) {
                        farm.addProduction(Buy.BuyType.WAVE, 20);
                        ((Sheep) animal).setShear(true);
                    }
                }

            }
        }

    }

    private void getAnimalToEat() {
        Farm farm = Farm.getFarm();

        Map<KindAnimal, List<Animal>> allLiveStockAnimal = farm.getAnimals()
                .get(Animal.TypeAnimal.LIVESTOCK);

        for (List<Animal> animals : allLiveStockAnimal.values()) {
            for (Animal animal : animals) {
                int chance = new Random().nextInt(100);
                if (chance < 90) {
                    ((LiveStock) animal).setHungry(false);
                }
            }
        }


    }
}
