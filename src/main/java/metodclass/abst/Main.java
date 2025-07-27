package metodclass.abst;

public class Main {
    public static void main(String[] args) {
        TransportVehicle[] transportVehicles = new TransportVehicle[2];
        transportVehicles[0] = new Bicycle("B-001", 25.5, true);
        transportVehicles[1] = new Car("C-001", 180.0, 5);

        System.out.println("--- Система Управління Транспортом ---");
        for (TransportVehicle vehicle : transportVehicles) {
            System.out.println("\n------------------------------------");
            vehicle.displayInfo();
            vehicle.startEngine();
            vehicle.calculateFuelConsumption(200);

            if (vehicle instanceof Car) {
                Car car = (Car) vehicle;
                System.out.println("  Тип: Автомобіль");
                System.out.println("  Кількість пасажирів: " + car.getNumberOfPassengers());
                ((Movable) car).move(200);
                ((Movable) car).stop();

            }else if (vehicle instanceof Bicycle) {
                Bicycle bicycle = (Bicycle) vehicle;
                System.out.println("  Тип: Велосипед");
                System.out.println("  Чи має велосипед коліска: " + bicycle.getHasGears());
                ((Movable) bicycle).move(150);
                ((Movable) bicycle).stop();
            }
        }
        System.out.println("------------------------------------");
        System.out.println("--- Конець Системи Управління Транспортом ---");

    }
}
