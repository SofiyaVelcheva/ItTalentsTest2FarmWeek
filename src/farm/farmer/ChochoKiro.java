package farm.farmer;

import farm.Farm;
import farm.animal.Animal;
import farm.animal.KindAnimal;
import farm.animal.WorkingAnimal;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class ChochoKiro extends Farmer {
    public ChochoKiro(String name, String tea) {
        super(name, tea);
    }

    @Override
    public void caretaker() {
        System.out.println(this.getName() + " horse brushing and care for ox.");

        Farm farm = Farm.getFarm();

        Map<KindAnimal, List<Animal>> allWorkingAnimal = farm.getAnimals()
                .get(Animal.TypeAnimal.WORKING);

        for (List<Animal> allAnimals : allWorkingAnimal.values()) {
            for (Animal animal : allAnimals) {
                if (((WorkingAnimal) animal).isTired()) {
                    int chance = new Random().nextInt(100);
                    if (chance < 60) {
                        ((WorkingAnimal) animal).setTired(false);
                    }
                }
            }
        }
    }
}

