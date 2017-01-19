/**
 * Exercise 7-4.
“More Recursion” on page 79 presents a recursive method that computes the factorial
function. Write an iterative version of factorial.
 */
import java.util.Scanner;
public class FindFactorial{
    public static void findFactorial (int number){
        int factorial = number;
        for(int i = number - 1; i > 0; i--){ 
            factorial *= i;
        }
    System.out.println("The factorial of " + number + " is:");
    System.out.println(factorial);
    }
    
public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
    System.out.println("Please enter your number:");
    int number = in.nextInt();
    findFactorial(number);
}
}