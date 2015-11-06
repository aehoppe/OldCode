package csc143.snapshop;

/**
 * This class implements the Edgy filter by initializing its weights field
 * to values as follows:
 * 
 * [-1 -1 -1]
 * [-1  9 -1]
 * [-1 -1 -1]
 * 
 * @author Alexander Hoppe
 * @version Apr 26, 2015
 */
public class EdgyFilter extends ThreeByThreeFilter {
    
    //constructor
    /**
     * Initializes the weights field to the Edgy filter pattern
     */
    public EdgyFilter() {
        weights = new int[] {-1, -1, -1, -1, 9, -1, -1, -1, -1};
    }

}
