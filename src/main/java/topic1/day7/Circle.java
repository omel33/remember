package topic1.day7;

public class Circle extends Shape{
    double radius;
    public Circle(double radius)
    {
        this.radius = radius;
    }
    @Override
    double getArea()
    {
        return Math.PI * radius * radius;
    }
}
