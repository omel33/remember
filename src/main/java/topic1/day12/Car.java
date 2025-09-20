package topic1.day12;

@MyAnnotation(author = "Omelko", version = 2.0)
public class Car {
    private String brand;
    private int year;

    public Car(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }


    @Override
    public String toString() {
        return "Car [brand=" + brand + ", year=" + year + "]";
    }
}
