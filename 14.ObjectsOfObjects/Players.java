/**
Exercise 14-3.
One limitation of the program we wrote in this chapter is that it only handles two
players. Modify the Eights class to create an  ArrayList of players, and modify  next
Playerto select the next player.
 */


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
/**
 * Test code for Deck and Hand.
 */
public class Players {

    public static void main(String[] args) {
 
         Eights game = new Eights(3);
        for(int i = 0; i < 100; i++)
        {
           
            Deck deck = new Deck("Deck");
            deck.shuffle();
            game.playGame();
        }
        

    }

static class Player {

    public String name;
    public Hand hand;

    /**
     * Constructs a player with an empty hand.
     */
    public Player(String name) {
        this.name = name;
        this.hand = new Hand(name);
    }

    /**
     * Gets the player's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the player's hand.
     */
    public Hand getHand() {
        return hand;
    }

    /**
     * Removes and returns a legal card from the player's hand.
     */
    public Card play(Eights eights, Card prev) {
        Card card = searchForMatch(prev);
        if (card == null) {
            card = drawForMatch(eights, prev);
        }
        return card;
    }

    /**
     * Searches the player's hand for a matching card.
     */
    public Card searchForMatch(Card prev) {
        for (int i = 0; i < hand.size(); i++) {
            Card card = hand.getCard(i);
            if (cardMatches(card, prev)) {
                return hand.popCard(i);
            }
        }
        return null;
    }

    /**
     * Draws cards until a match is found.
     */
    public Card drawForMatch(Eights eights, Card prev) {
        while (true) {
            Card card = eights.draw();
            System.out.println(name + " draws " + card);
            if (cardMatches(card, prev)) {
                return card;
            }
            hand.addCard(card);
        }
    }

    /**
     * Checks whether two cards match.
     */
    public static boolean cardMatches(Card card1, Card card2) {
        if (card1.getSuit() == card2.getSuit()) {
            return true;
        }
        if (card1.getRank() == card2.getRank()) {
            return true;
        }
        if (card1.getRank() == 8) {
            return true;
        }
        return false;
    }

    /**
     * Calculates the player's score (penalty points).
     */
    public int score() {
        int sum = 0;
        for (int i = 0; i < hand.size(); i++) {
            Card card = hand.getCard(i);
            int rank = card.getRank();
            if (rank == 8) {
                sum -= 20;
            } else if (rank > 10) {
                sum -= 10;
            } else {
                sum -= rank;
            }
        }
        return sum;
    }

    /**
     * Displays the player's hand.
     */
    public void display() {
        hand.display();
    }

    /**
     * Displays the player's name and score.
     */
    public void displayScore() {
        System.out.println(name + " has " + score() + " points");
    }

}

/**
 * Simulates a game of Crazy Eights.  See
 * https://en.wikipedia.org/wiki/Crazy_Eights
 * for basic play and scoring rules.
 */
static class Eights {

    Player [] players;
    private Hand drawPile;
    private Hand discardPile;
    private Scanner in;
    private int firstScore;
    private int secondScore;

    /**
     * Initializes the state of the game.
     */
    public Eights(int count) {
        Deck deck = new Deck("Deck");
        deck.shuffle();
        String[] playerNames = {"Allen", "Steve", "Martin", "John"};
        for (int i = 0; i < count; i++)
        {
            // deal cards to each player
            int handSize = 5;
            players[i] = new Player(playerNames[i]);
            deck.deal(players[i].getHand(), handSize);
        }

        // turn one card face up
        discardPile = new Hand("Discards");
        deck.deal(discardPile, 1);

        // put the rest of the deck face down
        drawPile = new Hand("Draw pile");
        deck.dealAll(drawPile);

        // create the scanner we'll use to wait for the user
        in = new Scanner(System.in);
    }

    /**
     * Returns true if either hand is empty.
     */
    public boolean isDone() {
      boolean  flag = false;
        for(int i = 0; i < players.length; i++)
        {
            if(players[i].getHand().empty())
            {
                flag = true;
            }
        }
        return flag;
    }

    /**
     * Moves cards from the discard pile to the draw pile and shuffles.
     */
    public void reshuffle() {
        // save the top card
        Card prev = discardPile.popCard();

        // move the rest of the cards
        discardPile.dealAll(drawPile);

        // put the top card back
        discardPile.addCard(prev);

        // shuffle the draw pile
        drawPile.shuffle();
    }

    /**
     * Returns a card from the draw pile.
     */
    public Card draw() {
        if (drawPile.empty()) {
            reshuffle();
        }
        return drawPile.popCard();
    }

    /**
     * Switches players.
     */
    public Player nextPlayer(int turn) {
       return players[turn];
    }

    /**
     * Displays the state of the game.
     */
    public void displayState() {
        for (int i = 0; i <  players.length; i++)
        {
            players[i].display();
       
        }
        discardPile.display();
        System.out.print("Draw pile: ");
        System.out.println(drawPile.size() + " cards");
    }

    /**
     * Waits for the user to press enter.
     */
    public void waitForUser() {
        in.nextLine();
    }

    /**
     * One player takes a turn.
     */
    public void takeTurn(Player player) {
        Card prev = discardPile.last();
        Card next = player.play(this, prev);
        discardPile.addCard(next);

        System.out.println(player.getName() + " plays " + next);
        System.out.println();
    }

    /**
     * Plays the game.
     */
    public void playGame() {
        Player player = players[0];
        int turn = 0;
        // keep playing until there's a winner
        while (!isDone()) {
            displayState();
            waitForUser();
            takeTurn(player);
            player = nextPlayer(turn % players.length);
            turn++;
        }

        // display the final score
          for(int i = 0; i < players.length; i++)
        {
           players[i].displayScore();
        }
    
    }
    
                       
    }


/**
 * A hand of playing cards.
 */
static class Hand extends CardCollection {

    /**
     * Constructs an empty hand.
     */
    public Hand(String label) {
        super(label);
    }

    /**
     * Prints the label and cards.
     */
    public void display() {
        System.out.println(getLabel() + ": ");
        for (int i = 0; i < size(); i++) {
            System.out.println(getCard(i));
        }
        System.out.println();
    }

}

/**
 * A deck of playing cards.
 */
static class Deck extends CardCollection {

    /**
     * Constructs a standard deck of 52 cards.
     */
    public Deck(String label) {
        super(label);

        for (int suit = 0; suit <= 3; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                addCard(new Card(rank, suit));
            }
        }
    }

}


/**
 * A collection of playing cards.
 */
static class CardCollection {

    private String label;
    private ArrayList<Card> cards;

    /**
     * Constructs an empty collection.
     */
    public CardCollection(String label) {
        this.label = label;
        this.cards = new ArrayList<Card>();
    }

    /**
     * Returns the label of the card collection.
     */
    public String getLabel() {
        return label;
    }

    /**
     * Adds the given card to the collection.
     */
    public void addCard(Card card) {
        cards.add(card);
    }

    /**
     * Removes and returns the card with the given index.
     */
    public Card popCard(int i) {
        return cards.remove(i);
    }

    /**
     * Removes and returns the last card.
     */
    public Card popCard() {
        int i = size() - 1;
        return popCard(i);
    }

    /**
     * Returns the number of cards.
     */
    public int size() {
        return cards.size();
    }

    /**
     * True if the collection is empty, false otherwise.
     */
    public boolean empty() {
        return cards.size() == 0;
    }

    /**
     * Moves n cards from this collection to the given collection.
     */
    public void deal(CardCollection that, int n) {
        for (int i = 0; i < n; i++) {
            Card card = popCard();
            that.addCard(card);
        }
    }

    /**
     * Moves all remaining cards to the given collection.
     */
    public void dealAll(CardCollection that) {
        int n = size();
        deal(that, n);
    }

    /**
     * Returns the card with the given index.
     */
    public Card getCard(int i) {
        return cards.get(i);
    }

    /**
     * Returns the last card.
     */
    public Card last() {
        int i = size() - 1;
        return cards.get(i);
    }

    /**
     * Swaps the cards at indexes i and j.
     */
    public void swapCards(int i, int j) {
        Card temp = cards.get(i);
        cards.set(i, cards.get(j));
        cards.set(j, temp);
    }

    /**
     * Randomly permute the cards.
     */
    public void shuffle() {
        Random random = new Random();
        for (int i = size() - 1; i > 0; i--) {
            int j = random.nextInt(i);
            swapCards(i, j);
        }
    }

    /**
     * Returns a string representation of the card collection.
     */
    public String toString() {
        return label + ": " + cards.toString();
    }

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

    static class BestPlayer extends Player{
       
        
        public BestPlayer(String name) {
            super(name);
            
        }
        

    /**
     * Removes and returns a legal card from the player's hand.
     */
    public Card play(Eights eights, Card prev) {
        Card card = searchForMatch(prev);
        if (card == null) {
            card = drawForMatch(eights, prev);
        }
        return card;
    }

    /**
     * Searches the player's hand for a matching card.
     */
    public Card searchForMatch(Card prev) {
        int max = -1;
        for (int i = 0; i < this.hand.size(); i++) {
            Card card = this.hand.getCard(i);
            if (cardMatches(card, prev) && card.rank == 8) {
                max = i;
            }
        }
        if(max != -1)
        {
           return hand.popCard(max);
        }
               else{
                   boolean first = false;
                   Card temp = new Card(0, 0); // we have to have values in temp
                    for (int i = 1; i < this.hand.size(); i++) {
            Card card = this.hand.getCard(i);
            if (cardMatches(card, prev) && first == false) {
                max = i;
               first = true;
               temp = card; // temp gets assigned only if it matches a card 
            }
            else if (cardMatches(card, prev) && first == true && card.rank > temp.rank)
            {
                temp = card;
                max = i;
            }
                
        }   
        }
            
        if(max != -1)
        {
           return hand.popCard(max);
        }
        
        return null;
    }

    /**
     * Draws cards until a match is found.
     */
    public Card drawForMatch(Eights eights, Card prev) {
        while (true) {
            Card card = eights.draw();
            System.out.println(name + " draws " + card);
            if (cardMatches(card, prev)) {
                return card;
            }
            hand.addCard(card);
        }
    }

    /**
     * Checks whether two cards match.
     */
    public static boolean cardMatches(Card card1, Card card2) {
        if (card1.getSuit() == card2.getSuit()) {
            return true;
        }
        if (card1.getRank() == card2.getRank()) {
            return true;
        }
        if (card1.getRank() == 8) {
            return true;
        }
        return false;
    }

    /**
     * Calculates the player's score (penalty points).
     */
    public int score() {
        int sum = 0;
        for (int i = 0; i < hand.size(); i++) {
            Card card = hand.getCard(i);
            int rank = card.getRank();
            if (rank == 8) {
                sum -= 20;
            } else if (rank > 10) {
                sum -= 10;
            } else {
                sum -= rank;
            }
        }
        return sum;
    }

    }
}
