package farm.animal.livestock;

import farm.animal.Animal;
import farm.animal.KindAnimal;

public abstract class LiveStock extends Animal {
    // Добитък
    private boolean isHungry = true;
    public LiveStock(KindAnimal kind) {
        super(TypeAnimal.LIVESTOCK, kind);
    }

    public enum KindLiveStock implements KindAnimal {
        SHEEP, COW
    }

    public boolean isHungry() {
        return isHungry;
    }

    public void setHungry(boolean hungry) {
        isHungry = hungry;
    }
}
