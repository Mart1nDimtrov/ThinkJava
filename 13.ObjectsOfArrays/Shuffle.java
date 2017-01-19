/**
 Exercise 13-2.
The goal of this exercise is to implement the shuffling algorithm from this chapter.
1. In the repository for this book, you should find a file called  Deck.java  that con?
tains the code in this chapter. Check that you can compile it in your environ?
ment.
2. Add a Deck method called randomInt that takes two integers,  lowand  high, and
returns a random integer between lowand high, including both. You can use the
nextInt provided by  java.util.Random, which we saw in  “Random Numbers”
on page  108. But you should avoid creating a  Randomobject every time  random
Intis invoked.
3. Write a method called swapCards that takes two indexes and swaps the cards at
the given locations.
4. Write a method called  shuffle that uses the algorithm in  “Shuffling Decks”  on
page 176.
 */

import java.util.Arrays;
import java.util.Random;

public class Shuffle{
    
    
    public static void main(String[] args) {
        
        Deck cards = new Deck();
        int choice = cards.randomInt(5, 10);
        System.out.println(choice);  
        System.out.println(cards); 
        
        cards.swapCards(0, 51);
        System.out.println(cards); 
        
        cards.shuffle();
        System.out.println(cards); 
    }
    
    static class Card {
    public static final String[] RANKS = {
        null, "Ace", "2", "3", "4", "5", "6", "7",
        "8", "9", "10", "Jack", "Queen", "King"};
    public static final String[] SUITS = {
        "Clubs", "Diamonds", "Hearts", "Spades"};
    
    
    private int rank;
    private int suit;
    
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
    
    /**
 * A deck of playing cards (of fixed size).
 */
static class Deck {

    private Card[] cards;

    /**
     * Constructs a standard deck of 52 cards.
     */
    public Deck() {
        this.cards = new Card[52];
        int index = 0;
        for (int suit = 0; suit <= 3; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                this.cards[index] = new Card(rank, suit);
                index++;
            }
        }
    }

    /**
     * Constructs a deck of n cards (null).
     */
    public Deck(int n) {
        this.cards = new Card[n];
    }

    /**
     * Gets the internal cards array.
     */
    public Card[] getCards() {
        return this.cards;
    }

    /**
     * Displays each of the cards in the deck.
     */
    public void print() {
        for (int i = 0; i < this.cards.length; i++) {
            System.out.println(this.cards[i]);
        }
    }

    /**
     * Returns a string representation of the deck.
     */
    public String toString() {
        return Arrays.toString(this.cards);
    }

    /**
     * Chooses a random number between low and high, including both.
     */
    public int randomInt(int low, int high) {
        Random random = new Random();
        int randNumber = low + (int)(Math.random() * ((high - low) + 1));
        return randNumber;
    }

    /**
     * Swaps the cards at indexes i and j.
     */
    public void swapCards(int i, int j) {
        int tempFirstRank = this.cards[i].getRank();
        int tempSecondRank = this.cards[j].getRank();
        int tempFirstSuit = this.cards[i].getSuit();
        int tempSecondSuit = this.cards[j].getSuit();
        
         this.cards[i] = new Card(tempSecondRank, tempSecondSuit);
         this.cards[j] = new Card(tempFirstRank, tempFirstSuit);
        
    }

    /**
     * Randomly permutes the array of cards.
     */
    public void shuffle() {
        
        for (int i = 0; i < cards.length; i++)
        {
           int randomPos = this.randomInt(0, cards.length - 1); // Choose a random number
           this.swapCards(i, randomPos);                        // between 0 and the last element element
          // swap the card at the current position with a random one
        }   
    }

    /**
     * Finds the index of the lowest card
     * between low and high inclusive.
     */
    public int indexLowest(int low, int high) {
        return 0;
    }

    /**
     * Sorts the cards (in place) using selection sort.
     */
    public void selectionSort() {
    }

    /**
     * Returns a subset of the cards in the deck.
     */
    public Deck subdeck(int low, int high) {
        Deck sub = new Deck(high - low + 1);
        for (int i = 0; i < sub.cards.length; i++) {
            sub.cards[i] = this.cards[low + i];
        }
        return sub;
    }

    /**
     * Combines two previously sorted subdecks.
     */
    public static Deck merge(Deck d1, Deck d2) {
        return null;
    }

    /**
     * Returns a sorted copy of the deck using merge sort.
     */
    public Deck mergeSort() {
        return this;
    }

    /**
     * Reorders the cards (in place) using insertion sort.
     */
    public void insertionSort() {
    }

}

   
}