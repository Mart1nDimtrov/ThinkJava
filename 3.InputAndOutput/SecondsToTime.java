/**
 * Created by martin on 30.10.2016 г..
 * Exercise 3-3.
 Write a program that converts a total number of seconds to hours, minutes, and sec‐
 onds. It should (1) prompt the user for input, (2) read an integer from the keyboard,
 (3) calculate the result, and (4) use  printfto display the output. For example,  "5000
 seconds = 1 hours, 23 minutes, and 20 seconds".
 Hint:Use the modulus operator.
 */
import java.util.Scanner;
public class SecondsToTime {
    public static void main(String[] args) {
        int secondsInHour = 3600;
        int secondsInMin = 60;
            Scanner in = new Scanner(System.in);
        System.out.print("Please enter the amount of seconds to be converted: ");
        int seconds = in.nextInt();

        int hours = seconds / secondsInHour;
        int minutes = (seconds % secondsInHour) / secondsInMin;
        int secondsLast = (seconds % secondsInHour) % secondsInMin;
        System.out.printf("%d hours %d minutes %d seconds", hours, minutes, secondsLast);


    }
}
