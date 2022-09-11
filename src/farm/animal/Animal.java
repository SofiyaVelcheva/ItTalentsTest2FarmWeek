package farm.animal;

public abstract class Animal {

    private TypeAnimal type;
    private KindAnimal kind;

    public enum TypeAnimal {
        LIVESTOCK,
        DOMESTIC,
        WORKING
    }

    public Animal(TypeAnimal type, KindAnimal kind) {
        this.type = type;
        this.kind = kind;
    }

    public KindAnimal getKind() {
        return kind;
    }

    public TypeAnimal getType() {
        return type;
    }
}
