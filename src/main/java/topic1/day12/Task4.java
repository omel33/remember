package topic1.day12;

import java.lang.reflect.Method;

public class Task4 {
    public static void main(String[] args) throws Exception
    {
        Car c = new Car("BMW", 2015);

        Method secretMethod = Car.class.getDeclaredMethod("secretInfo");
        secretMethod.setAccessible(true);

        String result = (String) secretMethod.invoke(c);
        System.out.println(result);
        System.out.println(c);

        Method yearMethod = Car.class.getDeclaredMethod("increaseYear", int.class);
        yearMethod.setAccessible(true);

        yearMethod.invoke(c,5);

        System.out.println(c);
    }
}
