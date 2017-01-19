/**
 * Exercise 6-7.
Write a recursive method named  oddSum that takes a positive odd integer  n  and
returns the sum of odd integers from 1 to n. Start with a base case, and use temporary
variables to debug your solution. You might find it helpful to print the value of neach
time oddSumis invoked.
 */
import java.util.Scanner;
public class OddSum{
    public static int oddSum (int oddNum){
     
       if (oddNum == 1)
       {
           return oddNum;
       }
       else{
        int recurse = oddSum(oddNum - 2);
        // System.out.println(recurse);
        int sum = oddNum + recurse;
        return sum;
       }
    }
    
public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Please enter an odd number:");
    int oddNum = in.nextInt();
    System.out.println(oddSum(oddNum));
}
}
