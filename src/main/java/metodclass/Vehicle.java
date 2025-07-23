package metodclass;

public class Vehicle {
    private String make;
    private String model;
    private int year;

    public Vehicle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }
    public Vehicle() {
        this("Невідома марка", "Невідома модель", 0); // Викликаємо інший конструктор з базовими значеннями
    }
    public String getMake() {
        return make;
    }
    public String getModel() {
        return model;
    }
    public int getYear() {
        return year;
    }
    public void startEngine() {
        System.out.println("Двигун транспортного засобу [" + make + " " + model + "] запущено.");
    }
    public double calculateFuelExpense(double distance) {
        double fuelConsumed = distance * 0.5; // Наприклад, 0.5 літра на км
        System.out.printf("Базовий транспортний засіб: для %.0f км витрачено %.2f л пального.%n", distance, fuelConsumed);
        return fuelConsumed;
    }

}
