package csc143.snapshop;

/**
 * This class implements the Rotate Clockwise filter for the SnapShop
 * @author Alexander Hoppe
 * @version Apr 26, 2015
 */
public class RotateClockwiseFilter implements Filter {

    /**
     * Rotates the image clockwise
     * @param theImage The image to be rotated clockwise
     */
    public void filter(PixelImage theImage) {
        //test for squareness
        if (theImage.getHeight() != theImage.getWidth()) 
            throw new IllegalArgumentException("Can't rotate non-square photos");
        
        //get image data
        Pixel[][] data = theImage.getData();
        
        //hold onto output data
        Pixel[][] output = new Pixel[theImage.getHeight()][theImage.getWidth()];
        
        //store dimensions for efficiency
        int height = theImage.getHeight();
        int width = theImage.getWidth();
        
        //iterate through and rotate image
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                output[0 + col][(width - 1) - row] = data[row][col];
            }
        }
        
        //set image to output array
        theImage.setData(output);
        
    }

}
