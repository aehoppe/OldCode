package csc143.data_structures;

/**
 * This interface represents an unbounded queue data structure
 * @author CSC143 class
 * @author Alexander Hoppe
 * @version Apr 28, 2015
 */
public interface UnboundedQueue {

    /**
     * This method adds an Object to the back of the queue
     * @param o The Object to be added 
     */
    public void add(Object o);

    /**
     * This method removes an object from the front of the queue and returns it
     * @return The Object at the front of the queue
     * @throws TheQueueIsDieting If the queue is empty
     */
    public Object remove() throws TheQueueIsDieting;

    /**
     * This method returns the Object at the front of the queue
     * @return The Object at the front of the Queue
     * @throws TheQueueIsDieting If the Queue is empty
     */
    public Object front() throws TheQueueIsDieting;

    /**
     * This method tests if the queue is empty
     * @return True if the queue is empty
     */
    public boolean isEmpty();
    
    /**
     * This method returns the number of elements in the queue
     * @return the number of elements in the queue
     */
    public int size();
    
    /**
     * This method returns a String representation of the queue
     * @return A String representation of the queue
     */
    public String toString();
    
}
