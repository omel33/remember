package topic1.day3;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = sc.nextInt();

        int fact = 1;
        for (int i = 1; i <= n; i++){
            fact *= i;
            System.out.println(fact);
        }
        System.out.println("Factorial of "+n+" is "+fact);

        System.out.println("enter number: ");
        int k=sc.nextInt();

        int sum=0;
        for (int i = 1; i <= k; i++){
            sum += i;
            System.out.println(sum);
        }
        System.out.println("Sum of "+k+" is "+sum);
    }
}
