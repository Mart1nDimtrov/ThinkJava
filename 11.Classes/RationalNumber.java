/**
 Exercise 11-5.
A rational number is a number that can be represented as the ratio of two integers.
For example,  2/3is a rational number, and you can think of 7 as a rational number
with an implicit 1 in the denominator.
1. Define a class called  Rational. A  Rationalobject should have two integer
instance variables that store the numerator and denominator.
2. Write a constructor that takes no arguments and that sets the numerator to 0 and
denominator to 1.
3. Write an instance method called  printRationalthat displays a  Rational  in
some reasonable format.
4. Write a  mainmethod that creates a new object with type  Rational, sets its
instance variables to some values, and displays the object.
5. At this stage, you have a minimal testable program. Test it and, if necessary,
debug it.
6. Write a toStringmethod for Rationaland test it using println.
7. Write a second constructor that takes two arguments and uses them to initialize
the instance variables.
8. Write an instance method called negatethat reverses the sign of a rational num?
ber. This method should be a modifier, so it should be void. Add lines to main  to
test the new method.
9. Write an instance method called invert that inverts the number by swapping the
numerator and denominator. It should be a modifier. Add lines to mainto test the
new method.
10. Write an instance method called toDouble that converts the rational number to a
double(floating-point number) and returns the result. This method is a pure
method; it does not modify the object. As always, test the new method.
11. Write an instance method named  reducethat reduces a rational number to its
lowest terms by finding the greatest common divisor (GCD) of the numerator
and denominator and dividing through. This method should be a pure method;
it should not modify the instance variables of the object on which it is invoked.
Hint:Finding the GCD only takes a few lines of code. Search the web for “Eucli?
dean algorithm”.
12. Write an instance method called  addthat takes a  Rationalnumber as an argu?
ment, adds it to this, and returns a new Rationalobject.
There are several ways to add fractions. You can use any one you want, but you
should make sure that the result of the operation is reduced so that the numera?
tor and denominator have no common divisor (other than 1).
The purpose of this exercise is to write a class definition that includes a variety of
methods, including constructors, static methods, instance methods, modifiers, and
pure methods.
 */
import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
import java.math.BigInteger;
public class RationalNumber{


public static void main(String[] args) {
    Rational number = new Rational(2, 3);
    number.printRational();
    String s = number.toString();
    System.out.println(s);
    
    number.negate();
    number.printRational();
    
    number.invert();
    number.printRational();
    
   
    System.out.println(number.toDouble());
    
    Rational num = new Rational(8, 12);
    int [] numberReduced = num.reduce();
    num.numerator = numberReduced[0];
    num.denominator = numberReduced[1];
    num.printRational();
    
    Rational num2 = new Rational(9, 12);
    Rational num3 = new Rational(7, 8);
    Rational sum  = num2.add(num3);
    sum.printRational();
   

}

static class Rational{
    private int numerator;
    private int denominator;
    
    
        public Rational(){
        this.numerator = 0;
        this.denominator = 1;
    }
        
    public Rational(int numerator, int denominator){
        this.numerator = numerator;
        this.denominator = denominator;
    }
    
 
        public void setNumerator(int numerator){
        this.numerator = numerator;
    }
           public int getNumerator(){
        return this.numerator;
    }
        
                public void setDenominator(int denominator){
        this.denominator = denominator;
    }    
    public int getDenominator(){
        return this.denominator;
    }

    
    public void printRational()
    {
        String ratio = String.format(this.numerator + "/" + this.denominator);
        System.out.println(ratio);
    }
    
        
    public String toString()
    {
        String ratio = String.format(this.numerator + "/" + this.denominator);
        return ratio;
    }
    
    public void negate(){
        this.numerator *= -1;
        this.denominator *= -1;
    }
        public void invert(){
        int temp = this.numerator;
        this.numerator = this.denominator;
        this.denominator = temp;
    }
    
        public double toDouble(){
            return (this.numerator * 1.0) / (this.denominator * 1.0);
        }

        public int[] reduce(){
            int a = this.denominator;
            int b = this.numerator;
            int remainder = -1;
            while(true){      // We use Euclidian's algorithm to find the GCD
                remainder = a % b;
                a = b;
                b = remainder;
                if(remainder == 0)
                {
                    remainder = a;
                    break;
                }
              
            }
            // I had to remake the method to return two ints to be used in the add method
           // System.out.println("The lowest of the ration is: "
                            //     + this.numerator / remainder + "/"  + this.denominator / remainder);
            return new int[]{this.numerator / remainder,  this.denominator / remainder};
        }
        
        
               public Rational add(Rational that){
                   int numerator = 0;
                   int denominator = 0;
                   if(this.denominator < that.denominator){ // we have to find out which
                        int a = this.denominator ;      // denominator is bigger
                        int b = that.denominator;
            
                   int remainder = -1;
            while(true){
                remainder = a % b;
                a = b;
                b = remainder;
                if(remainder == 0)
                {
                    remainder = a;
                    break;
                }
              
            }
            int firstMultiplier = (this.denominator / remainder);
            int secondMultiplier = (that.denominator / remainder);
            numerator = (secondMultiplier * this.numerator) + (firstMultiplier  * that.numerator);
            
            denominator = (secondMultiplier * this.denominator);
       
                   }
                   else{
                            int a = that.denominator ;
                        int b = this.denominator;
            
                   int remainder = -1;
            while(true){
                remainder = a % b;
                a = b;
                b = remainder;
                if(remainder == 0)
                {
                    remainder = a;
                    break;
                }
              
            }
            int firstMultiplier = (this.denominator / remainder);
            int secondMultiplier = (that.denominator / remainder);
            numerator = (secondMultiplier * this.numerator) + (firstMultiplier  * that.numerator);
            
            denominator = (secondMultiplier * this.denominator);
                   }
                   
                   Rational newRation = new Rational(numerator, denominator);
                   int[] arr = newRation.reduce();
                   
           return new Rational(arr[0], arr[1]);
        }
}

}