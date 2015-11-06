package csc143.sudoku;

/**
 * This abstract class outlines the behavior of the central class of the Sudoku
 * app. 
 * @author Dan Jinguji
 * @author Alexander Hoppe
 */
public abstract class SudokuBase extends java.util.Observable {

   /**
    * The number of rows in each region
    */
   private final int rows;
   
   /**
    * The number of columns in each region
    */
   private final int columns;
   
   /**
    * The dimension (it's a square) of the entire board, also the number of
    * squares in each region
    */
   private final int size;

   /**
    * This enum holds the three possible states for a region/row/column in 
    * sudoku games: complete, incomplete, or error (duplicates)
    * @author Dan Jinguji
    */
   public enum State {COMPLETE, INCOMPLETE, ERROR};

   /**
    * This constructor instantiates a SudokuBase with the specified number of 
    * rows and columns in each region
    * @param layoutRows The number of rows per region
    * @param layoutColumns The number of columns per region
    */
   public SudokuBase(int layoutRows, int layoutColumns) {
      rows = layoutRows;
      columns = layoutColumns;
      size = columns * rows;
   }
   
   /**
    * This method returns the rows dimension (per region)
    * @return Number of rows per region
    */
   public int getRows() {
      return rows;
   }

   /**
    * This method returns the columns dimension (per region) 
    * @return Number of columns per region
    */
   public int getColumns() {
      return columns;
   }

   /**
    * This method returns the side length (side dimension) of the board
    * @return Side length of board
    */
   public int getSize() {
      return size;
   }

   /**
    * This method returns the value stored in the square specified by the row 
    * and column
    * @param row The row the square is in
    * @param col The column the square is in
    * @return The value stored in that square
    */
   public abstract int getValue(int row, int col);

   /**
    * This method sets the value at the specified square
    * @param row The row of the desired square
    * @param col The column of the desired square
    * @param value The value to be inserted at that square
    */
   public abstract void setValue(int row, int col, int value);

   /**
    * This method tests if the value in the specified square is a given or not
    * @param row The row of the desired square
    * @param col The column of the desired square
    * @return True if the value is a given
    */
   public abstract boolean isGiven(int row, int col);

   /**
    * This method fixes all of the values currently in the sudoku board as given
    */
   public abstract void fixGivens();

   /**
    * This method gets the State (complete, incomplete, error) 
    * of the specified row
    * @param n The row to be tested
    * @return the State of the row
    */
   public abstract State getRowState(int n);

   /**
    * This method gets the State (complete, incomplete, error) 
    * of the specified column
    * @param n The column to be tested
    * @return the State of the column
    */
   public abstract State getColumnState(int n);

   /**
    * This method gets the State (complete, incomplete, error) 
    * of the specified region
    * @param n The region to be tested
    * @return The State of the region
    */
   public abstract State getRegionState(int n);

}