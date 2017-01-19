/**
 Exercise 5-7.
Now that we have conditional statements, we can get back to the “Guess My Number”
game from Exercise 3-4.
You should already have a program that chooses a random number, prompts the user
to guess it, and displays the difference between the guess and the chosen number.
Adding a small amount of code at a time, and testing as you go, modify the program
so it tells the user whether the guess is too high or too low, and then prompts the user
for another guess.
The program should continue until the user gets it right. Hint:  Use two methods, and
make one of them recursive.
 */

import java.util.Random;
import java.util.Scanner;

public class RecursiveGuessNumber {
    
    public static void difference (int guessedNumber, int secretNumber){
        if (guessedNumber > secretNumber){
             System.out.print("Your number is higher!");
        }
        else{
         System.out.print("Your number is lower!");
        }
    }
    
    
    public static void guessNumber (int guessedNumber, int secretNumber){
        if (guessedNumber == secretNumber){
         System.out.println("Your guess is correct!");
         return;
        }
        else{
           Scanner in = new Scanner(System.in);
           difference(guessedNumber, secretNumber);
           System.out.println("Try another one:");
           int number = in.nextInt();
           guessNumber(number, secretNumber);
        }
    }
    

    public static void main(String[] args) {
                
        Random random = new Random();
        int number = random.nextInt(100) + 1; // pick a random number
        Scanner in = new Scanner(System.in);
        System.out.println("I'm thinking of a number between 0 and 100");
        System.out.println("Can you guess what it is?");
        System.out.print("Type a number: ");
        int guessNum = in.nextInt(); 
        System.out.println();

        guessNumber(guessNum, number);
    }
}
