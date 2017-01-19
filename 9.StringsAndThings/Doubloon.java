/**
 * Exercise 9-6.
A word is said to be a “doubloon” if every letter that appears in the word appears
exactly twice. Here are some example doubloons found in the dictionary:
Abba, Anna, appall, appearer, appeases, arraigning, beriberi, bilabial, boob, Caucasus,
coco, Dada, deed, Emmett, Hannah, horseshoer, intestines, Isis, mama, Mimi, murmur,
noon, Otto, papa, peep, reappear, redder, sees, Shanghaiings, Toto
Write a method called isDoubloonthat takes a string and checks whether it is a dou?
bloon. To ignore case, invoke the toLowerCasemethod before checking.
 */

import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
public class Doubloon{
    public static boolean isDoubloon(String word)
    {
        boolean flag = true;
        
         int [] histogram = new int[26];
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            histogram[(int)(c) - 97]++;
        }
        
         for(int i = 0; i < histogram.length; i++){
           if (histogram[i] != 2 && histogram[i] != 0)
           {
               flag = false;
           }
        }

       return flag;
}

  
public static void main(String[] args) {
    
     Scanner in = new Scanner(System.in);
     System.out.println("Please enter a word:");
     String word = in.nextLine();
    String copy = word.toLowerCase();
  
     if(isDoubloon(copy)){
         System.out.println("The word is a doubloon.");
     }
        else{
            System.out.println("The word is not a doubloon.");
        }
 
}
}