/**
Exercise 8-7.
Write a method named arePrimeFactors that takes an integer n and an array of inte?
gers, and that returns true if the numbers in the array are all prime and their product
is n.
*/

import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
public class ArePrimeFactors{

    public static boolean arePrimeFactors (int [] arr, int number){
      boolean areFactors = true;
      for (int i = 0; i < arr.length; i++) { 
          if(number %  arr[i] != 0 && !isPrime(arr[i]))
          {
             areFactors = false;
          }
     }
      return areFactors;
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
     System.out.println("Please enter the number:");
     int number = in.nextInt();
    int[] arr = new int[3];
    
    System.out.println("Please enter the array:");
     for (int i = 0; i < arr.length; i++) {
     
         arr[i] = in.nextInt();
     }
     
     if(arePrimeFactors(arr, number)){
         System.out.println("All are prime factors.");
     }
     else{
         System.out.println("Not all are prime factors.");
     }     
      
}

}