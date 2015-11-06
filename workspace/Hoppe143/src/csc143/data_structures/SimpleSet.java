package csc143.data_structures;

/**
 * A simplified interface for a set. For this learning activity, it
 * is to be implemented using a binary search tree.
 */
public interface SimpleSet<E> {
  
  /**
   * Add an element to the set. 
   * 
   * @param e The element to be added to the set
   * @return  <tt>true</tt> if this operation updated the contents of the set
   */
  public boolean add(E e);
  
  /**
   * Remove all elements from this set
   */
  public void clear();
  
  /**
   * Checks for the existance of the specified value within the set.
   * 
   * @param e The value sought
   * @return  <tt>true</tt> if the value exists in the set.
   */
  public boolean contains(E e);
  
  /**
   * Check for the existance of elements in the set
   * 
   * @return  <tt>true</tt> is there are no elements in the set
   */
  public boolean isEmpty();

  /**
   * Return the number of elements in the set
   * @return  the number of elements in the set.
   */
  public int size();
  
  /**
   * Returns a String representation of the contents of the set.
   * @return  the String representation of the set.
   */
  public String toString();
  
}