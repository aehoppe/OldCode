package csc143.snapshop;

/**
 * This class implements the Laplacian filter by initializing its weights field
 * to values as follows:
 * 
 * [-1 -1 -1]
 * [-1  8 -1]
 * [-1 -1 -1]
 * 
 * @author Alexander Hoppe
 * @version Apr 26, 2015
 */
public class LaplacianFilter extends ThreeByThreeFilter {
    
    //constructor
    /**
     * Initializes the weights field to the Laplacian filter pattern
     */
    public LaplacianFilter() {
        weights = new int[] {-1, -1, -1, -1, 8, -1, -1, -1, -1};
    }

}
