package csc143.data_structures;


/**
 * This class is an array implementation of the BoundedQueue interface
 * @author Alexander Hoppe
 * @version Apr 28, 2015
 */
public class SampleBoundedQueue implements BoundedQueue {
    
    //fields
    /**
     * This field holds onto the array of Objects this structure contains
     */
    Object[] data;
    
    /**
     * This field holds onto the capacity of the array (to avoid extra calls)
     */
    int capacity;
    
    /**
     * This field holds onto the index of the size of the array
     */
    int size;

    
    //constructors
    /**
     * This is the specific constructor that takes a capacity parameter
     * O(k)
     * @param size the capacity of the queue
     */
    public SampleBoundedQueue(int size) {
        data = new Object[size];
        this.capacity = size;
        size = 0;
    }

    //methods
    /**
     * This method adds an Object to the back of the queue
     * O(k)
     * @param o the Object to be added
     * @throws TheQueueIsOutTheDoor if the queue is full
     */
    @Override
    public void add(Object o) throws TheQueueIsOutTheDoor {
        //test for a full queue
        if (isFull()) throw new TheQueueIsOutTheDoor("full queue");
        //add new value
        data[size] = o;
        //increment size
        size += 1;
    }

    /**
     * This method removes and returns the Object at the front of the queue
     * O(n)
     * @return the Object at the front of the queue
     * @throws TheQueueIsDieting If the queue is empty
     */
    @Override
    public Object remove() throws TheQueueIsDieting {
        //test for an empty queue
        if (isEmpty()) throw new TheQueueIsDieting("empty queue");
        //store the temporary value
        Object output = data[0];
        //shift the rest of the values down up to the last one
        for (int i = 1; i < size; i++) {
            data[i-1] = data[i];
        }
        //reset the final, now empty value
        data[size - 1] = null;
        //decrement size
        size -= 1;
        //return the output
        return output;
    }

    /**
     * This method returns the Object at the front of the queue
     * O(k)
     * @return the Object at the front of the queue
     * @throws TheQueueIsDieting If the queue is empty 
     */
    @Override
    public Object front() throws TheQueueIsDieting {
        //test for empty queue
        if (isEmpty()) throw new TheQueueIsDieting("empty queue");
        return data[0];
    }
    
    /**
     * This method tests if the queue is empty
     * O(k)
     * @return true if the queue is empty
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * This method tests if the queue is full
     * O(k)
     * @return true if the queue is full
     */
    @Override
    public boolean isFull() {
        return size == capacity;
    }

    /**
     * This method returns the current size of the queue
     * O(k)
     * @return the number of elements in the queue
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * This method returns the max capacity of the queue
     * O(k)
     * @return the capacity of the queue
     */
    @Override
    public int capacity() {
        return capacity;
    }

    /**
     * This method returns a String representation of the queue
     * O(n)
     * @return A String representation of the queue
     */
    @Override
    public String toString() {
        //set up the beginning of the string
        String output = "[ " + size + " : ";
        //construct the rest of the string
        if (size > 0) {
            output += data[0];
            //loop through rest of list
            for (int i = 1; i < capacity; i++) {
                output += ", " + data[i];
            }
            output += " ]";
        }
        //in the empty case
        else {
            output += "]";
        }
        return output;
    }
    
}
