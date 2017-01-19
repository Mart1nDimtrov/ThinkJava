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
public class PracticeEncapsulation2{
    public static int[] count (int scale, int[] arr){
        int[] counts = new int[scale];
        for (int score : arr) {
            counts[score]++;
        }
        return counts;
    }
    
public static void main(String[] args) {
    
    Scanner in = new Scanner(System.in);
    System.out.println("Please enter how many scores there are:");
    int scoresCount = in.nextInt();
    int[] arr = new int[scoresCount];
    
     for (int i = 0; i < scoresCount; i++) {
         System.out.println("Please enter a score:");
         arr[i] = in.nextInt();
     }
      System.out.println("Please enter the scale:");
      int scale = in.nextInt();
      System.out.println(Arrays.toString(count(scale, arr)));
}
}