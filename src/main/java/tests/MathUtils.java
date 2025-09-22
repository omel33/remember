package tests;

public class MathUtils {
    public static int sum(int a, int b) {
        return a + b;
    }
    public static double div(int a, int b){
        if(b==0) throw new ArithmeticException("Division by zero");
        return a / b;
    }
}
