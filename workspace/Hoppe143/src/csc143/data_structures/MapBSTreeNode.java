package csc143.data_structures;

/**
 * This class is a node in the BST implementation of the map classes in this package
 * @author Alexander Hoppe
 * @version May 22, 2015
 */
class MapBSTreeNode<K, V> {

    //fields
    /**
     * The E that this node stores
     */
    @SuppressWarnings("rawtypes")
    Comparable key;
    
    /**
     * The value associated with this node's key
     */
    V value;
    
    /**
     * The left and right subtrees of this node
     */
    MapBSTreeNode<K, V> left, right;
    
    //constructors
    /**
     * This constructor sets the data, the left, and the right subtrees
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    MapBSTreeNode(K key, V value, MapBSTreeNode<K, V> left, MapBSTreeNode<K, V> right) {
        this.key = (Comparable) key;
        this.value = value;
        this.left = left;
        this.right = right;
    }
    
}
