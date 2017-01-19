/**
 * Exercise 6-4.
Many computations can be expressed more concisely using the “multadd” operation,
which takes three operands and computes a * b + c. Some processors even provide
a hardware implementation of this operation for floating-point numbers.
1. Create a new program called Multadd.java.
2. Write a method called multaddthat takes three  doubles as parameters and that
returns a * b + c.
3. Write a main method that tests multadd by invoking it with a few simple parame?
ters, like 1.0, 2.0, 3.0.

Hint :The method for raising eto a power is Math.exp.
In the last part of this exercise, you need to write a method that invokes another
method you wrote. Whenever you do that, it is a good idea to test the first method
carefully before working on the second. Otherwise, you might find yourself debug?
ging two methods at the same time, which can be difficult.
One of the purposes of this exercise is to practice pattern-matching: the ability to rec?
ognize a specific problem as an instance of a general category of problems.
 */

import java.util.Scanner;

public class Multadd{
    public static double multadd(double a, double b, double c){
        
        return a * b + c;

    }
       public static double multadd(double a, double b){
        
        return a + b;

    }
    public static void main(String[] args){
        System.out.println(multadd(1.0, 2.0, 3.0));
        System.out.println(multadd(Math.sin(Math.PI / 4.0), Math.cos(Math.PI / 4.0) / 2.0));
        System.out.println(multadd(Math.log(10), Math.log(20)));
    }
}