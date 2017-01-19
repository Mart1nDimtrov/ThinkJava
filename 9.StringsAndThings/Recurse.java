/**
*Exercise 9-4.
Create a program called Recurse.javaand type in the following methods:

public static char first(String s) {
return s.charAt(0);
}

public static String rest(String s) {
return s.substring(1);
}

public static String middle(String s) {
return s.substring(1, s.length() - 1);
}

public static int length(String s) {
return s.length();
}

1. Write some code in mainthat tests each of these methods. Make sure they work,
and you understand what they do.
2. Using these methods, and without using any other  String methods, write a
method called  printString that takes a string as a parameter and that displays
the letters of the string, one on each line. It should be a void method.
3. Again using only these methods, write a method called printBackward that does
the same thing as  printStringbut that displays the string backward (again, one
character per line).
4. Now write a method called reverseString  that takes a string as a parameter and
that returns a new string as a return value. The new string should contain the
same letters as the parameter, but in reverse order.
String backwards = reverseString("coffee");
System.out.println(backwards);
The output of this example code should be:
eeffoc
5. A palindrome is a word that reads the same both forward and backward, like
“otto” and “palindromeemordnilap”. Here’s one way to test whether a string is a
palindrome:
A single letter is a palindrome, a two-letter word is a palindrome if the letters are
the same, and any other word is a palindrome if the first letter is the same as the
last and the middle is a palindrome.
Write a recursive method named isPalindrome that takes a Stringand returns a
booleanindicating whether the word is a palindrome.
**/


import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
public class Recurse{
    public static void printString(String sentence, int length)
    {
        if (length == 0)
        {
           System.out.println(sentence.charAt(0));
        }
        else {
             printString(sentence, length - 1);
            System.out.println(sentence.charAt(length));
           
        }
    }
    
      
       public static String reverseString(String str) {
    if ((null == str) || (str.length() <= 1)) {
        return str;
    }
    return reverseString(str.substring(1)) + str.charAt(0);
}
              public static boolean isPalindrome(String sentence) {
                  boolean check = true;
                  if(reverseString(sentence) == sentence){
                      check = true;
                  }
                  else{
                      check = false;
                  }
                  return check;
}

    
  
public static void main(String[] args) {
    
     Scanner in = new Scanner(System.in);
     System.out.println("Please enter a sentence:");
     String sentence = in.nextLine();
  
   printString(sentence, sentence.length() - 1);
    System.out.println();
  System.out.println(reverseString(sentence)); 
  
  if(isPalindrome(sentence))
  {
      System.out.println("The word is a palindrome.");
  }
  else{
      System.out.println("The word is not a palindrome.");
  }
  
}
}