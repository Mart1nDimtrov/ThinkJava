/**
Exercise 7-5.
One way to calculate e^x
is to use the infinite series expansion:
e^x = 1 + x + x^2/2! + x^3/3! + x^4/4! + ...
1. Write a method called myexp  that takes xand n  as parameters and estimates e^x
by adding the first n terms of this series. You can use the  factorial  method from
“More Recursion” on page 79 or your iterative version from the previous exer?
cise.
2. You can make this method more efficient if you realize that the numerator of
each term is the same as its predecessor multiplied by  x, and the denominator is
the same as its predecessor multiplied by  i. Use this observation to eliminate the
use of Math.powand factorial, and check that you get the same result.
3. Write a method called check that takes a parameter,  x, and displays  x,  myexp(x),
and Math.exp(x). The output should look something like:
1.0 2.708333333333333 2.718281828459045
You can use the escape sequence "\t"to put a tab character between columns of
a table.
4. Vary the number of terms in the series (the second argument that checksends to
myexp) and see the effect on the accuracy of the result. Adjust this value until the
estimated value agrees with the correct answer when xis 1.
5. Write a loop in mainthat invokes  checkwith the values 0.1, 1.0, 10.0, and 100.0.
How does the accuracy of the result vary as  xvaries? Compare the number of
digits of agreement rather than the difference between the actual and estimated
values.
6. Add a loop in main that checks myexp with the values -0.1, -1.0, -10.0, and -100.0.
Comment on the accuracy.
 */


import java.util.Scanner;
public class FindExponent{
    
    public static void findExponent (double x, double n){
        double exponent = 0.0;
        double factorial = 1;
        double power = x;
        for(int i = 1; i <= n; i++){ 
            factorial *= i;
            if (i == 1)
            {
                exponent += 1 + x;
            }else {
                power *= x;
                exponent += power / factorial;
            }
        }
        System.out.println("The exponent of " + x + " is:");
        System.out.println(exponent);
       // System.out.println(x + "    " + exponent + "    " + Math.exp(x) );
       // Check it against the Math.exp() function
    }
    
public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Please enter the numbers x and and n on seperate lines:");
    double x = in.nextDouble();
    double n = in.nextDouble();
    
    findExponent(x, n);
    
}
}