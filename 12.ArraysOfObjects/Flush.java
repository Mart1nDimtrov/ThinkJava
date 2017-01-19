/**
Exercise 12-3.
In Poker a “flush” is a hand that contains five or more cards of the same suit. A hand
can contain any number of cards.
1. Write a method called suitHist that takes an array of cards as a parameter and
that returns a histogram of the suits in the hand. Your solution should only tra-
verse the array once.
2. Write a method called hasFlushthat takes an array of cards as a parameter and
returns trueif the hand contains a flush (and false or therwise).
 */

import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
import java.math.BigInteger;
public class Flush{
    
    public static Card[] makeDeck(){
          
        Card[] cards = new Card[52];
        int index = 0;
        for (int suit = 0; suit <= 3; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                cards[index] = new Card(rank, suit);
                index++;
            }
        }
        return cards;
    }
    
    public static boolean flush(Card[] hand){
        
        int[] histogram = new int[4];
        boolean check = false;
        for(int i = 0; i < hand.length; i++)
        {
            if(hand[i].suit == 0)
            {
                histogram[0]++;
            }
             if(hand[i].suit == 1)
            {
                histogram[1]++;
            }
              if(hand[i].suit == 2)
            {
                histogram[2]++;
            }
               if(hand[i].suit == 3)
            {
                histogram[3]++;
            }
        }
        
                for(int i = 0; i < histogram.length; i++)
        {
                if(histogram[i] >= 5)
                {
                    check = true;
                }
        }
        
                return check;
        
        
    }
        


public static void main(String[] args) {
    
    Card[] cards = makeDeck();
    
    System.out.println(Arrays.toString(cards));
    
    Card[] hand = {new Card(7, 0), new Card(1, 1), new Card(12, 3), new Card(12, 2)};
    
    if(flush(hand))
    {
        System.out.println("Flush!");
    }
    else{
          System.out.println("No flush. :(");
    }
    
    // System.out.println(hand[1]);

}

static class Card {
    public static final String[] RANKS = {
        null, "Ace", "2", "3", "4", "5", "6", "7",
        "8", "9", "10", "Jack", "Queen", "King"};
    public static final String[] SUITS = {
        "Clubs", "Diamonds", "Hearts", "Spades"};
    
    
    private final int rank;
    private final int suit;
    
    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }
    
    public String toString() {
        return RANKS[this.rank] + " of " + SUITS[this.suit];
    }
    
    public boolean equals(Card that) {
        return this.rank == that.rank
            && this.suit == that.suit;
    }
    
    public int compareTo(Card that) {
        if (this.suit < that.suit) {
            return -1;
        }
        if (this.suit > that.suit) {
            return 1;
        }
        if (this.rank < that.rank) {
            return -1;
        }
        if (this.rank > that.rank) {
            return 1;
        }
        return 0;
    }
    
    public int getRank() {
        return this.rank;
    }
    public int getSuit() {
        return this.suit;
    }
    
}

}