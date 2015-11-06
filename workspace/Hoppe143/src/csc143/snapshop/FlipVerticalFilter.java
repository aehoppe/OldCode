package csc143.snapshop;

/**
 * Filter that flips the image vertically
 * @author Alexander Hoppe
 * @version Apr 26, 2015
 */
public class FlipVerticalFilter implements Filter{
    
    /**
     * Flip the image vertically (over the horizontal axis)
     * @param theImage The image to flip
     */
    public void filter(PixelImage theImage) {
        
        // get the image data
        Pixel[][] data = theImage.getData();
        
        //for each column, swap its contents from bottom to top
        for (int col = 0; col < theImage.getWidth(); col++) {
            for (int row = 0; row < theImage.getHeight() / 2; row++) {
                //for each column, the rows to be switched are paired according
                //to (row, height - row - 1), e.g. image height 10, row 0, resulting
                //swap is (0, 9), for row 1 it is (1, 8), stopping in the middle
                Pixel temp = data[row][col];
                data[row][col] = data[theImage.getHeight() - row - 1][col];
                data[theImage.getHeight() - row - 1][col] = temp;
            }
        }
        
        // update the image with the moved pixels
        theImage.setData(data);
        
    }
}