package csc143.sudoku;

import java.util.*;

/**
 * This class works with the internal state of the sudoku game for the sudoku 
 * project. It implements the methods that check for completeness.
 * @author Dan Jinguji
 * @author Alexander Hoppe
 * @version Jun 6, 2015
 */
public class SudokuModel extends SudokuCore {

    //constructor
    /**
     * This is the constructor, it is the same as the superclass
     * @param r The number of rows per region in the sudoku game
     * @param c The number of columns per region in the sudoku game
     */
    public SudokuModel(int r, int c) {
        super(r, c);
    }

    //methods
    /**
     * This method adds a notifyObservers to the superclass setValue method
     * @param row The row of the value to be set
     * @param col The column of the value to be set
     * @param value The value to be set in this row and column
     */
    @Override
    public void setValue(int row, int col, int value) {
        super.setValue(row, col, value);
        notifyObservers();
    }
    
    /**
     * This method adds a notifyObservers to the superclass notify method
     */
    @Override
    public void fixGivens() {
        super.fixGivens();
        notifyObservers();
    }
    
    
    /**
     * This method gets the State of the specified row
     * @param n The row (starting at 0) to be checked
     * @return The State of the row
     */
    public State getRowState(int n) { 
        return checkState(getRowIterator(n));
    }

    /**
     * This method gets the State of the specified column
     * @param n The column (starting at 0) to be checked
     * @return The State of the row
     */
    public State getColumnState(int n) { 
        return checkState(getColumnIterator(n)); 
    }

    /**
     * This method gets the State of the specified region
     * @param n The region (starting at 0) to be checked
     * @return The State of the row
     */
    public State getRegionState(int n) { 
        return checkState(getRegionIterator(n));
    }
    
    /*
     * This method returns a RowIterator for this sudoku game
     */
    private Iterator<Integer> getRowIterator(int n) {
        return new RowIterator<Integer>(n);
    }
    
    /*
     * This method returns a ColumnIterator for this sudoku game
     */
    private Iterator<Integer> getColumnIterator(int n) {
        return new ColumnIterator<Integer>(n);
    }
    
    /*
     * This method returns a RegionIterator for this sudoku game
     */
    private Iterator<Integer> getRegionIterator(int n) {
        return new RegionIterator<Integer>(n);
    }
    
    /*
     * This method iterates through a region, row or column and checks its State
     */
    private State checkState(Iterator<Integer> iter) {
        //the set for checking for dupes
        Set<Integer> temp = new HashSet<Integer>();
        //state variables
        int zeros = 0;
        boolean containsDuplicate = false;
        //add the values to the set
        while (iter.hasNext()) {
            //hold onto current value
            int current = iter.next();
            //test if zero
            if (current == 0){
                zeros++;
                temp.add(current);
            } else {
                containsDuplicate = containsDuplicate || !temp.add(current);
            }
        }
        //choose which state to return
        if (containsDuplicate) {
            return State.ERROR;
        } else if (zeros == 0 && temp.size() == getRows() * getColumns()) {
            return State.COMPLETE;
        } else return State.INCOMPLETE;
    }
     
    //inner classes
    /*
     * This class is an iterator for rows in this class. 
     */
    private class RowIterator<E> implements Iterator<E> {
        
        //fields
        /*
         * This field holds onto the position in the row
         */
        private int position;
        
        /*
         * This field holds onto the row this is iterating along
         */
        private int row;
        
        //constructor
        /*
         * This is the constructor, it initializes position to zero and row to
         * the row passed in the constructor
         */
        private RowIterator(int rowNumber) {
            this.row = rowNumber;
            position = -1;
        }
        
        //methods
        /*
         * (non-Javadoc)
         * @see java.util.Iterator#hasNext()
         */
        @Override
        public boolean hasNext() {
            return position < getRows() * getColumns() - 1;
        }

        /*
         * (non-Javadoc)
         * @see java.util.Iterator#next()
         */
        @SuppressWarnings("unchecked")
        @Override
        public E next() {
            //move to the next position
            position++;
            //return the value at this position
            return (E) new Integer(getValue(row, position));
        }
        
        /*
         * (non-Javadoc)
         * @see java.util.Iterator#remove()
         * @throws UnsupportedOperationException because it's unsupported
         */
        @Override
        public void remove() {
            throw new UnsupportedOperationException("Unused");
        }
        
    }
    
    /*
     * This class is an iterator for columns in this class
     */
    private class ColumnIterator<E> implements Iterator<E> {

        //fields
        /*
         * This field holds onto the position in the column
         */
        private int position;
        
        /*
         * This field holds onto the column this is iterating along
         */
        private int column;
        
        //constructor
        /*
         * This is the constructor, it initializes position to zero and column to
         * the column passed in the constructor
         */
        private ColumnIterator(int columnNumber) {
            this.column = columnNumber;
            position = -1;
        }
        
        //methods
        /*
         * (non-Javadoc)
         * @see java.util.Iterator#remove()
         */
        @Override
        public boolean hasNext() {
            return position < getRows() * getColumns() - 1;
        }
        
        /*
         * (non-Javadoc)
         * @see java.util.Iterator#remove()
         */
        @SuppressWarnings("unchecked")
        @Override
        public E next() {
            //move to the next position
            position++;
            //return the value at this position
            return (E) new Integer(getValue(position, column));
        }
        
        /*
         * (non-Javadoc)
         * @see java.util.Iterator#remove()
         * @throws UnsupportedOperationException because it's unsupported
         */
        @Override
        public void remove() {
            throw new UnsupportedOperationException("Unused");
        }
        
    }
    
    /*
     * This class is an iterator for regions in this class
     */
    private class RegionIterator<E> implements Iterator<E> {
        //fields
        /*
         * This field holds onto the position in the region
         */
        private int position;
        
        /*
         * This field holds onto the region this is iterating along
         */
        private int region;
        
        /*
         * This field holds onto the row of the first position in the region
         */
        private int firstRow;
        
        /*
         * This field holds onto the column of the first position in the region
         */
        private int firstColumn;
        
        //constructor
        /*
         * This is the constructor, it initializes position to zero and region to
         * the region passed in the constructor, as well as calculating the 
         * first position in the region, the top left.
         */
        private RegionIterator(int regionNumber) {
            this.region = regionNumber;
            position = -1;
            //get coords of first position in region
            firstRow = getRows() * (region / getRows());
            firstColumn = getColumns() * (region % getRows());
        }
        
        //methods
        /*
         * (non-Javadoc)
         * @see java.util.Iterator#remove()
         */
        @Override
        public boolean hasNext() {
            return position < getRows() * getColumns() - 1;
        }

        /*
         * (non-Javadoc)
         * @see java.util.Iterator#remove()
         */
        @SuppressWarnings("unchecked")
        @Override
        public E next() {
            //increment position
            position++;
            //return correct value: its complicated
            return (E) (new Integer(getValue(firstRow + position / getColumns(),
                    firstColumn + position % getColumns())));
        }
        
        /*
         * (non-Javadoc)
         * @see java.util.Iterator#remove()
         * @throws UnsupportedOperationException becese it's unsupported
         */
        @Override
        public void remove() {
            throw new UnsupportedOperationException("Unused");
        }
        
    }

}