package topic1.day7;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Animal[] animals = {dog, cat};
        for(Animal animal : animals){
            animal.makeSound();
        }

        Rectangle rectangle = new Rectangle(5, 10);
        Circle  circle = new Circle(5);
        Shape[] shapes = {rectangle, circle};
        for(Shape shape : shapes){
            System.out.println(shape.getArea());
        }
        Playable[] instruments = {new Guitar(), new Piano()};
        for(Playable instrument : instruments){
            instrument.play();
        }
    }
}
