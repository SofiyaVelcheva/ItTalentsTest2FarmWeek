package farm.farmer;

public class KakaMilka extends Farmer {
    public KakaMilka(String name, String tea) {
        super(name, tea);
    }

    @Override
    public void caretaker() {
        System.out.println(this.getName()+ " have nothing to do");
    }

}


