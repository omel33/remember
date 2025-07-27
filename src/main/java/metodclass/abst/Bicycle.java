package metodclass.abst;

public class Bicycle extends TransportVehicle implements Movable {
    private boolean hasGears;

    public Bicycle(String id, double maxSpeed, boolean hasGears) {
        super(id, maxSpeed);
        this.hasGears = hasGears;
    }

    public boolean getHasGears() {
        return hasGears;
    }
    @Override
    public void startEngine() {
        System.out.println("Bicycle don`t have engine started.");
    }
    @Override
    public double calculateFuelConsumption(double distance) {
        System.out.printf("Велосипед %s: для %.0f км витрачено 0.00 л пального (екологічно!).%n", getId(), distance);
        return 0;
    }

    @Override
    public void move(double distance) {
        System.out.println("Велосипед " + getId() + " рухається на " + distance + " км.");
    }
}
