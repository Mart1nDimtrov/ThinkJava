/**
Exercise 7-6.
One way to evaluate exp(-x^2) is to use the infinite series expansion:
 exp(-x^2) = 1 - x^2 + x^4 / 2 - x^6 / 6 + 
The  ith term in this series is  (-1)^i * x^2i/i.
Write a method named  gausst hat takes  x
and n as arguments and returns the sum of the first nterms of the series. You should
not use factorialor pow.
 */

import java.util.Scanner;
public class FindGauss{
    
        public static double findPower (double number, double power){
        double numberRaised = number;
        for(int i = 0; i < power - 1; i++){
            numberRaised *= number;
        }
        return numberRaised;

    }
    
    public static void findGauss (double x, double n){
        double exponent = 0.0;
        double factorial = 1;
        double power = 2;
        double numberRaised = 0.0;
        for(int i = 1; i <= n; i++){ 
            factorial *= i;
            numberRaised = findPower(x, power); // we need the findPower function
            if (i == 1)                         // for this one or raising it by too
            {                                   // would be too lenghty
                exponent += 1 - numberRaised;
            }
            else {
                    if (i % 2 == 0){
                exponent += numberRaised / factorial;
            }
            else if(i % 2 == 1){
                exponent -= numberRaised / factorial;
            }
            }
      power += 2; // increase the power with 2 every time
        }
        System.out.println("The gauss of " + x + " is:");
        System.out.println(exponent);
       // System.out.println(x + "    " + exponent + "    " + Math.exp(x) );
       // Check it against the Math.exp() function
    }
    
public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Please enter the numbers x and and n on seperate lines:");
    double x = in.nextDouble();
    double n = in.nextDouble();
    
    findGauss(x, n);
    
}
}