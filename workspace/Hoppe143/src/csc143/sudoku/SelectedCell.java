package csc143.sudoku;

/**
 * This interface is used for the SudokuView class to implement cell select
 * @author Dan Jinguji
 * @author Alexander Hoppe
 * @version Jun 11, 2015
 */
public interface SelectedCell {

    /**
     * This method sets the selected cell to the corresponding row and column
     * @param row The row of the new selected cell
     * @param col The column of the new selected cell
     */
    public void setSelected(int row, int col);
    
    /**
     * This method gets the row of the selected cell, starting at 0
     * @return The row the selected cell is in
     */
    public int getSelectedRow();
    
    /**
     * This method gets the column of the selected cell, starting at 0
     * @return The column the selected cell is in
     */
    public int getSelectedColumn();
    
}