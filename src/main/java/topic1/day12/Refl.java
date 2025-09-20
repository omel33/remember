package topic1.day12;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Refl {
    public static void main(String[] args) throws  Exception {
        Car car1 = new Car("BMW", 2015);
        Class<?> clazz = car1.getClass();
        System.out.println(clazz.getName());

        for(Field field : clazz.getDeclaredFields()){
            System.out.println(field.getName()+" "+field.getType());
        }

        Constructor<?> constructor = clazz.getConstructor(String.class, int.class);
        Object carObj= constructor.newInstance("Audi", 2018);
        Method toString = clazz.getMethod("toString");
        String result = (String) toString.invoke(carObj);
        System.out.println(result);

        Method driveMethod = clazz.getMethod("drive");
        driveMethod.invoke(carObj);

    }
}
