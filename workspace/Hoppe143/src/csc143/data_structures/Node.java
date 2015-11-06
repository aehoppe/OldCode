package csc143.data_structures;

/**
 * This class represents one node in the linked list that is used to implement 
 * the unbounded stack and queue classes.
 * @author Alexander Hoppe
 * @version May 10, 2015
 */
class Node {

    //fields
    /**
     *  This field holds onto the data of the node
     */
    Object data;
    
    /**
     * This field holds onto the next Node in the list
     */
    Node next;
    
    //constructors
    /**
     * This is the parameterless constructor, it won't be used
     */
    public Node() {
    }
   
    /**
     * This constructor sets the data and the next value in the list
     * @param data
     * @param next
     */
    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }
    
}
