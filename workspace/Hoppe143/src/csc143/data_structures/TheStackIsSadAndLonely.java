package csc143.data_structures;

/**
 * This exception is for when stack-type data structures are empty
 * @author CSC143 class
 * @author Alexander Hoppe
 * @version Apr 28, 2015
 */
public class TheStackIsSadAndLonely extends DataStructureException {
    
    /**
     * This is the default constructor
     */
    public TheStackIsSadAndLonely() {
    }
    
    /**
     * This is the constructor with a message
     * @param msg the error message
     */
    public TheStackIsSadAndLonely(String msg) {
        super(msg);
    }

}
