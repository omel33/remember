package topic1.day3;

import java.util.Scanner;

public class GuessGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int secret = (int)(Math.random()*100)+1;
        System.out.println("Guess a number between 1 and 100");
        int trys = 0;

        while ( true){
            System.out.println("Enter your guess");
            int guess = sc.nextInt();
            trys++;
            if (guess == secret){
                System.out.println("You guessed it!");

                break;
            }else if (guess > secret){
                System.out.println("Your guess is too high");
            }else {
                System.out.println("Your guess is too low");
            }
        }
        System.out.println("Вітаю, ти вгадав за "+trys+" спроб!");
    }
}
