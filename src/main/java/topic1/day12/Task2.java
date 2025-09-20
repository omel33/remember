package topic1.day12;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class Task2 {
    public static void main(String[] args) throws Exception {
        Constructor<Car> constructor=Car.class.getConstructor(String.class, int.class);
        Car car=constructor.newInstance("Toyota",2010);

        System.out.println("Before mod: "+ car);

        Field brandField=Car.class.getDeclaredField("brand");
        brandField.setAccessible(true);
        brandField.set(car,"Lexus");

        Field yearField=Car.class.getDeclaredField("year");
        yearField.setAccessible(true);
        yearField.set(car,2025);

        System.out.println("After mod: "+ car);
    }
}
