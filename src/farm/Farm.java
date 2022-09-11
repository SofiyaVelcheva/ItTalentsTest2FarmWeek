package farm;

import farm.animal.Animal;
import farm.animal.KindAnimal;
import farm.farmer.Farmer;
import village.order.Buy;
import village.order.Order;

import java.util.*;

public class Farm {

    private static Farm FARM;
    private String name;
    private List<Farmer> farmers = new ArrayList<>();
    private Map<Animal.TypeAnimal, Map<KindAnimal, List<Animal>>> animals = new HashMap<>();
    private Stack<Order> orders = new Stack<>();
    private final Map<Buy.BuyType, Integer> production = startProduction();
    private int counterPlug = 0;
    private int counterMilkLiter = 0;
    private int counterDeal = 0;
    private int counterOrder;


    private Map<Buy.BuyType, Integer> startProduction() {
        Map<Buy.BuyType, Integer> start = new HashMap<>();
        start.put(Buy.BuyType.MILK, 0);
        start.put(Buy.BuyType.WAVE, 0);
        return start;
    }

    private int moneyFarm = 0;

    private Farm(String name) {
        this.name = name;
    }

    public static void getInstanceFarm(String name) {
        if (FARM == null) {
            FARM = new Farm(name);
        }

    }

    public static Farm getFarm() {
        return FARM;
    }

    public void addAnimal(Animal a) {
        Animal.TypeAnimal typeAnimal = a.getType();
        KindAnimal kindAnimal = a.getKind();

        if (!animals.containsKey(typeAnimal)) {
            animals.put(typeAnimal, new HashMap<>());
        }

        if (!animals.get(typeAnimal).containsKey(kindAnimal)) {
            animals.get(typeAnimal).put(kindAnimal, new ArrayList<>());
        }

        animals.get(typeAnimal).get(kindAnimal).add(a);
    }

    public void addFarmer(Farmer f) {
        farmers.add(f);
    }

    public void addOrder(Order o) {
        orders.push(o);
    }

    public List<Farmer> getFarmers() {
        return farmers;
    }

    public Stack<Order> getOrders() {
        return orders;
    }

    public Map<Animal.TypeAnimal, Map<KindAnimal, List<Animal>>> getAnimals() {
        return animals;
    }

    public void addProduction(Buy.BuyType nameProduct, int quantity) {
        if (!this.production.containsKey(nameProduct)) {
            this.production.put(nameProduct, quantity);
        } else {
            this.production.put(nameProduct, this.production.get(nameProduct) + quantity);
        }
    }

    public Map<Buy.BuyType, Integer> getProduction() {
        return production;
    }

    public void addMoneyFarm(int moneyFarm) {
        this.moneyFarm = this.moneyFarm + moneyFarm;
    }

    public void printStatistics() {
        System.out.println("All milk " + counterMilkLiter);
        printFarmerMoney();
        System.out.println("All fields " + counterPlug);
        printPercentOrders();
    }

    private void printPercentOrders() {
        double percent = 1.0 * this.counterDeal / this.counterOrder;
        System.out.printf("Percent orders: %.2f", percent * 100);
    }

    public void setCounterOrder(int counterOrder) {
        this.counterOrder = counterOrder;
    }

    private void printFarmerMoney() {
        farmers.sort((o1, o2) -> {
            if ((o2.getMoneyFarmer() - o1.getMoneyFarmer()) == 0) {
                return 1;
            }

            return o2.getMoneyFarmer() - o1.getMoneyFarmer();
        });
        for (Farmer farmer : farmers) {
            System.out.println(farmer);
        }
    }

    public void setCounterPlug(int counterPlug) {
        this.counterPlug = this.counterPlug + counterPlug;
    }

    public void setCounterMilkLiter(int counterMilkLiter) {
        this.counterMilkLiter = this.counterMilkLiter + counterMilkLiter;
    }

    public void setCounterDeal() {
        this.counterDeal = this.counterDeal + 1;
    }
}
