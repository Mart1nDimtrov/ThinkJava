/**
 * Exercise 8-4.
Write a method called  indexOfMaxthat takes an array of integers and returns the
index of the largest element. Can you write this method using an enhanced forloop?
Why or why not?
 */
import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
public class IndexOfMax {
    
    public static int indexOfMax (int[] arr){
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max)
            {
                max = arr[i];
            }
        }
        return max;
    }
    
public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
    
    
    int[] arr = new int[10];
    
     for (int i = 0; i < arr.length; i++) {
         System.out.println("Please enter the next number:");
         arr[i] = in.nextInt();
     }
     System.out.println("The max number is " + indexOfMax(arr));
}
}