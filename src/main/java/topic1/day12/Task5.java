package topic1.day12;

public class Task5 {
    public static void main(String[] args) throws Exception {
        Class<Car> clazz = Car.class;
        MyAnnotation ann= clazz.getAnnotation(MyAnnotation.class);
        System.out.println(ann.author());
        System.out.println(ann.version());
    }
}
