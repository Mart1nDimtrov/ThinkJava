/**
 * Exercise 9-3.
The purpose of this exercise is to review encapsulation and generalization (see
“Encapsulation and Generalization” on page 92). The following code fragment traver?
ses a string and checks whether it has the same number of open and close parenthe?
ses:
String s = "((3 + 7) * 2)";
int count = 0;
for (int i = 0; i < s.length(); i++) {
char c = s.charAt(i);
if (c == '(') {
count++;
} else if (c == ')') {
count--;
}
}
System.out.println(count);
1. Encapsulate this fragment in a method that takes a string argument and returns
the final value of count.
2. Now that you have generalized the code so that it works on any string, what
could you do to generalize it more?
3. Test your method with multiple strings, including some that are balanced and
some that are not.
 */

import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
public class CountParentheses{
    public static boolean countParentheses(String sentence)
    {
       boolean check = true;
       int count = 0;
       for (int i = 0; i < sentence.length(); i++) {
           char c = sentence.charAt(i);
           if (c == '(') {
               count++;
           } else if (c == ')') {
               count--;
           }
       }
        if (count == 0)
        {
            check = true;
        }
        else {
            check = false;
        }
        return check;
    }
   
    
public static void main(String[] args) {
    
    Scanner in = new Scanner(System.in);
     System.out.println("Please enter your sentence:");
     String sentence = in.nextLine();
  
     if(countParentheses(sentence))
     {
     System.out.println("There is an even number of parantheses in the sentence.");
     }
     else
     {
     System.out.println("You're missing a bracket.");
     }
     
}
}