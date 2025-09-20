package topic1.day12;

import java.lang.reflect.Constructor;

public class Task3 {
    public static void main(String[] args) throws Exception
    {
        Constructor<Car> privateConstructor=Car.class.getDeclaredConstructor();
        privateConstructor.setAccessible(true);

        Car car=privateConstructor.newInstance();
        System.out.println( "private construktor: "+car);

        Constructor<Car> privateConstructor2=Car.class.getDeclaredConstructor(String.class);
        privateConstructor2.setAccessible(true);

        Car car2=privateConstructor2.newInstance("HiddenTesla");
        System.out.println("private construktor2: "+car2);
    }
}
