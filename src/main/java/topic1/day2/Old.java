package topic1.day2;

import java.util.Scanner;

public class Old {
    public static void main(String[] args)
    {
        Scanner scr=new Scanner(System.in);
        System.out.println("How old are you? ");
        int age=scr.nextInt();
        if(age>=18){
            System.out.println("You adult");
        }else {
            System.out.println("You child");
        }
    }
}
