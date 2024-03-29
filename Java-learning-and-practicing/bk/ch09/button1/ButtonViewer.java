import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/** 
 * This program demonstrates how to install an action listener
*/

public class ButtonViewer {
    
    private static final int FRAME_WIDTH = 100;
    private static final int FRAME_HEIGHT = 60;

    public static void main(String[] args){
        JFrame frame = new JFrame();
        JButton button = new JButton("Click me");
        frame.add(button); // add the button to the frame's content pane

        ActionListener listener =  new ClickListener(); // listener = event listener object
        // we could decalre the Clicklistner as an inner class
            // this would be very appropriate
                // I can be able to access some variables, without passing them to the constructor - but it has to be declared "final"-> the surrounding local variables 
        button.addActionListener(listener); // adding the event listner object to the appropriate event source

        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
