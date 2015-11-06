package csc143.data_structures;
/**
 * This class is an implementation class for the BST in MySimpleSet
 * @author Alexander Hoppe
 * @version May 18, 2015
 */

class BSTreeNode<E> {

    //fields
    /**
     * The E that this node stores
     */
    @SuppressWarnings("rawtypes")
    Comparable data;
    
    /**
     * The left and right subtrees of this node
     */
    BSTreeNode<E> left, right;
    
    //constructors
    /**
     * This constructor sets the data, the left, and the right subtrees
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    BSTreeNode(E data, BSTreeNode<E> left, BSTreeNode<E> right) {
        this.data = (Comparable) data;
        this.left = left;
        this.right = right;
    }
}
