/**
 * Exercise 9-2.
Write a method called  letterHist that takes a string as a parameter and returns a
histogram of the letters in the string. The zeroth element of the histogram should
contain the number of a’s in the string (upper- and lowercase); the 25th element
should contain the number of z’s. Your solution should only traverse the string once.
 */

import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
public class LetterHistogram{
    public static int[] letterHist(String letters)
    {
        int [] histogram = new int[26];
        for(int i = 0; i < letters.length(); i++){
            char c = letters.charAt(i);
            histogram[(int)(c) - 97]++;
        }
        return histogram;
    }
   
    
public static void main(String[] args) {
    
    Scanner in = new Scanner(System.in);
     System.out.println("Please enter the string of letters:");
     String letters = in.nextLine();
     String copy = letters.toLowerCase();
     
     String reference = "";
     
     for (char c = 'a'; c <= 'z'; c++){
         reference += c;
     }
     System.out.println(Arrays.toString(letterHist(copy)));
}
}
     
     