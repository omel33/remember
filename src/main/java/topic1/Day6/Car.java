package topic1.Day6;

public class Car {
    private String brand;
    private int year;
    private double price;

    public Car(String brand, int year, double price) {
        this.brand = brand;
        this.year = year;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }
    public int getYear() {
        return year;
    }
    public double getPrice() {
        return price;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void printInfo(){
        System.out.println("Brand: " + brand + " Year: " + year + " Price: " + price);
    }
}
