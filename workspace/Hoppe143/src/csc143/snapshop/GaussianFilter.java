package csc143.snapshop;

/**
 * This class implements the Gaussian filter by initializing its weights field
 * to values as follows:
 * 
 * [1 2 1]
 * [2 4 2]
 * [1 2 1]
 * 
 * @author Alexander Hoppe
 * @version Apr 26, 2015
 */
public class GaussianFilter extends ThreeByThreeFilter {
    
    //constructor
    /**
     * Initializes the weights field to the Gaussian filter pattern
     */
    public GaussianFilter() {
        weights = new int[] {1, 2, 1, 2, 4, 2, 1, 2, 1};
    }

}
