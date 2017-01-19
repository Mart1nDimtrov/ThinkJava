/**
 * Exercise 2-3.
 The point of this exercise is to (1) use some of the arithmetic operators, and (2) start
 thinking about compound entities (like time of day) that are represented with multi‐
 ple values.
 1. Create a new program called Time.java. From now on, we won’t remind you to
 start with a small, working program, but you should.
 2. Following the example program in  “Printing Variables”  on page  16, create vari‐
 ables named  hour,  minute, and  second. Assign values that are roughly the cur‐
 rent time. Use a 24-hour clock so that at 2pm the value of houris 14.
 3. Make the program calculate and display the number of seconds since midnight.
 4. Calculate and display the number of seconds remaining in the day.
 5. Calculate and display the percentage of the day that has passed. You might run
 into problems when computing percentages with integers, so consider using
 floating-point.
 6. Change the values of hour,  minute, and  secondto reflect the current time. Then
 write code to compute the elapsed time since you started working on this exer‐
 cise.
 Hint:You might want to use additional variables to hold values during the computa‐
 tion. Variables that are used in a computation but never displayed are sometimes
 called “intermediate” or “temporary” variables.
 * Created by martin on 27.10.2016 г..
 */
public class Time {
    public static void main(String[] args) {
            int hour;
        int minutes;
        int seconds;
        hour = 22;
        minutes = 5;
        seconds = 40;

        int secondsSinceMidnight = (hour * 3600) + (minutes * 60) + seconds;
        System.out.println("Seconds since midnight:");
        System.out.println(secondsSinceMidnight);

        double percentegeOfDay = (secondsSinceMidnight) / (24.0 * 3600.0);
        System.out.println("Percentage of the day left:");
        System.out.println(percentegeOfDay);

        System.out.println("Seconds left in the day:");
        System.out.println((24.0 * 3600.0) - secondsSinceMidnight);

        int tempHour = hour;
        int tempMinutes = minutes;
        int tempSeconds = seconds;

        hour = 22;
        minutes = 21;
        seconds = 47;
        int hourDifference = hour - tempHour;
        int minutesDifference = minutes - tempMinutes;
        int secondsDifference = seconds % tempSeconds;

        System.out.println("Elapsed time:");
        System.out.println(hourDifference + " " + minutesDifference + " " + secondsDifference);



    }
}
