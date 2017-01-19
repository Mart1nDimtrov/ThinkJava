/**
 * Exercise 10-5.
Many encryption algorithms depend on the ability to raise large integers to a power.
Here is a method that implements an efficient algorithm for integer exponentiation:
public static int pow(int x, int n) {
if (n == 0) return 1;
// find x to the n/2 recursively
int t = pow(x, n / 2);
// if n is even, the result is t squared
// if n is odd, the result is t squared times x
if (n % 2 == 0) {
    return t * t;
} else {
    return t * t * x;
  }
}
The problem with this method is that it only works if the result is small enough to be
represented by an  int. Rewrite it so that the result is a  BigInteger. The parameters
should still be integers, though.
You should use the  BigIntegermethods  addand  multiply. But don’t use
BigInteger.pow; that would spoil the fun.
 */

import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
import java.math.BigInteger;

public class IntegerExponentiation{
    
    public static BigInteger pow(int x, int n) {
        BigInteger number =  BigInteger.valueOf(x);
        if (n == 0) return BigInteger.valueOf(1);
       // find x to the n/2 recursively
       BigInteger t = pow(x, n / 2);
       // if n is even, the result is t squared
      // if n is odd, the result is t squared times x
       if (n % 2 == 0) {
        return t.multiply(t);
       } else {
        return number.multiply(t.multiply(t));
        }
 }
    
   public static void main(String[] args) {
       
     Scanner in = new Scanner(System.in);
     System.out.println("Please enter the number:");
     int number = in.nextInt();
     System.out.println("Please enter the exponent:");
     int exponent = in.nextInt();
     
     
     System.out.println(number + " multiplied " + exponent + " times is:");
     System.out.println(pow(number, exponent));
    
}
}

