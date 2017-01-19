/**
Exercise 13-3.
The goal of this exercise is to implement the sorting algorithms from this chapter. Use
the Deck.javafile from the previous exercise (or create a new one from scratch).
1. Write a method called  indexLowest that uses the  compareCard  method to find
the lowest card in a given range of the deck (from  lowIndexto  highIndex,
including both).
2. Write a method called  selectionSort that implements the selection sort algo?
rithm in “Selection Sort” on page 177.
3. Using the pseudocode in  “Merge Sort” on page  178, write the method called
merge. The best way to test it is to build and shuffle a deck. Then use  subdeck  to
form two small subdecks, and use selection sort to sort them. Then you can pass
the two halves to merge to see if it works.
4. Write the simple version of mergeSort, the one that divides the deck in half, uses
selectionSort to sort the two halves, and uses  mergeto create a new, sorted
deck.
5. Write a recursive version of  mergeSort. Remember that  selectionSort is a
modifier and  mergeSortis a pure method, which means that they get invoked
differently:
deck.selectionSort();  // modifies an existing deck
deck = deck.mergeSort();  // replaces old deck with new
 */

import java.util.Arrays;
import java.util.Random;

public class SelectionSort{
    
    
    public static void main(String[] args) {
        
        Deck cards = new Deck();
        int choice = cards.randomInt(5, 10);
        System.out.println(choice);  
        System.out.println(cards); 
        
        cards.swapCards(0, 51);
        System.out.println(cards); 
        
        cards.shuffle();
        System.out.println(cards); 
        
        System.out.println(cards.indexLowest(0, 51));
        cards.selectionSort();
        System.out.println(cards); 
       
        
        Deck firstHalf = cards.subdeck(0 , cards.cards.length / 2 - 1);
        Deck secondHalf = cards.subdeck(cards.cards.length / 2, 51);
        System.out.println(firstHalf); 
        System.out.println(secondHalf); 
     
      Deck merged = cards.merge(firstHalf, secondHalf); // the cards have to be sorted for 
      System.out.println(merged);                 // the algorithm to work
      System.out.println(merged.cards.length);
        
        cards.mergeSort();
        
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
        int lowestIndex = low;
        for(int i = low + 1; i <= high; i++)
        {
            if(this.cards[i].compareTo(this.cards[lowestIndex]) == -1)
            {
                lowestIndex = i;
            }
        }
        return lowestIndex;
    }

    /**
     * Sorts the cards (in place) using selection sort.
     */
    public void selectionSort() {
         for (int i = 0; i < this.cards.length; i++) {
           int indexLow = indexLowest(i, this.cards.length - 1);
           this.swapCards(i, indexLow); 
        }
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
        Deck mergedCards = new Deck(d1.cards.length + d2.cards.length);
        
        int i = 0;
        int j = 0;
        d1.selectionSort();
        d2.selectionSort();
        for(int k = 0; k < mergedCards.cards.length; k++)
        {
            if (i >= d1.cards.length)
            {
                   int tempSecondRank = d2.cards[j].getRank();
        
                 int tempSecondSuit = d2.cards[j].getSuit();
        
                 mergedCards.cards[k] = new Card(tempSecondRank, tempSecondSuit);
                 j++; 
          
             
            }
           else if(j >= d2.cards.length)
           {
                    int tempFirstRank = d1.cards[i].getRank();
        
                 int tempFirstSuit = d1.cards[i].getSuit();
        
                 mergedCards.cards[k] = new Card(tempFirstRank, tempFirstSuit);
                 i++; 
                 
        
           }
           else {
               
            if (d1.cards[i].compareTo(d2.cards[j]) == -1)
            {
                        int tempFirstRank = d1.cards[i].getRank();
        
                 int tempFirstSuit = d1.cards[i].getSuit();
        
                 mergedCards.cards[k] = new Card(tempFirstRank, tempFirstSuit);
                 i++;
              
        
            }
            else if(d1.cards[i].compareTo(d2.cards[j]) == 1){
                   int tempSecondRank = d2.cards[j].getRank();
        
                 int tempSecondSuit = d2.cards[j].getSuit();
        
                 mergedCards.cards[k] = new Card(tempSecondRank, tempSecondSuit);
                 j++; 
            }
          /**  else{
                  int tempFirstRank = d1.cards[i].getRank();
        
                 int tempFirstSuit = d1.cards[i].getSuit();
        
                 mergedCards.cards[k] = new Card(tempFirstRank, tempFirstSuit);
                 i++;
                  int tempSecondRank = d2.cards[j].getRank();
        
                 int tempSecondSuit = d2.cards[j].getSuit();
        
                 mergedCards.cards[k] = new Card(tempSecondRank, tempSecondSuit);
                 j++;
            } */
           }
            
        }
        
        return mergedCards;
    }

    /**
     * Returns a sorted copy of the deck using merge sort.
     */
    public Deck mergeSort() {
        if (this.cards.length <= 1)
        {
           return this;
        }
        Deck firstHalf = this.subdeck(0 , this.cards.length / 2 - 1);
        Deck secondHalf = this.subdeck(this.cards.length / 2, 51);
        Deck merged = this.merge(firstHalf, secondHalf);
        this.cards = merged.cards;
        return this;
    }

    /**
     * Reorders the cards (in place) using insertion sort.
     */
    public void insertionSort() {
    }

}

   
}