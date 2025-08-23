package metodclass;

public class  Car extends  Vehicle{
    private int numDoors;
    private double fuelConsumptionLitersPer100Km;

    public Car(String make, String model, int year, int numDoors, double fuelConsumptionLitersPer100Km) {
        super(make, model, year);
        this.numDoors = numDoors;
        if (fuelConsumptionLitersPer100Km >= 0) {
            this.fuelConsumptionLitersPer100Km = fuelConsumptionLitersPer100Km;
        } else {
            System.err.println("Помилка: Витрата пального не може бути від'ємною. Встановлено 0.0.");
            this.fuelConsumptionLitersPer100Km = 0.0;
        }

    }
    public Car() {
        super(); // Викликаємо конструктор за замовчуванням Vehicle
        this.numDoors = 4;
        this.fuelConsumptionLitersPer100Km = 10.0;
    }
    public int getNumDoors() {
        return numDoors;
    }
    public double getFuelConsumptionLitersPer100Km() {
        return fuelConsumptionLitersPer100Km;
    }
    public void setFuelConsumptionLitersPer100Km(double fuelConsumptionLitersPer100Km) {
        if (fuelConsumptionLitersPer100Km >= 0) {
            this.fuelConsumptionLitersPer100Km = fuelConsumptionLitersPer100Km;
        } else {
            System.err.println("Помилка: Недійсна витрата пального. Значення не змінено.");
        }
    }
    @Override
    public void startEngine() {
        System.out.println("Автомобіль [" + getMake() + " " + getModel() + "] запускає двигун з " + numDoors + " дверима.");
    }
    @Override
    public double calculateFuelExpense(double distance) {
        if (fuelConsumptionLitersPer100Km > 0) {
            double fuelConsumed = distance * fuelConsumptionLitersPer100Km / 100;
            System.out.printf("Автомобіль: для %.0f км витрачено %.2f л пального.%n", distance, fuelConsumed);
            return fuelConsumed;
        } else {
            System.err.println("Помилка: Витрата пального нульова або від'ємна для розрахунку.");
            return 0.0;
        }


    }

}
