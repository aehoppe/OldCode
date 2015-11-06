package csc143.data_structures;


/**
 * This class is an array implementation of the UnboundedStack interface
 * @author Alexander Hoppe
 * @version May 11, 2015
 */
public class ArrayUnboundedStack implements UnboundedStack {
    
    //fields
    /**
     * This field holds onto the array of Objects this structure contains
     */
    Object[] data;
    
    /**
     * This field holds onto the capacity of the array (to avoid extra calls?)
     */
    int capacity;
    
    /**
     * This field holds onto the index of the size of the array
     */
    int size;

    //constructors
    /**
     * This is the default constructor
     */
    public ArrayUnboundedStack() {
        this(10);
    }
    
    /**
     * This constructor specifies the capacity for the SampleBoundedStack
     * O(k)
     * @param size the capacity of the stack
     */
    public ArrayUnboundedStack(int size) {
        data = new Object[size];
        capacity = size;
        this.size = 0;
    }
    
    //methods
    /**
     * This method pushes an Object onto the stack
     * O(k)
     * @param o the Object to be pushed onto the stack
     */
    @Override
    public void push(Object o) {
        //test for a full stack
        if (isFull()) resize();
        //add new value
        data[size] = o;
        //increment size
        size += 1;
    }

    /**
     * This method pops the top Object off of the stack, removing and returning it
     * O(k)
     * @return the Object on the top of the stack
     * @throws TheStackIsSadAndLonely If the stack is empty
     */
    @Override
    public Object pop() throws TheStackIsSadAndLonely {
        //test if it's empty
        if (isEmpty()) throw new TheStackIsSadAndLonely("empty stack");
        size -= 1;
        return data[size];
    }

    /**
     * This method returns the top object on the stack
     * @return the Object on top of the stack
     * @throws TheStackIsSadAndLonely If the stack is empty
     */
    @Override
    public Object top() throws TheStackIsSadAndLonely {
        //test if it's empty
        if (isEmpty()) throw new TheStackIsSadAndLonely("emprty stack");
        return data[size - 1];
    }

    /**
     * This method tests if the stack is empty
     * @return true if the stack is empty
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * This method tests if the stack is full
     * @return true if the stack is full
     */
    private boolean isFull() {
        return size == capacity;
    }

    /**
     * This method returns the size of the stack
     * @return the number of elements in the stack
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * This method returns the max capacity of the stack
     * @return the capacity of the stack
     */
    private int capacity() {
        return capacity;
    }
    
    /**
     * This method returns a String representation of the stack
     * @return a String representation of the Object
     */
    @Override
    public String toString() {
        //set up the beginning of the string
        String output = "[ " + size + " : ";
        //construct the rest of the string if it's not empty
        if (size > 0) {
            output += data[0];
            //loop through rest of list
            for (int i = 1; i < size; i++) {
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
    
    /**
     * This private method resizes the array if necessary. 
     */
    private void resize() {
        capacity = capacity * 2;
        Object[] newData = new Object[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

}
