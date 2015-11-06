package hoppeHW6;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This class provides the user interface and control for the game Life.
 * 
 * @author Barbara Goldner based on work by Hal Perkins and Robert Carr
 */
public class LifeGUI extends JPanel {
    // game instance variables
    private Life board;        // game board

    // GUI components
    private JLabel generationsLived;          
    private JButton resetButton, cycleButton;   // reset control and cycle control
    private Cell[][] cells;         // board cells for display

    /** Construct new Life game with a graphical user interface */
    public LifeGUI()    {
        // create and initialize game board and display representation
        board = new Life();
        cells = new Cell[Life.NROWSCOLS][Life.NROWSCOLS];

        // set layout for game display
        setLayout(new BorderLayout());

        // Create board cells and add to display
        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(Life.NROWSCOLS, Life.NROWSCOLS));
        for (int row = 0; row < Life.NROWSCOLS; row++) {
            for (int col = 0; col < Life.NROWSCOLS; col++) {
                cells[row][col] = new Cell(Life.DEAD, row, col);
                boardPanel.add(cells[row][col]);
           }
        }
        add(boardPanel, BorderLayout.CENTER);


        // Set up 2 buttons
        // a reset button so it starts a new game when clicked
        // a cycle button to tell the Life automaton to live one cycle
        resetButton = new JButton("New Game");
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                board.newGame();
                updateDisplay();
            }
        });
        
        cycleButton = new JButton("Live One Cycle");
        cycleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                board.lifeCycle();
                updateDisplay();
            }
        });
        
        // Put the buttons and the generation count display on the screen
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(resetButton);
        buttonPanel.add(cycleButton);
        generationsLived = new JLabel("     Generations Lived: " , JLabel.RIGHT);
        buttonPanel.add(generationsLived);
        add(buttonPanel, BorderLayout.SOUTH);

        // show initial display
        updateDisplay();
    }

    /** Update display to match game state. */
    public void updateDisplay() {
        // update count display
        generationsLived.setText("     Generations Lived: " + board.getGenerationCount());

        // update board display
        for (int row = 0; row < Life.NROWSCOLS; row++) {
            for (int col = 0; col < Life.NROWSCOLS; col++) {
                cells[row][col].setState(board.getCell(row,col));
            }
        }
        repaint();
    }
        
    /** Create new game and a window to display it */
    private static void test() {
        JFrame f = new JFrame("The Game of Life");     // top-level window
        LifeGUI l = new LifeGUI();
        f.getContentPane().add(l);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(600,600);
        f.validate();
        f.setVisible(true);
        f.toFront();
    }
    
    public static void main(String[] args) {
        // To support stand-alone application
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                LifeGUI.test();
            }
        });
    }
}
