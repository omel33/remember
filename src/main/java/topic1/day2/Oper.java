package topic1.day2;

import java.util.Scanner;

public class Oper {
    public static void main(String[] args)
    {
        Scanner scr=new Scanner(System.in);
        System.out.println("Enter number 1");
        int n=scr.nextInt();
        System.out.println("Enter number 2");
        int m=scr.nextInt();
        int operation=4;
        System.out.println("Enter operation. 1 sum. 2 sub. 3 mul. 4 div");
        operation=scr.nextInt();
        switch (operation){
            case 1:
                System.out.println("Sum :"+(n+m));
                break;
                case 2:
                System.out.println("Sub :"+(n-m));
                break;
                case 3:
                System.out.println("Mul :"+(n*m));
                break;
                case 4:
                    if(m!=0){
                        System.out.println("div :"+((double)n / m));
                    }else {
                        System.out.println("Can't divide by zero");
                    }
                break;
            default:
                System.out.println("Unknown operation");
        }

    }
}
