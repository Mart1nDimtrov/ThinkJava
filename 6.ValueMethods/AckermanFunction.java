/**
 * Exercise 6-8.
The goal of this exercise is to translate a recursive definition into a Java method. The
Ackermann function is defined for non-negative integers as follows:
https://en.wikipedia.org/wiki/Ackermann_function
Write a method called ackthat takes two  ints as parameters and that computes and
returns the value of the Ackermann function.
Test your implementation of Ackermann by invoking it from main and displaying the
return value. Note the return value gets very big very quickly. You should try it only
for small values of mand n(not bigger than 3).
 */

import java.util.Scanner;

public class AckermanFunction {
    public static int calculateFunction(int first, int second){
        if (first == 0){
            return second + 1;
        }
        if (first > 0 && second == 0){
            return calculateFunction(first - 1, 1);
        }
      return calculateFunction(first - 1, calculateFunction(first, second - 1));
        
       }
    
public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    
     System.out.println("Please enter the two numbers on seperate lines:");
        int m = in.nextInt();
        int n = in.nextInt();
        
        System.out.println(calculateFunction(m, n));
}
}

