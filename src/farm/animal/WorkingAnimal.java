package farm.animal;

import farm.animal.Animal;
import farm.animal.KindAnimal;

public class WorkingAnimal extends Animal {

    private boolean isTired;

    public WorkingAnimal(KindAnimal kind) {
        super(TypeAnimal.WORKING, kind);
        this.isTired = true;
    }

    public enum KindWorkingAnimal implements KindAnimal {
        HORSE, OX
    }

    public boolean isTired() {
        return isTired;
    }

    public void setTired(boolean tired) {
        isTired = tired;
    }
}
