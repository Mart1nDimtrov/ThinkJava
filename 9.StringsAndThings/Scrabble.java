/**
 * Exercise 9-8.
In Scrabble each player has a set of tiles with letters on them. The object of the game
is to use those letters to spell words. The scoring system is complex, but longer words
are usually worth more than shorter words.
Imagine you are given your set of tiles as a string, like  "quijibo", and you are given
another string to test, like "jib".
Write a method called canSpellthat takes two strings and checks whether the set of
tiles can spell the word. You might have more than one tile with the same letter, but
you can only use each tile once.
 */
import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
public class Scrabble{
    public static boolean checkWords(String word, String secondWord)
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
           if (secondHistogram[i] != 0 && secondHistogram[i] > histogram[i])
           {                           // if the spot on the second histogram is not empty
               flag = false;          //  and there are more letters than on the tiles
           }
        }

       return flag;
}

  
public static void main(String[] args) {
    
     Scanner in = new Scanner(System.in);
     System.out.println("Please enter the tiles you have:");
     String tiles = in.nextLine();
    String copy = tiles.toLowerCase();
        System.out.println("Please enter the word you want to make:");
     String secondWord = in.nextLine();
    String secondCopy = secondWord.toLowerCase();
  
     if(checkWords(copy, secondCopy)){
         System.out.println("Scrabble!");
     }
     else{
            System.out.println("No scrabble :(");
        }
 
}
}