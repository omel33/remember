package topic1.day12;

public class Car {
    private String brand;
    private int year;

    public Car(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }
    private Car() {
        this.brand = "HiddenTesla";
        this.year = 9999;
    }
    private Car(String brand) {
        this.brand = brand;
        this.year = -1; // або будь-яке значення
    }

    public void drive() {
        System.out.println("Driving a " + brand + " car.");
    }
    private String secretInfo() {
        return "This is a secret car: " + brand + " (" + year + ")";
    }
    private void increaseYear(int n) {
        this.year += n;
    }

    @Override
    public String toString() {
        return "Car [brand=" + brand + ", year=" + year + "]";
    }
}
