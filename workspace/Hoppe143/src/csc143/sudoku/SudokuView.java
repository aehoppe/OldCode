package csc143.sudoku;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * This class implements the view of the MVC setup of the Sudoku game. 
 * @author Alexander Hoppe
 * @version Jun 11, 2015
 */
public class SudokuView extends SudokuBoard implements Observer, SelectedCell {
    
    //fields
    /*
     * This field holds onto a reference to this view's model
     */
    private SudokuBase base;
    
    /*
     * These fields hold onto the row and column of the selected cell
     */
    private int selectedRow, selectedColumn;
    
    /*
     * These fields hold onto the dimensions of the board
     */
    private int rows, columns, sideLength;
    
    /*
     * This field holds onto the SymbolRenderer for this class
     */
    private SymbolRenderer render;
    
    //constructor
    /**
     * This constructor takes a SudokuModel (the model for this view) and sets
     * this object's model field to it, as well as initializing selectedRow and
     * selectedColumn to 0;
     * @param b The SudokuModel this view represents
     */
    public SudokuView(SudokuBase b) {
        super(b);
        //initialize fields
        base = b;
        selectedRow = selectedColumn = 0;
        rows = b.getRows();
        columns = b.getColumns();
        sideLength = rows * columns * 50 + 4;
        //register this as an observer of the base
        base.addObserver(this);
        //add a mouseAdapter to this class
        this.addMouseListener(new CellSelect());
        //add a renderer
        render = new NumberSymbols();
    }

    //methods
    /**
     * This method overrides the default paintComponent method, drawing the 
     * sudoku board.
     * @param g The Graphics object associated with this component
     */
    @Override
    public void paintComponent(Graphics g) {
        //TODO THIS IS TOTALLY BROKEN 
        
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

        //draw the selected square
        g.setColor(Color.YELLOW);
        g.fillRect(selectedRow * 50 + 4, selectedColumn * 50 + 4, 46, 46);
        
        
        //draw the squares
        for (int i = 0; i < rows * columns; i++) {
            for (int j = 0; j < rows * columns; j++) {
                //set the color
                g.setColor(Color.BLACK);
                //draw the rectangle one in from its edges and two away from the panel border
                g.drawRect(i * 50 + 3, j * 50 + 3, 47, 47);
            }
        }
        
        //draw the numbers
        for (int i = 0; i < rows * columns; i++) {
            for (int j = 0; j < rows * columns; j++) {
                //pick the color
                if (base.isGiven(i, j)) {
                    g.setColor(Color.BLACK);
                } else {
                    g.setColor(Color.DARK_GRAY);
                }
                //draw the symbol
                render.drawSymbol(g, i * 50 + 7, j * 50 + 7, base.getValue(i, j));
            }
        }
    }

    /**
     * This method sets the selected row and column
     * @param row The row of the cell to be selected
     * @param col The column of the cell to be selected
     */
    @Override
    public void setSelected(int row, int col) {
        selectedRow = row;
        selectedColumn = col;
        repaint();
    }

    /**
     * This is a getter method for the selected row
     * @return The selected row as an int
     */
    @Override
    public int getSelectedRow() {
        return selectedRow;
    }

    /**
     * This is a getter method for the selected column
     * @return The selected column as an int
     */
    @Override
    public int getSelectedColumn() {
        return selectedColumn;
    }

    /**
     * This method repaints the object when the state of the base changes
     * @param arg0 The Observable this is registered to
     * @param arg1 The Object passed to notifyObservers
     */
    @Override
    public void update(Observable arg0, Object arg1) {
        repaint();
    }

    /*
     * This inner class implements a MouseAdapter for the selected cell
     */
    private class CellSelect extends MouseAdapter {
        
        /*
         * This method overrides the mouseClicked method
         */
        @Override
        public void mouseClicked(MouseEvent e) {
            Point raw = e.getPoint();
            int rawX = raw.x;
            int rawY = raw.y;
            setSelected(rawX / 50, rawY / 50);
        }
    }
}
