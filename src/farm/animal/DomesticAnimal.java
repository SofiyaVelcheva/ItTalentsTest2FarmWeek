package farm.animal;

public class DomesticAnimal extends Animal {
    // домашни животни

    private String name;
    private String breed;

    public enum KindDomesticAnimal implements KindAnimal {
        CAT, DOG
    }

    public DomesticAnimal(KindAnimal kind, String name, String breed) {
        super(TypeAnimal.DOMESTIC, kind);
        this.name = name;
        this.breed = breed;
    }

    public void petAnimal() {
        System.out.println("You pet " + getKind() + "with name: " + this.name);
    }
}
