/**
 * Exercise 8-1.
The goal of this exercise is to practice encapsulation with some of the examples in this
chapter.
1. Starting with the code in  “Array Traversal” on page  107, write a method called
powArray that takes a  double array,  a, and returns a new array that contains the
elements of a squared. Generalize it to take a second argument and raise the ele?
ments of a to the given power.
2. Starting with the code in “The Enhanced for Loop” on page  111, write a method
called  histogramthat takes an  intarray of scores from 0 to (but not including)
100, and returns a histogram of 100 counters. Generalize it to take the number of
counters as an argument.
 */

import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
public class PracticeEncapsulation{
    public static void powers (String numbers, double power, double[] arr){
        
        for (int i = 0; i < numbers.length(); i++) {
           char c = numbers.charAt(i);
           double number = (double)(c) - 48;
           arr[i] = Math.pow(number, power);  
        }

    }
    
public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Please enter your array of numbers seperated by spaces:");
    String numbers = in.nextLine(); 
    String[] numbersParsed = numbers.split(" ");
    String nums = String.join("", numbersParsed);
    System.out.println("Please enter the power:");
    double power = in.nextDouble();
    double[] arr = new double[nums.length()];
    
    powers(nums, power, arr); 
    System.out.println(Arrays.toString(arr));
    
    
}
}