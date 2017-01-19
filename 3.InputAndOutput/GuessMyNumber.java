/**
 * Exercise 3-4.
 The goal of this exercise is to program a “Guess My Number” game. When it’s fin‐
 ished, it will work like this:
 I'm thinking of a number between 1 and 100
 (including both). Can you guess what it is?
 Type a number: 45
 Your guess is: 45
 The number I was thinking of is: 14
 You were off by: 31
 To choose a random number, you can use the Randomclass in  java.util. Here’s how
 it works:
 import java.util.Random;
 public class GuessStarter {
 public static void main(String[] args) {
 // pick a random number
 Random random = new Random();
 int number = random.nextInt(100) + 1;
 System.out.println(number);
 }
 }
 Like the  Scannerclass we saw in this chapter,  Randomhas to be imported before we
 can use it. And as we saw with  Scanner, we have to use the  newoperator to create a
 Random(number generator).
 Then we can use the method nextInt to generate a random number. In this example,
 the result of  nextInt(100)will be between 0 and 99, including both. Adding 1 yields
 a number between 1 and 100, including both.
 1. The definition of  GuessStarteris in a file called  GuessStarter.java, in the
 directory called ch03, in the repository for this book.
 2. Compile and run this program.
 3. Modify the program to prompt the user, then use a Scanner to read a line of user
 input. Compile and test the program.
 4. Read the user input as an integer and display the result. Again, compile and test.
 5. Compute and display the difference between the user’s guess and the number that
 was generated.
 * Created by martin on 30.10.2016 г..
 */
import java.util.Random;
import java.util.Scanner;
/**
 * Starter code for the "Guess My Number" exercise.
 */
public class GuessMyNumber {

    public static void main(String[] args) {
        // pick a random number
        Scanner in = new Scanner(System.in);
        System.out.print("I'm thinking of a number between 0 and 100");
        System.out.println("can you guess what it is?");
        System.out.print("Type a number: ");
        int guessNum = in.nextInt();
        System.out.printf("Your guess is %d", guessNum);
        System.out.println();
        Random random = new Random();
        int number = random.nextInt(100) + 1;
        System.out.printf("The number I was thinking is: %d", number);
        System.out.println();
        System.out.printf("You were off by: %d", Math.abs(number - guessNum));
    }

}
