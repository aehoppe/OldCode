/**
 * This class is a new type of exception for when functions fail to converge.
 * @author Alexander Hoppe
 * @version 4/11/15
 *
 */
@SuppressWarnings("serial")
public class NonConvergenceException extends RuntimeException {

    //constructors
    /**
     * This is the default constructor with no parameters.
     */
    public NonConvergenceException(){
        super();
    }
    
    /**
     * This is the constructor for the message version of the exception.
     * @param message The error message for the exception
     */
    public NonConvergenceException(String message){
        super(message);
    }
}
