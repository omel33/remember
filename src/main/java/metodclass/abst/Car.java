package metodclass.abst;

public class Car extends TransportVehicle implements Movable {
    private int numberOfPassengers;

    public Car(String id, double maxSpeed, int numberOfPassengers) {
        super(id, maxSpeed);
        this.numberOfPassengers = numberOfPassengers;
    }
    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }
    @Override
    public void startEngine() {
        System.out.println("Автомобіль " + getId() + " запустив двигун.");
    }
    @Override
    public double calculateFuelConsumption(double distance) {
        double fuelConsumed = (distance / 100.0) * 8.0; // 8 літрів на 100 км
        System.out.printf("Автомобіль %s: для %.0f км витрачено %.2f л пального.%n", getId(), distance, fuelConsumed);
        return fuelConsumed;
    }
    @Override
    public void move(double distance) {
        System.out.println("Автомобіль " + getId() + " рухається на " + distance + " км.");
    }
}
