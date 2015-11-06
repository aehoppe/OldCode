package csc143.data_structures;

/**
 * This exception is for all queue-type data structures, when they are empty
 * @author CSC143 class
 * @author Alexander Hoppe
 * @version Apr 28, 2012
 */
public class TheQueueIsDieting extends DataStructureException {

    /**
     * This is the default constructor
     */
    public TheQueueIsDieting() {
    }
    
    /**
     * This is the constructor with a mesage
     * @param msg the error message
     */
    public TheQueueIsDieting(String msg) {
        super(msg);
    }
    
}
