package metodclass.abst;

public abstract class TransportVehicle {
    private String id;
    private double maxSpeed;

    public TransportVehicle(String id, double maxSpeed) {
        this.id = id;
        this.maxSpeed = maxSpeed;
    }

    public String getId() {
        return id;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }


    public void displayInfo() {
        System.out.println("ID: " + id + "Max Speed: " + maxSpeed);
    }

    public abstract void startEngine();

    public abstract double calculateFuelConsumption(double distance);
}
