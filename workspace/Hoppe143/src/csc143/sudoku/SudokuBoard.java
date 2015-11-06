package csc143.sudoku;

import java.awt.*;

/**
 * This class is the visual background for the Sudoku game. 
 * @author Alexander Hoppe
 * @version 5/31/15
 */
public class SudokuBoard extends javax.swing.JComponent {

    //fields
    /* 
     * Holds onto info from the SudokuBase
     */
    private int rows, columns;
    
    /*
     * Holds onto dimensions
     */
    private int sideLength;
    
    //constructor
    /**
     * This constructor ties this component to an instance of the sudoku base
     * class that the game is built upon
     * @param b The SudokuBase this class is representing
     */
    public SudokuBoard(SudokuBase b) {
        rows = b.getRows();
        columns = b.getColumns();
        sideLength = rows * 50 * columns + 4;
        setPreferredSize(new Dimension(sideLength, sideLength));
    }

    //methods
    /**
     * This method overrides the default paintComponent method, drawing the 
     * sudoku board.
     * @param g The Graphics object associated with this component
     */
    public void paintComponent(Graphics g) {
        //draw the backdrop
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, sideLength, sideLength);
        //draw the border
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, sideLength - 1, sideLength - 1);
        //boolean for grey alternation
        boolean grey = false;
        //draw the regions
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                //flop colors
                if (grey) {
                    g.setColor(Color.LIGHT_GRAY);
                } else {
                    g.setColor(Color.WHITE);
                }
                //flip boolean
                grey = !grey;
                //draw the rectangle
                g.fillRect(i * columns * 50 + 2, j * rows * 50 + 2, columns * 50, rows * 50);
            }
            //flop the boolean again if it's even
            if (columns % 2 == 0) {
                grey = !grey;
            }
        }
        
        //draw the squares
        for (int i = 0; i < rows * columns; i++) {
            for (int j = 0; j < rows * columns; j++) {
                //set the color
                g.setColor(Color.BLACK);
                //draw the rectangle one in from its edges and two away from the panel border
                g.drawRect(i * 50 + 3, j * 50 + 3, 47, 47);
            }
        }
        
    }
    
}