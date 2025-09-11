package topic1;

import java.util.Scanner;

public class Temp {
    public static void main(String[] args) {
        Scanner scr=new Scanner(System.in);
        System.out.println("What is the temperature in Celsius? ");
        double c=scr.nextDouble();
        double fahrenheit=c * 9/5 + 32;
        System.out.println("The temperature in Fahrenheit is " + fahrenheit);
    }
}
