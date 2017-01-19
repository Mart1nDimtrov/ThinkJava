/**
 * Exercise 9-7.
Two words are anagrams if they contain the same letters and the same number of
each letter. For example, “stop” is an anagram of “pots” and “allen downey” is an ana?
gram of “well annoyed”.
Write a method that takes two strings and checks whether they are anagrams of each
other.
 */
import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
public class Anagrams{
    public static boolean areAnagrams(String word, String secondWord)
    {
        boolean flag = true;
         int [] histogram = new int[26];
         int [] secondHistogram = new int[26];
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) != ' ')
            {
                char c = word.charAt(i);
                histogram[(int)(c) - 97]++;
            }
    
        }
             
        for(int i = 0; i < secondWord.length(); i++){
                   if(secondWord.charAt(i) != ' ')
            {
                char c = secondWord.charAt(i);
                secondHistogram[(int)(c) - 97]++;
            }
        }
        
         for(int i = 0; i < histogram.length; i++){
           if (histogram[i] != secondHistogram[i])
           {
               flag = false;
           }
        }

       return flag;
}

  
public static void main(String[] args) {
    
     Scanner in = new Scanner(System.in);
     System.out.println("Please enter the fist word:");
     String word = in.nextLine();
    String copy = word.toLowerCase();
        System.out.println("Please enter the second word:");
     String secondWord = in.nextLine();
    String secondCopy = secondWord.toLowerCase();
  
     if(areAnagrams(copy, secondCopy)){
         System.out.println("The words are anagrams of each other.");
     }
     else{
            System.out.println("The words are not anagrams of each other.");
        }
 
}
}