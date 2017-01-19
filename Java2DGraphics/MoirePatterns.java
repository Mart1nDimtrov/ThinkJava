/**
Exercise B-3.
In this exercise, you will draw “Moiré patterns” that seem to shift around as you
move. For an explanation of what is going on, see  https://en.wikipedia.org/wiki/
Moire_pattern.
1. In the directory  app02in the repository for this book, you’ll find a file named
Moire.java. Open it and read the  paintmethod. Draw a sketch of what you
expect it to do. Now run it. Did you get what you expected?
2. Modify the program so that the space between the circles is larger or smaller. See
what happens to the image.
3. Modify the program so that the circles are drawn in the center of the screen and
concentric, as in  Figure B-5(left). The distance between the circles should be
small enough that the Moiré interference is apparent.
4. Write a method named radialthat draws a radial set of line segments as shown
in  Figure B-5(right), but they should be close enough together to create a Moiré
pattern.
5. Just about any kind of graphical pattern can generate Moiré-like interference pat?
terns. Play around and see what you can create. 
 */
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class MoirePatterns extends Canvas {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Moire Pattern");
        Canvas canvas = new Moire();
        canvas.setSize(400, 400);
        canvas.setBackground(Color.white);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
    }

    public void paint(Graphics g) {
        int i = 90;
        while (i < getWidth()) {
            g.drawOval(0, 0, i, i);
            i = i + 3;
        }
    }

}