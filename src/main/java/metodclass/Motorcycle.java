package metodclass;

public class Motorcycle extends Vehicle {
    private boolean hasSideCar;
    private double engineCapacityCC;
    public Motorcycle(String make, String model, int year, boolean hasSideCar, double engineCapacityCC) {
        super(make, model, year);
        this.hasSideCar = hasSideCar;
        if (engineCapacityCC > 0) {
            this.engineCapacityCC = engineCapacityCC;
        } else {
            System.err.println("Помилка: Об'єм двигуна має бути додатнім. Встановлено 0.0.");
            this.engineCapacityCC = 0.0;
        }
    }
    public Motorcycle() {
        super(); // Викликаємо конструктор за замовчуванням Vehicle
        this.hasSideCar = false;
        this.engineCapacityCC = 500.0;

    }
    public boolean getHasSideCar() {
        return hasSideCar;
    }
    public double getEngineCapacityCC() {
        return engineCapacityCC;
    }
    @Override
    public void startEngine() {
        System.out.println("Мотоцикл [" + getMake() + " " + getModel() + "] реве двигуном (об'єм: " + engineCapacityCC + " куб. см).");}
    @Override
    public double calculateFuelExpense(double distance) {
        double fuelConsumed = distance * 0.04; // Наприклад, 4 літри на 100 км, або 0.04 л/км
        System.out.printf("Мотоцикл: для %.0f км витрачено %.2f л пального.%n", distance, fuelConsumed);
        return fuelConsumed;
    }
}
