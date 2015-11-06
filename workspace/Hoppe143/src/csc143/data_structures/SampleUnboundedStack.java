package csc143.data_structures;


/**
 * This class is a LinkedList implementation of the UnboundedStack interface
 * @author Alexander Hoppe
 * @version Apr 28, 2015
 */
public class SampleUnboundedStack implements UnboundedStack {
    //fields
    /**
     * This field holds onto the first Node in the linked list of queue elements
     */
    Node top;
    
    /**
     * This field holds onto the last Node in the linked list of queue elements
     */
    Node bottom;
    
    //constructors
    /**
     * This is the default constructor
     * O(k)
     */
    public SampleUnboundedStack() {
        top = null;
        bottom = null;
    }
    
    //methods
    /**
     * This method adds an object to the back of the queue
     * O(k)
     * @param o The object to be added
     */
    @Override
    public void push(Object o) {
        //check if it's empty
        if (top == null) {
            top = new Node(o, null);
            bottom = top;
        } 
        //otherwise add to the front
        else { 
            top = new Node(o, top);
        }
    }

    /**
     * This method pops the top Object off of the top of the stack
     * O(k)
     * @return the Object on top of the stack
     * @throws TheStackIsSadAndLonely If the stack is empty
     */
    @Override
    public Object pop() throws TheStackIsSadAndLonely {
        //test if it's empty
        if (top == null) throw new TheStackIsSadAndLonely("empty stack");
        //grab the first element
        Object output = top.data;
        //advance the queue
        top = top.next;
        //return the element
        return output;
    }

    /**
     * This method returns the top Object on the stack
     * O(k)
     * @return the top Object on the stack
     * @throws TheStackIsSadAndLonely If the stack is empty
     */
    @Override
    public Object top() throws TheStackIsSadAndLonely {
        //test if it's empty
        if (top == null) throw new TheStackIsSadAndLonely("empty stack");
        //return top of stack
        return top.data;
    }

    /**
     * This method tests if the stack is empty
     * O(k)
     * @return true if the stack is empty
     */
    @Override
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * This method returns the current size of the stack
     * O(n)
     * @return the number of elements in the stack
     */
    @Override
    public int size() {
        //test if it's empty
        if (isEmpty()) return 0;
        
        //otherwise count through elements
        int size = 0;
        Node current = top;
        while(current != null){
            current = current.next;
            size++;
        }
        return size;
    }

    /**
     * This method returns a String representation of the stack
     * O(2n)
     * @return A String representation of the stack
     */
    @Override
    public String toString() {
        //set up the beginning of the string
        int size = size();
        String output = "[ " + size + " : ";
        //construct the rest of the string
        if (size > 0) {
            output += top.data;
            //loop through rest of list
            Node current = top.next;
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
