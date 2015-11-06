package csc143.snapshop;

/**
 * This class implements the Unsharp Masking filter by initializing its weights 
 * field to values as follows:
 * 
 * [-1 -2 -1]
 * [-2 28 -2]
 * [-1 -2 -1]
 * 
 * @author Alexander Hoppe
 * @version Apr 26, 2015
 */
public class UnsharpMaskingFilter extends ThreeByThreeFilter {
    
    //constructor
    /**
     * Initializes the weights field to the Unsharp Masking filter pattern
     */
    public UnsharpMaskingFilter() {
        weights = new int[] {-1, -2, -1, -2, 28, -2, -1, -2, -1};
    }

}
