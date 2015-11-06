package csc143.data_structures;

/**
 * This class implements the BasicMap<K, V> interface for HW 7
 * @author Alexander Hoppe
 * @version May 22, 2015
 */
public class MyBasicMap<K, V> implements BasicMap<K, V> {

    //fields
    /**
     * This field holds onto the size
     */
    protected int size;
    
    /**
     * This field holds onto the root of the BST
     */
    protected MapBSTreeNode<K, V> root;
    
    //constructor
    public MyBasicMap() {
        size = 0;
        root = null;
    }
    
    //methods
    /**
     * Associates the value provided with the key provided in the map
     * @param key The key in the key/value pair
     * @param value The value in the key/value pair
     */
    @Override
    public void put(K key, V value) {
        if (key == null || value == null) throw new IllegalArgumentException("Cannot add null key/value");
        subPut(root, key, value);
    }
    
    /**
     * This helper method adds a key/value pair to a given subtree
     * @param The root of the working subtree
     * @param key The key in the key/value pair
     * @param value The value in the key/value pair
     * @throws IllegalArgumentException for null arguments
     */
    private void subPut(MapBSTreeNode<K, V> n, K key, V value) {
        //if we're at the bottom add a new node
        if (n == null){
            n = new MapBSTreeNode<K, V>(key, value, null, null);
            size++;
        }
        //otherwise keep processing
        @SuppressWarnings("unchecked")
        int compare = n.key.compareTo(key);
        //if this key is already there, update its value
        if (compare == 0) n.value = value;
        //otherwise keep moving down subtrees
        else if (compare > 0) subPut(n.left, key, value);
        else /* compare < 0 */ subPut(n.right, key, value);
    }

    /**
     * This method returns the value associated with a key in the map
     * @param key The key being searched for
     * @return The value associated with that key
     */
    @Override
    public V get(Object key) { 
        return subGet(root, key);
    }
    
    /**
     * This helper method searches the map for the key given then returns the value 
     * associated with that key
     * @param n The node/subtree working
     * @param key The key being searched for
     * @return The value associated with the key
     */
    private V subGet(MapBSTreeNode<K, V> n, Object key) {
        //if the subtree is empty the key isn't there
        if (n == null) return null;
        //otherwise
        @SuppressWarnings("unchecked")
        int compare = n.key.compareTo(key);
        if (compare == 0) return n.value;
        else if (compare > 0) return subGet(n.left, key);
        else /* compare < 0 */ return subGet(n.right, key);
    }

    /**
     * This method searches the map for a specific key and returns true if it is 
     * in the map
     * @param key The key being searched for in the map
     * @return true if the key is found in the map
     */
    @Override
    public boolean containsKey(Object key) {
        return subContainsKey(root, key);
    }
    
    /**
     * This recursive method is a helper method for the containsKey method, 
     * searches for a value in the tree rooted at n.
     * @param n The node/subtree being processed
     * @param key The key being searched for
     * @return whether or not the key was in the subtree
     */
    private boolean subContainsKey(MapBSTreeNode<K, V> n, Object key) {
        //if the subtree is empty
        if (n == null) return false;
        //otherwise
        else {
            @SuppressWarnings("unchecked")
            int compare = n.key.compareTo(key);
            if (compare == 0) return true;
            else if (compare > 0) return subContainsKey(n.left, key);
            else return subContainsKey(n.right, key);
        }
        
    }

    /**
     * This method tests if the map is empty
     * @return true if the map is empty
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * This method empties the map
     */
    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    /**
     * This method returns the size of the map
     * @return the size of the map
     */
    @Override
    public int size() {
        return size;
    }
    
    /**
     * This method returns a string representation of the map
     * @return A String representation of this map
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
    private String subToString(MapBSTreeNode<K, V> n) {
        //if empty, return nothing
        if (n == null) return "";
        //otherwise
        String output = "";
        //put in data first
        output += n.key + ":" + n.value + " (";
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
