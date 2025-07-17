package core;

public class FactorialCalculator {
    public static void main(String[] args) {
        int number = -2;
        int factorial = 1;
        if(number < 0){
            System.out.println("Factorial of negative number does not exist");
            return;
        }else if(number == 0){
            System.out.println("Factorial of 0 is 1");
            return;
        }
        for(int i = 1; i <= number; i++) {
            factorial=factorial*i;
        }
        System.out.println("Factorial of " + number + " is " + factorial);
    }
}
