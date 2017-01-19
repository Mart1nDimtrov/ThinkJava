/**
 * Exercise 3-2.
 Write a program that converts a temperature from Celsius to Fahrenheit. It should (1)
 prompt the user for input, (2) read a  doublevalue from the keyboard, (3) calculate
 the result, and (4) format the output to one decimal place. For example, it should dis‐
 play "24.0 C = 75.2 F".
 Here is the formula. Be careful not to use integer division!
 F = (C × 9/5) + 32
 * Created by martin on 30.10.2016 г..
 */
import java.util.Scanner;
public class CelsiusToFahrenheit {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the degrees to be converted: ");
        double degrees = in.nextDouble();
        System.out.println();
        double convertedDegrees = (degrees * (9.0/5.0)) + 32.0;
        System.out.printf("%.1f C = %.1f F", degrees, convertedDegrees);

    }
}
