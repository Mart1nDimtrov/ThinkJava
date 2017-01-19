/**
Exercise B-1.
Draw the flag of Japan: a red circle on a white background that is wider than it is tall.
 */
import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.Color;

public class FlagJapan extends Canvas {
    public static void main(String[] args) {
        JFrame frame = new JFrame("My Drawing");
        Canvas canvas = new FlagJapan();
        canvas.setSize(400, 400);
        canvas.setBackground(Color.white);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
    }
    public void paint(Graphics g) {
        g.setColor(Color.red);
        g.fillOval(100, 100, 225, 200);
    }
}
