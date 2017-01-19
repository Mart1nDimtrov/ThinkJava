/**
Exercise 11-4.
Write a class definition for  Date, an object type that contains three integers:  year,
month, and  day. This class should provide two constructors. The first should take no
parameters and initialize a default date. The second should take parameters named
year, monthand day, and use them to initialize the instance variables.
Write a main method that creates a new Dateobject named birthday. The new object
should contain your birth date. You can use either constructor.
 */

/**
Exercise 11-3.
In the board game Scrabble, each tile contains a letter, which is used to spell words in
rows and columns, and a score, which is used to determine the value of words.
1. Write a definition for a class named  Tilethat represents Scrabble tiles. The
instance variables should include a character named  letter and an integer
named value.
2. Write a constructor that takes parameters named letter  and  value and initial?
izes the instance variables.
3. Write a method named  printTile that takes a  Tile object as a parameter and
displays the instance variables in a reader-friendly format.
4. Write a method named testTile that creates a  Tile object with the letter  Z  and
the value 10, and then uses printTile to display the state of the object.
5. Implement the toString and equals methods for a Tile.
6. Create getters and setters for each of the attributes.
The point of this exercise is to practice the mechanical part of creating a new class
definition and code that tests it.
 */
import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
import java.math.BigInteger;
public class DateClass{


public static void main(String[] args) {

     Date birthday = new Date(11, 11, 1988);
     String birthDate = String.format("%02d - %02d - %04d", birthday.day, birthday.month, birthday.year);
     System.out.println(birthDate);

}

static class Date{
    private int year;
    private int month;
    private int day;
    
        public Date(){
        this.year = 2016;
        this.month = 6;
        this.day = 23;
    }
    
    public Date(int day, int month, int year){
        this.year = year;
        this.month = month;
        this.day = day;
    }
    
    public int getYear(){
        return this.year;
    }
        public int getMonth(){
        return this.month;
    }
            public int getDay(){
        return this.day;
    }
    
}

}