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
public class ScrabbleObject{
    public static void printTile(Tile tile)
    {
        System.out.println("Tile: " + tile.letter + " Value: " + tile.value);
    }
       public static void testTile()
    {
        Tile tile = new Tile('d', 12);
        System.out.println("Tile: " + tile.letter + " Value: " + tile.value);
    }
 

public static void main(String[] args) {
    Tile firstTile = new Tile('c', 25);
    String s = firstTile.toString();
    System.out.println(s);
    printTile(firstTile);
    testTile();
    Tile secondTile = new Tile('n', 35);
    if(firstTile.equals(secondTile)){
        System.out.println("The two tiles are the same.");
    }
       else{
           System.out.println("The two tiles are not the same.");
       }
       
     

}

static class Tile{
    private char letter;
    private int value;
    
    public Tile(char letter, int value){
        this.letter = letter;
        this.value = value;
    }
    
  
    
    public char getLetter(){
        return this.letter;
    }
    public void setLetter(char letter){
        this.letter = letter;
    }
    
        
    public int getValue(){
        return this.value;
    }
    public void setLetter(int value){
        this.value = value;
    }

    public String toString(){
        return String.format("Tile: " + this.letter + " Value: " + this.value);
    }
    
    public boolean equals(Tile that){
        return this.letter == that.letter &&
            this.value == that.value;
        
}

}
}