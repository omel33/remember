package topic1.Day6;

import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("BMW", 2015, 10000);
        car1.printInfo();
        Student student1 = new Student("John", 18, 4.5);
        student1.printInfo();
        BankAccount account1 = new BankAccount(1000.0);
        System.out.println("Balance: " + account1.getBalance());
        account1.deposit(500.0);
        System.out.println("New balance: " + account1.getBalance());
        account1.withdraw(200.0);
        System.out.println("New balance: " + account1.getBalance());
        HashSet <Car> carSet = new HashSet<>();
        ArrayList <Car> carList = new ArrayList<>();
    }
}
