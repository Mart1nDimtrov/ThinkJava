/**
 * Exercise 10-4.
You might be sick of the factorial method by now, but we’re going to do one more
version.
1. Create a new program called Big.javaand write (or reuse) an iterative version of
factorial.
2. Display a table of the integers from 0 to 30 along with their factorials. At some
point around 15, you will probably see that the answers are not right anymore.
Why not?
3. BigIntegeris a Java class that can represent arbitrarily big integers. There is no
upper bound except the limitations of memory size and processing speed. Take a
minute to read the documentation, which you can find by doing a web search for
“Java BigInteger”.
4. To use BigIntegers, you have to import  java.math.BigInteger  at the beginning
of your program.
5. There are several ways to create a BigInteger, but the simplest uses valueOf. The
following code converts an integer to a BigInteger:
int x = 17;
BigInteger big = BigInteger.valueOf(x);
6. Since BigIntegers are not primitive types, the usual math operators don’t work.
Instead, we have to use methods like  add. To add two BigIntegers, invoke  add  on
one and pass the other as an argument.
BigInteger small = BigInteger.valueOf(17);
BigInteger big = BigInteger.valueOf(1700000000);
BigInteger total = small.add(big);
Try out some of the other methods, like multiplyand pow.
7. Convert  factorialso that it performs its calculation using BigIntegers and
returns a BigInteger as a result. You can leave the parameter alone; it will still be
an integer.
8. Try displaying the table again with your modified factorial method. Is it correct
up to 30? How high can you make it go?
9. Are BigInteger objects mutable or immutable? How can you tell?
 */
import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
import java.math.BigInteger;
public class Big{
     public static void findFactorial (int number){
        BigInteger factorial = BigInteger.valueOf(number);
        
        if (number == 0)
        {
            System.out.println("0" + " " + "0");
        }
        else if (number == 2)
        {
            System.out.println("2" + " " + "2");
        }
        else {
             for(int i = number - 1; i > 0; i--){ 
             BigInteger newMultiplier =  BigInteger.valueOf(i); // we have to pass one 
             BigInteger  result = factorial.multiply(newMultiplier); // variable to another to
             factorial = result;                          // to multiply the factorial every time
        }
          System.out.println(number + " " + factorial);
   
        }
        
     
    }

  
public static void main(String[] args) {
    
     Scanner in = new Scanner(System.in);
     System.out.println("Displaying the histogram for factorials from one to 30:");
    
    for(int i = 0; i < 31; i++)
    {
        findFactorial(i);
    }
    
}
}