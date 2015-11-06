package csc143.la9;

import java.awt.*;
import javax.swing.*;

/**
 * This class is the panel background for the TTT class
 * @author Alexander Hoppe
 * @version May 28, 2015
 */
@SuppressWarnings("serial")
class TicTacToePanel extends JPanel {
    
    //no fields
    
    //constructor
    /**
     * This is the default constructor
     */
    TicTacToePanel() {
        setPreferredSize(new Dimension(300, 300));
    }
    
    //methods
    /**
     * This method overrides the paintComponent method for JPanel
     * @param g The Graphics object associated with this class
     */
    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawLine(getWidth() / 3, 0, getWidth() / 3, getHeight());
        g.drawLine(getWidth() * 2 / 3, 0, getWidth() * 2 / 3, getHeight());
        g.drawLine(0, getHeight() / 3, getWidth(), getHeight() / 3);
        g.drawLine(0, getHeight() * 2 / 3, getWidth(), getHeight() * 2 / 3);
    }

}
