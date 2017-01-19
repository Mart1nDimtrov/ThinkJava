/**
 * Exercise 8-5.
The Sieve of Eratosthenes is “a simple, ancient algorithm for finding all prime num?
bers up to any given limit,” which you can read about at https://en.wikipedia.org/wiki/
Sieve_of_Eratosthenes.
Write a method called sievethat takes an integer parameter, n, and returns a boolean
array that indicates, for each number from 0to n - 1, whether the number is prime.
 */

import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
public class SieveOfErathosthenes{
    public static boolean[] sieve (int[] arr){
       boolean[] sieve = new boolean[arr.length];
       for (int i = 0; i < arr.length; i++) {
           if(isPrime(arr[i]))
                  {
               sieve[i] = true;
           }
              else{
                 sieve[i] = false; 
              }
              
     }
        return sieve;
    }
    public static boolean isPrime (int number){
        boolean isPrime = true;
      for (int i = 1; i <= number; i++) { 
          if(number % i == 0 && i != 1 && i != number)
          {
              isPrime = false;
          }
     }
      return isPrime;
    }
    
public static void main(String[] args) {
    
    Scanner in = new Scanner(System.in);
     System.out.println("Please enter the range:");
      int range = in.nextInt();
    int[] arr = new int[range];
    
     for (int i = 1; i < range; i++) {
         arr[i] = i + 1;
     }
     
      System.out.println(Arrays.toString(sieve(arr)));
}
}