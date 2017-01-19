/**
 * Exercise 9-5.
A word is said to be “abecedarian” if the letters in the word appear in alphabetical
order. For example, the following are all six-letter English abecedarian words:
abdest, acknow, acorsy, adempt, adipsy, agnosy, befist, behint, beknow, bijoux, biopsy,
cestuy, chintz, deflux, dehors, dehort, deinos, diluvy, dimpsy
Write a method called  isAbecedarianthat takes a  Stringand returns a  boolean
indicating whether the word is abecedarian. Your method can be iterative or recur?
sive.
 */

import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
public class Abecederian{
    public static boolean isAbecederian(String word)
    {
        boolean flag = true;
        char temp = word.charAt(0);
        for(int i = 1; i < word.length(); i++){
            char c = word.charAt(i);
            if(temp < c){
                temp = c;
            }
            else {
                flag = false;
                return flag;
            }
        }
       return flag;
}
  
  
public static void main(String[] args) {
    
     Scanner in = new Scanner(System.in);
     System.out.println("Please enter a word:");
     String word = in.nextLine();
  
     if(isAbecederian(word)){
         System.out.println("The word is abecederian.");
     }
        else{
            System.out.println("The word is not abecederian.");
        }
        

  
}
}