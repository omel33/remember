package topic1;

import java.util.Scanner;

public class Hello {
    public static void main(String[] args) {
        Scanner scr=new Scanner(System.in);

        System.out.println("What is your name? ");
        String name=scr.nextLine();

        System.out.println("How old are you?");
        int age=scr.nextInt();

        System.out.println("What is your city?");
        String city=scr.nextLine();

        System.out.println("Hello " + name + "! You are " + age + " years old and you live in " + city);
    }
}
