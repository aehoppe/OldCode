package csc143.data_structures;

/**
 * This exception class is for when bounded queues are full
 * @author CSC143 class
 * @author Alexander Hoppe
 * @version Apr 28, 2015
 */
public class TheQueueIsOutTheDoor extends DataStructureException {
    
    /**
     * This is the default constructor
     */
    public TheQueueIsOutTheDoor() {
    }
    
    /**
     * This is the constructor with a message
     * @param msg the error message
     */
    public TheQueueIsOutTheDoor(String msg) {
        super(msg);
    }

}
