package csc143.data_structures;


/**
 * This class is a LinkedList implementation of the UnboundedQueue interface
 * @author Alexander Hoppe
 * @version Apr 28, 2015
 */
public class SampleUnboundedQueue implements UnboundedQueue {

    //fields
    /**
     * This field holds onto the first Node in the linked list of queue elements
     */
    Node first;
    
    /**
     * This field holds onto the last Node in the linked list of queue elements
     */
    Node last;
    
    //constructors
    /**
     * This is the default constructor
     * O(k)
     */
    public SampleUnboundedQueue() {
        first = null;
        last = null;
    }
    
    //methods
    /**
     * This method adds an object to the back of the queue
     * O(k)
     * @param o The object to be added
     */
    @Override
    public void add(Object o) {
        //check if it's empty
        if (first == null) {
            first = new Node(o, null);
            last = first;
        } 
        //otherwise add to the end
        else { 
            Node temp = new Node(o, null);
            last.next = temp;
            last = temp;
        }
    }

    /**
     * This method removes and returns the Object at the front of the queue
     * O(k)
     * @return the Object at the front of the queue
     * @throws TheQueueIsDieting If the queue is empty
     */
    @Override
    public Object remove() throws TheQueueIsDieting {
        //test if it's empty
        if (first == null) throw new TheQueueIsDieting("empty queue");
        //grab the first element
        Object output = first.data;
        //advance the queue
        first = first.next;
        //return the element
        return output;
    }

    /**
     * This method returns the Object at the front of the queue
     * O(k)
     * @return the object at the front of the queue
     * @throws TheQueueIsDieting if the queue is empty
     */
    @Override
    public Object front() throws TheQueueIsDieting {
        //test if it's empty
        if (first == null) throw new TheQueueIsDieting("empty queue");
        //return the first element
        return first.data;
    }

    /**
     * This method tests if the queue is empty
     * O(k)
     * @return true if the queue is empty
     */
    @Override
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * This method returns the current size of the queue
     * O(n)
     * @return the number of elements in the queue
     */
    @Override
    public int size() {
        //test if it's empty
        if (isEmpty()) return 0;
        
        //otherwise count through elements
        int size = 0;
        Node current = first;
        while(current != null){
            current = current.next;
            size++;
        }
        return size;
    }
    
    /**
     * This method returns a String representation of the queue
     * O(2n)
     * @return a String representation of the queue
     */
    public String toString() {
        //set up the beginning of the string
        int size = size();
        String output = "[ " + size + " : ";
        //construct the rest of the string
        if (size > 0) {
            output += first.data;
            //loop through rest of list
            Node current = first.next;
            while (current != null) {
                output += ", " + current.data;
                current = current.next;
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
