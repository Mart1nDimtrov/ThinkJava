/**
 * Exercise 6-2.
Write a method named isDivisible that takes two integers, n and m, and that returns
true if n is divisible by m, and false otherwise.
 */
import java.util.Scanner;

public class Divisible{
    public static boolean isDivisible(int n, int m){
        if(n % m == 0){
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String[] args){
       
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the first number:");
        int n = in.nextInt();
        System.out.println("Enter the second number:");
        int m = in.nextInt();
        
       if (isDivisible(n, m)){
          System.out.println("The first number is divisible by the second.");
       }
       else{
         System.out.println("The first number is not divisible by the second.");
      }
    }
}

        