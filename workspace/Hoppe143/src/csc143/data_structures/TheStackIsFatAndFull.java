package csc143.data_structures;

/**
 * This exception class is for bounded stack data structures when they are full
 * @author CSC143 class
 * @author Alexander Hoppe
 * @version Apr 28, 2015
 */
public class TheStackIsFatAndFull extends DataStructureException {

    /**
     * This is the default constructor
     */
    public TheStackIsFatAndFull() {
    }
    
    /**
     * This is the constructor with a message
     * @param msg the error message
     */
    public TheStackIsFatAndFull(String msg) {
        super(msg);
    }
    
}