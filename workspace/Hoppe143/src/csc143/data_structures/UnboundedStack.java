package csc143.data_structures;

/**
 * This interface represents an unbounded stack data structure
 * @author CSC143 class
 * @author Alexander Hoppe
 * @version Apr 28, 2015
 */
public interface UnboundedStack {
     /**
      * This method pushes an Object onto the top of the stack
      * @param o The Object to be pushed onto the stack
      */
    public void push(Object o);
    
    
   /**
    * This method pops the top Object off of the stack, removing it.
    * @return The top Object on the stack
    * @throws TheStackIsSadAndLonely If the stack is empty
    */
    public Object pop() throws TheStackIsSadAndLonely;
    
    /**
     * This method returns the top object on the stack
     * @return the top Object on the stack 
     * @throws TheStackIsSadAndLonely If the stack is empty
     */
    public Object top() throws TheStackIsSadAndLonely;
    
    /**
     * This method tests if the stack is empty
     * @return true if the stack is empty
     */
    public boolean isEmpty();
    
    /**
     * This method returns the number of elements in the stack
     * @return the number of elements in the stack
     */
    public int size();
    
    /**
     * This method represents the stack as a String
     * @return A String representation of the stack
     */
    public String toString();
    
}
