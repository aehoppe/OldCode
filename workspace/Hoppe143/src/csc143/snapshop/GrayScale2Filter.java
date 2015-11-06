package csc143.snapshop;

/**
 * This class implements a grayscale filter using integer division, 
 * setting all colors to the sum of 11/32 of the red value, 16/32 of the green value, 
 * and 5/32 of the blue value. 
 * @author Alexander Hoppe
 * @version Apr 26, 2015
 */
public class GrayScale2Filter implements Filter {

    /**
     * Takes each pixel and changes its color to a percent gray value
     * @param theImage the PixelImage to be grayscaled
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
                int gray = p.rgb[0] * 11/32  + p.rgb[1] * 16/32 + p.rgb[2] * 5/32;
                output[row][col] = new Pixel(gray, gray, gray);
            }
        }
        
        //set the image to the new data values
        theImage.setData(output);

    }

}
