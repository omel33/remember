package topic1.day2;

import java.util.Scanner;

public class Uno {
    public static void main(String[] args) {
        Scanner scr=new Scanner(System.in);
        System.out.println("Enter number ");
        int n=scr.nextInt();
        if (n%2==0){
            System.out.println("Even");
        }else {
            System.out.println("Odd");
        }
    }
}
