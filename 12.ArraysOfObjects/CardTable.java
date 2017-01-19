/**
Exercise 12-4.
Working with cards is more interesting if you can display them on the screen. If you
have not already read Appendix B about 2D graphics, you should read it before work?
ing on this exercise. In the code directory for this chapter, ch12, you will find:
• cardset-oxymoron: A directory containing images of playing cards.
• CardTable.java: A sample program that demonstrates how to read and display
images.
This code demonstrates the use of a 2D array, specifically an array of images. The
declaration looks like this:
private Image[][] images;
The variable  imagesrefers to a 2D array of  Imageobjects, which are defined in the
java.awtpackage. Here’s the code that creates the array itself:
images = new Image[14][4];
The array has 14 rows (one for each rank plus an unused row for rank 0) and 4 col?
umns (one for each suit). Here’s the loop that populates the array:
String cardset = "cardset-oxymoron";
String suits = "cdhs";
for (int suit = 0; suit <= 3; suit++) {
char c = suits.charAt(suit);
for (int rank = 1; rank <= 13; rank++) {
String s = String.format("%s/%02d%c.gif",
cardset, rank, c);
images[rank][suit] = new ImageIcon(s).getImage();
}
}
The variable cardset contains the name of the directory that contains the image files.
suitsis a string that contains the single-letter abbreviations for the suits. These
strings are used to assemble s, which contains the filename for each image. For exam?
ple, when rank=1and suit=2, the value of  s  is  "cardset-oxymoron/01h.gif", which
is an image of the Ace of Hearts.
The last line of the loop reads the image file, extracts an Image  object, and assigns it
to a location in the array, as specified by the indexes rankand suit. For example, the
image of the Ace of Hearts is stored in row 1, column 2.
If you compile and run  CardTable.java, you should see images of a deck of cards
laid out on a green table. You can use this class as a starting place to implement your
own card games.
 */

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class CardTable extends Canvas {

    private Image[][] images;
    private int cardWidth, cardHeight;

    /**
     * Creates a CardTable.
     * cardset is the name of the folder that contains the card images.
     */
    public CardTable(String cardset) {
        setBackground(new Color(0x088A4B));

        // create a 2-D array of card images
        images = new Image[14][4];
        String suits = "cdhs";

        for (int suit = 0; suit <= 3; suit++) {
            char c = suits.charAt(suit);

            for (int rank = 1; rank <= 13; rank++) {
                String s = String.format("%s/%02d%c.gif",
                                         cardset, rank, c);
                images[rank][suit] = new ImageIcon(s).getImage();
            }
        }

        // get the width and height of the cards and set the size of
        // the frame accordingly
        cardWidth = images[1][1].getWidth(null);
        cardHeight = images[1][1].getHeight(null);

        // set the size temporarily to get the insets
        setTableSize(14, 4);
    }

    /**
     * Sets the table size.
     * x and y are in units of card width/height.
     */
    public void setTableSize(double x, double y) {
        setSize((int) (x * cardWidth),
                (int) (y * cardHeight));
    }

    /**
     * Draws a card at the given coordinates.
     * x and y are in units of card width/height.
     */
    public void drawCard(Graphics g, int rank, int suit, double x, double y) {
        Image image = images[rank][suit];
        g.drawImage(image,
                    (int) (x * cardWidth),
                    (int) (y * cardHeight),
                    null);
    }

    /**
     * Special method invoked when the Frame needs to be drawn.
     */
    public void paint(Graphics g) {
        for (int rank = 1; rank <= 13; rank++) {
            for (int suit = 0; suit <= 3; suit++) {
                double x = rank - 1 + suit / 5.0;
                double y = suit / 2.0;
                drawCard(g, rank, suit, x, y);
            }
        }
    }

    public static void main(String[] args) {
        // make the frame
        JFrame frame = new JFrame("Card Table");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // add the CardTable
        String cardset = "cardset-oxymoron";
        Canvas canvas = new CardTable(cardset);
        frame.getContentPane().add(canvas);

        // show the frame
        frame.pack();
        frame.setVisible(true);
    }

}