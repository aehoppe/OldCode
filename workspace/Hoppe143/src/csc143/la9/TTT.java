package csc143.la9;

import java.awt.*;
import javax.swing.*;

/**
 * This class creates a Tic Tac Toe board in a window
 * @author Alexander Hoppe
 * @version May 28, 2015
 */
public class TTT {

    /**
     * This main method creates and runs the Tic-tac-toe application
     * @param args The unused command-line args
     */
    public static void main(String[] args) {
        //create window
        JFrame win = new JFrame("Tic-Tac-Toe");
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TicTacToePanel background = new TicTacToePanel();
        win.add(background);
        //setup layout
        background.setLayout(new GridLayout(3, 3, 2, 2));
        //add x and o and blank
        background.add(centeredX(Color.BLUE));
        background.add(centeredO(Color.YELLOW, Color.RED));
        background.add(centeredX(Color.BLUE));
        background.add(centeredO(Color.YELLOW, Color.RED));
        background.add(centeredX(Color.BLUE));
        background.add(new Blank2());
        background.add(centeredO(Color.YELLOW, Color.RED));
        background.add(new Blank2());
        background.add(centeredX(Color.BLUE));
        win.pack();
        win.setVisible(true);

    }
    
    //helper methods
    private static JPanel centeredX(Color lc) {
        JPanel output = new JPanel();
        output.setLayout(new BorderLayout());
        output.add(new Blank2(), BorderLayout.SOUTH);
        output.add(new Blank2(), BorderLayout.NORTH);
        output.add(new Blank2(), BorderLayout.EAST);
        output.add(new Blank2(), BorderLayout.WEST);
        output.add(new X2(lc));
        return output;
    }
    
    private static JPanel centeredO(Color fc, Color lc) {
        JPanel output = new JPanel();
        output.setLayout(new BorderLayout());
        output.add(new Blank2(), BorderLayout.SOUTH);
        output.add(new Blank2(), BorderLayout.NORTH);
        output.add(new Blank2(), BorderLayout.EAST);
        output.add(new Blank2(), BorderLayout.WEST);
        output.add(new O2(fc, lc));
        return output;
    }

}
