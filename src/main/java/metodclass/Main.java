package metodclass;

public class Main {
    public static void main(String[] args) {
        Calc calc = new Calc();
        double circleArea = calc.calculateCircleArea(5.0);
        calc.printArea("Circle", circleArea);

        double rectangleArea = calc.calculateRectangleArea(4.0, 6.0);
        calc.printArea("Rectangle", rectangleArea);
    }
}
