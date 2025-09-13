package topic1.day3;

import java.util.Scanner;

public class Midl {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number of elements: ");
        int n = sc.nextInt();

        int[] arr=new int[n];
        System.out.println("Enter " + n + " elements:");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        int sum = 0;
        for(int num: arr){
            sum += num;
        }
        double midl = (double) sum / n;
        System.out.println("Midl is " + midl);
    }
}
