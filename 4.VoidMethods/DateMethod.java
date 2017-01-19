/**Exercise 4-3.
The purpose of this exercise is to take code from a previous exercise and encapsulate
it in a method that takes parameters. You should start with a working solution to
Exercise 2-2.
1. Write a method called printAmerican that takes the day, date, month and year as
parameters and that displays them in American format.
2. Test your method by invoking it from  mainand passing appropriate arguments.
The output should look something like this (except that the date might be differ?
ent):
Saturday, July 22, 2015
3. Once you have debugged  printAmerican, write another method called
printEuropeanthat displays the date in European format.
 */
public class DateMethod {
    public static void printAmerican (int date, String day, String month, int year){
        System.out.println(" " + day + ", " + month + " " + date + ", " + year);
    }
    public static void printEuropean (int date, String day, String month, int year){
          System.out.println(day + " " + date + " " + month + " " + year);
    }
    public static void main (String[] args) {
                int date;
        String month;
        String day;
        int year;
        day = "Thursday";
        date = 27;
        month = "October";
        year = 2016;
        printAmerican(date, day, month, year);
        printEuropean(date, day, month, year);
    }
}
        