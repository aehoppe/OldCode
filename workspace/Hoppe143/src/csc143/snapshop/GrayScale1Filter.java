package csc143.snapshop;

/**
 * This class implements a grayscale filter using percentage weights, 
 * setting all colors to the sum of 30% of the red value, 59% of the green value, 
 * and 11% of the blue value. 
 * @author Alexander Hoppe
 * @version Apr 26, 2015
 */
public class GrayScale1Filter implements Filter {

    /**
     * Takes each pixel and changes its color to a percent gray value
     * @param TheImage the PixelImage to be grayscaled
     */
    public void filter(PixelImage theImage) {
        
        //get image data
        Pixel[][] data = theImage.getData();
        
        //set up output to right size
        Pixel[][] output = new Pixel[theImage.getHeight()][theImage.getWidth()];
        
        //iterate through, set each pixel in output to gray value
        for (int row = 0; row < theImage.getHeight(); row++) {
            for (int col = 0; col < theImage.getWidth(); col++) {
                Pixel p = data[row][col];
                //calculate the gray value
                int gray = (int) (p.rgb[0] * 0.3 + p.rgb[1] * 0.59 + p.rgb[2] * 0.11);
                output[row][col] = new Pixel(gray, gray, gray);
            }
        }
        
        //set the image to the new data values
        theImage.setData(output);

    }

}
