/**
Exercise 8-6.
Write a method named areFactors that takes an integer  n and an array of integers,
and that returns  true if the numbers in the array are all factors of  n(which is to say
that n is divisible by all of them).
*/

import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
public class AreFactors{

    public static boolean areFactors (int [] arr, int number){
      boolean areFactors = true;
      for (int i = 0; i < arr.length; i++) { 
          if(number %  arr[i] != 0)
          {
             areFactors = false;
          }
     }
      return areFactors;
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
     
     if(areFactors(arr, number)){
         System.out.println("All are factors.");
     }
     else{
         System.out.println("Not all are factors.");
     }     
      
}

}