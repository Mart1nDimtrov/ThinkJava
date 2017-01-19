/**
 * Exercise 6-9.
Write a recursive method called  power  that takes a double  x and an integer  n  and
returns Math.pow(x, n).
Hint:A recursive definition of this operation is Math.pow(x, n) = x * Math.pow(x, n - 1);
. Also, remember that anything raised to the zeroth power is 1.
Optional challenge: you can make this method more efficient, when n is even, using 
Math.pow(x) = Math.pow(Math.pow(x, n/2), 2);
 */
import java.util.Scanner;
public class RecursivePower{
    public static double power (double number, int power){
     if (power == 1)
     {
         return number;
     }
     double recursive = power(number, power - 1);
     double numberRaised = number * recursive;
     return numberRaised;
    }
    
public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Please enter the number you want raised to a power:");
    double number = in.nextDouble();
    System.out.println("Please enter the power:");
     int power = in.nextInt();
     System.out.println(number + " raised to the power of " + power + " is:");
     System.out.println(power(number, power));
}
}
