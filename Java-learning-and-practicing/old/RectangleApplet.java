package old;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JApplet;

public class RectangleApplet extends JApplet{

    public void paint(Graphics g){

        Graphics2D g2 = (Graphics2D)g;
        
        Rectangle box = new Rectangle(5, 10, 20, 20);

        g2.draw(box);

        // move the rectangle - 15 units to the right and 25 units dow
        box.translate(15, 25);

        // we draw again
        g2.draw(box);

    }

    public static void main(String[] args) {
        
    }
}

