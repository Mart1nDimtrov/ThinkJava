/**
Exercise 12-2.
In some card games, Aces are ranked higher than Kings. Modify the  compareTo
method to implement this ordering. 
 */
import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
import java.math.BigInteger;
public class ModifyCompare{
    
    public static Card[] makeDeck(){
          
        Card[] cards = new Card[52];
        int index = 0;
        for (int suit = 0; suit <= 3; suit++) {
            for (int rank = 2; rank <= 14; rank++) {
                cards[index] = new Card(rank, suit);
                index++;
            }
        }
        return cards;
    }
        


public static void main(String[] args) {
    
    Card[] cards = makeDeck();
    
    System.out.println(Arrays.toString(cards));

}

static class Card {
    public static final String[] RANKS = {
        null, null, "2", "3", "4", "5", "6", "7",
        "8", "9", "10", "Jack", "Queen", "King", "Ace"};
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