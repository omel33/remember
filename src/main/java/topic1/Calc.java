package topic1;

import java.util.Scanner;

public class Calc {
    public static void main(String[] args) {
        Scanner scr=new Scanner(System.in);
        System.out.println("Enter first number");
        int a=scr.nextInt();
        System.out.println("Enter second number");
        int b=scr.nextInt();
        System.out.println("Sum of " + a + " and " + b + " is " + (a+b));
        System.out.println("Difference of " + a + " and " + b + " is " + (a-b));
        System.out.println("Product of " + a + " and " + b + " is " + (a*b));
        if( b !=0){
            System.out.println("Quotient of " + a + " and " + b + " is " + (a/b));
        }else {
            System.out.println("Cannot divide by zero");
        }
    }
}
