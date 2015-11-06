package csc143.data_structures;
/**
 * This class implements a set on a basic BST structure
 * @author Alexander Hoppe
 * @version May 18, 2015
 */

public class MySimpleSet<E> implements SimpleSet<E> {
    
    //fields
    /**
     * The size of this structure
     */
    private int size;
    
    /**
     * The root of the binary search tree this set is built upon
     */
    private BSTreeNode<E> root;
    
    //constructor
    /**
     * This is the constructor, all it does is set size and root to 0 and null
     */
    public MySimpleSet() {
        root = null;
        size = 0;
        }
    
    //methods
    /**
     * This method attempts to add an E to the set, returns true if successful
     * @param E e The element to be added
     * @return Whether or not the element was added
     */
    @Override
    public boolean add(E e) {
        //check for duplicates
        if (contains(e)) return false;
        //no need to worry about duplicates
        else {
            root = subAdd(root, e);
            size += 1;
            return true;
        }
    }
    
    /**
     * This method adds a value to a subtree rooted at node n
     * @param n The node/subtree being worked on
     * @param element The element to be added
     * @return 
     */
    @SuppressWarnings("unchecked")
    private BSTreeNode<E> subAdd(BSTreeNode<E> n, E element) {
        //if we're at the bottom, add a new node
        if (n == null) return new BSTreeNode<E>(element, null, null);
        //otherwise process subtrees
        int compare = n.data.compareTo(element);
        //compare != 0
        if (compare > 0) {
            n.left = subAdd(n.left, element);
        } else /* comp < 0 */ {
            n.right = subAdd(n.right, element);
        }
        return n;
    }
    
    /**
     * This method empties the set.
     */
    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    /**
     * Returns whether the element is in the set
     * @param E e The element to be searched for
     * @return whether or not the element is in the set
     */
    @Override
    public boolean contains(E e) {
        return subContains(root, e);
    }
    
    /**
     * This recursive method is a helper method for the contains method, searches
     * for a value in the tree rooted at n.
     * @param n The node/subtree being processed
     * @param element The element being searched for
     * @return whether or not the element was in the subtree
     */
    private boolean subContains(BSTreeNode<E> n, E element) {
        //if the subtree is empty
        if (n == null) return false;
        //otherwise
        else {
            @SuppressWarnings("unchecked")
            int compare = n.data.compareTo(element);
            if (compare == 0) return true;
            else if (compare > 0) return subContains(n.left, element);
            else return subContains(n.right, element);
        }
        
    }
    
    /**
     * This method returns true if the set is empty
     * @return whether or not the set is empty
     */
    @Override
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * This method returns the number of elements in the set
     * @return whether or not the set is empty
     */
    @Override
    public int size() {
        return size;
    }
    
    /**
     * This method returns a string representation of the tree
     * @return A String representation of this set
     */
    @Override
    public String toString() {
        //enclosed in parens
        return "(" + subToString(root) + ")";
    }
    
    /**
     * This recursive method is a helper method for the toString method
     * @param n the node/subtree being worked on
     * @return a toString representation of that subtree
     */
    private String subToString(BSTreeNode<E> n) {
        //if empty, return nothing
        if (n == null) return "";
        //otherwise
        String output = "";
        //put in data first
        output += n.data + " (";
        //left subtree
        output += subToString(n.left);
        output += ") (";
        //right subtree
        output += subToString(n.right);
        output += ")";
        //all done!
        return output;
    }

}
