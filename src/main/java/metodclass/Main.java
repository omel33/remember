package metodclass;

public class Main {
    public static void main(String[] args) {
        double circleArea = AreaCalculator.calculateCircleArea(5.0);
        System.out.println("Circle area: " + circleArea);

        double rectangleArea = AreaCalculator.calculateRectangleArea(4.0, 6.0);
        System.out.println("Rectangle area: " + rectangleArea);

        AreaCalculator.printArea("Circle", circleArea);
        AreaCalculator.printArea("Rectangle", rectangleArea);

    }
}
