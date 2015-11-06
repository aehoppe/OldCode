package csc143.data_structures;

/**
 * This interface represents a bounded stack data structure
 * @author CSC143 class
 * @author Alexander Hoppe
 * @version Apr 28, 2015
 */
public interface BoundedStack {
    
    /**
     * This method pushes an Object onto the top of the stack
     * @param o The Object to be pushed
     * @throws TheStackIsFatAndFull If the stack is full
     */
    public void push(Object o) throws TheStackIsFatAndFull;
    
    /**
     * This method pops the top Object off of the stack, removing it from the stack
     * @return the Object on top of the stack
     * @throws TheStackIsSadAndLonely If the stack is empty
     */
    public Object pop() throws TheStackIsSadAndLonely;
    
    /**
     * This method returns the Object on top of the stack
     * @return the Object on top of the stack
     * @throws TheStackIsSadAndLonely If the stack is empty
     */
    public Object top() throws TheStackIsSadAndLonely;
    
    /**
     * This method tests if the stack is empty.
     * @return if the stack is empty
     */
    public boolean isEmpty();
    
    /**
     * This method tests if the stack is full
     * @return if the stack is full
     */
    public boolean isFull();
    
    /**
     * This method returns the current size of the stack
     * @return the number of elements in the stack
     */
    public int size();
    
    /**
     * This method returns the max capacity of the stack
     * @return the capacity of the stack
     */
    public int capacity();
    
    /**
     * This method returns a String representation of the stack
     * @return a String representation of the stack
     */
    public String toString();
    
}
