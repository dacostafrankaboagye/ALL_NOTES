// package bk.ch09.button1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** 
 * An action listener that prints a message
*/
public class ClickListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Clicked!!");
    }

}
