/**
Exercise B-2.
Modify Mickey.javato draw ears on the ears, and ears on those ears, and more ears
all the way down until the smallest ears are only 3 pixels wide.
The result should look like “Mickey Moose”, shown in  Figure B-4.  Hint:  You should
only have to add or modify a few lines of code.
 */
import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Rectangle;

public class MickeyMoose extends Canvas {


     public  void boxOval(Graphics g, Rectangle bb) {
     g.setColor(Color.red);
     
}
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("My Drawing");
        Canvas canvas = new MickeyMoose();
        canvas.setSize(600, 600);
        canvas.setBackground(Color.white);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
           
    }
    
     public void paint(Graphics g) {
        g.setColor(Color.gray);
     Rectangle rect = new Rectangle(200, 200, 200, 200);
     g.fillOval(rect.x, rect.y, rect.width, rect.height);
     int dx = rect.width / 2;
     int dy = rect.height / 2;
     Rectangle half = new Rectangle(rect.x, rect.y, dx, dy);
     half.translate(-dx / 2, -dy / 2);
     g.fillOval(half.x, half.y, half.width, half.height);
     half.translate(dx * 2, 0);
     g.fillOval(half.x, half.y, half.width, half.height);
     

    }

 
}
