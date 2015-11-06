package csc143.data_structures;

/**
 * This interface represents a bounded queue data structure
 * @author CSC143 class
 * @author Alexander Hoppe
 * @version Apr 28, 2015
 */
public interface BoundedQueue {
    
    /**
     * This method adds an Object to the front of the queue
     * @param o the Object to be added
     * @throws TheQueueIsOutTheDoor If the queue is full
     */
    public void add(Object o) throws TheQueueIsOutTheDoor;
    
    /**
     * This method removes the Object at the front of the queue and returns it
     * @return the Object being removed
     * @throws TheQueueIsDieting If the queue is empty
     */
    public Object remove() throws TheQueueIsDieting; 
    
    /**
     * This method returns the Object at the front of the queue
     * @return the Object at the front of the queue
     * @throws TheQueueIsDieting if the queue is empty
     */
    public Object front() throws TheQueueIsDieting;
    
    /**
     * This method tests if the bounded queue is empty
     * @return true if the queue is empty
     */
    public boolean isEmpty();
    
    /**
     * This method tests if the queue is full
     * @return true if the queue is full
     */
    public boolean isFull();
    
    /**
     * This method returns the current size of the queue
     * @return the number of elements in the queue
     */
    public int size();
    
    /**
     * This method returns the maximum capacity of the queue
     * @return the capacity of the queue
     */
    public int capacity();
    
    /**
     * This method returns a String representation of the queue
     * @return A String representation of the queue
     */
    public String toString();
    
}

