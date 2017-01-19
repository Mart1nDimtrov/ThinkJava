/**
 * Exercise 7-2.
 * Let’s say you are given a number, a, and you want to find its square root. One way to
do that is to start with a rough guess about the answer, x0, and then improve the guess
using this formula:
x1 = (x0 + a/x0) + 2;
 Write a method called squareRootthat takes a  doubleand returns an approximation
of the square root of the parameter, using this technique. You should not use
Math.sqrt.
As your initial guess, you should use a/2. Your method should iterate until it gets two
consecutive estimates that differ by less than 0.0001. You can use  Math.abs  to calcu?
late the absolute value of the difference
 */
import java.util.Scanner;
public class FindRoot{
    public static void findRoot (double number, double guess){
        double constant = number;
        double root = 0.0;
        while(true){
            root = (guess + constant / guess) / 2 ;
            
            if(Math.abs(root - guess) < 0.0001){ // we Math.abs to determine how close the
                System.out.println("The root is:"); // two numbers are
                System.out.println(root);
                break;
            }
           guess = root;
          
        }
    }
    
public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Please enter your number:");
    double number = in.nextDouble();
    double guess = number / 2; // random guess
    findRoot(number, guess); 
}
}