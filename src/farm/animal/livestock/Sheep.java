package farm.animal.livestock;

public class Sheep extends LiveStock {

    private boolean isShear;

    public Sheep() {
        super(KindLiveStock.SHEEP);
        this.isShear = false;
    }

    public void setShear(boolean shear) {
        isShear = shear;
    }

    public boolean isShear() {
        return isShear;
    }
}
