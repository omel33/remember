package metodclass;

public class GarageApp {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[3];
        vehicles[0] = new Vehicle("Generic", "Transport", 2020);
        vehicles[1] = new Car("Toyota", "Camry", 2020, 4, 8.5);
        vehicles[2] = new Motorcycle("Harley-Davidson", "Iron 883", 2022, false, 883.0);

        System.out.println("--- Огляд транспортних засобів у гаражі (Поліморфізм) ---");

        for(Vehicle v: vehicles) {
            System.out.println("\n------------------------------------");
            v.startEngine();
            v.calculateFuelExpense(100);


        if(v instanceof Car) {
            Car car = (Car) v;
            System.out.println("Кількість дверей: " + car.getNumDoors());
            System.out.println("Витрата пального на 100 км: " + car.getFuelConsumptionLitersPer100Km() + " л");
            System.out.println("Type: Car");
        }else if(v instanceof Motorcycle) {
            Motorcycle motorcycle = (Motorcycle) v;
            System.out.println("  Тип: Мотоцикл");
            System.out.println("  Чи є коляска: " + (motorcycle.getHasSideCar() ? "Так" : "Ні"));
            System.out.println("  Об'єм двигуна (куб. см): " + motorcycle.getEngineCapacityCC());
        }else {
            System.out.println("  Тип: Загальний транспортний засіб.");
        }
    }

    }
}