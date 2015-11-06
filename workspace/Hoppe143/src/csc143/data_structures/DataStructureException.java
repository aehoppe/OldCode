package csc143.data_structures;

/**
 * This class is the superclass of all the data structure exceptions in this package
 * @author Alexander Hoppe
 * @version Apr 28, 2015
 */
public class DataStructureException extends Exception {
    
    /**
     * This is the default constructor
     */
    public DataStructureException() {
    }
    
    /**
     * This is the constructor that takes a message
     * @param msg the error message
     */
    public DataStructureException(String msg) {
        super(msg);
    }
}
